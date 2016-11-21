package com.foodiespot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodiespot.dao.CartDao;
import com.foodiespot.dao.OrderDao;
import com.foodiespot.model.BillingAddress;
import com.foodiespot.model.Cart;
import com.foodiespot.model.Order;
import com.foodiespot.model.ShippingAddress;

public class OrderWebflow {
	@Autowired 
	Order order ;
	
	@Autowired
	HttpSession httpSession ;
	
	@Autowired
	Cart cart ;
	
	@Autowired
	CartDao cartDao ;
	
	@Autowired
	ShippingAddress shippingAddress ;
	
	@Autowired
	BillingAddress billingAddress ;
	
	@Autowired
	OrderDao orderDao ;
	
	public Order initFlow(){
		Order order = new Order();
		String userId = (String) httpSession.getAttribute("user");
		List cartList = (List<Cart>) cartDao.listCart(userId);
		order.setUserId(userId);
		order.setCartList(cartList);
		order.setTotalRs(cartDao.getTotalRs(userId));
		return order ;
	}
	
	public String addShippingAddress(Order order, ShippingAddress shippingAddress) {
		String loggedInUserId = (String) httpSession.getAttribute("user");
		this.shippingAddress.setUserId(loggedInUserId);
		return "positive";
	}
	

	public String addBillingAddress(Order order, BillingAddress billingAddress) {
		String loggedInUserId = (String) httpSession.getAttribute("user");
		this.billingAddress.setUserId(loggedInUserId);
		return "positive";
	}
	
	public String confirmOrder(Order order) {
		try {
			orderDao.saveorupdate(order);
		} catch (Exception e) {
			
			e.printStackTrace();
			return "negative" ;
		}
		return "positive";
	}

	/*public String addPayMethod(Order order, String payMethod) {
		order.setPayMethod(payMethod);
		return "positive";
	}
*/
}
