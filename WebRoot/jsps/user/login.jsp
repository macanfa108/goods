<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">

<title>用户登录页面</title>
<meta content="charset='utf-8'" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- css -->
<link rel="stylesheet" type="text/css"
	href="<%=path%>/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=path%>/jsps/css/user/login.css">


</head>

<body>
	<div class="container">
	<div class="box">
		   
		  <div class="registBox">
			<!--面板-->
			<div class="panel  panel-info">
				<!--标题-->
				<div class="panel-heading text-success">用户登录</div>
				<!--主体-->
				<div class="panel-body">
				
					<form class="form-horizontal" method="post" action="#" id="loginForm">
					<!-- 发送参数的隐藏的input -->
					<input type="hidden" name="method" value='#'>
					
						<!--用户名输入-->
						<div class="form-group">
							<label for="loginName" class="col-sm-2 control-label">用户名：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="loginName" name="loginName"
									placeholder="请输入用户名"  value="">
							</div>
							<div class="col-sm-4">
								<p class=" errorMsg bg-danger">
								<span class='glyphicon glyphicon-remove'></span> 
								<!-- 后台返回的错误信息.Msg -->
								<span class='Msg' id="loginNameError"></span>
								</p>
							</div>
							
						</div>
						<!--密码输入-->
						<div class="form-group">
							<label for="loginpassword" class="col-sm-2 control-label">密码：</label>
							<div class="col-sm-6">
								<input type="password" class="form-control" id="loginpassword" name="loginpassword"
									placeholder="请输入密码"  value="">
							</div>
							<div class="col-sm-4">
								<p class="bg-danger text-muted errorMsg">
								<span class='glyphicon glyphicon-remove'></span> 
								<!-- 后台返回的错误信息.Msg -->
								<span class='Msg' id="loginpasswordError"></span>
								</p>
							</div>
						</div>
						
						<!--验证码输入框-->
						<div class="form-group">
							<label for="VerificationCode" class="col-sm-2 control-label">验证码：</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="VerificationCode" name="VerificationCode"
									placeholder="请输入验证码"   value="">
							</div>
							<div class="col-sm-4">
								<p class="bg-danger text-muted errorMsg">
								<span class='glyphicon glyphicon-remove'></span> 
								<!-- 后台返回的错误信息.Msg -->
								<span class='Msg' id="VerificationCodeError"></span>
								</p>
							</div>
						</div>
						<!--验证码图片-->
						<div class="form-group">
							<div class="col-sm-6 col-sm-offset-2">
								<div class="thumbnail">
									<img src="../logo.png"/ id="imgVerifyCode"><!-- 验证码图片 -->
								</div>
							</div>
							<div class="col-sm-4">
								<a href="javascript:changeImg();" class="btn btn-info">换一张</a><!-- 换码按钮 -->
							</div>
						</div>
						<!--登录按钮-->
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-6">
								<button type="submit" class="btn btn-success btn-block">登录</button>
							</div>
						</div>
						<div class="form-group">
						<div class="col-sm-offset-2 col-sm-4">
								还没账号？
							</div>
							<div class="col-sm-6">
								<button type="submit" class="btn btn-default ">注册</button>
							</div>
						</div>
					</form>
					
				</div>
				
			</div>
		</div>
		<!--registBox-->
		</div>
		
	</div>
	<!--js-->
	<script src="<%=path%>/vendor/bootstrap/js/jquery.js"></script>
	<script src="<%=path%>/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=path%>/jsps/js/user/login.js"></script>
</body>
</html>
