package com.springboot.backed.apirest.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.springboot.backed.apirest.models.entity.UserRole;
import com.springboot.backed.apirest.models.service.interfaces.IUserService;

@SuppressWarnings("deprecation")
 @Component
public class InfoAditionalToken implements TokenEnhancer{

	@Autowired
	private IUserService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<>();
		UserRole user = userService.findByUsername(authentication.getName());
		
		info.put("aditional_info", "Hello client ".concat(authentication.getName()));
		info.put("Name", user.getName());
		info.put("Last_Name", user.getLastName());
		info.put("Email", user.getEmail());
	
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}
	
}
