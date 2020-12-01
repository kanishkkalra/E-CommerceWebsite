package com.kanishk.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanishk.entity.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {
	
	Product findByName(String name);

}
