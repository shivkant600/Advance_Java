<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%=request.getParameter("firstName")%>
	<%=request.getParameter("lastName")%>
	<%=request.getParameter("UserName")%>
	<%=request.getParameter("password")%>
	<%=request.getParameter("address")%>
	<%=request.getParameter("Dob")%>
</body>
</html>