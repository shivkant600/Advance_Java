package com.rays.jdbc.preparedstatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestModel {

	public static void main(String[] args) throws Exception {

		//testAdd();
		
		//testdelete();
		testUpdate();
		
		

	}

	private static void testUpdate() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model = new UserModel();
		
		UserBean bean = new UserBean();
		
		bean.setId(1);
		bean.setFirstName("satyam");
		bean.setLastName("choudhary");
		bean.setLoginId("satyu@gmail123");
		bean.setPassword("pass@123");
		bean.setAddress("pune");
		bean.setDob(sdf.parse("2004-03-02"));
		
		model.update(bean);
		
		
		
		
	}

	private static void testdelete() throws Exception {
	         UserModel model = new UserModel();
	         model.delete(3);
		
	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(4);
		bean.setFirstName("Kamal");
		bean.setLastName("Sharma");
		bean.setLoginId("kamal@gmail.com");
		bean.setPassword("pass123");
		bean.setAddress("indore");
		bean.setDob(sdf.parse("2003-02-02"));

		model.add(bean);

	}

}