<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="mem_tit">产品类别管理</div>
			<div align="right">
				<a href="addcatagory1.jsp" style="padding: 10px 20px;">添加产品类别</a>
			</div>
			<table border="0" class="order_tab"
				style="width: 930px; text-align: center; margin-bottom: 30px;"
				cellspacing="0" cellpadding="0">
				<tr>
					<td width="6%">产品类别编号</td>
					<td width="20%">产品类别名称</td>
					<td width="20%">产品类别描述</td>
					<td width="10%">操作</td>
				</tr>
				<c:forEach items="${listCategory }" var="li" varStatus="vs">
					<tr>
						<td>${vs.count }</td>
						<td>${li.categoryName }</td>
						<td>${li.cdescribe }</td>
						<td><a class="c0085d0" href="updatecategory?categoryId=${li.categoryId }">修改</a>&nbsp;&nbsp;<a
							class="c0085d0" href="deletecategory?categoryId=${li.categoryId }" onclick="alert('确定要删除吗？')">删除</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
