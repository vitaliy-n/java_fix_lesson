<%@ page import="java.util.ArrayList" %>
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
    <div class="form-style-2-heading">
        Alredy registered
    </div>
    <table>
        <tr>
            <th>first name</th>
            <th>Second name</th>
            <th>Birth date is</th>
        </tr>

        <jsp:useBean id="usersFromServer" scope="request" type="java.util.List"/>
        <c:forEach items="${usersFromServer}" var="user">
            <tr>
                <td>
                        ${user.getFirstName()}
                        ${user.getLastName()}

                </td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>
</html>
