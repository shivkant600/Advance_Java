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

@WebServlet("/CollegeListCtl.do")
public class CollegeListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		try {
			List list = model.search(bean, 1, 5);
			request.setAttribute("list", list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("CollegeListView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();

		String op = request.getParameter("operation");
		int pageNo = 1;
		int pageSize = 5;

		System.out.println("op====" + op);

		String[] ids = request.getParameterValues("ids");

		try {

			if (op.equals("delete")) {
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
				bean.setName(request.getParameter("name"));
				bean.setAddress(request.getParameter("address"));
				bean.setState(request.getParameter("state"));
			}

			if (op.equals("next")) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
				pageNo++;
			}
			if (op.equals("previous")) {
				pageNo = Integer.parseInt(request.getParameter("pageNo"));
				pageNo--;
			}
			List list = model.search(bean, pageNo, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("CollegeListView.jsp");
		rd.forward(request, response);

	}

}
