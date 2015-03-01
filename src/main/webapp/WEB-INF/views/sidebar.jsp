<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%--
  Created by IntelliJ IDEA.
  User: Odour
  Date: 27.02.2015
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="sidebar">
  <ul>
    <li>Person
      <ul>
        <li>
          <a href="<c:url value="/person/list"/>">List</a>
        </li>
        <li>
          <a href="<c:url value="/person/add"/>">Add</a>
        </li>
        <li>
          <a href="<c:url value="/person/search"/>">Search</a>
        </li>
      </ul>
    </li>
    <li>Company
      <ul>
        <li>
          <a href="/company/list">List</a>
        </li>
        <li>
          <a href="/company/add">Add</a>
        </li>
      </ul>
    </li>
    <li>
      Skill
      <ul>
        <li>
          <a href="/skill/list">List</a>
        </li>
        <li>
          <a href="/skill/add">Add</a>
        </li>
      </ul>
    </li>
  </ul>
</div>
