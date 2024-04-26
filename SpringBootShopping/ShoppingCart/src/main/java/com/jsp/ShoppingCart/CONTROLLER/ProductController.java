package com.jsp.ShoppingCart.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.ShoppingCart.DAO.ProductDAO;
import com.jsp.ShoppingCart.DTO.Product;

@RestController
public class ProductController {

	@Autowired
	ProductDAO dao;
	
	@PostMapping("/product")
	public String saveProduct(@RequestBody Product product) {
		 String message = dao.addProduct(product);
		 return message;
	}
	
	@GetMapping("/product")
	public List<Product> fetchAllProduct(){
		return dao.fetchAllProduct();
	}
	
	@GetMapping("/findProductById")
	public Product findProductById(@RequestParam int id) {
		return dao.findProductById(id);
	}
	
	@DeleteMapping("/deleteProduct")
	public String deleteProduct(@RequestParam int id) {
		return dao.deleteProduct(id);
	}
	
	@PutMapping("/updateProduct")
	public Product updateQuan(@RequestParam int id, @RequestParam int newQuantity) {
		
		return dao.updateProduct(id, newQuantity);
	}
}
