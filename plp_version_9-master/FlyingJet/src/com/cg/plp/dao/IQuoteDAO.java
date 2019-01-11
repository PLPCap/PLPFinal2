package com.cg.plp.dao;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;

import com.cg.plp.bean.AccountCreationBean;
import com.cg.plp.bean.BusinessSegmentBean;
import com.cg.plp.bean.DetailedReportBean;
import com.cg.plp.bean.PolicyBean;
import com.cg.plp.bean.PolicyCreationBean;
import com.cg.plp.bean.PolicyQuestions;
import com.cg.plp.bean.ReportGeneration;
import com.cg.plp.bean.UserLoginBean;

public interface IQuoteDAO {

	public int checkValidLogin(UserLoginBean userLoginBean) throws SQLException, ClassNotFoundException, FileNotFoundException;
	public void profileCreation(UserLoginBean userLoginBean) throws ClassNotFoundException, FileNotFoundException, SQLException;
	public void accountCreation(AccountCreationBean accountCreationBean) throws ClassNotFoundException, FileNotFoundException, SQLException;
	public void policyCreation(PolicyCreationBean policyCreationBean);
	public List<PolicyQuestions> retrieveAll(String bus_seg) throws ClassNotFoundException, FileNotFoundException, SQLException;
	public List<PolicyBean> getMyPolicies(String userName) throws ClassNotFoundException, FileNotFoundException, SQLException;
	public List<PolicyBean> getMyCustomerPolicies(int agentId) throws ClassNotFoundException, FileNotFoundException, SQLException;
	public List<PolicyQuestions> getQuestions(String segment) throws ClassNotFoundException, FileNotFoundException, SQLException;
	public String setPremium(int premium, String userName) throws ClassNotFoundException, FileNotFoundException, SQLException ;
	public long processRequest(String id, long accountNumber) throws SQLException, ClassNotFoundException, FileNotFoundException;
	public List<ReportGeneration> generateReport(String userName) throws SQLException, ClassNotFoundException, FileNotFoundException;
	public DetailedReportBean getDetailedreport(long policyNumber) throws ClassNotFoundException, FileNotFoundException, SQLException;
	public void addDetailsOfUser(UserLoginBean userLoginBean) throws ClassNotFoundException, FileNotFoundException, SQLException;
	public List<BusinessSegmentBean> getBusSegDetails() throws SQLException, ClassNotFoundException, FileNotFoundException;
}
