<%@page import="com.rays.bean.StudentBean"%>
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
		StudentBean bean = (StudentBean) request.getAttribute("bean");
	%>


	<form action="StudentCtl.do" method="post">
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

				<h1>Update user</h1>

				<%
					} else {
				%>
				<h1>ADD Student</h1>

				<%
					}
				%>

				<tr>
					<td><input type="hidden" name="id"
						value="<%=bean != null ? bean.getid() : ""%>"></td>
				</tr>


				<tr>
					<th>FirstName:</th>
					<td><input type="text" name="FirstName"
						value="<%=bean != null ? bean.getFirstName() : ""%>"
						placeholder="enter first name"></td>
				</tr>
				<tr>
					<th>LastName:</th>
					<td><input type="text" name="LastName"
						value="<%=bean != null ? bean.getLastName() : ""%>"
						placeholder="enter last name"></td>
				</tr>
				<tr>
					<th>Date</th>
					<td><input type="date" name="dob"
						value="<%=bean != null ? bean.getDob() : ""%>"
						placeholder="enter dob"></td>
				</tr>
				
			
				
				<tr>
					<th>MobileNo:</th>
					<td><input type="text" name="mobileNo"
						value="<%=bean != null ? bean.getMobileNo() : ""%>"
						placehoder="enter mobile no"></td>
				</tr>
				
					<tr>
					<th>Email:</th>
					<td><input type="text" name="email"
						value="<%=bean != null ? bean.getEmail() : ""%>"
						placeholder="enter email"></td>
				</tr>

				<tr>
					<th>CollegeName:</th>
					<td><input type="text" name="CollegeName"
						value="<%=bean != null ? bean.getCollegeName() : ""%>"
						placeholder="enter collegename"></td>

				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=bean != null ? "update" : "save"%>"></td>

				</tr>
			</table>
		</center>


	</form>
	<%@include file="Footer.jsp"%>
</body>
</html>