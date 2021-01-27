<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
<%@include file="menu.jsp" %>
<div align="center">
<h2> <marquee>Welcome To Student Edit Page</marquee></h2>
<form action="update" method="post">
<pre>
ID    :<input type="text" name="stdId" value="${sob.stdId}" readonly="readonly"><br>
NAME  :<input type="text" name="stdName" value="${sob.stdName}" ><br>
COURSE:<input type="text" name="stdCourse" value="${sob.stdCourse}" ><br>
FEE   :<input type="text" name="stdFee" value="${sob.stdFee}" ><br>
<input type="submit" value="Update">
</pre>
</form>
</div>
</body>
</html>