<%@page import="com.rays.bean.CollegeBean"%>
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


	<form action="CollegeListCtl.do" method="post">


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

		<h1 align="center">College List</h1>

		<table>
			<tr>
				<th>Name :</th>
				<td><input type="text" name="name" placeholder="enter name"></td>&nbsp;
				<th>Address:</th>
				<td><input type="text" name="address"
					placeholder="enter address"></td>&nbsp;
				<th>State :</th>
				<td><input type="text" name="state" placeholder="enter state"></td>&nbsp;
				<th></th>
				<td><input type="submit" name="operation" value="search"></td>

			</tr>



		</table>

		<center>
			<table border=1px width="100%" cellspacing=10 cellpadding=20>
				<thead bgcolor="blue">
					<tr align="center">
						<th>Delete</th>
						<th>Name</th>
						<th>Address</th>
						<th>State</th>
						<th>City</th>
						<th>PhoneNo</th>
						<th>Edit</th>
					</tr>
				</thead>
				<%
					Iterator it = list.iterator();
				%>


				<%
					while (it.hasNext()) {
						CollegeBean bean = (CollegeBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" name="ids"
						value="<%=bean.getId()%>"></td>
					<td><%=bean.getName()%></td>
					<td><%=bean.getAddress()%></td>
					<td><%=bean.getState()%></td>
					<td><%=bean.getCity()%></td>
					<td><%=bean.getPhoneNo()%></td>
					<td><a href="CollegeCtl.do?id=<%=bean.getId()%>">Edit</a></td>

				</tr>

				<%
					}
				%>
			</table>
		</center>
		<table width="100%">
			<tr>
				<td align="left"><input type="submit" name="operation"
					value="previous" <%=(pageNo == 1) ? "disabled" : ""%>></td>


				<td><input type="submit" name="operation" value="delete"></td>


				<td align="right"><input type="submit" name="operation"
					value="next" <%=list.size() == 0 ? "disabled" : ""%>></td>
			</tr>
		</table>
		<td><input type="hidden" name="pageNo" value="<%=pageNo%>"></td>

	</form>
	<%@include file="Footer.jsp"%>
</body>
</html>