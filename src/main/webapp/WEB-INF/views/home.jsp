<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h4>
	Hello world!
</h4>
${controllerMessage}<br/>
<br/>
<br/>
<a href="person/list">Go to the person list</a><br/>
<a href="company/list">Go to the companies list</a><br/>
<a href="skill/list">Go to the skills list</a>
</body>
</html>
