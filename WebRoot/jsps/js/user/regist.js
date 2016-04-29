/**
 * 
 */
$(function(){
	/**
	 * 1.调用方法显示错误信息
	 */
	$(".Msg").each(function(){
		showError($(this));
	});
	/**
	 * 输入框获取焦点隐藏错误信息
	 */
	$(".form-control").focus(function(){
		//获取错误信息元素，清空，再？显示
		var MsgId=$(this).attr('id')+"Error";
		$("#"+MsgId).text("");
		showError($("#"+MsgId));
	});
	/**
	 * 输入框失去焦点，调用对应的校验方法
	 */
	$(".form-control").blur(function(){
		var id=$(this).attr("id");
		console.log(id);
		var funName="validate"+id.substring(0,1).toUpperCase()+id.substring(1)+"()";
		eval(funName);
	});
	/**
	 * registForm表单提交全部校验
	 */
	$("#registForm").submit(function(){
		var bool=true;
		if(!validateLoginName()){
			bool=false;
		}
		if(!validateLoginpassword()){
			bool=false;
		}
		if(!validateReloginpassword()){
			bool=false;
		}
		if(!validateEmail()){
			bool=false;
		}
		if(!validateVerificationCode()){
			bool=false;
		}
		return bool;
	})
});
/**
 * 是否显示错误信息
 * @param ele
 */
function showError(ele){
	var text=ele.text();
//	console.log(text);
	if(!text){
		ele.parent(".errorMsg").hide();
	}else{
		ele.parent(".errorMsg").show();
	}
};
/**
 * 换一张验证码
 */
function changeImg(){
	/**
	 * 获取img元素重新设置src，添加毫秒参数
	 */
	
	$("#imgVerifyCode").attr("src","/goods/VerifyCodeServlet?a="+new Date().getTime());
};
/**
 * 校验用户名
 * 非空校验
 * 长度校验
 * 是否已经注册
 */
function validateLoginName(){
	var id="loginName";
	var value=$("#"+id).val();
	
	if(!value){
		$("#"+id+"Error").text("用户名不能为空！");
		showError($("#"+id+"Error"));
		return false;
	}
	if(value.length<3||value.length>20){
		$("#"+id+"Error").text("长度必须在3~20之间！");
		showError($("#"+id+"Error"));
		return false;
	}
//	是否已经注册
	$.ajax({
		url:"/goods/UserServlet",//调用的servlet
		data:{
			method:"ajaxValidateLoginname",//调用方法名
			loginname:value
		},
		type:'post',
		dataType:'json',
		async:false,//异步加载
		cache:false,
		success:function(result){
			if(!result){//校验失败
				$("#"+id+"Error").text("用户名已被注册！");
				showError($("#"+id+"Error"));
				return false;
			}
		}
	})
	
	return true;
	
};
/**
 * 校验密码
 */
function validateLoginpassword(){
	var id='loginpassword';
	var value=$("#"+id).val();
	if(!value){
		$("#"+id+"Error").text("密码不能为空！");
		showError($("#"+id+"Error"));
		return false;
	}
	if(value.length<3||value.length>20){
		$("#"+id+"Error").text("长度必须在3~20之间！");
		showError($("#"+id+"Error"));
		return false;
	}
	return true;
};
/**
 * 校验确认密码
 */
function validateReloginpassword(){
	var id='reloginpassword';
	var value=$("#"+id).val();
	if(!value){
		$("#"+id+"Error").text("密码不能为空！");
		showError($("#"+id+"Error"));
		return false;
	}
	if(value!=$("#loginpassword").val()){
		$("#"+id+"Error").text("两次密码不一致！");
		showError($("#"+id+"Error"));
		return false;
	}
	return true;
};
/**
 * 校验邮箱
 */
function validateEmail(){
	var id='Email';
	var value=$("#"+id).val();
	 var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	 if (filter.test(value)){
		//是否注册校验
		 $.ajax({
		    url:"/goods/UserServlet",
			data:{
				method:"ajaxValidateEmail",//调用方法名
				email:value
			},
			type:'post',
			dataType:'json',
			async:false,//异步加载
			cache:false,
			success:function(result){
				if(!result){//校验失败
					$("#"+id+"Error").text("邮箱已被注册！");
					showError($("#"+id+"Error"));
					return false;
				}
			}
		});
		 return true;
	 }else {
		 $("#"+id+"Error").text("电子邮件格式不正确！");
			showError($("#"+id+"Error"));
			return false;
	} 
};
/**
 * 校验验证码
 */
function validateVerificationCode(){
	var id='VerificationCode';
	var value=$("#"+id).val();
	if(!value){
		$("#"+id+"Error").text("验证码不能为空！");
		showError($("#"+id+"Error"));
		return false;
	}
	if(value.length!=4){
		$("#"+id+"Error").text("错误的验证码！");
		showError($("#"+id+"Error"));
		return false;
	}
	//是否验证码正确
	 $.ajax({
		url:"/goods/UserServlet",//调用的servlet
		data:{
			method:"ajaxValidateVerifyCode",//调用方法名
			VerificationCode:value
		},
		type:'post',
		dataType:'json',
		async:false,//异步加载
		cache:false,
		success:function(result){
			if(!result){//校验失败
				$("#"+id+"Error").text("验证码错误！");
				showError($("#"+id+"Error"));
				return false;
			}else{
				$("#"+id+"Error").text("验证码正确！");
				$("#"+id+"Error").parent(".errorMsg").addClass("bg-success").
				showError($("#"+id+"Error"));
				return true;
			}
		}
	});
	
	return true;
};