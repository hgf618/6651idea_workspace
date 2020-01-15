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
    <script language="javascript">
        function  checkForm() {
            //设置区县名称
            var qxSelObj = document.getElementById("qxid");
            var qxName=qxSelObj.options[qxSelObj.selectedIndex].innerText;
            document.getElementById("qxName").value=qxName;

            //设置街道名称
            var jdSelObj = document.getElementById("jdid");
            var jdName=jdSelObj.options[jdSelObj.selectedIndex].innerText;
            document.getElementById("jdName").value=jdName;

            //设置房屋类型的id和房屋类型名称
            var fwlxSelObj = document.getElementById("lxid");
            var fwlxName=fwlxSelObj.options[fwlxSelObj.selectedIndex].innerText;
            document.getElementById("fwlx").value=fwlxName;



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

            <s:form action="post_confirm.jsp" method="post" name="mf" onsubmit="return checkForm()">
                <table>
                    <tr>
                        <td colspan="2">发布租房信息：</td>
                    </tr>
                    <tr>
                        <td colspan="2"><hr/></td>
                    </tr>
                    <tr>
                        <td><strong>标题：</strong></td>
                        <td><s:textfield name="title" label="标题t"></s:textfield>  </td>
                    </tr>
                    <tr>
                        <td><strong>区县：</strong></td>
                        <td class="myClass">
                            <s:doubleselect name="qxid" id="qxid" list="qxList" listKey="qxid" listValue="qx"
                                            doubleName="jdid" doubleId="jdid"  doubleList="qxJdMap[top.qxid]" doubleListKey="jdid" doubleListValue="jd">
                            </s:doubleselect>
                            <input type="hidden" name="qxName" id="qxName">
                            <input type="hidden" name="jdName" id="jdName">
                        </td>
                    </tr>

                    <tr>
                        <td><strong>租金：</strong></td>
                        <td><s:textfield name="zj"></s:textfield>  元/月</td>
                    </tr>
                    <tr>
                        <td><strong>户型：</strong></td>
                        <td>
                            <s:select name="shi" list="#{1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8,9:9}"></s:select>室
                            <s:select name="ting" list="#{1:1,2:2,3:3,4:4,5:5}"></s:select>厅
                        </td>
                    </tr>
                    <tr>
                        <td><strong>房屋类型：</strong></td>
                        <td>
                            <s:select name="lxid" id="lxid" list="fwlxList" listKey="lxid" listValue="fwlx" onchange="setFwlxName()"></s:select>
                            <input type="hidden" id="fwlx" name="fwlx">
                            <script language="javascript">
                                function setFwlxName(value) {
                                    var fwlxSelObj = document.getElementById("lxid");
                                    var fwlxName=fwlxSelObj.options[fwlxSelObj.selectedIndex].innerText;
                                    document.getElementById("fwlx").value=fwlxName;
                                }
                            </script>
                           </td>
                    </tr>
                    <tr>
                        <td><strong>联系电话：</strong></td>
                        <td><s:textfield name="telephone"></s:textfield>  </td>
                    </tr>
                    <tr>
                        <td><strong>联系人：</strong></td>
                        <td><s:textfield name="lxr"></s:textfield> </td>
                    </tr>
                    <tr>
                        <td><strong>房屋信息：</strong></td>
                        <td>
                            <s:textarea name="fwxx" rows="10" cols="40"></s:textarea>
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