<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		UserBean userbean = (UserBean) session.getAttribute("user");
	%>

	<%
		if (userbean != null) {
	%>
	<h2><%="Hi, " + userbean.getFirstname()%></h2>
	<a href="UserCtl.do">Add User</a>|

	<a href="UserListCtl.do">User List</a>|
	<a href="MarksheetCtl.do">ADD Marksheet User</a>|
	<a href="MarksheetListCtl.do">Marksheet List</a>|
	<a href="WelcomeCtl">Welcome</a>
	<a href="LoginCtl?operation=logout">logout</a>

	<%
		} else {
	%>




	<h2>Hi, Guest</h2>
	<a href="UserRegistrationCtl">SignUp</a> |
	<a href="LoginCtl">login</a> |

	<a href="WelcomeCtl">Welcome</a>

	<%
		}
	%>

	<hr>

</body>
</html>