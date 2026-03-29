package com.tap.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.tap.dao.UserDAO;
import com.tap.daoimpl.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	static int count =3;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String oldPassword= "";
		String dbUsername= "";
		boolean found=false;
		
		
		PrintWriter out=resp.getWriter();
		
		 
		UserDAO impl=new UserDAOImpl();
		
		List<User> user= impl.getAllUser();
		for(User u : user) {
			oldPassword = u.getPassword();
			dbUsername = u.getUserName();
			if(password.equals(oldPassword) && username.equals(dbUsername)) {
				
				impl.updateUser(u);
				out.println("Hi "+username+" Welcome to Home Page");
				session.setAttribute("id", u.getUserId());
				RequestDispatcher rd = req.getRequestDispatcher("HomeServlet");
				rd.include(req, resp);
				found=true;
				return;
			}
		}
		
		if(count>0 && found==false){
			out.println("Invalid Password "+count+" attempts left");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, resp);
			count--;
		}
		else {
			out.println("Attempt Over Contact Admin");
		}
	}
	
	
	

}
