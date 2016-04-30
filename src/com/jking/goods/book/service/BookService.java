package com.jking.goods.book.service;

import java.sql.SQLException;

import com.jking.goods.book.domain.Book;
import com.jking.goods.book.dao.BookDAO;
import com.jking.goods.pager.PageBean;
 

public class BookService {
	private BookDAO bookDAO = new BookDAO() ;
	public PageBean<Book> findByCategory(String cid, int pc){
		try {
			return bookDAO.findByCategory(cid, pc) ;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}
	
	public PageBean<Book> findByBname(String bname, int pc){
		try {
			return bookDAO.findByBname(bname, pc) ;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}
	
	public PageBean<Book> findByAuthor(String author, int pc){
		try {
			return bookDAO.findByAuthor(author, pc) ;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}
	
	public PageBean<Book> findByCombination(Book book, int pc){
		try {
			return bookDAO.findByCombination(book, pc) ;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}
}
