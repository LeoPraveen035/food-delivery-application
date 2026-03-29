package com.tap.servlet;

import java.io.IOException;

import com.tap.dao.MenuDAO;
import com.tap.daoimpl.MenuDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		HttpSession session=req.getSession();
		
		Cart cart=(Cart)session.getAttribute("cart");
		Integer restId = (Integer) session.getAttribute("restaurantId");
		
		int newRestId = Integer.parseInt(req.getParameter("restaurantId"));
		String action = req.getParameter("action");
		
		if(cart==null || restId != newRestId) {
			cart= new Cart();
			session.setAttribute("cart",cart);
			session.setAttribute("restaurantId", newRestId);
			
			
		}
		
			if(action.equals("add")) {
				addItemToCart(req,cart);
			}
			else if(action.equals("update")) {
				updateItemToCart(req,cart);
			}
			else if(action.equals("delete")){
				deleteItemToCart(req,cart);
			}
		
			
			
		res.sendRedirect("Cart.jsp");
	}


	
	
	private void deleteItemToCart(HttpServletRequest req, Cart cart) {
		int menuId = Integer.parseInt(req.getParameter("menuId"));
		cart.deleteItem(menuId);
		
		HttpSession session=req.getSession();
		int totalPrice =cart.totalPrice();
		session.setAttribute("totalPrice", totalPrice);
		
		int totalItems =cart.deleteItem(menuId);
		session=req.getSession();
		session.setAttribute("totalItems", totalItems);
		
		
	}

	private void updateItemToCart(HttpServletRequest req, Cart cart) {
		int menuId = Integer.parseInt(req.getParameter("menuId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		cart.updateItem(menuId, quantity);
		
		HttpSession session=req.getSession();
		int totalPrice =cart.totalPrice();
		session.setAttribute("totalPrice", totalPrice);
		
		
	}

	
	private void addItemToCart(HttpServletRequest req, Cart cart) {
		
		int menuId = Integer.parseInt(req.getParameter("menuId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		
		MenuDAO menuDAO = new MenuDAOImpl();
		Menu menu = menuDAO.getMenu(menuId);
		
		if(menu != null) {
			
			CartItem item = new CartItem(menuId, menu.getRestId(), menu.getItemName(), quantity, menu.getPrice(), menu.getImageUrl());
			
			int totalItems =cart.addItem(item);
			HttpSession session=req.getSession();
			session.setAttribute("totalItems", totalItems);
			
			int totalPrice =cart.totalPrice();
			session.setAttribute("totalPrice", totalPrice);
		}
		
	}
}


