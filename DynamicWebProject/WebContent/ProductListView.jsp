
<%@page import="com.rays.bean.ProductBean"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
		List list = (List) request.getAttribute("list");
	%>

	<form action="ProductListCtl.do" method="post">

		<h1 align="center">productList</h1>


		<table border="1px" width="100%">

			<tr style="background: orange" align="center">
				<th>Delete</th>
				<th>ProductName</th>
				<th>ProductPrice</th>
				<th>PurchaseDate</th>
				<th>PurchaseCategory</th>
			</tr>

			<%
				Iterator it = list.iterator();
			%>



			<%
				while (it.hasNext()) {
					ProductBean bean = (ProductBean) it.next();
			%>

			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getProductname()%></td>
				<td><%=bean.getProductprice()%></td>
				<td><%=bean.getPurchasedate()%></td>
				<td><%=bean.getProductcategory()%></td>
			</tr>
			<%
				}
			%>


		</table>

		<tr>

			<td><input type="submit" name="operation" value="delete">
			<td>
		</tr>


	</form>
	<%@ include file="Footer.jsp"%>


</body>
</html>