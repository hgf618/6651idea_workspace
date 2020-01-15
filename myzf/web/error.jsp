<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/6 0006
  Time: 上午 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>



<HTML>
<HEAD>
    <TITLE>北京出租房</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">

    <link href="style/mycss.css" rel="stylesheet" type="text/css" />
    <link href="style/texts.css" rel="stylesheet" type="text/css" />
    <link href="style/btn.css" rel="stylesheet" type="text/css" />
    <script language="javascript">
        var n=5;
        function tiao(){
            n--;
            document.getElementById("timeLate").innerHTML=n;
            if(n==0){
                location.href=document.getElementById("tiaoUrl").getAttribute("href");
            }
        }
        var t=setInterval("tiao()",1000);//每隔一秒


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
        <td width="172" valign="top">

         <jsp:include page="left.jsp"></jsp:include>
        </td>
        <td width="35" background="images/layout_24.gif">&nbsp;</td>
        <td width="495">
            <table align="center">
                <tr>
                    <td width="3%" >&nbsp;</td>
                    <td width="97%" >
                        <img src="images/error.jpg">
                        <h2 align="center">${ fn:split(msgUrl,'-')[0] } </h2>
                       <p align="center" style="font-size:14px;"> 过<span id="timeLate" style="color:red;font-size:24px;">5</span>自动跳转!&nbsp;
                           点击<a id="tiaoUrl" href="${ fn:split(msgUrl,'-')[1] }" style="text-decoration: underline;font-size:24px;color:blue;">跳转</a></p>


                    </td>
                </tr>
                <tr>
                    <td colspan="2"></td>
                </tr>
            </table>
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