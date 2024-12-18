package com.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.ProductBean;
import com.rays.util.JDBCDataSource;

public class ProductModel {
	public void add(ProductBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("insert into st_product values(?,?,?,?,?)");

		pstmt.setInt(1, nextpk());
		pstmt.setString(2, bean.getProductname());
		pstmt.setString(3, bean.getProductprice());
		pstmt.setDate(4, new java.sql.Date(bean.getPurchasedate().getTime()));
		pstmt.setString(5, bean.getProductcategory());

		int i = pstmt.executeUpdate();
		System.out.println("data added succesfully" + i);
	}

	public void update(ProductBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_product set productname=?, productprice=?,  purchasedate=?,  productcategory=? where id=?");
		pstmt.setString(1, bean.getProductname());
		pstmt.setString(2, bean.getProductprice());
		pstmt.setDate(3, new java.sql.Date(bean.getPurchasedate().getTime()));
		pstmt.setString(4, bean.getProductcategory());

		pstmt.setInt(5, bean.getId());

		int i = pstmt.executeUpdate();
		System.out.println("data updated" + i);

	}

	public void delete(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("delete from st_product where id =?");

		pstmt.setInt(1, id);

		int i = pstmt.executeUpdate();
		System.out.println("data deleted succesfully" + i);
	}

	public List search(ProductBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		StringBuffer sql = new StringBuffer("select * from st_product where 1 = 1");
		if (bean != null) {

			if (bean.getProductname() != null && bean.getProductname().length() > 0) {
				sql.append(" and productname like '" + bean.getProductname() + "'");
			}
			if (bean.getProductprice() != null && bean.getProductprice().length() > 0) {
				sql.append(" and productprice like '" + bean.getProductprice() + "'");

			}
		}
	//	if (pageSize > 0) {
		//	pageNo = (pageNo - 1) * pageSize;
			//sql.append(" limit " + pageNo + "," + pageSize);
		//}

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		System.out.println("sql==" + toString());

		ResultSet rs = pstmt.executeQuery();

		List list = new ArrayList();

		while (rs.next()) {
			bean = new ProductBean();

			bean.setId(rs.getInt(1));
			bean.setProductname(rs.getString(2));
			bean.setProductprice(rs.getString(3));
			bean.setPurchasedate(rs.getDate(4));
			bean.setProductcategory(rs.getString(5));

			list.add(bean);
		}
		return list;

	}

	public ProductBean findbyid(int id) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select * from st_product where id =?");

		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();

		ProductBean bean = null;
		while (rs.next()) {
			bean = new ProductBean();

			bean.setId(rs.getInt(1));
			bean.setProductname(rs.getString(2));
			bean.setProductprice(rs.getString(3));
			bean.setPurchasedate(rs.getDate(4));
			bean.setProductcategory(rs.getString(5));

		}
		return bean;
	}

	public int nextpk() throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_product");

		int pk = 0;
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
			System.out.println("max id " + pk);

		}
		return pk + 1;

	}

}
