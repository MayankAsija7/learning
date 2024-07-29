<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import ="java.sql.Date" %>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.StudentMaster.StudentDao" %>
    <%@ page import="com.StudentMaster.StudentDaoImp" %>
    <%@ page import="com.StudentMaster.Student" %>
        <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  
StudentDaoImp StObj=new StudentDaoImp();
int id=Integer.parseInt(request.getParameter("studentId"));
String name=request.getParameter("studentNm");
String contNum=request.getParameter("contNum");
String Adrs=request.getParameter("address");
String email=request.getParameter("email");
String password=request.getParameter("password");

System.out.println("DataLog--------------->"+"Id : "+id+" Name : "+name+" : Password : "+password);
//response.sendRedirect("StudentMasterPage.jsp");
%>
<form action="StudentMasterPageController" method="post">
<table>


<tr>
<th>
Student Id
</th><td><lable value='<%=id%>'><%=id%></lable><input type="hidden" name="StudentId" value='<%=id%>'></td>
</tr>


<tr>
<th>
Student Name
</th><td><input type="text" name="StudentName" value='<%=name%>'></td>
</tr>
<tr>
<th>
Contact Number
</th><td><input type="text" name="StudentConNum" value='<%=contNum%>'></td>
</tr>

<tr>
<th>
Address
</th><td><input type="text" name="StudentAddress" value='<%=Adrs%>'></td>
</tr>

<tr>
<th>
Email
</th><td><input type="text" name="StudentEmail" value='<%=email%>'></td>
</tr>

<tr>
<th>
Password
</th><td><input type="password" name="password" value='<%=password%>'></td>
</tr>


<tr>
<th>
</th><td><input type="submit" name="btn" value="Update Student"></td>
</tr>
</form>







</body>
</html>