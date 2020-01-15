<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/6 0006
  Time: 上午 9:09
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
    <script   language="javascript">
        function back(){
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
        <td width="495" align="center">

            <table width="450">
                <tr>
                    <td class="listTitle">${fwxx.title}</td>
                </tr>
                <tr>
                    <td class="listTitle"><hr/></td>
                </tr>
                <tr>
                    <td><strong><s:text name="telephone"/>：</strong>${fwxx.telephone}</td>
                </tr>
                <tr>
                    <td><strong><s:text name="contact"/>：</strong>${fwxx.lxr}</td>
                </tr>
                <tr>
                    <td><strong><s:text name="houseType"/>：</strong>${fwxx.fwlx.fwlx}</td>
                </tr>
                <tr>
                    <td><strong><s:text name="roomType"/>：</strong>${fwxx.shi} <s:text name="rooms"/> ${fwxx.ting} <s:text name="hall"/></td>
                </tr>
                <tr>
                    <td><strong><s:text name="price"/>：</strong>¥${fwxx.zj}</td>
                </tr>
                <tr>
                    <td><strong><s:text name="address"/>：</strong>${fwxx.jd.qx.qx}--&nbsp;&nbsp;${fwxx.jd.jd}</td>
                </tr>
                <tr>
                    <td><strong><s:text name="postDate"/>：</strong> ${fwxx.date}</td>
                </tr>
                <tr>
                    <td><hr></td>
                </tr>
                <tr>
                    <td >${fwxx.fwxx}</td>
                </tr>
                <tr>
                    <td><input type="button" value="<s:text name="back"/>" class="btn" onclick="back()"></td>
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