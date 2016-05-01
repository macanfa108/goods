package com.jking.goods.cart.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.jking.goods.book.domain.Book;
import com.jking.goods.cart.domain.CartItem;
import com.jking.goods.user.domain.User;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

public class CartItemDAO {

	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 通过用户查询购物车条目
	 * 
	 * @param uid
	 * @return
	 * @throws SQLException
	 */
	public List<CartItem> findByUser(String uid) throws SQLException {

		String sql = "SELECT * FROM t_cartitem c , t_book b WHERE c.bid = b.bid AND uid = ?  order by c.orderBy";

		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(),uid);

		return toCartItemList(mapList);

	}

	/**
	 * 将Map转化为CartItem
	 * 
	 * @param map
	 * @return
	 */
	private CartItem toCartItem(Map<String, Object> map) {

		if (map == null || map.size() == 0) {
			return null;
		}
		CartItem cartItem = CommonUtils.toBean(map, CartItem.class);

		Book book = CommonUtils.toBean(map, Book.class);

		User user = CommonUtils.toBean(map, User.class);

		cartItem.setBook(book);

		cartItem.setUser(user);

		return cartItem;
	}

	/**
	 * 将多个Map映射为多个CartItem对象
	 */
	private List<CartItem> toCartItemList(List<Map<String, Object>> mapList) {

		List<CartItem> cartItemList = new ArrayList<CartItem>();
		for (Map<String, Object> map : mapList) {
			CartItem cartItem = toCartItem(map);
			cartItemList.add(cartItem);
		}
		return cartItemList;
	}
	/**
	 * 查询某个用户某本图书的购物车条目是否存在
	 * @param uid
	 * @param bid
	 * @return
	 * @throws SQLException 
	 */
	public CartItem findByUidAndBid(String uid,String bid) throws SQLException{
			
		String sql = "SELECT * FROM t_cartitem WHERE uid = ? AND bid = ?" ;

		Map<String,Object> map = qr.query(sql, new MapHandler()) ;
		
		CartItem cartItem = toCartItem(map) ;
		
		System.out.print("category "+cartItem) ;
		
		return cartItem ;
		
	}
	/**
	 *  修改指定条目的数量
	 * @param cartItemId
	 * @param quantity
	 * @throws SQLException 
	 */
	public void update(String cartItemId,int quantity) throws SQLException{
		
		String sql = "UPDATE t_category SET quantity = ? WHEEN cateItemId = ? " ;
		
		qr.update(sql,quantity,cartItemId)  ;
		
	}
	/**
	 * 插入数据库
	 * @param cartItem
	 * @throws SQLException
	 */
	public void addCartItem(CartItem cartItem) throws SQLException{
		
		String sql = "INSERT INTO t_cartItem(cartItemId,quantity,bid,uid)"+"value(?,?,?,?)" ;
		
		Object[] param = {cartItem.getCartItemId(),cartItem.getQuantity(),
								cartItem.getBook().getBid(),cartItem.getUser().getUid()} ;
		
		qr.update(sql,param) ;
	}
	   
}
