<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ page import="java.util.*" %>
    <%@ page import ="java.sql.Date" %>
    <%@ page import="java.sql.*" %>
 <%@ page import ="java.util.ArrayList"%>

<%@ page import ="com.LibrarianMaster.Librarian"%>
<%@ page import ="com.LibrarianMaster.LibrarianMasterDaoImpl"%>
<%@ page import ="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  
LibrarianMasterDaoImpl LibrarianObj=new LibrarianMasterDaoImpl();
int id=Integer.parseInt(request.getParameter("LibrarianId"));
String name=request.getParameter("LibrarianNm");
String contNum=request.getParameter("LibrariancontNum");
String joiningDate=request.getParameter("LibrarianJoinDate");
String Address=request.getParameter("LibrarianAddress");
String email=request.getParameter("LibrarianEmail");
String password=request.getParameter("LibrarianPassword");

System.out.println("DataLog--------------->"+"Id : "+id+" Name : "+name+" : Password : "+password);
//response.sendRedirect("StudentMasterPage.jsp");
%>
<form action="Controller" method="post">
<table>


<tr>
<th>
Librarian Id
</th><td><lable value='<%=id%>'><%=id%></lable><input type="hidden" name="librarianId" value='<%=id%>'></td>
</tr>


<tr>
<th>
Librarian Name
</th><td><input type="text" name="librarianName" value='<%=name%>'></td>
</tr>
<tr>
<th>
Contact Number
</th><td><input type="text" name="librarianConNum" value='<%=contNum%>'></td>
</tr>



<tr>
<th>
Joining Date
</th><td><input type="date" name="joiningDate" value='<%=joiningDate%>'></td>
</tr>


<tr>
<th>
Address
</th><td><input type="text" name="librarianAddress" value='<%=Address%>'></td>
</tr>




<tr>
<th>
Email
</th><td><input type="text" name="librarianEmail" value='<%=email%>'></td>
</tr>

<tr>
<th>
Password
</th><td><input type="password" name="password" value='<%=password%>'></td>
</tr>


<tr>
<th>
</th><td><input type="submit" name="btn" value="Update Librarian"></td>
</tr>
</form>







</body>
</html>