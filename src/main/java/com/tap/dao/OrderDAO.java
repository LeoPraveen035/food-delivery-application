package com.tap.dao;

import java.util.List;

import com.tap.model.Order;

public interface OrderDAO {
	
	int addOrder(Order order);
	
	void deleteOrder(int orderId);
	
	void updateOrder(Order order);
	
	Order getOrder(int orderId);
	
	List<Order> getOrderByRestaurantId(int restId);
	
	List<Order> getOrderByUserId(int userId);
	
	
	
}
	

