package com.springboot.backed.apirest.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backed.apirest.models.entity.UserRole;

public interface IUserRoleRepository extends CrudRepository<UserRole, Long>{

	UserRole findByUsername(String username);
}
