package com.tap.model;

public class CartItem {
	private int menuId;
	private int restaurantId;
	private String menuName;
	private int quantity;
	private int price;
	private String imageUrl;
	
	public CartItem() {
		
	}
	
	
	public CartItem(int menuId, int restaurantId, String name, int quantity, int price, String imageUrl) {
		super();
		this.menuId = menuId;
		this.restaurantId = restaurantId;
		this.menuName = name;
		this.quantity = quantity;
		this.price = price;
		this.imageUrl = imageUrl;
	}


	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return menuName;
	}
	public void setName(String name) {
		this.menuName = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	@Override
	public String toString() {
		return "CartItem [menuId=" + menuId + ", restaurantId=" + restaurantId + ", name=" + menuName + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	
	
	
	
}
