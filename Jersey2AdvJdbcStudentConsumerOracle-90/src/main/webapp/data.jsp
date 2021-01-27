<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data Is Displayed</title>
</head>
<body>
<%@include file="menu.jsp" %>
<h2><marquee>Welcome To Student Data Page</marquee></h2>
<table border="1">
<tr>
<th>ID</th>
<th>NAME</th>
<th>COURSE</th>
<th>FEE</th>
<th>DISCOUNT</th>
<th colspan="2">LINKS</th>
<c:forEach items="${list}" var="ob">
<tr>
<td>${ob.stdId}</td>
<td>${ob.stdName}</td>
<td>${ob.stdCourse}</td>
<td>${ob.stdFee}</td>
<td>${ob.stdDiscount}</td>
<td><a href="delete?id=${ob.stdId }">DELETE</a></td>
<td><a href="edit?id=${ob.stdId }">EDIT</a></td>
</tr>
</c:forEach>
</tr>
</table>
${message}
</body>
</html>