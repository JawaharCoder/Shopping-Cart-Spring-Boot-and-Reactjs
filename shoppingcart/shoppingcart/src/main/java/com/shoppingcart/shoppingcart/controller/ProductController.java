/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shoppingcart.shoppingcart.controller;

import com.shoppingcart.shoppingcart.exception.ResourceNotFoundException;
import com.shoppingcart.shoppingcart.model.Product;
import com.shoppingcart.shoppingcart.repository.ProductRepository;


/**
 *
 * @author jawah
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.shoppingcart.model.Product;
import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")
public class ProductController {
    
        ArrayList<Product> productsList = new ArrayList();
        ArrayList<Product> productsItem = new ArrayList();
        
        ProductController(){
                this.productsList.add(new Product(1, "/images/image1.png", "APPLE iPhone 13 (Midnight, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity. ", "Last updated 3 mins ago"));
                this.productsList.add(new Product(2, "/images/image2.png", "APPLE iPhone 13 (Green, 256 GB)", "The iPhone 13 features a stylish design and innovative features that make it a delight to use.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(3, "/images/image3.png", "APPLE iPhone 13 ((PRODUCT)RED, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(4, "/images/image4.png", "APPLE iPhone 13 (Blue, 512 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(5, "/images/image5.png", "APPLE iPhone 13 (Midnight, 512 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(6, "/images/image6.png", "APPLE iPhone 13 (Midnight, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(7, "/images/image7.png", "APPLE iPhone 13 (Pink, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity. ", "Last updated 3 mins ago"));
                this.productsList.add(new Product(8, "/images/image8.png", "APPLE iPhone 13 (Starlight, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(9, "/images/image9.png", "APPLE iPhone 13 (Blue, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(10, "/images/image10.png", "APPLE iPhone 13 (Starlight, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(11, "/images/image11.png", "APPLE iPhone 13 (Green, 128 GB)", "The iPhone 13 features a stylish design and innovative features that make it a delight to use.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(12, "/images/image12.png", "APPLE iPhone 13 (Pink, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(13, "/images/image1.png", "APPLE iPhone 13 (Midnight, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity. ", "Last updated 3 mins ago"));
                this.productsList.add(new Product(14, "/images/image2.png", "APPLE iPhone 13 (Green, 256 GB)", "The iPhone 13 features a stylish design and innovative features that make it a delight to use.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(15, "/images/image3.png", "APPLE iPhone 13 ((PRODUCT)RED, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(16, "/images/image4.png", "APPLE iPhone 13 (Blue, 512 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(17, "/images/image5.png", "APPLE iPhone 13 (Midnight, 512 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(18, "/images/image6.png", "APPLE iPhone 13 (Midnight, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(19, "/images/image7.png", "APPLE iPhone 13 (Pink, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity. ", "Last updated 3 mins ago"));
                this.productsList.add(new Product(20, "/images/image8.png", "APPLE iPhone 13 (Starlight, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(21, "/images/image9.png", "APPLE iPhone 13 (Blue, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(22, "/images/image10.png", "APPLE iPhone 13 (Starlight, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(23, "/images/image11.png", "APPLE iPhone 13 (Green, 128 GB)", "The iPhone 13 features a stylish design and innovative features that make it a delight to use.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(24, "/images/image12.png", "APPLE iPhone 13 (Pink, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(25, "/images/image1.png", "APPLE iPhone 13 (Midnight, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity. ", "Last updated 3 mins ago"));
                this.productsList.add(new Product(26, "/images/image2.png", "APPLE iPhone 13 (Green, 256 GB)", "The iPhone 13 features a stylish design and innovative features that make it a delight to use.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(27, "/images/image3.png", "APPLE iPhone 13 ((PRODUCT)RED, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(28, "/images/image4.png", "APPLE iPhone 13 (Blue, 512 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(29, "/images/image5.png", "APPLE iPhone 13 (Midnight, 512 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(30, "/images/image6.png", "APPLE iPhone 13 (Midnight, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(31, "/images/image7.png", "APPLE iPhone 13 (Pink, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity. ", "Last updated 3 mins ago"));
                this.productsList.add(new Product(32, "/images/image8.png", "APPLE iPhone 13 (Starlight, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(33, "/images/image9.png", "APPLE iPhone 13 (Blue, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(34, "/images/image10.png", "APPLE iPhone 13 (Starlight, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(35, "/images/image11.png", "APPLE iPhone 13 (Green, 128 GB)", "The iPhone 13 features a stylish design and innovative features that make it a delight to use.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(36, "/images/image12.png", "APPLE iPhone 13 (Pink, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(37, "/images/image1.png", "APPLE iPhone 13 (Midnight, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity. ", "Last updated 3 mins ago"));
                this.productsList.add(new Product(38, "/images/image2.png", "APPLE iPhone 13 (Green, 256 GB)", "The iPhone 13 features a stylish design and innovative features that make it a delight to use.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(39, "/images/image3.png", "APPLE iPhone 13 ((PRODUCT)RED, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(40, "/images/image4.png", "APPLE iPhone 13 (Blue, 512 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(41, "/images/image5.png", "APPLE iPhone 13 (Midnight, 512 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(42, "/images/image6.png", "APPLE iPhone 13 (Midnight, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(43, "/images/image7.png", "APPLE iPhone 13 (Pink, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity. ", "Last updated 3 mins ago"));
                this.productsList.add(new Product(44, "/images/image8.png", "APPLE iPhone 13 (Starlight, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(45, "/images/image9.png", "APPLE iPhone 13 (Blue, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(46, "/images/image10.png", "APPLE iPhone 13 (Starlight, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(47, "/images/image11.png", "APPLE iPhone 13 (Green, 128 GB)", "The iPhone 13 features a stylish design and innovative features that make it a delight to use.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(48, "/images/image12.png", "APPLE iPhone 13 (Pink, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(49, "/images/image8.png", "APPLE iPhone 13 (Starlight, 256 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                this.productsList.add(new Product(50, "/images/image9.png", "APPLE iPhone 13 (Blue, 128 GB)", "iPhone 13. boasts an advanced dual-camera system that allows you to click mesmerising pictures with immaculate clarity.", "Last updated 3 mins ago"));
                
        }

        @RequestMapping("/")
        public String home(){
            return "Home";
        }

        @GetMapping("/products")
        public ResponseEntity<ArrayList<Product>> getAllProducts(){
                return ResponseEntity.ok(this.productsList);
	}
        
        @PostMapping("/items")
	public ResponseEntity<ArrayList<Product>> addItem(@RequestBody Product product) {
		productsItem.add(product);
                return ResponseEntity.ok(this.productsItem);
	}
        
        
        @DeleteMapping("/items/{id}")
	public ResponseEntity<ArrayList<Product>> removeItem(@PathVariable Long id){
		this.productsItem.remove(0);
		return ResponseEntity.ok(this.productsItem);
	}
        
        @GetMapping("/items")
	public ResponseEntity<ArrayList<Product>> getAllItems() {
		return ResponseEntity.ok(this.productsItem);
	}
}
