package com.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;

import com.ecommerce.entidades.Product;
import com.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@SuppressWarnings("deprecation")
	public Page<Product> findPaginator(String page, String limit) {
		return productRepository.findAll(new QPageRequest(Integer.parseInt(page), Integer.parseInt(limit)));
	}
	
	public Page<Product> findPaginatorByName(String name, String page, String limit){
		return productRepository.searchByName(name, new QPageRequest(Integer.parseInt(page), Integer.parseInt(limit)));
	}

}
