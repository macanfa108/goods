package com.jking.goods.cart.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jking.goods.book.domain.Book;
import com.jking.goods.cart.domain.CartItem;
import com.jking.goods.cart.service.CartItemService;
import com.jking.goods.user.domain.User;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

public class CartItemServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;

	private CartItemService cartItemService = new CartItemService();
	/**
	 * 找到购物车
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String myCart(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取当前用户
		User user = (User) req.getSession().getAttribute("sessionUser");
		// uid
		String uid = user.getUid();
		// 获取购物车的条目
		List<CartItem> cartItemList = cartItemService.myCart(uid);

		req.setAttribute("cartItemList", cartItemList);

		return "f:/jsps/cart/list.jsp";
	}
	/**
	 * 添加购物车条目 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			//bid  quantity 封装表单数据  
			Map map = req.getParameterMap() ;
		    CartItem cartItem = CommonUtils.toBean(map, CartItem.class) ;  
		    //注意 要前台传回的属性名字是否和CartItem的属性名字一致（即和set与get方法）
		    Book book = CommonUtils.toBean(map, Book.class) ;
		  
		    User user =  (User) req.getSession().getAttribute("sessionUser") ;
		  
		    cartItem.setBook(book) ;
		    
		    cartItem.setUser(user) ;
		    
		    cartItemService.add(cartItem) ;
  		    
		    //查询当前用户的所有条目 转发到list.jsp
		    return myCart(req,resp) ;
		   
	}
	
}
