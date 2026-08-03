package com.gcu.cloudtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gcu.cloudtest.model.Product;
import com.gcu.cloudtest.repository.ProductRepo;

@Service
public class ProductService {

    private final ProductRepo productRepository;

    public ProductService(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}