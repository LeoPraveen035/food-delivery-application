package com.tap.model;

import java.sql.Date;

public class Order {
	
	private int orderId;
	private int restId;
	private int userId;
	private Date orderDate;
	private int totalAmt;
	private String status;
	private String paymentMethods;
	
	public Order(int orderId, int restId, int userId, Date orderDate, int totalAmt, String status,
			String paymentMethods) {
		this.orderId = orderId;
		this.restId = restId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmt = totalAmt;
		this.status = status;
		this.paymentMethods = paymentMethods;
	}
	public Order(int restId, int userId, Date orderDate, int totalAmt, String status,
			String paymentMethods) {
		
		this.restId = restId;
		this.userId = userId;
		this.orderDate = orderDate;
		this.totalAmt = totalAmt;
		this.status = status;
		this.paymentMethods = paymentMethods;
	}

	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getRestId() {
		return restId;
	}

	public void setRestId(int restId) {
		this.restId = restId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(String paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", restId=" + restId + ", userId=" + userId + ", orderDate=" + orderDate
				+ ", totalAmt=" + totalAmt + ", status=" + status + ", paymentMethods=" + paymentMethods + "]";
	}
	
	
	

}
