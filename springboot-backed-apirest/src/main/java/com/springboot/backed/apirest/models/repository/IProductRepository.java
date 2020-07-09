package com.springboot.backed.apirest.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.backed.apirest.models.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Long>{
	
	@Query("select p from Product p where p.name like %?1%")
	List<Product> findByName(String term);
	
	List<Product> findByNameContainingIgnoreCase(String term);
	
	List<Product> findByNameStartingWithIgnoreCase(String term);
}
