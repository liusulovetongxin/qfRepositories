<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/22
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/user/login" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
    </table>
    <button type="submit">登录</button>
    <a href="regist.jsp"><button type="button">注册</button></a>
</form>
</body>
</html>
