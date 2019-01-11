package com.cg.plp.bean;

public class PolicyBean {
	private long policyNumber;
	private long accountNumber;
	private int policyPremium;
	public long getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getPolicyPremium() {
		return policyPremium;
	}
	public void setPolicyPremium(int policyPremium) {
		this.policyPremium = policyPremium;
	}
	@Override
	public String toString() {
		return "PolicyBean [policyNumber=" + policyNumber + ", accountNumber="
				+ accountNumber + ", policyPremium=" + policyPremium + "]";
	}
	
	

}
