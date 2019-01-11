package com.cg.plp.bean;

public class AccountCreationBean {

	private String insuredName;
	private String insuredStreet;
	private String insuredCity;
	private String insuredState;
	private int insuredZip;
	private String businessSegment;
	private String username;
	private double accountNo;
	private int premium;
	
	public String getInsuredName() {
		return insuredName;
	}
	public void setInsuredName(String insuredName) {
		this.insuredName = insuredName;
	}
	public String getInsuredStreet() {
		return insuredStreet;
	}
	public void setInsuredStreet(String insuredStreet) {
		this.insuredStreet = insuredStreet;
	}
	public String getInsuredCity() {
		return insuredCity;
	}
	public void setInsuredCity(String insuredCity) {
		this.insuredCity = insuredCity;
	}
	public String getInsuredState() {
		return insuredState;
	}
	public void setInsuredState(String insuredState) {
		this.insuredState = insuredState;
	}
	public int getInsuredZip() {
		return insuredZip;
	}
	public void setInsuredZip(int insuredZip) {
		this.insuredZip = insuredZip;
	}
	public String getBusinessSegment() {
		return businessSegment;
	}
	public void setBusinessSegment(String businessSegment) {
		this.businessSegment = businessSegment;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(double accountNo) {
		this.accountNo = accountNo;
	}
	public int getPremium() {
		return premium;
	}
	public void setPremium(int premium) {
		this.premium = premium;
	}
	
	@Override
	public String toString() {
		return "AccountCreationBean [insuredName=" + insuredName
				+ ", insuredStreet=" + insuredStreet + ", insuredCity="
				+ insuredCity + ", insuredState=" + insuredState
				+ ", insuredZip=" + insuredZip + ", businessSegment="
				+ businessSegment + ", username=" + username + ", accountNo="
				+ accountNo + ", premium=" + premium + "]";
	}
	
}
