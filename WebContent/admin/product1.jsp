<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<div class="mem_tit">产品管理</div>
			<div align="left">
				产品名称:&nbsp; <input name="txtPname" type="text" id="txtPname"
					style="width: 127px;" />&nbsp; <input type="submit" name="Button1"
					value="查询产品" id="Button1" /><br />
				<div align="right">
					<a href="addproduct1.html" style="padding: 10px 20px;">添加产品<!--<input type="button" name=""  value="添加产品"  />--></a>
				</div>
			</div>
			<div align="center">
				<table width="100%" border="1" cellpadding="0" cellspacing="0"
					class="order_tab">
					<tr>
						<td width="7%">产品编号</td>
						<td width="10%">产品类别</td>
						<td width="10%">产品名称</td>
						<td width="10%">图片</td>
						<td width="15%">产品描述</td>
						<td width="10%">产品单价</td>
						<td width="7%">库存量</td>
						<td width="7%">状态</td>
						<td width="15%">操作</td>
					</tr>
					<tr>
						<td>1</td>
						<td>水果类</td>
						<td>草莓</td>
						<td>images/1.jpg</td>
						<td>美极鲜</td>
						<td>20.00</td>
						<td>100</td>
						<td>已上架</td>
						<td><a class="c0085d0" href="#">上架</a>&nbsp;&nbsp;<a
							class="c0085d0" href="#">下架</a>&nbsp;&nbsp;<a class="c0085d0"
							href="updateproduct1.html">修改</a>&nbsp;&nbsp;<a class="c0085d0"
							href="#" onclick="alert('确定要删除吗？')">删除</a></td>
				</table>
			</div>
		</div>
	</div>
</body>
</html>