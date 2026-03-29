package com.tap.dao;

import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDAO {

	int addRestaurant(Restaurant restaurant);

	int updateRestaurant(Restaurant restaurant);

	List<Restaurant> getAllRestaurant();
	
	Restaurant getRestaurant(int restaurantId);
	
	void deleteRestaurant(int restaurantId);
	
}
