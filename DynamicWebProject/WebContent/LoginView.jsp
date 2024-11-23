
<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
	<%@ include file="Header.jsp"%>


	<center>
		<form action="LoginCtl" method="post">

			<br> <br> <br>

			<%
				String msg = (String) request.getAttribute("msg");
				String err = (String) request.getAttribute("err");
			%>

			<%
				if (msg != null) {
			%>
			<span style="color: green"><%=msg%></span>
			<%
				}
			%>

			<%
				if (err != null) {
			%>
			<span style="color: red"><%=err%></span>
			<%
				}
			%>

			<h1>Login</h1>



			<table>



				<tr>


					<th>LoginId:</th>
					<td><input type="email" name="loginId"
						placeholder="Enter your LoginId"></td>
				</tr>
				<tr>
					<th>password:</th>
					<td><input type="password" name="password"
						placeholder="Enter your Password"></td>
				</tr>


				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="SignIn"></td>

				</tr>

			</table>
		</form>
	</center>
	<%@ include file="Footer.jsp"%>
</body>
</html>