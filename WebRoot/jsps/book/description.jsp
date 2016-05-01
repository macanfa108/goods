<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书详情页</title>



<link rel="stylesheet" type="text/css"
	href="<%=path%>/jsps/css/book/desc.css">
<style>
.BookName {
	width: 700px;
	font-size: 20px;
	font-weight: bold;
	word-wrap: break-word;
	word-break: break-all;
}
</style>
</head>

<body>
	<h2>图书详情</h2>
	<div>
		<img align="top" src="<%=path%>/${book.image_w}"
			class="img_image_w" />
		<div class="divBookDesc">
			<ul>

				<li class='BookName'>${book.bname}
				</li>
				<li>商品编号：${book.bid}</li>
				<li>定价：<span class="price_n">&yen;59</span></li>
				<li>当前价：<span class="spanPrice">&yen;${book.price}</span> 折扣：<span
					style="color: #c30;">${book.discount}</span>折
				</li>
			</ul>
			<!-- <hr class="hr1" /> -->
			<table>
				<tr>
					<td colspan="3">作者：${book.author }</td>
				</tr>
				<tr>
					<td colspan="3">出版社：${book.press }</td>
				</tr>
				<tr>
					<td colspan="3">出版时间：${book.publishtime }</td>
				</tr>
				<tr>
					<td>版次：${book.edition }</td>
					<td>页数：${book.pageNum }</td>
					<td>字数：${book.wordNum }</td>
				</tr>
				<tr>
					<td width="180">印刷时间：${book.printtime }</td>
					<td>开本：${book.booksize }开</td>
					<td>纸张：${book.paper }</td>
				</tr>
			</table>
			<div class="divForm">
				<form id="form1" action="www.baidu.com"
					method="post">
					<input type="hidden" name="method" value="add" />
					 <input
						type="hidden" name="bid" value="${book.bid }" /> 
						我要买：<input
						id="cnt" style="width: 40px;text-align: center;" type="text"
						name="quantity" value="1" />件
				</form>
				<a id="btn" href="javascript:$('#form1').submit();">立即购买</a>
			</div>
		</div>
	</div>
		<script src="<%=path %>/vendor/bootstrap/js/jquery.js"></script>
	<script>
	$(function() {
		$("#cnt").blur(function() {
			var quantity = $("#cnt").val();
			if(!/^[1-9]\d*$/.test(quantity)) {
				alert("数量必须是合法整数！");
				$("#cnt").val("1");
			}
		});
		
	});
	</script>
</body>
</html>
