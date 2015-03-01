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
    Person id: #${personInfo.id} <br/>
    Name: ${personInfo.lastName} ${personInfo.firstName} <br/>
    Age: ${personInfo.age} <br/>
    Company: ${personInfo.company.name}<br/>
    Skills: <br/>
    <c:forEach items="${personInfo.skills}" var="skill">
      ${skill.name}
    </c:forEach>
  <p>    <table>
    <tr>
      <td>
        <form action="edit" method="get">
          <input type="hidden" name="id" value="${personInfo.id}">
          <input type="submit" value="Edit">
        </form>
      </td>
      <td>
        <form action="delete" method="post">
          <input type="hidden" name="id" value="${personInfo.id}">
          <input type="submit" value="Delete">
        </form>
      </td>
    </tr>
  </table>
    </p>


  </div>

  <jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>
