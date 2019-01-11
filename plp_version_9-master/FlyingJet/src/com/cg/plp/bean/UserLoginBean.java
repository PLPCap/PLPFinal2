package com.cg.plp.bean;

public class UserLoginBean {

	private String loginId;
	private String password;
	private int roleCode;
	
	public int getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
