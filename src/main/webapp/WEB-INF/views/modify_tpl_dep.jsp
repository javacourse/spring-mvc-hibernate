<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form style="padding:8px" modelAttribute="departament">
  ID - ${departament.id}<br/>
  <p>
    Departament Name<br/>
    <form:input path="depName"/>
  </p>
  <input type="submit" value="Save"/>
</form:form>
