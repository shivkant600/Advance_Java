package com.rays.jdbc.preparedstatement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
<<<<<<< HEAD
=======
import java.util.Iterator;
import java.util.List;
>>>>>>> e7f2ed83b6ff7e0798b1c90bb719d58f345130cc

public class TestModel {

	public static void main(String[] args) throws Exception {

		//testAdd();
<<<<<<< HEAD
		
		//testdelete();
		testUpdate();
		
		
=======
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
>>>>>>> e7f2ed83b6ff7e0798b1c90bb719d58f345130cc

	}

	private static void testUpdate() throws Exception {
<<<<<<< HEAD
		
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
		
=======

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

>>>>>>> e7f2ed83b6ff7e0798b1c90bb719d58f345130cc
	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

<<<<<<< HEAD
		bean.setId(4);
		bean.setFirstName("Kamal");
		bean.setLastName("Sharma");
		bean.setLoginId("kamal@gmail.com");
		bean.setPassword("pass123");
		bean.setAddress("indore");
		bean.setDob(sdf.parse("2003-02-02"));
=======
		bean.setId(6);
		bean.setFirstName("Kamal");
		bean.setLastName("Sharma");
		bean.setUsername("kamal@gmail.com");
		bean.setPassword("pass123");
		bean.setAddress("indore");
		bean.setDob(sdf.parse("2007-02-01"));
>>>>>>> e7f2ed83b6ff7e0798b1c90bb719d58f345130cc

		model.add(bean);

	}

}