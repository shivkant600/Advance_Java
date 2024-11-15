package com.rays.test;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;


public class testapp {
	
	public static void main(String[] args) {
		
	ResourceBundle sr = ResourceBundle.getBundle("com.rays.bundle.app");
		
		System.out.println(sr.getString("greeeting"));
	}

}
