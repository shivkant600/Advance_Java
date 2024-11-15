package com.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MarksheetModel {
	
	
	//sirf add update delete mai get kartai hai
	//find by rollno search mai set kar tai hai

	public void add(MarksheetBean Bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("insert into marksheet values(?,?,?,?,?,?)");

		MarksheetBean existBean = new MarksheetBean();

		System.out.println("rollno" + Bean.getRollno());

		existBean = findbyROllno(Bean.getRollno());

		if (existBean != null) {
			System.out.println("roll no already  exits");
		}

		else {
			pstmt.setInt(1, Bean.getId());

			pstmt.setInt(2, Bean.getRollno());

			pstmt.setString(3, Bean.getName());

			pstmt.setInt(4, Bean.getPhysics());

			pstmt.setInt(5, Bean.getChemistry());

			pstmt.setInt(6, Bean.getMaths());

			int i = pstmt.executeUpdate();

			System.out.println("data added" + i);

		}
	}

	/////////////////////////////

	public void update(MarksheetBean Bean) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement(
				"update marksheet set id=?,rollno =?,name=?,physics =?,chemistry =?,maths =? where id = ?");

		pstmt.setInt(1, Bean.getId());
		pstmt.setInt(2, Bean.getRollno());
		pstmt.setString(3, Bean.getName());
		pstmt.setInt(4, Bean.getPhysics());
		pstmt.setInt(5, Bean.getChemistry());
		pstmt.setInt(6, Bean.getMaths());

		pstmt.setInt(7, Bean.getId());

		int i = pstmt.executeUpdate();

		System.out.println("data updated " + i);

	}

	public void delete(int id) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("delete from marksheet where id = ?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();

		System.out.println("data delete " + i);

	}

	// error hai es mai

	public MarksheetBean findbyROllno(int rollno) throws Exception {
		// yeh wali add say chala gee
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet where rollno =?");

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

	// es ko select method v bol tai hai
	public List search(MarksheetBean bean) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Result", "root", "root");

		PreparedStatement pstmt = conn.prepareStatement("select * from marksheet");

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

		//sirf return wala ko while loop say bahar likh tai hai   orr       bina return wala ko while loop kai andar likh tai hai
		return list;

	}

}
