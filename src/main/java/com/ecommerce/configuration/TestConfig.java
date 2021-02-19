package com.ecommerce.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.ecommerce.entidades.Category;
import com.ecommerce.entidades.Product;
import com.ecommerce.repositories.CategoryRepository;
import com.ecommerce.repositories.ProductRepository;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	private static Logger logger = LoggerFactory.getLogger(Product.class);
	
	@Override
	public void run(String... args) throws Exception {
		
		logger.info("Iniciado cadastro!");
		Category category = new Category(null, "Roupa de Cama");
		categoryRepository.save(category);
		Product product = null;
		
		for(int i=0; i < 220; i++) {
			if(i % 2 == 0) {
				product = new Product(null, "Kit de cama 210 fios", "Classic I - Solteiro Extra", 98.9,80.7,
						"../assets/images1.jpg","../assets/images2.jpg", "../assets/images3.jpg");
			} else {
				product = new Product(null, "Kit de cama 420 fios", "Classic II - Casal Extra", 200.20, 180.2,
						"../assets/images3.jpg","../assets/images2.jpg", "../assets/images1.jpg");
			}
			
			
			productRepository.save(product);
			
			product.getCategories().add(category);
			
			productRepository.save(product);
		}
		
		logger.info("Finalizado com sucesso!");
	}

}
