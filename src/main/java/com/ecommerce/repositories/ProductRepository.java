package com.ecommerce.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.entidades.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	Page<Product> findAll(Pageable pageable);
	Page<Product> findByName(String name, Pageable pageable);
	
	@Query("From Product p WHERE LOWER(p.name) like %:searchTerm%")
	Page<Product> searchByName(@Param("searchTerm") String searchTerm, Pageable pageable);
	
}
