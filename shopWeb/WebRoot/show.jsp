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
<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
		    <s:if test="#session.username == 'buyer'">
		    	 买家你好，<span class="name"><s:property value="#session.existUser.username"/></span>！<a href="">[退出]</a>
		    </s:if>
		    <s:elseif test="#session.username == 'seller'">
		    	卖家你好，<span class="name"><s:property value="#session.username"/></span>！<a href="">[退出]</a>
		    </s:elseif>
		    <s:else>
		    	  请<a href="./login.jsp">[登录]</a>
		    </s:else> 
  		 </div>
        <ul class="nav">
            <li><a href="./loginSuccess.jsp">首页</a></li>
        </ul>
    </div>
</div>
<div class="g-doc">
    <div class="n-show f-cb" id="showContent">
        <div class="img"><img src="http://nec.netease.com/img/l/<s:property value="#session.product.pid"/>.jpg" alt=""></div>
        <div class="cnt">
            <h2><s:property value="#session.product.title"/></h2>
            <p class="summary"><s:property value="#session.product.info"/></p>
            <div class="price">
                <span class="v-unit">¥</span><span class="v-value"><s:property value="#session.product.price"/></span>
            </div>
        </div>
            <div class="oprt f-cb">
	            <s:if test="#session.username == 'buyer'">
	               <s:if test="#session.product.sold">
	               	    <span class="u-btn u-btn-primary z-dis">已购买</span>
	                    <span class="buyprice">当时购买价格：¥<s:property value="#session.product.price"/></span>
		           </s:if>
	               <s:else>
	                    <a href="<%=basePath%>product_buyIt.action?pid=<s:property value="#session.product.pid"/>" class="u-btn u-btn-primary">立即购买</a>
	                    <a href="<%=basePath%>product_putCart.action?pid=<s:property value="#session.product.pid"/>" class="u-btn u-btn-primary">加入购物车</a>
	               </s:else>
		       </s:if>
	           <s:elseif test="#session.username == 'seller'">
	           		<a href="<%=basePath%>product_edit.action?pid=<s:property value="#session.product.pid"/>" class="u-btn u-btn-primary">编 辑</a>
	           </s:elseif>
	           <s:else>
	           		
	           </s:else>
	        </div>
        </div>
    </div>
    <div class="m-tab m-tab-fw m-tab-simple f-cb">
        <h2>详细信息</h2>
    </div>
    <div class="n-detail">
        <s:property value="#session.product.detail"/>
    </div>
</div>             
<div class="n-foot">
    <p>版权所有：网易云课堂<a href="http://mooc.study.163.com/smartSpec/detail/85002.htm">Java开发工程师(Web方向)</a>微专业团队</p>
</div>
<script type="text/javascript" src="../js/global.js"></script>
<script type="text/javascript" src="../js/pageShow.js"></script>
</body>
</html>
<s:debug></s:debug>