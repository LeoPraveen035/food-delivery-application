package com.tap.model;

public class OrderDetail {

	private Order order;
	private Restaurant rest;
	public OrderDetail(Order order, Restaurant rest) {
		super();
		this.order = order;
		this.rest = rest;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Restaurant getRest() {
		return rest;
	}
	public void setRest(Restaurant rest) {
		this.rest = rest;
	}
	@Override
	public String toString() {
		return "OrderDetail [order=" + order + ", rest=" + rest + "]";
	}
	
	
}
