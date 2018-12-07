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
			<br>
			<div class="am-cf am-padding">
				<div class="am-fl am-cf" style="font-size: 21px;"><strong class="am-text-danger am-text-lg">&nbsp&nbsp小区成员</strong> / <small>number</small></div>
			</div>
			<hr/>
  			<br>
            <table border="1" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="15%">姓名</td>
                <td width="15%">电话号</td>
                <td width="20%">地址</td>
              </tr>
              
               <c:forEach items="${uses}" var="us">
               	  <tr>
	                   <td>${us.vipName }</td>
		               <td>${us.vipPhone }</td>
		               <td>${us.address }</td>
	              </tr>
               
               </c:forEach>
             
             
            </table>
       		
            <center>
				<font size="2">共 ${page.totalPageCount} 页</font> <font size="2">第
					${page.pageNow} 页</font> <a
					href="${pageContext.request.contextPath}/BrowseMemberServlet?pageNow=1">首页</a>
				<c:choose>
					<c:when test="${page.pageNow - 1 > 0}">
						<a href="${pageContext.request.contextPath}/BrowseMemberServlet?pageNow=${page.pageNow - 1}">上一页</a>
					</c:when>
					<c:when test="${page.pageNow - 1 <= 0}">
						<a href="${pageContext.request.contextPath}/BrowseMemberServlet?pageNow=1">上一页</a>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${page.totalPageCount==0}">
						<a
							href="${pageContext.request.contextPath}/BrowseMemberServlet?pageNow=${page.pageNow}">下一页</a>
					</c:when>
					<c:when test="${page.pageNow + 1 < page.totalPageCount}">
						<a
							href="${pageContext.request.contextPath}/BrowseMemberServlet?pageNow=${page.pageNow + 1}">下一页</a>
					</c:when>
					<c:when test="${page.pageNow + 1 >= page.totalPageCount}">
						<a
							href="${pageContext.request.contextPath}/BrowseMemberServlet?pageNow=${page.totalPageCount}">下一页</a>
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${page.totalPageCount==0}">
						<a
							href="${pageContext.request.contextPath}/BrowseMemberServlet?pageNow=${page.pageNow}">尾页</a>
					</c:when>
					<c:otherwise>
						<a
							href="${pageContext.request.contextPath}/BrowseMemberServlet?pageNow=${page.totalPageCount}">尾页</a>
					</c:otherwise>
				</c:choose>
			</center>
        </div>
    </div>
</body>
</html>