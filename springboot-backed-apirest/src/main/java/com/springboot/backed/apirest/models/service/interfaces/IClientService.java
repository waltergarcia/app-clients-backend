package com.springboot.backed.apirest.models.service.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springboot.backed.apirest.models.entity.Bill;
import com.springboot.backed.apirest.models.entity.Client;
import com.springboot.backed.apirest.models.entity.Product;
import com.springboot.backed.apirest.models.entity.Region;

public interface IClientService {
	List<Client> findAll();
	Page<Client> findAll(Pageable pageable);
	Client findById(Long id);
	Client save(Client client);
	void delete(Long id);
	List<Region> findAllRegions();
	
	Bill findBillById(Long id);
	Bill saveBill(Bill bill);
	void deleteBill(Long id);
	
	List<Product> findProductByName(String term);
}
