<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import ="java.sql.Date" %>
<%@ page import="java.sql.*" %>
    <%@ page import ="java.util.ArrayList"%>
<%@ page import ="com.BookMaster.LibBook"%>
<%@ page import ="com.BookMaster.BookMasterDaoImpl"%>
<%@ page import ="java.util.List"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">



th, td {
  padding-top: 10px;
  padding-bottom: 10px;
  padding-left: 5px;
  padding-right: 5px;
}

</style>



</head>
<body>
<%  
BookMasterDaoImpl bookObj=new BookMasterDaoImpl();
int isbn=Integer.parseInt(request.getParameter("bookIsbn"));
String booksName=request.getParameter("bookName");
String booksAuthor=request.getParameter("bookAuthor");
String booksDescription=request.getParameter("bookDescription");
String booksGenre=request.getParameter("bookGenre");
String booksStatus=request.getParameter("bookStatus");

System.out.println("DataLog--------------->"+"Id : "+isbn+" Name : "+booksName);
//response.sendRedirect("StudentMasterPage.jsp");
%>
<form action="BookMasterPageController" method="post">
<table>


<tr>
<th>
Book Isbn
</th><td><lable value='<%=isbn%>'><%=isbn%></lable><input type="hidden" name="BookIsbn" value='<%=isbn%>'></td>
</tr>


<tr>
<th>
Book Name
</th><td><input type="text" name="BookName" value='<%=booksName%>'></td>
</tr>
<tr>
<th>
Book Author
</th><td><input type="text" name="bookAuthor" value='<%=booksAuthor%>'></td>
</tr>

<tr>
<th>
Book Description
</th><td><input type="text" name="bookDescription" value='<%=booksDescription%>'></td>
</tr>

<tr>
<th>
Book Genre
</th><td><input type="text" name="bookGenre" value='<%=booksGenre%>'></td>
</tr>

<%-- <tr>
<th>
Book Status
</th><td><input type="text" name="bookStatus" value='<%=booksStatus%>'></td>
</tr>
 --%>

<tr>
<th>
</th><td><input type="submit" name="btn" value="Update Book"></td>
</tr>
</form>







</body>
</html>