package com.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.MarksheetBean;
import com.rays.model.MarksheetModel;

@WebServlet("/MarksheetCtl.do")
public class MarksheetCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String rollno = request.getParameter("rollno");

		System.out.println("rollno" + rollno);

		MarksheetModel model = new MarksheetModel();
		MarksheetBean bean = new MarksheetBean();
		if (rollno != null) {

			try {
				bean = model.findbyROllno(Integer.parseInt(rollno));

				request.setAttribute("bean", bean);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("MarksheetView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");
		System.out.println("op==" + op);
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		String rollno = request.getParameter("rollno");
		String name = request.getParameter("name");
		String physics = request.getParameter("physics");
		String chemistry = request.getParameter("chemistry");
		String maths = request.getParameter("maths");
		try {
			bean.setRollno(Integer.parseInt(rollno));
			bean.setName(name);
			bean.setPhysics(Integer.parseInt(physics));
			bean.setChemistry(Integer.parseInt(chemistry));
			bean.setMaths(Integer.parseInt(maths));

			if (op.equals("save")) {

				model.add(bean);

				request.setAttribute("msg", "data added succesfully");
			}

			else if (op.equals("update")) {
				System.out.println("idddd");
				bean.setId(Integer.parseInt(request.getParameter("id")));

				request.setAttribute("bean", bean);
				model.update(bean);
				request.setAttribute("msg", "data update succesfully");

			}

			RequestDispatcher rd = request.getRequestDispatcher("MarksheetView.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
