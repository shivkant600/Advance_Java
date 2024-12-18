package com.rays.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.ProductBean;
import com.rays.model.ProductModel;

@WebServlet("/ProductListCtl.do")
public class ProductListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();

		try {
			List list = model.search(bean);
			request.setAttribute("list", list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("ProductListView.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("operation");

		System.out.println("op======" + op);

		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();

		String[] ids = request.getParameterValues("ids");
 
		if (op.equals("delete")) {

			for (String id : ids) {
				try {
			
		
					model.delete(Integer.parseInt(id));
					
					List list = model.search(bean);
					request.setAttribute("list", list);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher rd = request.getRequestDispatcher("ProductListView.jsp");
				rd.forward(request, response);
			}
			
		}
	}

}
