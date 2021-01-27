<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Menu.jsp" %>
<div align="center">
<H3>WELCOME TO STUDENT DATA PAGE</H3>
<table border="1">
<tr>
	<th>ID</th>
	<th>NAME</th>
	<th>FEE</th>
	<th>COURSE</th>
	<th>DISCOUNT</th>
	<th colspan="2">LINK</th>
</tr>
 	<c:forEach items="${list}" var="ob">
 		<tr>
 			<td>${ob.stdId}</td>
 			<td>${ob.stdName}</td>
 			<td>${ob.stdFee}</td>
 			<td>${ob.stdCourse}</td>
 			<td>${ob.stdDiscount}</td>
 			<td>
 				<a href="delete?id=${ob.stdId}">DELETE</a>
 			</td>
 			<td>	
 				<a href="edit?id=${ob.stdId}">EDIT</a>
 			</td>
 		</tr>
 	</c:forEach>
</table>
${message}
</div>
</body>
</html>







