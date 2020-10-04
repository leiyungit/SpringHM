<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/10/3
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>参数</title>
</head>
<body>

    <form action="param/saveUser" method="post">
        账号： <input type="text" name="uname"> <br />
        年龄： <input type="text" name="age"> <br />
        生日： <input type="text" name="date"> <br />
        <input type="submit" value="提交">
    </form>
</body>
</html>
