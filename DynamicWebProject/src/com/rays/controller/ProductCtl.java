package com.rays.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.rays.bean.ProductBean;
import com.rays.model.ProductModel;

@WebServlet("/ProductCtl.do")
public class ProductCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("ProductView.jsp");

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductBean bean = new ProductBean();
		ProductModel model = new ProductModel();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

		String Productname = request.getParameter("productName");

		String productPrice = request.getParameter("productPrice");

		String purchaseDate = request.getParameter("purchaseDate");

		bean.setProductname(Productname);
		bean.setProductprice(productPrice);
		try {
			bean.setPurchasedate(sdf.parse(purchaseDate));
			model.add(bean);
			request.setAttribute("bean", bean);
			request.setAttribute("msg", "data added succesfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("ProductView.jsp");
         rd.forward(request, response);
	}

}
