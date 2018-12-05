<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
					<a href="#" target="_top" class="h">亲，请登录</a> <a href="#"
						target="_top">免费注册</a>
				</div>
			</div>
		</ul>
		<ul class="message-r">
			<div class="topMessage home">
				<div class="menu-hd">
					<a href="#" target="_top" class="h">商城首页</a>
				</div>
			</div>
			<div class="topMessage my-shangcheng">
				<div class="menu-hd MyShangcheng">
					<a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
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
			<form>
				<input id="searchInput" name="index_none_header_sysc" type="text"
					placeholder="搜索" autocomplete="off"> <input
					id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
					type="submit">
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
						<li class="qc"><a href="#">${category.categoryName }</a></li>
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
			<li><a href="#">${product.category.categoryName }</a></li>
			<li><a href="#">${product.productName }</a></li>
		</ol>
		<script type="text/javascript">
			$(function() {
			});
			$(window).load(function() {
				$('.flexslider').flexslider({
					animation : "slide",
					start : function(slider) {
						$('body').removeClass('loading');
					}
				});
			});
		</script>
		<div class="scoll">
			<section class="slider">
			<div class="flexslider">
				<ul class="slides">
					<c:forTokens items="${product.productImages }" delims=";"
						var="imageUrl">
						<li><img src="${imageUrl }" title="pic" /></li>
					</c:forTokens>
				</ul>
			</div>
			</section>
		</div>

		<!--放大镜-->

		<div class="item-inform">
			<div class="clearfixLeft" id="clearcontent">

				<div class="box">
					<script type="text/javascript">
						$(document).ready(
								function() {
									$(".jqzoom").imagezoom();
									$("#thumblist li a").click(
											function() {
												$(this).parents("li").addClass(
														"tb-selected")
														.siblings()
														.removeClass(
																"tb-selected");
												$(".jqzoom").attr(
														'src',
														$(this).find("img")
																.attr("mid"));
												$(".jqzoom").attr(
														'rel',
														$(this).find("img")
																.attr("big"));
											});
								});
					</script>
					<c:set var="defaultImageUrl"
						value="${fn:split(product.productImages,';')[0] }" />
					<div class="tb-booth tb-pic tb-s310">
						<a href="${defaultImageUrl }"><img src="${defaultImageUrl }"
							alt="细节展示放大镜特效" rel="${defaultImageUrl }" class="jqzoom" /></a>
					</div>

				</div>

				<div class="clear"></div>
			</div>

			<div class="clearfixRight">

				<!--规格属性-->
				<!--名称-->
				<div class="tb-detail-hd">
					<h1>${product.productName }</h1>
				</div>
				<div class="tb-detail-list">
					<!--价格-->
					<div class="tb-detail-price">
						<li class="price iteminfo_price">
							<dt>促销价</dt>
							<dd>
								<em>¥</em><b class="sys_item_price">${product.productPrice }</b>
							</dd>
						</li>
						<li class="price iteminfo_mktprice">
							<dt>原价</dt>
							<dd>
								<em>¥</em><b class="sys_item_mktprice">${product.productPrice*1.25 }</b>
							</dd>
						</li>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
					<div class="clear"></div>

					<!--地址-->
					<dl class="iteminfo_parameter freight">
						<dt>配送至</dt>
						<div class="iteminfo_freprice">
							<div class="am-form-content address">
								<select data-am-selected>
									<option value="a">浙江省</option>
									<option value="b">湖北省</option>
								</select> <select data-am-selected>
									<option value="a">温州市</option>
									<option value="b">武汉市</option>
								</select> <select data-am-selected>
									<option value="a">瑞安区</option>
									<option value="b">洪山区</option>
								</select>
							</div>
							<div class="pay-logis">
								快递<b class="sys_item_freprice">10</b>元
							</div>
						</div>
					</dl>
					<div class="clear"></div>
					<div class="clear"></div>

					<!--销量-->
					<ul class="tm-ind-panel">
						<li class="tm-ind-item tm-ind-sellCount canClick">
							<div class="tm-indcon">
								<span class="tm-label">月销量</span><span class="tm-count">${productMonthSellCount }</span>
							</div>
						</li>
						<li class="tm-ind-item tm-ind-sumCount canClick tm-line3">
							<div class="tm-indcon">
								<span class="tm-label">累计销量</span><span class="tm-count">${productAllSellCount }</span>
							</div>
						</li>
					</ul>
					<div class="clear"></div>
					<div class="clear"></div>

					<!--各种规格-->
					<dl class="iteminfo_parameter sys_item_specpara">
						<dt class="theme-login">
							<div class="cart-title">
								可选规格<span class="am-icon-angle-right"></span>
							</div>
						</dt>
						<dd>
							<!--操作页面-->

							<div class="theme-popover">
								<div class="theme-span"></div>
								<div class="theme-poptit">
									<a href="javascript:;" title="关闭" class="close">×</a>
								</div>
								<div class="theme-popbod dform">
									<form class="theme-signin" name="loginform" action=""
										method="post">

										<div class="theme-signin-left">
											<div class="theme-options">
												<div class="cart-title">规格</div>
												<ul class="tb-thumb" id="thumblist">
													<c:set var="imageIndex" value="1"></c:set>
													<c:forTokens items="${product.productImages }" delims=";"
														var="imageUrl">
														<c:if test="${imageIndex==1 }">
															<li class="tb-selected">
																<div class="tb-pic tb-s40">
																	<a href="#"><img src="${imageUrl }"
																		mid="${imageUrl }" big="${imageUrl }"></a>
																</div>
															</li>
														</c:if>
														<c:if test="${imageIndex!=1 }">
															<li>
																<div class="tb-pic tb-s40">
																	<a href="#"><img src="${imageUrl }"
																		mid="${imageUrl }" big="${imageUrl }"></a>
																</div>
															</li>
														</c:if>
														<c:set var="imageIndex" value="${imageIndex+1 }"></c:set>
													</c:forTokens>

												</ul>
											</div>
											<div class="theme-options">
												<div class="cart-title number">数量</div>
												<dd>
													<input id="min" class="am-btn am-btn-default" name=""
														type="button" value="-" /> <input id="text_box" name=""
														type="text" value="1" style="width: 30px;" /> <input
														id="add" class="am-btn am-btn-default" name=""
														type="button" value="+" /> <span id="Stock"
														class="tb-hidden">库存<span class="stock">${product.inventory }</span>件
													</span>
												</dd>

											</div>
											<div class="clear"></div>

											<div class="btn-op">
												<div class="btn am-btn am-btn-warning">确认</div>
												<div class="btn close am-btn am-btn-warning">取消</div>
											</div>
										</div>
										<div class="theme-signin-right">
											<div class="img-info">
												<img src="images/songzi.jpg" />
											</div>
											<div class="text-info">
												<span class="J_Price price-now">¥${product.productPrice }</span>
												<span id="Stock" class="tb-hidden">库存<span
													class="stock">${product.inventory }</span>件
												</span>
											</div>
										</div>

									</form>
								</div>
							</div>

						</dd>
					</dl>
					<div class="clear"></div>
					<div class="clear"></div>
					<!--活动	-->
					<div class="shopPromotion gold">
						<div class="hot">
							<dt class="tb-metatit">店铺活动</dt>
							<div class="gold-list">
								<p>
									限时打8折，欲购从速....<span>进行中<i class="am-icon-sort-down"></i></span>
								</p>
							</div>
						</div>
						<div class="clear"></div>
						<div class="coupon">
							<dt class="tb-metatit">活动说明</dt>
							<div class="gold-list">
								<ul>
									<li>活动真实有效，全场8折，活动进行中...</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<div class="clear"></div>

				<div class="pay">
					<div class="pay-opt">
						<a href="<%=request.getContextPath()%>"><span class="am-icon-home am-icon-fw">首页</span></a>
						<a><span class="am-icon-heart am-icon-fw">收藏</span></a>

					</div>
					<li>
						<div class="clearfix tb-btn tb-btn-buy theme-login">
							<a id="LikBuy" title="点此按钮到下一步确认购买信息" href="#">立即购买</a>
						</div>
					</li>
					<li>
						<div class="clearfix tb-btn tb-btn-basket theme-login">
							<a id="LikBasket" title="加入购物车" href="#"><i></i>加入购物车</a>
						</div>
					</li>
				</div>

			</div>

			<div class="clear"></div>

		</div>

		<!-- introduce-->

		<div class="introduce">
			<div class="browse">
				<div class="mc">
					<ul>
						<div class="mt">
							<h2>看了又看</h2>
						</div>

						<li class="first">
							<div class="p-img">
								<a href="#"> <img class="" src="images/browse1.jpg"></a>
							</div>
							<div class="p-name">
								<a href="#"> 【三只松鼠_开口松子】零食坚果特产炒货东北红松子原味 </a>
							</div>
							<div class="p-price">
								<strong>￥35.90</strong>
							</div>
						</li>
						<li>
							<div class="p-img">
								<a href="#"> <img class="" src="images/browse1.jpg"></a>
							</div>
							<div class="p-name">
								<a href="#"> 【三只松鼠_开口松子】零食坚果特产炒货东北红松子原味 </a>
							</div>
							<div class="p-price">
								<strong>￥35.90</strong>
							</div>
						</li>
						<li>
							<div class="p-img">
								<a href="#"> <img class="" src="images/browse1.jpg"></a>
							</div>
							<div class="p-name">
								<a href="#"> 【三只松鼠_开口松子】零食坚果特产炒货东北红松子原味 </a>
							</div>
							<div class="p-price">
								<strong>￥35.90</strong>
							</div>
						</li>
						<li>
							<div class="p-img">
								<a href="#"> <img class="" src="images/browse1.jpg"></a>
							</div>
							<div class="p-name">
								<a href="#"> 【三只松鼠_开口松子】零食坚果特产炒货东北红松子原味 </a>
							</div>
							<div class="p-price">
								<strong>￥35.90</strong>
							</div>
						</li>
						<li>
							<div class="p-img">
								<a href="#"> <img class="" src="images/browse1.jpg"></a>
							</div>
							<div class="p-name">
								<a href="#"> 【三只松鼠_开口松子218g】零食坚果特产炒货东北红松子原味 </a>
							</div>
							<div class="p-price">
								<strong>￥35.90</strong>
							</div>
						</li>

					</ul>
				</div>
			</div>
			<div class="introduceMain">
				<div class="am-tabs" data-am-tabs>
					<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
						<li class="am-active"><a href="#"> <span
								class="index-needs-dt-txt">宝贝详情</span></a></li>

						</li>

						<li><a href="#"> <span class="index-needs-dt-txt">猜你喜欢</span></a>
						</li>
					</ul>

					<div class="am-tabs-bd">

						<div class="am-tab-panel am-fade am-in am-active">
							<div class="J_Brand">

								<div class="attr-list-hd tm-clear">
									<h4>产品参数：</h4>
								</div>
								<div class="clear"></div>
								<ul id="J_AttrUL">
									<li title="">产品类型:&nbsp;${product.category.categoryName }类</li>
									<li title="">类型标签:&nbsp;${product.category.cdescribe }</li>
									<li title="">产品名称:&nbsp;${product.productName }</li>
									<li title="">当前售价:&nbsp;${product.productPrice }</li>
									<li title="">库存量:&nbsp;${product.inventory }</li>
									<li title="">上架状态:&nbsp;${product.productState }</li>
									<li title="">产地:&nbsp;${product.suppliers }</li>
									<li title="">生产许可证编号：&nbsp;QS4201 1801 ${(product.productId*97362)%10000 } </li>
									<li title="">储存方法：&nbsp;请放置于常温、阴凉、通风、干燥处保存</li>
								</ul>
								<div class="clear"></div>
							</div>

							<div class="details">
								<div class="attr-list-hd after-market-hd">
									<h4>商品细节</h4>
								</div>
								<div class="twlistNews">
									<c:forTokens items="${product.productDescriptionImages }"
										delims=";" var="productDescriptionImage">
										<img src="${productDescriptionImage }" />
									</c:forTokens>
								</div>
							</div>
							<div class="clear"></div>

						</div>

						<div class="am-tab-panel am-fade">
							<div class="like">
								<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
									<li>
										<div class="i-pic limit">
											<img src="images/imgsearch1.jpg" />
											<p>
												【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
											</p>
											<p class="price fl">
												<b>¥</b> <strong>298.00</strong>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<img src="images/imgsearch1.jpg" />
											<p>
												【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
											</p>
											<p class="price fl">
												<b>¥</b> <strong>298.00</strong>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<img src="images/imgsearch1.jpg" />
											<p>
												【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
											</p>
											<p class="price fl">
												<b>¥</b> <strong>298.00</strong>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<img src="images/imgsearch1.jpg" />
											<p>
												【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
											</p>
											<p class="price fl">
												<b>¥</b> <strong>298.00</strong>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<img src="images/imgsearch1.jpg" />
											<p>
												【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
											</p>
											<p class="price fl">
												<b>¥</b> <strong>298.00</strong>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<img src="images/imgsearch1.jpg" />
											<p>
												【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
											</p>
											<p class="price fl">
												<b>¥</b> <strong>298.00</strong>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<img src="images/imgsearch1.jpg" />
											<p>
												【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
											</p>
											<p class="price fl">
												<b>¥</b> <strong>298.00</strong>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<img src="images/imgsearch1.jpg" />
											<p>
												【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
											</p>
											<p class="price fl">
												<b>¥</b> <strong>298.00</strong>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<img src="images/imgsearch1.jpg" />
											<p>
												【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
											</p>
											<p class="price fl">
												<b>¥</b> <strong>298.00</strong>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<img src="images/imgsearch1.jpg" />
											<p>
												【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
											</p>
											<p class="price fl">
												<b>¥</b> <strong>298.00</strong>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<img src="images/imgsearch1.jpg" />
											<p>
												【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
											</p>
											<p class="price fl">
												<b>¥</b> <strong>298.00</strong>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											<img src="images/imgsearch1.jpg" />
											<p>
												【良品铺子_开口松子】零食坚果特产炒货 <span>东北红松子奶油味</span>
											</p>
											<p class="price fl">
												<b>¥</b> <strong>298.00</strong>
											</p>
										</div>
									</li>
								</ul>
							</div>
							<div class="clear"></div>

							<!--分页 -->
							<ul class="am-pagination am-pagination-right">
								<li class="am-disabled"><a href="#">&laquo;</a></li>
								<li class="am-active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">&raquo;</a></li>
							</ul>
							<div class="clear"></div>

						</div>

					</div>

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


</body>

</html>