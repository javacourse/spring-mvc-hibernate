<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<html>
<head>
<title>Home</title>
</head>
<body>
<h1>Listing People</h1>
<table border="1">
	<tr class="panel">
		<td>id</td>
		<td align="center">Dep id</td>
		<td align="center">Dep Name</td>
		<td align="center">First Name</td>
		<td align="center">Last Name</td>
		<td></td>
	</tr>
	<c:forEach items="${people}" var="v_person">
		<tr>
			<td>${v_person.id}</td>
			<td><a href="edit?id=${v_person.id}">${v_person.getDepartament().getId()}</a></td>
			<td><a href="edit?id=${v_person.id}">${v_person.getDepartament().getDepName()}</a></td>
			<td><a href="edit?id=${v_person.id}">${v_person.firstName}</a></td>
			<td><a href="edit?id=${v_person.id}">${v_person.lastName}</a></td>
			<td><a href="del?id=${v_person.id}">del</a></td>
		</tr>
	</c:forEach>
</table>
<a href="new"> Add Person</a> <br/>
<a href="search"> Find Person</a> <br/>
<a href="/department/list">Go to List of Departament</a><br/>
<jsp:include page="footer.jsp" />
</body>
</html>
