<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/9 0009
  Time: 上午 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags"  prefix="s"%>
<HTML>
<HEAD>
    <TITLE>北京出租房</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">

    <link href="style/mycss.css" rel="stylesheet" type="text/css" />
    <link href="style/texts.css" rel="stylesheet" type="text/css" />
    <link href="style/btn.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
        .myClass br{display: none;}
    </style>
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

            <s:form action="FwxxAction_update" method="post" name="mf" onsubmit="return validateTitle()" theme="simple">
                <s:hidden name="fwxx.fwid"></s:hidden>
                <table>
                    <tr>
                        <td colspan="2">修改租房信息：</td>
                    </tr>
                    <tr>
                        <td colspan="2"><hr/></td>
                    </tr>
                    <tr>
                        <td><strong>标题：</strong></td>
                        <td><s:textfield name="fwxx.title" label="标题t"></s:textfield>  </td>
                    </tr>
                    <tr>
                        <td><strong>区县：</strong></td>
                        <td class="myClass">
                            <s:doubleselect name="fwxx.jd.qx.qxid" list="qxList" listKey="qxid" listValue="qx"
                                            doubleName="fwxx.jd.jdid"  doubleList="qxJdMap[top.qxid]" doubleListKey="jdid" doubleListValue="jd">
                            </s:doubleselect>

                        </td>
                    </tr>

                    <tr>
                        <td><strong>租金：</strong></td>
                        <td><s:textfield name="fwxx.zj"></s:textfield>  元/月</td>
                    </tr>
                    <tr>
                        <td><strong>户型：</strong></td>
                        <td>
                            <s:select name="fwxx.shi" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8,9:9}"></s:select>室
                            <s:select name="fwxx.ting" list="#{1:1,2:2,3:3,4:4,5:5}"></s:select>厅
                        </td>
                    </tr>
                    <tr>
                        <td><strong>房屋类型：</strong></td>
                        <td>
                            <s:select name="fwxx.fwlx.lxid" list="fwlxList" listKey="lxid" listValue="fwlx"></s:select>
                           </td>
                    </tr>
                    <tr>
                        <td><strong>联系电话：</strong></td>
                        <td><s:textfield name="fwxx.telephone"></s:textfield>  </td>
                    </tr>
                    <tr>
                        <td><strong>联系人：</strong></td>
                        <td><s:textfield name="fwxx.lxr"></s:textfield> </td>
                    </tr>
                    <tr>
                        <td><strong>修改时间：</strong></td>
                        <td><s:textfield name="fwxx.date"></s:textfield> </td>
                    </tr>
                    <tr>
                        <td><strong>房屋信息：</strong></td>
                        <td>
                            <s:textarea name="fwxx.fwxx" rows="10" cols="40"></s:textarea>
                           </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <div align="center"><input type="submit" value="提交" class="btn"></div>				</td>
                    </tr>
                </table>
                </s:form>

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