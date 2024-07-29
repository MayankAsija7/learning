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
<title>Insert title here</title>
</head>
<%LibrarianMasterDaoImpl librarianObj= new LibrarianMasterDaoImpl(); 
int maxId= librarianObj.fetchMax();
%>
<body>
<table>
<form action="LibrarianMasterController" method="post"> 
 <tr><th>Id</th><td><input type="number" name="libId" value='<%=maxId%>'required></td></tr>
  <tr><th>Name</th><td><input type="text" name="libName"></td></tr>
  <tr><th>Contact Number</th><td><input type="number" name="contNum"></td></tr>
   <tr><th>Joining Date</th><td><input type="date" name="jDate"></td></tr>
   <tr><th>Address</th><td><input type="text" name="address"></td></tr>
   <tr><th> Email</th><td><input type="email" name="email"></td></tr>
  <tr><th>Password</th><td><input type="password" name="password"></td></tr>
<table>
<tr>  
 <th></th><td><input type="submit" name="BtnClick" value="Add Librarian"></td>
 <th></th><td><input type="submit" name="BtnClick" value="Display Librarian"></td>
 <th></th><td><input type="submit" name="BtnClick" value="Update Librarian"></td>
 <th></th><td><input type="submit" name="BtnClick" value="Delete Librarian"></td>
</tr>
</table>
</table><br><br>
<% 
 ArrayList<Librarian> LibrarianAvailable=(ArrayList<Librarian>)request.getAttribute("LibrarianData"); 
if(LibrarianAvailable!=null && !LibrarianAvailable.isEmpty())
{%>
<table border="2px">
	<tr>
    <th>Id</th>
    <th>Name</th>
    <th>Contact Number</th>
    <th>Joining Date</th>
    <th>Address</th>
    <th>Email</th>
</tr>
	<%
	for(int i=0;i<LibrarianAvailable.size();i++)
	{
		Librarian LbOb =LibrarianAvailable.get(i);
		
%>

<tr>
<td><%=LbOb.getLibId()%></td>
<td><%=LbOb.getLibName()%></td>
<td><%=LbOb.getLibContNum()%></td>
<td><%=LbOb.getLibJoinDate()%></td>
<td><%=LbOb.getLibAddress()%></td>
<td><%=LbOb.getLibEmail()%></td>
</tr>
<%
}
	%> </table><%
}
%>
<%
String LbAvailable=request.getParameter("LibrarianAvailable"); %>
  
  </form>
</body>
</html>