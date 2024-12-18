<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
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
	<a href="StudentCtl.do">Student Add</a>|
	<a href="StudentListCtl.do">Student List</a>|
	<a href="CollegeCtl.do">College Add</a>|
	<a href="CollegeListCtl.do">College List View</a>|
	<a href="ProductCtl.do">prodcut Add</a>|
	<a href="ProductListCtl.do">Product List View</a>|
	<a href="WelcomeCtl">Welcome</a>|
	<a href="LoginCtl?operation=logout">logout</a>|

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