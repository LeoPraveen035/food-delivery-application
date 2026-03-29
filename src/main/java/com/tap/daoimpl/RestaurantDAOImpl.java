package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.util.DBConnection;

public class RestaurantDAOImpl implements RestaurantDAO {
	
	@Override
	public int addRestaurant(Restaurant r) {
		int i=0;
		String QUERY = "INSERT INTO Restaurant(`name`,`address`,`phoneNumber`,`cuisineType`,`deliveryTime`,`adminUserId`,`rating`,`isActive`,`imageUrl`) VALUES(?,?,?,?,?,?,?,?,?)";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(QUERY))
		{
			
			
				pstmt.setString(1, r.getName());
				pstmt.setString(2, r.getAddress());
				pstmt.setString(3, r.getPhoneNumber());
				pstmt.setString(4, r.getCuisineType());
				pstmt.setString(5, r.getDeliveryTime());
				pstmt.setInt(6, r.getAdminUserId());
				pstmt.setString(7, r.getRating());
				pstmt.setBoolean(8, r.isActive());
				pstmt.setString(9, r.getImageUrl());
				
				
				i=pstmt.executeUpdate();
						
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@Override
	public Restaurant getRestaurant(int restaurantId) {
		Restaurant res = null;
		String QUERY = "SELECT * FROM `restaurant` WHERE `restaurantId` = ? ";
		try(Connection con=DBConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(QUERY);){
			
			stmt.setInt(1, restaurantId);
			ResultSet result=stmt.executeQuery();
			
			while(result.next()) {
			res = new Restaurant(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getInt(7),result.getString(8),result.getBoolean(9),result.getString(10));
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public List<Restaurant> getAllRestaurant(){
		
		List<Restaurant> list = new ArrayList<>();
		String QUERY = "SELECT * FROM `restaurant`";
		try(Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();)
		{
			ResultSet result=stmt.executeQuery(QUERY);
			
			while(result.next()) {
				list.add(new Restaurant(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getInt(7),result.getString(8),result.getBoolean(9),result.getString(10)));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int updateRestaurant(Restaurant r) {
		
		int i=0;
		String QUERY = "UPDATE `restaurant` SET `name` = ? , `address` = ? , `phoneNumber` = ? , `cuisineType` = ? , `deliveryTime` = ? , `adminUserId` = ? , `rating` = ? , `isActive` = ? WHERE restaurantId = ? ";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(QUERY);)
		{
			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getAddress());
			pstmt.setString(3, r.getPhoneNumber());
			pstmt.setString(4, r.getCuisineType());
			pstmt.setString(5, r.getDeliveryTime());
			pstmt.setInt(6, r.getAdminUserId());
			pstmt.setString(7, r.getRating());
			pstmt.setBoolean(8, r.isActive());
			pstmt.setInt(9,  r.getRestaurantId());
			
			i=pstmt.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	
	@Override
	public void deleteRestaurant(int restaurantId) {
		
		String QUERY = "DELETE FROM `restaurant` WHERE `restaurantId` = ? ";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(QUERY);)
		{
			pstmt.setInt(1, restaurantId);
			
			pstmt.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	        
}
