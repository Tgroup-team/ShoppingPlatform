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
				<a href="admin/baccounts1.jsp">返回</a>
			</div>
			<form action="cashwithdrawal?money=${seleteByManagerName.money }&managerId=${seleteByManagerName.managerId}" method="post"">
			<table border="1" class="order_tab"
				style="width: 450px; text-align: margin-bottom:30px;"
				cellspacing="0" cellpadding="0">
				<tr>
					<td colspan="2"><div align="center">提现</div></td>
				</tr>
				<tr>
					<td width="33%">管理员账户余额：</td>
					<td width="67%">${seleteByManagerName.money }</td>
				</tr>
				<tr>
					<td width="33%">提现金额：</td>
					<td width="67%"><label for="textfield"></label> <input
						type="text" name="textfield" id="textfield" /></td>
				</tr>

				<tr>
					<td colspan="2">
						<div align="center">
							<input type="submit" value="提现" /> <input type="reset"
								value="重置" />
						</div>
					</td>
				</tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>