package com.gcu.cloudtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gcu.cloudtest.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
}