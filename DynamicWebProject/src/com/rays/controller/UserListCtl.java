package com.rays.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserListCtl.do")
public class UserListCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		try {
			List list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
		} catch (Exception e) {

			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String op = request.getParameter("operation");
		int pageNo = 1;
		int pageSize = 5;

		System.out.println("op = = " + op);

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		String[] ids = request.getParameterValues("ids");

		if (op.equals("delete")) {
			if (ids != null && ids.length > 0) {

				for (String id : ids) {

					try {
						model.delete(Integer.parseInt(id));
					} catch (Exception e) {

						e.printStackTrace();
					}

				}
			}

		} else {
			System.out.println("select at leat one record to delete");
		}

		try {

			if (op.equals("search")) {

				bean.setFirstname(request.getParameter("firstName"));
				bean.setLastname(request.getParameter("lastName"));
				bean.setLoginid(request.getParameter("loginId"));
				bean.setAddress(request.getParameter("address"));

				if (request.getParameter("dob") != "") {
					bean.setDob(sdf.parse(request.getParameter("dob")));
				}

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

		RequestDispatcher rd = request.getRequestDispatcher("UserListView.jsp");
		rd.forward(request, response);

	}
}