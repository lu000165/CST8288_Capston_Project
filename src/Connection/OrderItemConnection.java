package Connection;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class OrderItemConnection extends MyConnection {
	public static final String COLUMN_TABLEID = "tableid";
	public static final String COLUMN_MENUID = "menuId";
	public static final String COLUMN_QUANTITY = "quantity";
	public static final String COLUMN_ORDERID = "orderid";
	public static void addItem(int orderId, int tableNumber, int menuItemId, int quantity) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = (Connection)initDB();
		Statement statement =(Statement) con.createStatement();
		
		String sql = "insert into orderitem ("+COLUMN_TABLEID+","+COLUMN_MENUID+","+COLUMN_QUANTITY+","+COLUMN_ORDERID+") value("
		+tableNumber+","+menuItemId+","+quantity+","+orderId+")";
		System.out.println(sql);
		statement.executeUpdate(sql);
	}
		

}
