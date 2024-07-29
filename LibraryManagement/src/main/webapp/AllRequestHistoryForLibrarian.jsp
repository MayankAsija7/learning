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
  padding-right: 5px;
}

</style>
</head>
<body>
<%
String st=(String)session.getAttribute("SessionUserName");
if(st!=null && !st.isEmpty()){ 
%>
<h1>Welcome <%=session.getAttribute("SessionUserName")%></h1>

<%ArrayList<Requests> RequestArrayList=new ArrayList<>();
 fetchOne obj=new fetchOne();
 RequestArrayList=(ArrayList<Requests>)request.getAttribute("sortByDate");
RequestArrayList=obj.dispAllRequest();


ArrayList<Requests> sample=(ArrayList<Requests>)request.getAttribute("sortByDate");

System.out.println("Here Sample ArrayList Received"+sample);
if(request.getAttribute("sortByDate") !=null)
{
	System.out.println("Here Data Sorted********************************************");
	System.out.println("Here In Sorted");
	RequestArrayList=(ArrayList<Requests>)request.getAttribute("sortByDate");

}
System.out.println("Array List Received "+RequestArrayList);

if(!RequestArrayList.isEmpty())
{
%>
<div id="tb">
<table>
<tr><form method="post" action="Controller">
<th>
From
</th>
<td><input type="date" name="fromDate"></td>
<th>To</th><td><input type="date" name="toDate"></td>
<td><input type="submit" name="btn" value="Apply Filter"></td>
</form>
</tr>
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
<button onclick="window.location.href='LibrarianHome.jsp'" name="HomeBtn">Back To Home</button>
<%}
else
{
%>
<h1>No Request History Found</h1>

<% }%>


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