<%@page import="com.rays.bean.StudentBean"%>
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
	<%  if(request.getAttribute("pageNo") != null) {%>
	
	<% pageNo=(int) request.getAttribute("pageNo"); %>
	
	<%} %>


	<form action="StudentListCtl.do" method="post">



		<h1 align="center">Student List</h1>
		<table>
			<th>FirstName</th>
			<td><input type="text" name="firstName"
				placeholder="enter firstname"></td> &nbsp;

			<th>LastName</th>
			<td><input type="text" name="lastName"
				placeholder="enter lastName"></td> &nbsp;

			<th>Email</th>
			<td><input type="email" name="email" placeholder="enter email"></td>
			&nbsp;


			<th></th>
			<td><input type="submit" name="operation" value="search"></td>

		</table>






		<table border="1px" width="100%">
			<tr style="background: blue" align="center">
				<th>Delete</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Date</th>
				<th>MobileNO</th>
				<th>Email</th>
				<th>CollegeName</th>
				<th>Edit</th>

			</tr>
			<%
				Iterator it = list.iterator();
			%>
			<%
				while (it.hasNext()) {
					StudentBean bean = (StudentBean) it.next();
			%>
			<tr align="center">
				<td><input type="checkbox" name="ids" value="<%=bean.getid()%>"></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=bean.getMobileNo()%></td>
				<td><%=bean.getEmail()%></td>
				<td><%=bean.getCollegeName()%></td>
				<td><a href="StudentCtl.do?id=<%=bean.getid()%>">Edit</a>
			</tr>
			<%
				}
			%>
		</table>
		<br>
		<table width="100%">
			<tr>
				<td align="left"><input type="submit" name="operation"
					value="previous" <%=pageNo == 1 ? "disabled" : ""%>></td>
				<td align="center"><input type="submit" name="operation"
					value="delete"></td>
				<td align="right"><input type="submit" name="operation"
					value="next" <%=list.size() == 0 ? "disabled" : ""%>></td>


			</tr>
		</table>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>
	<%@ include file="Footer.jsp"%>

</body>
</html>