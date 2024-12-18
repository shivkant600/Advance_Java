package com.rays.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.rays.bean.MarksheetBean;
import com.rays.util.JDBCDataSource;

public class MarksheetModel {

	public void add(MarksheetBean Bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_marksheet values(?,?,?,?,?,?)");

		MarksheetBean existBean = new MarksheetBean();

		System.out.println("rollno" + Bean.getRollno());

		existBean = findbyROllno(Bean.getRollno());

		if (existBean != null) {
			System.out.println("roll no already  exits");
		}

		else {
			pstmt.setInt(1, nextpk());

			pstmt.setInt(2, Bean.getRollno());

			pstmt.setString(3, Bean.getName());

			pstmt.setInt(4, Bean.getPhysics());

			pstmt.setInt(5, Bean.getChemistry());

			pstmt.setInt(6, Bean.getMaths());

			int i = pstmt.executeUpdate();

			System.out.println("data added" + i);

		}
	}

	public void update(MarksheetBean Bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_marksheet set rollno =?,name=?,physics =?,chemistry =?,maths =? where id = ?");

	
		pstmt.setInt(1, Bean.getRollno());
		pstmt.setString(2, Bean.getName());
		pstmt.setInt(3, Bean.getPhysics());
		pstmt.setInt(4, Bean.getChemistry());
		pstmt.setInt(5, Bean.getMaths());

		pstmt.setInt(6, Bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("data updated " + i);

	}

	//////////////////////////////////////////

	public void delete(int id) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_marksheet where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("data delete " + i);

	}

	public MarksheetBean findbyROllno(int rollno) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from st_marksheet where rollno =?");

		pstmt.setInt(1, rollno);
		ResultSet rs = pstmt.executeQuery();

		MarksheetBean Bean = null;

		while (rs.next()) {

			Bean = new MarksheetBean();

			Bean.setId(rs.getInt(1));

			Bean.setRollno(rs.getInt(2));

			Bean.setName(rs.getString(3));

			Bean.setPhysics(rs.getInt(4));

			Bean.setChemistry(rs.getInt(5));

			Bean.setMaths(rs.getInt(6));
		}

		return Bean;

	}

	public List search(MarksheetBean bean, int pageNo, int pageSize) throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		StringBuffer sql = new StringBuffer("select * from st_marksheet where 1 = 1");

		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {

				sql.append(" and name like '" + bean.getName() + "'");
			}
		}

		if (bean != null) {

			if (bean.getRollno() != 0 && bean.getRollno() > 0) {
					 
				sql.append(" and rollno = " + bean.getRollno() + "");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;

			sql.append(" limit " + pageNo + "," + pageSize);

		}
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		System.out.println("sql =" + sql.toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {

			bean = new MarksheetBean();

			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));

			list.add(bean);
		}

		return list;

	}

	public int nextpk() throws Exception {

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_marksheet");

		int pk = 0;
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

			System.out.println("max id " + pk);

		}
		return pk + 1;

	}
	
	public MarksheetBean findbyrollno(int rollno) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("select * from st_user where rollno = ?");

		pstmt.setInt(1, rollno);
		
		ResultSet rs = pstmt.executeQuery();
		
		MarksheetBean bean = null;
		
		while(rs.next()) {
			
			bean = new MarksheetBean();
		
		bean.setId(rs.getInt(1));
		
		bean.setRollno(rs.getInt(2));
		bean.setName(rs.getString(3));
		bean.setPhysics(rs.getInt(4));
		bean.setChemistry(rs.getInt(5));
		bean.setMaths(rs.getInt(5));
				
	}
	return bean;


}
}
