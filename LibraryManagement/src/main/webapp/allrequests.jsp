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
body {
    text-align: center;
    
}
.center {
  margin-left: auto;
  margin-right: auto;
}
th, td {
  padding-top: 20px;
  padding-bottom: 10px;
  padding-left: 20px;
  padding-right: 20px;
}

</style>
</head>
<body>
<%
String st=(String)session.getAttribute("mailInSession");
if(st!=null && !st.isEmpty()){ 
%>
<h1>Welcome <%=session.getAttribute("username")%></h1>





<%


		HttpSession sessionObj=request.getSession();
	  //Here Session is Being Initialized
	        /* sessionObj.setAttribute("sessionStudentId",5);
			sessionObj.setAttribute("sessionStudentName","Mayank"); 
			 */
	
		
			 if(session.getAttribute("sessionStudentId") !=null && sessionObj.getAttribute("username") !=null)
				{
		
				 System.out.println("Here going to assigned to variables from session : Student Id : "+sessionObj.getAttribute("sessionStudentId"));
		Integer studentId=Integer.parseInt((String)sessionObj.getAttribute("sessionStudentId"));
		System.out.println("Here studentId assigned to variables from session");
		String studentName=(String)sessionObj.getAttribute("username");
		
		System.out.println("Here Values assigned to variables from session");
 
ArrayList<Requests> requestArrayList=new ArrayList<>();	
 fetchOne obj=new fetchOne();
 requestArrayList=obj.disp(studentId); 
 
 
 try
 {
 
 if(requestArrayList != null)
		{
			%>
			
			<table class="center">
			<tr><th>Request Id</th>
			<th>Request Status</th>
			 <th>Request Date</th> 
			<th>Book Name</th>
			</tr>
			
			<%
		for(int i=0;i<requestArrayList.size();i++)
{
%>	
<tr>
<td><%=requestArrayList.get(i).getRequestId()%></td>
<td><%=requestArrayList.get(i).getRequestStatus()%></td>
<td><%=requestArrayList.get(i).getRequestDate()%></td>
<td><%=requestArrayList.get(i).getBookReturnDate()%></td>
</tr>
<% }%>
	<tr><th></th><td colspan="4"><button onclick="window.location.href='StudentHome.jsp'" align="center">Back To Home</button></td></tr>
<%
}
 else
 {
	 System.out.println("No Record Found");
 }
 }
catch(Exception ex)
{
ex.getStackTrace();
System.out.println("Exception Orroured "+ex);
}
}
else
{
%>
	
<a href="Login.jsp">Failed To Load Data,<br>Please Login</a>	
	
<%	
}
%>



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