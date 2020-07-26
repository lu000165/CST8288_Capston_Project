package Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import objects.Order;
import objects.OrderLineItem;

public class OrderConnection extends MyConnection {
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_TABLENUM = "tableNum";
	public static final String COLUMN_STATUS = "Status";
	public static Order create(int table) throws ClassNotFoundException, SQLException {
		Connection con = (Connection)initDB();
		Statement statement =(Statement) con.createStatement();
		
		String sql = "insert into purchaseorder (tableNum) value("+table+")";
		System.out.println(sql);
		statement.executeUpdate(sql);
		
		sql ="select * from purchaseorder order by id DESC";
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		int id = resultSet.getInt(COLUMN_ID);
		int tableNumber = resultSet.getInt(COLUMN_TABLENUM);
		String status = resultSet.getString(COLUMN_STATUS);
		
		Order order = new Order(id,tableNumber,new ArrayList<OrderLineItem>(),status);
		con.close();
		return order;
	}

	
	

}
