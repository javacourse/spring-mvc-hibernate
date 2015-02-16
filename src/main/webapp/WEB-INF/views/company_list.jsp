<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<h4>Listing Companies</h4>
<c:forEach items="${companies}" var="v_company">
	<a href="edit?id=${v_company.id}">${v_company.id} -
	${v_company.name}</a>
	<br />
</c:forEach>
<a href="new"> Add Company</a>
</body>
</html>
