<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <form style="padding:8px" name="login" action="<c:url value='j_spring_security_check' />" method="POST">
      <table>
        <tr>
          <td>
            Login:
          </td>
          <td>
            <input type="text" name="login">
          </td>
        </tr>
        <tr>
          <td>
            Password:
          </td>
          <td>
            <input type="password" name="password">
          </td>
        </tr>
      </table>
      <input type="submit" value="Save"/>
    </form>
  </div>
  <jsp:include page="footer.jsp"></jsp:include>
  </div>
</body>
</html>
