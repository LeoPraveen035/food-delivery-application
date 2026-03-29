package com.tap.servlet;

import java.io.IOException;

import com.tap.dao.UserDAO;
import com.tap.daoimpl.UserDAOImpl;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		HttpSession session = req.getSession();
		
		String doorno = req.getParameter("doorno");
		String apartment = req.getParameter("apartment");
		String area =req.getParameter("area");
		String landmark =req.getParameter("landmark");
		String place =req.getParameter("place");
		
		int id = (int)session.getAttribute("id");
		UserDAO impl = new UserDAOImpl();
		
		User user = impl.getUser(id);
		
		
		
		if (doorno != null && apartment != null && area != null && landmark != null && !doorno.isEmpty()) {
		    String mergedAddress = String.join(", ", doorno, apartment, area, landmark);
		    user.setAddress(mergedAddress);
		    impl.updateUser(user);
		}
		if(place==null) {
			place="Home";
		}
		
		session.setAttribute("saveAddress", user.getAddress());
		session.setAttribute("place", place);
			
		RequestDispatcher rd = req.getRequestDispatcher("Order.jsp");
		rd.forward(req,res);
		
		
		
		
	}

}

