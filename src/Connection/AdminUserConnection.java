package Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import objects.Order;
import objects.OrderLineItem;

public class AdminUserConnection extends MyConnection {
	public static final String COLUMN_UserName = "UserName";
	public static final String COLUMN_Password = "Password";
	public static void register(String userName,String password) throws ClassNotFoundException, SQLException {
		Connection con = (Connection)initDB();
		Statement statement =(Statement) con.createStatement();
		
		String sql = "insert into adminuser ("+COLUMN_UserName+","+COLUMN_Password+") value('"+userName+"','"+password+"')";
		System.out.println(sql);
		statement.executeUpdate(sql);
		
		con.close();
	}
	public static Boolean login(String userNameString, String passwordString) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = (Connection)initDB();
		Statement statement =(Statement) con.createStatement();
		
		String sql = "select * from adminuser where "+COLUMN_UserName+" = '"+userNameString+"' and "+ COLUMN_Password + " = '"+
				passwordString+"'";
		ResultSet resultSet = statement.executeQuery(sql);
		
		return resultSet.next();
		
	}

}
