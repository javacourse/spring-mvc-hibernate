<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
    <title>Home</title>
	<link rel="stylesheet" href="<c:url value="/resources/css/screen.css" />" type="text/css" />
</head>
<body>
<h1>Listing People</h1>
<table>
	<tr class="panel">
		<td>id</td>
		<td align="center">First Name</td>
		<td align="center">Last Name</td>
		<td></td>
		<td></td>
		<td>Phone(s)</td>
	</tr>
<c:forEach items="${people}" var="v_person">
	<tr>
		<td>${v_person.id}</td>
		<td><a href="edit?id=${v_person.id}">${v_person.firstName}</a></td>
		<td><a href="edit?id=${v_person.id}">${v_person.lastName}</a></td>
		<td><a href="del?id=${v_person.id}">delete</a></td>
		<td><a href="addPhone?id=${v_person.id}">add phone</a></td>
		<td>
			<table>
			<c:forEach items="${v_person.phones}" var="v_phone">
				<tr>
					<td>${v_phone.id}</td>
					<td>${v_phone.number}</td>
				</tr>
			</c:forEach>
			</table>
		</td>
	</tr>
</c:forEach>
</table>
<br />
<a href="new"> Add Person</a>
</body>
</html>
