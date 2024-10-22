package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class UserModel {

	public void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?, ?)");
		
		
       // column dhayan rakhnaa
		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getUsername());
		pstmt.setString(5, bean.getPassword());
		pstmt.setString(6, bean.getAddress());
		pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));

		int i = pstmt.executeUpdate();

		System.out.println("data added successfully " + i);
	}

	    public void delete(int Id) throws Exception {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","root","root");
	    	
	    	PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id =?");
	    	
	    	
	    	               pstmt.setInt(1, Id);
	    	
	    	       int i =   pstmt.executeUpdate();
	    	       
	    	       System.out.println(i+"data delete succesfull");
	    	
		
		   
		

	}

	public void update(UserBean Bean) throws Exception  {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		
		PreparedStatement pstmt= conn.prepareStatement("update st_user  set firstname =?,lastname =?,Username =?,password =?,address = ?,Dob =? where id =?");
		
		pstmt.setString(1,Bean.getFirstName());
		pstmt.setString(2, Bean.getLastName());
		pstmt.setString(3, Bean.getUsername());
		pstmt.setString(4, Bean.getPassword());
		pstmt.setString(5, Bean.getAddress());
		pstmt.setDate(6, new java.sql.Date(Bean.getDob().getTime()));
		pstmt.setInt(7, Bean.getId());
		
		int i = pstmt.executeUpdate();
		
		System.out.println(i +"update succesfull");
	}
		

	public void search() {

	}

}
