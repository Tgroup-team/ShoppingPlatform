<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>个人中心</title>

		<link href="Style/user/css/admin.css" rel="stylesheet" type="text/css">
		<link href="Style/user/css/amazeui.css" rel="stylesheet" type="text/css">
		<link href="Style/user/css/personal.css" rel="stylesheet" type="text/css">
		<link href="css/systyle.css" rel="stylesheet" type="text/css">
		
		

		<script src="Style/user/js/amazeui.js" type="text/javascript"></script>
		<script src="Style/user/js/jquery.min.js" type="text/javascript"></script>
		
	</head>

        <body style="background: transparent;">
		<!--头 -->
		<header>
			<article>
				<div class="mt-logo">
					<!--顶部导航条 -->
					<div class="am-container header">
						<ul class="message-l">
							<div class="topMessage">
								<div class="menu-hd">
									<a href="#" target="_top" class="h">欢迎回来，会员个人中心</a>
									
								</div>
							</div>
						</ul>
						<ul class="message-r">
                                                    
					                
							 <div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng"><a href="personalcenter2.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
					</div>
                                    
					<div class="topMessage home">
						<div class="menu-hd"><a href="index.jsp" target="_top" class="h"><i class="am-icon-shopping-cart  am-icon-fw"></i>商城首页</a></div>
					</div>
					
					<!--<div class="  topMessage mini-cart">
						<div class="menu-hd"><a id="mc-menu-hd" href="shopcart2.html" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h"></strong></a></div>
					</div>
                                 -->   
					<div class="topMessage favorite1">
						<div class="menu-hd"><a href="ahome1.jsp" target="_top"><span>管理员中心</span></a></div>
                                        </div>
						</ul>
						</div>

						
							<div class="m-user">
								<!--个人信息 -->
								<div class="m-bg"></div>
								<div class="m-userinfo">
									<div class="m-baseinfo">
										<a href="#">
											<img src="images/getAvatar.do.jpg">
										</a>
										<em class="s-name">(小叮当)<span class="vip1"></em>
										<div class="s-prestige am-btn am-round">
											</span>会员福利</div>
									</div>
									<div class="m-right">
										<div class="m-new">
											<a href="editor.jsp"><i class="am-icon-bell-o"></i>设置</a>
										</div>
										<div class="m-address">
											<a href="page" class="i-trigger">我的收货地址</a>
										</div>
									</div>
								</div>
							</div>
					</div>
			</article>
		</header>
		

        <div class="center">
			<div class="col-main">
                     
				<!--浮动框架-->
                <div class="main-wrap">
                    <iframe width="1020" height="700px" name="main" style="background-color: white;" src="page" scrolling="no" allowTransparency="true"></iframe>           
			    </div>

                 <!--底部-->
				<div class="footer" style="margin-bottom: -24px;">
					
					<div class="m-user">
						<!--个人信息 -->
						<div class="m-bg"></div>
						<div class="m-userinfo">
							<div class="footer-hd" >
								<p>
									<span><a href="#">恒望科技</a></span>
									<b>|</b>
									<a href="#">商城首页</a>
									<b>|</b>
									<a href="#">支付宝</a>
									<b>|</b>
									<a href="#">物流信息</a>
									<b>|</b>
									<a href="#">微信</a>
									<b>|</b>
									<a href="#">联系我们</a>
									<a href="#" style="margin-left: 245px;">关于恒望</a>
									<a href="#">合作伙伴</a>
									<a href="#">联系我们</a>
									<a href="#">网站地图</a>
									<em>© 2015-2025 Hengwang.com 版权所有</em>
								</p>
			                </div>
						</div>
					</div>
				</div>
			</div>
             <!--左导航栏-->
          <aside class="menu">
				<ul>
					<li class="person active">
                        <a href="#">个人中心</a>
					</li>
					<li class="person">
						<a href="#">个人资料</a>
						<ul>
                             <li><a href="page" target="main">收货地址</a></li>   
                             <li><a href="newaddress.jsp" target="main">新增地址</a></li>   
						</ul>
					</li>
                     <li class="person">
						<a href="#">我的交易</a>
						<ul>
	                        <li><a href="shopcar1.jsp" target="main">订单管理</a></li>
                            <li><a href="orderinfo2.jsp" target="main">订单详情</a></li>  
                            <li><a href="shopcar2.jsp" target="main">购物车</a></li>    
						</ul>
					</li>
		            <li class="person">
						<a href="#">我的资产</a>
						<ul>
                            <li><a href="balance2.jsp" target="main">账户余额</a></li>   
						</ul>
					</li>
					<li class="person">
						<a href="#">我的管理</a>
						<ul>
                            <li><a href="manage.jsp" target="main">收货管理</a></li>   
						</ul>
					</li><li class="person">
						<a href="#">小区成员</a>
						<ul>
                            <li><a href="userinfo.jsp" target="main">查看成员</a></li>   
						</ul>
					</li>
					<li class="person">
						<a href="#">我的申请</a>
						<ul>
                            <li><a href="request.jsp" target="main">申请团长</a></li>   
						</ul>
					</li>
				</ul>
			</aside>
		</div>

	</body>

</html>