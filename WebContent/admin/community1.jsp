<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
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
			<div class="mem_tit">社区管理</div>
			<table width="888" border="1" cellpadding="0" cellspacing="0"
				class="order_tab"
				style="width: 930px; text-align: center; margin-bottom: 30px;">
				<tr>
					<td colspan="7">社区团长申核</td>
				</tr>
				<tr>
					<td width="10%">社区名称</td>
					<td width="10%">会员名</td>
					<td width="10%">申请时间</td>
					<td width="10%">处理结果</td>

					<td width="10%">操作处理</td>
				</tr>
				
				<c:forEach items="${listApply }" var="la">
				   <tr>
					<td>${la.community.communityName }</td>
					<td>${la.user.vipName }</td>
					<td><fmt:formatDate value="${la.rappl }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
					<td>${la.deal }</td>
					<td><a class="c0085d0" href="applypass?applyId=${la.applyId }&vipId=${la.vipId}">审核通过</a>&nbsp;&nbsp;<a
						class="c0085d0" href="applynpass?applyId=${la.applyId }&vipId=${la.vipId}">不通过</a></td>
				</tr>
				
				</c:forEach>
				
			</table>
		</div>
	</div>
</body>
</html>