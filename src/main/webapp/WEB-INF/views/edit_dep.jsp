<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
<h1>
  Editing Departament ${departament.id} - ${departament.depName}
</h1>
<jsp:include page="modify_tpl_dep.jsp"></jsp:include>

</body>
</html>

