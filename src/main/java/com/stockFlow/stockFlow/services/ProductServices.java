package com.stockFlow.stockFlow.services;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockFlow.stockFlow.entities.Product;
import com.stockFlow.stockFlow.entities.Supllier;
import com.stockFlow.stockFlow.repositories.ProductRepository;
import com.stockFlow.stockFlow.repositories.SupllierRepository;

@Service
public class ProductServices {
	@Autowired
	ProductRepository repository;
	@Autowired
	SupllierRepository suprepo;
	
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
	
	public void setSuplleir(Long idprod,Long idsup) {
		
	Product p =	findById(idprod);
		p.setSupllie(suprepo.findById(idsup).get());
			repository.save(p);
	}
	
	public String stockTotalValue() {
		List<Product> products = repository.findAll();
		double totalValue = 0.0;
		
		for(Product p : products) {
			
			totalValue += p.productTotalValue();
		}
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		return decimalFormat.format(totalValue);
		
	}
	
}
