<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				style="width: 960px; text-align: center; margin-bottom: 30px;"
				cellspacing="0" cellpadding="0">
				<tr>

					<td width="17%">订单编号</td>
					<td width="9%">订单总金额</td>
					<td width="19%">下单时间</td>
					<td width="12%">处理状态</td>
					<td width="19%">操作</td>
				</tr>
				<tr>
					<td width="17%">2</td>
					<td width="9%">20.0￥</td>
					<td width="19%">2018-05-04</td>
					<td width="12%">发货</td>
					<td width="19%"><a
						href="javascript:if(confirm('您是否确定发货？'))location='DoUpdateOrderServlet?id=2'">发货</a>&nbsp;&nbsp;<a
						class="c0085d0" href="#" onclick="alert('确定要删除吗？')">删除</a></td>
				</tr>
				<tr>
					<td width="17%">3</td>
					<td width="9%">20.0￥</td>
					<td width="19%">2018-11-27</td>
					<td width="12%">待发货</td>
					<td width="19%"><a
						href="javascript:if(confirm('您是否确定发货？'))location='DoUpdateOrderServlet?id=3'">发货</a>&nbsp;&nbsp;<a
						class="c0085d0" href="#" onclick="alert('确定要删除吗？')">删除</a></td>
				</tr>
			</table>
		</div>
	</div>
	<script type="text/javascript">
		function Send(){
			var send=document.getElementById('send');
			send.innerHTML="";
		}
	</script>
</body>
<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>
