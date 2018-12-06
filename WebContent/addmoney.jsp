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
  <div class="m_right" >
       <div class="am-cf am-padding" style="font-size: 21px;">
		<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">充值中心</strong> / <small>Add&nbsp;Money</small></div>
	   </div>
     	<hr/>
      <table border="1" class="order_tab" style="width:450px; text-align: margin-top:30px;" cellspacing="0" cellpadding="0">
               <tr>                                                                                                                                                    
                <td colspan="2"><div align="center">充值</div></td>
              </tr>
              <tr>
                <td width="33%">充值金额</td>
                <td width="67%"><form id="form1" name="form1" method="post" action="">
                  <label for="textfield"></label>
                  <input type="text" name="textfield" id="textfield" />
                </form></td>
               
              </tr>
              <tr>
                <td width="33%">充值账户</td>
                <td width="67%"><form id="form1" name="form1" method="post" action="">
                  <label for="textfield"></label>
                  <input type="text" name="textfield" id="textfield" />
                </form></td>
               
              </tr>
              
             
                   <tr> <td colspan="2">
                     <div align="center">
                       <input type="submit" value="确定" />  
                       <input type="reset" value="重置" />
                     </div>    
                   </td>
               </tr>
      </table>
                   

    </div>
    </div>
    

</body>
</html>
