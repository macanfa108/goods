package com.jking.goods.user.web.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;

import com.jking.goods.user.domain.User;
import com.jking.goods.user.service.UserService;
import com.jking.goods.user.service.exception.UserException;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;

/**
 * 用户模块WEB层
 * 
 * @author joker
 * 
 */
public class UserServlet extends BaseServlet {

	private UserService userService = new UserService();

	/**
	 * 注册功能
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String regist(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("regist");
		// 封装数据
		Map<String, String> userMap = new HashMap<String, String>();
		String loginname = req.getParameter("loginName");
		String loginpass = req.getParameter("loginpassword");
		String reloginpass = req.getParameter("reloginpassword");
		String email = req.getParameter("Email");
		String verifyCode = req.getParameter("VerificationCode");
		userMap.put("loginname", loginname);
		userMap.put("loginpass", loginpass);
		userMap.put("reloginpass", reloginpass);
		userMap.put("email", email);
		userMap.put("verifyCode", verifyCode);

		User formUser = CommonUtils.toBean(userMap, User.class);
		// 检验

		System.out.print(formUser);

		Map<String, String> errors = validateRegist(formUser, req.getSession());

		if (errors.size() > 0) {
			req.setAttribute("form", formUser);
			req.setAttribute("errors", errors);
			return "f:/jsps/user/regist.jsp";
		}

		userService.regist(formUser);

		req.setAttribute("code", "success");
		req.setAttribute("msg", "注册成功,马上到邮箱激活");
		return "f:/jsps/msg.jsp";

	}

	/**
	 * 注册校验
	 * 
	 * @param formUser
	 * @return
	 */
	private Map<String, String> validateRegist(User formUser,
			HttpSession session) {
		Map<String, String> errors = new HashedMap();
		String loginname = formUser.getLoginname();
		// 1.判断用户名
		if (loginname == null || loginname.trim().isEmpty()) {
			errors.put("loginname", "用户名不能为空");
		} else if (loginname.length() < 3 || loginname.length() > 20) {
			errors.put("loginname", "用户名长度必须在3到20之间");
		} else if (!userService.ajaxValidateLoginname(loginname)) {
			errors.put("loginname", "用户名已经存在");
		}
		// 2.登陆密码
		String loginpass = formUser.getLoginpass();
		// 1.判断用户名
		if (loginpass == null || loginpass.trim().isEmpty()) {
			errors.put("loginpass", "密码不能为空");
		} else if (loginname.length() < 3 || loginname.length() > 20) {
			errors.put("loginpass", "密码长度必须在3到20之间");
		}

		// 3.确认密码校验
		String reloginpass = formUser.getReloginpass();
		// 1.判断用户名
		if (reloginpass == null || reloginpass.trim().isEmpty()) {
			errors.put("reloginpass", "确认密码不能为空");
		} else if (!reloginpass.equals(loginpass)) {
			errors.put("reloginpass", "两次密码不同");
		}
		// 4.邮箱校验
		String email = formUser.getEmail();
		// 1.判断用户名
		if (email == null || email.trim().isEmpty()) {
			errors.put("email", "邮箱不能为空");
		} else if (!email
				.matches("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\\.[a-zA-Z0-9_-]{2,3}){1,2})$")) {
			errors.put("email", "邮箱格式不正确");
		} else if (!userService.ajaxValidateEmail(email)) {
			errors.put("email", "邮箱已经注册");
		}

		// 5.验证码 校验
		String verifyCode = formUser.getVerifyCode();

		String vcode = (String) session.getAttribute("vCode");

		// 1.判断用户名
		if (verifyCode == null || verifyCode.trim().isEmpty()) {
			errors.put("verifyCode", "验证码不能为空");
		} else if (!verifyCode.equalsIgnoreCase(vcode)) {
			errors.put("verifyCode", "验证码失败");
		}
		return errors;
	}

