package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateQuery {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava","root","root");
		
		Statement stm = conn.createStatement();
		
		     int i = stm.executeUpdate("update  employee set name ='raj' where id = 10");
		     
		     System.out.println(i);
		
	}
}
