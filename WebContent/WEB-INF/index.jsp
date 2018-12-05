<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="web.entity.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<title>首页</title>

	<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
		type="text/css" />
	<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
		type="text/css" />

	<link href="basic/css/demo.css" rel="stylesheet" type="text/css" />

	<link href="css/hmstyle.css" rel="stylesheet" type="text/css" />
	<link href="css/skin.css" rel="stylesheet" type="text/css" />
	<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
	<script src="AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>
</head>

<body>
	<div class="hmtop">
		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="login.html" target="_top" class="h">亲，请登录</a> <a
							href="register.html" target="_top">免费注册</a> <a href="#"
							target="_top">手机逛商场</a>
					</div>
				</div>
			</ul>
			<ul class="message-r">
				<div class="topMessage zhuce">
					<div class="menu-hd">
						<a href="register2.html" target="_top"><span>注册</span></a>
					</div>
				</div>

				<div class="topMessage denglu">
					<div class="menu-hd">
						<a href="login2.html" target="_top"><span>登录</span></a>
					</div>
				</div>

				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng">
						<a href="personalcenter2.html" target="_top"><i
							class="am-icon-user am-icon-fw"></i>个人中心</a>
					</div>
				</div>

				<div class="topMessage home">
					<div class="menu-hd">
						<a href="index.html" target="_top" class="h">商城首页</a>
					</div>
				</div>

				<div class="  topMessage mini-cart">
					<div class="menu-hd">
						<a id="mc-menu-hd" href="shopcart2.html" target="_top"><i
							class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
							id="J_MiniCartNum" class="h"></strong></a>
					</div>
				</div>

				<div class="topMessage favorite1">
					<div class="menu-hd">
						<a href="login1.html" target="_top"><span>管理员中心</span></a>
					</div>
				</div>


			</ul>
		</div>

		<!--悬浮搜索框-->

		<div class="nav white">
			<div class="logo">
				<img src="images/logo.png" />
			</div>
			<div class="logoBig">
				<li><img src="images/logobig.png" /></li>
			</div>

			<div class="search-bar pr">
				<a name="index_none_header_sysc" href="#"></a>
				<form>
					<input id="searchInput" name="index_none_header_sysc" type="text"
						placeholder="搜索" autocomplete="off"> <input
						id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
						type="submit">
				</form>
			</div>
		</div>

		<div class="clear"></div>
	</div>
	<div class="banner">
		<!--轮播 -->
		<div class="am-slider am-slider-default scoll" data-am-flexslider
			id="demo-slider-0">
			<ul class="am-slides">
				<li class="banner1"><a href="introduction.html"><img
						src="images/ad1.jpg" /></a></li>
				<li class="banner2"><a><img src="images/ad2.jpg" /></a></li>
				<li class="banner3"><a><img src="images/ad3.jpg" /></a></li>
				<li class="banner4"><a><img src="images/ad4.jpg" /></a></li>

			</ul>
		</div>
		<div class="clear"></div>
	</div>
	<div class="shopNav">
		<div class="slideall">

			<!--轮播-->

			<script type="text/javascript">
							(function() {
								$('.am-slider').flexslider();
							});
							$(document).ready(function() {
								$("li").hover(function() {
									$(".category-content .category-list li.first .menu-in").css("display", "none");
									$(".category-content .category-list li.first").removeClass("hover");
									$(this).addClass("hover");
									$(this).children("div.menu-in").css("display", "block")
								}, function() {
									$(this).removeClass("hover")
									$(this).children("div.menu-in").css("display", "none")
								});
							})
						</script>



			<!--小导航 -->
			<div class="am-g am-g-fixed smallnav">
				<div class="am-u-sm-3">
					<a href="sort.html"><img src="images/navsmall.jpg" />
						<div class="title">商品分类</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img src="images/huismall.jpg" />
						<div class="title">大聚惠</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img src="images/mansmall.jpg" />
						<div class="title">个人中心</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img src="images/moneysmall.jpg" />
						<div class="title">投资理财</div> </a>
				</div>
			</div>

		</div>
	</div>
	<div class="clear"></div>
	</div>
	<script type="text/javascript">
					if ($(window).width() < 640) {
						function autoScroll(obj) {
							$(obj).find("ul").animate({
								marginTop: "-39px"
							}, 500, function() {
								$(this).css({
									marginTop: "0px"
								}).find("li:first").appendTo(this);
							})
						}
						$(function() {
							setInterval('autoScroll(".demo")', 3000);
						})
					}
				</script>
	</div>
	<div class="shopMainbg">
		<div class="shopMain" id="shopmain">


			<div class="clear "></div>
			<!--热门活动 -->

			<div class="clear "></div>
			<c:forEach items="${productMap }" var="productList">
			<c:set var="productListItemIndex" value="0"></c:set>
				<div id="f1">
				<div class="am-container ">
					<div class="shopTitle ">
						<h4>${productList[0].category.categoryName }</h4>
						<span class="more "> </span>
					</div>
				</div>
				<div class="am-g am-g-fixed floodFour">
				
					<div class="am-u-sm-7 am-u-md-4 text-two">
						<div class="outer-con ">
							<div class="title ">${productList[0].productName }</div>
							<div class="sub-title ">¥${productList[0].productPrice }/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="${fn:split(productList[0].productImages,';')[0] }" /></a>
					</div>
					
					<div class="am-u-sm-3 am-u-md-2 text-three sug">
						<div class="outer-con ">
							<div class="title ">${productList[1].productName }</div>
							<div class="sub-title ">¥${productList[1].productPrice }/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="${fn:split(productList[1].productImages,';')[0] }" /></a>
					</div>
					
					<c:forEach items="${productList }" var="product" begin="2" step="1">
						<div class="am-u-sm-3 am-u-md-2 text-three big">
							<div class="outer-con ">
							<div class="title ">${product.productName }</div>
							<div class="sub-title ">¥${product.productPrice }/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="${fn:split(product.productImages,';')[0] }" /></a>
						</div>
					</c:forEach>
				</div>
				<div class="clear "></div>
				</div>
			
			</c:forEach>

			









