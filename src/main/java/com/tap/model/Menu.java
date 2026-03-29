package com.tap.model;

public class Menu {
	
	private int menuId;
	private int restId;
	private String itemName;
	private String description;
	private int price;
	private String isAvailable;
	private int rating;
	private String imageUrl;
	
	
	public Menu(int menuId, int restId, String itemName, String description, int price, String isAvailable, int rating, String imageUrl) {
		super();
		this.menuId = menuId;
		this.restId = restId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.rating = rating;
		this.imageUrl = imageUrl;
	}
	
	public Menu(int restId, String itemName, String description, int price, String isAvailable, int rating, String imageUrl) {
		super();
		this.restId = restId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
		this.rating = rating;
		this.imageUrl = imageUrl;
	}


	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public int getRating() {
		return rating;
	}

	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public int getRestId() {
		return restId;
	}


	public void setRestId(int restId) {
		this.restId = restId;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}





	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", restId=" + restId + ", itemName=" + itemName + ", description="
				+ description + ", price=" + price + ", rating=" + rating + "]";
	}
	
	
	
	
	

}
