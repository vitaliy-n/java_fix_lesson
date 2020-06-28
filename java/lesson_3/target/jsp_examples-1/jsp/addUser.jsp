<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Please Sign Up!
    </div>
    <form method="post" action="<c:url value="/users"/>">
        <label for="firstName">User name
            <input class="input-field" type="text" id="firstName" name="firstName">
        </label>
        <label for="lastName">lastName
            <input class="input-field" type="text" id="lastName" name="lastName">
        </label>
        <input type="submit" value="addUser">
    </form>
</div>
</body>