package com.foodiespot.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class CardDetails implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String userId ;
	private String cardNumber ;
	private String mM ;
	private String yY ;
	private String cV ;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getmM() {
		return mM;
	}
	public void setmM(String mM) {
		this.mM = mM;
	}
	public String getyY() {
		return yY;
	}
	public void setyY(String yY) {
		this.yY = yY;
	}
	public String getcV() {
		return cV;
	}
	public void setcV(String cV) {
		this.cV = cV;
	}
	
	

}
