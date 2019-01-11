package com.cg.plp.service;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.plp.bean.AccountCreationBean;
import com.cg.plp.bean.BusinessSegmentBean;
import com.cg.plp.bean.DetailedReportBean;
import com.cg.plp.bean.PolicyBean;
import com.cg.plp.bean.PolicyCreationBean;
import com.cg.plp.bean.PolicyQuestions;
import com.cg.plp.bean.ReportGeneration;
import com.cg.plp.bean.UserLoginBean;
import com.cg.plp.dao.IQuoteDAO;
import com.cg.plp.dao.QuoteDAOImpl;

public class QuoteServiceImpl implements IQuoteService {

	IQuoteDAO iQuoteDAO=new QuoteDAOImpl();
	
	@Override
	public int checkValidLogin(UserLoginBean userLoginBean) throws ClassNotFoundException, FileNotFoundException, SQLException {
		
		
		
		//System.out.println("id"+userLoginBean.getLoginId());
		
		return iQuoteDAO.checkValidLogin(userLoginBean);
	}

	@Override
	public void profileCreation(UserLoginBean userLoginBean) throws ClassNotFoundException, FileNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		//System.out.println(userLoginBean.getPassword()+" "+userLoginBean.getLoginId());
		
		iQuoteDAO.profileCreation(userLoginBean);
		
		
	}

	@Override
	public void accountCreation(AccountCreationBean accountCreationBean) throws ClassNotFoundException, FileNotFoundException, SQLException {
		// TODO Auto-generated method stub
		iQuoteDAO.accountCreation(accountCreationBean);
	}

	@Override
	public void policyCreation(PolicyCreationBean policyCreationBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PolicyQuestions> retrieveAll(String bus_seg) throws ClassNotFoundException, FileNotFoundException, SQLException {
	
		//List<PolicyQuestions> policyList=null;
		List<PolicyQuestions> policy= new ArrayList<PolicyQuestions>();
				policy=iQuoteDAO.retrieveAll(bus_seg);
		
		return policy;
		
		
//		public List<DonorBean> retriveAll() throws DonorException {
//			donorDao=new DonorDaoImpl();
//			List<DonorBean> donorList=null;
//			donorList=donorDao.retriveAllDetails();
//			return donorList;
	}

	@Override
	public List<PolicyBean> getMyPolicies(String userName)
			throws ClassNotFoundException, FileNotFoundException, SQLException {
		iQuoteDAO = new QuoteDAOImpl();
		List<PolicyBean> li = new ArrayList<>();
		li = iQuoteDAO.getMyPolicies(userName);
		return li;
	}

	@Override
	public List<PolicyBean> getMyCustomerPolicies(int agentId)
			throws ClassNotFoundException, FileNotFoundException, SQLException {
		iQuoteDAO = new QuoteDAOImpl();
		List<PolicyBean> li = new ArrayList<PolicyBean>();
		li = iQuoteDAO.getMyCustomerPolicies(agentId);
		return li;
	}

	@Override
	public List<PolicyQuestions> getQuestions(String segment) throws ClassNotFoundException, FileNotFoundException, SQLException {
		iQuoteDAO = new QuoteDAOImpl();
		List<PolicyQuestions> policyQuestionsList = new ArrayList<PolicyQuestions>();
		policyQuestionsList = iQuoteDAO.getQuestions(segment);
		return policyQuestionsList;
	}

	@Override
	public String setPremium(int premium,String userName) throws ClassNotFoundException, FileNotFoundException, SQLException{
		iQuoteDAO = new QuoteDAOImpl();
		String installment = iQuoteDAO.setPremium(premium,userName);
		return installment;
	}

	@Override
	public long processRequest(String id, long accountNumber) throws SQLException, ClassNotFoundException, FileNotFoundException {
		iQuoteDAO = new QuoteDAOImpl();
		long policyNumber = iQuoteDAO.processRequest(id,accountNumber);
		return policyNumber;
	}

	@Override
	public List<ReportGeneration> generateReport(String userName) throws ClassNotFoundException, FileNotFoundException, SQLException {
		iQuoteDAO = new QuoteDAOImpl();
		List<ReportGeneration> reportGenerationList = new ArrayList<ReportGeneration>();
		reportGenerationList = iQuoteDAO.generateReport(userName);
		return reportGenerationList;
	}

	@Override
	public DetailedReportBean getDetailedReport(long policyNumber) throws ClassNotFoundException, FileNotFoundException, SQLException {
		iQuoteDAO = new QuoteDAOImpl();
		DetailedReportBean detailedReportBean = new DetailedReportBean();
		detailedReportBean = iQuoteDAO.getDetailedreport(policyNumber);
		return detailedReportBean;
	}

	@Override
	public void addDetailsOfUser(UserLoginBean userLoginBean) throws ClassNotFoundException, FileNotFoundException, SQLException {
		iQuoteDAO=new QuoteDAOImpl();
		iQuoteDAO.addDetailsOfUser(userLoginBean);
	}

	@Override
	public List<BusinessSegmentBean> getBusSegdetails() throws ClassNotFoundException, FileNotFoundException, SQLException {
		iQuoteDAO=new QuoteDAOImpl();
		List<BusinessSegmentBean> busSegList=new ArrayList<>();
		busSegList=iQuoteDAO.getBusSegDetails();
		return busSegList;
	}

	
	
}
