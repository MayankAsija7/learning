<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.lang.*"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="com.RequestMaster.Requests"%>
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
</style>
</head>

<body> 

<table>

  <form action="RequestController" method="post"> 
 <tr><th>Request Id</th><td><input type="number" name="requestId"></td></tr>
  <tr><th>Student Id</th><td><input type="number" name="studentId" required></td></tr>
  <tr><th>Request Status</th><td><input type="text" name="requestStatus"></td></tr>
  <tr><th>Request Date</th><td><input type="Date" name="requestDate"></td></tr>
 <tr><th>Request Remark</th><td><input type="text" name="requestRemark"></td></tr>
 <!--  <tr><th>Book Return Date</th><td><input type="Date" name="bookReturnDate"></td></tr> -->
<table>
<tr>  
 <!-- <th></th><td><input type="submit" name="BtnClick" value="Request Book"></td> -->
 <th></th><td><input type="submit" name="BtnClick" value="Display Request"></td>
 <th></th><td><input type="submit" name="BtnClick" value="Update Request"></td>
 <th></th><td><input type="submit" name="BtnClick" value="Delete Request"></td>
</tr>
</table>
</table><br><br>
<% 
 ArrayList<Requests> requestAvailable=(ArrayList<Requests>)request.getAttribute("RequestData"); 

System.out.println(requestAvailable);
if(requestAvailable!=null && !requestAvailable.isEmpty())
{%>
<table border="2px">
	<tr>
    <th>Request Id</th>
    <th>Student Id</th>
    <th>Request Status</th>
    <th>Request Date</th>
    <th>Remark</th>
    <th>Book Return Date</th>
</tr>
	<%
	for(int i=0;i<requestAvailable.size();i++)
	{
		Requests RqOb =requestAvailable.get(i);
		
%>

<tr>
<td><%=RqOb.getRequestId()%></td>
<td><%=RqOb.getStudentId()%></td>
<td><%=RqOb.getRequestStatus()%></td>
<td><%=RqOb.getRequestDate()%></td>
<td><%=RqOb.getRemark()%></td>
<td><%=RqOb.getBookReturnDate()%></td>

</tr>

<%
}
	%> <%
}
%>
  
  </form>
  </table>
</body>
</html>