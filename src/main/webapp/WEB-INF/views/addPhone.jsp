<%--
  Created by IntelliJ IDEA.
  User: iten
  Date: 2/16/2015
  Time: 9:14 PM
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
<h1>
  Add new phone number for ${person.firstName} ${person.lastName}
</h1>
<jsp:include page="modifyPhone_tpl.jsp"></jsp:include>

</body>
</html>
