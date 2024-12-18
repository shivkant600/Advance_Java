package com.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.StudentBean;
import com.rays.model.StudentModel;

@WebServlet("/StudentListCtl.do")
public class StudentListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		try {
			List list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("StudentListView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in do post method in StudentListCtl");
		String op = request.getParameter("operation");
		 int pageNo=1;
		 int pageSize=5;

		System.out.println("op==" + op);

		StudentBean bean = new StudentBean();
		StudentModel model = new StudentModel();

		String[] ids = request.getParameterValues("ids");

		try {
		
		if (op.equals("delete")) {
			System.out.println("in delete condition");

		//	if (ids != null && ids.length > 0) {

				for (String id : ids) {

					try {
						model.delete(Integer.parseInt(id));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
		
			if (op.equals("search")) {
				System.out.println("in search condition");
				bean.setFirstName(request.getParameter("firstName"));
				bean.setLastName(request.getParameter("lastName"));
				bean.setEmail(request.getParameter("email"));
			}
			if(op.equals("next")) {
				System.out.println("in next method"); 
				pageNo=Integer.parseInt(request.getParameter("pageNo"));
				pageNo++;
				
			}
			
			if(op.equals("previous")) {
				System.out.println("in previous  method");
				pageNo=Integer.parseInt(request.getParameter("pageNo"));
				pageNo--;
				
			}

			List list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("StudentListView.jsp");
		rd.forward(request, response);

	}

}
