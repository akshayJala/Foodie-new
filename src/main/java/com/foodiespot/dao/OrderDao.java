package com.foodiespot.dao;

import java.util.List;

import com.foodiespot.model.Order;

public interface OrderDao {
	public List<Order> orderListofUser(String userId) ;
	public void saveorupdate(Order order) ;
	public void update(Order order) ;
	/*public String delete(int orderId);*/
	public Order get(String userId);
	public Long getTotalRs(String userId);
}
