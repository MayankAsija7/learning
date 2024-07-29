<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="com.BookMaster.LibBook"%>
<%@ page import ="java.util.List"%> 
<%@ page import ="java.sql.Date" %>
<%@ page import="java.sql.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Book</title>
<style type="text/css">
td
{
align-text:center;
padding:10px;

}
</style>


</head>
<body>
<%
String st=(String)session.getAttribute("mailInSession");
if(st!=null && !st.isEmpty()){ 
%>
<h1>Welcome <%=session.getAttribute("username")%></h1>


<%try
{	
String url="jdbc:postgresql://10.1.1.53:5432/TRAINING";
	String name="postgres";
	String password="MOb1cule!";

Class.forName("org.postgresql.Driver");
Connection con=DriverManager.getConnection(url,name,password);
String Query2="select Max(request_id) from \"I1291\".requests";
PreparedStatement pts2=con.prepareStatement(Query2);
ResultSet resultset=pts2.executeQuery();
System.out.println("Maximum Id Generated : "+resultset);
if(resultset.next())
{
	int id=resultset.getInt(1);
	id++;
request.setAttribute("IdValue",id);
	
}
else
{
	System.out.println("Data Not Found");
}

}
catch(Exception ex)
{
	System.out.println("Here Exception Occoured");
} 

%>

<form method="post" action="BookFetchController">
<table >
<tr>
<!-- <th>
Request Id:
</th> -->
<td>
<input type="text" id="requestId" name="requestId" value="<%=request.getAttribute("IdValue")%>" hidden>
</td>
</tr>
<tr>
<th>
Isbn
</th>
<td>
<input type="text" name="isbn" list="bookName" />
<datalist id="bookName">
<%ArrayList<LibBook> bookList=(ArrayList<LibBook>)request.getAttribute("bookData");
System.out.println(bookList);
if(bookList != null) 
{
System.out.println(bookList.size());
	
for(int i=0;i<bookList.size();i++)
 { %>
 
  <option value=<%=bookList.get(i).getIsbn()%>><%=bookList.get(i).getName()%></option>

<%}} %>
</datalist><input type="submit" name="btn" Value="Fetch Data">
</td>
</tr>
<tr>
<th>
Request Date
</th>
<td>
<%long millis=System.currentTimeMillis();  
java.sql.Date date=new java.sql.Date(millis);%>
<input type="text" id="requestDate" name="requestDate" value="<%=date%>" hidden><span><%=date%></span>
</td>
</tr>
<tr>
<th>
Remark
</th>
<td>
<input type="text" name="remark">
</td>
</tr>




<div id="center">
<tr>
<div><td><input type="submit" name="btn" value="Submit Request"></td>
<td><input type="submit" name="btn" value="All Requests"></td>
</div>
<br>
</tr>




<tr>
<div><td>
<input type="button" name="backBtn" onclick="window.location.href='StudentHome.jsp'" value="Back To Home" ></td><td><input type="button" value="Go Back" onclick="history.back()"></td>
<td><input type="text" id="requestid" value='<%=request.getAttribute("IdValue")%>'  hidden></td>
</tr>
</div>
</table>

</form>


<%if(request.getParameter("reqId")!=null) 
{%>
	
<script>
var message=document.getElementById("requestid").value;
var id=parseInt(message)-1;
alert("Your RequestId : "+id);
</script>

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