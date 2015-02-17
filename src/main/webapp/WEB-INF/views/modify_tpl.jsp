<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form:form style="padding:8px" modelAttribute="person">
    ID - ${person.id}<br/>
    
    <p>
        Departament<br/>
        <select name="departamentId">
            <c:forEach items="${departaments}" var="departament">
                <option value="${departament.id}">
                        ${departament.depName}
                </option>
            </c:forEach>
        </select>
    </p>

    <p>
        First Name<br/>
        <form:input path="firstName"/>
    </p>
    <p>
        Last Name<br/>
        <form:input path="lastName"/>
    </p>
    <input type="submit" value="Save"/>
</form:form>