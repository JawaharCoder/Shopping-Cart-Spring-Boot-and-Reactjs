package com.shoppingcart.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
        private String imagelink;
        private String product_name;
        private String product_description;
        private String updated;
	
	public Product() {
		
	}

        public Product(long id, String imagelink, String product_name, String product_description, String updated) {
            this.id = id;
            this.imagelink = imagelink;
            this.product_name = product_name;
            this.product_description = product_description;
            this.updated = updated;
        }
        
        public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
        
        public String getImagelink() {
            return imagelink;
        }

        public void setImagelink(String imagelink) {
            this.imagelink = imagelink;
        }

        public String getProduct_name() {
            return product_name;
        }

        public void setProduct_name(String product_name) {
            this.product_name = product_name;
        }

        public String getProduct_description() {
            return product_description;
        }

        public void setProduct_description(String product_description) {
            this.product_description = product_description;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }
        
        
	
}
