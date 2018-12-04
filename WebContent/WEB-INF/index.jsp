<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

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




			<!--侧边导航 -->
			<div id="nav" class="navfull">
				<div class="area clearfix">
					<div class="category-content" id="guide_2">

						<div class="category">
							<ul class="category-list" id="js_climit_li">

							</ul>
						</div>
					</div>

				</div>
			</div>


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


			<div class="advTip">
				<img src="images/advTip.jpg" />
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


			<div id="f1">
				<!--水果-->
				<div class="am-container ">
					<div class="shopTitle ">
						<h4>水果</h4>


						<span class="more "> </span>
					</div>
				</div>
				<div class="am-g am-g-fixed floodFour">
				
					<div class="am-u-sm-3 am-u-md-2 text-three sug">
						<div class="outer-con ">
							<div class="title ">草莓</div>
							<div class="sub-title ">¥21/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/cm2.jpg" /></a>
					</div>
					
					<div class="am-u-sm-7 am-u-md-4 text-two">
						<div class="outer-con ">
							<div class="title ">草莓</div>
							<div class="sub-title ">¥22/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/cm2.jpg" /></a>
					</div>

					

					<div class="am-u-sm-3 am-u-md-2 text-three big">
						<div class="outer-con ">
							<div class="title ">橘子</div>
							<div class="sub-title ">¥5/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/5.jpg" /></a>
					</div>

					<div class="am-u-sm-3 am-u-md-2 text-three big">
						<div class="outer-con ">
							<div class="title ">蓝莓</div>
							<div class="sub-title ">¥30/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/4.jpg" /></a>
					</div>

					<div class="am-u-sm-3 am-u-md-2 text-three big">
						<div class="outer-con ">
							<div class="title ">龙眼</div>
							<div class="sub-title ">¥10/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/2.jpg" /></a>
					</div>

					<div class="am-u-sm-3 am-u-md-2 text-three big">
						<div class="outer-con ">
							<div class="title ">葡萄</div>
							<div class="sub-title ">¥7/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/pt6.jpg" /></a>
					</div>
					
					<div class="am-u-sm-3 am-u-md-2 text-three big">
						<div class="outer-con ">
							<div class="title ">葡萄</div>
							<div class="sub-title ">¥7/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/pt6.jpg" /></a>
					</div>
					
					<div class="am-u-sm-3 am-u-md-2 text-three big">
						<div class="outer-con ">
							<div class="title ">葡萄</div>
							<div class="sub-title ">¥7/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/pt6.jpg" /></a>
					</div>
					
					<div class="am-u-sm-3 am-u-md-2 text-three big">
						<div class="outer-con ">
							<div class="title ">葡萄</div>
							<div class="sub-title ">¥7/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/pt6.jpg" /></a>
					</div>
					
					<div class="am-u-sm-3 am-u-md-2 text-three big">
						<div class="outer-con ">
							<div class="title ">葡萄</div>
							<div class="sub-title ">¥7/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/pt6.jpg" /></a>
					</div>
					
					<div class="am-u-sm-3 am-u-md-2 text-three big">
						<div class="outer-con ">
							<div class="title ">葡萄</div>
							<div class="sub-title ">¥7/斤</div>
							<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
						</div>
						<a href="# "><img src="images/pt6.jpg" /></a>
					</div>

				</div>
				<div class="clear "></div>
			</div>










			<div id="f6">
				<!--油粮类-->
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
				<!--冷藏类-->
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
				<!--饮料-->
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
			</div>








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


	<!--菜单 -->
	<div class=tip>
		<div id="sidebar">
			<div id="wrap">
				<div id="prof" class="item ">
					<a href="# "> <span class="setting "></span>
					</a>
					<div class="ibar_login_box status_login ">
						<div class="avatar_box ">
							<p class="avatar_imgbox ">
								<img src="images/no-img_mid_.jpg " />
							</p>
							<ul class="user_info ">
								<li>用户名sl1903</li>
								<li>级&nbsp;别普通会员</li>
							</ul>
						</div>
						<div class="login_btnbox ">
							<a href="# " class="login_order ">我的订单</a> <a href="# "
								class="login_favorite ">我的收藏</a>
						</div>
						<i class="icon_arrow_white "></i>
					</div>

				</div>
				<div id="shopCart " class="item ">
					<a href="# "> <span class="message "></span>
					</a>
					<p>购物车</p>
					<p class="cart_num ">0</p>
				</div>
				<div id="asset " class="item ">
					<a href="# "> <span class="view "></span>
					</a>
					<div class="mp_tooltip ">
						我的资产 <i class="icon_arrow_right_black "></i>
					</div>
				</div>

				<div id="foot " class="item ">
					<a href="# "> <span class="zuji "></span>
					</a>
					<div class="mp_tooltip ">
						我的足迹 <i class="icon_arrow_right_black "></i>
					</div>
				</div>

				<div id="brand " class="item ">
					<a href="#"> <span class="wdsc "><img
							src="images/wdsc.png " /></span>
					</a>
					<div class="mp_tooltip ">
						我的收藏 <i class="icon_arrow_right_black "></i>
					</div>
				</div>

				<div id="broadcast " class="item ">
					<a href="# "> <span class="chongzhi "><img
							src="images/chongzhi.png " /></span>
					</a>
					<div class="mp_tooltip ">
						我要充值 <i class="icon_arrow_right_black "></i>
					</div>
				</div>

				<div class="quick_toggle ">
					<li class="qtitem "><a href="# "><span class="kfzx "></span></a>
						<div class="mp_tooltip ">
							客服中心<i class="icon_arrow_right_black "></i>
						</div></li>
					<!--二维码 -->
					<li class="qtitem "><a href="#none "><span
							class="mpbtn_qrcode "></span></a>
						<div class="mp_qrcode " style="display: none;">
							<img src="images/weixin_code_145.png " /><i
								class="icon_arrow_white "></i>
						</div></li>
					<li class="qtitem "><a href="#top " class="return_top "><span
							class="top "></span></a></li>
				</div>

				<!--回到顶部 -->
				<div id="quick_links_pop " class="quick_links_pop hide "></div>

			</div>

		</div>
		<div id="prof-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>我</div>
		</div>
		<div id="shopCart-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>购物车</div>
		</div>
		<div id="asset-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>资产</div>

			<div class="ia-head-list ">
				<a href="# " target="_blank " class="pl ">
					<div class="num ">0</div>
					<div class="text ">优惠券</div>
				</a> <a href="# " target="_blank " class="pl ">
					<div class="num ">0</div>
					<div class="text ">红包</div>
				</a> <a href="# " target="_blank " class="pl money ">
					<div class="num ">￥0</div>
					<div class="text ">余额</div>
				</a>
			</div>

		</div>
		<div id="foot-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>足迹</div>
		</div>
		<div id="brand-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>收藏</div>
		</div>
		<div id="broadcast-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>充值</div>
		</div>
	</div>
	<script>
			window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
		</script>
	<script type="text/javascript " src="basic/js/quick_links.js "></script>
</body>

</html>