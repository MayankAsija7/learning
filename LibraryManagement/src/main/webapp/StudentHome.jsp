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
<title>Welcome Student</title>

<style type="text/css">
body {
    text-align: center;
    }
    


</style>

</head>
<body>
<%
String st=(String)session.getAttribute("mailInSession");
String studentId=(String)session.getAttribute("sessionStudentId");
System.out.println("Here Logged Student Id"+studentId);
if(st!=null && !st.isEmpty()){ 
	System.out.println("Student Id Received By Home : "+studentId);
int id=Integer.parseInt(studentId); 
ArrayList<Requests> BookList=new ArrayList<>();
fetchOne obj=new fetchOne();

ArrayList<Requests> inHandBooksList=new ArrayList<>();
inHandBooksList=obj.dispInHandBooks(id);
System.out.println("Requests for particular students"+inHandBooksList);
 
System.out.println(inHandBooksList.size());


%>


<h1>Welcome <%=session.getAttribute("username")%></h1>	
<br>



<% if (inHandBooksList != null && inHandBooksList.size() !=0) { %>
  <div style="margin: 0 auto; width: 50%;">
    <table  style="margin: 0 auto; padding:40px;">
    <tr>
    <th colspan="2" style="padding-bottom:40px">
    Book In Hand
    </th>
    </tr>
      <tr>
        <th>Request Id</th>
        <th>Book Name</th>
      </tr>
      <% for (int i = 0; i < inHandBooksList.size(); i++) { %>
        <tr>
          <td><%=inHandBooksList.get(i).getRequestId()%></td>
          <td><%=inHandBooksList.get(i).getBookName()%></td>
        </tr>
      <% } %>
    </table>
  </div>
<% 
} 
else 
{ %>

  <h3><%= "No Book In Hand" %></h3>


<% } %>


<br><br><br>






<a href="requestGen.jsp">Click to Issue Book</a>
<br>
<br>
<a href="StudentReturnBookList.jsp">Click To Return Book</a>
<br>
<br>
<form action="lgout" method="post">
<input type="submit" value="Logout">
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