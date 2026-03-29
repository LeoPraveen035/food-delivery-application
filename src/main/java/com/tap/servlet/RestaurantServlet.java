package com.tap.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.dao.MenuDAO;
import com.tap.dao.RestaurantDAO;
import com.tap.daoimpl.MenuDAOImpl;
import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.Menu;
import com.tap.model.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RestaurantServlet")
public class RestaurantServlet extends HttpServlet {

	public MenuDAO menu;

	@Override
	public void init() throws ServletException {
		menu = new MenuDAOImpl();
	}

	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			 int id = Integer.parseInt(req.getParameter("restaurantId"));
			 System.out.println("id: "+ id);
			 
			 
			 
			 RestaurantDAO rimpl = new RestaurantDAOImpl();
			 Restaurant restaurant = rimpl.getRestaurant(id);
			 
			 System.out.print(restaurant);
			 
			 List<Menu> menuList=menu.getMenuByRestaurantId(Integer.parseInt(req.getParameter("restaurantId")));
				 
			 	 req.setAttribute("menus",menuList);
				 req.setAttribute("restaurant",restaurant);
				
				 
				 RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
				 rd.forward(req,resp);
				 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
