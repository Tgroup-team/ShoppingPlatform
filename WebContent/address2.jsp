<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

<title>地址管理</title>
<link href="Style/user/css/admin.css" rel="stylesheet" type="text/css">
<link href="Style/user/css/amazeui.css" rel="stylesheet" type="text/css">
<link href="Style/user/css/personal.css" rel="stylesheet"
	type="text/css">


<link href="Style/user/css/addstyle.css" rel="stylesheet"
	type="text/css">
<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"
	type="text/javascript"></script>
<script src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>
</head>
<body style="background: transparent;">
	<div class="user-address">
		<!--标题 -->
		<div class="am-cf am-padding">
			<div class="am-fl am-cf">
				<strong class="am-text-danger am-text-lg">地址管理</strong> / <small>Address&nbsp;list</small>
			</div>
		</div>
		<hr />
		<ul class="am-avg-sm-1 am-avg-md-3 am-thumbnails">
<<<<<<< HEAD
		  <c:forEach items="${addresses}" var="ad">
			<li class="user-addresslist">
				<span class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</span>
				<p class="new-tit new-p-re">
					<span class="new-txt">${ad.aName }</span>
					<span class="new-txt-rd2">${ad.aTel }</span>
				</p>
				<div class="new-mu_l2a new-p-re">
					<p class="new-mu_l2cw">
						<span class="title">地址：</span>
						<span class="province">${ad.aProvince }</span>
						<span class="city">${ad.aCity }</span>
						<span class="dist">${ad.aArea }</span>
						<span class="street">${ad.aDetailAddr}</span>
					</p>
				</div>
				<div class="new-addr-btn">
					<a href="editor?id=${ad.aId }"><i class="am-icon-edit"></i>编辑</a>
					<span class="new-addr-bar">|</span>
					<a href="DeleteAddressServlet?id=${ad.aId }"><i class="am-icon-trash"></i>删除</a>
				</div>
			</li>
		  </c:forEach>
		  </ul>
	
		  	<center>
=======
			<c:forEach items="${addresses}" var="ad">
				<li class="user-addresslist"><span class="new-option-r"><i
						class="am-icon-check-circle"></i>设为默认</span>
					<p class="new-tit new-p-re">
						<span class="new-txt">${ad.aName }</span> <span
							class="new-txt-rd2">${ad.aTel }</span>
					</p>
					<div class="new-mu_l2a new-p-re">
						<p class="new-mu_l2cw">
							<span class="title">地址：</span> <span class="province">${ad.aProvince }</span>
							<span class="city">${ad.aCity }</span> <span class="dist">${ad.aArea }</span>
							<span class="street">${ad.aDetailAddr}</span>
						</p>
					</div>
					<div class="new-addr-btn">
						<a href="editor.html"><i class="am-icon-edit"></i>编辑</a> <span
							class="new-addr-bar">|</span> <a href="javascript:void(0);"
							onClick="delClick(this);"><i class="am-icon-trash"></i>删除</a>
					</div></li>
			</c:forEach>
			<br />
			<br />
			<center>
>>>>>>> 446ab84... 首页基本完成，购物页缺购物车和购买，搜索页基本完成
				<font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
					${page.pageNow} 页</font> <a
					href="${pageContext.request.contextPath}/page?pageNow=1">首页</a>
				<c:choose>
					<c:when test="${page.pageNow - 1 > 0}">
						<a
							href="${pageContext.request.contextPath}/page?pageNow=${page.pageNow - 1}">上一页</a>
					</c:when>
					<c:when test="${page.pageNow - 1 <= 0}">
						<a href="${pageContext.request.contextPath}/page?pageNow=1">上一页</a>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${page.totalPageCount==0}">
						<a
							href="${pageContext.request.contextPath}/page?pageNow=${page.pageNow}">下一页</a>
					</c:when>
					<c:when test="${page.pageNow + 1 < page.totalPageCount}">
						<a
							href="${pageContext.request.contextPath}/page?pageNow=${page.pageNow + 1}">下一页</a>
					</c:when>
					<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
						<a
							href="${pageContext.request.contextPath}/page?pageNow=${page.totalPageCount}">下一页</a>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${page.totalPageCount==0}">
						<a
							href="${pageContext.request.contextPath}/page?pageNow=${page.pageNow}">尾页</a>
					</c:when>
					<c:otherwise>
						<a
							href="${pageContext.request.contextPath}/page?pageNow=${page.totalPageCount}">尾页</a>
					</c:otherwise>
				</c:choose>
			</center>
<<<<<<< HEAD
	</div>
	<script type="text/javascript">
=======

			<script type="text/javascript">
>>>>>>> 446ab84... 首页基本完成，购物页缺购物车和购买，搜索页基本完成
		$(document).ready(function() {							
			$(".new-option-r").click(function() {
				$(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
			});
			
			var $ww = $(window).width();
			if($ww>640) {
				$("#doc-modal-1").removeClass("am-modal am-modal-no-btn")
			}
			
		})
	</script>
</body>

</html>