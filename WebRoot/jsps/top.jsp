
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
<%-- <base href="<%=basePath%>"> --%>

<%-- <title>顶部导航条</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css"
href="<%=path%>/vendor/bootstrap/css/bootstrap.min.css" /> --%>
<link rel="stylesheet" type="text/css" href="<%=path%>/jsps/css/top.css" />

</head>
<body>
	<nav>
	<div class="container-fluid containerColor">
		<div class="container">
			<ul class="nav navbar-nav">
				<li><a class='name'>游客,欢迎来到图书商城！</span></a></li>
				<li><a href="<%=path%>/jsps/user/login.jsp">登录</a></li>
				<li><a href="<%=path%>/jsps/user/regist.jsp">免费注册</a></li>
			</ul>
			<ul class="nav navbar-nav  navbar-right">
				<li><a href="<%=path%>/jsps/user/login.jsp"><span
						class='glyphicon glyphicon-shopping-cart'></span> 我的购物车</a></li>
				<li><a href="<%=path%>/jsps/user/regist.jsp"><span
						class="glyphicon glyphicon-list-alt"></span> 我的订单</a></li>
				<li><a href="<%=path%>/jsps/user/regist.jsp"><span
						class='glyphicon glyphicon-pencil'></span> 修改密码</a></li>
				<li><a href="<%=path%>/jsps/user/regist.jsp"><span
						class='glyphicon glyphicon-log-out'></span> 退出商城</a></li>
				<li><a href="<%=path%>/jsps/user/regist.jsp"><span
						class="glyphicon glyphicon-comment"></span> 联系我们</a></li>
			</ul>
		</div>
	</div>
	<!-- /.container-fluid --> </nav>
	<!-- logo和搜索框 -->
	<div class='container-fluid  searchPart''>
		<div class='container'>
			<div class='pull-left logoBox'>
				<img src="<%=path%>/images/logo.png">
			</div>
				<!-- 按名称搜索表单 -->
			<form class="navbar-form navbar-right" role="search">
				<div class="form-group">
					<input type="hidden" name="method" value="#" /> <input type="text"
						class='form-control' name="bookName" placeholder='搜索您要的图书' />
				</div>
				<a href="#" class="btn btn-default" target='body'>搜索</a>
			</form>
		
			
		</div>

	</div>
</body>
</html>