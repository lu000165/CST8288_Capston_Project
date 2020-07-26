package Servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import Connection.MyConnection;
import objects.OrderLineItem;
import objects.MenuItem;
import objects.Order;

//@WebServlet("/postLog")
public class MenuServlet extends HttpServlet{
	
	List<OrderLineItem> lineitem= new ArrayList<OrderLineItem>();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("in do get Menu Servelet");
	
		
		String submitB=request.getParameter("addCart");
		String editB=request.getParameter("edit");
		String deleteB=request.getParameter("delete");
		String setTableB = request.getParameter("setTable");
		

		
		//String tableNumberString =request.getParameter("tableNumber");
		//String name= request.getParameter("title");
		//String des=request.getParameter("content");
		//String priceString= request.getParameter("price");
		//String quantityString =request.getParameter("quantity");
		//int price = Integer.parseInt(priceString);
		//int quantity=Integer.parseInt(quantityString);
		//int tableid=Integer.parseInt(tableNumberString);
		
		if(!(setTableB == null)){
			try {
				String tableNumberString =request.getParameter("tableNumber");
				int tableNum = Integer.parseInt(tableNumberString);
				Order newOrder = Order.create(tableNum);
				request.setAttribute("orderID", newOrder.getOrderNumber());
				request.setAttribute("tableNumber", newOrder.getTableNumber());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if(!(submitB == null)){
			System.out.println("in add cart");
			String tableNumberString =request.getParameter("tableNumber");
			int tableNumber = Integer.parseInt(tableNumberString);
			String orderIDString = request.getParameter("orderNumber");
			int orderId = Integer.parseInt(orderIDString);
			String memuItemString = request.getParameter("itemID");
			int menuItemId = Integer.parseInt(memuItemString);
			String quantityString = request.getParameter("quantity");
			int quantity = Integer.parseInt(quantityString);
			
			request.setAttribute("orderID", orderId);
			request.setAttribute("tableNumber", tableNumber);
			
			try {
				Order.addItem(orderId,tableNumber,menuItemId,quantity);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		



		
	

		request.getRequestDispatcher("/html/Menu.jsp").forward(request, resp);
				
		
	}

}
