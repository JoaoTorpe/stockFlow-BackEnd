package com.stockFlow.stockFlow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockFlow.stockFlow.DTOs.ProductDTO;
import com.stockFlow.stockFlow.entities.Product;
import com.stockFlow.stockFlow.entities.Supllier;
import com.stockFlow.stockFlow.services.SupplierService;

@RestController
@RequestMapping("/suplliers")
public class SupllierController {
	@Autowired
	SupplierService service;
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public ResponseEntity<List<Supllier>> findAll(){
		List<Supllier> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/{id}")
	public Supllier findByid(@PathVariable Long id) {
		return service.findById(id);
	}
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void addSupllier(@RequestBody Supllier supllier) {
		service.addSupllier(supllier);
	}
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value="/products/{id}")
	public ResponseEntity<List<ProductDTO>> addSupllier(@PathVariable Long id) {
		return  ResponseEntity.ok().body(service.getProduts(id));
	}
	
	
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping(value="/{id}")
	public void remove(@PathVariable Long id) {
		
		service.remove(id);
	}
	 
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
		@PutMapping(value="/{id}")
	 public void updateSpullier(@PathVariable Long id , @RequestBody Supllier newSupllier ) {
		 
		service.updateSupplier(id, newSupllier);
		 
	 }
	
	
	
}
