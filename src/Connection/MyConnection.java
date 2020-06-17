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
		String dbname="";
  
        Class.forName(dbDriver); 
        Connection con=(Connection) DriverManager.getConnection(servername+dbname,username,password);
        return con; 
    }

	public static void edit(Connection con, String title, String content, int id) throws SQLException {
		// TODO Auto-generated method stub
		Statement statement =(Statement) con.createStatement();
		String sql ="update textlog set title='"+title+"', content ='"+content +"' where id="+id;
		System.out.println(sql);
		statement.executeUpdate(sql);
	}

	public static void create(Connection con, String title, String content) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement st = (PreparedStatement) con 
                .prepareStatement("insert into textlog (title,content) values(?, ?)"); 

         st.setString(1, title); 
         st.setString(2, content);
         st.executeUpdate(); 
	}

	public static void delete(Connection con, int id) throws SQLException {
		// TODO Auto-generated method stub
		Statement statement =(Statement) con.createStatement();
		String sql ="delete from textlog where id="+id;
		statement.executeUpdate(sql);
	} 
} 