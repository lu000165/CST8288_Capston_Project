package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.AdminUserConnection;


public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException{
		System.out.println("in do get RegisterServlet");
		
		String login=request.getParameter("submit");
		
		if (login!=null){
			Boolean loginSuccessful = false;
			System.out.println("login user");
			String userNameString =request.getParameter("userName");
			String passwordString = request.getParameter("password");
			try {
				loginSuccessful = AdminUserConnection.login(userNameString,passwordString);
				System.out.println("loging succesfull: "+ loginSuccessful);
				if (loginSuccessful){
					request.getRequestDispatcher("/html/AddItem.jsp").forward(request, resp);
				}else{
					request.setAttribute("ErrorMessage", "Login unsuccessful");
					request.getRequestDispatcher("/html/login.jsp").forward(request, resp);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// to do print out error message on screen
				e.printStackTrace();
			}
		}else{
		
			request.getRequestDispatcher("/html/login.jsp").forward(request, resp);
	
		}
	}

}
