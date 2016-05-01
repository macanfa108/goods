package com.jking.goods.admin.category.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jking.goods.category.domain.Category;
import com.jking.goods.category.service.CategoryService;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

public class AdminCategoryServlet extends BaseServlet {
 private CategoryService categoryService = new CategoryService() ;
	/**
	 * 查找所有的分类
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//调用函数 查找所有的图书
		    req.setAttribute("parent", categoryService.findAll()) ;
			return  "f:/adminjsps/admin/category/list.jsp";
	}
	/**
	 * 添加一级分类
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String addParent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//封装表单数据 
			Map map = req.getParameterMap() ;
			
			Category category = CommonUtils.toBean(map, Category.class) ;
			return  findAll(req, resp);
	}
	
}
