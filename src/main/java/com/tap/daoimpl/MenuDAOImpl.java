package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDAO;
import com.tap.model.Menu;
import com.tap.util.DBConnection;

public class MenuDAOImpl implements MenuDAO {
	
	@Override
	public int addMenu(Menu menu) {
		int i=0;
		String INSERT_QUERY = "INSERT INTO `menu`(`restId`, `itemName`, `description`, `price`, `isAvailable`, `rating`, `imageUrl`) VALUE(?,?,?,?,?,?,?)";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(INSERT_QUERY);)
		{
			pstmt.setInt(1,menu.getRestId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDescription());
			pstmt.setInt(4, menu.getPrice());
			pstmt.setString(5, menu.getIsAvailable());
			pstmt.setInt(6, menu.getRating());
			pstmt.setString(7, menu.getImageUrl());
			
			
			i =pstmt.executeUpdate();
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@Override
	public void updateMenu(Menu menu) {
		
		String UPDATE_QUERY = "UPDATE `menu` SET `restId` = ? , `itemName` = ? , `description` = ? , `price` = ? , `isAvailable` = ?, `rating` = ?, `imageUrl` = ? WHERE `menuId` = ? ";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);)
		{
			pstmt.setInt(1, menu.getRestId());
			pstmt.setString(2, menu.getItemName());
			pstmt.setString(3, menu.getDescription());
			pstmt.setInt(4, menu.getPrice());
			pstmt.setString(5,menu.getIsAvailable());
			pstmt.setInt(6, menu.getRating());
			pstmt.setString(7, menu.getImageUrl());
			
			pstmt.setInt(8, menu.getMenuId());
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public Menu getMenu(int menuId) {
		
		Menu menu = null;
		String SELECT_QUERY = "SELECT * FROM `menu` WHERE `menuId` = ? ";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY)){
			
			pstmt.setInt(1, menuId);
			
			ResultSet result=pstmt.executeQuery();
			
			while(result.next()) {
				
				int restId = result.getInt(2);
				String itemName = result.getString(3);
				String description = result.getString(4);
				int price = result.getInt(5);
				String isAvailable = result.getString(6);
				int rating = result.getInt(7);
				String imageUrl = result.getString(8);
				
				menu = new Menu(menuId, restId, itemName, description, price, isAvailable, rating, imageUrl);
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return menu;
	}
	
	@Override
	public List<Menu> getMenuByRestaurantId(int restId){
		
		List<Menu> list =new ArrayList<>();
		String SELECT_QUERY = "SELECT * FROM `menu` WHERE `restId` = ? ";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY))
		{
		
			pstmt.setInt(1, restId);
			
			ResultSet result=pstmt.executeQuery();
			
			
			
			while(result.next()) {
				int menuId = result.getInt(1);
				String itemName = result.getString(3);
				String description = result.getString(4);
				int price = result.getInt(5);
				String isAvailable = result.getString(6);
				int rating = result.getInt(7);
				String imageUrl = result.getString(8);
				
				
				list.add(new Menu(menuId, restId, itemName, description, price, isAvailable, rating, imageUrl));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;	
	}
	
	@Override
	public void deleteMenu(int menuId) {
		
		String DELETE_QUERY = "DELETE FROM `menu` WHERE `menuId` = ? ";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);)
		{
			pstmt.setInt(1, menuId);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
