<%@page import="com.rays.bean.MarksheetBean"%>
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


	<form action="MarksheetListCtl.do" method="post">
		<h1 align="center">Marksheet List</h1>



		<table border="1px" width="100%">

			<tr style="background: red">
				<th>Delete</th>
				<th>RollNo</th>
				<th>Name</th>
				<th>physics</th>
				<th>chmemistry</th>
				<th>maths</th>
			</tr>

			<%
				Iterator it = list.iterator();
			%>

			<%
				while (it.hasNext()) {
					MarksheetBean bean = (MarksheetBean) it.next();
			%>

			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getRollno()%></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getPhysics()%></td>
				<td><%=bean.getChemistry()%></td>
				<td><%=bean.getMaths()%></td>
			</tr>

			<%
				}
			%>

		</table>
		<br>

		<table width=100%>

			<tr>
				<td><input type="submit" name="operation" value="delete"></td>


			</tr>


		</table>
	</form>
	<%@include file="Footer.jsp"%>


</body>
</html>