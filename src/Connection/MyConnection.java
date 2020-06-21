package Connection;


import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement; 
  
// This class can be used to initialize the database connection
//might need to find a web database
public class MyConnection { 
    public static Connection initDB() 
        throws SQLException, ClassNotFoundException 
    { 
        
		String dbDriver="com.mysql.jdbc.Driver";
		String servername = "jdbc:mysql://localhost:3306/";
		String username ="root";
		String password ="";
		String dbname="capstone_project";
  
        Class.forName(dbDriver); 
        Connection con=(Connection) DriverManager.getConnection(servername+dbname,username,password);
        checkDBTables(con);
        return con; 
    }






	
	private static void checkDBTables(Connection con) throws SQLException {
		createMenuItemTable(con);
	}







	private static void createMenuItemTable(Connection con) throws SQLException {
		Statement statement =(Statement) con.createStatement();
		String menuItemTableSQL = "CREATE TABLE IF NOT EXISTS `menuitem` (" 
		  +"`id` int(11) NOT NULL AUTO_INCREMENT,"
		  +"`name` varchar(255) NOT NULL,"
		  +"`description` varchar(255) DEFAULT NULL,"
		  +"`price` int(11) DEFAULT NULL,"
		  +"`active` tinyint(1) NOT NULL DEFAULT 1,"
		  +"PRIMARY KEY (`id`))";
		statement.executeUpdate(menuItemTableSQL);
		
	}







	public static void addCart(Connection con, int tableid, String name, int quantity, int price) throws SQLException {
		// TODO Auto-generated method stub
		Statement statement =(Statement) con.createStatement();
		
		String sql = "INSERT INTO `orderitem`( `tableid`, `name`, `quantity`, `price`) VALUES ( "+tableid+ " , "+name+ " , " +quantity+ " ,"+ price+ ")";
		statement.executeUpdate(sql);
	}
} 