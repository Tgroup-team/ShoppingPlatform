<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
            <div align="right"style="margin-right: 20px;margin-top: -30px;font-size: 40px;margin-bottom: 10px;">  
            	<a href="addmoney.jsp"><input type="button" name=""  value="充值"  /></a>
            </div>
            <table border="1" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="20%">类型</td>
                <td width="25%">时间</td>
                <td width="15%">金额</td>
              </tr>
              	<c:forEach items="${resList}" var="re">
              	 <tr>
              		<td>${re.recordtype }</td>
                	<td><div align="center">${re.recordTime }</div></td>
                	<td>${re.recordAmount }</td>
              	</tr>
              </c:forEach>
            </table>
            	<center>
				<font size="2">共 ${Balancepage.totalPageCount} 页</font> <font size="2">第
					${Balancepage.pageNow} 页</font> <a
					href="${pageContext.request.contextPath}/Balancepage?pageNow=1">首页</a>
				<c:choose>
					<c:when test="${Balancepage.pageNow - 1 > 0}">
						<a href="${pageContext.request.contextPath}/Balancepage?pageNow=${Balancepage.pageNow - 1}">上一页</a>
					</c:when>
					<c:when test="${Balancepage.pageNow - 1 <= 0}">
						<a href="${pageContext.request.contextPath}/Balancepage?pageNow=1">上一页</a>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${Balancepage.totalPageCount==0}">
						<a href="${pageContext.request.contextPath}/Balancepage?pageNow=${Balancepage.pageNow}">下一页</a>
					</c:when>
					<c:when test="${Balancepage.pageNow + 1 < Balancepage.totalPageCount}">
						<a href="${pageContext.request.contextPath}/Balancepage?pageNow=${Balancepage.pageNow + 1}">下一页</a>
					</c:when>
					<c:when test="${Balancepage.pageNow + 1 >= Balancepage.totalPageCount}">
						<a href="${pageContext.request.contextPath}/Balancepage?pageNow=${Balancepage.totalPageCount}">下一页</a>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${Balancepage.totalPageCount==0}">
						<a href="${pageContext.request.contextPath}/Balancepage?pageNow=${Balancepage.pageNow}">尾页</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/Balancepage?pageNow=${Balancepage.totalPageCount}">尾页</a>
					</c:otherwise>
				</c:choose>
			</center>
        </div>
    </div>
</body>
</html>