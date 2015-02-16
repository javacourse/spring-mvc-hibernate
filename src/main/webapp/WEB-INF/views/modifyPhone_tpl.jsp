<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form style="padding:8px" modelAttribute="phone">
    ID - ${person.id}<br/>
    <p>
        Phone number<br/>
        <form:input path="number"/>
    </p>
    <input type="submit" value="Save"/>
</form:form>