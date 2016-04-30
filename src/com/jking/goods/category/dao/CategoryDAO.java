package com.jking.goods.category.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import com.jking.goods.category.domain.Category;
import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

public class CategoryDAO {
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 转化为javabean
	 * 
	 * @param mp
	 * @return
	 */
	private Category toCategory(Map<String, Object> mp) {
		Category category = CommonUtils.toBean(mp, Category.class);
		String pid = (String) mp.get("pid");
		if (pid != null) {
			Category cate = new Category();
			cate.setCid(pid);
			category.setParent(cate);
		}
		return category;
	}

	public List<Category> toCategoryList(List<Map<String, Object>> mp) {

		List<Category> categoryList = new ArrayList<Category>();

		for (Map<String, Object> map : mp) {

			Category c = toCategory(map);

			categoryList.add(c);

		}

		return categoryList;

	}

	/**
	 * 查询父分类
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Category> findAll() throws SQLException {

		String sql = "SELECT * FROM t_category WHERE pid is NULL ";

		List<Map<String, Object>> maList = qr.query(sql, new MapListHandler());

		List<Category> parents = toCategoryList(maList);

		for (Category parent : parents) {
			// 查询出当前分类的所有子分类
			List<Category> children = findByParent(parent.getCid());

			parent.setChildren(children);
		}

		return parents;
	}

	public List<Category> findByParent(String pid) throws SQLException {

		String sql = "SELECT * FROM t_category WHERE pid = ?";

		List<Map<String, Object>> mapList = qr.query(sql, new MapListHandler(),
				pid);

		return toCategoryList(mapList);
	}
}
