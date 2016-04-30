package com.jking.goods.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jking.goods.user.domain.User;
import com.sun.org.apache.xml.internal.utils.IntVector;

import cn.itcast.jdbc.TxQueryRunner;

/**
 * 用户模块持久化层
 * @author joker
 *
 */
public class UserDAO {
	private QueryRunner qr = new TxQueryRunner() ;
	 /**
	  * 校验用户是否注册
	  * @param loginname
	  * @return
	  * @throws SQLException
	  */
	public boolean ajaxValidateLoginname(String loginname) throws SQLException{
		//按用户名查询数据库 
		String sql = "SELECT COUNT(*) FROM t_user WHERE loginname = ?" ;
		Number number = (Number) qr.query(sql, new ScalarHandler(),loginname) ;
		return number.intValue() == 0  ;
	}
	 /**
	  * 通过激活码查找User
	  * @param code
	  * @return
	  * @throws SQLException
	  */
	public User findUserByCode(String code) throws SQLException{
		//按用户名查询数据库 
		String sql = "SELECT * FROM t_user WHERE activationCode = ?" ;
		return  qr.query(sql,new BeanHandler<User>(User.class),code) ;
	}
	 
	/**
	 * 判断邮箱是否注册 
	 * @param loginname
	 * @return
	 * @throws SQLException
	 */
	public boolean ajaxValidateEmail(String email) throws SQLException{
		//按用户名查询数据库 
		String sql = "SELECT COUNT(*) FROM t_user WHERE email = ?" ;
		Number number = (Number) qr.query(sql, new ScalarHandler(),email) ;
		return number.intValue() == 0  ;
	}
	public void add(User user) throws SQLException{
		String sql = "INSERT INTO t_user values(?,?,?,?,?,?)" ;
		Object [] params ={user.getUid(),user.getLoginname(),user.getLoginpass(),
							user.getEmail(),user.isStatus(),user.getActivationCode() } ;
		qr.update(sql,params) ;
	}
	 /**
	  * 修改用户状态
	  * @param uid
	  * @param flag
	 * @throws SQLException 
	  */
	public void updateStatus(String uid,boolean flag) throws SQLException{
		String sql = "UPDATE t_user set status = ? WHERE activationCode = ?  " ;
		qr.update(sql,flag,uid) ; 
	}
	/**
	 * 按照账号密码查询
	 * @param loginname
	 * @param password
	 * @return
	 * @throws SQLException 
	 */
	public User findByLoginnameAndPasswWord(String loginname,String loginpass) throws SQLException{
		String sql = "SELECT * FROM t_user WHERE loginname = ? AND loginpass = ?" ;
		return  qr.query(sql, new BeanHandler<User>(User.class),loginname,loginpass) ;
		   
	} 
	/**
	 * 通过密码账号查询
	 * @param uid
	 * @param password
	 * @return
	 * @throws SQLException 
	 */
	public boolean findByUidAndPassword(String uid ,String password) throws SQLException{
		String sql = "SELECT COUNT(*) FROM t_user WHERE uid = ? AND loginpass = ? " ;
		Number number = (Number)qr.query(sql, new ScalarHandler(),uid,password) ;
		return number.intValue() > 0 ; //大于0 表示有数据存在
	}
	
	public void updatePassword(String uid ,String password) throws SQLException{
		String sql = "UPDATE t_user SET loginpass = ? WHERE uid = ?" ;
		qr.update(sql,password,uid) ;
	}
}