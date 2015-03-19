<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>
${controllerMessage}<br/>
<br/>
<br/>
<a href="person/list">Go to the person list</a>
<br>
<a href="department/list">Go to the department list</a>

<jsp:include page="footer.jsp" />
</body>
</html>
