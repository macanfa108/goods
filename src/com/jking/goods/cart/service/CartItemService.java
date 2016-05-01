package com.jking.goods.cart.service;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.commons.CommonUtils;

import com.jking.goods.cart.dao.CartItemDAO;
import com.jking.goods.cart.domain.CartItem;

public class CartItemService {
	
	private CartItemDAO cartItemDAO = new CartItemDAO() ;
	/**
	 * 我的购物车
	 * @param uid  用户uid
	 * @return
	 */
	public List<CartItem> myCart(String uid){
		try {
			return cartItemDAO.findByUser(uid) ;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}
	/**
	 * 增加到数据库 
	 * @param cartItem 传入的参数
	 */
	public void add(CartItem cartItem){
		try {
			//1.判断是否存在 _cartItem 表示从数据库中取出 
			CartItem _cartItem = cartItemDAO.findByUidAndBid(cartItem.getUser().getUid(), cartItem.getBook().getBid()) ;
			if(_cartItem == null){
				//设置主键
				cartItem.setCartItemId(CommonUtils.uuid()) ;
				
				cartItemDAO.addCartItem(cartItem) ;
			}else{   //如果有这个条目
				
				int quantity = cartItem.getQuantity() + _cartItem.getQuantity() ;
				
				_cartItem.setQuantity(quantity) ;
				
				cartItemDAO.update(_cartItem.getCartItemId(), quantity) ;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		 
	}
}
