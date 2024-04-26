package com.jsp.ShoppingCart.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.ShoppingCart.DTO.Product;
import com.jsp.ShoppingCart.REPOSITORY.ProductRepository;

@Repository
public class ProductDAO {
	
	@Autowired
	ProductRepository repository;
	
	//To insert Object
	public String addProduct(Product product) {
		repository.save(product);
		return "Product added to cart successfully";
	}
	
	//To fetch all object from database
	public List<Product> fetchAllProduct(){
		return repository.findAll();
	}
	
	//To find particular object based on id
	public Product findProductById(int id) {
		Optional<Product> opt =  repository.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			return null;
		}
	}
	
	//To delete product from cart based on id
	public String deleteProduct(int id) {
		Product p = findProductById(id);
		repository.delete(p);
		if(p != null) {
			return p.getProductName() + " Product is successfully find...!";
		}else {
			return "Product not found...!";
		}
	}
	
	//To update product quantity based on id
	public Product updateProduct(int id, int newQuantity) {
		Product p = findProductById(id);
		if(p != null) {
			p.setQuantity(newQuantity);
			repository.save(p);
			return p;
		}
		return null;
	}
}
