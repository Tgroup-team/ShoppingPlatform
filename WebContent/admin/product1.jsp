<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/style_1.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/select.js"></script>

<style type="text/css">
.wrap {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>


</head>
<body style="background: transparent;">
	<div class="i_bg bg_color">
		<div class="m_right">
			<div class="mem_tit">产品管理</div>
			<div align="left">
				产品名称:&nbsp; <input name="txtPname" type="text" id="txtPname"
					style="width: 127px;" />&nbsp; <input type="submit" name="Button1"
					value="查询产品" id="Button1" /><br />
				<div align="right">
					<a href="admin/addproduct1.jsp" style="padding: 10px 20px;">添加产品<!--<input type="button" name=""  value="添加产品"  />--></a>
				</div>
			</div>
			<div align="center">
				<table width="100%" border="1" cellpadding="0" cellspacing="0"
					class="order_tab">
					<tr>
						<td style="text-align: center;" width="7%">编号</td>
						<td style="text-align: center;" width="10%">类别</td>
						<td style="text-align: center;" width="10%">名称</td>
						<td style="text-align: center;" width="10%">图片</td>
						<td style="text-align: center;" width="10%">描述图片</td>
						<td style="text-align: center;" width="10%">描述</td>
						<td style="text-align: center;" width="10%">单价</td>
						<td style="text-align: center;" width="7%">库存量</td>
						<td style="text-align: center;" width="7%">状态</td>
						<td style="text-align: center;" width="15%">操作</td>
					</tr>

					<c:forEach items="${pro }" var="lp">
						<tr>
							<td style="text-align: center;">${lp.productId }</td>
							<td style="text-align: center;">${lp.category.categoryName }</td>
							<td style="text-align: center;">${lp.productName }</td>
							<td class="wrap" title="${lp.productImages }">images/...</td>
							<td class="wrap" title="${lp.productDescriptionImages }">images/...</td>
							<td>描述</td>
							<td style="text-align: center;">${lp.productPrice }</td>
							<td style="text-align: center;">${lp.inventory }</td>
							<td style="text-align: center;">${lp.productState }</td>
							<td style="text-align: center;"><a class="c0085d0"
								href="uppershelf?productId=${lp.productId }">上架</a>&nbsp;&nbsp;<a
								class="c0085d0" href="lowershelf?productId=${lp.productId }">下架</a>&nbsp;&nbsp;<a
								class="c0085d0" href="updateproduct?productId=${lp.productId }">修改</a>&nbsp;&nbsp;<a
								class="c0085d0" href="deleteproduct?productId=${lp.productId }"
								onclick="alert('确定要删除吗？')">删除</a></td>
					</c:forEach>

				</table>
				<br>
				<br>
				<center>
					<font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
						${page.pageNow} 页</font> <a
						href="${pageContext.request.contextPath}/productservlet?pageNow=1">首页</a>
					<c:choose>
						<c:when test="${page.pageNow - 1 > 0}">
							<a
								href="${pageContext.request.contextPath}/productservlet?pageNow=${page.pageNow - 1}">上一页</a>
						</c:when>
						<c:when test="${page.pageNow - 1 <= 0}">
							<a
								href="${pageContext.request.contextPath}/productservlet?pageNow=1">上一页</a>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${page.totalPageCount==0}">
							<a
								href="${pageContext.request.contextPath}/productservlet?pageNow=${page.pageNow}">下一页</a>
						</c:when>
						<c:when test="${page.pageNow + 1 < page.totalPageCount}">
							<a
								href="${pageContext.request.contextPath}/productservlet?pageNow=${page.pageNow + 1}">下一页</a>
						</c:when>
						<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
							<a
								href="${pageContext.request.contextPath}/productservlet?pageNow=${page.totalPageCount}">下一页</a>
						</c:when>
					</c:choose>
					<c:choose>
						<c:when test="${page.totalPageCount==0}">
							<a
								href="${pageContext.request.contextPath}/productservlet?pageNow=${page.pageNow}">尾页</a>
						</c:when>
						<c:otherwise>
							<a
								href="${pageContext.request.contextPath}/productservlet?pageNow=${page.totalPageCount}">尾页</a>
						</c:otherwise>
					</c:choose>
				</center>


			</div>
		</div>
	</div>

</body>
</html>