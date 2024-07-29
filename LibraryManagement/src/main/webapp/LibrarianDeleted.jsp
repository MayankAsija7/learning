<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.Date"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="com.LibrarianMaster.Librarian"%>
<%@ page import="com.LibrarianMaster.LibrarianMasterDaoImpl"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
body {
	text-align: center;
}

th, td {
	padding-top: 10px;
	padding-bottom: 10px;
	padding-left: 5px;
	padding-right: 5px;
}
</style>
</head>
<body>
	<%
	String st = (String) session.getAttribute("mailInSession");
	if (st != null && !st.isEmpty()) {
		LibrarianMasterDaoImpl librarianObject = new LibrarianMasterDaoImpl();
		ArrayList<Librarian> AllLibrarianArrayList = new ArrayList<Librarian>();
		AllLibrarianArrayList = librarianObject.DeletedLibrarian();
	%>
	<table>
		<tr>
			<th colspan="5">
				<h1>
					Welcome
					<%=session.getAttribute("username")%></h1>
			</th>
		</tr>
		<%
		if (AllLibrarianArrayList.isEmpty()) {
		%>
		<tr>
			<th></th>
			<td><p>No Librarian Record Found</p></td>
		</tr>
		<%
		} else {
		if (AllLibrarianArrayList == null) {
		%>
		<tr>
			<th></th>
			<td><p style="color: red">Something Went Wrong!!!</p></td>
			<%
			} else {
			%>
		
		<tr>
			<th>Librarian Id</th>
			<th>Librarian Name</th>
			<th>Contact No</th>
			<th>Librarian Joining Date</th>
			<th>Librarian Address</th>
			<th>Librarian Email</th>
			<%
			for (int i = 0; i < AllLibrarianArrayList.size(); i++) {
			%>
		
		<tr>


			<td><%=AllLibrarianArrayList.get(i).getLibId()%></td>

			<td><%=AllLibrarianArrayList.get(i).getLibName()%></td>

			<td><%=AllLibrarianArrayList.get(i).getLibContNum()%></td>

			<td><%=AllLibrarianArrayList.get(i).getLibJoinDate()%></td>

			<td><%=AllLibrarianArrayList.get(i).getLibAddress()%></td>

			<td><%=AllLibrarianArrayList.get(i).getLibEmail()%></td>
	
		</tr>
		<%
		}
		}
		}
		%>

		<tr>
			<td colspan="5"><form action="lgout" method="post">
					<input type="submit" value="Logout">
				</form></td>
		</tr>
	</table>

	<% }%>
</body>
</html>