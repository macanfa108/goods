package com.jking.goods.user.web.servlet;


import com.jking.goods.user.service.UserService;

import cn.itcast.servlet.BaseServlet;

/**
 * 用户模块WEB层
 * @author joker
 *
 */
public class UserServlet extends BaseServlet {
	
	private UserService userService = new UserService() ;
}
