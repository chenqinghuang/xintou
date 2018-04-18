<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/12
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>玩转spring boot——简单登录认证</title>
</head>
<body>
<h1>玩转spring boot——简单登录认证</h1>
<h4>
    <a href="http://www.cnblogs.com/GoodHelper/">from 刘冬的博客</a>
</h4>
<h3 th:text="'登录用户：' + ${name}"></h3>

<a href="/logout">注销</a>
<br />
<a href="http://www.cnblogs.com/GoodHelper/">点击访问原版博客(www.cnblogs.com/GoodHelper)</a>
</body>
</html>
