<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">


    <title>购物车</title>

	<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
	<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

	<link href="css/personal.css" rel="stylesheet" type="text/css">
	<link href="Style/user/css/orstyle.css" rel="stylesheet" type="text/css">

	<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
	<script src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>


</head>

<body style="background: transparent;">
<b class="line"></b>
	<div class="wrap-left" >
		<div class="wrap-list">
			<div class="user-order" >
	
		<!--标题 -->
	<div class="am-cf am-padding">
		<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单管理</strong> / <small>Order</small></div>
	</div>
	<hr/>
	
	<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>
	
		<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs">
			<li class="am-active"><a href="#tab1">所有订单</a></li>
			<li><a href="#tab2">待付款</a></li>
			<li><a href="#tab3">待发货</a></li>
			<li><a href="#tab4">待收货</a></li>
			<li><a href="#tab5">待评价</a></li>
		</ul>
	
		<div class="am-tabs-bd">
			<div class="am-tab-panel am-fade am-in am-active" id="tab1">
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
				<!-- 	<div class="th th-amount">
						<td class="td-inner">合计</td>
					</div>
					<div class="th th-status">
						<td class="td-inner">交易状态</td>
					</div>
					<div class="th th-change">
						<td class="td-inner">交易操作</td>
					</div> -->
				</div>
	
						
				<!--交易失败-->
				<div class="order-status0">
					<div class="order-title">
						
						<span>成交时间：2018-12-20</span>
						<!--    <em>店铺：小桔灯</em>-->
					</div>
					<div class="order-content">
						<div class="order-left">
							<ul class="item-list">
								<li class="td td-item">
									<div class="item-pic">
										<a href="#" class="J_MakePoint">
											<img src="images/cm2.jpg" class="itempic J_ItemImg">
										</a>
									</div>
									<div class="item-info">
										<div class="item-basic-info">
											<a href="#">
												<p>草莓 新鲜水果牛奶巧克力奶油大草莓</p>
												<p class="info-little">品种：新鲜水果牛奶巧克力奶油大草莓
													<br/>包装：盒装 </p>
											</a>
										</div>
									</div>
								</li>
								<li class="td td-price">
									<div class="item-price">
										20.00/斤
									</div>
								</li>
								<li class="td td-number">
									<div class="item-number">
										<span>×</span>2
									</div>
								</li>
								<li class="td td-operation">
									<div class="item-operation">
										
									</div>
								</li>
	                                               </ul>
	
							<ul class="item-list">
								<li class="td td-item">
									<div class="item-pic">
										<a href="#" class="J_MakePoint">
											<img src="images/cm2.jpg" class="itempic J_ItemImg">
										</a>
									</div>
									<div class="item-info">
										<div class="item-basic-info">
											<a href="#">
												<p>草莓 新鲜水果牛奶巧克力奶油大草莓</p>
												<p class="info-little">品种：新鲜水果牛奶巧克力奶油大草莓
													<br/>包装：盒装 </p>
											</a>
										</div>
									</div>
								</li>
								<li class="td td-price">
									<div class="item-price">
										20.00/斤
									</div>
								</li>
								<li class="td td-number">
									<div class="item-number">
										<span>×</span>2
									</div>
								</li>
								<li class="td td-operation">
									<div class="item-operation">
										
									</div>
								</li>
							</ul>
						</div>
						<div class="order-right">
							<li class="td td-amount">
								<div class="item-amount">
									合计：92.00
									<p>含运费：<span>12.00</span></p>
								</div>
							</li>
							<div class="move-right">
								<li class="td td-status">
									<div class="item-status">
										<p class="Mystatus">交易关闭</p>
									</div>
								</li>
								<li class="td td-change">
									<div class="am-btn am-btn-danger anniu">
										删除订单</div>
								</li>
							</div>
						</div>
					</div>
				</div>											
						
						<!--待发货-->
						
	
						<!--不同状态订单-->
						<div class="order-status3">
							<div class="order-title">
								
								<span>成交时间：2018-12-20</span>
								<!--    <em>店铺：小桔灯</em>-->
							</div>
							<div class="order-content">
								<div class="order-left">
									<ul class="item-list">
										<li class="td td-item">
											<div class="item-pic">
												<a href="#" class="J_MakePoint">
													<img src="images/cm2.jpg" class="itempic J_ItemImg">
												</a>
											</div>
											<div class="item-info">
												<div class="item-basic-info">
													<a href="#">
														<p>草莓 新鲜水果牛奶巧克力奶油大草莓</p>
														<p class="info-little">品种：新鲜水果牛奶巧克力奶油大草莓
															<br/>包装：盒装 </p>
													</a>
												</div>
											</div>
										</li>
										<li class="td td-price">
											<div class="item-price">
												20.00/斤
											</div>
										</li>
										<li class="td td-number">
											<div class="item-number">
												<span>×</span>2
											</div>
										</li>
										<li class="td td-operation">
											<div class="item-operation">
												<a href="refund2.html">退款/退货</a>
											</div>
										</li>
									</ul>
	
								</div>
								<div class="order-right">
									<li class="td td-amount">
										<div class="item-amount">
											合计：52.00
											<p>含运费：<span>12.00</span></p>
										</div>
									</li>
									<div class="move-right">
										<li class="td td-status">
											<div class="item-status">
												<p class="Mystatus">卖家已发货</p>
												<p class="order-info"><a href="orderinfo2.html">订单详情</a></p>
												<p class="order-info"><a href="logistics2.html">查看物流</a></p>
												<p class="order-info"><a href="#">延长收货</a></p>
											</div>
										</li>
										<li class="td td-change">
											<div class="am-btn am-btn-danger anniu">
												确认收货</div>
										</li>
									</div>
								</div>
							</div>
	
						</div>
	
					</div>
			<div class="am-tab-panel am-fade am-in am-active" id="tab2">
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
													<div class="th th-amount">
														<td class="td-inner">合计</td>
													</div>
													<div class="th th-status">
														<td class="td-inner">交易状态</td>
													</div>
													<div class="th th-change">
														<td class="td-inner">交易操作</td>
													</div>
												</div>
			
														
														<!--交易失败-->
														<div class="order-status0">
															<div class="order-title">
																
																<span>成交时间：2018-12-20</span>
																<!--    <em>店铺：小桔灯</em>-->
															</div>
															<div class="order-content">
																<div class="order-left">
																	<ul class="item-list">
																		<li class="td td-item">
																			<div class="item-pic">
																				<a href="#" class="J_MakePoint">
																					<img src="images/cm2.jpg" class="itempic J_ItemImg">
																				</a>
																			</div>
																			<div class="item-info">
																				<div class="item-basic-info">
																					<a href="#">
																						<p>草莓 新鲜水果牛奶巧克力奶油大草莓</p>
																						<p class="info-little">品种：新鲜水果牛奶巧克力奶油大草莓
																							<br/>包装：盒装 </p>
																					</a>
																				</div>
																			</div>
																		</li>
																		<li class="td td-price">
																			<div class="item-price">
																				20.00/斤
																			</div>
																		</li>
																		<li class="td td-number">
																			<div class="item-number">
																				<span>×</span>2
																			</div>
																		</li>
																		<li class="td td-operation">
																			<div class="item-operation">
																				
																			</div>
																		</li>
			                                                                                                                </ul>
			
																	<ul class="item-list">
																		<li class="td td-item">
																			<div class="item-pic">
																				<a href="#" class="J_MakePoint">
																					<img src="images/cm2.jpg" class="itempic J_ItemImg">
																				</a>
																			</div>
																			<div class="item-info">
																				<div class="item-basic-info">
																					<a href="#">
																						<p>草莓 新鲜水果牛奶巧克力奶油大草莓</p>
																						<p class="info-little">品种：新鲜水果牛奶巧克力奶油大草莓
																							<br/>包装：盒装 </p>
																					</a>
																				</div>
																			</div>
																		</li>
																		<li class="td td-price">
																			<div class="item-price">
																				20.00/斤
																			</div>
																		</li>
																		<li class="td td-number">
																			<div class="item-number">
																				<span>×</span>2
																			</div>
																		</li>
																		<li class="td td-operation">
																			<div class="item-operation">
																				
																			</div>
																		</li>
																	</ul>
																</div>
																<div class="order-right">
																	<li class="td td-amount">
																		<div class="item-amount">
																			合计：92.00
																			<p>含运费：<span>12.00</span></p>
																		</div>
																	</li>
																	<div class="move-right">
																		<li class="td td-status">
																			<div class="item-status">
																				<p class="Mystatus">交易关闭</p>
																			</div>
																		</li>
																		<li class="td td-change">
																			<div class="am-btn am-btn-danger anniu">
																				删除订单</div>
																		</li>
																	</div>
																</div>
															</div>
														</div>											
														
													
			
													</div>
			<div class="am-tab-panel am-fade am-in am-active" id="tab3">
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
					<div class="th th-amount">
						<td class="td-inner">合计</td>
					</div>
					<div class="th th-status">
						<td class="td-inner">交易状态</td>
					</div>
					<div class="th th-change">
						<td class="td-inner">交易操作</td>
					</div>
				</div>
	
						
						
						
						<!--待发货-->
						<div class="order-status2">
							<div class="order-title">
								
								<span>成交时间：2018-12-20</span>
								<!--    <em>店铺：小桔灯</em>-->
							</div>
							<div class="order-content">
								<div class="order-left">
									<ul class="item-list">
										<li class="td td-item">
											<div class="item-pic">
												<a href="#" class="J_MakePoint">
													<img src="images/cm2.jpg" class="itempic J_ItemImg">
												</a>
											</div>
											<div class="item-info">
												<div class="item-basic-info">
													<a href="#">
														<p>草莓 新鲜水果牛奶巧克力奶油大草莓</p>
														<p class="info-little">品种：新鲜水果牛奶巧克力奶油大草莓
															<br/>包装：盒装 </p>
													</a>
												</div>
											</div>
										</li>
										<li class="td td-price">
											<div class="item-price">
												20.00/斤
											</div>
										</li>
										<li class="td td-number">
											<div class="item-number">
												<span>×</span>2
											</div>
										</li>
										<li class="td td-operation">
											<div class="item-operation">
												<a href="refund2.html">退款</a>
											</div>
										</li>
									</ul>
	
									<ul class="item-list">
										<li class="td td-item">
											<div class="item-pic">
												<a href="#" class="J_MakePoint">
													<img src="images/cm2.jpg" class="itempic J_ItemImg">
												</a>
											</div>
											<div class="item-info">
												<div class="item-basic-info">
													<a href="#">
														<p>草莓 新鲜水果牛奶巧克力奶油大草莓</p>
														<p class="info-little">品种：新鲜水果牛奶巧克力奶油大草莓
															<br/>包装：盒装 </p>
													</a>
												</div>
											</div>
										</li>
										<li class="td td-price">
											<div class="item-price">
												20.00/斤
											</div>
										</li>
										<li class="td td-number">
											<div class="item-number">
												<span>×</span>2
											</div>
										</li>
										<li class="td td-operation">
											<div class="item-operation">
												<a href="refund2.html">退款</a>
											</div>
										</li>
									</ul>
								</div>
								<div class="order-right">
									<li class="td td-amount">
										<div class="item-amount">
											合计：92.00
											<p>含运费：<span>12.00</span></p>
										</div>
									</li>
									<div class="move-right">
										<li class="td td-status">
											<div class="item-status">
												<p class="Mystatus">买家已付款</p>
												<p class="order-info"><a href="orderinfo2.html">订单详情</a></p>
											</div>
										</li>
										<li class="td td-change">
											<div class="am-btn am-btn-danger anniu">
												提醒发货</div>
										</li>
									</div>
								</div>
							</div>
						</div>
	
						<!--不同状态订单-->
						
							</div>
	
					
	                          <div class="am-tab-panel am-fade am-in am-active" id="tab4">
			
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
					<div class="th th-amount">
						<td class="td-inner">合计</td>
					</div>
					<div class="th th-status">
						<td class="td-inner">交易状态</td>
					</div>
					<div class="th th-change">
						<td class="td-inner">交易操作</td>
					</div>
				</div>
	
						
					
						<!--待发货-->
						<div class="order-status2">
							<div class="order-title">
								
								<span>成交时间：2018-12-20</span>
								<!--    <em>店铺：小桔灯</em>-->
							</div>
							<div class="order-content">
								<div class="order-left">
									<ul class="item-list">
										<li class="td td-item">
											<div class="item-pic">
												<a href="#" class="J_MakePoint">
													<img src="images/cm2.jpg" class="itempic J_ItemImg">
												</a>
											</div>
											<div class="item-info">
												<div class="item-basic-info">
													<a href="#">
														<p>草莓 新鲜水果牛奶巧克力奶油大草莓</p>
														<p class="info-little">品种：新鲜水果牛奶巧克力奶油大草莓
															<br/>包装：盒装 </p>
													</a>
												</div>
											</div>
										</li>
										<li class="td td-price">
											<div class="item-price">
												20.00/斤
											</div>
										</li>
										<li class="td td-number">
											<div class="item-number">
												<span>×</span>2
											</div>
										</li>
										<li class="td td-operation">
											<div class="item-operation">
												<a href="refund2.html">退款</a>
											</div>
										</li>
									</ul>
	
									<ul class="item-list">
										<li class="td td-item">
											<div class="item-pic">
												<a href="#" class="J_MakePoint">
													<img src="images/cm2.jpg" class="itempic J_ItemImg">
												</a>
											</div>
											<div class="item-info">
												<div class="item-basic-info">
													<a href="#">
														<p>草莓 新鲜水果牛奶巧克力奶油大草莓</p>
														<p class="info-little">品种：新鲜水果牛奶巧克力奶油大草莓
															<br/>包装：盒装 </p>
													</a>
												</div>
											</div>
										</li>
										<li class="td td-price">
											<div class="item-price">
												20.00/斤
											</div>
										</li>
										<li class="td td-number">
											<div class="item-number">
												<span>×</span>2
											</div>
										</li>
										<li class="td td-operation">
											<div class="item-operation">
												<a href="refund2.html">退款</a>
											</div>
										</li>
									</ul>
								</div>
								<div class="order-right">
									<li class="td td-amount">
										<div class="item-amount">
											合计：92.00
											<p>含运费：<span>12.00</span></p>
										</div>
									</li>
									<div class="move-right">
										<li class="td td-status">
											<div class="item-status">
												<p class="Mystatus">买家已付款</p>
												<p class="order-info"><a href="orderinfo2.html">订单详情</a></p>
											</div>
										</li>
										<li class="td td-change">
											<div class="am-btn am-btn-danger anniu">
												确认收货</div>
										</li>
									</div>
								</div>
							</div>
						</div>
	
						<!--不同状态订单-->
						
								</div>
							
	
					
	
				
		<div class="am-tab-panel am-fade am-in am-active" id="tab5">
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
					<div class="th th-amount">
						<td class="td-inner">合计</td>
					</div>
					<div class="th th-status">
						<td class="td-inner">交易状态</td>
					</div>
					<div class="th th-change">
						<td class="td-inner">交易操作</td>
					</div>
				</div>
	
						
					
	
						<!--不同状态订单-->
						<div class="order-status3">
							<div class="order-title">
								
								<span>成交时间：2018-12-20</span>
								<!--    <em>店铺：小桔灯</em>-->
							</div>
							<div class="order-content">
								<div class="order-left">
									<ul class="item-list">
										<li class="td td-item">
											<div class="item-pic">
												<a href="#" class="J_MakePoint">
													<img src="images/cm2.jpg" class="itempic J_ItemImg">
												</a>
											</div>
											<div class="item-info">
												<div class="item-basic-info">
													<a href="#">
														<p>草莓 新鲜水果牛奶巧克力奶油大草莓</p>
														<p class="info-little">品种：新鲜水果牛奶巧克力奶油大草莓
															<br/>包装：盒装 </p>
													</a>
												</div>
											</div>
										</li>
										<li class="td td-price">
											<div class="item-price">
												20.00/斤
											</div>
										</li>
										<li class="td td-number">
											<div class="item-number">
												<span>×</span>2
											</div>
										</li>
										<li class="td td-operation">
											<div class="item-operation">
												<a href="refund2.html">退款/退货</a>
											</div>
										</li>
									</ul>
	
								</div>
								<div class="order-right">
									<li class="td td-amount">
										<div class="item-amount">
											合计：52.00
											<p>含运费：<span>12.00</span></p>
										</div>
									</li>
									<div class="move-right">
										<li class="td td-status">
											<div class="item-status">
												
											</div>
										</li>
										<li class="td td-change">
											<div class="am-btn am-btn-danger anniu">
												评价</div>
										</li>
									</div>
								</div>
							</div>
	
						</div>
	
					</div>
		</div>
	
	
		</div>
</body>
</html>
                     