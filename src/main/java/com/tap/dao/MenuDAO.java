package com.tap.dao;

import java.util.List;

import com.tap.model.Menu;

public interface MenuDAO {
	
	int addMenu(Menu menu);
	
	void updateMenu(Menu menu);
	
	Menu getMenu(int menuId);
	
	List<Menu> getMenuByRestaurantId(int restId);
	
	void deleteMenu(int menuId);

}