	/**
	 * 登陆校验
	 * 
	 * @param formUser
	 * @return
	 */
	private Map<String, String> validateLogin(User formUser, HttpSession session) {
		Map<String, String> login_errors = new HashedMap();
		String loginname = formUser.getLoginname();
		// 1.判断用户名
		if (loginname == null || loginname.trim().isEmpty()) {
			login_errors.put("loginname", "用户名不能为空");
		} else if (loginname.length() < 3 || loginname.length() > 20) {
			login_errors.put("loginname", "用户名长度必须在3到20之间");
		}
		// 2.登陆密码
		String loginpass = formUser.getLoginpass();
		// 1.判断用户名
		if (loginpass == null || loginpass.trim().isEmpty()) {
			login_errors.put("loginpass", "密码不能为空");
		} else if (loginname.length() < 3 || loginname.length() > 20) {
			login_errors.put("loginpass", "密码长度必须在3到20之间");
		}

		// 5.验证码 校验
		String verifyCode = formUser.getVerifyCode();

		String vcode = (String) session.getAttribute("vCode");

		if (verifyCode == null || verifyCode.trim().isEmpty()) {
			login_errors.put("verifyCode", "验证码不能为空");
		} else if (!verifyCode.equalsIgnoreCase(vcode)) {
			login_errors.put("verifyCode", "验证码失败");
		}
		return login_errors;
	}

	/**
	 * 用户名注册
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateLoginname(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		// 获取用户名
		String loginname = req.getParameter("loginname");
		boolean flag = userService.ajaxValidateLoginname(loginname);
		resp.getWriter().print(flag);
		return null;

	}

	/**
	 * 邮箱校验
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateEmail(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		boolean flag = userService.ajaxValidateEmail(email);
		resp.getWriter().print(flag);
		return null;

	}

	/**
	 * 校验验证码
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateVerifyCode(HttpServletRequest req,
			HttpServletResponse resp) throws ServletException, IOException {
		String verificationCode = req.getParameter("VerificationCode");
		String vcode = (String) req.getSession().getAttribute("vCode");
		boolean flag = verificationCode.equalsIgnoreCase(vcode);
		resp.getWriter().print(flag);
		// return "f:/jsps/msg.jsp";
		return null;
	}

	/**
	 * 发送邮箱
	 * 
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String activation(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("activation");
		String code = req.getParameter("activationCode");
		try {
			userService.activation(code);
			req.setAttribute("code", "success");
			req.setAttribute("msg", "恭喜激活成功");
		} catch (UserException e) {
			// 出错
			req.setAttribute("msg", e.getMessage());
			req.setAttribute("code", "error"); // 图标
			e.printStackTrace();
		}
		return "f:/jsps/msg.jsp";
	}

	public String login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		/*
		 * 1.封装表单数据 2.验证表单数据 3.使用service查询 得到user 4.查看是否存在 不存在 保存错误信息 用户名或者密码错误
		 * 保存用户信息 为了回显 转发到login.jsp 存在 查看状态 false 保存错误信息 未激活 保存用户信息 为了回显
		 * 转发到login.jsp 成功 保存user到session cookie 中文编码处理
		 */

		System.out.println("login");
		// 封装数据
		Map<String, String> userMap = new HashMap<String, String>();
		String loginname = req.getParameter("loginName");
		String loginpass = req.getParameter("loginpassword");
		String verifyCode = req.getParameter("VerificationCode");

		userMap.put("loginname", loginname);
		userMap.put("loginpass", loginpass);
		userMap.put("verifyCode", verifyCode);

		// 封装数据
		User formUser = CommonUtils.toBean(userMap, User.class);

		// 校验数据的合理性
		Map<String, String> loginerrors = validateLogin(formUser,
				req.getSession());
		System.out.println("loginerrors" + loginerrors.size());
		if (loginerrors.size() > 0) {
			req.setAttribute("user", formUser);
			req.setAttribute("loginerrors", loginerrors);
			return "f:/jsps/user/login.jsp";
		}

		User user = userService.login(formUser);
		// 判断
		if (user == null) {
			req.setAttribute("msg", "用户名或密码错误！");
			req.setAttribute("user", formUser);
			return "f:jsps/user/login.jsp";
		} else if (!user.isStatus()) {
			req.setAttribute("msg", "您还没有激活！");
			req.setAttribute("user", formUser);
			return "f:jsps/user/login.jsp";
		} else {
			req.getSession().setAttribute("sessionUser", user);

			String loginName = user.getLoginname();
			loginName = URLEncoder.encode(loginName, "utf-8");

			Cookie cookie = new Cookie("loginName", loginName);
			cookie.setMaxAge(1000 * 60 * 60 * 24 * 10);
			resp.addCookie(cookie);
			return "r:/index.jsp";
		}

	}
}
