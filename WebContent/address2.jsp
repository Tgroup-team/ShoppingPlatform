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

	</div>
	<script type="text/javascript">
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