<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/21
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>这不是主页</title>
</head>
<body>
<h1>用户列表</h1>
<table>
    <tr>
        <th>用户主键</th>
        <th>用户姓名</th>
        <th>用户密码</th>
        <th>用户邮箱</th>
        <th>用户性别</th>
        <th>用户flag</th>
        <th>用户role</th>
        <th>用户code</th>
    </tr>
    <c:forEach var="user" items="${list}">
    <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
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
