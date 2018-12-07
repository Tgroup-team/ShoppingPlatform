<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/style_1.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/select.js"></script>
</head>
<body style="background: transparent;">
	<div class="i_bg bg_color">
		<div class="m_right">
			<div class="mem_tit">订单管理</div>
			<table border="1" class="order_tab"
				style="width: 930px; text-align: center; margin-bottom: 30px;"
				cellspacing="0" cellpadding="0">
				<tr>
					<td width="20%">退货编号</td>
					<td width="25%">申请时间</td>
					<td width="15%">订单总金额</td>
					<td width="25%">处理状态</td>

					<td width="15%">操作</td>
				</tr>
				
				<c:forEach items="${listReturn }" var="lr">
				   <tr>
					<td><font color="#ff4e00">${lr.returnId }</font></td>
					<td><fmt:formatDate value="${lr.applytime }" pattern="yyyy-MM-dd"/></td>
					<td>¥${lr.total}</td>
					<td>${lr.returnstate } ${lr.processingstate }</td>
					<td><a class="c0085d0" href="refund?returnId=${lr.returnId }">退款</a>
					<a class="c0085d0" href="returngoods?returnId=${lr.returnId }">退货</a>
					</td>
				   </tr>
				</c:forEach>
				
				<!-- <tr>
					<td><font color="#ff4e00">2015092823056</font></td>
					<td>2015-09-26 16:45:20</td>
					<td>￥456.00</td>
					<td>未退货</td>
					<td><a class="c0085d0" href="#">退货</a></td>
				</tr> -->
			</table>
		</div>
	</div>
</body>
<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>