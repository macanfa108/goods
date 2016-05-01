package com.jking.goods.book.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jking.goods.book.domain.Book;
import com.jking.goods.book.service.BookService;
import com.jking.goods.pager.PageBean;

import cn.itcast.servlet.BaseServlet;

public class BookServlet extends BaseServlet {
	private BookService bookService = new BookService() ;
	 /**
	  * 获取参数pc 第几页
	  * @param req
	  * @return
	  */
	private int getPc(HttpServletRequest req){
		int pc = 1 ;
		String param = req.getParameter("pc") ;
		
		if(param!= null && !param.trim().isEmpty()){
			try{
				pc = Integer.parseInt(param) ;
			}catch(RuntimeException e){
				pc = 1 ;
			}
		}
		return pc ;
		
	}
	/**
	 *  截取url
	 * @param req
	 * @return
	 */
	private String getUrl(HttpServletRequest req){
		String url = req.getRequestURI() + "?" + req.getQueryString();  
		
		int index = url.indexOf("&pc=") ;
		if(index != -1 ){
			url = url.substring(0,index) ;
		}
		return url ;
	}
	
	public String findByCategory(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int pc = getPc(req) ;
		
		String url = getUrl(req) ;
		
		String cid = req.getParameter("cid") ;
		
		PageBean<Book> pb = bookService.findByCategory(cid, pc) ;
		
		pb.setUrl(url) ;
		
		req.setAttribute("pb", pb) ;
		
		return "f:/jsps/book/list.jsp" ;
 		 
	}
}
