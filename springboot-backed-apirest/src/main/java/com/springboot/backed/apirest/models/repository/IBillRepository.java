package com.springboot.backed.apirest.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backed.apirest.models.entity.Bill;

public interface IBillRepository extends CrudRepository<Bill, Long>{

}
