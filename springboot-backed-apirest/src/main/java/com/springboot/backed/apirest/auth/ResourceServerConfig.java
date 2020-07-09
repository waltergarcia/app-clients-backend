package com.springboot.backed.apirest.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	//ROLES
	//private static final String ADMIN 				= "ADMIN";
	//private static final String USER 					= "USER";
	
	//URLS
	private static final String BASE_PATH 		= "/api/client";
	//private static final String BASE_PATH_BILLS	= "/api/bill";
	private static final String FIND_ALL 		= BASE_PATH.concat("/findAll");
	private static final String FIND_ALL_PAGE	= BASE_PATH.concat("/findAll/page/**");
	//private static final String FIND_BY_ID 		= BASE_PATH.concat("/findById/{id}");
	//private static final String SAVE 			= BASE_PATH.concat("/save");
	/*private static final String UPDATE 			= BASE_PATH.concat("/update/{id}");
	private static final String DELETE 			= BASE_PATH.concat("/delete/{id}");*/
	//private static final String IMAGE_UPLOAD 	= BASE_PATH.concat("/image/upload");
	private static final String IMAGE_SHOW 		= BASE_PATH.concat("/image/show/**");
	//private static final String REGIONS 		= BASE_PATH.concat("/findAll/regions");
	private static final String NO_IMAGE 		= "/images/**";
	//private static final String BILLS 			= BASE_PATH_BILLS.concat("/findAll");
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, FIND_ALL, FIND_ALL_PAGE, IMAGE_SHOW, NO_IMAGE).permitAll()
			/*.antMatchers(FIND_BY_ID).permitAll()
			.antMatchers(BASE_PATH_BILLS.concat("/**")).permitAll()
			.antMatchers(HttpMethod.GET, FIND_BY_ID).hasAnyRole(USER, ADMIN)
			.antMatchers(HttpMethod.POST, SAVE).hasRole(ADMIN)
			.antMatchers(HttpMethod.POST, IMAGE_UPLOAD).hasAnyRole(USER, ADMIN)
			.antMatchers(BASE_PATH.concat("/**")).hasRole(ADMIN)*/
			.anyRequest().authenticated()
			.and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
				
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "*"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		
		source.registerCorsConfiguration("/**", config);
		
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		return bean;
	}
}