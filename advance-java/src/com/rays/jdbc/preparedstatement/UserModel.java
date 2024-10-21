package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel {

	public void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?, ?)");

		pstmt.setInt(1, bean.getId());
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLoginId());
		pstmt.setString(5, bean.getPassword());
		pstmt.setString(6, bean.getAddress());
		pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));

		int i = pstmt.executeUpdate();

		System.out.println("data added successfully " + i);
	}

	    public void delete(int id) throws Exception {
	    	
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
		
		
		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id = ?");
		                    //column pass kartai hai
		          pstmt.setInt(1, id);
		              
		          int i =pstmt.executeUpdate();
		          
		          System.out.println("data delete succesfully"+i);
		              
		   
		

	}

	public void update(UserBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","root");
	PreparedStatement pstmt = conn.prepareStatement("update st_user set firstname = ?,lastName = ?,username = ?,password = ?,address = ?,Dob =? where id =?");
	               pstmt.setString(1, bean.getFirstName());
	               
	               pstmt.setString(2, bean.getLastName());
	               
	              pstmt.setString(3,bean.getLoginId() );
	              
	              pstmt.setString(4,bean.getPassword() );
	              
	              pstmt.setString(5, bean.getAddress());
	              
	              pstmt.setDate(6,new java.sql.Date(bean.getDob().getTime()));
	              
	              pstmt.setInt(7, bean.getId());
	              
	              int i = pstmt.executeUpdate();
	              
	              System.out.println("data update succesfully"+i);
	              
	
              }

	public void search() {

	}

}
