<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTMqL 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>商品页面</title>

<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css" />
<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css" />
<link href="basic/css/demo.css" rel="stylesheet" type="text/css" />
<link type="text/css" href="css/optstyle.css" rel="stylesheet" />
<link type="text/css" href="css/style.css" rel="stylesheet" />

<script type="text/javascript" src="basic/js/jquery-1.7.min.js"></script>
<script type="text/javascript" src="basic/js/quick_links.js"></script>

<script type="text/javascript" src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>
<script type="text/javascript" src="js/jquery.imagezoom.min.js"></script>
<script type="text/javascript" src="js/jquery.flexslider.js"></script>
<script type="text/javascript" src="js/list.js"></script>

</head>

<body>


	<!--顶部导航条 -->
	<div class="am-container header">
		<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="<%=request.getContextPath()%>/userlogin.jsp" target="_top" class="h">亲，请登录</a> <a
							href="register.html" target="_top">免费注册</a> <a href="#"
							target="_top">手机逛商场</a>
					</div>
				</div>
		</ul>
		<ul class="message-r">
			<div class="topMessage home">
				<div class="menu-hd">
					<a href="<%=request.getContextPath()%>" target="_top" class="h">商城首页</a>
				</div>
			</div>
			<div class="topMessage my-shangcheng">
				<div class="menu-hd MyShangcheng">
					<a href="<%=request.getContextPath()%>/personalcenter2.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
				</div>
			</div>
			<div class="topMessage mini-cart">
				<div class="menu-hd">
					<a id="mc-menu-hd" href="#" target="_top"><i
						class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
						id="J_MiniCartNum" class="h">0</strong></a>
				</div>
			</div>
			<div class="topMessage favorite">
				<div class="menu-hd">
					<a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a>
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
			<form action="<%=request.getContextPath()%>/IntroductionServletList">
				<input id="categoryIdInput" type="hidden" name="categoryId" value="${categoryId }" />
				<input id="searchInput" name="keywords" type="text" value="${keywords }"
					placeholder="搜索" autocomplete="off" onchange="$('#categoryIdInput').val('')"/> <input
					id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
					type="submit"/>
			</form>
		</div>
	</div>

	<div class="clear"></div>
	<b class="line"></b>
	<div class="listMain">

		<!--分类-->
		<div class="nav-table">
			<div class="long-title">
				<span class="all-goods">全部分类</span>
			</div>
			<div class="nav-cont">
				<ul>
					<li class="index"><a href="<%=request.getContextPath()%>">首页</a></li>
					<c:forEach items="${categories }" var="category">
						<li class="qc"><a href="<%=request.getContextPath()%>/IntroductionServletList?categoryId=${category.categoryId }">${category.categoryName }</a></li>
					</c:forEach>
				</ul>
				<!-- 				<div class="nav-extra">
					<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
					<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
				</div> -->
			</div>
		</div>
		<ol class="am-breadcrumb am-breadcrumb-slash">
			<li><a href="<%=request.getContextPath()%>">首页</a></li>
			<li><a href="<%=request.getContextPath()%>/IntroductionServletList?keywords=${keywords }">${keywords }</a></li>
		</ol>

		<!-- introduce-->

		<div class="introduce">
			<div class="introduceMain" style="width: 100%;">
				<div class="am-tabs" data-am-tabs>

					<div class="am-tabs-bd">

						<div class="am-tab-panel am-fade am-in am-active">
							<div class="like" style="min-height: 660px;margin-top:0px;">
								<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
									<c:forEach items="${list }" var="product">
										<li>
											<div class="i-pic limit">
												<a
													href="<%=request.getContextPath() %>/IntroductionServlet?productId=${product.productId }"><img
													src="${fn:split(product.productImages,';')[0] }" /></a>
												<p>
													<a
														href="<%=request.getContextPath() %>/IntroductionServlet?productId=${product.productId }">${product.productName }</a>
												</p>
												<p class="price fl">
													<b>¥</b> <strong>${product.productPrice }</strong>
												</p>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
							<div class="clear"></div>

							<!--分页 -->
							<ul class="am-pagination am-pagination-right" style="padding-top:20px;">
								<c:if test="${pagesIndex>1 }">
									<li><a
										href="?categoryId=${categoryId }&keywords=${keywords }&pageIndex=${pagesIndex-1 }">&laquo;</a></li>
								</c:if>
								<c:if test="${pagesIndex<2 }">
									<li class="am-disabled"><a href="#">&laquo;</a></li>
								</c:if>
								<c:forEach var="pageindexTemp" begin="1" end="${pagesCount }"
									step="1">
									<c:if test="${pagesIndex==pageindexTemp }">
										<li class="am-active"><a
											href="?categoryId=${categoryId }&keywords=${keywords }&pageIndex=${pageindexTemp }">${pageindexTemp }</a></li>
									</c:if>
									<c:if test="${pagesIndex!=pageindexTemp }">
										<li><a
											href="?categoryId=${categoryId }&keywords=${keywords }&pageIndex=${pageindexTemp }">${pageindexTemp }</a></li>
									</c:if>
								</c:forEach>
								<c:if test="${pagesIndex<pagesCount }">
									<li><a
										href="?categoryId=${categoryId }&keywords=${keywords }&pageIndex=${pagesIndex+1 }">&raquo;</a></li>
								</c:if>
								<c:if test="${pagesIndex>=pagesCount }">
									<li class="am-disabled"><a href="#">&raquo;</a></li>
								</c:if>
							</ul>
						</div>
					</div>

					<div class="am-tab-panel am-fade"></div>

				</div>

				<div class="clear"></div>

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

		</div>
	</div>

	<!-- 实现自动滚动到猜你喜欢 -->
	<c:if test="${pagesIndex>1 }">
		<script type="text/javascript">
			$(function() {
				var $body = (window.opera) ? (document.compatMode == "CSS1Compat" ? $('html') : $('body')) : $('html,body');
				$body.animate({scrollTop: $('.listMain').offset().top}, 1000);
			});
		</script>
	</c:if>

</body>

</html>