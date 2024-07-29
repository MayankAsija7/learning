<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import ="java.util.ArrayList"%>
    <%@ page import ="com.RequestMaster.Requests"%>
<%@ page import ="com.RequestMaster.RequestedBookDaoImpl"%>
<%@ page import ="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String st=(String)session.getAttribute("mailInSession");
if(st!=null && !st.isEmpty()){ 
%>
<h1>Welcome <%=session.getAttribute("username")%></h1>




<% 
HttpSession sessionObj=request.getSession();
if(sessionObj.getAttribute("sessionStudentId") != null)
{
	Integer stid=Integer.parseInt((String)sessionObj.getAttribute("sessionStudentId"));

// validate first about student logged in
ArrayList<Requests> RequestsList=new ArrayList<>();
RequestedBookDaoImpl RequestsObj= new RequestedBookDaoImpl();
RequestsList=RequestsObj.returnBook(stid);
for(int i=0;i<RequestsList.size();i++)
{
	System.out.println(i+" : "+RequestsList.get(i).getRequestId());
}



%>
<% if(!RequestsList.isEmpty())
{ 
%>
<form method="post" action="BookFetchController">
Select Request Id To Return Book <select name="RequestId">
  <!-- <option value="volvo">Volvo</option> -->
  <% 
 
  for(int i=0;i<RequestsList.size();i++)
  {
	  %>
	  <option value="<%=RequestsList.get(i).getRequestId()%>">Request Id : <%=RequestsList.get(i).getRequestId()%> : <%=RequestsList.get(i).getBookName()%></option>
<%	  
  }
  %>
  
  </select>    <input type="submit" name="btn2" value="Return Book"><br>
  <%
}
else
{
	
%>

<h1>No Book Pending For Return</h1>
<button onclick="window.location.href='StudentHome.jsp'" align="center">Back To Home</button>
<%
}
}
else
{
  %>
 <a href="Login.jsp">Please Login To Continue</a>
  
  
  
<% }%>
</form>



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