package com.jking.goods.admin.admin.domain;

public class Admin {
		private String adminId ;   //主键
		private String adminname ; //用户名
		private String adminpwd ;  //密码
		public String getAdminId() {
			return adminId;
		}
		public void setAdminId(String adminId) {
			this.adminId = adminId;
		}
		public String getAdminname() {
			return adminname;
		}
		public void setAdminname(String adminname) {
			this.adminname = adminname;
		}
		public String getAdminpwd() {
			return adminpwd;
		}
		public void setAdminpwd(String adminpwd) {
			this.adminpwd = adminpwd;
		}
		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", adminname=" + adminname
					+ ", adminpwd=" + adminpwd + "]";
		}
		
}
