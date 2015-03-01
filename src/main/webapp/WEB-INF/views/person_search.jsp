<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Odour
  Date: 27.02.2015
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title></title>
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="container">
  <jsp:include page="header.jsp"></jsp:include>
  <jsp:include page="sidebar.jsp"></jsp:include>

  <div id="content">
    <h4>
      Search:
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
      <p>
        <input type="submit" value="Find">
      </p>

    </form:form>
  </div>

  <jsp:include page="footer.jsp"></jsp:include>
  </div>
</body>
</html>
