<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form style="padding:8px" modelAttribute="person">
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
            <option value="${company.id}" <c:if test="${company.id.equals(person.company.id)}">
                selected </c:if> >
                ${company.name}
            </option>
        </c:forEach>
        </select>
    </p>
    <p>
        Skills<br/>
            <c:forEach items="${skillsList}" var="skillValue">
                <input type="checkbox" name="skillsVars" value="${skillValue.id}"
                        <c:forEach items="${person.skills}" var="skill">
                                <c:if test="${skill.id.equals(skillValue.id)}">
                                    checked
                                </c:if>
                            </c:forEach>>
                        ${skillValue.name}
                <br/>
            </c:forEach>
    </p>

    <input type="submit" value="Save"/>
</form:form>