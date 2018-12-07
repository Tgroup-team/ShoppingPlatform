<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<table border="1" cellpadding="10" cellspacing="0">
		<tr>
<!-- 			<th><input id="all" type="checkbox" /></th> -->
			<th>名字</th>
			<th>电话</th>
			<th>省份</th>
		</tr>
		<c:forEach items="${addresses}" var="ad">
			<tr>
				<td>${ad.aName }</td>
				<td>${ad.aTel }</td>
				<td>${ad.aProvince }</td>
			
		</tr>
		
		</c:forEach>
	</table>
	
	
	<!-- 分页 -->
	<div >
		<font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
			${page.pageNow} 页</font> <a
			href="${pageContext.request.contextPath}/page?pageNow=1">首页</a>
		<c:choose>
			<c:when test="${page.pageNow - 1 > 0}">
				<a href="${pageContext.request.contextPath}/page?pageNow=${page.pageNow - 1}">上一页</a>
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
	</div>

</body>
</html>