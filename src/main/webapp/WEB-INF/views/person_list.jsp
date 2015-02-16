<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<h4>Listing People</h4>
<c:forEach items="${people}" var="v_person">
	<a href="edit?id=${v_person.id}">${v_person.id} -
	${v_person.firstName} ${v_person.lastName} </a>
	<br />
</c:forEach>
<br/>
<a href="new"> Add Person</a><br/>
<a href="search"> Find Person</a>
</body>
</html>
