package com.springboot.backed.apirest.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.backed.apirest.models.entity.Client;
import com.springboot.backed.apirest.models.entity.Region;
import com.springboot.backed.apirest.models.service.interfaces.IClientService;
import com.springboot.backed.apirest.models.service.interfaces.IUploadFileService;

@CrossOrigin(origins = {"http://localhost:4200", "*"})
@RestController
@RequestMapping("/api/client")
public class ClientController {
	
	//ROLES
	private static final String ADMIN 	= "ROLE_ADMIN";
	private static final String USER 	= "ROLE_USER";
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IUploadFileService uploadService;

	@GetMapping("/findAll")
	public List<Client> findAll(){
		return clientService.findAll();
	}
	
	@Secured(ADMIN)
	@GetMapping("/findAll/regions")
	public List<Region> findAllRegions(){
		return clientService.findAllRegions();
	}
	
	@GetMapping("/findAll/page/{page}")
	public Page<Client> findAll(@PathVariable Integer page){
		Pageable pageable = PageRequest.of(page, 4);
		return clientService.findAll(pageable);
	}
	
	@Secured({ADMIN, USER})
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Client client;
		
		try {
			client = clientService.findById(id);
		}catch(DataAccessException e) {
			response.put("message", "Error getting client");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(client == null) {
			response.put("message", "Client Id '".concat(id.toString().concat("' doesn't exists in the BD!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@Secured(ADMIN)
	@PostMapping("/save")
	public ResponseEntity<?> save (@Valid @RequestBody Client client, BindingResult result) {
		Map<String, Object> response = new HashMap<>();
		Client newClient;
		
		if(result.hasErrors()) {		
			List<String> errors = result.getFieldErrors()
									.stream()
									.map(error -> "Field '" + error.getField() + "' " + error.getDefaultMessage())
									.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			newClient = clientService.save(client);
		}catch(DataAccessException e) {
			response.put("message", "Error saving client");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
			
		response.put("message", "Client saved successful");
		response.put("client", newClient);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured(ADMIN)
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Client client, BindingResult result, @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Client clientUpdated;
		Client clientFound = clientService.findById(id);
		
		if(result.hasErrors()) {			
			List<String> errors = result.getFieldErrors()
									.stream()
									.map(error -> "Field '" + error.getField() + "' " + error.getDefaultMessage())
									.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if(clientFound == null) {
			response.put("message", "Error! Cannot update, client Id '".concat(id.toString().concat("' doesn't exists in the BD!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			clientFound.setName(client.getName());
			clientFound.setLastName(client.getLastName());
			clientFound.setEmail(client.getEmail());
			clientFound.setCreateAt(client.getCreateAt());
			clientFound.setRegion(client.getRegion());
			
			clientUpdated = clientService.save(clientFound);
		}catch(DataAccessException e) {
			response.put("message", "Error updating client");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "Client updated successful");
		response.put("client", clientUpdated);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@Secured(ADMIN)
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		Client client = clientService.findById(id);
		
		try {
			uploadService.delete(client.getImage());
			clientService.delete(id);
		}catch(DataAccessException e) {
			response.put("message", "Error deleting client");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "Client deleted successful");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	@Secured({ADMIN, USER})
	@PostMapping("/image/upload")
	public ResponseEntity<?> uploadUserImage(@RequestParam("imageFile") MultipartFile imageFile, 
												@RequestParam("id") Long id){
		Map<String, Object> response = new HashMap<>();
		Client client = clientService.findById(id);
		
		if(!imageFile.isEmpty()) {
			String nameFile;
			
			try {
				nameFile = uploadService.copy(imageFile);
			}catch(IOException e) {
				response.put("message", "Error uploading client photo");
				response.put("error", e.getMessage().concat(" : ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}

			String oldPhoto = client.getImage();
			
			uploadService.delete(oldPhoto);
			
			client.setImage(nameFile);
			clientService.save(client);
			
			response.put("client", client);
			response.put("message", "Image upload successful: " + nameFile);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/image/show/{namePhoto:.+}")
	public ResponseEntity<Resource> showClientImage(@PathVariable String namePhoto){
		Resource resource = null;
		HttpHeaders headers = new HttpHeaders();
		
		try {
			resource = uploadService.load(namePhoto);
		}catch(MalformedURLException e) {
			
		}
		
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"");
		
		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
}
