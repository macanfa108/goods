<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">

<title>用户注册</title>
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
	href="<%=path %>/vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/jsps/css/user/regist.css'/>">
	

</head>

<body>
	<div class="container-fluid">
		<form action="">
			<div class="form-group">
				<label for="loginName">用户名:</label> <input type="text"
					class="form-control" id="loginName" name='loginName'
					placeholder="请输入用户名">
			</div>
		</form>
	</div>
</body>
</html>
