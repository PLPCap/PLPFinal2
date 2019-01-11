package com.cg.plp.bean;

public class ViewPolicyBean {

	private String insuredName;
	private String insuredStreet;
	private String insuredCity;
	private String insuredState;
	private String insuredZip;
	private String businessSegment;
	private String question1;
	private String question2;
	private String question3;
	private String question4;
	private String Coverage1;
	private String Coverage2;
	private String Coverage3;
	private String Coverage4;
	private double proposedPremium;
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
	public String getInsuredZip() {
		return insuredZip;
	}
	public void setInsuredZip(String insuredZip) {
		this.insuredZip = insuredZip;
	}
	public String getBusinessSegment() {
		return businessSegment;
	}
	public void setBusinessSegment(String businessSegment) {
		this.businessSegment = businessSegment;
	}
	public String getQuestion1() {
		return question1;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public String getQuestion2() {
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public String getQuestion3() {
		return question3;
	}
	public void setQuestion3(String question3) {
		this.question3 = question3;
	}
	public String getQuestion4() {
		return question4;
	}
	public void setQuestion4(String question4) {
		this.question4 = question4;
	}
	public String getCoverage1() {
		return Coverage1;
	}
	public void setCoverage1(String coverage1) {
		Coverage1 = coverage1;
	}
	public String getCoverage2() {
		return Coverage2;
	}
	public void setCoverage2(String coverage2) {
		Coverage2 = coverage2;
	}
	public String getCoverage3() {
		return Coverage3;
	}
	public void setCoverage3(String coverage3) {
		Coverage3 = coverage3;
	}
	public String getCoverage4() {
		return Coverage4;
	}
	public void setCoverage4(String coverage4) {
		Coverage4 = coverage4;
	}
	public double getProposedPremium() {
		return proposedPremium;
	}
	public void setProposedPremium(double proposedPremium) {
		this.proposedPremium = proposedPremium;
	}
	@Override
	public String toString() {
		return "ViewPolicyBean [insuredName=" + insuredName + ", insuredStreet=" + insuredStreet + ", insuredCity="
				+ insuredCity + ", insuredState=" + insuredState + ", insuredZip=" + insuredZip + ", businessSegment="
				+ businessSegment + ", question1=" + question1 + ", question2=" + question2 + ", question3=" + question3
				+ ", question4=" + question4 + ", Coverage1=" + Coverage1 + ", Coverage2=" + Coverage2 + ", Coverage3="
				+ Coverage3 + ", Coverage4=" + Coverage4 + ", proposedPremium=" + proposedPremium + "]";
	}
	
	
	
}
