<%--
  Created by IntelliJ IDEA.
  User: Odour
  Date: 16.02.2015
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
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
    Company: <select name="companyId">
  <c:forEach items="${companyList}" var="v_company">
    <option value="${v_company.id}">
      ${v_company.name}
    </option>
  </c:forEach>
</select>
  <br/>
  <br/>
Skills: <br/>
<c:forEach items="${skillList}" var="v_skill">
  <input type="checkbox" value="${v_skill.id}" name="skillsId">
      ${v_skill.name}<br/>
</c:forEach>
  <input type="submit" value="Find">
</form:form>
</body>
</html>
