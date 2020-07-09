package com.springboot.backed.apirest.models.service.interfaces;

import com.springboot.backed.apirest.models.entity.UserRole;

public interface IUserService {
	UserRole findByUsername(String username);
}
