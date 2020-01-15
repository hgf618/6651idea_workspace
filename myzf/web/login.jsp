<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/3 0003
  Time: 上午 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<HTML>
<HEAD>
    <TITLE>北京出租房</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">

    <link href="style/mycss.css" rel="stylesheet" type="text/css" />
    <link href="style/texts.css" rel="stylesheet" type="text/css" />
    <link href="style/btn.css" rel="stylesheet" type="text/css" />
    <script lang="javascript">
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
    </script>
</HEAD>
<BODY BGCOLOR=#FFFFFF LEFTMARGIN=0 TOPMARGIN=0 MARGINWIDTH=0 MARGINHEIGHT=0>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td colspan="5"><img src="images/top.jpg" width="780" height="213"></td>
    </tr>
    <tr>
        <td colspan="5"><img src="images/middle1.jpg" width="780" height="47"></td>
    </tr>
    <tr>
        <td width="38" background="images/middle2.jpg">&nbsp;</td>
        <td width="172">
            <table align="center">
                <tr>
                    <td><a href="IndexAction_search"><s:text name="backHome"/></a></td>
                </tr>
                <tr>
                    <td><a href="GoAction_register"><s:text name="userRegister"/></a></td>
                </tr>
            </table>
        </td>
        <td width="35" background="images/layout_24.gif">&nbsp;</td>
        <td width="495">
            <form action="UserAction_login" method="post" name="myForm"><!-- onsubmit="return login()"-->
                <table align="center">
                    <tr>
                        <td colspan="3" align="center">

                        </td>
                    </tr>
                    <tr>
                        <td colspan="3"><s:text name="userLogin"/>：&nbsp;</td>
                    </tr>
                    <tr>
                        <td colspan="3"><hr/></td>
                    </tr>
                    <tr>
                        <td><s:text name="userName"/>：</td>
                        <td><input type="text" name="user.uname" id="uname"></td>
                        <td> <s:fielderror fieldName="unameError"></s:fielderror>
                        <s:fielderror fieldName="user.uname"></s:fielderror>
                        </td>
                    </tr>
                    <tr>
                        <td><s:text name="userPass"/>：</td>
                        <td><input type="password" name="user.upass" id="upass"></td>
                        <td> <s:fielderror fieldName="userPassError"></s:fielderror>
                            <s:fielderror fieldName="user.upass"></s:fielderror>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="hidden" name="sign" value="login"/>
                            <input type="submit" value="<s:text name="login"/>" class="btn">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" style="color:red;">${msg}</td>
                    </tr>
                </table>
            </form>
        </td>
        <td width="40" background="images/middle4.jpg">&nbsp;</td>
    </tr>
    <tr>
        <td colspan="5"><img src="images/bottom.jpg" width="780" height="82"></td>
    </tr>
</table>
<jsp:include page="foot.jsp"></jsp:include>
</BODY>
</HTML>