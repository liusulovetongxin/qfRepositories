<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/22
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>用户id</th>
        <th>用户姓名</th>
        <th>用户邮箱</th>
        <th>用户性别</th>
        <th>用户flag</th>
        <th>用户role</th>
        <th>用户code</th>
    </tr>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.gender}</td>
            <td>${user.flag}</td>
            <td>${user.role}</td>
            <td>${user.code}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
