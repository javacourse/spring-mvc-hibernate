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
	Logon screen
</h1>
${controllerMessage}<br/>
<br/>
<form action="<c:url value="/department/deptList" />" >

	<input type="text" name="un"/><br>

	<input type="text" name="pw"/>

	<input type="submit" value="submit">

</form>
<br/>

</body>
</html>
