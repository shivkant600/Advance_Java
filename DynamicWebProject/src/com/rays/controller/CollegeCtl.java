package com.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.CollegeBean;
import com.rays.model.CollegeModel;

@WebServlet("/CollegeCtl.do")
public class CollegeCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		System.out.println("id ==" + id);
		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();
		if (id != null) {
			try {
				bean = model.findbyid(Integer.parseInt(id));
				request.setAttribute("bean", bean);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("CollegeView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		System.out.println("op ===" + op);
		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		String phoneNo = request.getParameter("phoneNo");
		try {
			bean.setName(name);
			bean.setAddress(address);
			bean.setState(state);
			bean.setCity(city);
			bean.setPhoneNo(phoneNo);

			if (op.equals("save")) {
				model.add(bean);
				request.setAttribute("msg", "data added succesfully");
			}

			else {

				bean.setId(Integer.parseInt(request.getParameter("id")));
				model.update(bean);
				request.setAttribute("bean", bean);

				request.setAttribute("msg", "data updated succesfully");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("CollegeView.jsp");
		rd.forward(request, response);
	}
}
