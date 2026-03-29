package com.tap.dao;

import java.util.List;
import com.tap.model.User;



public interface UserDAO {

	List<User> getAllUser();
	
	int addUser(User user);
	
	void updateUser(User user);
	
	User getUser(int id);
	
	void deleteUser(int id);
}
