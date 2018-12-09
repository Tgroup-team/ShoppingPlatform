<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<title>购物车页面</title>

<link
	href="<%=request.getContextPath()%>/AmazeUI-2.4.2/assets/css/amazeui.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/basic/css/demo.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/cartstyle.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/css/optstyle.css"
	rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.js"></script>

</head>

<body style="background: transparent;">

	<div class="s-bar" style="font-size: 21px;">
		<i class="s-icon"></i>购物车/<small>shopping</small>
		<hr />
	</div>

	<div class="clear"></div>

	<!--购物车 -->
	<div class="concent">
		<div id="cartTable">
			<div class="cart-table-th">
				<div class="wp">
					<div class="th th-chk">
						<div id="J_SelectAll1" class="select-all J_SelectAll"></div>
					</div>
					<div class="th th-item">
						<div class="td-inner">商品信息</div>
					</div>
					<div class="th th-price">
						<div class="td-inner">单价</div>
					</div>
					<div class="th th-amount">
						<div class="td-inner">数量</div>
					</div>
					<div class="th th-sum">
						<div class="td-inner">金额</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<div class="bundle-main"
				style="overflow-y: scroll; height: 500px; width: 1020px;">
				<!-- 提交删除和提交结算的 -->
				<form id="CartActionForm" action="ShowUserCart" method="get">
					<input type="hidden" name="post" value="" />
					<input type="hidden" name="delete" value="" />
					<c:forEach items="${selectCartById }" var="cartBean">
						<ul class="item-content clearfix">
							<li class="td td-chk">
								<div class="cart-checkbox ">
									<input class="check" id="J_CheckBox_170037950254" name="item"
										value="${cartBean.carId }" data="${cartBean.price }" type="checkbox" onclick="getsum()" />

								</div>
							</li>
							<li class="td td-item">
								<div class="item-pic">
									<a href="<%=request.getContextPath() %>/IntroductionServlet?productId=${cartBean.productId }" target="_blank"
										data-title="${cartBean.product.productName }"
										class="J_MakePoint" data-point="tbcart.8.12"> <img
										src="<%=request.getContextPath() %>/${fn:split(cartBean.product.productImages,';')[0] }"
										class="itempic J_ItemImg" /></a>
								</div>
								<div class="item-info">
									<div class="item-basic-info">
										<a href="<%=request.getContextPath() %>/IntroductionServlet?productId=${cartBean.productId }" target="_blank"
											title="${cartBean.product.productName }"
											class="item-title J_MakePoint" data-point="tbcart.8.11">${cartBean.product.productName }</a>
									</div>
								</div>
							</li>
							<li class="td td-info">
								<div class="item-props item-props-can">
									<span class="sku-line">上架状态：${cartBean.product.productState }</span>
									<span class="sku-line">产地：${cartBean.product.suppliers }</span>
									<i class="theme-login am-icon-sort-desc"></i>
								</div>
							</li>
							<li class="td td-price">
								<div class="item-price price-promo-promo">
									<div class="price-content">
										<div class="price-line">
											<em class="J_Price price-now" tabindex="0">${cartBean.price }/斤</em>
										</div>
									</div>
								</div>
							</li>
							<li class="td td-amount">
								<div class="amount-wrapper ">
									<div class="item-amount ">
										<div class="sl">
											${cartBean.amount }
											<%-- <input class="min am-btn" name="" type="button" value="-" />--%>
											<input class="text_box" name="all" type="hidden"
												value="${cartBean.amount }" style="width: 30px;" /> 
											<%--	<input class="add am-btn" name="" type="button" value="+" /> --%>
										</div>
									</div>
								</div>
							</li>
							<li class="td td-sum">
								<div class="td-inner">
									<em tabindex="0" class="J_ItemSum number">${cartBean.total }</em>
								</div>
							</li>
						</ul>
					</c:forEach>
				</form>
			</div>
			<div class="clear"></div>

			<div class="float-bar-wrapper">
				<div id="J_SelectAll2" class="select-all J_SelectAll">
					<div class="cart-checkbox">
						<input class="check-all check" id="allok" onclick="checkall()"
							type="checkbox" />
					</div>
					<span>全选</span>
				</div>
				<div class="operations">
					<a href="javascript:doDeleteCart()" hidefocus="true"
						class="deleteAll">删除</a>
				</div>
				<div class="float-bar-right">

					<div class="price-sum">
						<span class="txt">合计:</span> <strong class="price">¥<em
							id="allsum"></em></strong>
					</div>
					<div class="btn-area">
						<a href="javascript:postSubmitCart()" id="J_Go"
							class="submit-btn submit-btn-disabled"
							aria-label="请注意如果没有选择宝贝，将无法结算"> <span>结&nbsp;算</span></a>
					</div>
				</div>

			</div>
		</div>
	</div>
	<script type="text/javascript">
		var caf = document.getElementById('CartActionForm');
		//var caf_method = document.getElementById('CartActionForm_method');
		//提交删除
		function doDeleteCart() {
			if (confirm('真的要删除吗？')) {
				$(caf).attr('action', 'ShowUserCart');
				//$(caf_method).val('delete');
				caf.submit();
			}
		}
		//提交结算
		function postSubmitCart() {
			if (confirm('确认提交结算吗？')) {
				$(caf).attr('action', 'OrderSubmit');
				//$(caf_method).val('post');
				caf.submit();
			}
		}

		function checkall() {
			var allok = document.getElementById("allok");
			var item = document.getElementsByName("item");
			if (allok.checked) {
				for (var j = 0; j < item.length; j++) {
					item[j].checked = true;
				}
			} else {
				for (var j = 0; j < item.length; j++) {
					item[j].checked = false;
				}
			}
			getsum();
		}
		function getsum() {
			var itemsum = document.getElementsByName("item");
			var all = document.getElementsByName("all");
			var sum = 0;
			for (var i = 0; i < itemsum.length; i++) {
				if (itemsum[i].checked == true) {
					sum += parseFloat($(itemsum[i]).attr('data') * $(all[i]).val());
				}
			}
			var allsum = document.getElementById("allsum");
			allsum.innerHTML = sum;
		}
	</script>
</body>

</html>