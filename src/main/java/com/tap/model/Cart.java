package com.tap.model;

import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

public class Cart {

	private Map<Integer, CartItem> itemsMap;
	
	public Cart() {
		this.itemsMap = new HashMap<>();
	}
	
	public int addItem(CartItem item) {
		int menuId = item.getMenuId();
		if(itemsMap.containsKey(menuId)) {
			CartItem existingItem=itemsMap.get(menuId);
			existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());	
			
		}
		else {
			itemsMap.put(menuId, item);
			
			
		}
		int size = itemsMap.size();
		return size;
		
	}
	
	public Map<Integer, CartItem> getItems(){
		
		return itemsMap;
	}
	
	public void updateItem(int menuId, int quantity) {
		if(itemsMap.containsKey(menuId)) {
			if(quantity <= 0) {
				itemsMap.remove(menuId);
			}
			else {
				itemsMap.get(menuId).setQuantity(quantity);
			}
		}
	}
	
	public int deleteItem(int menuId) {
		itemsMap.remove(menuId);
		int size = itemsMap.size();
		return size;
	}
	
	public int totalPrice() {
		int totalPrice = 0;
		for(CartItem item : itemsMap.values()) {
			if(item.getQuantity()>=1) {
				totalPrice = totalPrice+ (item.getPrice()*item.getQuantity());
			}
			else {
				totalPrice=totalPrice+item.getPrice();
			}
		}
		return totalPrice;
		
		
		
	}
}
