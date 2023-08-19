package com.stockFlow.stockFlow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockFlow.stockFlow.entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
