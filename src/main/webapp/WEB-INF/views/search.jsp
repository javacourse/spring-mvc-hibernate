<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Searching</title>
</head>
<body>
<h4>
  Looking for a person:
</h4>
<form:form action="found" method="get">
  Departament: <select name="departamentId">
  <c:forEach items="${departaments}" var="departament">
    <option value="${departament.id}">
        ${departament.depName}
    </option>
  </c:forEach>
</select>
  <br/>
  <input type="submit" value="Find">
</form:form>
</body>
</html>