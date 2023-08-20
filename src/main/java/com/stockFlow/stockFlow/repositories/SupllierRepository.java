package com.stockFlow.stockFlow.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockFlow.stockFlow.entities.Supllier;
@Repository
public interface SupllierRepository extends JpaRepository<Supllier,Long> {

}
