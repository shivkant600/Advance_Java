package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.UserBean;
import com.rays.util.JDBCDataSource;

public class UserModel {

public int nextpk() throws Exception {
	
	Connection conn = JDBCDataSource.getConnection();
	
	PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_user");

	int pk = 0;
	
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);
			/////1 colloum number diya hai 
			//es ko chalana kai liya add mai v change kar naa pada gaa
			
			//orr yeh wali add say chala geee

			System.out.println("max id = " + pk);

		}
		return pk + 1;

	}
	
	

	public void add(UserBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("insert into st_user values(?, ?, ?, ?, ?, ?, ?)");

		UserBean exitsBean = new UserBean();
		
		System.out.println("username" + bean.getUsername());

		exitsBean = findByUsername(bean.getUsername());

		if (exitsBean != null) {
			System.out.println("username already  exits");
		}

		else {
			// column dhayan rakhnaa
			pstmt.setInt(1, nextpk());
			pstmt.setString(2, bean.getFirstname());
			pstmt.setString(3, bean.getLastname());
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
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_user where id =?");

		pstmt.setInt(1, Id);

		int i = pstmt.executeUpdate();

		System.out.println(i + "data delete succesfull");

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void update(UserBean Bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement(
		"update st_user  set firstname =?,lastname =?,Username =?,password =?,address = ?,Dob =? where id =?");

		pstmt.setString(1, Bean.getFirstname());
		pstmt.setString(2, Bean.getLastname());
		pstmt.setString(3, Bean.getUsername());
		pstmt.setString(4, Bean.getPassword());
		pstmt.setString(5, Bean.getAddress());
		pstmt.setDate(6, new java.sql.Date(Bean.getDob().getTime()));
		pstmt.setInt(7, Bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println(i + "update succesfull");
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public List search(UserBean bean, int pageNo, int pageSize) throws Exception {
		// list saara data nikal kai dai gee es liya use kiya

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_user where 1 = 1");

		// stringbuffer ki method hai append (append do cheej ko jood rha hai )(edhar
		// pai select*from st_user where 1=1 ko sql.append mai jo diya hai ush say jod
		// rha hai)

		// sql injection bol tai hai esa where 1=1 (es ka use stringbuffer mai hota hai)

		if (bean != null) {
			if (bean.getFirstname() != null && bean.getFirstname().length() > 0) {
				sql.append(" and firstname like '" + bean.getFirstname() + "'");
			}

			// if(bean.getLastName()!=null && bean.getLastName().length()>0) {

			// sql.append(" and lastname like '"+bean.getLastName()+"'");
			// }

			// if (bean.getUsername() != null && bean.getUsername().length() > 0) {

			// sql.append(" and username like '" + bean.getUsername() + "'");
			// }

		}
		
		
		//for pagination
		if (pageSize > 0) {

			pageNo = (pageNo - 1) * pageSize;

			sql.append(" limit " + pageNo + "," + pageSize);

		}
		
		

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		// string buffer ki cheej(object) ko laana kai liya tostring ka use kar tai hai

		System.out.println("sql = " + sql.toString());

		// seach kai liya edhar say dekha
		ResultSet rs = pstmt.executeQuery();

		// UserBean bean = null;

		List list = new ArrayList();
		// list ek ek kar kai data nikal kar dai taaa hai

		while (rs.next()) {

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
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

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where username=? and password =?");

		pstmt.setString(1, username);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		UserBean Bean = null;

		while (rs.next()) {
			Bean = new UserBean();

			Bean.setId(rs.getInt(1));
			Bean.setFirstname(rs.getString(2));
			Bean.setLastname(rs.getString(3));
			Bean.setUsername(rs.getString(4));
			Bean.setPassword(rs.getString(5));
			Bean.setAddress(rs.getString(6));
			Bean.setDob(rs.getDate(7));
		}

		return Bean;

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public UserBean findByUsername(String Username) throws Exception {
		
		//yeh wali add say chala geee

		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where Username = ?");

		pstmt.setString(1, Username);

		ResultSet rs = pstmt.executeQuery();

		UserBean bean = null;

		while (rs.next()) {

			// es mai bean mai set kara gai orr pstmt mai get kara gai

			bean = new UserBean();

			bean.setId(rs.getInt(1));
			bean.setFirstname(rs.getString(2));
			bean.setLastname(rs.getString(3));
			bean.setUsername(rs.getString(4));
			bean.setPassword(rs.getString(5));
			bean.setAddress(rs.getString(6));
			bean.setDob(rs.getDate(7));

		}

		return bean;

	}

	
	

}
