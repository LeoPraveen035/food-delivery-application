package com.tap.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.MenuDAO;
import com.tap.dao.OrderDAO;
import com.tap.dao.OrderItemDAO;
import com.tap.dao.RestaurantDAO;
import com.tap.dao.UserDAO;
import com.tap.daoimpl.MenuDAOImpl;
import com.tap.daoimpl.OrderDAOImpl;
import com.tap.daoimpl.OrderItemDAOImpl;
import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.daoimpl.UserDAOImpl;
import com.tap.model.Menu;
import com.tap.model.Order;
import com.tap.model.OrderItem;
import com.tap.model.Restaurant;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/OrderDetailServlet")
public class OrderDetailServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		
		int restId = Integer.parseInt(req.getParameter("restId")) ;
		RestaurantDAO impl = new RestaurantDAOImpl();
		
		Restaurant r = impl.getRestaurant(restId);
		
		int orderId = Integer.parseInt(req.getParameter("orderId"));
		OrderDAO oimpl = new OrderDAOImpl();
		Order o = oimpl.getOrder(orderId);
		
		OrderItemDAO oiimpl = new OrderItemDAOImpl();
		List<OrderItem> list = oiimpl.getOrderItemsByOrderId(orderId);
		
		MenuDAO mimpl = new MenuDAOImpl();
		List<Menu> menuList = new ArrayList<>();
		for(OrderItem oi : list) {
			Menu m =mimpl.getMenu(oi.getMenuId());
			menuList.add(m);
			System.out.println(m);
		}
		
		UserDAO uimpl = new UserDAOImpl();
		User u = uimpl.getUser(o.getUserId());
		req.setAttribute("user", u);
		req.setAttribute("order", o);
		req.setAttribute("restaurant", r);
		req.setAttribute("orderItem", list);
		req.setAttribute("menuList", menuList);
		RequestDispatcher rd = req.getRequestDispatcher("OrderDetail.jsp");
		rd.forward(req, res);
		
	}
}
