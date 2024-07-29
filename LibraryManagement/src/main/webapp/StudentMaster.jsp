<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import ="java.util.ArrayList"%>

<%@ page import ="com.StudentMaster.Student"%>
<%@ page import ="com.StudentMaster.StudentDaoImp"%>
<%@ page import ="java.util.List"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registeration</title>
</head>
<% StudentDaoImp studentObj=new StudentDaoImp();
int id=studentObj.fetchMax();
%>
<body>
<table>
  <form action="StdentMasterController" method="post"> 
 <tr><th>Student Id</th><td><input type="number" name="studentId" value='<%=id%>'></td></tr>
  <tr><th>Name</th><td><input type="text" name="studentNm"></td></tr>
  <tr><th>Contact Number</th><td><input type="number" name="contNum"></td></tr>
  <tr><th>Address</th><td><input type="text" name="address"></td></tr>
 <tr><th> Email</th><td><input type="email" name="email"></td></tr>
  <tr><th>Password</th><td><input type="PASSWORD" name="password"></td></tr>
<table>
<tr>  
 <th></th><td><input type="submit" name="BtnClick" value="Add Student"></td>
 <th></th><td><input type="submit" name="BtnClick" value="Display Student"></td>
 <th></th><td><input type="submit" name="BtnClick" value="Update Student"></td>
 <th></th><td><input type="submit" name="BtnClick" value="Delete Student"></td>
</tr>
</table>
</table><br><br>
<% 
 ArrayList<Student> studentAvailable=(ArrayList<Student>)request.getAttribute("StudentData"); 

System.out.println(studentAvailable);
if(studentAvailable!=null && !studentAvailable.isEmpty())
{%>
<table border="2px">
	<tr>
    <th>Id</th>
    <th>Name</th>
    <th>Contact No</th>
    <th>Email</th>
    <th>Address</th>
</tr>
	<%
	for(int i=0;i<studentAvailable.size();i++)
	{
		Student StOb =studentAvailable.get(i);
		
%>

<tr>
<td><%=StOb.getId()%></td>
<td><%=StOb.getStudentName()%></td>
<td><%=StOb.getPhoneNo()%></td>
<td><%=StOb.getEmail()%></td>
<td><%=StOb.getAddress()%></td>
</tr>

<%
}
	%> </table><%
}
%>



  
  </form>
</body>
</html>