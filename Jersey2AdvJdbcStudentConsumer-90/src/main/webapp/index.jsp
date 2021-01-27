<%@page isELIgnored="false" %>
<html>
<body>
<%@include file="Menu.jsp" %>
<div align="center">
<H3>WELCOME TO STUDENT REGISTER PAGE</H3>
<form action="insert" method="POST">
<pre>
ID    : <input type="text" name="stdId"/>
NAME  : <input type="text" name="stdName"/>
COURSE: <input type="text" name="stdCourse"/>
FEE   : <input type="text" name="stdFee"/>
	<input type="submit" value="Register"/>
</pre>
${message }
</form>
</div>
</body>
</html>
