package com.foodiespot.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "PRODUCT")
@Component
public class Product {
	@Id 
	private int productId;
	private String productName;
	private String description;
	private int quantity;
	private float price;
	
	@Transient
	private MultipartFile image ;
	
	
	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="categoryId" ,nullable= false )//,insertable=true ,updatable=false)
	private Category category ;
	
	
	@ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
	@JoinColumn(name="supplierId" ,nullable= false)//,insertable=true ,updatable=false)
	private Supplier supplier ;
	

	public Supplier getSupplier() {
		return supplier;
	}


	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	
	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		if (price <= 0) {
			System.out.println("Minimum Price should be 10");
			price = 0;

		}
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public MultipartFile getImage() {
		return image;
	}


	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
}
