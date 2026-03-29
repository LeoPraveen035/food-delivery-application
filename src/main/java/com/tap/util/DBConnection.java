package com.tap.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	static String URL = "jdbc:mysql://localhost:3306/fooddeliveryapp";
	static String USERNAME = "root";
	static String PASSWORD = "root";
	
	static Connection con=null;

	public static Connection getConnection(){

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}


}
