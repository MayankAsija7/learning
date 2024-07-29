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

	padding-top: 5px;
	padding-bottom: 5px;
	padding-left: 2px;
	padding-right: 2px;
}
</style>

<script>
function myFunction() {
  let text = "Press a button!\nEither OK or Cancel.";
  if (confirm(text) == true) {
    text = "You pressed OK!";
  } else {
    text = "You canceled!";
  }
  document.getElementById("demo").innerHTML = text;
}
</script>




</head>
<body>
	<%
	String st = (String) session.getAttribute("mailInSession");
	if (st != null && !st.isEmpty()) {
		LibrarianMasterDaoImpl librarianObject = new LibrarianMasterDaoImpl();
		ArrayList<Librarian> AllLibrarianArrayList = new ArrayList<Librarian>();
		AllLibrarianArrayList = librarianObject.AllLibrarian();
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





			<td><form action="LibrarianUpdation.jsp" method="post">

					<input type="hidden" name="LibrarianId"
						value="<%=AllLibrarianArrayList.get(i).getLibId()%>"> <input
						type="hidden" name="LibrarianNm"
						value="<%=AllLibrarianArrayList.get(i).getLibName()%>"> <input
						type="hidden" name="LibrariancontNum"
						value="<%=AllLibrarianArrayList.get(i).getLibContNum()%>">
					<input type="hidden" name="LibrarianJoinDate"
						value="<%=AllLibrarianArrayList.get(i).getLibJoinDate()%>">
					<input type="hidden" name="LibrarianAddress"
						value="<%=AllLibrarianArrayList.get(i).getLibAddress()%>">
					<input type="hidden" name="LibrarianEmail"
						value="<%=AllLibrarianArrayList.get(i).getLibEmail()%>"> <input
						type="hidden" name="LibrarianPassword"
						value="<%=AllLibrarianArrayList.get(i).getLibPassword()%>">
					<input type="hidden" name="text"
						value="<%=AllLibrarianArrayList.get(i).getLibPassword()%>">
					<input type="submit" name="BtnClick" value="Update">
				</form>






				<form form action="Controller" method="post">
<input type="hidden" name="librarianId" value="<%=AllLibrarianArrayList.get(i).getLibId()%>"> <br>
<input type="submit" name="btn" value="Delete"   >
				</form></td>
		</tr>
		<%
		}
		}
		}
		%>

		<tr>
			<th>
			</th>
			<td colspan="2" Style="padding-right:1px"><a name="addLibrarian" href="LibrarianRegistration.jsp"><button>Add Librarian</button></a></td>
			<td ><a name="Deleted" href="LibrarianDeleted.jsp"><button>Deleted Librarian</button></a></td>
		</tr>
		<tr>
			<td colspan="5"><form action="lgout" method="post">
					<input type="submit" value="Logout">
					<input type="button" value="go back" onclick="history.back()">
				</form></td>
		</tr>
	</table>

	<% }%>
</body>
</html>