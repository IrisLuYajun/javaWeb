
<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta charset="utf-8"/>
<title>java</title>
<link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
            买家你好，<span class="name"><s:property value="#session.username"/></span>！<a href="">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="./loginSuccess.jsp">首页</a></li>
            <li><a href="<%=basePath%>product_account.action">账务</a></li>
            <li><a href="<%=basePath%>product_findCart.action">购物车</a></li>
        </ul>
    </div>
</div>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>已购买的内容</h2>
    </div>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup><col class="img"/><col/><col class="time"/><col class="price"/></colgroup>
        <thead>
            <tr><th>内容图片</th><th>内容名称</th><th>购买时间</th><th>购买价格</th></tr>
        </thead>
        <tbody>
        <%int sum = 0; %>
        <!-- 商品循环开始 -->
       	 <s:iterator value="#session.soldList">
            <tr>
                <td><a href="<%=basePath%>product_show.action?pid=<s:property value="pid"/>"><img src="http://nec.netease.com/img/s/<s:property value="imgUrl"/>.jpg" alt=""></a></td>
                <td><h4><a href="<%=basePath%>product_show.action?pid=<s:property value="pid"/>"><s:property value="title"/></a></h4></td>
                <td><span class="v-time"><s:property value="time"/></span></td>
                <td><span class="v-unit">¥</span><span class="value"><s:property value="price"/></span></td>
            </tr>
             </s:iterator>
<!-- 商品循环结束 -->   
        </tbody>
        <tfoot>
            <tr>
                <td colspan="3"><div class="total">总计：</div></td>
                <td><span class="v-unit">¥</span><span class="value"><s:property value="#session.sum"/></span></td>
            </tr>
        </tfoot>
    </table>
</div>
<s:debug></s:debug>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
</body>
</html>