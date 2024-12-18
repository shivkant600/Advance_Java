<%@page import="com.rays.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="Header.jsp"%>

	<%
		ProductBean bean = (ProductBean) request.getAttribute("bean");
	%>




	<center>
		<form action="ProductCtl.do" method="post">

			<%
				String msg = (String) request.getAttribute("msg");
			%>
			<%
				if (msg != null) {
			%>
			<span style="color: red"><%=msg%></span>
			<%
				}
			%>

			<table>

				<h1 align="center">Product Add</h1>

				<tr>
					<th>Product Name :</th>
					<td><input type="text" name="productName"
						placeholder="enter product name"></td>
				</tr>


				<tr>
					<th>Product Price :</th>
					<td><input type="text" name="productPrice"
						placeholder="enter product price"></td>
				</tr>

				<tr>
					<th>Purchase Date</th>
					<td><input type="date" name="purchaseDate"
						placeholder="enter purchase date"></td>
				</tr>

				<tr>

					<th>Product Category</th>
					<td><input type="text" name="productCategory"
						placeholder=" enter productCategory"></td>
				</tr>


				<tr>
					<td><input type="submit"></td>
				</tr>

			</table>
		</form>
	</center>
	<%@ include file="Footer.jsp"%>

</body>
</html>