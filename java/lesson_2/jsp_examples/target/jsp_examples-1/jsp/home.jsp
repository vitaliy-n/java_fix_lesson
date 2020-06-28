<%--
  Created by IntelliJ IDEA.
  User: Vitaliy
  Date: 12/25/2019
  Time: 12:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<span style="color: ${cookie.color.value}">hello</span>
<form action="home" method="post">
    <div class="select-field">
        <select name="color" id="color">
            <option value="red">RED</option>
            <option value="green">green</option>
            <option value="yellow">yellow</option>
        </select>
    </div>
    <input type="submit" value="colorSend">
</form>
</body>
</html>
