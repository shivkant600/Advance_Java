package com.rays.test;

import java.util.ResourceBundle;

public class Testapp_hi {
	
	public static void main(String[] args) {
		
		ResourceBundle sr  = ResourceBundle.getBundle("com.rays.bundle.app_hi");
		
		System.out.println(sr.getString("greeting"));
	}

}
