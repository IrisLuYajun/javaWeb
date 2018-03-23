
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
        <h2>已添加到购物车的商品</h2>
    </div>
    <table class="m-table m-table-row n-table g-b3">
        <colgroup><col class="img"/><col/><col class="time"/><col class="price"/></colgroup>
        <thead>
            <tr><th>商品名称</th><th>价格</th></tr>
        </thead>
        <tbody>
        <!-- 商品循环开始 -->
       	 <s:iterator value="#session.cartList">
            <tr>
                <td><h4><a href="<%=basePath%>product_show.action?pid=<s:property value="pid"/>"><s:property value="title"/></a></h4></td>
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
    <s:if test="#session.sum=='0.0'">
        <a href="">购买</a>
    </s:if>
    <s:elseif test="#session.sum!='0'">
    	<a href="<%=basePath%>product_buyCart.action">购买</a>
    </s:elseif>
    <input type="button" value="退出" onclick="javascript:history.go(-1);">
</div>
<s:debug></s:debug>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
</body>
</html>