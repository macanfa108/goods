package com.jking.goods.admin.admin.service;

import java.sql.SQLException;

import com.jking.goods.admin.admin.dao.AdminDAO;
import com.jking.goods.admin.admin.domain.Admin;

public class AdminService {
	private AdminDAO adminDAO = new AdminDAO() ;
	/**
	 * 登陆
	 * @param admin
	 * @return
	 */
	public Admin login(Admin admin){
		try {
			return adminDAO.find(admin.getAdminname(), admin.getAdminpwd()) ;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
	}
}
