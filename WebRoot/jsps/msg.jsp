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

<title>激活状态页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/vendor/bootstrap/css/bootstrap.min.css" />
<style type="text/css">
.statusPanel {
	width: 800px;
	height: auto;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -200px;
	margin-left: -400px;
}
.center-block {
  display: block;
  margin-left: auto;
  margin-right: auto;
  text-align:center;
}
</style>
</head>

<body>
	<div class="panel panel-primary statusPanel">
		<div class="panel-heading">用户激活状态</div>
		<div class="panel-body">
			<h1 class="text-primary">${msg}</h1>
		</div>
		<div class="panel-footer">
		<div class="center-block">
				 <a href="<%=path %>/jsps/user/login.jsp" class="btn btn-success btn-lg" role="button">马上登录</a>
				 <a href="<%=path %>/jsps/body.jsp" class="btn btn-primary btn-lg" role="button">回到首页</a>
			</div>
		</div>
	</div>
</body>
</html>
