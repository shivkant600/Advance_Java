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
	<center>
	
	 <% String msg = (String) request.getAttribute("msg");%>
       <%if(msg != null){ %>
       
     <span style="color: green">  <%=msg %></span>
       
       <%} %>
       
	
		<h1>Add marksheet</h1>
		<form action="MarksheetCtl.do" method="post">

      

			<table>
				<tr>
					<th>roll no:</th>
					<td><input type="text" name="rollno"
						placeholder="enter roll no"></td>
				</tr>
				<tr>
					<th>name:</th>
					<td><input type="text" name="name" placeholder="enter name"></td>
				</tr>

				<tr>
					<th>physics:</th>
					<td><input type="text" name="physics"
						placeholder="enetr physics no"></td>
				</tr>

				<tr>
					<th>Chemistry:</th>
					<td><input type="text" name="chemistry"
						placeholder="enter chemistry marks"></td>
				</tr>

				<tr>
					<th>Maths:</th>
					<td><input type="text" name="maths"
						placeholder="enter maths marks"></td>

				</tr>
				<tr>
					<th></th>
					<td><input type="Submit" ></td>

				</tr>

			</table>
		</form>
	</center>

</body>
</html>