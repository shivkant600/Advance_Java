package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insertquery {

	public static void main(String[] args)throws Exception {
		
		// step 1. Load Mysql Driver (Class loader)
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// step 2. Create Connection
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");

				
				Statement stmt = conn.createStatement();
				
				int i = stmt.executeUpdate("insert into employee values(10,'uday','amazon',5000,'banglore',null)");
				
				System.out.println(i);
				
				

	}
}
