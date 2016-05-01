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
	
	private static final long serialVersionUID = 1L;
	
	private BookService bookService = new BookService() ;
	
	/**
	  * 获取参数pc 第几页
	  * @param req
	  * @return
	  */
	private int getPc(HttpServletRequest req){
		
		int pc = 1 ;  //初始化 默认显示第一页
		
		String param = req.getParameter("pc") ;
		
		if(param!= null && !param.trim().isEmpty()){
			try{
				 pc = Integer.parseInt(param) ;    //转化 
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

		
		String url = req.getRequestURI() + "?" +  req.getQueryString();   //获得完整的url 
		
		int index = url.indexOf("&pc=") ; 
		
		if(index != -1 ){
		
			url = url.substring(0,index) ;
		}
		 
		return url ;
	}
	
	public String findByCategory(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int pc = getPc(req) ;    //获取显示的第几页
		
		String url = getUrl(req) ;
		
		String cid = req.getParameter("cid") ;
		
		PageBean<Book> pb = bookService.findByCategory(cid, pc) ;
		
		pb.setUrl(url) ;
		
		req.setAttribute("pb", pb) ;    //保存到request的书本信息
		
		return "f:/jsps/book/list.jsp" ;
 		 
	}
	/**
	 * 查询所有的图书
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findAllBooks(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int pc = getPc(req) ;    //获取显示的第几页
		
		String url = getUrl(req) ;
		
		PageBean<Book> pb = bookService.findAllBooks(pc) ;
		
		pb.setUrl(url) ;
		
		req.setAttribute("pb", pb) ;    //保存到request的书本信息
		
		return "f:/jsps/book/list.jsp" ;
 		 
	}
	/**
	 * 按照书名查找图书
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByBname(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int pc = getPc(req) ;    //获取显示的第几页
		
		String url = getUrl(req) ;
		
		String bookName = req.getParameter("bookName") ;
		
		PageBean<Book> pb = bookService.findByBname(bookName, pc) ;
		
		pb.setUrl(url) ;
		
		req.setAttribute("pb", pb) ;    //保存到request的书本信息
		
	 	return "f:/jsps/book/list.jsp" ;
		 
	}
	/**
	 * 按照作者查询图书
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByAuthor(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int pc = getPc(req) ;    //获取显示的第几页
		
		String url = getUrl(req) ;
		
		String author  = req.getParameter("author") ;
		
		PageBean<Book> pb = bookService.findByAuthor(author, pc) ;
		
		pb.setUrl(url) ;
		
		req.setAttribute("pb", pb) ;    //保存到request的书本信息
		
		return "f:/jsps/book/list.jsp" ;
 		 
	}
	/**
	 * 按照出版社查询图书 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String findByPress(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int pc = getPc(req) ;    //获取显示的第几页
		
		String url = getUrl(req) ;
		
		String press = req.getParameter("press") ;
		
		PageBean<Book> pb = bookService.findByPress(press, pc);
		
		pb.setUrl(url) ;
		
		req.setAttribute("pb", pb) ;    //保存到request的书本信息
		
		return "f:/jsps/book/list.jsp" ;
 		 
	}
	/**
	 * 查看图书的详细信息
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String load(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String bookID = req.getParameter("bid") ;
		
		Book book = bookService.load(bookID) ;
		
		req.setAttribute("book", book) ;
		
		return "f:/jsps/book/description.jsp" ;
 		 
	}
	
}
