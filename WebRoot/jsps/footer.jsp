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

<title>底部导航条</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
	href="<%=path%>/jsps/css/footer.css">

</head>

<body>
	<div class='container-fluid '  id='footer'>
		<div class='container'>
			<p class='text-muted'>Copyright (C) 图书商城网 2004-2016, All Rights Reserved</p>
			<p class='text-muted'>京ICP证041189号|出版物经营许可证 新出发京批字第直0673号|食品流通许可证：SP1101011010021855(1-1)</p>
			<p class='text-muted'>互联网药品信息服务资格证编号：(京)-非经营性-2012-0016|京公网安备110101000001号</p>
		</div>

	</div>
</body>
</html>
