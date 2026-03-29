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

public class RegisterServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		String phoneno=req.getParameter("phoneno");
		String address=req.getParameter("address");
		String role=req.getParameter("role");
		
		res.setContentType("text/html");
		
		User u = new User(name,username,password,email,phoneno,address,role);
		UserDAO impl = new UserDAOImpl();
		
		int result = impl.addUser(u);
		
		PrintWriter out = res.getWriter();
		
		
		if(result==1 && username.equals(u.getUserName())) {
			out.print("Hi "+req.getParameter("name")+" Registration Successful !!");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req,res);
		}
		else {
			out.print("Hi "+req.getParameter("name")+" Registration Failed !!");
			
		}
	}
	
	

}
