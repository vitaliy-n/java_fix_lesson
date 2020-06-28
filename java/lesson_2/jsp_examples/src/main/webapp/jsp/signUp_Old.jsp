<%@ page import="java.util.ArrayList" %>
<%@ page import="com.cheba00.models.User" %><%--
  Created by IntelliJ IDEA.
  User: Vitaliy
  Date: 12/23/2019
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% ArrayList<User> users = (ArrayList) request.getAttribute("usersFromServer");%>
<table>
    <tr>
        <th>User name is</th>
        <th>Password is</th>
        <th>Birth date is</th>
    </tr>
    <% for (User user : users) {%>
    <tr>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getPassword()%>
        </td>
        <td><%=user.getBirthDate()%>
        </td>
    </tr>
    <%}%>

</table>
</body>
</html>
