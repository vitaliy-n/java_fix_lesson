<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cheba00.models.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%--
  Created by IntelliJ IDEA.
  User: Vitaliy
  Date: 12/23/2019
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" type="text/css">
    <script crossorigin="anonymous"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="form-style-2">
    <form action="signUp" method="post">
        <label for="name">Name
            <input type="text" class="input-field" name="name" id="name">
        </label>
        <label for="password">Password
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <label for="birthDate">Birth Date
            <input type="date" class="input-field" name="birthDate" id="birthDate">
        </label>
        <input type="submit" value="sighUp">

    </form>
</div>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Alredy registered
    </div>
    <table>
        <tr>
            <th>User name</th>
            <th>Password is</th>
            <th>Birth date is</th>
        </tr>

        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>
                        ${user.name }
                        ${user.password }
                        ${user.birthDate }
                </td>
            </tr>
        </c:forEach>

    </table>
</div>
<a href="${pageContext.request.contextPath}/login">Login</a>

</body>
</html>
