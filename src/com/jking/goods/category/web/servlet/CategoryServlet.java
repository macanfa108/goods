package com.jking.goods.category.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jking.goods.category.domain.Category;
import com.jking.goods.category.service.CategoryService;

 

public class CategoryServlet extends cn.itcast.servlet.BaseServlet {
	 
	private static final long serialVersionUID = 1L;
	
	private CategoryService categoryService = new CategoryService() ;
	/**
	 * 显示列表 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		 List<Category> parent  = categoryService.findAll() ;
		
		 req.setAttribute("parent", parent) ;
		 
		 return "f:/jsps/left.jsp" ;
	}
}
