<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Panel</title>
<style type="text/css">
body {
    text-align: center;
}
sessionOutError{
	display: flex;
	flex-direction: column;
	justify-content: center;
	text-align: center;
}
</style>
</head>
<body>
<%
String st=(String)session.getAttribute("mailInSession");
if(st!=null && !st.isEmpty()){ 
%>
<h1>Welcome <%=session.getAttribute("username")%></h1>

<a href="StudentMasterPage.jsp" name="StudentMaster" style="text-decoration:none">Click To Open Student Master</a><br><br>
<a href="BookMasterPage.jsp" name="BookMaster" style="text-decoration:none">Click to Open Book Master</a><br><br>
<a href="LibrarianMasterPage.jsp" name="LibraryMaster" style="text-decoration:none">Click To Open Librarian Master</a><br><br>
<a href="adminRequestView.jsp" name="RequestMaster" style="text-decoration:none">Click To Open Request Master</a><br><br>
<form action="lgout" method="post">
<input type="submit" value="Logout">
</form>
<%
}
else
{
%>

<a href="Login.jsp" id="sessionOutError">Please Login to continue</a>

<%
}
%>








</body>
</html>