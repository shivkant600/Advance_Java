package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class UserModel {

	public void add(UserBean bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?, ?)");
		
		

		UserBean exitsBean = new UserBean();
		System.out.println("username" + bean.getUsername());
		
		
		

		exitsBean = findByUsername(bean.getUsername());
		
		

		if (exitsBean != null) {
			System.out.println("username already  exits");
		}

		
		
		else {
			// column dhayan rakhnaa
			pstmt.setInt(1, bean.getId());
			pstmt.setString(2, bean.getFirstName());
			pstmt.setString(3, bean.getLastName());
			pstmt.setString(4, bean.getUsername());
			pstmt.setString(5, bean.getPassword());
			pstmt.setString(6, bean.getAddress());
			pstmt.setDate(7, new java.sql.Date(bean.getDob().getTime()));

			int i = pstmt.executeUpdate();

			System.out.println("data added succesfu" + i);
		}
	}

	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	

	public void delete(int Id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id =?");

		pstmt.setInt(1, Id);

		int i = pstmt.executeUpdate();

		System.out.println(i + "data delete succesfull");

	}
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	

	public void update(UserBean Bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_user  set firstname =?,lastname =?,Username =?,password =?,address = ?,Dob =? where id =?");

		pstmt.setString(1, Bean.getFirstName());
		pstmt.setString(2, Bean.getLastName());
		pstmt.setString(3, Bean.getUsername());
		pstmt.setString(4, Bean.getPassword());
		pstmt.setString(5, Bean.getAddress());
		pstmt.setDate(6, new java.sql.Date(Bean.getDob().getTime()));
		pstmt.setInt(7, Bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + "update succesfull");
	}
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	



	public List search(UserBean bean) throws Exception {
   //list saara data nikal kai dai gee es liya use kiya
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		StringBuffer sql = new StringBuffer("select * from st_user where 1 = 1");
		
		// stringbuffer ki method hai append (append do cheej ko jood rha hai )(edhar
		// pai select*from st_user where 1=1 ko sql.append mai jo diya hai ush say jod
		// rha hai)

		// sql injection bol tai hai esa where 1=1 (es ka use stringbuffer mai hota hai)

		if (bean != null) {
			 if(bean.getFirstName()!=null && bean.getFirstName().length()>0)
			 {
			 sql.append(" and firstname like '"+bean.getFirstName()+"'");
			}

			// if(bean.getLastName()!=null && bean.getLastName().length()>0) {

			// sql.append(" and lastname like '"+bean.getLastName()+"'");
			// }

		//	if (bean.getUsername() != null && bean.getUsername().length() > 0) {

			//	sql.append(" and username like '" + bean.getUsername() + "'");
			//}

		}

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		//string buffer ki cheej(object) ko laana kai liya tostring ka use kar tai hai 

		System.out.println("sql = " + sql.toString());

		// seach kai liya edhar say dekha
		ResultSet rs = pstmt.executeQuery();

		// UserBean bean = null;

		List list = new ArrayList();
		//list ek ek kar kai data nikal kar dai taaa hai

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setUsername(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setDob(rs.getDate(7));

			list.add(bean);
		}

		return list;

	}
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

	

	public UserBean Authenticate(String username, String password) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where username=? and password =?");

		pstmt.setString(1, username);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		UserBean Bean = null;

		while (rs.next()) {
			Bean = new UserBean();

			Bean.setId(rs.getInt(1));
			Bean.setFirstName(rs.getString(2));
			Bean.setLastName(rs.getString(3));
			Bean.setUsername(rs.getString(4));
			Bean.setPassword(rs.getString(5));
			Bean.setAddress(rs.getString(6));
			Bean.setDob(rs.getDate(7));
		}

		return Bean;

	}
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	

	public UserBean findByUsername(String Username) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where Username = ?");

		pstmt.setString(1, Username);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {
			
			//es mai bean mai set kara gai orr pstmt mai get kara gai

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstName(rs.getString(2));
			bean.setLastName(rs.getString(3));
			bean.setUsername(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setDob(rs.getDate(7));

		}

		return bean;

	}
}
