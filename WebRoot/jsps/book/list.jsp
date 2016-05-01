<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	href="<%=path%>/jsps/css/book/list.css">
</head>

<body>
	<div class="container">
		<h2>图书列表</h2>
		<c:forEach items="${pb.beanList}" var="book">
				<div class=" col-md-3">
				<!-- 每个图书 -->
				<div class="thumbnail card">
					<a href='#'> <img src="<c:url value='/${book.image_b}'/>" />
						<div class="caption">
							<a href='#'>
								<p class='noWrap'>${book.bname}</p>
							</a>
							<p class='text-primary'>
								<a href='#'>${book.author} </a>编著
							</p>
							<p class='text-primary'>
								<a href='#'>${book.press}</a>
							</p>
							<p>
								<span class='CurrentPrice'>${book.currPrice}</span> <span class='OldPrice'>${book.price}</span><span
									class='Count'>${book.discount} 折</span>
							</p>
						</div>
					</a>
				</div>
				<!-- 每个图书 -->
			</div>
			</c:forEach>
	<!-- row -->
	<div class='container'>
		<nav class='row pull-right'> <!-- 分页导航栏 -->
		<ul class="pagination '">
			<!-- 上一页 -->
			<c:choose>
				<%-- 判断当前页数是否等于1  true 上一页无法点击 --%>
				<c:when test="${pb.pc eq 1}"><li class="disabled"><span aria-hidden="true">上一页</span></li></c:when>
			<c:otherwise>
			   <li>
				 <a href="${pb.url}&pc=${pb.pc-1}" aria-label="Previous"><span
					aria-hidden="true">上一页</span>
			    </a>
			   </li>
			</c:otherwise>
			
			</c:choose>
			<!-- 显示 1 2 3 4 5 6  -->
			<c:choose>
				<%-- pb.tp 总页数  --%>
				<c:when test="${pb.tp <= 6}">
						<c:set var="begin" value="1"></c:set>
						<c:set var="end" value="${pb.tp}"></c:set>
				</c:when>
				
				<c:otherwise>
						<c:set var="begin" value="${pb.pc - 2}"></c:set>
						<c:set var="end"  value="${pb.pc + 3}"></c:set>
						<c:if test="${begin < 1 }">
								<c:set var="begin" value="1"></c:set>
						        <c:set var="end" value="6"></c:set>
						</c:if>
						<%-- end大于总页数 --%>
						<c:if test="${end > pb.tp }">
								<c:set var="begin" value="${pb.tp -5}"></c:set>
						        <c:set var="end" value="${pb.tp}"></c:set>
						</c:if>
				</c:otherwise>
			</c:choose>
			
			<c:forEach begin="${begin}" end="${end}" var="i">
			 		<c:choose>
			 		<%-- 当前页数 高亮显示 --%>
			 		<c:when test="${i eq pb.pc }">
			 			<li class="active"><a href="#">${i}</a></li>
			 		</c:when>
			 		<c:otherwise>
			 			<li><a href="${pb.url}&pc=${i}">${i}</a></li>
			 		</c:otherwise>
			 		</c:choose>	
			</c:forEach>
					<c:if test="${end < pb.tp}">
						<li><span>...</span></li>
					</c:if>
			<!-- 下一页 -->
			<c:choose>
			 	<c:when test="${pb.pc eq pb.tp}"><li class="disabled"><span aria-hidden="true">下一页</span></li>
				</c:when>
				<c:otherwise>
				<!-- class="disabled" -->
				  <li>
				  <a href="${pb.url}&pc=${pb.pc+1}" aria-label="Previous"><span
					    aria-hidden="true">下一页</span></a>
				</li>
				</c:otherwise>
			</c:choose>
		
			<!-- 总页数 -->
			<span class='totalPage'>共${pb.tp}页</span>
			<!-- 定位到指定页数 -->
			<span class='goPageSize '> 到 <input type='text'
				name='searchForPageSize' class='form-control' id='searchForPageSize'  value='${pb.pc }' />
				页 <a href='javascript:goPageSize();' class='btn btn-default '
				id='sureSize'>确定</a> </span>
		</ul>

		</nav>
	</div>
	<script src="<%=path%>/vendor/bootstrap/js/jquery.js"></script>
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
			var MaxPageSize = ${pb.tp};//此处的10为后台传过来的最大页码
			if (pageSize > MaxPageSize) {
				alert('请输入正确页码！');
				return false;
			}
			location = "${pb.url}&pc="+pageSize;//此处的url为请求的后台链接（加上参数）
		}
	</script>
</html>
