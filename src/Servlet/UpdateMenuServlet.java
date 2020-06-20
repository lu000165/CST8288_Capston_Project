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

import Connection.MenuItemConnection;
import Connection.MyConnection;
import objects.OrderLineItem;
import objects.MenuItem;

//@WebServlet("/postLog")
public class UpdateMenuServlet extends HttpServlet{
	
	List<OrderLineItem> lineitem= new ArrayList<OrderLineItem>();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException{
	
		
		String submitB=request.getParameter("submit");
		String editB=request.getParameter("edit");
		String deleteB=request.getParameter("delete");

		String name= request.getParameter("title");
		String des=request.getParameter("content");
		String priceString= request.getParameter("price");
		String idString = request.getParameter("id");
	
		int price = Integer.parseInt(priceString);
		int id = 0;
		if (idString != null){
			id= Integer.parseInt(idString);
		}
		

		try {
			if (submitB!=null){
				MenuItemConnection.create(name,des,price);
				
			}else if (editB !=null){
				MenuItemConnection.edit(name,des,price,id);

			}else{
				System.out.println("delete method");
				MenuItemConnection.delete(id);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	

		request.getRequestDispatcher("/html/AddItem.jsp").forward(request, resp);
				
		
	}

}
