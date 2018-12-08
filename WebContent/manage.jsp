<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

	<title>个人中心</title>

	<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
	<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">
	<link href="css/personal.css" rel="stylesheet" type="text/css">
	<link href="css/systyle.css" rel="stylesheet" type="text/css">

</head>

<body style="background: transparent;">
     <b class="line"></b>
		<div class="wrap-left" >
			<div class="wrap-list">
				<!--订单 -->
				<div class="m-order">
					<div class="s-bar" style="font-size: 21px;">
						<i class="s-icon"></i>收货管理
						<a class="i-load-more-item-shadow" href="#"></a>
					</div>
				</div>
				
				
				<!--物流 -->
				<div class="m-logistics">
					<div class="s-content">
						<ul class="lg-list">
						  <c:forEach items="${takegoods}" var="tg">
							<li class="lg-item">
								<div class="item-info">
									<a href="#">
										<img src="${pageContext.request.contextPath}/${fn:split(tg.productImages,';')[0]}" alt="新鲜水果牛奶巧克力奶油大草莓">
									</a>
								</div>
								<div class="lg-info">
									<p>快件已从 ${tg.suppliers} 发出</p>
									<time>${tg.delivery }</time>
									<div class="lg-detail-wrap">
										<a class="lg-detail i-tip-trigger" href="javascript:void(0)" style="font-weight:bold;">${tg.orderstate }</a>
										<div class="J_TipsCon hide"></div>
									</div>
								</div>
								<div class="lg-confirm">
									<c:if test="${tg.orderstate!='已收货'}">
										<a class="i-btn-typical" href="confirmGoodsServlet?id=${tg.orderId}">确认收货</a>
									</c:if>
								</div>
							</li>
						  </c:forEach>
						  <hr>
					   </ul>
					   
					</div>
				</div>
				
				<br /><br>
				
				<center>
				<font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
					${page.pageNow} 页</font> <a
					href="${pageContext.request.contextPath}/takeGoodServlet?pageNow=1">首页</a>
				<c:choose>
					<c:when test="${page.pageNow - 1 > 0}">
						<a href="${pageContext.request.contextPath}/takeGoodServlet?pageNow=${page.pageNow - 1}">上一页</a>
					</c:when>
					<c:when test="${page.pageNow - 1 <= 0}">
						<a href="${pageContext.request.contextPath}/takeGoodServlet?pageNow=1">上一页</a>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${page.totalPageCount==0}">
						<a
							href="${pageContext.request.contextPath}/takeGoodServlet?pageNow=${page.pageNow}">下一页</a>
					</c:when>
					<c:when test="${page.pageNow + 1 < page.totalPageCount}">
						<a
							href="${pageContext.request.contextPath}/takeGoodServlet?pageNow=${page.pageNow + 1}">下一页</a>
					</c:when>
					<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
						<a
							href="${pageContext.request.contextPath}/takeGoodServlet?pageNow=${page.totalPageCount}">下一页</a>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${page.totalPageCount==0}">
						<a
							href="${pageContext.request.contextPath}/takeGoodServlet?pageNow=${page.pageNow}">尾页</a>
					</c:when>
					<c:otherwise>
						<a
							href="${pageContext.request.contextPath}/takeGoodServlet?pageNow=${page.totalPageCount}">尾页</a>
					</c:otherwise>
				</c:choose>
			</center>
			</div>
		</div>
</body>
</html>
                     