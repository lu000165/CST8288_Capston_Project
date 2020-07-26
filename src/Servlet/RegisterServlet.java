package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.AdminUserConnection;


public class RegisterServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("in do get RegisterServlet");
		
		String register=request.getParameter("submit");
		
		if (register!=null){
			System.out.println("register user");
			String userNameString =request.getParameter("userName");
			String passwordString = request.getParameter("password");
			try {
				AdminUserConnection.register(userNameString,passwordString);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// to do print out error message on screen
				e.printStackTrace();
			}
		}
		request.getRequestDispatcher("/html/login.jsp").forward(request, resp);
	}

}
