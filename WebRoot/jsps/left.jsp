<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>left</title>
    


	<%-- <script type="text/javascript" src="<c:url value='/vendor/bootstrap/js/jquery.js'/>"></script> --%>
	<script type="text/javascript" src="<c:url value='/menu/mymenu.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/menu/mymenu.css'/>" type="text/css" media="all">
	<%-- <link rel="stylesheet" type="text/css" href="<%=path%>/jsps/css/left.css" /> --%>
<script language="javascript">
/*
 * 1. 对象名必须与第一个参数相同！
   2. 第二个参数是显示在菜单上的大标题
 */
var bar = new Q6MenuBar("bar", "图书商城");
$(function() {
	bar.colorStyle = 1;//指定配色样式，一共0,1,2,3,4
	bar.config.imgDir = "<c:url value='/menu/img/'/>";//小工具所需图片的路径
	bar.config.radioButton=true;//是否排斥，多个一级分类是否排斥

	/*
	1. 程序设计：一级分类名称
	2. Java Javascript：二级分类名称
	3. /goods/jsps/book/list.jsp：点击二级分类后链接到的URL
	4. body:链接的内容在哪个框架页中显示
	*/

	bar.add("一级分类1", "一级分类11", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类1", "一级分类12", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类1", "一级分类13", "/goods/jsps/book/list.jsp", "body");
	
	bar.add("一级分类2", "一级分类21", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类2", "一级分类22", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类2", "一级分类23", "/goods/jsps/book/list.jsp", "body");
	
	bar.add("一级分类3", "一级分类21", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类3", "一级分类22", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类3", "一级分类23", "/goods/jsps/book/list.jsp", "body");
  
	bar.add("一级分类4", "一级分类21", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类4", "一级分类22", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类4", "一级分类23", "/goods/jsps/book/list.jsp", "body");
  
	bar.add("一级分类5", "一级分类21", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类5", "一级分类22", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类5", "一级分类23", "/goods/jsps/book/list.jsp", "body");
  
	bar.add("一级分类6", "一级分类21", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类6", "一级分类22", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类6", "一级分类23", "/goods/jsps/book/list.jsp", "body");
  
	bar.add("一级分类7", "一级分类21", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类7", "一级分类22", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类7", "一级分类23", "/goods/jsps/book/list.jsp", "body");
	
	bar.add("一级分类8", "一级分类21", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类8", "一级分类22", "/goods/jsps/book/list.jsp", "body");
	bar.add("一级分类8", "一级分类23", "/goods/jsps/book/list.jsp", "body");
  
	
	$("#menu").html(bar.toString());
});
</script>
</head>
  
<body>  
  <div id="menu"></div>
</body>
</html>
