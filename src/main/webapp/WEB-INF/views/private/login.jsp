<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page session="false"%>
<!doctype html>
<html lang="ru">
<head>
  <meta charset="utf-8">
  <title>Вход</title>

</head>

<body onload='document.f.j_username.focus();'>

<form name='f' action="<c:url value='_spring_security_check' />"
      method='POST'>
  <div class="logincontainer">

    <div class="login">
      <table>
        <tr>
          <td>Имя
          </td>
          <td> <input type='text' name='_username'>
          </td>

        </tr>
        <tr>
          <td>Пароль
          </td>
          <td> <input type='password' name='_password' />
          </td>
        </tr>
      </table>
      <br />
      <input id="_spring_security_remember_me"
             name="_spring_security_remember_me" type="checkbox" value="true" />
      <label for="_spring_security_remember_me">Remember Me?</label>

      <br /> <input class="btn btn-primary" name="submit" type="submit"
                    value="Вход" /> <br />
    </div>
    <c:if test="${not empty error}">
      <div class="alert alert-danger" style="width: 285px; margin: 0px auto;" role="alert">
          ${error}</div>
    </c:if>
  </div>
</form>
</body>
</html>