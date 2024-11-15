<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="FirstServlet">


		<table>



			<tr>
				<th>FirstName :</th>
				<td><input type="text" name="firstname"
					placeholder="enter first name"></td>
			</tr>

			<tr>
				<th>LastName:</th>
				<td><input type="text" name="lastname"
					placeholder="enter lastname"></td>

			</tr>

			<tr>
				<th>LoginId:</th>
				<td><input type="email" Name="username"
					placeholder="enter username"></td>
			</tr>


			<tr>
				<th>Password:</th>
				<td><input type="password" name="password"
					placeholder="enter password"></td>

			</tr>

			<tr>
				<th>Address:</th>
				<td><input type="text" name="address"
					placeholder="enter address"></td>
			</tr>

			<tr>
				<th>Date:</th>
				<td><input type="date" name="dob" placeholder="enter date"></td>
			</tr>

                <tr>
                <th></th>
                <td><input type="submit"></td>
                </tr>
		</table>
	</form>
</body>
</html>