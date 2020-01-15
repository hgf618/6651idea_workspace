<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/17 0017
  Time: 上午 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<s:iterator value="{'a','b'}" status="s">
    <s:property value="#s.getIndex()"></s:property>&nbsp;&nbsp;
    <s:property></s:property><br>
</s:iterator>
<br><br>
<s:set var="testname" value="'Java'"/><!--字符串用单引号-->
<s:if test="%{#testname=='java'}">
    <div>Will Not Be Executedaaaaaa</div>
</s:if>
<s:elseif test="%{#testname=='Java'}">
    <div>Will Be Executedb bbbb</div>
</s:elseif>
<s:else>
    <div>Will Not Be Executedcccccc</div>
</s:else>


<br><br>
<s:select label="请选择" name="select"
          list="%{#{'platform':'开发平台','softwareType':'软件类型','market':'市场定向'}}">
    <s:optgroup label="开发语言"
                list="%{#{'java':'JAVA','c':'C++','matlab':'MATLAB'}}" />
    <s:optgroup label="数据库"
                list="%{#{'mysql':'MySQL','Oracle':'Oracle'}}" />
</s:select>



</body>
</html>
