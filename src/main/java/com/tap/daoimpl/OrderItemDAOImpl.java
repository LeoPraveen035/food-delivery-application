package com.tap.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.util.DBConnection;

public class OrderItemDAOImpl implements OrderItemDAO{
	
	@Override
	public int addOrderItem(OrderItem oi) {
		
		int i=0;
		String INSERT_QUERY = "INSERT INTO `orderitem`(`orderId`,`menuId`,`quantity`,`totalAmount`) VALUES(? ,? ,?, ?)";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(INSERT_QUERY);)
		{
			pstmt.setInt(1, oi.getOrderId());
			pstmt.setInt(2, oi.getMenuId());
			pstmt.setInt(3, oi.getQuantity());
			pstmt.setInt(4, oi.getTotalAmount());
			
			i = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@Override
	public void deleteOrderItem(int orderItem) {
		
		String DELETE_QUERY = "DELETE FROM `orderItem` WHERE `orderItem` = ?";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);)
		{
			pstmt.setInt(1, orderItem);
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public OrderItem getOrderItem(int orderItemId) {
		
		OrderItem oi = null;
		String SELECT_QUERY = "SELECT * FROM `OrderItem` WHERE `orderItem` = ? ";
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);)
		{
			pstmt.setInt(1, orderItemId);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int orderId = res.getInt(2);
				int menuId = res.getInt(3);
				int quantity = res.getInt(4);
				int totalAmount = res.getInt(5);
				
				oi = new OrderItem(orderItemId,orderId,menuId,quantity,totalAmount);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return oi;
	}
	
	@Override
	public List<OrderItem> getOrderItemsByOrderId(int orderId){
		
		List<OrderItem> list = new ArrayList<>();
		String SELECT_QUERY = "SELECT * FROM `orderItem` WHERE `orderId` = ? ";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);)
		{
			pstmt.setInt(1, orderId);
			
			ResultSet res=pstmt.executeQuery();
			
			while(res.next()) {
				int orderItemId = res.getInt(1);
				int menuId = res.getInt(3);
				int quantity = res.getInt(4);
				int totalAmount = res.getInt(5);
				
				list.add(new OrderItem(orderItemId,orderId,menuId,quantity,totalAmount));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	@Override
	public void updateOrderItem(OrderItem oi) {
		
		String UPDATE_QUERY ="UPDATE `orderItem` SET `orderId` = ? ,`menuId` = ? , `quantity` = ? , `totalAmount` = ? WHERE `orderItemId` = ? ";
		
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);){
			
			pstmt.setInt(1, oi.getOrderId());
			pstmt.setInt(2, oi.getMenuId());
			pstmt.setInt(3, oi.getQuantity());
			pstmt.setInt(4, oi.getTotalAmount());
			
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
