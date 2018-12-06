<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<title>购物车页面</title>
	<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
	<link href="basic/css/demo.css" rel="stylesheet" type="text/css" />
	<link href="Style/user/css/cartstyle.css" rel="stylesheet" type="text/css" />
	<link href="css/optstyle.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body style="background: transparent;">
	<div class="s-bar" style="font-size: 21px;">
		<i class="s-icon"></i>购物车/<small>shopping</small>
		<hr />
	</div>

	<!--悬浮搜索框-->

	<div class="clear"></div>
	<!--购物车 -->
	<div class="concent" >
		<div id="cartTable">
			<div class="cart-table-th">
				<div class="wp">
					<div class="th th-chk">
						<div id="J_SelectAll1" class="select-all J_SelectAll"></div>
					</div>
					<div class="th th-item">
						<div class="td-inner">商品信息</div></div>
					<div class="th th-price">
						<div class="td-inner">单价</div></div>
					<div class="th th-amount">
						<div class="td-inner">数量</div></div>
					<div class="th th-sum">
						<div class="td-inner">金额</div></div>
				</div>
			</div>
			<div class="clear"></div>
			<%-- <c:forEach items="" var=""> --%>
			<tr class="item-list">
				<div class="bundle  bundle-last ">
					<div class="bundle-hd">
						<div class="bd-promos"></div>
							<span class="list-change theme-login">编辑</span>
					</div>
				</div>
				<div class="clear"></div>
				<div class="bundle-main">
					<ul class="item-content clearfix">
						<li class="td td-chk">
							<div class="cart-checkbox ">
								<input class="check" id="J_CheckBox_170037950254" name="items[]" value="170037950254" type="checkbox">
								<label for="J_CheckBox_170037950254"></label>
							</div>
						</li>
						<li class="td td-item">
							<div class="item-pic">
								<a href="#" target="_blank" data-title="草莓 新鲜水果牛奶巧克力奶油大草莓" class="J_MakePoint" data-point="tbcart.8.12">
									<img src="images/cm2.jpg_80x80.jpg" class="itempic J_ItemImg"></a>
							</div>
							<div class="item-info">
								<div class="item-basic-info">
									<a href="#" target="_blank" title="草莓 新鲜水果牛奶巧克力奶油大草莓" class="item-title J_MakePoint" data-point="tbcart.8.11">新鲜水果牛奶巧克力奶油大草莓</a>
								</div>
							</div>
						</li>
						<li class="td td-info">
							<div class="item-props item-props-can">
								<span class="sku-line">品种：新鲜水果牛奶巧克力奶油大草莓</span>
								<span class="sku-line">包装：盒装</span>
								<span tabindex="0" class="btn-edit-sku theme-login">修改</span>
								<i class="theme-login am-icon-sort-desc"></i>
							</div>
						</li>
						<li class="td td-price">
							<div class="item-price price-promo-promo">
								<div class="price-content">
									<div class="price-line">
										<em class="price-original"></em>
									</div>
									<div class="price-line">
										<em class="J_Price price-now" tabindex="0">20.00/斤</em>
									</div>
								</div>
							</div>
						</li>
						<li class="td td-amount">
							<div class="amount-wrapper ">
								<div class="item-amount ">
									<div class="sl">
										<input class="min am-btn" name="" type="button" value="-" />
										<input class="text_box" name="" type="text" value="3" style="width:30px;" />
										<input class="add am-btn" name="" type="button" value="+" />
									</div>
								</div>
							</div>
						</li>
						<li class="td td-sum">
							<div class="td-inner">
								<em tabindex="0" class="J_ItemSum number">60.00</em>
							</div>
						</li>
					</ul>
				</div>
			</tr>
<%-- 			</c:forEach> --%>

			
		</div>
		<div class="clear"></div>

		<div class="float-bar-wrapper">
			<div id="J_SelectAll2" class="select-all J_SelectAll">
				<div class="cart-checkbox">
					<input class="check-all check" id="J_SelectAllCbx2" name="select-all" value="true" type="checkbox">
					<label for="J_SelectAllCbx2"></label>
				</div>
				<span>全选</span>
			</div>
			<div class="operations">
				<a href="#" hidefocus="true" class="deleteAll">删除</a>
				<a href="#" hidefocus="true" class="J_BatchFav">移入收藏夹</a>
			</div>
			<div class="float-bar-right">
				<div class="amount-sum">
					<span class="txt">已选商品</span>
					<em id="J_SelectedItemsCount">0</em><span class="txt">件</span>
					<div class="arrow-box">
						<span class="selected-items-arrow"></span>
						<span class="arrow"></span>
					</div>
				</div>
				<div class="price-sum">
					<span class="txt">合计:</span>
					<strong class="price">¥<em id="J_Total">180.00</em></strong>
				</div>
				<div class="btn-area">
					<a href="pay2.html" id="J_Go" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
						<span>结&nbsp;算</span></a>
				</div>
			</div>

		</div>

		
	<!--操作页面-->

	<div class="theme-popover-mask"></div>

	<div class="theme-popover">
		<div class="theme-span"></div>
		<div class="theme-poptit h-title">
			<a href="javascript:;" title="关闭" class="close">×</a>
		</div>
		<div class="theme-popbod dform">
			<form class="theme-signin" name="loginform" action="" method="post">

				<div class="theme-signin-left">

					<li class="theme-options">
						<div class="cart-title">品种：</div>
						<ul>
							<li class="sku-line selected">新鲜水果牛奶巧克力奶油大草莓<i></i></li>
							<li class="sku-line">新鲜水果牛奶巧克力奶油大草莓<i></i></li>
						</ul>
					</li>
					<li class="theme-options">
						<div class="cart-title">包装：</div>
						<ul>
							<li class="sku-line selected">包装：盒装<i></i></li>
							<li class="sku-line"><i></i></li>
						</ul>
					</li>
					<div class="theme-options">
						<div class="cart-title number">数量</div>
						<dd>
							<input class="min am-btn am-btn-default" name="" type="button" value="-" />
							<input class="text_box" name="" type="text" value="1" style="width:30px;" />
							<input class="add am-btn am-btn-default" name="" type="button" value="+" />
							<span  class="tb-hidden">库存<span class="stock">1000</span>件</span>
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
						<img src="images/cm2.jpg" />
					</div>
					<div class="text-info">
						<span class="J_Price price-now">¥40.00</span>
						<span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span>
					</div>
				</div>

			</form>
		</div>
	</div>
<!--引导 -->
</div>

</body>

</html>