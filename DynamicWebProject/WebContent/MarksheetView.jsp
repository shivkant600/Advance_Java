<%@page import="com.rays.bean.MarksheetBean"%>
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
		MarksheetBean bean = (MarksheetBean) request.getAttribute("bean");
	%>

	<center>


		<form action="MarksheetCtl.do" method="post">


			<%
				String msg = (String) request.getAttribute("msg");
			%>


			<%
				if (msg != null) {
			%>

			<span style="color: green"> <%=msg%></span>

			<%
				}
			%>

			
			<%
				if (bean != null) {
			%>



			<h1>Update Marksheet</h1>



			<%
				} else {
			%>


			<h1>Add Marksheet</h1>
			<%
				}
			%>

			<table>



				<td><input type="hidden" name="id"
					value="<%=bean != null ? bean.getId() : ""%>"></td>


				<tr>
					<th>roll no:</th>
					<td><input type="text" name="rollno"
						value="<%=bean != null ? bean.getRollno() : ""%>"
						placeholder="enter roll no"></td>
				</tr>
				<tr>
					<th>name:</th>
					<td><input type="text" name="name"
						value="<%=bean != null ? bean.getName() : ""%>"
						placeholder="enter name"></td>
				</tr>

				<tr>
					<th>physics:</th>
					<td><input type="text" name="physics"
						value="<%=bean != null ? bean.getPhysics() : ""%>"
						placeholder="enetr physics no"></td>
				</tr>

				<tr>
					<th>Chemistry:</th>
					<td><input type="text" name="chemistry"
						value="<%=bean != null ? bean.getChemistry() : ""%>"
						placeholder="enter chemistry marks"></td>
				</tr>

				<tr>
					<th>Maths:</th>
					<td><input type="text" name="maths"
						value="<%=bean != null ? bean.getMaths() : ""%>"
						placeholder="enter maths marks"></td>

				</tr>
				<tr>
					<th></th>
					<td><input type="Submit" name="operation"
						value="<%=bean != null ? "update" : "save"%>"></td>

				</tr>

			</table>
		</form>
	</center>

</body>
</html>