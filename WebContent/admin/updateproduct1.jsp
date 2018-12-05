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
				<a href="product1.html">返回</a>
			</div>
			<div align="center">
				<form method="post" action="DoAddproductServlet">
					<table border="1" class="order_tab"
						style="width: 500px; text-align: margin-bottom:30px;"
						cellspacing="0" cellpadding="0">
						<tr>
							<td colspan="2"><div align="center">修改产品</div></td>
						</tr>
						<tr>
							<td>所属类别：</td>
							<td><select name="categoryId" id="categoryId">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
							</select></td>
						<tr>
							<td width="33%">产品名称：</td>
							<td width="67%"><input type="text" name="productName"
								id="productName" /></td>
						</tr>
						<tr>
							<td width="33%">产品单价：</td>
							<td width="67%"><input type="text" name="productPrice"
								id="productPrice" /></td>
						</tr>
						<tr>
							<td width="33%">图片地址：</td>
							<td width="67%"><input type="text" name="productImge"
								id="productImge" /></td>
						</tr>
						<tr>
							<td width="33%">库存量：</td>
							<td width="67%"><input type="text" name="inventory"
								id="inventory" /></td>
						</tr>
						<tr>
							<td>产品状态：</td>
							<td><select name="productState" id="productState">
									<option>上架</option>
									<option>下架</option>
							</select></td>
						</tr>
						<tr>
							<td width="33%">产品描述：</td>
							<td width="67%"><input type="text" name="suppliers"
								id="suppliers" /></td>
						</tr>

						<tr>
							<td colspan="2">
								<div align="center">
									<input name="Submit" type="submit" class="button" value="修改">
									<input type="reset" class="button" value="重置">
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