package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DeleteQuery {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		
		Statement stm = conn.createStatement();
		
		
              int i = stm.executeUpdate("delete from st_user where id = 4");
              
              System.out.println(i);
	}

}
