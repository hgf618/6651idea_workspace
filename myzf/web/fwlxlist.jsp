<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/17 0017
  Time: 上午 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <s:iterator value="fwlxList">
        <a href="# "><s:property value="fwlx"></s:property></a><br>
    </s:iterator>
</body>
</html>
