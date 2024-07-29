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

</style>
</head>
<body>
<%
String st=(String)session.getAttribute("SessionUserName");
if(st!=null && !st.isEmpty()){ 
%>
<h1>Welcome <%=session.getAttribute("SessionUserName")%></h1>	
<a href="LibrarianManageRequest.jsp">Requested Books Manage</a><br><br>
<a href="LibrarianManageReturnRequest.jsp">Return Requested Books Manage</a><br><br>
<a href="AllRequestHistoryForLibrarian.jsp">All Requests History</a><br><br>
<a href="addBook.jsp">Add Books</a><br><br>
<a href="Register.jsp">Add Student</a>
<br><br>
<form method="post" action="lgout">
<input type="submit" name="logoutBtn" value="Logout">
</form>
<%
}
else
{
%>	
<a href="Login.jsp">Please Login to Continue</a><br>
<%
}
%>





</body>
</html>