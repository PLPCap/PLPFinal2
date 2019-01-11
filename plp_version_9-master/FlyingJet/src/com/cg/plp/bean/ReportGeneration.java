package com.cg.plp.bean;

public class ReportGeneration {

	private int serialNo;
	private long accountNumber;
	private long policyNumber;
	private double policyPremium;
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public long getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}
	public double getPolicyPremium() {
		return policyPremium;
	}
	public void setPolicyPremium(double policyPremium) {
		this.policyPremium = policyPremium;
	}
	@Override
	public String toString() {
		return "ReportGeneration [serialNo=" + serialNo + ", accountNumber="
				+ accountNumber + ", policyNumber=" + policyNumber
				+ ", policyPremium=" + policyPremium + "]";
	}
	
	
}
