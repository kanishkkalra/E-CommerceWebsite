package com.kanishk.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanishk.entity.Product;

@Service
public class ProductDAOImplementation {
	
	@Autowired
	private ProductDAO pdao;
	
	public Product saveProduct(Product product) {
		return pdao.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return pdao.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return pdao.findAll();
	}
	
	public Product getProductById(int id) {
		return pdao.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return pdao.findByName(name);
	}
	
	public String deleteProduct(int id) {
		pdao.deleteById(id);
		
		return "Product Removed Successfully || ID - "+id;
	}
	
	public Product updateProduct(Product product) {
		Product existingProduct = pdao.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setDiscount(product.getDiscount());
		existingProduct.setPrice(product.getPrice());
		return pdao.save(existingProduct);
	}

}
