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
            <div class="mem_tit">账户余额</div>
            <div align="right"style="margin-right: 20px;margin-top: -30px;font-size: 40px;margin-bottom: 10px;">  
            	<a href="addmoney.jsp"><input type="button" name=""  value="充值"  /></a>
            </div>
           <hr/>
           <br />
            <table border="1" class="order_tab" style="width:600px; text-align:center; margin-bottom:30px;" cellspacing="0" cellpadding="0">
              <tr>                                                                                                                                                    
                <td width="15%">姓名</td>
                <td width="15%">金额</td>
              </tr>
              <tr>
             	 <td>${user.vipName }</td>
               	 <td>${user.aBalance}元</td>
              </tr>
            </table>
        </div>
    </div>
</body>
</html>