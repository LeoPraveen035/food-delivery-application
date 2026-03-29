package com.tap.servlet;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tap.dao.OrderDAO;
import com.tap.dao.OrderItemDAO;
import com.tap.dao.RestaurantDAO;
import com.tap.daoimpl.OrderDAOImpl;
import com.tap.daoimpl.OrderItemDAOImpl;
import com.tap.daoimpl.RestaurantDAOImpl;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.Order;
import com.tap.model.OrderDetail;
import com.tap.model.OrderItem;
import com.tap.model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet{
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException{
		
		
		HttpSession session =req.getSession();
		Integer userId = (Integer) session.getAttribute("id");
		Integer restId = (Integer) session.getAttribute("restaurantId");
		String payment = req.getParameter("payment");
		Date orderDate = Date.valueOf(LocalDate.now());
		boolean orderStatus=Boolean.parseBoolean(req.getParameter("orderStatus"));
		
		OrderDAO impl = new OrderDAOImpl();
		
		if(orderStatus == true) {
		int totalamount = (int) session.getAttribute("totalPrice");
		
		//Order insertion
		
		Order order = new Order(restId,userId,orderDate,totalamount,"Confirmed",payment);
		int id = impl.addOrder(order);
		System.out.println("Order"+order);		
		System.out.println("id::::"+id);	
		
		//CartItem insertion 
		Cart cart = (Cart) session.getAttribute("cart");
		OrderItemDAO oiimpl = new OrderItemDAOImpl();
		for(CartItem ci : cart.getItems().values()) {
			OrderItem oi = new OrderItem(id,ci.getMenuId(),ci.getQuantity(),ci.getPrice());
			oiimpl.addOrderItem(oi);
		}
		
		}
		
		     
		
		List<Order> orders=impl.getOrderByUserId(userId);
		
		List<OrderDetail> orderDetailList = new ArrayList<>();
		
		RestaurantDAO restImpl = new RestaurantDAOImpl();
		for(Order o: orders) {
			Restaurant rest =restImpl.getRestaurant(o.getRestId());
			orderDetailList.add(new OrderDetail(o,rest));
			
		}
		session.setAttribute("orders", orderDetailList);
		
			
		res.sendRedirect("OrderItem.jsp");
			
		
		
		
		
		
		
		
	}
}      