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
			<div style="float: right;">
				<a href="catagory1.html">返回</a>
			</div>
			<div align="center">
				<form method="post" action="DoAddcatagoryServlet">
					<table border="1" class="order_tab"
						style="width: 500px; text-align: margin-bottom:30px;"
						cellspacing="0" cellpadding="0">
						<tr>
							<td colspan="2"><div align="center">添加产品类别</div></td>
						</tr>
						<tr>
							<td width="23%">编号：</td>
							<td width="77%"><label for="categoryName"></label> <input
								type="text" name="" id="" /></td>
						</tr>
						<tr>
							<td width="23%">类别名称：</td>
							<td width="77%"><label for="categoryName"></label> <input
								type="text" name="categoryName" id="categoryName" /></td>
						</tr>
						<tr>
							<td width="23%">类别描述：</td>
							<td width="77%"><label for="cdescribe"></label> <textarea
									name="cdescribe" id="cdescribe" cols="45" rows="5"></textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div align="center">
									<input name="Submit" type="submit" class="button" value="添加">
									<input name="Submit" type="reset" class="button" value="重置">
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>


</body>
</html>