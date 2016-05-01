 
package com.jking.goods.admin.admin.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jking.goods.admin.admin.domain.Admin;
import com.jking.goods.admin.admin.service.AdminService;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
 
public class AdminServlet extends BaseServlet {
	private AdminService adminService = new AdminService() ;
	 /**
	  * 登录功能
	  * @param req
	  * @param resp
	  * @return
	  * @throws ServletException
	  * @throws IOException
	  */
	public String login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 //1.封装表单数据 注意修改 看前台数据
		Admin form = CommonUtils.toBean(req.getParameterMap(), Admin.class) ;
		Admin admin = adminService.login(form) ;
		if(admin == null){ 
			req.setAttribute("msg","用户名或密码错误") ;
			return "adminjsps/login.jsp" ;
		}
		 //2.验证管理员通关
		req.setAttribute("admin", admin) ;
		 return "r:/adminjsps/admin/index.jsp" ;
	}
}	
