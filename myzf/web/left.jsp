<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/6 0006
  Time: 上午 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${sessionScope.LOGIN_USER==null}">
    <script language="javascript">
        <!--
        function login(){
            if( document.getElementById("uname").value =="" ){
                alert("用户名不能为空");
                document.getElementById("uname").focus();
                return false;
            }else if(document.getElementById("upass").value == ""){
                alert("密码不能为空");
                document.getElementById("upass").focus();
                return false;
            } else {
                return true;
            }
        }
        -->
    </script>

    <form action="UserAction_login" method="post" name="myForm" onsubmit="return login()">
        <p>&nbsp;</p>
        <table align="center">
            <tr>
                <td colspan="2"><s:text name="userName"/>：</td>
            </tr>
            <tr>
                <td colspan="2"><input type="text" name="user.uname" size=10" class="editbox"></td>
            </tr>
            <tr>
                <td colspan="2"><s:text name="userPass"/>：</td>
            </tr>
            <tr>
                <td colspan="2"><input type="password" name="user.upass" size=10"  class='editbox'></td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" name="sign" value="login"/>
                    <input type="submit" value="<s:text name="login"/>" class='btn'>
                    <input type="reset" value="<s:text name="reset"/>" class='btn'>
                </td>
            </tr>
            <tr>
                <td><a href="GoAction_register"><s:text name="userRegister"/></a></td>
            </tr>
        </table>
    </form>
</c:if>



<c:if test="${sessionScope.LOGIN_USER!=null}">
    <table align="center">
        <tr>
            <td width=''><font color='red'><s:text name="currentUser"/>：

                    ${sessionScope.LOGIN_USER.uname}</font>
            </td>
        </tr>
        <tr>
            <td width='150'><a href="FwxxAction_findMyList?fwxxCon.fwxx.user.uid=${sessionScope.LOGIN_USER.uid}"><s:text name="manageMyFwxx"/></a></td>
        </tr>
        <tr>
            <td width='100'><a href="FwxxAction_toPost"><s:text name="postFwxx"/></a></td>
        </tr>
        <tr>
            <td width='100'><a href="IndexAction_search"><s:text name="backHome"/></a></td>
        </tr>
        <tr>
            <td width='100'><a href="UserAction_logOut">[<s:text name="logOut"/>]</a></td>
        </tr>
    </table>
</c:if>

    <s:action name="FwlxAction" executeResult="true"></s:action><!--访问Action并把结果返回-->


</body>
</html>
