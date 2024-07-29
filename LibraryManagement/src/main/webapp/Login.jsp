<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body {
	text-align: center;
}

td, th {
	padding-rigth: 5px;
	padding-left: 5px;
	padding-top: 5px;
	padding-bottom: 5px;
}



</style>


</head>

<body>
	<div>

		<form action="authentication" method="post">
			<table>
				<tr>
					<th></th>
					<td><h1>Login Page</h1></td>
				</tr>
				<tr>
					<th><lable>Enter User Name</lable></th>
					<td><input type="text" name="nm" id="userName"></td>
				</tr>
				<tr>
					<th><lable>Enter Password</lable></th>
					<td><input type="password" name="pass" id="userId"></td>
				</tr>
				<tr>
					<th class="sp"></th>
					<td><input type="submit" value="login"></td>
				</tr>
				<tr>
					<th></th>
					<td><a href="Register.jsp">Student Register Here</a></td>
				</tr>
			</table>
			
			
			<p name="test" value='<%=request.getParameter("Error")%>'></p>
			
			
					
			
			
			

			<%
			String error = request.getParameter("Error");
			System.out.println("Value Of Error " + error);
			if (error != null && error.equals("1")) {
			%>
			
			<p style="color: red;">Invalid userName.</p>
			<%
			} else if (error != null && error.equals("2")) {
			%>

			<p style="color: red;">Invalid Password.</p>

			<%
			} else if (error != null && error.equals("EmptyResult")) {
			%>
			<script>
			alert("invalid Password");
document.getElementById("userName").focus();

			</script>
			<%
			} else if (error != null && error.equals("invalidusernm")) {
				
				
			%>
		<script>

alert("invalid user name");
document.getElementById("userName").focus();
</script>
			<%
			} else if (error != null && error.equals("suspended")) {
			%>
			
			
						<script>
			alert("Account Deleted Please Contact admin or create new account");
document.getElementById("userName").focus();

			</script>
			<%
			}
			%>
			
		</form>
</body>
</html>