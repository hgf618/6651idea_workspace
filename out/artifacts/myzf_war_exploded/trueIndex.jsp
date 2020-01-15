<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/3 0003
  Time: 上午 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%--  原来的
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  </body>
</html>
--%>


<HTML>
<HEAD>
    <TITLE>北京出租房</TITLE>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">

    <link href="style/mycss.css" rel="stylesheet" type="text/css" />
    <link href="style/texts.css" rel="stylesheet" type="text/css" />
    <link href="style/btn.css" rel="stylesheet" type="text/css" />
    <style>td{border:solid 0px blue;}
    .table_title{
        border:solid 1px #aaa;
        border-width:0 0 1px 0;
    }
    .myClass br{display: none;}
    </style>
    <script language="javascript">
        function  jump(pno) {
            document.getElementById("newPageNo").value=pno;//要要跳转到的页码值传递给表单的页码隐藏域
            document.mf.submit();//提交表单
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
        <td width="172" valign="top" align="center">

            <a href="LanguageAction?request_locale=zh_CN">中文</a>&nbsp;&nbsp;
            <a href="LanguageAction?request_locale=en_US">English</a><br>

            <jsp:include page="left.jsp"></jsp:include>

        </td>

        <td width="35" background="images/layout_24.gif">&nbsp;</td>
        <td width="495" align="center" style="vertical-align: top;"><br/>
            <s:form action="IndexAction_search" method="post" name="mf" theme="simple">
                <input type="hidden" name="myPage.pageNo" value="1" id="newPageNo">
                <script>
                    function fswitch(id){
                        var o = document.getElementById(id);
                        if (o){
                            if (o.style.display == "none"){ o.style.display = "block"; } else {o.style.display = "none";}
                        }
                    }
                </script>
                <div style="text-align:left;width:88%;">
                    <s:textfield name="fwxxCon.fwxx.title"/>
                    <s:submit value="查询" class="btn"></s:submit>
                    <span onclick="fswitch('advSearch');" style="cursor:hand;color:blue;"><s:text name="advanceSearch"/></span>
                </div>

                <table width="88%;" id="advSearch" style="border:solid 0px #000;display:none;">
                    <tr>
                        <td width="80px">区县街道：</td>
                        <td class="myClass" > <s:doubleselect name="fwxxCon.fwxx.jd.qx.qxid" list="qxList" listKey="qxid" listValue="qx"
                                              doubleName="fwxxCon.fwxx.jd.jdid"  doubleList="qxJdMap[top.qxid]" doubleListKey="jdid" doubleListValue="jd">
                        </s:doubleselect></td>
                        <td rowspan="6">&nbsp;</td>
                    </tr>

                    <tr>
                        <td>租金：</td>
                        <td> <s:textfield name="fwxxCon.zj1" size="5" class="unnamed1"/>  至 <s:textfield name="fwxxCon.zj2" size="5" class="unnamed1"/>  元/月</td>
                    </tr>
                    <tr>
                        <td>户型：</td>
                        <td> <s:select name="fwxxCon.fwxx.shi" list="#{0:'不限--',1:1,2:2,3:3,4:4,5:5,6:6,7:7,8:8,9:9}" style="width:60px"></s:select>室
                            <s:select name="fwxxCon.fwxx.ting" list="#{0:'不限--',1:1,2:2,3:3,4:4,5:5}" style="width:60px"></s:select>厅</td>
                    </tr>
                    <tr>
                        <td>房屋类型：</td>
                        <td>
                            <s:checkboxlist name="fwxxCon.lxids" list="fwlxList" listKey="lxid" listValue="fwlx"></s:checkboxlist>
                        </td>
                    </tr>
                    <tr>
                        <td>发布日期：</td>
                        <td>
                            <s:select name="fwxxCon.days" list="#{0:'不限--',1:'当天',2:'近两天',7:'近一周',14:'近两周',30:'近一月'}" style="width:80px"></s:select>
                           </td>
                    </tr>
                    <tr>
                        <td colspan='3'><hr/></td>
                    </tr>

                </table>
            </s:form>
                <table width="88%" cellspacing="0">
                    <tr  >
                        <TD width='250' class="table_title"><s:text name="title"/></TD>
                        <TD width='100' class="table_title"><s:text name="houseType"/></TD>
                        <TD width='80' class="table_title"><s:text name="address"/></TD>
                        <TD width='90' align='center' class="table_title"><s:text name="moneyPerMonth"/></TD>
                        <TD width='100' align='center' class="table_title"><s:text name="postDate"/></TD>
                    </tr>
                    <%--
                    <c:if test="${fwxxList==null || fwxxList.size()==0}">
                        <tr><td colspan="5">抱歉！暂无符合要求的记录！</td></tr>
                    </c:if>
                    <c:if test="${fwxxList!=null && fwxxList.size()>0}">
                        <c:forEach var="fwxx" items="${fwxxList}">
                            <tr>
                                <td><a href='IndexAction_detail?fwxx.fwid=${fwxx.fwid}'>${fwxx.title}</a></td>
                                <td>${fwxx.fwlx.fwlx}</td>
                                <td>${fwxx.jd.qx.qx}</td>
                                <td align='center' style='height:30px;'>${fwxx.zj}元</td>
                                <td align='center'><fmt:formatDate value="${fwxx.date}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <tr><td colspan="5"><hr></td></tr>--%>
                    <s:if test="fwxxList==null || fwxxList.size()==0">
                        <tr><td colspan="5">抱歉！暂无符合要求的记录！</td></tr>
                    </s:if>
                    <s:else>
                        <s:set var="myno" value="1"></s:set><!--定义一个变量-->
                        <s:iterator value="fwxxList">
                            <tr>
                                <td><s:property value="#myno"></s:property><a href='IndexAction_detail?fwxx.fwid=<s:property value="fwid"/>'> <s:property value="title"></s:property> </a></td>
                                <td><s:property value="fwlx.fwlx"/>  </td>
                                <td><s:property value="jd.qx.qx"/></td>
                                <td align='center' style='height:30px;'><s:property value="zj"/>元</td>
                                <td align='center'><s:date name="date" format="yyyy-MM-dd"></s:date></td>
                            </tr>
                            <s:set var="myno" value="#myno+1"></s:set>
                        </s:iterator>

                        <tr>
                            <td colspan='5'><hr/></td>
                        </tr>
                        <tr>
                            <td colspan='5'>
                                共${myPage.rowCount}条&nbsp;第${myPage.pageNo}/${myPage.pageCount}页&nbsp;
                                <c:forEach var="p"  begin="1" end="${myPage.pageCount}">
                                    <a href="javascript:jump(${p})">${p}</a>&nbsp;
                                </c:forEach>


                            </td>
                        </tr>
                    </s:else>
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