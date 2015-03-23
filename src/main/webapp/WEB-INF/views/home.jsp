<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>
${controllerMessage}<br/>
<br/>
<br/>
<a href="/department/deptList">Departments</a>
<c:url value="/j_spring_security_logout" var="logoutUrl" />

<form action="${logoutUrl}" method="post" id="logoutForm">
	<input name="submit" type="submit" value="Logout"/>
</form>
</body>
</html>
