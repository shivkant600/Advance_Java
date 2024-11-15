package com.rays.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;


@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("UserRegistrationView.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		
		String Firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String dob = request.getParameter("dob");
		
		
		try {
			bean.setFirstname(Firstname);
			bean.setLastname(lastname);
			bean.setUsername(username);
			bean.setPassword(password);
			bean.setAddress(address);
			bean.setDob(sdf.parse(dob));
			
			model.add(bean);
			
			
			
			
		 //key kaa name hum nai msg rakha hai hum kuch v rak saktai hai (orr es mai jo v likh tai hai boo print hoo taa hai 
			request.setAttribute("msg", "user registered succesfully");
			
			//requestdispatcher method hai jo request send kartii hai dusra page pai es kai saath forward kar tai hai 
			RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");
			
			//request response pathset kar taa hai requestDispatcher par jaha par huma send kar naa hooo
			rd.forward(request, response);
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
