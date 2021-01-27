<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
</head>
<body>
<%@include file="menu.jsp" %>
<div align="center">
<h2><marquee>Welcome To Student Registration Page</marquee></h2>
<form action="insert" method="post">
<pre>
ID    :<input type="text" name="stdId"><br>
NAME   :<input type="text" name="stdName"> <br>
COURSE:<input type="text" name="stdCourse"><br>
FEE   :<input type="text" name="stdFee"><br>
<input type="submit" value="Register"><br>
</pre>
${message}
</form>
</div>
</body>
</html>