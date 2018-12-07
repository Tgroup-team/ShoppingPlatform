<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			<div class="mem_tit">余额账户</div>
			<div align="right">
				<a href="admin/withdrawal1.jsp" style="padding: 10px 20px;">提现</a>
			</div>
			<table border="0" class="order_tab"
				style="width: 930px; text-align: center; margin-bottom: 30px;"
				cellspacing="0" cellpadding="0">
				<tr>
					<td width="20%">类型</td>
					<td width="25%">时间</td>
					<td width="15%">金额</td>
				</tr>
				
				<c:forEach items="${listRecord }" var="lr">
				   <tr>
				        <td><div align="center">${lr.recordtype }</div></td>
						<td><fmt:formatDate value="${lr.recordTime }" pattern="yyyy-MM-dd"/></td>
						<td>${lr.recordAmount }</td>
				    </tr>
				</c:forEach>
				
			</table>
		</div>
	</div>
</body>
</html>