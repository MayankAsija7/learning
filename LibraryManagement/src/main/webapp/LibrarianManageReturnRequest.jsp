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
<title>Insert title here</title>
</head>
<body>
<%
String st=(String)session.getAttribute("SessionUserName");
if(st!=null && !st.isEmpty()){ 
%>
<h1>Welcome <%=session.getAttribute("SessionUserName")%></h1>





<% 

ArrayList<Requests> RequestArrayList=new ArrayList<>();

fetchOne obj=new fetchOne();
RequestArrayList=obj.dispAllReturnRequest(); 

System.out.println("Array List Received "+RequestArrayList);

if(!RequestArrayList.isEmpty())
{
%>
<table>
<%for(int i=0;i<RequestArrayList.size();i++) 
{
%>
<tr>
<td><label><%=RequestArrayList.get(i).getRequestId()%></label></td>
<td><label><%=RequestArrayList.get(i).getStudentName()%></label></td>
<td><label><%=RequestArrayList.get(i).getRequestDate()%></label></td>
<td><label><%=RequestArrayList.get(i).getBookName()%></label></td>
<td>
    <form method="post" action="RequestMangeByLibrarianController">
        <input type="hidden" name="reqid" value="<%=RequestArrayList.get(i).getRequestId()%>">
        <input type="hidden" name="studentName" value="<%=RequestArrayList.get(i).getStudentName()%>">
                <input type="submit" name="btn" value="Accept Return">
                
    </form>	
</td>
</tr>
<% }%>
</table>
<%}
else
{
%>
<h1>No Open Pending Request</h1>
<button onclick="window.location.href='LibrarianHome.jsp'" name="HomeBtn">Back To Home</button>
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