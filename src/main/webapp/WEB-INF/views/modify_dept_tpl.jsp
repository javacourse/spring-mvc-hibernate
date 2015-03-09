<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form style="padding:8px" modelAttribute="department">
    ID - ${department.id}<br/>
    <p>
        Department Name<br/>
        <form:input path="name"/>
    </p>
    <input type="submit" value="Save"/>
</form:form>