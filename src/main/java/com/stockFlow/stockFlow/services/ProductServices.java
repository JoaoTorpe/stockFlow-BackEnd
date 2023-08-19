package com.stockFlow.stockFlow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockFlow.stockFlow.entities.Product;
import com.stockFlow.stockFlow.repositories.ProductRepository;

@Service
public class ProductServices {
	@Autowired
	ProductRepository repository;
	
	public void addProduct(Product product){
		repository.save(product);
	}
	
	public Product findById(Long id) {
		Optional<Product> product = repository.findById(id);
		return product.get();
	}
	
	public List<Product> findAll(){
		List<Product> products = repository.findAll();
		return products;
	}
	
	public void remove(Long id) {
		repository.deleteById(id);
	}
	
}
