package com.kanishk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kanishk.dao.ProductDAOImplementation;
import com.kanishk.entity.Product;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {
	
	@Autowired
	private ProductDAOImplementation productImpl;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return productImpl.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products) {
		return productImpl.saveProducts(products);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")	
	@GetMapping("/products")
	public List<Product> findAllProducts() {
		return productImpl.getProducts();
	}

	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id) {
		return productImpl.getProductById(id);
	}
	
	@GetMapping("/productByName/{name}")
	public Product findProductByName(@PathVariable String name) {
		return productImpl.getProductByName(name);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productImpl.updateProduct(product);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.DELETE)
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
		productImpl.deleteProduct(id);
	 return new ResponseEntity<>(HttpStatus.OK);
	}

}
