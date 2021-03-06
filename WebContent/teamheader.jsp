<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>新增地址</title>

		<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="css/personal.css" rel="stylesheet" type="text/css">
		<link href="css/addstyle.css" rel="stylesheet" type="text/css">
		<script src="AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
		<script src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>

	</head>

<body style="background: transparent;">
		<div class="user-address"> 
			
			<a class="new-abtn-type" data-am-modal="{target: '#doc-modal-1', closeViaDimmer: 0}">添加</a>
			<!--例子-->
			<div class="am-modal am-modal-no-btn" id="doc-modal-1">

				<div class="add-dress">

					<!--标题 -->
					<div class="am-cf am-padding">
						<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">请确认申请人信息</strong></div>
					</div>
					<hr/>

					<div class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;"  >
						<form class="am-form am-form-horizontal" action="applyLeaderServlet" method="post">

							<div class="am-form-group">
								<label for="user-name" class="am-form-label">申请人</label>
								<div class="am-form-content">
									<input type="text" id="user-name" value="${user.vipName }" style="width:540px" disabled="disabled">
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-phone" class="am-form-label">手机号码</label>
								<div class="am-form-content">
									<input id="user-phone" value="${user.vipPhone }"style="width:540px" disabled="disabled" type="text">
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-address" class="am-form-label">所在小区</label>
								<div class="am-form-content address">
									<input id="user-phone" value="${user.address }" style="width:540px" disabled="disabled" type="text">
								</div>
						    </div>
							
							<%-- <div class="am-form-group">
										<label for="user-address" class="am-form-label">所在小区</label>
										<p>${user.address }</p>
										<div class="am-form-content address">
											<select data-am-selected>
												<option value="a">浙江省</option>
												<option value="b" selected>湖北省</option>
											</select>
											<select data-am-selected>
												<option value="a">温州市</option>
												<option value="b" selected>武汉市</option>
											</select>
											<select data-am-selected>
												<option value="a">瑞安区</option>
												<option value="b" selected>洪山区</option>
											</select>
										</div>
									</div>

									<div class="am-form-group">
										<label for="user-intro" class="am-form-label">详细地址</label>
										<div class="am-form-content">
											<p>${user.address }</p>
											<small>100字以内写出你的详细地址...</small>
										</div>
									</div>
--%>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input  style="background:#00ff00;border:1px solid #ccc;" class="am-btn am-btn-danger" type="submit" value="提交">	
									&nbsp &nbsp &nbsp
									<a href="javascript: void(0)" class="am-close am-btn am-btn-danger" data-am-modal-close>返回</a>
								</div>
							</div>
						</form>
					</div>

				</div>

			</div>

		</div>

		<script type="text/javascript">
			$(document).ready(function() {							
				$(".new-option-r").click(function() {
					$(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
				});
				
				var $ww = $(window).width();
				if($ww>640) {
					$("#doc-modal-1").removeClass("am-modal am-modal-no-btn")
				}
				
			})
		</script>

		<div class="clear"></div>
	
</body>

</html>