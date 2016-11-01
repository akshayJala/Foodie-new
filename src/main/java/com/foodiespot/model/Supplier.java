package com.foodiespot.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="SUPPLIER")
@Component
public class Supplier {
	@Id
	private int supplierId ;
	private String supplierName ;
	private String supplierAddress ;
	
	@OneToMany(mappedBy="supplier" , fetch=FetchType.EAGER,orphanRemoval=true)
	private Set<Product> products ;
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProduct(Set<Product> products) {
		this.products = products;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	
	@Override
	public String toString() {	
		return supplierName ;
	}
	

}
