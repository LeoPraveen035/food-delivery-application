package com.tap.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import com.tap.dao.MenuDAO;
import com.tap.daoimpl.MenuDAOImpl;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet{
	
	private MenuDAO menuImpl = null;
	
	
	@Override
	public void init() {
		menuImpl= new MenuDAOImpl();
	
	}
	
	
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		int menuId = Integer.parseInt(req.getParameter("menuId"));
		String menuName = req.getParameter("menuName");
		
		
		
		
		Menu menu = menuImpl.getMenu(menuId);
		
		
		
		
		
		HttpSession session =req.getSession();	
		
		List<Menu> cart = (List<Menu>) session.getAttribute("cart");
		
		
		if(cart==null) {
			cart= new ArrayList<>();
		}
		
		cart.add(menu);
		session.setAttribute("cart",cart );
		
		
		for(Menu carts : cart) {
			System.out.print(carts);
		}
		
		
	
	}

}
