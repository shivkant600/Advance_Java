package com.rays.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.StudentBean;
import com.rays.model.StudentModel;

@WebServlet("/StudentCtl.do")
public class StudentCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("id=" + id);

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		try {
			bean = model.findbyid(Integer.parseInt(id));
			request.setAttribute("bean", bean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");

		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		System.out.println("op = " + op);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();
		String firstname = request.getParameter("FirstName");
		String lastname = request.getParameter("LastName");
		String dob = request.getParameter("dob");

		String email = request.getParameter("email");

		String mobileNo = request.getParameter("mobileNo");
		String collegename = request.getParameter("CollegeName");

		try {
			bean.setFirstName(firstname);
			bean.setLastName(lastname);
			bean.setDob(sdf.parse(dob));
			bean.setEmail(email);
			bean.setMobileNo(mobileNo);
			bean.setCollegeName(collegename);

			if (op.equals("save")) {
				model.add(bean);
				request.setAttribute("bean", bean);
				request.setAttribute("msg", "user added succesfully");
			} else {
				bean.setid(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("bean", bean);
				model.update(bean);
				request.setAttribute("msg", "user updated succesfully");

			}
			RequestDispatcher rd = request.getRequestDispatcher("StudentView.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
