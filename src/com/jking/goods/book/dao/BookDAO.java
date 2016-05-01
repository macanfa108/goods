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

	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 根据条件查询图书
	 * 
	 * @param expression
	 * @param pc
	 *            当前页面数
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByCriteria(List<Expression> expression, int pc)
			throws SQLException {

		int ps = 8; // ps每页显示的记录数

		StringBuilder sb = new StringBuilder("WHERE 1 = 1");

		List<Object> param = new ArrayList<Object>();

		// System.out.println(param.toArray()) ;

		for (Expression expr : expression) {

			sb.append("  ").append("and").append("  ").append(expr.getName())
					.append("  ").append(expr.getOperator());

			// 判断 is null
			if (!expr.getOperator().equals("is null")) {

				sb.append("  ").append("?").append(" ");

				param.add(expr.getValue()); // 增加值

			}
		}

		System.out.println("查询条件 " + sb);

		String sql = "SELECT count(*) FROM t_book " + sb;

		Number number = (Number) qr.query(sql, new ScalarHandler(),
				param.toArray());

		int totalNumber = number.intValue(); // 记录数

		sql = "SELECT * FROM t_book " + sb + "ORDER BY orderby LIMIT ?,? ";

		param.add((pc - 1) * ps); // 第一页 0，5 第二页 6，5
									// ps每页显示的记录数 pc当前页数
		param.add(ps);

		List<Book> bookList = qr.query(sql, new BeanListHandler<Book>(
				Book.class), param.toArray());

		PageBean<Book> pb = new PageBean<Book>(); // 设置PageBean

		pb.setBeanList(bookList);

		pb.setPc(pc); // 第几页

		pb.setTr(totalNumber); // 总数

		pb.setPs(ps); // 每页显示的数目

		return pb;
	}

	/**
	 * 按分类查询
	 * 
	 * @param cid
	 *            父分类的id
	 * @param pc
	 *            第几页
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByCategory(String cid, int pc)
			throws SQLException {

		List<Expression> exprList = new ArrayList<Expression>();

		exprList.add(new Expression("cid", "=", cid));

		return findByCriteria(exprList, pc);

	}

	/**
	 * 根据书名查询图书
	 * 
	 * @param bname
	 *            书名
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByBname(String bname, int pc) throws SQLException {

		List<Expression> exprList = new ArrayList<Expression>();

		exprList.add(new Expression("cname", "like", bname));

		return findByCriteria(exprList, pc);
	}

	/**
	 * 作者查询
	 * 
	 * @param author
	 *            作者
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByAuthor(String author, int pc)
			throws SQLException {

		List<Expression> exprList = new ArrayList<Expression>();

		exprList.add(new Expression("author", "like", "%" + author + "%"));

		return findByCriteria(exprList, pc);

	}

	/**
	 * 组合查询条件
	 * 
	 * @param book
	 *            Book封装的信息
	 * @param pc
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findByCombination(Book book, int pc)
			throws SQLException {

		List<Expression> exprList = new ArrayList<Expression>();

		exprList.add(new Expression("author", "like", "%" + book.getAuthor()
				+ "%")); // 作者

		exprList.add(new Expression("bname", "like", "%" + book.getBname()
				+ "%")); // 书名

		exprList.add(new Expression("press", "like", "%" + book.getPress()
				+ "%")); // 出版社

		return findByCriteria(exprList, pc);
	}
	/**
	 * 查询所有的图书
	 * @param pc 显示第几页
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Book> findAllBooks( int pc)
			throws SQLException {
		
		List<Expression> exprList = new ArrayList<Expression>();

		exprList.add(new Expression("1", "=", "1"));

		return findByCriteria(exprList, pc);
	}
}
