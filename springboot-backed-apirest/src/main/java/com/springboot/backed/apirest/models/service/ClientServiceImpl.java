package com.springboot.backed.apirest.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backed.apirest.models.entity.Bill;
import com.springboot.backed.apirest.models.entity.Client;
import com.springboot.backed.apirest.models.entity.Product;
import com.springboot.backed.apirest.models.entity.Region;
import com.springboot.backed.apirest.models.repository.IBillRepository;
import com.springboot.backed.apirest.models.repository.IClientRepository;
import com.springboot.backed.apirest.models.repository.IProductRepository;
import com.springboot.backed.apirest.models.service.interfaces.IClientService;

@Service
public class ClientServiceImpl implements IClientService{

	@Autowired
	private IClientRepository clientRepository;
	
	@Autowired
	private IBillRepository billRepository;
	
	@Autowired
	private IProductRepository productRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		return (List<Client>) clientRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Client> findAll(Pageable pageable) {
		return clientRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Client findById(Long id) {
		return clientRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clientRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Region> findAllRegions() {
		return clientRepository.findAllRegions();
	}

	@Override
	@Transactional(readOnly = true)
	public Bill findBillById(Long id) {
		return billRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Bill saveBill(Bill bill) {	
		return billRepository.save(bill);
	}

	@Override
	@Transactional
	public void deleteBill(Long id) {
		billRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Product> findProductByName(String term) {
		return productRepository.findByNameContainingIgnoreCase(term);
	}	
}