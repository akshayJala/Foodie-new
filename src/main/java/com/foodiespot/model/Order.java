package com.foodiespot.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;
/*@Entity
@Table*/
@Component
public class Order implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private String userId ;
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int orderId ;
	private Double totalRs ;
	/*private String payMethod ;*/
	private ShippingAddress shippingAddress ;
	private BillingAddress billingAddress ;
	private List<Cart> cartList ;
	private CardDetails cardDetails ;
	
	
	public CardDetails getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Double getTotalRs() {
		return totalRs;
	}
	public void setTotalRs(Double totalRs) {
		this.totalRs = totalRs;
	}
	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public List<Cart> getCartList() {
		return cartList;
	}
	public void setCartList(List<Cart> cartList) {
		this.cartList = cartList;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	

	
	

}
