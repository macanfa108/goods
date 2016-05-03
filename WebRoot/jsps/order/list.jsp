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
    <title>订单列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css"
	href="<%=path%>/vendor/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css"
	href="<%=path%>/jsps/css/book/list.css">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/order/list.css'/>" />
	<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" /> --%>
   <%--  <script type="text/javascript" src="<c:url value='/jsps/pager/pager.js'/>"></script> --%>
  </head>
  
  <body>
<div class="divMain">
	<div class="divTitle">
		<span style="margin-left: 150px;margin-right: 280px;">商品信息</span>
		<span style="margin-left: 40px;margin-right: 38px;">金额</span>
		<span style="margin-left: 50px;margin-right: 40px;">订单状态</span>
		<span style="margin-left: 50px;margin-right: 50px;">操作</span>
	</div>
	<br/>
	<table align="center" border="0" width="100%" cellpadding="0" cellspacing="0">

<c:forEach items="${pb.beanList }" var="order">

		<tr class="tt">
			<td width="320px">订单号：<a  href="<c:url value='/OrderServlet?method=load&oid=${order.oid }'/>">${order.oid }</a></td>
			<td width="200px">下单时间：${order.ordertime }</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr style="padding-top: 10px; padding-bottom: 10px;">
			<td colspan="2">


  <c:forEach items="${order.orderItemList }" var="orderItem">
	<a class="link2" href="<c:url value='/BookServlet?method=load&bid=${orderItem.book.bid }'/>">
	    <img border="0" width="70" src="<c:url value='/${orderItem.book.image_b }'/>"/>
	</a>
  </c:forEach>
	



			</td>
			<td width="115px">
				<span class="price_t">&yen;${order.total }</span>
			</td>
			<td width="142px">
<c:choose>
	<c:when test="${order.status eq 1 }">(等待付款)</c:when>
	<c:when test="${order.status eq 2 }">(准备发货)</c:when>
	<c:when test="${order.status eq 3 }">(等待确认)</c:when>
	<c:when test="${order.status eq 4 }">(交易成功)</c:when>
	<c:when test="${order.status eq 5 }">(已取消)</c:when>
</c:choose>			

			</td>
			<td>
			<a href="<c:url value='/OrderServlet?method=load&oid=${order.oid }'/>">查看</a><br/>
<c:if test="${order.status eq 1 }">
				<a href="<c:url value='/OrderServlet?method=paymentPre&oid=${order.oid }'/>">支付</a><br/>
				<a href="<c:url value='/OrderServlet?method=load&oid=${order.oid }&btn=cancel'/>">取消</a><br/>						
</c:if>
<c:if test="${order.status eq 3 }">
				<a href="<c:url value='/OrderServlet?method=load&oid=${order.oid }&btn=confirm'/>">确认收货</a><br/>
</c:if>
			</td>
		</tr>
</c:forEach>



	</table>
	<br/>
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
			var MaxPageSize = 10;//此处的10为后台传过来的最大页码${pb.tp}
			if (pageSize > MaxPageSize) {
				alert('请输入正确页码！');
				return false;
			}

			location = "${pb.url}&pc="+pageSize;//此处的url为请求的后台链接（加上参数）

		}
	</script>
</div>
  </body>
</html>
