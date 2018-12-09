<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head lang="en">
	<meta charset="UTF-8">
	<title>登录</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta name="format-detection" content="telephone=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />

	<link rel="stylesheet" href="<%=request.getContextPath()%>/AmazeUI-2.4.2/assets/css/amazeui.css" />
	<link href="<%=request.getContextPath()%>/css/dlstyle.css" rel="stylesheet" type="text/css">
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>
	<script type="text/javascript">
		 
		//提交之前进行检查，如果return false，则不允许提交
		function check(){
		//根据ID获取值
		var username=document.getElementById("username").value;
		var password=document.getElementById("password").value;
		if(username==""){
		alert("用户名不能为空");
		return false;
		
		}
		if(password==""){
		alert("密码不能为空");
		return false;
		}
		return true;	
		}	 
	</script>
</head>
<body>
	<div class="login-boxtitle">
		<a href="index.html"><img alt="logo" src="<%=request.getContextPath()%>/images/logobig.png" /></a>
	</div>

	<div class="login-banner" style="height: 500px;">
		<div class="login-main" style="padding-top: 25px;">
			<div class="login-banner-bg"><span></span><img src="<%=request.getContextPath()%>/images/big.jpg" /></div>
			<div class="login-box">
				<h3 class="title" style="margin-top:25px">登录商城</h3>
				<div class="clear"></div>
				<div class="login-form">
				  <form action="userLoginServlet" method="post"  onsubmit="return check()">
				  		<input type="hidden" name="redirectUrl" value="${redirectUrl }">
					    <div class="user-name">
						    <label for="user"><i class="am-icon-user"></i></label>
						    <input type="text" name="uname" id="username" placeholder="请输入用户名">
                   		</div>
                   		<hr/>
		                 <div class="user-pass">
						    <label for="password"><i class="am-icon-lock"></i></label>
						    <input type="password" name="pwd" id="password" placeholder="请输入密码">
		                 </div>
		                 <hr />
						<div class="am-cf">
							<input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm">
						</div>
                       </form>
         		</div>
           		<div class="login-links">
					<a href="RegisterReqest" class="zcnext am-fr am-btn-default">注册</a><br />
          		</div>
				<div class="partner">		
					<h3>合作账号</h3>
					<div class="am-btn-group">
						<li><a href="#"><i class="am-icon-qq am-icon-sm"></i><span>QQ登录</span></a></li>
						<li><a href="#"><i class="am-icon-weibo am-icon-sm"></i><span>微博登录</span> </a></li>
						<li><a href="#"><i class="am-icon-weixin am-icon-sm"></i><span>微信登录</span> </a></li>
					</div>
				</div>	
			</div>
		</div>
	</div>
	
	<div class="footer ">
		<div class="footer-hd ">
			<p>
				<a href="# ">恒望科技</a>
				<b>|</b>
				<a href="# ">商城首页</a>
				<b>|</b>
				<a href="# ">支付宝</a>
				<b>|</b>
				<a href="# ">物流</a>
			</p>
		</div>
		<div class="footer-bd ">
			<p>
				<a href="# ">关于恒望</a>
				<a href="# ">合作伙伴</a>
				<a href="# ">联系我们</a>
				<a href="# ">网站地图</a>
				<em>© 2015-2025 Hengwang.com 版权所有</em>
			</p>
		</div>
	</div>
	

<script type="text/javascript">


$(function() {
	<%if(request.getAttribute("loginMsg")!=null){ %>
		alert("<%=request.getAttribute("loginMsg")%>");
	<%} %>
	//判断是不是在框架中打开，是就重定向一下
	if(top.location!=self.location){
		top.location=self.location;
	}
});
</script>

</body>

</html>