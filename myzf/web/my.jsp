<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/6 0006
  Time: 上午 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<HTML>
<HEAD>
    <TITLE>北京出租房</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">

    <link href="style/mycss.css" rel="stylesheet" type="text/css" />
    <link href="style/texts.css" rel="stylesheet" type="text/css" />
    <link href="style/btn.css" rel="stylesheet" type="text/css" />

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
            <table>
                <tr>
                    <td width="3%">&nbsp;</td>
                    <td width="97%">


                        <table width='450' border='0'>
                            <tr>
                                <TD>标题</TD>
                                <TD width='100' align='center'>月租金</TD>
                                <TD width='110'align='center'>发布日期</TD>
                                <TD width='50'>&nbsp;</TD>
                                <TD width='50'>&nbsp;</TD>
                            </tr>
                            <tr>
                                <td colspan='5'><hr/></td>
                            </tr>
                            <c:forEach var="fwxx" items="${fwxxList}">
                                <tr onmouseover="this.style.background='#EfEfEf'" onmouseout="this.style.background='#FFFFFF'">
                                    <td><a href='IndexAction_detail?fwxx.fwid=${fwxx.fwid}'>${fwxx.title}</a></td>
                                    <td align='center' style='height:30px;'>${fwxx.zj}元</td>
                                    <td align='center'><fmt:formatDate value="${fwxx.date}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                                    <td align='center' style='height:30px;'><a href='FwxxAction_delete?fwxx.fwid=${fwxx.fwid}' onclick="return confirm('您确定要删除吗?')">[删除]</a></td>
                                    <td align='center' style='height:30px;'><a href='FwxxAction_toUpdate?fwxx.fwid=${fwxx.fwid}'>[修改]</a></td>
                                </tr>
                            </c:forEach>

                            <tr>
                                <td colspan='5'><hr/></td>
                            </tr>
                            <tr>
                                <td colspan='5'>
                                    共${myPage.rowCount}条&nbsp;第${myPage.pageNo}/${myPage.pageCount}页&nbsp;
                                    <c:forEach var="p"  begin="1" end="${myPage.pageCount}">
                                        <a href="FwxxAction_findMyList?myPage.pageNo=${p}&fwxxCon.fwxx.user.uid=${sessionScope.LOGIN_USER.uid}">${p}</a>&nbsp;
                                    </c:forEach>
                                </td>
                            </tr>
                        </table>




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