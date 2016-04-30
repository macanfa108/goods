<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>图书列表页面</title>
<link rel="stylesheet" type="text/css"
	href="/goods/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css"
	href="<%=path %>/jsps/css/book/list.css">


</head>

<body>
	<div class="container">

		<h2>图书列表</h2>
		<div class="row">
			<!-- 每行3列 循环项 -->
			<div class="col-md-3">
				<!-- 每个图书 -->
				<div class="thumbnail card">
					<a href='<%=path%>/jsps/book/description.jsp'> <img src="book_img/21006995-1_b.jpg" />
						<div class="caption">
							<a href='<%=path%>/jsps/book/description.jsp''>
								<p class='noWrap'>锋利的jQuery(第2版)(畅销书升级版，增加jQuery
									Mobile和性能优化) 锋利的jQuery(第2版)(畅销书升级版，增加jQuery Mobile和性能优化)
									轻量级Javascript库jQuery图书畅销升级版</p>
							</a>
							<p class='text-primary'>
								<a href='#'>单东林 张晓菲 魏然 </a>编著
							</p>
							<p class='text-primary'>
								<a href='#'>人民邮电出版社</a>
							</p>

							<p>
								<span class='CurrentPrice'>¥41.50</span> <span class='OldPrice'>￥59.0</span><span
									class='Count'>8.0 折</span>
							</p>
						</div>
					</a>

				</div>
				<!-- 每个图书 -->
			</div>
			<!-- 每行3列 -->
			<!-- 每行3列 -->
			<div class="col-md-3">
				<!-- 每个图书 -->
				<div class="thumbnail card">
					<a href='#'> <img src="book_img/21006995-1_b.jpg" />
						<div class="caption">
							<a href='#'>
								<p class='noWrap'>锋利的jQuery(第2版)(畅销书升级版，增加jQuery
									Mobile和性能优化) 锋利的jQuery(第2版)(畅销书升级版，增加jQuery Mobile和性能优化)
									轻量级Javascript库jQuery图书畅销升级版</p>
							</a>
							<p class='text-primary'>
								<a href='#'>单东林 张晓菲 魏然 </a>编著
							</p>
							<p class='text-primary'>
								<a href='#'>人民邮电出版社</a>
							</p>

							<p>
								<span class='CurrentPrice'>¥41.50</span> <span class='OldPrice'>￥59.0</span><span
									class='Count'>8.0 折</span>
							</p>
						</div>
					</a>

				</div>
				<!-- 每个图书 -->
			</div>
			<!-- 每行3列 -->
			<!-- 每行3列 -->
			<div class=" col-md-3">
				<!-- 每个图书 -->
				<div class="thumbnail card">
					<a href='#'> <img src="book_img/21006995-1_b.jpg" />
						<div class="caption">
							<a href='#'>
								<p class='noWrap'>锋利的jQuery(第2版)(畅销书升级版，增加jQuery
									Mobile和性能优化) 锋利的jQuery(第2版)(畅销书升级版，增加jQuery Mobile和性能优化)
									轻量级Javascript库jQuery图书畅销升级版</p>
							</a>
							<p class='text-primary'>
								<a href='#'>单东林 张晓菲 魏然 </a>编著
							</p>
							<p class='text-primary'>
								<a href='#'>人民邮电出版社</a>
							</p>

							<p>
								<span class='CurrentPrice'>¥41.50</span> <span class='OldPrice'>￥59.0</span><span
									class='Count'>8.0 折</span>
							</p>
						</div>
					</a>

				</div>
				<!-- 每个图书 -->
			</div>
			<!-- 每行3列 -->
			<!-- 每行3列 -->
			<div class=" col-md-3">
				<!-- 每个图书 -->
				<div class="thumbnail card">
					<a href='#'> <img src="book_img/21006995-1_b.jpg" />
						<div class="caption">
							<a href='#'>
								<p class='noWrap'>锋利的jQuery(第2版)(畅销书升级版，增加jQuery
									Mobile和性能优化) 锋利的jQuery(第2版)(畅销书升级版，增加jQuery Mobile和性能优化)
									轻量级Javascript库jQuery图书畅销升级版</p>
							</a>
							<p class='text-primary'>
								<a href='#'>单东林 张晓菲 魏然 </a>编著
							</p>
							<p class='text-primary'>
								<a href='#'>人民邮电出版社</a>
							</p>

							<p>
								<span class='CurrentPrice'>¥41.50</span> <span class='OldPrice'>￥59.0</span><span
									class='Count'>8.0 折</span>
							</p>
						</div>
					</a>

				</div>
				<!-- 每个图书 -->
			</div>
			<!-- 每行3列 -->
			<!-- 每行3列 -->
			<div class="col-md-3">
				<!-- 每个图书 -->
				<div class="thumbnail card">
					<a href='#'> <img src="book_img/21006995-1_b.jpg" />
						<div class="caption">
							<a href='#'>
								<p class='noWrap'>锋利的jQuery(第2版)(畅销书升级版，增加jQuery
									Mobile和性能优化) 锋利的jQuery(第2版)(畅销书升级版，增加jQuery Mobile和性能优化)
									轻量级Javascript库jQuery图书畅销升级版</p>
							</a>
							<p class='text-primary'>
								<a href='#'>单东林 张晓菲 魏然 </a>编著
							</p>
							<p class='text-primary'>
								<a href='#'>人民邮电出版社</a>
							</p>

							<p>
								<span class='CurrentPrice'>¥41.50</span> <span class='OldPrice'>￥59.0</span><span
									class='Count'>8.0 折</span>
							</p>
						</div>
					</a>

				</div>
				<!-- 每个图书 -->
			</div>
			<!-- 每行3列 -->
		</div>
		<!-- row -->
		<div class='container'>
			<nav class='row pull-right'> <!-- 分页导航栏 -->
			<ul class="pagination '">
				<!-- 上一页 -->
				<li class="disabled"><span aria-hidden="true">上一页</span></li>
				<li><a href="#" aria-label="Previous"><span
						aria-hidden="true">上一页</span></a></li>
				<!-- 上一页 -->
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3 </a></li>
				<li><a href="#">4 </a></li>
				<li><a href="#">5 </a></li>
				<li><a href="#">6 </a></li>

				<li><span>...</span></li>
				<!-- 下一页 -->

				<li class="disabled"><a href="#" aria-label="Previous"><span
						aria-hidden="true">下一页</span></a></li>
				<li class="disabled"><span aria-hidden="true">下一页</span></li>
				<!-- 下一页 -->

				<!-- 总页数 -->
				<span class='totalPage'>共12页</span>
				<!-- 定位到指定页数 -->
				<span class='goPageSize '> 到 <input type='text'
					name='searchForPageSize' class='form-control'
					id='searchForPageSize' ' /> 页 <a href='javascript:goPageSize();'
					class='btn btn-default ' id='sureSize'>确定</a> 
				</span>
			</ul>

			</nav>
		</div>
		<script src="<%=path %>/vendor/bootstrap/js/jquery.js"></script>
		<script>
			/**
			 * 判断是否是正确页码
			 */
			function goPageSize() {
				
				var pageSize = $("#searchForPageSize").val();
				
				if (!/^[1-9]\d*$/.test(pageSize)) {
					alert("请输入正确的页码！");
					return false;
				}
				var MaxPageSize = 10;//此处的10为后台传过来的最大页码
				if (pageSize > MaxPageSize) {
					alert('请输入正确页码！');
					return false;
				}
				location = "www.baidu.com";//此处的url为请求的后台链接（加上参数）
			}
		</script>
</html>
