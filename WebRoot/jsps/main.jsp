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

<title>图书商城首页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="<%=path%>/vendor/bootstrap/css/bootstrap.min.css" />
<!-- my css -->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/jsps/css/main.css" />
<script src='<%=path%>/vendor/bootstrap/js/jquery.js'></script>
</head>
<body>
		<!--引入头部文件  -->
	<jsp:include page="top.jsp"></jsp:include>
	
	<div class='minWidth'>
		<!--左侧菜单  -->
		<div id='leftPart'>
			<jsp:include page="left.jsp"></jsp:include>
		</div>
		<!-- 右侧banner -->
		<div id='rightPart'>
			<jsp:include page="banner.jsp"></jsp:include>
		</div>
		<!-- 图书内容展示区 -->

	</div>
	<div class='height_20'></div>
	<!-- 产品展示区 -->
	<div class='container'>

		<iframe id='iframepage' frameborder=”no” border=”0″
			src='<%=path%>/jsps/book/list.jsp' name='body' scrolling=no
			width="100%" height='auto' onLoad='reinitIframe();'></iframe>
	</div>
	<!-- 底部展示区 -->
			<jsp:include page='footer.jsp' />

	<script src='<%=path%>/vendor/bootstrap/js/bootstrap.min.js'></script>

	<script type="text/javascript" language="javascript">
		function reinitIframe() {
			var iframe = document.getElementById("iframepage");
			try {
				var bHeight = iframe.contentWindow.document.body.scrollHeight;
				var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
				var height = Math.max(bHeight, dHeight);
				iframe.height = height;
			} catch (ex) {
			}
		}

		var timer1 = window.setInterval("reinitIframe()", 500); //定时开始  

		function reinitIframeEND() {
			var iframe = document.getElementById("iframepage");
			try {
				var bHeight = iframe.contentWindow.document.body.scrollHeight;
				var dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
				var height = Math.max(bHeight, dHeight);
				iframe.height = height;
			} catch (ex) {
			}
			// 停止定时  
			window.clearInterval(timer1);

		}
	</script>
</body>
</html>
