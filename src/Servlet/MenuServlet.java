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

//@WebServlet("/postLog")
public class MenuServlet extends HttpServlet{
	
	List<OrderLineItem> lineitem= new ArrayList<OrderLineItem>();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException{
	
		String submit=request.getParameter("submit");

		String name= request.getParameter("Name");
		String priceString= request.getParameter("Price");
		String quantityString = request.getParameter("Quantity");
		String des=request.getParameter("Description");
		int quantity=Integer.parseInt(quantityString);
		double price = Double.parseDouble(priceString);
		
	

		request.getRequestDispatcher("/html/Menu.jsp").forward(request, resp);
				
		
	}

}
