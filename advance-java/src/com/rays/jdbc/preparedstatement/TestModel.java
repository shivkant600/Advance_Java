package com.rays.jdbc.preparedstatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestModel {

	public static void main(String[] args) throws Exception {

		testAdd();
		
		//testdelete();
		//testupdate();
		
		

	}

	private static void testdelete() throws Exception {
	 UserModel model = new UserModel();
	 
	 model.delete(5);
	          
		
	}

	private static void testUpdate()throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserModel model = new UserModel();
		UserBean Bean = new UserBean();
		Bean.setId(1);
		Bean.setFirstName("anshit");
		Bean.setLastName("patel");
		Bean.setUsername("paas@123");
		Bean.setPassword("patel123");
		Bean.setAddress("mumbai");
		 Bean.setDob(sdf.parse("2004-02-14"));
		
	      model.update(Bean);
		
		
		
		
		
	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(5);
		bean.setFirstName("Kamal");
		bean.setLastName("Sharma");
		bean.setUsername("kamal@gmail.com");
		bean.setPassword("pass123");
		bean.setAddress("indore");
		bean.setDob(sdf.parse("2007-02-01"));

		model.add(bean);

	}

}