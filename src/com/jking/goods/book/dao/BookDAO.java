package com.jking.goods.book.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jking.goods.book.domain.Book;
import com.jking.goods.pager.Expression;
import com.jking.goods.pager.PageBean;

import cn.itcast.jdbc.TxQueryRunner;

public class BookDAO {
	private QueryRunner qr = new  TxQueryRunner() ;
	/**
	 * 根据条件查询图书
	 * @param expression
	 * @param pc  当前页面数
	 * @return 
	 * @throws SQLException
	 */
	public PageBean<Book> findByCriteria(List<Expression> expression ,int pc) throws SQLException{
		
		
		int ps = 8 ;// pc每页显示的记录数
	
		StringBuilder sb = new StringBuilder("WHERE 1 = 1") ;
		
		List<Object> param = new ArrayList<Object>() ;
			
		System.out.println(param.toArray()) ;
			
		for(Expression expr : expression){
		
			sb.append("  and").append(" ").append(expr.getName())
			  .append("  ").append(expr.getOperator()).append("  ") ;
			//判断 is null 
			if(!expr.getOperator().equals("is null")){
				sb.append("?").append(" ");
				param.add(expr.getValue()) ;
			}
		}
		
		System.out.println(sb) ;
		
		String sql = "SELECT count(*) FROM t_book " + sb ;
		
	   Number number =(Number) qr.query(sql, new ScalarHandler(),param.toArray()) ;
		
	   int totalNumber = number.intValue() ;
	   //beanList 当前页的记录  
	   sql = "SELECT * FROM t_book " + sb + "ORDER BY orderby LIMIT ?,? " ; 
	  
	   param.add((pc-1) * ps) ;
	   
	   param.add(ps) ;
	   
	   List<Book> bookList = qr.query(sql, new BeanListHandler<Book>(Book.class),param.toArray()) ;
	   
	   /*
	    * 设置PageBean
	    */
	   PageBean<Book> pb = new PageBean<Book>() ;
	   
	   pb.setBeanList(bookList) ;
	   //每页显示的数目 
	   pb.setPc(pc) ;
	   //总数
	   pb.setTr(totalNumber) ;
	   pb.setPs(ps);
	   pb.setPc(pc) ;
	   
	   return pb ;
	}
	
	/**
	 * 按分类查询
	 * @param cid
	 * @param pc
	 * @return
	 * @throws SQLException 
	 */
	public PageBean<Book> findByCategory(String cid,int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>() ;
		exprList.add(new Expression("cid","=",cid)) ;
		return findByCriteria(exprList, pc) ;
	}
	
	public PageBean<Book> findByBname(String bname,int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>() ;
		exprList.add(new Expression("cname","like",bname)) ;
		return findByCriteria(exprList, pc) ;
	}
	/**
	 * 作者查询
	 * @param author
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByAuthor(String author,int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>() ;
		exprList.add(new Expression("author","like","%"+author+"%")) ;
		return findByCriteria(exprList, pc) ;
	}
	/**
	 * 组合查询条件
	 * @param book
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByCombination(Book book,int pc) throws SQLException{
		List<Expression> exprList = new ArrayList<Expression>() ;
		exprList.add(new Expression("author","like","%"+book.getAuthor()+"%")) ;
		exprList.add(new Expression("bname","like","%"+book.getBname()+"%")) ;
		exprList.add(new Expression("press","like","%"+book.getPress()+"%")) ;
		return findByCriteria(exprList, pc) ;
	}
	
}
