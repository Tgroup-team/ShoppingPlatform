<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>后台管理</title>

<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">

<link href="css/personal.css" rel="stylesheet" type="text/css">

<link href="css/systyle.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/jquery.min.js"
	type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/AmazeUI-2.4.2/assets/js/amazeui.js" type="text/javascript"></script>

</head>
<body style="background: transparent; height: 1000px;">
	<!--头 -->
	<header>
		<article>
			<div class="mt-logo">
				<!--顶部导航条 -->
				<div class="am-container header">
					<ul class="message-l">
						<div class="topMessage">
							<div class="menu-hd">
								<a href="#" target="_top" class="h">欢迎回来，管理员</a>

							</div>
						</div>
					</ul>
					<ul class="message-r">

						<div class="topMessage my-shangcheng">
							<div class="menu-hd MyShangcheng">
								<a href="#" target="_top"><i
									class="am-icon-user am-icon-fw"></i>个人中心</a>
							</div>
						</div>

						<div class="topMessage home">
							<div class="menu-hd">
								<a href="#" target="_top" class="h">商城首页</a>
							</div>
						</div>

						<div class="  topMessage mini-cart">
							<div class="menu-hd">
								<a id="mc-menu-hd" href="#" target="_top"><i
									class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
									id="J_MiniCartNum" class="h"></strong></a>
							</div>
						</div>

						<div class="topMessage favorite1">
							<div class="menu-hd">
								<a href="#" target="_top"><span>管理员中心</span></a>
							</div>
						</div>

					</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="m-user">
					<!--个人信息 -->
					<div class="m-bg"></div>
					<div class="m-userinfo">
						<div class="m-baseinfo">
							<a href="${pageContext.request.contextPath}/admin/information.jsp"> <img
								src="${pageContext.request.contextPath}/images/getAvatar.do.jpg">
							</a> <em class="s-name">管理员</em>
						</div>
						<div class="m-right">
							<div class="m-new">
								<a href="${pageContext.request.contextPath}/admin/news.jsp"><i class="am-icon-bell-o"></i>消息</a>
							</div>
						</div>
					</div>
				</div>
				<div class="box-container-bottom"></div>

				<div class="clear"></div>
			</div>
			</div>
		</article>
	</header>

	<div class="center">
		<div class="col-main">

			<!--浮动框架-->
			<div class="main-wrap" style="background-color: #ffffff;">
				<iframe width="1000" height="800" name="main" src="${pageContext.request.contextPath}/admin/catagory1.jsp"
					scrolling="no" allowTransparency="true"></iframe>

			</div>

			<!--底部-->
			<div class="footer">
				<div class="footer-hd">
					<p>
						<a href="#">恒望科技</a> <b>|</b> <a href="#">商城首页</a> <b>|</b> <a
							href="#">支付宝</a> <b>|</b> <a href="#">物流</a>
					</p>
				</div>
				<div class="footer-bd">
					<p>
						<a href="#">关于恒望</a> <a href="#">合作伙伴</a> <a href="#">联系我们</a> <a
							href="#">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有</em>
					</p>
				</div>
			</div>
		</div>

		<!--左导航栏-->
		<aside class="menu">
			<ul>
				<li class="person active"><a href="#">社区管理员系统</a></li>
				<li class="person"><a href="#">产品类别管理</a>
					<ul>
						<li><a href="categoryservlet" target="main">产品类别</a></li>

					</ul></li>
				<li class="person"><a href="#">产品管理</a>
					<ul>
						<li><a href="productservlet" target="main">添加产品</a></li>

					</ul></li>
				<li class="person"><a href="#">订单管理</a>
					<ul>
						<li><a href="porderservlet" target="main">查看订单</a></li>
						<li><a href="returnservlet" target="main">退货</a></li>
					</ul></li>
				<li class="person"><a href="#">社区管理</a>
					<ul>
						<li><a href="applyservlet" target="main">团长审核</a></li>
						<li><a href="communityservlet" target="main">添加社区</a></li>

					</ul></li>
				<li class="person"><a href="#">我的账户</a>
					<ul>

						<li><a href="scanbaccounts" target="main">余额账户</a></li>

					</ul></li>

			</ul>

		</aside>
	</div>

</body>
</html>