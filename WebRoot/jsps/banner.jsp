<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
<head>
<title>banner部分</title>
<style type="text/css" id="css">
* {
	margin: 0px;
	padding: 0px;
}

li {
	list-style: none;
}
/* 重定义bootstrap.min.css中的ul,olmargin-bottom属性 */
ul.pic {
	margin-bottom: 0px;
}

.wrap {
	height: 360px;
	/* background: #ccc; */
	perspective: 800px;
}

.wrap .pic li {
	/*width:200px;*/
	height: 360px;
	float: left;
	position: relative;
	transform-style: preserve-3d;
	transition: 2s;
	transform: translateZ(-180px);
}

.wrap .pic li span {
	/*width:200px;*/
	height: 360px;
	display: block;
	position: absolute;
}

.wrap .pic li span:nth-child(1) {
	top: -360px;
	transform-origin: bottom;
	transform: translateZ(180px) rotateX(90deg);
	background: url("images/bannerImages/2.png") no-repeat;
	background-size:cover;

}

.wrap .pic li span:nth-child(2) {
	top: 360px;
	transform-origin: top;
	transform: translateZ(180px) rotateX(-90deg);
	background: url("images/bannerImages/4.jpg") no-repeat;
	background-size:cover;

}

.wrap .pic li span:nth-child(3) {
	transform: translateZ(180px);
	background: url("images/bannerImages/1.png") no-repeat;
	background-size:cover;

}

.wrap .pic li span:nth-child(4) {
	transform: translateZ(-180px) rotateX(180deg);
	background: url("images/bannerImages/3.jpg") no-repeat;
	background-size:cover;
	
}

.wrap .pic li span:nth-child(5) {
	right: 200px;
	width: 360px;
	transform-origin: right;
	transform: translateZ(180px) rotateY(-90deg);
}

.wrap .pic li span:nth-child(6) {
	left: 200px;
	width: 360px;
	transform-origin: left;
	transform: translateZ(180px) rotateY(90deg);
}
/*.wrap .pic:hover li{
	transform:translateZ(-180px) rotateX(180deg);
}*/
/*
.wrap .pic li:nth-child(1) span{
	background-position:0px;
}
.wrap .pic li:nth-child(2) span{
	background-position:-200px;
}
.wrap .pic li:nth-child(3) span{
	background-position:-400px;
}
.wrap .pic li:nth-child(4) span{
	background-position:-600px;
}
*/
/*
.wrap .pic li:nth-child(1){
	transition:2s 0s;
}
.wrap .pic li:nth-child(2){
	transition:2s 0.5s;
}
.wrap .pic li:nth-child(3){
	transition:2s 1s;
}
.wrap .pic li:nth-child(4){
	transition:2s 1.5s;
}
*/
.wrap .btn {
	position: absolute;
	bottom: 10px;
	right: 10px;
}

.wrap .btn li {
	width: 20px;
	height: 20px;
	background: #000;
	color: #fff;
	float: left;
	border-radius: 10px;
	text-align: center;
	line-height: 20px;
	margin-left: 10px;
	cursor: pointer;
}
</style>
</head>

<body>
	<div class="wrap">
		<ul class="pic">
		</ul>
		<ul class="btn">
			<li>1</li>
			<li>2</li>
			<li>3</li>
			<li>4</li>
		</ul>
	</div>
	<script type="text/javascript">
		function play(x) {/*封装*/
			/*数值定义*/
			var pHtml = "", cHtml = "", zHtml = "", tHtml = "";
			var lwid = 800 / x;/*li,span的宽度*/
			var z = 0;
			/*动态添加标签和样式*/
			for (var i = 0; i < x; i++) {
				pHtml += "<li><span></span><span></span><span></span><span></span><span></span><span></span></li>";
				cHtml += ".wrap .pic li:nth-child(" + (i + 1)
						+ ") span{background-position:" + (-i * lwid) + "px;}";
				if (i > x / 2) {
					z--;
					zHtml += ".wrap .pic li:nth-child(" + (i + 1)
							+ "){z-index:" + z + ";}"
				}
				tHtml += ".wrap .pic li:nth-child(" + (i + 1)
						+ "){transition:2s " + 0.5 * i / x + "s;}"/*0.5*i/x是强制在0.5秒内完成*/
			}
			$(".pic").append(pHtml);
			$("#css").append(cHtml + zHtml + tHtml);

			$(".pic li").css("width", lwid);
			$(".pic li span").css("width", lwid);

			$(".btn li").click(
					function() {
						var a = $(this).index();
						var b = a * 90 + 'deg';
						$(".pic li").css("transform",
								"translateZ(-180px) rotateX(" + b + ")");
					})
		}
		play(100);
	</script>
</body>
</html>
