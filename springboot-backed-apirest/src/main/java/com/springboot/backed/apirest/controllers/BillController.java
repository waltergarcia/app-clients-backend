package com.springboot.backed.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backed.apirest.models.entity.Bill;
import com.springboot.backed.apirest.models.entity.Product;
import com.springboot.backed.apirest.models.service.interfaces.IClientService;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api/bill")
public class BillController {

	//ROLES
	private static final String ADMIN 	= "ROLE_ADMIN";
	private static final String USER 	= "ROLE_USER";
	
	@Autowired
	private IClientService clientService;
	
	@Secured({ADMIN, USER})
	@GetMapping("/findById/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Bill findById(@PathVariable Long id){
		return clientService.findBillById(id);
	}
	
	@Secured({ADMIN})
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Bill save(@RequestBody Bill bill){
		return clientService.saveBill(bill);
	}
	
	@Secured({ADMIN})
	@DeleteMapping("/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		clientService.deleteBill(id);
	}
	
	@Secured({ADMIN})
	@GetMapping("/filter/products/{term}")
	@ResponseStatus(HttpStatus.OK)
	public List<Product> filterProducts(@PathVariable String term){
		return clientService.findProductByName(term);
	}
	
}
