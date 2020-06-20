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
		System.out.println("in do get Menu Servelet");
	
		
		String submitB=request.getParameter("addCart");
		String editB=request.getParameter("edit");
		String deleteB=request.getParameter("delete");
		

		
		String tableNumberString =request.getParameter("tableNumber");
		String name= request.getParameter("title");
		String des=request.getParameter("content");
		String priceString= request.getParameter("price");
		String quantityString =request.getParameter("quantity");
		int price = Integer.parseInt(priceString);
		int quantity=Integer.parseInt(quantityString);
		int tableid=Integer.parseInt(tableNumberString);
		
		int id=0;
		

		try {
			Connection con = (Connection)MyConnection.initDB();

			if (submitB!=null){
				MyConnection.addCart(con,tableid,name, quantity,price);
				
			}else if (editB !=null){
				//MyConnection.edit(con,name,des,price,id);

			}else{
				System.out.println("delete method");
				//MyConnection.delete(con,id);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	

		request.getRequestDispatcher("/html/Menu.jsp").forward(request, resp);
				
		
	}

}
