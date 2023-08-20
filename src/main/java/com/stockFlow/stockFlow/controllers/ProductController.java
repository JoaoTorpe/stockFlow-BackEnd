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
import com.stockFlow.stockFlow.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductServices service;
	@PostMapping
	public void addProduct(@RequestBody Product product) {
		service.addProduct(product);
	}
	
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping(value = "/total")
	public ResponseEntity<String> totalValue() {
		
		return ResponseEntity.ok().body(service.stockTotalValue());
	}
	
	@PostMapping(value="/{idprod}/{idsup}")
	public void setSupllier(@PathVariable Long idprod,@PathVariable Long idsup) {
		
		service.setSuplleir(idprod,idsup);
		
	}
	
	@DeleteMapping(value="/{id}")
	public void remove(@PathVariable Long id){
		service.remove(id);	
	}
	
	
	
	
	
}
