<%--
  Created by IntelliJ IDEA.
  User: iten
  Date: 3/9/2015
  Time: 1:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
  <title>Departments</title>
  <link rel="stylesheet" href="<c:url value="/resources/css/screen.css" />" type="text/css" />
</head>
<body>
<h1>Listing Departments</h1>
<table>
  <tr class="panel">
    <td>id</td>
    <td align="center">Department Name</td>
    <td></td>
    <td></td>
  </tr>
  <c:forEach items="${departments}" var="v_department">
    <tr>
      <td>${v_department.id}</td>
      <td><a href="edit?id=${v_department.id}">${v_department.name}</a></td>
      <td><a href="editPeople?id=${v_department.id}">Edit stuff</a></td>
      <td><a href="del?id=${v_department.id}">delete</a></td>
    </tr>
  </c:forEach>
</table>
<br />
<a href="new">Add Department</a>
</body>
</html>
