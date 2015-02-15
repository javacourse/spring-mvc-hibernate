<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<form:form style="padding:8px" modelAttribute="skill">
    ID - ${skill.id}<br/>
    <p>
        Skill name:<br/>
        <form:input path="name"/>
    </p>
    <input type="submit" value="Save"/>
</form:form>