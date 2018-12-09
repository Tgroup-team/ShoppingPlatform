<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">


<title>购物车</title>

<link href="<%=request.getContextPath() %>/AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="<%=request.getContextPath() %>/AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">

<link href="<%=request.getContextPath() %>/css/personal.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/Style/user/css/orstyle.css" rel="stylesheet" type="text/css">

<script src="<%=request.getContextPath() %>/AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/AmazeUI-2.4.2/assets/js/amazeui.js"></script>


</head>

<body style="background: transparent;">
	<b class="line"></b>
	<div class="wrap-left">
		<div class="wrap-list">
			<div class="user-order">

				<!--标题 -->
				<div class="am-cf am-padding">
					<div class="am-fl am-cf">
						<strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small>
					</div>
				</div>
				<hr />

				<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

					<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
						<li class="am-active"><a href="#tab1">所有订单</a></li>
						<li><a href="#tab2">待发货</a></li>
						<li><a href="#tab3">已发货</a></li>
						<li><a href="#tab4">已收货</a></li>
						<li><a href="#tab5">退货</a></li>
					</ul>

					<div class="am-tabs-bd" style="width:1040px;height: 600px;">

						<!--所有订单-->
						<div class="am-tab-panel am-fade am-in am-active" id="tab1" style="overflow-y: scroll;height: 600px;">
							<div class="order-top">
								<div class="th th-item">
									<td class="td-inner">商品</td>
								</div>
								<div class="th th-price">
									<td class="td-inner">单价</td>
								</div>
								<div class="th th-number">
									<td class="td-inner">数量</td>
								</div>
								<div class="th th-operation">
									<td class="td-inner">商品操作</td>
								</div>
							</div>

							<!-- 列表 -->
							<c:forEach items="${selectOrderdetails_all }" var="orderdetails">
								<div class="order-status0">
									<div class="order-title">
										<span>成交时间：${orderdetails.ordertime }</span>
									</div>
									<div class="order-content">
										<div class="order-left">
											<ul class="item-list">
												<li class="td td-item">
													<div class="item-pic">
														<a target="_black" href="<%=request.getContextPath() %>/IntroductionServlet?productId=${orderdetails.productId }" class="J_MakePoint"> <img
															src="<%=request.getContextPath() %>/${fn:split(orderdetails.product.productImages,';')[0] }" class="itempic J_ItemImg">
														</a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a target="_black" href="<%=request.getContextPath() %>/IntroductionServlet?productId=${orderdetails.productId }">
																<p>${orderdetails.product.productName }</p>
																<p class="info-little">
																	订单状态：${orderdetails.order.orderstate } <br />再次购买
																</p>
															</a>
														</div>
													</div>
												</li>
												<li class="td td-price">
													<div class="item-price">${orderdetails.product.productPrice }/斤</div>
												</li>
												<li class="td td-number">
													<div class="item-number">
														<span>×</span>${orderdetails.amount }
													</div>
												</li>
												<li class="td td-operation">
													<div class="item-operation"></div>
												</li>
											</ul>
										</div>
										<div class="order-right">
											<li class="td td-amount">
												<div class="item-amount">
													总价：${orderdetails.total }
												</div>
											</li>
											<div class="move-right">
												<li class="td td-status">
													<div class="item-status">
														<p class="Mystatus">${orderdetails.order.orderstate }</p>
													</div>
												</li>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>

						</div>

						<!-- ------------------------ 订单分割线  ------------------------------------ -->
						
						<!--待发货-->
						<div class="am-tab-panel am-fade am-in am-active" id="tab2"  style="overflow-y: scroll;height: 600px;">
							<div class="order-top">
								<div class="th th-item">
									<td class="td-inner">商品</td>
								</div>
								<div class="th th-price">
									<td class="td-inner">单价</td>
								</div>
								<div class="th th-number">
									<td class="td-inner">数量</td>
								</div>
								<div class="th th-operation">
									<td class="td-inner">商品操作</td>
								</div>
							</div>

							<!-- 列表 -->
							<c:forEach items="${selectOrderdetails_waitSend }" var="orderdetails">
								<div class="order-status0">
									<div class="order-title">
										<span>成交时间：${orderdetails.ordertime }</span>
									</div>
									<div class="order-content">
										<div class="order-left">
											<ul class="item-list">
												<li class="td td-item">
													<div class="item-pic">
														<a target="_black" href="<%=request.getContextPath() %>/IntroductionServlet?productId=${orderdetails.productId }" class="J_MakePoint"> <img
															src="<%=request.getContextPath() %>/${fn:split(orderdetails.product.productImages,';')[0] }" class="itempic J_ItemImg">
														</a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a target="_black" href="<%=request.getContextPath() %>/IntroductionServlet?productId=${orderdetails.productId }">
																<p>${orderdetails.product.productName }</p>
																<p class="info-little">
																	订单状态：${orderdetails.order.orderstate } <br />再次购买
																</p>
															</a>
														</div>
													</div>
												</li>
												<li class="td td-price">
													<div class="item-price">${orderdetails.product.productPrice }/斤</div>
												</li>
												<li class="td td-number">
													<div class="item-number">
														<span>×</span>${orderdetails.amount }
													</div>
												</li>
												<li class="td td-operation">
													<div class="item-operation"></div>
												</li>
											</ul>
										</div>
										<div class="order-right">
											<li class="td td-amount">
												<div class="item-amount">
													总价：${orderdetails.total }
												</div>
											</li>
											<div class="move-right">
												<li class="td td-status">
													<div class="item-status">
														<p class="Mystatus">${orderdetails.order.orderstate }</p>
													</div>
												</li>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>

						</div>

						<!-- ------------------------ 订单分割线  ------------------------------------ -->
						
						<!--已发货-->
						<div class="am-tab-panel am-fade am-in am-active" id="tab3" style="overflow-y: scroll;height: 600px;">
							<div class="order-top">
								<div class="th th-item">
									<td class="td-inner">商品</td>
								</div>
								<div class="th th-price">
									<td class="td-inner">单价</td>
								</div>
								<div class="th th-number">
									<td class="td-inner">数量</td>
								</div>
								<div class="th th-operation">
									<td class="td-inner">商品操作</td>
								</div>
							</div>

							<!-- 列表 -->
							<c:forEach items="${selectOrderdetails_sended }" var="orderdetails">
								<div class="order-status0">
									<div class="order-title">
										<span>成交时间：${orderdetails.ordertime }</span>
									</div>
									<div class="order-content">
										<div class="order-left">
											<ul class="item-list">
												<li class="td td-item">
													<div class="item-pic">
														<a target="_black" href="<%=request.getContextPath() %>/IntroductionServlet?productId=${orderdetails.productId }" class="J_MakePoint"> <img
															src="<%=request.getContextPath() %>/${fn:split(orderdetails.product.productImages,';')[0] }" class="itempic J_ItemImg">
														</a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a target="_black" href="<%=request.getContextPath() %>/IntroductionServlet?productId=${orderdetails.productId }">
																<p>${orderdetails.product.productName }</p>
																<p class="info-little">
																	订单状态：${orderdetails.order.orderstate } <br />再次购买
																</p>
															</a>
														</div>
													</div>
												</li>
												<li class="td td-price">
													<div class="item-price">${orderdetails.product.productPrice }/斤</div>
												</li>
												<li class="td td-number">
													<div class="item-number">
														<span>×</span>${orderdetails.amount }
													</div>
												</li>
												<li class="td td-operation">
													<div class="item-operation">
														<a href="javascript:returnOrderFunction(${orderdetails.orderId })">退款/退货</a>
													</div>
												</li>
											</ul>
										</div>
										<div class="order-right">
											<li class="td td-amount">
												<div class="item-amount">
													总价：${orderdetails.total }
												</div>
											</li>
											<div class="move-right">
												<li class="td td-status">
													<div class="item-status">
														<p class="Mystatus">${orderdetails.order.orderstate }</p>
													</div>
												</li>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>

						</div>

						<!-- ------------------------ 订单分割线  ------------------------------------ -->
						
						<!--已收货-->
						<div class="am-tab-panel am-fade am-in am-active" id="tab4" style="overflow-y: scroll;height: 600px;">
							<div class="order-top">
								<div class="th th-item">
									<td class="td-inner">商品</td>
								</div>
								<div class="th th-price">
									<td class="td-inner">单价</td>
								</div>
								<div class="th th-number">
									<td class="td-inner">数量</td>
								</div>
								<div class="th th-operation">
									<td class="td-inner">商品操作</td>
								</div>
							</div>

							<!-- 列表 -->
							<c:forEach items="${selectOrderdetails_received }" var="orderdetails">
								<div class="order-status0">
									<div class="order-title">
										<span>成交时间：${orderdetails.ordertime }</span>
									</div>
									<div class="order-content">
										<div class="order-left">
											<ul class="item-list">
												<li class="td td-item">
													<div class="item-pic">
														<a target="_black" href="<%=request.getContextPath() %>/IntroductionServlet?productId=${orderdetails.productId }" class="J_MakePoint"> <img
															src="<%=request.getContextPath() %>/${fn:split(orderdetails.product.productImages,';')[0] }" class="itempic J_ItemImg">
														</a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a target="_black" href="<%=request.getContextPath() %>/IntroductionServlet?productId=${orderdetails.productId }">
																<p>${orderdetails.product.productName }</p>
																<p class="info-little">
																	订单状态：${orderdetails.order.orderstate } <br />再次购买
																</p>
															</a>
														</div>
													</div>
												</li>
												<li class="td td-price">
													<div class="item-price">${orderdetails.product.productPrice }/斤</div>
												</li>
												<li class="td td-number">
													<div class="item-number">
														<span>×</span>${orderdetails.amount }
													</div>
												</li>
												<li class="td td-operation">
													<div class="item-operation"></div>
												</li>
											</ul>
										</div>
										<div class="order-right">
											<li class="td td-amount">
												<div class="item-amount">
													总价：${orderdetails.total }
												</div>
											</li>
											<div class="move-right">
												<li class="td td-status">
													<div class="item-status">
														<p class="Mystatus">${orderdetails.order.orderstate }</p>
													</div>
												</li>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>

						</div>

						<!-- ------------------------ 订单分割线  ------------------------------------ -->
						
						<!--退货-->
						<div class="am-tab-panel am-fade am-in am-active" id="tab5" style="overflow-y: scroll;height: 600px;">
							<div class="order-top">
								<div class="th th-item">
									<td class="td-inner">商品</td>
								</div>
								<div class="th th-price">
									<td class="td-inner">单价</td>
								</div>
								<div class="th th-number">
									<td class="td-inner">数量</td>
								</div>
								<div class="th th-operation">
									<td class="td-inner">商品操作</td>
								</div>
							</div>

							<!-- 列表 -->
							<c:forEach items="${selectRetrun_return }" var="returnOrder">
								<div class="order-status0">
									<div class="order-title">
										<span>申请时间：${returnOrder.applytime }</span>
									</div>
									<div class="order-content">
										<div class="order-left">
											<ul class="item-list">
												<li class="td td-item">
													<div class="item-pic">
														<a target="_black" href="<%=request.getContextPath() %>/IntroductionServlet?productId=${returnOrder.productId }" class="J_MakePoint"> <img
															src="<%=request.getContextPath() %>/${fn:split(returnOrder.product.productImages,';')[0] }" class="itempic J_ItemImg">
														</a>
													</div>
													<div class="item-info">
														<div class="item-basic-info">
															<a target="_black" href="<%=request.getContextPath() %>/IntroductionServlet?productId=${returnOrder.productId }">
																<p>${returnOrder.product.productName }</p>
																<p class="info-little">
																	状态：${returnOrder.returnstate } <br />再次购买
																</p>
															</a>
														</div>
													</div>
												</li>
												<li class="td td-price">
													<div class="item-price">${returnOrder.productprice }/斤</div>
												</li>
												<li class="td td-number">
													<div class="item-number">
														<span>×</span>${returnOrder.amount }
													</div>
												</li>
												<li class="td td-operation">
													<div class="item-operation"></div>
												</li>
											</ul>
										</div>
										<div class="order-right">
											<li class="td td-amount">
												<div class="item-amount">
													总价：${returnOrder.total }
												</div>
											</li>
											<div class="move-right">
												<li class="td td-status">
													<div class="item-status">
														<p class="Mystatus">${returnOrder.processingstate }</p>
													</div>
												</li>
											</div>
										</div>
									</div>
								</div>
							</c:forEach>

						</div>

						<!-- ------------------------ 订单分割线  ------------------------------------ -->
						

					</div>


				</div>
				
				<!-- 用来提交退货表单 -->
				<div style="display:none;">
					<form id="postReturnOrder" action="ShowUserOrders" method="post">
						<input id="postReturnOrder_orderId" name="orderId" value="">
					</form>
					<script type="text/javascript">
						var returnOrderFunction=function(orderId){
							$('#postReturnOrder_orderId').val(orderId);
							var form_table=document.getElementById("postReturnOrder");
							form_table.submit();
						};
					</script>
				</div>
</body>
</html>
