package com.cg.plp.bean;

public class PolicyQuestions {


private int quesId;
private String busSegId;
private String quesDesc;
private String ans1;
private String ans2;
private String ans3;
private String ans4;
private int Pol_Ques_Ans1_weightage;
private int Pol_Ques_Ans2_weightage;
private int Pol_Ques_Ans3_weightage;
private int Pol_Ques_Ans4_weightage;
public int getQuesId() {
	return quesId;
}
public void setQuesId(int quesId) {
	this.quesId = quesId;
}
public String getBusSegId() {
	return busSegId;
}
public void setBusSegId(String busSegId) {
	this.busSegId = busSegId;
}
public String getQuesDesc() {
	return quesDesc;
}
public void setQuesDesc(String quesDesc) {
	this.quesDesc = quesDesc;
}
public String getAns1() {
	return ans1;
}
public void setAns1(String ans1) {
	this.ans1 = ans1;
}
public String getAns2() {
	return ans2;
}
public void setAns2(String ans2) {
	this.ans2 = ans2;
}
public String getAns3() {
	return ans3;
}
public void setAns3(String ans3) {
	this.ans3 = ans3;
}
public String getAns4() {
	return ans4;
}
public void setAns4(String ans4) {
	this.ans4 = ans4;
}
public int getPol_Ques_Ans1_weightage() {
	return Pol_Ques_Ans1_weightage;
}
public void setPol_Ques_Ans1_weightage(int pol_Ques_Ans1_weightage) {
	Pol_Ques_Ans1_weightage = pol_Ques_Ans1_weightage;
}
public int getPol_Ques_Ans2_weightage() {
	return Pol_Ques_Ans2_weightage;
}
public void setPol_Ques_Ans2_weightage(int pol_Ques_Ans2_weightage) {
	Pol_Ques_Ans2_weightage = pol_Ques_Ans2_weightage;
}
public int getPol_Ques_Ans3_weightage() {
	return Pol_Ques_Ans3_weightage;
}
public void setPol_Ques_Ans3_weightage(int pol_Ques_Ans3_weightage) {
	Pol_Ques_Ans3_weightage = pol_Ques_Ans3_weightage;
}
public int getPol_Ques_Ans4_weightage() {
	return Pol_Ques_Ans4_weightage;
}
public void setPol_Ques_Ans4_weightage(int pol_Ques_Ans4_weightage) {
	Pol_Ques_Ans4_weightage = pol_Ques_Ans4_weightage;
}
@Override
public String toString() {
	return "PolicyQuestions [quesId=" + quesId + ", busSegId=" + busSegId
			+ ", quesDesc=" + quesDesc + ", ans1=" + ans1 + ", ans2=" + ans2
			+ ", ans3=" + ans3 + ", ans4=" + ans4
			+ ", Pol_Ques_Ans1_weightage=" + Pol_Ques_Ans1_weightage
			+ ", Pol_Ques_Ans2_weightage=" + Pol_Ques_Ans2_weightage
			+ ", Pol_Ques_Ans3_weightage=" + Pol_Ques_Ans3_weightage
			+ ", Pol_Ques_Ans4_weightage=" + Pol_Ques_Ans4_weightage + "]";
}



	
}
