package com.jking.goods.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.jking.goods.user.domain.User;

import cn.itcast.jdbc.TxQueryRunner;

/**
 * 用户模块持久化层
 * @author joker
 *
 */
public class UserDAO {
	
	private QueryRunner qr = new TxQueryRunner() ;
	
	/**
	  * 校验用户是否注册 按用户名查询数据库
	  * @param loginname
	  * @return
	  * @throws SQLException
	  */
	public boolean ajaxValidateLoginname(String loginname) throws SQLException{
		 
		String sql = "SELECT COUNT(*) FROM t_user WHERE loginname = ? " ;
		
		Number number = (Number) qr.query(sql, new ScalarHandler(),loginname) ;
		
		return number.intValue() == 0  ;
	}
	
	 /**
	  * 查找User是否注册  按激活码查询数据库
	  * @param activationCode   激活码					
	  * @return
	  * @throws SQLException
	  */
	public User findUserByCode(String activationCode) throws SQLException{
		  
		String sql = "SELECT * FROM t_user WHERE activationCode = ?" ;
		
		return  qr.query(sql,new BeanHandler<User>(User.class),activationCode) ;
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
	/**
	 * 增加用户 向数据库插入数据 
	 * @param user
	 * @throws SQLException
	 */
	public void add(User user) throws SQLException{
		
		String sql = "INSERT INTO t_user values(?,?,?,?,?,?)" ;
		
		Object [] params ={user.getUid(),user.getLoginname(),user.getLoginpass(),
				
							user.getEmail(),user.isStatus(),user.getActivationCode() } ;
		
		qr.update(sql,params) ;
	}
	
	 /**
	  * 修改激活用户状态
	  * @param activationCode   激活码
	  * @param flag		激活状态
	 * @throws SQLException 
	  */
	public void updateStatus(String activationCode,boolean flag) throws SQLException{
		
		String sql = "UPDATE t_user set status = ? WHERE activationCode = ?  " ;
		
		qr.update(sql,flag,activationCode) ; 
	}
	
	/**
	 * 按照账号名密码查询用户是否存在
	 * @param loginname
	 * @param password
	 * @return
	 * @throws SQLException 
	 */
	public User findByLoginnameAndPasswWord(String loginname,String loginpass) throws SQLException{
		
		String sql = "SELECT * FROM t_user WHERE loginname = ? AND loginpass = ? " ;
		
		return  qr.query(sql, new BeanHandler<User>(User.class),loginname,loginpass) ;
		   
	} 
	
	/**
	 * 通过账号和密码查询用户
	 * @param loginname
	 * @param loginpass
	 * @return
	 * @throws SQLException 
	 */
	public boolean findByUidAndPassword(String loginname ,String loginpass) throws SQLException{
		
		String sql = "SELECT COUNT(*) FROM t_user WHERE loginname = ? AND loginpass = ? " ;
		
		Number number = (Number)qr.query(sql, new ScalarHandler(),loginname,loginpass) ;
		
		return number.intValue() > 0 ;      //大于0 表示用户存在
	}
	/**
	 * 更新数据库密码
	 * @param loginname
	 * @param password
	 * @throws SQLException
	 */
	public void updatePassword(String loginname ,String password) throws SQLException{
		
		String sql = "UPDATE t_user SET loginpass = ? WHERE loginname = ?" ;
		
		qr.update(sql,password,loginname) ;
	}
	
}