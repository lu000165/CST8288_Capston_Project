package Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import objects.MenuItem;

/***
 * 
 * @author lianmin lu
 * 
 * This class if the SQL method related to MenuItemConnection 
 *
 */
public class MenuItemConnection extends MyConnection{
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_DESCIPTION = "description";
	public static final String COLUMN_PRICE = "price";
	public static final String COLUMN_active = "active";
	
	
	//Return all active menuItems
	public static ArrayList<MenuItem> showAllMenu() {
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
		
		try {
			Connection con = (Connection) initDB();
			Statement statement =(Statement) con.createStatement();
			String sql ="select * from menuitem";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()){
				int id = resultSet.getInt(COLUMN_ID);
				String name = resultSet.getString(COLUMN_NAME);
				String description = resultSet.getString(COLUMN_DESCIPTION);
				int price = resultSet.getInt(COLUMN_PRICE);
				boolean active = resultSet.getInt(COLUMN_active)>0;
				MenuItem menuItem = new MenuItem(id,name,description,price,active);
				menuItems.add(menuItem);
				
			}
			con.close();
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return menuItems;
	}
	public static void create(String name, String description, int price) throws SQLException, ClassNotFoundException {
		
		Connection con = (Connection)initDB();
		Statement statement =(Statement) con.createStatement();
		
		String sql = "INSERT INTO `menuitem`( "+ COLUMN_NAME+ ", "+COLUMN_DESCIPTION+", "+COLUMN_PRICE+") VALUES ( '"+name+ "' , '" +description+ "' ,"+ price+ ")";
		System.out.println(sql);
		statement.executeUpdate(sql);
		con.close();
	}
	public static void delete(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con = (Connection)initDB();
		Statement statement =(Statement) con.createStatement();
		String sql ="delete from menuitem where id="+id;
		statement.executeUpdate(sql);
		System.out.println(sql);
		con.close();
	} 
	public static void edit(String name, String description, int price,int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection con = (Connection)initDB();
		Statement statement =(Statement) con.createStatement();
		String sql ="update menuitem set name='"+name+"', description ='"+description +"' , price ="+price +" where id="+id;
		System.out.println(sql);
		statement.executeUpdate(sql);
		con.close();
	}
	public static ArrayList<MenuItem> showActiveMenu() {
		
		ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
		
		try {
			Connection con = (Connection) initDB();
			Statement statement =(Statement) con.createStatement();
			String sql ="select * from menuitem where active = 1";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()){
				int id = resultSet.getInt(COLUMN_ID);
				String name = resultSet.getString(COLUMN_NAME);
				String description = resultSet.getString(COLUMN_DESCIPTION);
				int price = resultSet.getInt(COLUMN_PRICE);
				boolean active = resultSet.getInt(COLUMN_active)>0;
				MenuItem menuItem = new MenuItem(id,name,description,price,active);
				menuItems.add(menuItem);
				
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuItems;
	}
	
	
}