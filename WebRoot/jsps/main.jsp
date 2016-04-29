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
	<jsp:include page="top.jsp"></jsp:include>
	<div class='container'>
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
	<div class='container'>
		<iframe id='iframepage' border=0 src='<%=path %>/jsps/book/list.jsp' name='body'  frameborder='0' scrolling='no'  width='100%‘ onload='iFrameHeight();'></iframe>
	</div>


	<script src='<%=path%>/vendor/bootstrap/js/bootstrap.min.js'></script>
	   
    <script type="text/javascript" >   
    function iFrameHeight() {   
    var ifm= document.getElementById("iframepage");   
    var subWeb = document.frames ? document.frames["iframepage"].document : ifm.contentDocument;   
    if(ifm != null && subWeb != null) {
       ifm.height = subWeb.body.scrollHeight;
       ifm.width = subWeb.body.scrollWidth;
    }   
    }   
    </script>
</body>
</html>
