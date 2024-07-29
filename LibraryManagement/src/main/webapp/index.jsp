<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="index.css">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <h1>Login</h1>
        <form action="ser" method="post"> <!-- Change method to "post" -->
            <label for="username">UserName:</label>
            <input type="text" id="username" name="nm" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="ps" required><br>
            <button type="submit">Login</button>
        </form>

        <p>Don't Registered Yet ? &nbsp; <a href="register.jsp"><b>Register Now</b></a></p>

        <%-- Display error message if login fails --%>
        <% String error = request.getParameter("error");
            if (error != null && error.equals("1")) { %>
                <p style="color: red;">Invalid userName or password. Please tr y again.</p>
        <% } %>
        
        <%-- Display error message if Register Successful --%>
        <% String rs = request.getParameter("registration");
            if (rs != null && rs.equals("success")) { %>
                <p style="color: green;">Your Registration is Successful. Please Login.</p>
        <% } %>
    </div>
</body>
</html>