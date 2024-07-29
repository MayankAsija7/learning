<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import ="java.sql.Date" %>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.RequestMaster.*" %>
    <%@ page import="com.RequestMaster.Requests" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Requests</title>
<style type="text/css">
body
{
text-align:center;
}

.center {
  margin-left: auto;
  margin-right: auto;
}
th, td {
  padding-top: 10px;
  padding-bottom: 10px;
  padding-left: 10px;
  padding-right: 10px;

}


#tableStyle{
border-style:solid;
border-width:1px;

}
</style>
</head>
<body>
<%ArrayList<Requests> RequestArrayList=new ArrayList<>();
 fetchOne obj=new fetchOne();

RequestArrayList=obj.dispAllRequest();
System.out.println("Array List Received "+RequestArrayList);

if(!RequestArrayList.isEmpty())
{
%>
<div id="tb">
<table id="tableStyle">
<%for(int i=0;i<RequestArrayList.size();i++) 
{
%>
<tr>
<td><label><%=RequestArrayList.get(i).getRequestId()%></label></td>
<td><label><%=RequestArrayList.get(i).getStudentName()%></label></td>
<td><label><%=RequestArrayList.get(i).getRequestDate()%></label></td>
<td><label><%=RequestArrayList.get(i).getBookName()%></label></td>
<td><label><%=RequestArrayList.get(i).getRequestStatus()%></label></td>
</tr>
<% }%>
</table>
</div>
<br>
<button onclick="window.location.href='AdminHome.jsp'" name="back button">Back To Home</button>
<%}
else
{
%>
<h1>No Request History Found</h1>

<% }%>
</body>
</html>