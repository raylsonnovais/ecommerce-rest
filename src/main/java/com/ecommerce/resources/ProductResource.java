package com.ecommerce.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entidades.Product;
import com.ecommerce.services.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	ProductService service;
	
	@GetMapping
	@RequestMapping(value = "paginator")
	public ResponseEntity<Page<Product>> findPaginator(HttpServletRequest request){
		Page<Product> page = service.findPaginator(request.getParameter("page"), request.getParameter("limit"));
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping
	@RequestMapping(value = "paginatorByName")
	public ResponseEntity<Page<Product>> findPaginatorByName(HttpServletRequest request){
		Page<Product> page = service.findPaginatorByName(request.getParameter("name"),request.getParameter("page"), request.getParameter("limit"));
		return ResponseEntity.ok().body(page);
	}

}
