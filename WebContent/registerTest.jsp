<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head lang="en">
		<meta charset="UTF-8">
		<title>注册</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta name="format-detection" content="telephone=no">
		<meta name="renderer" content="webkit">
		<meta http-equiv="Cache-Control" content="no-siteapp" />

		<link rel="stylesheet" href="AmazeUI-2.4.2/assets/css/amazeui.min.css" />
		<link href="css/dlstyle.css" rel="stylesheet" type="text/css">
		<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"></script>
		<script src="AmazeUI-2.4.2/assets/js/amazeui.min.js"></script>

	</head>

	<body>

		<div class="login-boxtitle">
			<a href="login2.html"><img alt="" src="images/logobig.png" /></a>
		</div>

		<div class="res-banner">
			<div class="res-main">
				<div class="login-banner-bg"><span></span><img src="images/big.jpg" /></div>
				<div class="login-box">

						<div class="am-tabs" id="doc-my-tabs">
							<ul class="am-tabs-nav am-nav am-nav-tabs am-nav-justify">
								
								<li><a href="">手机号注册</a></li>
							</ul>

							<div class="">

								<div class="am-tab-panel">
									<form method="post">
                        <div class="user-phone">
								    <label for="vipName"></label>
								    <input type="vipName" name="" id="vipName" placeholder="请输入会员姓名">
                 </div>																						
                        <div class="user-phone">
								    <label for="password"></label>
								    <input type="password" name="" id="password" placeholder="请输入会员密码">
                 </div>										
                        <div class="user-phone">
								    <label for="phone"></label>
								    <input type="tel" name="" id="phone" placeholder="请输入手机号">
                 </div>	
                        <div class="user-phone">
								    <label for="address"></label>
								    <input type="address" name="" id="address" placeholder="请输入地址">
                 </div>	
                        <div class="user-phone">
								     
            
            所属社区：<form id="form2" name="form2" method="post" action="">
              <p class="am-u-sm-pull-11">&nbsp;</p>
				<select name="select" id="select">
	            <!--     <option>雨花小区</option>
	                <option>天星小区</option>
                 	<option>开福小区</option>
                  	<option>芙蓉小区</option>
                    <option>岳麓小区</option>
                    <option>开福小区</option> -->
                    <c:forEach items="${communitys}" var="com">
                    	<option value="${com.communityId }">${com.communityName }</option>
                    </c:forEach>
             	 </select>
            </form>

                 </div>	
									</form>
               
								 
										<div class="am-cf">
											<input type="submit" name="" value="注册" class="am-btn am-btn-primary am-btn-sm am-fl">
										</div>
								
									<hr>
								</div>

								<script>
									$(function() {
									    $('#doc-my-tabs').tabs();
									  })
								</script>

							</div>
						</div>

				</div>
			</div>
			
					<div class="footer ">
						<div class="footer-hd ">
							<p>
								<a href="# ">恒望科技</a>
								<b>|</b>
								<a href="# ">商城首页</a>
								<b>|</b>
								<a href="# ">支付宝</a>
								<b>|</b>
								<a href="# ">物流</a>
							</p>
						</div>
						<div class="footer-bd ">
							<p>
								<a href="# ">关于恒望</a>
								<a href="# ">合作伙伴</a>
								<a href="# ">联系我们</a>
								<a href="# ">网站地图</a>
								<em>© 2015-2025 Hengwang.com 版权所有</em>
							</p>
						</div>
					</div>
	</body>

</html>