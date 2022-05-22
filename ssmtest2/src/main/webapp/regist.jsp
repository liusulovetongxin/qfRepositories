<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/22
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<form action="/user/regist" method="post">
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
        <tr>
            <td>邮箱</td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <select name="gender">
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </td>
        </tr>

    </table>
    <button type="submit">注册</button>
</form>
</body>
</html>
