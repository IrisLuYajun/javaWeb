<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>java</title>
<link rel="stylesheet" href="../css/style.css"/>
</head>
<body>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
<s:debug></s:debug>
<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
        <s:if test="#session.username=='buyer'">
                                买家你好，
        </s:if>
        <s:elseif test="#session.username=='seller'"> 
                                卖家你好，
        </s:elseif>
        <span class="name"><s:property value="#session.existUser.username"/></span>！<a href="">[退出]</a>
        </div>
        <ul class="nav">
            <li><a href="./loginSuccess.jsp">首页</a></li>
            <s:if test="#session.username=='buyer'">
            <li><a href="<%=basePath%>product_account.action">账务</a></li>
            <li><a href="<%=basePath%>product_findCart.action">购物车</a></li>
            </s:if>
            <s:elseif test="#session.username=='seller'">
            <li><a href="./public.jsp">发布</a></li>
            </s:elseif>
        </ul>
    </div>
</div>
<div class="g-doc">
    <div class="n-result">
        <h3>编辑成功！</h3>
        <p><a href="<%=basePath%>product_show.action?pid=<s:property value="#session.product.pid"/>">[查看内容]</a><a href="./loginSuccess.jsp">[返回首页]</a></p>
    </div>
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
</body>
</html>