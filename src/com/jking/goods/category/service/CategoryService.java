package com.jking.goods.category.service;

import java.sql.SQLException;
import java.util.List;
import com.jking.goods.category.dao.CategoryDAO;
import com.jking.goods.category.domain.Category;
 

public class CategoryService {
	
	private CategoryDAO categoryDAO = new CategoryDAO() ;
	/**
	 * 查询所有的分类
	 * @return
	 */
	public List<Category> findAll(){
		try {
			return categoryDAO.findAll() ;
		} catch (SQLException e) {
			 throw new RuntimeException(e) ;
		}
	}
	/**
	 * 添加类别
	 * @param category
	 */
	public void addCategory(Category category){
		try {
			categoryDAO.add(category) ;
		} catch (SQLException e) {
			 throw new RuntimeException(e) ;
		}
	}
}
