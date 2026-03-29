package com.tap.daoimpl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.model.User;
import com.tap.util.DBConnection;

public class UserDAOImpl implements UserDAO {
	
	private String INSERT_QUERY = "INSERT INTO `user`(`userId`,`name`,`userName`,`password`,`email`,`phoneNumber`,`address`,`role`,`createdDate`,`lastLoginDate`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private String UPDATE_QUERY = "UPDATE `user` SET `name` = ?, `userName` = ?, `password` = ?, `email` = ? ,`phoneNumber` = ?, `address` = ?, `lastLoginDate` = ? WHERE `userId` = ?";
	
	private String SELECT_ALL_QUERY = "SELECT * FROM `user`";
	private String SELECT_QUERY = "SELECT * FROM `user` WHERE `userId` = ?";
	
	private String DELETE_QUERY = "DELETE FROM `user` WHERE `userId` = ? ";
	
	@Override
	public int addUser(User user) {
		int res = 0;
		//try with resource
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement(INSERT_QUERY);)
		{
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getPhoneNumber());
			pstmt.setString(7, user.getAddress());
			pstmt.setString(8, user.getRole());
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(10, new Timestamp(System.currentTimeMillis()));
			

			res = pstmt.executeUpdate();
			System.out.println(res);
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		return res;
	}
	
	@Override
	public void updateUser(User user) {
		
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(UPDATE_QUERY);)
		{
			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getUserName());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getEmail());
			pstmt.setString(5,user.getPhoneNumber());
			pstmt.setString(6,user.getAddress());
			pstmt.setInt(8, user.getUserId());
			pstmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			
			int res=pstmt.executeUpdate();	
			System.out.println(res);
			
		}
		catch(SQLException e) {
			
		}
	}

	@Override
	public List<User> getAllUser() {
		List<User> list = new ArrayList<>();
		try(Connection con = DBConnection.getConnection();
				Statement stmt = con.createStatement();)
		{
			ResultSet result = stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(result.next()) {
				list.add(new User(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getTimestamp(9),result.getTimestamp(10)));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public User getUser(int id) {
		User u = null;
		try(Connection con = DBConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement(SELECT_QUERY);){
			
			pstmt.setInt(1,id);
			ResultSet result = pstmt.executeQuery();
			while(result.next()) {
			u = new User(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getTimestamp(9),result.getTimestamp(10));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void deleteUser(int id) {
		try(Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(DELETE_QUERY);){
			
			pstmt.setInt(1, id);
			int res=pstmt.executeUpdate();
			System.out.println(res);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
			
			
		
	}
}
