<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Odour
  Date: 27.02.2015
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h4>Listing People</h4>
    <c:forEach items="${people}" var="v_person">
      <a href="info?id=${v_person.id}">${v_person.id} -
          ${v_person.lastName} ${v_person.firstName}</a>
      <br />
    </c:forEach>
  </div>

  <jsp:include page="footer.jsp"></jsp:include>
  </div>
</body>
</html>
