package com.ecommerce;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Add some initial products
        productRepository.save(new Product("Product 1", 10.0, "https://via.placeholder.com/150"));
        productRepository.save(new Product("Product 2", 20.0, "https://via.placeholder.com/150"));
        productRepository.save(new Product("Product 3", 30.0, "https://via.placeholder.com/150"));
    }

}
