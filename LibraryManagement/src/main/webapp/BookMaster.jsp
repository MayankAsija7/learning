<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.util.ArrayList"%>

<%@ page import ="com.BookMaster.LibBook"%>
<%@ page import ="com.BookMaster.BookMasterDaoImpl"%>
<%@ page import ="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Master</title>
</head>


<body>

<form action="BookMasterDaoController" method="post">
<table>
<tr><th>Book Isbn</th><td><input type="number" name="isbnNum" required></td></tr>

<tr><th>Book Name</th><td><input type="text" name="bookName"></td></tr>

 <tr><tr><th>Book Author</th><td><input type="text" name="bookAuthor"></td></tr>
 
<tr><th>Book Description</th><td><input type="text" name="bookDescription"></td></tr>

<tr><th>Book Genre</th><td><input type="text" name="bookGenre"></td></tr>


<tr>
<th></th>
<td colspan="2"><input type="submit" name="BtnClick" value="Add Book"> 
<input type="submit" name="BtnClick" value="Display Book">
<input type="submit" name="BtnClick" value="Update Book">
<input type="submit" name="BtnClick" value="Delete Book"></td>
</tr>
</table>
</form>


<%
ArrayList<LibBook> studentAvailable=(ArrayList<LibBook>)request.getAttribute("BookData"); 
LibBook BkOb=new LibBook();
System.out.println(studentAvailable);
if(studentAvailable!=null && !studentAvailable.isEmpty())
{
%>
<table border="2px">
	<tr>
    <th>Isbn Number</th>
    <th>Author</th>
    <th>Name</th>
    <th>Description]</th>
    <th>Genre</th>
</tr>
	<%
	for(int i=0;i<studentAvailable.size();i++)
	{
		BkOb =studentAvailable.get(i);
		
%>

<tr>
<td><%=BkOb.getIsbn()%></td>
<td><%=BkOb.getName()%></td>
<td><%=BkOb.getAuthor()%></td>
<td><%=BkOb.getDescription()%></td>
<td><%=BkOb.getGenre()%></td>
</tr>

<%
}
	%>
	
	
	 </table>
	 
<%
}
%>

</form>

<%String error=request.getParameter("error");
System.out.println("Error occoured and printing Error : "+error);
if(error != null)
{
	%>
	
	<p style="color:red" align="center">Failed To Update book</p>
<%
}
%>

</table>
</body>
</html>