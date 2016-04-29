package com.jking.goods.user.domin;

/**
 * 用户模块实体类
 * @author joker
 *
 */
public class User {
	//数据表的字段
	//主键
	private String uid ; 
	//登录名
	private String loginname ;
	//登陆密码
	private String loginpass ;
	//邮箱 
	private String email ;
	//状态   true表示激活  或者未激活
	private boolean status ;
	//激活码 唯一值
	private String activationCode ;
	
	
	//验证表单的字段
	//确认密码
	private String reloginpass ;
	//验证码
	private String verifyCode ;
	
	//修改密码表单
	//新密码
	
	private String newloginpass ;
	public String getReloginpass() {
		return reloginpass;
	}
	public void setReloginpass(String reloginpass) {
		this.reloginpass = reloginpass;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getNewloginpass() {
		return newloginpass;
	}
	public void setNewloginpass(String newloginpass) {
		this.newloginpass = newloginpass;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpass() {
		return loginpass;
	}
	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", loginname=" + loginname + ", loginpass="
				+ loginpass + ", email=" + email + ", status=" + status
				+ ", activationCode=" + activationCode + ", reloginpass="
				+ reloginpass + ", verifyCode=" + verifyCode
				+ ", newloginpass=" + newloginpass + "]";
	}
}
