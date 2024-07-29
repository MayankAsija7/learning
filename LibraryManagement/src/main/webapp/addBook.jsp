<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<style type="text/css">
body
{
text-align:center;
}
form { 
margin: 0 auto; 
width:250px;
}
th, td {
  padding-top: 10px;
  padding-bottom: 10px;
  padding-left: 10px;
  padding-right: 10px;
}
.sp
{
  padding-top: 20px;
}
</style>
<body>
<h1>Add Book</h1>
<form method="post" action="BookMasterPageController">
<table>

<tr><th class="sp">Isbn</th><td class="sp"><input type="number" name="isbnNum" required></td></tr>
<tr><th>Book Name</th><td><input type="text" name="bookName" required></td></tr>
<tr><th>Book Author</th><td><input type="text" name="bookAuthor" required></td></tr>
<tr><th>Book Description</th><td><input type="text" name="bookDescription" required></td></tr>
<tr><th>Book Genre</th><td><input type="text" name="bookGenre" required></td></tr>
<tr><th></th><td><input type="submit" value="Add Book" name="btn">

<input type="button" value="go back" onclick="history.back()">

</td></tr>
</form>
</body>
</html>