package com.stockFlow.stockFlow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockFlow.stockFlow.entities.Product;
import com.stockFlow.stockFlow.entities.Supllier;
import com.stockFlow.stockFlow.services.SupllierService;

@RestController
@RequestMapping("/suplliers")
public class SupllierController {
	@Autowired
	SupllierService service;
	
	@GetMapping
	public ResponseEntity<List<Supllier>> findAll(){
		List<Supllier> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public Supllier findByid(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public void addSupllier(@RequestBody Supllier supllier) {
		service.addSupllier(supllier);
	}
	
	@GetMapping(value="/products/{id}")
	public ResponseEntity<List<Product>> addSupllier(@PathVariable Long id) {
		return  ResponseEntity.ok().body(service.getProduts(id));
	}
	
	
	
	@DeleteMapping(value="/{id}")
	public void remove(@PathVariable Long id) {
		
		service.remove(id);
		
	}
	
	
	
}
