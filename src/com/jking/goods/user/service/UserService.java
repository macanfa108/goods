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
	 * @param activationCode 激活码 
	 *             
	 * @throws UserException
	 */
	public void activation(String activationCode) throws UserException {

		try {

			User user = userDAO.findUserByCode(activationCode);

			if (user == null) // 如果User为null 说明无效激活码 抛出异常信息

				throw new UserException("无效的用户名");

			if (user.isStatus()) // 查看用户状态 如果激活 给出异常 不需要激活

				throw new UserException("你已经激活 无需激活");

			userDAO.updateStatus(activationCode, true); // 修改用户激活状态

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}
	}

	/**
	 * 判断用户是否已经注册
	 * 
	 * @param loginname 用户名
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
	 * 校验邮箱是否注册过
	 * 
	 * @param email
	 *            邮箱账号
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
	 *            封装的表单数据
	 */
	public void regist(User user) {

		user.setUid(CommonUtils.uuid()); // 设置主键

		user.setStatus(false); // 设置激活状态

		user.setActivationCode(CommonUtils.uuid() + CommonUtils.uuid()); // 设置激活码

		try {
			userDAO.add(user); // 更新数据库

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

		Properties prop = new Properties(); // 数据准备

		try {
			prop.load(this.getClass().getClassLoader()
					.getResourceAsStream("email_template.properties"));

		} catch (IOException e1) {
			throw new RuntimeException(e1);
		}

		String host = prop.getProperty("host"); // 得到服务器主机名
		String username = prop.getProperty("username"); // 登录名
		String password = prop.getProperty("password"); // 登陆密码

		Session session = MailUtils.createSession(host, username, password); // 发邮箱的前置准备

		String from = prop.getProperty("from");

		String to = user.getEmail();

		String subject = prop.getProperty("subject");

		// MessageFormat.format 将第一个参数的{0} 使用第二个参数来替换
		String content = MessageFormat.format(prop.getProperty("content"),
				user.getActivationCode()); // 设置邮件的内容

		Mail mail = new Mail(from, to, subject, content); // 创建Mail对象

		try {
			MailUtils.send(session, mail); // 发送邮件

		} catch (MessagingException e) {

			throw new RuntimeException(e);

		} catch (IOException e) {

			throw new RuntimeException(e);
		}
	}

	/**
	 * 登录功能
	 * 
	 * @param user
	 * @return
	 */
	public User login(User user) {
		try {

			return userDAO.findByLoginnameAndPasswWord(user.getLoginname(),
					user.getLoginpass());

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

	/**
	 * 更新密码
	 * 
	 * @param loginname
	 * @param newPasss
	 * @param oldPass
	 * @throws UserException
	 */
	public void updatePassword(String loginname, String newPasss, String oldPass)
			throws UserException {

		try {

			boolean flag = userDAO.findByUidAndPassword(loginname, oldPass);

			if (!flag)

				throw new UserException("旧密码错误 ");

			    userDAO.updatePassword(loginname, newPasss);

		} catch (SQLException e) {

			throw new RuntimeException(e);
		}

	}

}
