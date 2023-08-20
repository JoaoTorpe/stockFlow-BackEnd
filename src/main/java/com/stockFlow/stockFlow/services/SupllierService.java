package com.stockFlow.stockFlow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockFlow.stockFlow.entities.Supllier;
import com.stockFlow.stockFlow.repositories.SupllierRepository;
@Service
public class SupllierService {
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
		
		
		
}
