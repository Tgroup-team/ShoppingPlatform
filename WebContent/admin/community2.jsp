<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <div align="right">  <a href="<%=request.getContextPath() %>/admin/addcommunity1.jsp" style="padding: 10px 20px;">添加社区</a></div>
           <table width="888" border="1" cellpadding="0" cellspacing="0" class="order_tab" style="width:930px; text-align:center; margin-bottom:30px;">
              
              <tr>
                <td width="10%">社区编号</td>
                <td width="10%">社区名称</td>
                <td width="10%">操作处理</td>
              </tr>
              
              <c:forEach items="${listCommunity }" var="lc" varStatus="vs">
                 <tr>
                  <td>${vs.count }</td>
                  <td>${lc.communityName }</td>        
                <td><a class="c0085d0" href="updatecommunity?communityId=${lc.communityId }">修改</a>&nbsp;&nbsp;
                <a class="c0085d0" href="deletecommunity?communityId=${lc.communityId }" onclick="alert('确定要删除吗？')">删除</a></td>
              </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>