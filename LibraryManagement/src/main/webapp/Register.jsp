<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registeration</title>
</head>
<style type="text/css">
body
{
text-align:center;
}
form { 
margin: 0 auto; 
width:250px;
}
th, td {
  padding-top: 10px;
  padding-bottom: 10px;
  padding-left: 10px;
  padding-right: 10px;
}
.sp
{
  padding-top: 20px;
}
</style>
<body>
<h1>Registration From</h1>
<form method="post" action="StdentMasterController">
<table>

<tr><th class="sp">Name</th><td class="sp"><input type="text" name="name" required></td></tr>
<tr><th>Contact Number</th><td><input type="number" name="contactNo" minlength="10" maxlength="15" required></td></tr>
<tr><th>Address</th><td><input type="text" name="address" required></td></tr>
<tr><th>Email Adress</th><td><input type="email" name="email" id="emailId" required></td></tr>
<tr><th>Password</th><td><input type="password" name="password" minlength="8" required>
</td></tr>
<tr><th></th><td><input type="submit" value="Signup" name="SignupBtn">

<input type="button" value="go back" onclick="history.back()">

</td></tr>
</form>
<% 
if(request.getParameter("error") != null)
{
	
String errorcatched=request.getParameter("error");	

System.out.println("Value of Error : "+errorcatched);

if(errorcatched.equals("user_already_registered"))
{%>
<script>
alert("User Email Already Exist Plesae Try With Different Email");
document.getElementById("emailId").focus();

</script>
<%
}
}
%>
</body>
</html>