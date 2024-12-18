package com.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.MarksheetBean;

import com.rays.model.MarksheetModel;

@WebServlet("/MarksheetListCtl.do")
public class MarksheetListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		try {

			List list = model.search(bean, 1, 5);
			request.setAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("MarksheetListView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		int pageNo = 1;
		int pageSize = 5;

		System.out.println("op ==" + op);
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

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

			}
			try {
				if (op.equals("search")) {
					bean.setName(request.getParameter("name"));

					bean.setRollno(Integer.parseInt(request.getParameter("rollno")));

				}
				
				
				
				if (op.equals("next")) {
					pageNo = (Integer.parseInt(request.getParameter("pageNo")));
					pageNo++;

				}
				
				
				
				if (op.equals("previous")) {
					pageNo = (Integer.parseInt(request.getParameter("pageNo")));
					pageNo--;

				}

				
				List list = model.search(bean, pageNo, pageSize);
				request.setAttribute("list", list);
				request.setAttribute("pageNo", pageNo);
			} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("MarksheetListView.jsp");
		rd.forward(request, response);

	}

}

