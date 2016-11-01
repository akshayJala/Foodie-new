package com.foodiespot.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class BillingAddress implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private int billingAddressId ;
	private String userId ;
	private String fullName ;
	private String addressLine ;
	private String city_Town ;
	private String state_Province_RegionNumber ;
	private String zip_PostalCode ;
	private String country ;
	
	public int getBillingAddressId() {
		return billingAddressId;
	}
	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity_Town() {
		return city_Town;
	}
	public void setCity_Town(String city_Town) {
		this.city_Town = city_Town;
	}
	public String getState_Province_RegionNumber() {
		return state_Province_RegionNumber;
	}
	public void setState_Province_RegionNumber(String state_Province_RegionNumber) {
		this.state_Province_RegionNumber = state_Province_RegionNumber;
	}
	public String getZip_PostalCode() {
		return zip_PostalCode;
	}
	public void setZip_PostalCode(String zip_PostalCode) {
		this.zip_PostalCode = zip_PostalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
