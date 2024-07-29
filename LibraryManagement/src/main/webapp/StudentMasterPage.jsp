<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="java.util.*" %>
    <%@ page import ="java.sql.Date" %>
    <%@ page import="java.sql.*" %>
    <%@ page import="com.StudentMaster.StudentDao" %>
    <%@ page import="com.StudentMaster.StudentDaoImp" %>
    <%@ page import="com.StudentMaster.Student" %>
        <%@ page import="java.util.ArrayList" %>
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


th, td {
  padding-top: 5px;
  padding-bottom: 5px;
  padding-left: 5px;
  padding-right: 5px;
}

</style>
<script>


</script>
</head>
<body>
<%
String st=(String)session.getAttribute("mailInSession");
if(st!=null && !st.isEmpty()){ 
StudentDao studentObject=new StudentDaoImp();
ArrayList<Student> AllStudentArrayList=new ArrayList<Student>(); 
AllStudentArrayList =studentObject.showAllUsers();
%>
<table>
<tr>
<th colspan="5">
<h1>Welcome <%=session.getAttribute("username")%></h1>
</th>
</tr>
<%if(AllStudentArrayList.isEmpty()){%>
<tr>
<th></th><td><p>No Student Record Found</p></td>
</tr>
<%}
else
{
	if(AllStudentArrayList==null)
	{%>
		<tr><th></th><td><p style="color:red">Something Went Wrong!!!</p></td>
<%}
	else
	{
	%>
	<tr><th>Student Id</th><th>Student Name</th><th>Contact No</th><th>Student Address</th><th>Student Email</th>
	<%	
	for(int i=0;i<AllStudentArrayList.size();i++)
	{
%>
<tr>
<td><%=AllStudentArrayList.get(i).getId()%></td>
<td><%=AllStudentArrayList.get(i).getStudentName()%></td>
<td><%=AllStudentArrayList.get(i).getPhoneNo()%></td>
<td><%=AllStudentArrayList.get(i).getAddress()%></td>
<td><%=AllStudentArrayList.get(i).getEmail()%></td>


<td><form action="StudentUpdation.jsp" method="post">

<input type="hidden" name="studentId" value="<%=AllStudentArrayList.get(i).getId()%>">
<input type="hidden" name="studentNm" value="<%=AllStudentArrayList.get(i).getStudentName()%>">
<input type="hidden" name="contNum" value="<%=AllStudentArrayList.get(i).getPhoneNo()%>">
<input type="hidden" name="address" value="<%=AllStudentArrayList.get(i).getAddress()%>">
<input type="hidden" name="email" value="<%=AllStudentArrayList.get(i).getEmail()%>">
<input type="hidden" name="password" value="<%=AllStudentArrayList.get(i).getPass()%>">


<input type="submit" name="BtnClick" value="Update">
</form>






<form form action="StudentMasterPageController" method="post"> 
<input type="hidden" name="studentId" value="<%=AllStudentArrayList.get(i).getId()%>">
<input type="submit" name="btn" value="Delete">
</form></td>
</tr>
<%}}}%>

<tr>
<th><th>
<td>
<a name="addStudent" href="Register.jsp"><button>Add Student</button></a></td>
<td>

<a name="Deleted" href="StudentDeleted.jsp"><button>Deleted Students</button></a>
</td>
</tr>

<tr>
<td colspan="5"><form action="lgout" method="post">
<input type="submit" value="Logout">
<input type="button" value="go back" onclick="history.back()">
</form>
</td>
</tr>
</table>

<% }%>
</body>
</html>