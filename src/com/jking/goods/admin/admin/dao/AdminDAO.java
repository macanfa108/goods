package com.jking.goods.admin.admin.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.jking.goods.admin.admin.domain.Admin;

import cn.itcast.jdbc.TxQueryRunner;

public class AdminDAO {
	
	private QueryRunner qr = new  TxQueryRunner() ;
	
	/**
	 * 通过管理员账号和密码查找账号
	 * @param adminname
	 * @param adminpwd
	 * @return
	 * @throws SQLException
	 */
	public Admin find(String adminname ,String adminpwd) throws SQLException{
		
		String sql = "SELECT * FROM t_admin WHERE adminname= ? AND adminpwd = ?" ;
	
		return qr.query(sql, new BeanHandler<Admin>(Admin.class),adminname,adminpwd) ;

	}
}
