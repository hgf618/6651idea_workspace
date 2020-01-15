<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/18 0018
  Time: 上午 8:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传实例</title>

</head>
<body>
<form action="upload" enctype="multipart/form-data" method="post">
    用户名：<input type="text" name="uname"><br>
    头像：<input type="file" name="mf"><br>
    <input type="submit">
</form>

</body>
</html>