<!-- 
			<div id="f6">
				油粮类
				<div class="am-container ">
					<div class="shopTitle ">
						<h4>油粮</h4>

					</div>
				</div>
				<div class="am-g am-g-fixed floodFour">
					<div class="am-u-sm-7 am-u-md-4 text-two">
						<div class="outer-con ">
							<div class="title ">米</div>
							<div class="sub-title ">¥55.6</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/7.jpg" /></a>
					</div>


					<div class="am-u-sm-3 am-u-md-2 text-three big">
						<div class="outer-con ">
							<div class="title ">面条</div>
							<div class="sub-title ">¥55.9</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/10.jpg" /></a>
					</div>

					<div class="am-u-sm-3 am-u-md-2 text-three sug">
						<div class="outer-con ">
							<div class="title ">花生油</div>
							<div class="sub-title ">¥149.9</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/8.jpg" /></a>
					</div>

					<div class="am-u-sm-3 am-u-md-2 text-three ">
						<div class="outer-con ">
							<div class="title ">酱油</div>
							<div class="sub-title ">¥28.8</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/9.jpg" /></a>
					</div>

					<div class="am-u-sm-3 am-u-md-2 text-three last big ">
						<div class="outer-con ">
							<div class="title ">鸡精</div>
							<div class="sub-title ">¥35.5</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/11.jpg" /></a>
					</div>

				</div>
				<div class="clear "></div>
			</div>




			<div id="f7">
				冷藏类
				<div class="am-container ">
					<div class="shopTitle ">
						<h4>冷冻冷藏</h4>

					</div>
				</div>
				<div class="am-g am-g-fixed floodFour">
					<div class="am-u-sm-7 am-u-md-4 text-two">
						<div class="outer-con ">
							<div class="title ">鲜奶</div>
							<div class="sub-title ">¥69</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/20.jpg" /></a>
					</div>


					<div class="am-u-sm-3 am-u-md-2 text-three big">
						<div class="outer-con ">
							<div class="title ">酸奶</div>
							<div class="sub-title ">¥50</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/21.jpg" /></a>
					</div>

					<div class="am-u-sm-3 am-u-md-2 text-three sug">
						<div class="outer-con ">
							<div class="title ">肉品类</div>
							<div class="sub-title ">¥100</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/22.jpg" /></a>
					</div>

					<div class="am-u-sm-3 am-u-md-2 text-three ">
						<div class="outer-con ">
							<div class="title ">面包</div>
							<div class="sub-title ">¥30</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/23.jpg" /></a>
					</div>

					<div class="am-u-sm-3 am-u-md-2 text-three last big ">
						<div class="outer-con ">
							<div class="title ">冰激凌</div>
							<div class="sub-title ">¥20</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/25.jpg" /></a>
					</div>

				</div>
				<div class="clear "></div>
			</div>








			<div id="f3">
				饮料
				<div class="am-container ">
					<div class="shopTitle ">
						<h4>饮料</h4>

					</div>
				</div>
				<div class="am-g am-g-fixed floodFour">
					<div class="am-u-sm-7 am-u-md-4 text-two">
						<div class="outer-con ">
							<div class="title ">苏打水</div>
							<div class="sub-title ">¥4.5</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/sudashui.jpg" /></a>
					</div>


					<div class="am-u-sm-3 am-u-md-2 text-three big">
						<div class="outer-con ">
							<div class="title ">苹果汁</div>
							<div class="sub-title ">¥10</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/pingguozhi.jpg" /></a>
					</div>

					<div class="am-u-sm-3 am-u-md-2 text-three sug">
						<div class="outer-con ">
							<div class="title ">金典牛奶</div>
							<div class="sub-title ">¥45</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/niunai.jpg" /></a>
					</div>

					<div class="am-u-sm-3 am-u-md-2 text-three ">
						<div class="outer-con ">
							<div class="title ">香飘飘奶茶</div>
							<div class="sub-title ">¥4.5</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/naicha.jpg" /></a>
					</div>

					<div class="am-u-sm-3 am-u-md-2 text-three last big ">
						<div class="outer-con ">
							<div class="title ">天然矿泉水</div>
							<div class="sub-title ">¥1.5</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/shui.jpg" /></a>
					</div>

				</div>
				<div class="clear "></div>
			</div> -->








			<div class="footer ">
				<div class="footer-hd ">
					<p>
						<a href="# ">恒望科技</a> <b>|</b> <a href="# ">商城首页</a> <b>|</b> <a
							href="# ">支付宝</a> <b>|</b> <a href="# ">物流</a>
					</p>
				</div>
				<div class="footer-bd ">
					<p>
						<a href="# ">关于恒望</a> <a href="# ">合作伙伴</a> <a href="# ">联系我们</a>
						<a href="# ">网站地图</a> <em>© 2015-2025 Hengwang.com 版权所有</em>
					</p>
				</div>
			</div>

		</div>
	</div>
	<!--引导 -->
	<div class="navCir">
		<li class="active"><a href="index.html"><i
				class="am-icon-home "></i>首页</a></li>
		<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
		<li><a href="shopcart.html"><i
				class="am-icon-shopping-basket"></i>购物车</a></li>
		<li><a href="person/index.html"><i class="am-icon-user"></i>我的</a></li>
	</div>
	<script type="text/javascript " src="basic/js/quick_links.js "></script>
</body>

</html>