<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/style_1.css" />
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/select.js"></script>
</head>
<body style="background: transparent;">
	<div class="i_bg bg_color">
		<div class="m_right">
			<div style="float: right;">
				<a href="<%=request.getContextPath() %>/productservlet">返回</a>
			</div>
			<div align="center">

				<form action="addproduct" method="get">

					<table border="1" class="order_tab"
						style="width: 500px; text-align: margin-bottom:30px;"
						cellspacing="0" cellpadding="0">
						<tr>
							<td colspan="2"><div align="center">添加产品</div></td>
						</tr>
						<tr>
							<td>所属类别：</td>
							<td><select name="categoryId" id="categoryId">	
									<c:forEach items="${listCategory }" var="lc">
									   <option value="${lc.categoryId }">${lc.categoryName }</option>
									</c:forEach>
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
<!-- 						<tr>
							<td width="33%">产品图片地址：</td>
							<td width="67%"><input type="text" name="productImge"
								id="productImge" /></td>
						</tr>
						
						<tr>
							<td width="33%">产品描述图片地址：</td>
							<td width="67%"><input type="text" name="productDescriptionImages"
								id="productDescriptionImages" /></td>
						</tr> -->
						<tr>
							<td width="33%">产品图片：</td>
							<td width="67%"id="productImages_td">
								<button type="button" onclick="addproductImages()">点我添加图片地址</button>
							</td>
							<script type="text/javascript">
								var productImages_index=1;
								function addproductImages(){
									$("#productImages_td").append("<br class='productImages_line"+productImages_index+"'/><input type='text' class='productImages_line"+productImages_index+"' name='productImages' id='productImages"+productImages_index+"' /><button class='productImages_line"+productImages_index+"' onclick='removeproductImages("+productImages_index+")'>移除</button>");
									productImages_index++;
								}
								function removeproductImages(index){
									$(".productImages_line"+index).remove();
								}
							</script>
						</tr>
						<tr>
							<td width="33%">产品介绍图片：</td>
							<td width="67%" id="productDescriptionImages_td">
							<button type="button" onclick="addproductDescriptionImages()">点我添加图片地址</button>
							</td>
							<script type="text/javascript">
								var productDescriptionImages_index=1;
								function addproductDescriptionImages(){
									$("#productDescriptionImages_td").append("<br class='productDescriptionImages_line"+productDescriptionImages_index+"'/><input type='text' class='productDescriptionImages_line"+productDescriptionImages_index+"' name='productDescriptionImages' id='productDescriptionImages"+productDescriptionImages_index+"' /><button class='productDescriptionImages_line"+productDescriptionImages_index+"' onclick='removeproductDescriptionImages("+productDescriptionImages_index+")'>移除</button>");
									productDescriptionImages_index++;
								}
								function removeproductDescriptionImages(index){
									$(".productDescriptionImages_line"+index).remove();
								}
							</script>
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
							<td width="33%">产品产地：</td>
							<td width="67%"><input type="text" name="suppliers"
								id="suppliers" /></td>
						</tr>

						<tr>
							<td colspan="2">
								<div align="center">
									<input name="Submit" type="submit" class="button" value="添加">
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