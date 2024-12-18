package com.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.rays.bean.StudentBean;
import com.rays.util.JDBCDataSource;

public class StudentModel {

	public void add(StudentBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into student values(?,?,?,?,?,?,?)");

		SimpleDateFormat sdf = new SimpleDateFormat();

		StudentBean exitsbean = new StudentBean();

		// System.out.println("email==== " + bean.getEmail());

		// exitsbean = findbyemail(bean.getEmail());

		// if (exitsbean != null) {
		// System.out.println("email already exits");

		System.out.println("id==" + bean.getid());

		exitsbean = findbyid(bean.getid());

		if (exitsbean != null) {

			System.out.println("id already exits");

		}

		else {
			pstmt.setInt(1, nextpk());

			pstmt.setString(2, bean.getFirstName());

			pstmt.setString(3, bean.getLastName());

			pstmt.setDate(4, new java.sql.Date(bean.getDob().getTime()));

			pstmt.setString(5, bean.getMobileNo());

			pstmt.setString(6, bean.getEmail());

			pstmt.setString(7, bean.getCollegeName());

			int i = pstmt.executeUpdate();

			System.out.println("data added" + i);
		}

	}

	public void update(StudentBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update  student set firstname = ?,lastname = ?,dob = ?,mobileno = ?,email = ?,collegename = ? where id = ?");

		pstmt.setString(1, bean.getFirstName());

		pstmt.setString(2, bean.getLastName());

		pstmt.setDate(3, new java.sql.Date(bean.getDob().getTime()));

		pstmt.setString(4, bean.getMobileNo());

		pstmt.setString(5, bean.getEmail());
		pstmt.setString(6, bean.getCollegeName());

		pstmt.setInt(7, bean.getid());

		int i = pstmt.executeUpdate();

		System.out.println("data updated" + i);

	}

	public void delete(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from student where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("data deleted" + i);

	}

	public List search(StudentBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from Student where 1 = 1");
		if (bean != null) {
			if (bean.getFirstName() != null && bean.getFirstName().length() > 0) {
				sql.append(" and firstName like '" + bean.getFirstName() + "'");

			}
		}

		if (bean != null) {
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" and lastName like '" + bean.getLastName() + "'");

			}
		}

		if (bean != null) {
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				Date d = new Date(bean.getDob().getTime());
				sql.append(" and dob like '" + d + "'");
			}
		}
		if(bean != null) {
			if(bean.getEmail() !=null && bean.getEmail().length()>0) {
				sql.append(" and email like '" + bean.getEmail() + "'");
			}
			
		}

		if (bean != null) {
			if (bean.getCollegeName() != null && bean.getCollegeName().length() > 0) {
				sql.append(" and collegeName like '" + bean.getCollegeName() + "'");
			}
		}
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit "+pageNo +"," +pageSize);

		}

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		System.out.println("sql = " + sql.toString());
		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new StudentBean();

			bean.setid(rs.getInt(1));

			bean.setFirstName(rs.getString(2));

			bean.setLastName(rs.getString(3));

			bean.setDob(rs.getDate(4));

			bean.setMobileNo(rs.getString(5));

			bean.setEmail(rs.getString(6));

			bean.setCollegeName(rs.getString(7));

			list.add(bean);

		}
		return list;

	}

	public StudentBean findbyemail(String email) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from student where email = ?");

		pstmt.setString(1, email);

		ResultSet rs = pstmt.executeQuery();

		StudentBean bean = null;

		while (rs.next()) {

			bean = new StudentBean();

			bean.setid(rs.getInt(1));

			bean.setFirstName(rs.getString(2));

			bean.setLastName(rs.getString(3));

			bean.setDob(rs.getDate(4));

			bean.setEmail(rs.getString(5));

			bean.setMobileNo(rs.getString(6));

			bean.setCollegeName(rs.getString(7));

		}

		return bean;

	}

	public StudentBean findbyid(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from student where id = ?");

		pstmt.setInt(1, id);

		ResultSet rs = pstmt.executeQuery();

		StudentBean bean = null;

		while (rs.next()) {
			bean = new StudentBean();

			bean.setid(rs.getInt(1));

			bean.setFirstName(rs.getString(2));

			bean.setLastName(rs.getString(3));

			bean.setDob(rs.getDate(4));
			bean.setMobileNo(rs.getString(5));
			bean.setEmail(rs.getString(6));

			bean.setCollegeName(rs.getString(7));
		}
		return bean;

	}

	public int nextpk() throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from student");

		int pk = 0;

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			pk = rs.getInt(1);

			System.out.println("max id" + pk);
		}
		return pk + 1;

	}

}
