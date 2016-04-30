package com.jking.goods.user.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;

import cn.itcast.commons.CommonUtils;
import cn.itcast.mail.Mail;
import cn.itcast.mail.MailUtils;

import com.jking.goods.user.dao.UserDAO;
import com.jking.goods.user.domain.User;
import com.jking.goods.user.service.exception.UserException;

/**
 * 用户模块业务层
 * 
 * @author joker
 * 
 */
public class UserService {

	private UserDAO userDAO = new UserDAO();

	/**
	 * 激活功能
	 * 
	 * @param code
	 * @throws UserException
	 */
	public void activation(String code) throws UserException {
		// 如果User为null 说明无效激活码 抛出异常信息
		try {
			User user = userDAO.findUserByCode(code);
			if (user == null)
				throw new UserException("无效的用户名");
			// 查看用户状态 如果激活 给出异常 不需要激活
			if (user.isStatus())
				throw new UserException("你已经激活 无需激活");
			// 修改用户状态
			userDAO.updateStatus(code, true);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 用户名注册
	 * 
	 * @param loginname
	 * @return
	 */
	public boolean ajaxValidateLoginname(String loginname) {
		try {
			return userDAO.ajaxValidateLoginname(loginname);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 校验邮箱
	 * 
	 * @param email
	 * @return
	 */
	public boolean ajaxValidateEmail(String email) {
		try {
			return userDAO.ajaxValidateEmail(email);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 注册功能
	 * 
	 * @param user
	 */
	public void regist(User user) {
		user.setUid(CommonUtils.uuid());
		user.setStatus(false);
		// 激活码
		user.setActivationCode(CommonUtils.uuid() + CommonUtils.uuid());
		// 更新数据库
		try {
			userDAO.add(user);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		/**
		 * 数据准备
		 */
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getClassLoader()
					.getResourceAsStream("email_template.properties"));
		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}

		String host = prop.getProperty("host"); // 得到服务器主机名
		String username = prop.getProperty("username"); // 登录名
		String password = prop.getProperty("password"); // 登陆密码

		Session session = MailUtils.createSession(host, username, password);

		String from = prop.getProperty("from");
		String to = user.getEmail();
		String subject = prop.getProperty("subject");
		// MessageFormat.format 将第一个参数的{0} 使用第二个参数来替换
		String content = MessageFormat.format(prop.getProperty("content"),
				user.getActivationCode());

		// 创建Mail对象
		Mail mail = new Mail(from, to, subject, content);
		// 发送邮件
		try {
			MailUtils.send(session, mail);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 登陆功能
	 */
	public User login(User user) {
		try {
			return userDAO.findByLoginnameAndPasswWord(user.getLoginname(),
					user.getLoginpass());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void updatePassword(String uid, String newPasss, String oldPass) throws UserException {
		
		try {
			boolean flag = userDAO.findByUidAndPassword(uid, newPasss) ;
			if(!flag) 
				throw new UserException("旧密码错误 ") ;
			
			 userDAO.updatePassword(uid, newPasss) ;
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
	}
	 
}
