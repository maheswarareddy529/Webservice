<%@page isELIgnored="false" %>
<html>
<body>
<%@include file="Menu.jsp" %>
<div align="center">
<H3>WELCOME TO STUDENT EDIT PAGE</H3>
<form action="update" method="POST">
<pre>
ID    : <input type="text" name="stdId" value="${sob.stdId}" readonly="readonly"/>
NAME  : <input type="text" name="stdName" value="${sob.stdName}"/>
COURSE: <input type="text" name="stdCourse" value="${sob.stdCourse}"/>
FEE   : <input type="text" name="stdFee" value="${sob.stdFee}"/>
	<input type="submit" value="Update"/>
</pre>
</form>
</div>
</body>
</html>
