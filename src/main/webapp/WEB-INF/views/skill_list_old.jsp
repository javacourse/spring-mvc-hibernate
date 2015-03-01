<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<h4>Listing Skills</h4>
<c:forEach items="${skills}" var="v_skill">
	<a href="edit?id=${v_skill.id}">${v_skill.id} -
	${v_skill.name}</a>
	<br />
</c:forEach>
<a href="new">Add Skill</a>
</body>
</html>
