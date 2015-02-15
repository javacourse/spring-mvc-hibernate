<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form style="padding:8px" modelAttribute="person">
    ID - ${person.id}<br/>
    <p>
        First Name<br/>
        <form:input path="firstName"/>
    </p>
    <p>
        Last Name<br/>
        <form:input path="lastName"/>
    </p>
    <p>
        Age<br/>
        <form:input path="age"/>
    </p>
    <p>
        Company<br/>
        <select name="compId">
        <c:forEach items="${companies}" var="company">
            <option value="${company.id}">
                ${company.name}
            </option>
        </c:forEach>
        </select>
    </p>
    <p>
        Skills<br/>
            <c:forEach items="${skillsList}" var="skillValue">
                <input type="checkbox" name="skillsVars" value="${skillValue.id}">
                        ${skillValue.name}
                <br/>
            </c:forEach>
    </p>

    <input type="submit" value="Save"/>
</form:form>