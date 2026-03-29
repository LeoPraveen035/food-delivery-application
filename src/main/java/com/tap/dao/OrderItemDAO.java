package com.tap.dao;

import java.util.List;

import com.tap.model.OrderItem;

public interface OrderItemDAO {

	int addOrderItem(OrderItem oi);
	
	void updateOrderItem(OrderItem oi);
	
	OrderItem getOrderItem(int orderItemId);
	
	List<OrderItem> getOrderItemsByOrderId(int orderId);
	
	void deleteOrderItem(int orderItemId);
}
