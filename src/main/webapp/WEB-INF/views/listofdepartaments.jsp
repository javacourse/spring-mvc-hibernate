<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
  <title>Home</title>
</head>
<body>
<h1>Listing of Departments</h1>
<table>
  <tr class="panel">
    <td>id</td>
    <td align="center">Dep Name</td>
    <td></td>
  </tr>
  <c:forEach items="${list}" var="v_departament">
  <tr>
    <td>${v_departament.id}</td>
    <td><a href="edit?id=${v_departament.id}">${v_departament.depName}</a></td>
    <td><a href="del?id=${v_departament.id}">del</a></td>
  </tr>
  </c:forEach>
</table>
<a href="new"> Add Department</a>
<br>
</body>
</html>
