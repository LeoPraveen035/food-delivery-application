package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderDAO;
import com.tap.model.Order;
import com.tap.util.DBConnection;

public class OrderDAOImpl implements OrderDAO{
	
	@Override
	public int addOrder(Order order) {
		
		int i=0;
		String INSERT_QUERY = "INSERT INTO `orders`(`restId`, `userId`, `orderDate`, `totalAmt`, `status`,`paymentMethods`) VALUES(   ? ,?, ?, ?, ?, ?)";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS);)
		{
			pstmt.setInt(1, order.getRestId());
			pstmt.setInt(2, order.getUserId());
			pstmt.setDate(3, order.getOrderDate());
			pstmt.setInt(4, order.getTotalAmt());
			pstmt.setString(5,order.getStatus());
			pstmt.setString(6, order.getPaymentMethods());
			
			int rowsAffected=pstmt.executeUpdate();
			
			if (rowsAffected > 0) {
	            ResultSet rs = pstmt.getGeneratedKeys();
	            if (rs.next()) {
	                i = rs.getInt(1); // ✅ This is your orderId
	            }
	        }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@Override
	public void deleteOrder(int orderId) {
		
		String DELETE_QUERY = "DELETE FROM `orders` WHERE `orderId` = ? ";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);)
		{
			pstmt.setInt(1, orderId);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Order getOrder(int orderId) {
		
		Order order = null;
		String SELECT_QUERY = "SELECT * FROM `orders` WHERE `orderId` = ? ";
		
		try(Connection con =  DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);)
		{
			pstmt.setInt(1, orderId);
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				int restId = result.getInt(2);
				int userId = result.getInt(3);
				Date orderDate = result.getDate(4);
				int totalAmt = result.getInt(5);
				String status = result.getString(6);
				String paymentMethods = result.getString(7);
				
				order = new Order(orderId,restId, userId, orderDate, totalAmt, status, paymentMethods);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return order;
	}
	
	@Override
	public List<Order> getOrderByRestaurantId(int restId){
		
		List<Order> list = new ArrayList<>();;
		String SELECT_QUERY = "SELECT * FROM `orders` WHERE `restId = ? ";
		
		try(Connection con =  DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);)
		{
			
			pstmt.setInt(1, restId);
			ResultSet result=pstmt.executeQuery();
			
			
			
			while(result.next()) {
				int orderId = result.getInt(1);
				int userId = result.getInt(3);
				Date orderDate = result.getDate(4);
				int totalAmt = result.getInt(5);
				String status = result.getString(6);
				String paymentMethods = result.getString(7);
				
				list.add(new Order(orderId, restId, userId, orderDate, totalAmt, status, paymentMethods));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
		return list;
		}
	
	@Override
	public List<Order> getOrderByUserId(int userId){
		
		List<Order> list = new ArrayList<>();
		String SELECT_QUERY = "SELECT * FROM `orders` WHERE `userId` = ? ";
		
		try(Connection con =  DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);)
		{
			
			pstmt.setInt(1, userId);
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				
				int orderId = result.getInt(1);
				int restId = result.getInt(2);
				Date orderDate = result.getDate(4);
				int totalAmt = result.getInt(5);
				String status = result.getString(6);
				String paymentMethods = result.getString(7);
				
				list.add(new Order(orderId, restId, userId, orderDate, totalAmt, status, paymentMethods));
				
			}
		}
			catch(Exception e) {
				e.printStackTrace();
		}
		
		return list;
		
	}
	
	@Override
	public void updateOrder(Order order) {
		
		
		String SELECT_QUERY = "UPDATE `orders` SET `restId`= ? , `userId` = ? , `orderDate`= ? , `totalAmt`= ? , `status`= ?  , `paymentMethods` = ? WHERE `orderId` = ? ";
		
		try(Connection con =  DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);)
		{
			
			pstmt.setInt(1,order.getRestId());
			pstmt.setInt(2,order.getUserId());
			pstmt.setDate(3,order.getOrderDate());
			pstmt.setInt(4,order.getTotalAmt());
			pstmt.setString(5, order.getStatus());
			pstmt.setString(6, order.getPaymentMethods());
			
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
