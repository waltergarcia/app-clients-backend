package com.springboot.backed.apirest.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.backed.apirest.models.entity.Client;
import com.springboot.backed.apirest.models.entity.Region;

public interface IClientRepository extends JpaRepository<Client, Long>{

	@Query("from Region")
	List<Region> findAllRegions();
}
