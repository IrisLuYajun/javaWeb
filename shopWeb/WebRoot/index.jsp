<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@page import="com.lyj.dao.impl.ProductDaoImpl" %>
<%@page import="com.lyj.model.Product"%>
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
<s:debug></s:debug>
<div class="n-support">请使用Chrome、Safari等webkit内核的浏览器！</div>
<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
          
            请<a href="./login.jsp">[登录]</a>
        </div>
        <ul class="nav">
            <li><a href="./index.jsp">首页</a></li>
        </ul>
    </div>
</div>
<div class="g-doc">
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li class="z-sel"><a href="<%=basePath%>product_findAll.action?uid=0">查看商品</a></li>
            </ul>
        </div>
    </div>
    
    <div class="n-plist">
        <ul class="f-cb" id="plist">
       	 <!-- 商品循环开始 -->
       	 <s:iterator value="list" var="p">
            <li id="p-<s:property value="#p.pid"/>">
                <a href="<%=basePath%>product_show.action?pid=<s:property value="#p.pid"/>" class="link">
                    <div class="img"><img src="http://nec.netease.com/img/s/<s:property value="#p.imgUrl"/>" alt=""></div>
                    <h3><s:property value="#p.title"/></h3>
                    <div class="price"><span class="v-unit">¥</span><span class="v-value"><s:property value="#p.price"/></span></div>
                </a>
            </li>
         </s:iterator>
         <!-- 商品循环结束 -->
                 
        </ul>
    </div> 
</div>
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
<script type="text/javascript" src="../js/global.js"></script>
<script type="text/javascript" src="../js/pageIndex.js"></script>
</body>
</html>