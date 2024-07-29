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
body
{
text-align:center;
}


th, td {
  padding-top: 5px;
  padding-bottom: 5px;
  padding-left: 5px;
  padding-right: 5px;
}

</style>
</head>
<body>
<%
String st=(String)session.getAttribute("mailInSession");
if(st!=null && !st.isEmpty()){ 
	BookMasterDaoImpl BooksObject=new BookMasterDaoImpl();
ArrayList<LibBook> BookArrayList=new ArrayList<LibBook>(); 
BookArrayList =BooksObject.findAllBook();
%>
<table>
<tr>
<th colspan="5">
<h1>Welcome <%=session.getAttribute("username")%></h1>
</th>
</tr>
<%if(BookArrayList.isEmpty()){%>
<tr>
<th></th><td><p>No Book Found</p></td>
</tr>
<%}
else
{
	if(BookArrayList==null)
	{%>
		<tr><th></th><td><p style="color:red">Something Went Wrong!!!</p></td>
<%}
	else
	{
	%>
	<tr><th>Book Isbn</th><th>Book Name</th><th>Book Author</th><th>Book Description</th><th>Book Genre</th><th>Book Status</th>
	<%	
	for(int i=0;i<BookArrayList.size();i++)
	{
%>
<tr>


<td><%=BookArrayList.get(i).getIsbn()%></td>

<td><%=BookArrayList.get(i).getName()%></td>

<td><%=BookArrayList.get(i).getAuthor()%></td>

<td><%=BookArrayList.get(i).getDescription()%></td>

<td><%=BookArrayList.get(i).getGenre()%></td>

<td><%=BookArrayList.get(i).getStatus()%></td>


<td><form action="bookUpdation.jsp" method="post">

<input type="hidden" name="bookIsbn" value="<%=BookArrayList.get(i).getIsbn()%>">
<input type="hidden" name="bookName" value="<%=BookArrayList.get(i).getName()%>">
<input type="hidden" name="bookAuthor" value="<%=BookArrayList.get(i).getAuthor()%>">
<input type="hidden" name="bookDescription" value="<%=BookArrayList.get(i).getDescription()%>">
<input type="hidden" name="bookGenre" value="<%=BookArrayList.get(i).getGenre()%>">
<input type="hidden" name="bookStatus" value="<%=BookArrayList.get(i).getStatus()%>">
<input type="submit" name="BtnClick" value="Update">
</form>






<form form action="BookMasterPageController" method="post"> 
<input type="hidden" name="isbn" value="<%=BookArrayList.get(i).getIsbn()%>">
<input type="submit" name="btn" value="Delete Book">
</form></td>
</tr>
<%}}}%>

<tr>
<th><th>
<td>
<a name="addbook" href="addBook.jsp"><button>Add Book</button></a></td>
<td>
<a name="Deleted" href="booksDeleted.jsp"><button>Deleted Books</button></a>
</td>
</tr>
<tr>
<td colspan="6"><form action="lgout" method="post">
<input type="submit" value="Logout">
<input type="button" value="go back" onclick="history.back()">
</form>
</td>
</tr>
</table>

<% }%>
</body>
</html>