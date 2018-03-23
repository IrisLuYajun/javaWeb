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
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <div class="tab">
            <ul>
                <li class="z-sel"><a href="<%=basePath%>product_findAll.action?uid=<s:property value="#session.existUser.uid"/>">所有商品</a></li>
                <s:if test="#session.username=='buyer'">
	            	<li><a href="<%=basePath%>product_findUnsoldForBuyer.action">未购买的商品</a></li>
	            </s:if>
	            
            </ul>
        </div>
    </div>
     
    <div class="n-plist">
        <ul class="f-cb" id="plist">
         <!-- 商品循环开始 -->
       	 <s:iterator value="#session.allList">
            <li id="p-pid">
                <a href="<%=basePath%>product_show.action?pid=<s:property value="pid"/>" class="link">
                    <div class="img"><img src="http://nec.netease.com/img/s/<s:property value="imgUrl"/>" alt=""></div>
                    <h3><s:property value="title"/></h3>
                    <div class="price"><span class="v-unit">¥</span><span class="v-value"><s:property value="price"/></span></div>
               		<s:if test="#session.username=='buyer'">
	               		<s:if test="sold"> 
	               			<span class="had"><b>已购买</b></span>
	               		</s:if>
               		</s:if>
               		<s:elseif test="#session.username=='seller'">
               			<s:if test="sold"> 
	               			<span class="had"><b>已售出</b></span>
	               		</s:if>
	               		<s:else>
	               			<a href="<%=basePath%>product_delete.action?pid=<s:property value="pid"/>">删除</a>
	               		</s:else>
               		</s:elseif>
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