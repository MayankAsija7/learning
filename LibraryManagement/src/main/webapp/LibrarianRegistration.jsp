<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.util.ArrayList"%>

<%@ page import ="com.LibrarianMaster.Librarian"%>
<%@ page import ="com.LibrarianMaster.LibrarianMasterDaoImpl"%>

<%@ page import ="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Librarian Registeration</title>
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
<h1>Librarian Registration From</h1>
<%LibrarianMasterDaoImpl librarianObj= new LibrarianMasterDaoImpl(); 
int maxId= librarianObj.fetchMax();
%>
<form method="post" action="Controller">
<table>

<tr><th class="sp">Librarian Id</th><td class="sp"><lable><%=maxId%></lable><input type="hidden" name="libId" value='<%=maxId%>'></td></tr>
<tr><th>Librarian Name</th><td><input type="text" name="libName" required></td></tr>
<tr><th>Contact Number</th><td><input type="number" name="contNum" minlength="10" maxlength="15" required></td></tr>
<tr><th>Joining Date</th><td><input type="date" name="jDate" required></td></tr>
<tr><th>Address</th><td><input type="text" name="address" required></td></tr>
<tr><th>Email Id</th><td><input type="email" name="email" required></td></tr>
<tr><th>Password</th><td><input type="password" name="password" minlength="8" required></td></tr>
<tr><th></th><td><input type="submit" value="Add Librarian" name="btn"></td></tr>
<tr><th></th><td><input type="button" value="Go Back" onclick="history.back()"></td></tr>
</form>
<%

if(request.getParameter("error") !=null)
{
	System.out.println("error : "+request.getParameter("error"));
	String errorStatus=request.getParameter("error");
	if(errorStatus.equals("librarian_already_exist"))
	{
		%>
		
	<script>
alert("Email Id Aready Registered Please Different Email id");
		</script>
	
		
<%	}
}
%>
</body>
</html>