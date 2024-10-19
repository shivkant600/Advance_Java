package JDBC;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

public class deletequery {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava","root","root");
		
		
		Statement st = cn.createStatement();
		
		int i = st.executeUpdate("delete from employee where id =9;");
		
		System.out.println(i);
		
		
		
	}

}
