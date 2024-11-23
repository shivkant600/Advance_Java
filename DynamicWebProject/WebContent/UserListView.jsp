<%@page import="com.rays.bean.UserBean"%>
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
	<% pageNo = (int)request.getAttribute("pageNo");%>
	<%
		}
	%>



	<form action="UserListCtl.do" method="post">

		<h1 align="center">User List</h1>

		<table>
			<th>First Name</th>
			<td><input type="text" name="firstName"
				placeholder="Enter First Name"></td> &nbsp;

			<th>Last Name</th>
			<td><input type="text" name="lastName"
				placeholder="Enter Last Name"></td> &nbsp;

			<th>Loginid</th>
			<td><input type="text" name="loginId"
				placeholder="enter loginid"></td> &nbsp;

			<th>address</th>
			<td><input type="text" name="address"
				placeholder="enter address"></td> &nbsp;

			<th>date</th>
			<td><input type="date" name="dob" placeholder="enter dob"></td>&nbsp;


			<th></th>
			<td><input type="submit" name="operation" value="search"></td>
		</table>

		<br>

		<table border="1px" width="100%">


			<tr style="background: pink">
				<th>Delete</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>LoginId</th>
				<th>Address</th>
				<th>DOB</th>
				<th>Edit</th>
			</tr>

			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>
			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=bean.getFirstname()%></td>
				<td><%=bean.getLastname()%></td>
				<td><%=bean.getLoginid()%></td>
				<td><%=bean.getAddress()%></td>
				<td><%=bean.getDob()%></td>
				<td><a href="UserCtl.do?id=<%=bean.getId()%>">Edit</a></td>
			</tr>
			<%
				}
			%>
		</table>
		<br>
		<table width="100%">
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
	<%@ include file="Footer.jsp"%>
</body>