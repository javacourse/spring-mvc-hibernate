<%--
  Created by IntelliJ IDEA.
  User: Odour
  Date: 16.02.2015
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Found persons</title>
</head>
<body>
  <h4>
    Found persons:
  </h4>
<c:forEach items="${personList}" var="person">
  ${person.id} - ${person.lastName} ${person.firstName} ${person.age} <br/>
</c:forEach>
  <br/>
<a href="list">Return to persons list</a>
</body>
</html>
