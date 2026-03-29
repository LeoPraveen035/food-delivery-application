package com.tap.model;

public class Restaurant {
	private int restaurantId;
	private String name;
	private String address; 
	private String phoneNumber;
	private String cuisineType;
	private String deliveryTime;
	private int adminUserId;
	private String rating;
	private boolean isActive;
	private String imageUrl;
	
	
	public Restaurant(int restaurantId, String name, String address, String phoneNumber, String cuisineType,
			String deliveryTime,int adminUserId, String rating, boolean isActive, String imageUrl) {
		
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imageUrl = imageUrl;
	}
	
	public Restaurant(String name, String address, String phoneNumber, String cuisineType,
			String deliveryTime,int adminUserId, String rating, boolean isActive, String imageUrl) {
		
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		this.imageUrl=imageUrl;
	}


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getAdminUserId() {
		return adminUserId;
	}


	public void setAdminUserId(int adminUserId) {
		this.adminUserId = adminUserId;
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getCuisineType() {
		return cuisineType;
	}


	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}


	public String getDeliveryTime() {
		return deliveryTime;
	}


	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "Restaurant [ RestaurantId : "+restaurantId+" Name: "+name+" Address: "+address+" ]";
	}
	
	
	
}
