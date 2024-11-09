package com.rays.jdbc.preparedstatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestModel {

	public static void main(String[] args) throws Exception {

		//testAdd();
		// testdelete();
		// testupdate();
		testsearch();
		//testAuthenticate();
	  
	}
	
	////////////////////////////////////////

	private static void testAuthenticate() throws Exception {
		UserModel model = new UserModel();
		
		UserBean Bean = model.Authenticate("kamal@gmail.com", "pass123");
		
		if(Bean != null) {
			System.out.println(Bean.getFirstName());
			System.out.println(Bean.getLastName());
		}
		else {
			System.out.println("user not found");
		}	
	}
	
	
   /////////////////////////////////////////////////////////
	private static void testsearch() throws Exception {
		
		
		
		UserModel model = new UserModel();
		

		UserBean bean = new UserBean();
        
          bean.setFirstName("anshit");
		
	//	bean.setUsername("paas@123");
		
	//	bean.setLastName("patel");
		
		List list = model.search(bean);
		
		
		Iterator it = list.iterator();
		
		while (it.hasNext()) {
			
			bean = (UserBean) it.next();
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getUsername());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getAddress());
			System.out.println("\t" + bean.getDob());

			
		}

	}

	private static void testdelete() throws Exception {
		UserModel model = new UserModel();

		model.delete(6);

	}

	private static void testUpdate() throws Exception {

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

		bean.setId(6);
		bean.setFirstName("Kamal");
		bean.setLastName("Sharma");
		bean.setUsername("kamal@gmail.com");
		bean.setPassword("pass123");
		bean.setAddress("indore");
		bean.setDob(sdf.parse("2007-02-01"));

		model.add(bean);

	}

}