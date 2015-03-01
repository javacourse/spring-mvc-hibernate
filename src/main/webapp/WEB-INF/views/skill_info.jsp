<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Odour
  Date: 27.02.2015
  Time: 14:16
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
    <h4>
      Person information
    </h4>
    Skill id: #${skill.id} <br/>
    Skill name: ${skill.name} <br/>
  <p>    <table>
    <tr>
      <td>
        <form action="edit" method="get">
          <input type="hidden" name="id" value="${skill.id}">
          <input type="submit" value="Edit">
        </form>
      </td>
      <td>
    </tr>
  </table>
    </p>


  </div>

  <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
