package com.springboot.backed.apirest.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backed.apirest.models.entity.UserRole;
import com.springboot.backed.apirest.models.repository.IUserRoleRepository;
import com.springboot.backed.apirest.models.service.interfaces.IUserService;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Service
public class UserRoleService implements UserDetailsService, IUserService{

	private Logger logger = LoggerFactory.getLogger(UserRoleService.class);
	
	@Autowired
	private IUserRoleRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserRole userRole = userRepository.findByUsername(username);
		
		if(userRole == null) {
			String msg = "user doesn't exists: " + username;
			logger.error(msg);
			throw new UsernameNotFoundException(msg);
		}
		
		List<GrantedAuthority> authorities = userRole.getRoles()
												.stream()
												.map(role -> new SimpleGrantedAuthority(role.getName()))
												.peek(authority -> logger.info("Role: " + authority.getAuthority()))
												.collect(Collectors.toList());
		
		return new User(userRole.getUsername(), userRole.getPassword(),  userRole.getEnabled(), 
						true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public UserRole findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
