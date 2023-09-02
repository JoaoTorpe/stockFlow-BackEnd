package com.stockFlow.stockFlow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockFlow.stockFlow.DTOs.ProductDTO;
import com.stockFlow.stockFlow.entities.Product;
import com.stockFlow.stockFlow.entities.Supllier;
import com.stockFlow.stockFlow.repositories.SupllierRepository;
@Service
public class SupplierService {
		@Autowired
		SupllierRepository repository;
	
		public void addSupllier(Supllier supllier) {
			
			repository.save(supllier);
			
		}
		
		
		public List<Supllier> findAll(){
			
			return repository.findAll();
		}
		
		public Supllier findById(Long id) {
			
			Optional<Supllier> sup = repository.findById(id);
			return sup.get();
		}
		
		public void remove(Long id) {
			repository.deleteById(id);
		}
		
		public List<ProductDTO> getProduts(Long id){
			List<Product> listProd= findById(id).getProducts();
			List<ProductDTO> listDTO = new ArrayList<>();
			
			for(Product p : listProd) {
				
				ProductDTO pDTO = new ProductDTO();
				pDTO.setId(p.getId());
				pDTO.setName(p.getName());
				
				listDTO.add(pDTO);
			}
			
			return listDTO;
			
				
		}
		
		public void updateSupplier(Long id , Supllier newSupllier) {
			Supllier courrentSup = findById(id);
			
			courrentSup.setName(newSupllier.getName());
			courrentSup.setEmail(newSupllier.getEmail());
			courrentSup.setPhone(newSupllier.getPhone());
			repository.save(courrentSup);
		}
		
		
		
		
}
