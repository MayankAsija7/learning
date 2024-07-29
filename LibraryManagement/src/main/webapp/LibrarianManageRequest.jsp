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
<style type="text/css">

.lft{

padding-top:10px;

}



</style>

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
RequestArrayList=obj.dispAll(); 

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
<td><label><%=RequestArrayList.get(i).getBookStatus()%></label></td>
<td>
    <form method="post" action="RequestMangeByLibrarianController">
        <input type="hidden" name="reqid" value="<%=RequestArrayList.get(i).getRequestId()%>">
        <input type="hidden" name="studentName" value="<%=RequestArrayList.get(i).getStudentName()%>">
        <%if(RequestArrayList.get(i).getBookStatus().equals("Available")) 
        {%>
        <input type="submit" name="btn" value="Accept">
        <input type="submit" name="btn" value="deny">
        <%}
        else
        {
        %>
        <input type="submit" name="btn" value="Accept" disabled>
         <input type="submit" name="btn" value="deny" disabled><lable style="color:red">Unable to process book not available</lable>
        <% }%>
       
    </form>	
</td>
</tr>

<% }%>
<tr>
<th></th><td colspan="5" align="center" class="lft"><button onclick="window.location.href='LibrarianHome.jsp'">Back To Home</button></td>
</tr>
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