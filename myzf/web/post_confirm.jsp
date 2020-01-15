<%@ taglib prefix="c" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/12 0012
  Time: 上午 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<HTML>
<HEAD>
    <TITLE>北京出租房</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">

    <link href="style/mycss.css" rel="stylesheet" type="text/css" />
    <link href="style/texts.css" rel="stylesheet" type="text/css" />
    <link href="style/btn.css" rel="stylesheet" type="text/css" />
    <script   language="javascript">
        function back()
        {
            window.history.back();
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
        <td width="172" valign="top">
            <jsp:include page="left.jsp"></jsp:include>
        </td>
        <td width="35" background="images/layout_24.gif">&nbsp;</td>
        <td width="495">
            <table width="460">
                <tr>
                    <td>请确认您要发布的信息：</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td colspan="2"><hr/></td>
                </tr>
                <tr>
                    <td>${param.title}<br/></td>
                </tr>
                <tr>
                    <td><strong>电话/手机：</strong>${param.telephone}</td>
                </tr>
                <tr>
                    <td><strong>联系人：</strong>${param.lxr}</td>
                </tr>
                <tr>
                    <td><strong>房屋类型：</strong>${param.fwlx}</td>
                </tr>
                <tr>
                    <td><strong>户型：</strong>${param.shi}室${param.ting}厅</td>
                </tr>
                <tr>
                    <td><strong>价格：</strong>${param.zj}元</td>
                </tr>
                <tr>
                    <td><strong>地段：</strong>${param.qxName}&nbsp;${param.jdName}</td>
                </tr>
                <tr>
                    <td><strong>发布时间：</strong>
                        <jsp:useBean id="today" class="java.util.Date"></jsp:useBean>
                        <c:set var="date">
                            <fmt:formatDate pattern="yyyy-MM-dd  HH:mm:ss" value="${today}" />
                        </c:set>
                        ${date}
                        </td>
                </tr>
                <tr>
                    <td><hr></td>
                </tr>
                <tr>
                    <td>${param.fwxx}</td>
                </tr>
                <tr>
                    <td><hr></td>
                </tr>
                <tr>
                    <td>
                        <form action="FwxxAction_post" method="POST">
                            <input type="hidden" name="fwxx.title" value="${param.title}"/>
                            <input type="hidden" name="fwxx.telephone" value="${param.telephone}"/>
                            <input type="hidden" name="fwxx.lxr" value="${param.lxr}"/>
                            <input type="hidden" name="fwxx.shi" value="${param.shi}"/>
                            <input type="hidden" name="fwxx.ting" value="${param.ting}"/>
                            <input type="hidden" name="fwxx.fwlx.lxid" value="${param.lxid}"/>
                            <input type="hidden" name="fwxx.jd.jdid" value="${param.jdid}"/>
                            <input type="hidden" name="fwxx.fwxx" value="${param.fwxx}"/>
                            <input type="hidden" name="fwxx.date" value="${date}"/>
                            <input type="hidden" name="fwxx.zj" value="${param.zj}"/>
                            <input type="submit" value="确认提交" class="btn" >&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="button" value="返回修改" class="btn" onclick="back()">
                        </form>
                    </td>
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