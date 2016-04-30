package com.jking.goods.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {

	public void destroy() {
	 

	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		 /*
		  * 获取session中的user
		  * 判断是否为null
		  * 	如果为null 保存错误消息 转发到msg.jsp
		  * 	如果不为null 放行
		  */
		HttpServletRequest req = (HttpServletRequest)arg0 ;
		Object user = req.getSession().getAttribute("sessionUser") ;
		if(user == null) {
			//显示图片
			req.setAttribute("code", "error") ;
			req.setAttribute("msg", "您还没有登录,无法访问本资源") ;
			req.getRequestDispatcher("/jsps/msg.jsp").forward(arg0, arg1) ;
		}else{
			arg2.doFilter(arg0, arg1) ;
		}
	}
	public void init(FilterConfig arg0) throws ServletException {
		 
	}

}
