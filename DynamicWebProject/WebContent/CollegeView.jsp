<%@page import="com.rays.bean.CollegeBean"%>
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
		CollegeBean bean = (CollegeBean) request.getAttribute("bean");
	%>

	<form action="CollegeCtl.do" method="post">
		<center>

			<table>




				<%
					String msg = (String) request.getAttribute("msg");
				%>

				<%
					if (msg != null) {
				%>
				<span><%=msg%></span>
				<%
					}
				%>
				<%
					if (bean != null) {
				%>
				<h1>update college student</h1>
				<%
					}else{
				%>


				<h1>ADD College stud</h1>


				<%} %>

				<tr>
					<td><input type="hidden" name="id"
						value="<%=bean != null ? bean.getId() : ""%>"></td>
				</tr>
				<tr>
					<th>Name</th>
					<td><input type="text" name="name"
						value="<%=bean != null ? bean.getName() : ""%>"></td>
				</tr>

				<tr>
					<th>Address</th>
					<td><input type="text" name="address"
						value="<%=bean != null ? bean.getAddress() : ""%>"></td>
				</tr>

				<tr>
					<th>State</th>
					<td><input type="text" name="state"
						value="<%=bean != null ? bean.getState() : ""%>"></td>
				</tr>

				<tr>
					<th>City</th>
					<td><input type="text" name="city"
						value="<%=bean != null ? bean.getCity() : ""%>"></td>
				</tr>

				<tr>
					<th>PhoneNo</th>
					<td><input type="text" name="phoneNo"
						value="<%=bean != null ? bean.getPhoneNo() : ""%>"></td>
				</tr>


			</table>

			<table>

				<td><input type="submit" name="operation"
					value="<%=bean != null ? "update" : "save"%>"></td>

			</table>
		</center>
	</form>

	<%@include file="Footer.jsp"%>

</body>
</html>