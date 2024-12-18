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
		int pageNo = 1;
	%>
	<%
		if (request.getAttribute("pageNo") != null) {
	%>
	<%
		pageNo = (int) request.getAttribute("pageNo");
	%>
	<%
		}
	%>


	<form action="MarksheetListCtl.do" method="post">
		<h1 align="center">Marksheet List</h1>

		<table>
			<th>ROll No:</th>
			<td><input type="text" name="rollno" placeholder="enter roll no"></td>&nbsp;

			<th>Name:</th>
			<td><input type="text" name="name" placeholder="enter name"></td>&nbsp;

			<th></th>
			<td><input type="submit" name="operation" value="search"></td>

			<br>

		</table>



		<table border="1px" width="100%">

			<tr style="background: red" align="center">
				<th>Delete</th>
				<th>RollNo</th>
				<th>Name</th>
				<th>physics</th>
				<th>chmemistry</th>
				<th>maths</th>
				<th>Total</th>
				<th>percentage</th>
				<th>Edit</th>
			</tr>

			<%
				Iterator it = list.iterator();
			%>

			<%
				while (it.hasNext()) {
					MarksheetBean bean = (MarksheetBean) it.next();
			%>


			<%
				int total = (bean.getPhysics() + bean.getChemistry() + bean.getMaths());
					double p = (total / 3);
			%>
			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getRollno()%></td>
				<td><%=bean.getName()%></td>
				<td><%=bean.getPhysics()%></td>
				<td><%=bean.getChemistry()%></td>
				<td><%=bean.getMaths()%></td>
				<td><%=total%></td>
				<td><%=p +"%"%></td>
				<td><a href="MarksheetCtl.do?rollno=<%=bean.getRollno()%>">Edit</a></td>
			</tr>

			<%
				}
			%>

		</table>
		<br>

		<table width=100%>

			<tr>

				<td align="left"><input type="submit" name="operation"
					value="previous" <%=(pageNo == 1) ? "disabled" : ""%>></td>

				<td><input type="submit" name="operation" value="delete"></td>

				<td align="right"><input type="submit" name="operation"
					value="next" <%=list.size() == 0 ? "disabled" : ""%>></td>
			</tr>


		</table>

		<input type="hidden" name="pageNo" value="<%=pageNo%>">

	</form>
	<%@include file="Footer.jsp"%>


</body>
</html>