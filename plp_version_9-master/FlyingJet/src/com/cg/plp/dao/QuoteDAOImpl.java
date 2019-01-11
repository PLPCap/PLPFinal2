package com.cg.plp.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import com.cg.plp.util.DBConnection;

public class QuoteDAOImpl implements IQuoteDAO {

	@Override
	public int checkValidLogin(UserLoginBean userLoginBean) throws SQLException, ClassNotFoundException, FileNotFoundException {
		
		{
			Connection connection=DBConnection.getConnection();
					int role=0;
					
					PreparedStatement preparedStatement=null;
					ResultSet resultset1 = null;
					
					
					    preparedStatement=connection.prepareStatement("select role_code from Login_credentials where user_name=? and password=?");
						preparedStatement.setString(1,userLoginBean.getLoginId());
						preparedStatement.setString(2, userLoginBean.getPassword());
						resultset1=preparedStatement.executeQuery();
						while(resultset1.next())
						{
							role=resultset1.getInt(1);
							
						}
			return role;				
		}
		//return 1;
	}

	@Override
	public void profileCreation(UserLoginBean userLoginBean) throws ClassNotFoundException, FileNotFoundException, SQLException{
		// TODO Auto-generated method stub
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		//ResultSet resultset2= null;
		
		preparedStatement=connection.prepareStatement("insert into login_credentials values(?,?,?)");
		
		preparedStatement.setString(1, userLoginBean.getLoginId());
		preparedStatement.setString(2, userLoginBean.getPassword());
		preparedStatement.setInt(3, userLoginBean.getRoleCode());
		
		preparedStatement.executeUpdate();
		
		
		
	}

	@Override
	public void accountCreation(AccountCreationBean accountCreationBean) throws ClassNotFoundException, FileNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		int account_number=0;
		
		preparedStatement=connection.prepareStatement("insert into accounts values(?,?,?,?,?,?,?,?,null)");
		
		preparedStatement.setDouble(1, accountCreationBean.getAccountNo());
		preparedStatement.setString(2, accountCreationBean.getInsuredName());
		preparedStatement.setString(3, accountCreationBean.getInsuredStreet());
		preparedStatement.setString(4, accountCreationBean.getInsuredCity());
		preparedStatement.setString(5, accountCreationBean.getInsuredState());
		preparedStatement.setInt(6, accountCreationBean.getInsuredZip());
		preparedStatement.setString(7, accountCreationBean.getBusinessSegment());
		preparedStatement.setString(8, accountCreationBean.getUsername());

//		if(resultSet.next())
//		{
//			account_number = resultSet.getInt(1);
//					
//		}
		
		
		preparedStatement.executeUpdate();
		
		preparedStatement=connection.prepareStatement("insert into policy values(policy_id_seq.nextval,?,?)");
		
		preparedStatement.setDouble(1, accountCreationBean.getPremium());
		preparedStatement.setDouble(2,accountCreationBean.getAccountNo());
		
		preparedStatement.executeUpdate();
	
	}

	@Override
	public void policyCreation(PolicyCreationBean policyCreationBean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PolicyQuestions> retrieveAll(String bus_seg) throws ClassNotFoundException, FileNotFoundException, SQLException {
		
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		preparedStatement=connection.prepareStatement("select * from policy_questions where bus_seg_id=?");
		preparedStatement.setString(1,bus_seg);
		resultSet=preparedStatement.executeQuery();
		List<PolicyQuestions> policyList = new ArrayList<PolicyQuestions>();
		while(resultSet.next())
		{
			PolicyQuestions policyQuestions=new PolicyQuestions();
			
			policyQuestions.setQuesId(resultSet.getInt(1));
			policyQuestions.setBusSegId(resultSet.getString(2));
			policyQuestions.setQuesDesc(resultSet.getString(3));
			policyQuestions.setAns1(resultSet.getString(4));
			policyQuestions.setPol_Ques_Ans1_weightage(resultSet.getInt(5));
			policyQuestions.setAns2(resultSet.getString(6));
			policyQuestions.setPol_Ques_Ans2_weightage(resultSet.getInt(7));
			policyQuestions.setAns3(resultSet.getString(8));
			policyQuestions.setPol_Ques_Ans3_weightage(resultSet.getInt(9));
			policyQuestions.setAns4(resultSet.getString(10));
			policyQuestions.setPol_Ques_Ans4_weightage(resultSet.getInt(11));
			
			//policyQuestions.setPol_Ques_Ans1_weightage(resultSet.getString(9));
			//policyQuestions.setPol_Ques_Ans2_weightage(resultSet.getString(10));
			//de System.out.println(policyQuestions);
			policyList.add(policyQuestions);
			
		}
		return policyList;
		
//		public List<DonorBean> retriveAllDetails() throws DonorException {
//			
//			Connection con=DBConnection.getInstance().getConnection();
//			int donorCount = 0;
//			
//			PreparedStatement ps=null;
//			ResultSet resultset = null;
//			
//			List<DonorBean> donorList=new ArrayList<DonorBean>();
//			try
//			{
//				ps=con.prepareStatement(QueryMapper.RETRIVE_ALL_QUERY);
//				resultset=ps.executeQuery();
//				
//				while(resultset.next())
//				{	
//					DonorBean bean=new DonorBean();
//					bean.setDonorName(resultset.getString(1));
//					bean.setAddress(resultset.getString(2));
//					bean.setPhoneNumber(resultset.getString(3));
//					bean.setDonationDate(resultset.getDate(4));
//					bean.setDonationAmount(resultset.getDouble(5));
//					donorList.add(bean);a
//					
//					donorCount++;
//				}			
//				
//	}


		
		
	}

	@Override
	public List<PolicyBean> getMyPolicies(String userName)
			throws ClassNotFoundException, FileNotFoundException, SQLException {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		try{
			preparedStatement = connection.prepareStatement("select a.policy_number,a.policy_premium,a.account_number from policy a,accounts b where a.account_number = b.account_number and b.user_name = ?");
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			List<PolicyBean> li = new ArrayList<>();
			while(resultSet.next()){
				PolicyBean policyBean = new PolicyBean();
				policyBean.setPolicyNumber(resultSet.getLong(1));
				policyBean.setPolicyPremium(resultSet.getInt(2));
				policyBean.setAccountNumber(resultSet.getLong(3));
				li.add(policyBean);
			}
			
			return li;
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<PolicyBean> getMyCustomerPolicies(int agentId)
			throws ClassNotFoundException, FileNotFoundException, SQLException {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		try{
			preparedStatement = connection.prepareStatement("select a.policynumber,a.policypremium,a.accountnumber from policy a,accounts b where a.accountnumber = b.accountnumber and b.agentid = ?");
			preparedStatement.setInt(1, agentId);
			resultSet = preparedStatement.executeQuery();
			List<PolicyBean> li = new ArrayList<PolicyBean>();
			while(resultSet.next()){
				PolicyBean policyBean = new PolicyBean();
				policyBean.setPolicyNumber(resultSet.getLong(1));
				policyBean.setPolicyPremium(resultSet.getInt(2));
				policyBean.setAccountNumber(resultSet.getLong(3));
				li.add(policyBean);
			}
			return li;
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public List<PolicyQuestions> getQuestions(String segment) throws ClassNotFoundException, FileNotFoundException, SQLException {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		
		preparedStatement = connection.prepareStatement("select a.pol_ques_id,a.bus_seg_id,a.pol_ques_desc,a.pol_ques_ans1,a.pol_ques_ans1_weightage,a.pol_ques_ans2,a.pol_ques_ans2_weightage,a.pol_ques_ans3,a.pol_ques_ans3_weightage,a.pol_ques_ans4,a.pol_ques_ans4_weightage from policy_questions a,business_segment b where b.bus_seg_name=? and a.bus_seg_id=b.bus_seg_id");
		preparedStatement.setString(1, segment);
		resultSet = preparedStatement.executeQuery();
		List<PolicyQuestions> policyQuestionsList = new ArrayList<PolicyQuestions>();
		while(resultSet.next()){
			PolicyQuestions policyQuestions = new PolicyQuestions();
			policyQuestions.setQuesId(resultSet.getInt(1));
			policyQuestions.setBusSegId(resultSet.getString(2));
			policyQuestions.setQuesDesc(resultSet.getString(3));
			policyQuestions.setAns1(resultSet.getString(4));
			policyQuestions.setPol_Ques_Ans1_weightage(resultSet.getInt(5));
			policyQuestions.setAns2(resultSet.getString(6));
			policyQuestions.setPol_Ques_Ans2_weightage(resultSet.getInt(7));
			policyQuestions.setAns3(resultSet.getString(8));
			policyQuestions.setPol_Ques_Ans3_weightage(resultSet.getInt(9));
			policyQuestions.setAns4(resultSet.getString(10));
			policyQuestions.setPol_Ques_Ans4_weightage(resultSet.getInt(11));
			policyQuestionsList.add(policyQuestions);
		}
		
		return policyQuestionsList;
	}

	@Override
	public String setPremium(int premium,String userName) throws ClassNotFoundException, FileNotFoundException, SQLException  {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		PreparedStatement preparedStatement1=null;
		ResultSet resultSet = null;
		long account_number = 0;
		try{
			preparedStatement = connection.prepareStatement("select account_number from accounts where user_name=?");
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
			account_number = resultSet.getLong(1);
			System.out.println(account_number);
			preparedStatement1 = connection.prepareStatement("insert into policy values(0,?,?)");
			preparedStatement1.setInt(1, premium);
			preparedStatement1.setLong(2, account_number);
			preparedStatement1.executeUpdate();
			}
			return "success";
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		return null;
	}

	@Override
	public long processRequest(String id, long accountNumber) throws SQLException, ClassNotFoundException, FileNotFoundException {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		PreparedStatement preparedStatement1=null;
		PreparedStatement preparedStatement2=null;
		ResultSet resultSet = null;
		long policyNumber=0;
		
		preparedStatement = connection.prepareStatement("update accounts set agent_name=? where account_number=?");
		preparedStatement.setString(1, id);
		preparedStatement.setLong(2, accountNumber);
		preparedStatement.executeUpdate();
		
		preparedStatement1 = connection.prepareStatement("update policy set policy_number=policy_id_seq.nextval where account_number=?");
		preparedStatement1.setLong(1, accountNumber);
		preparedStatement1.executeUpdate();
		
	//	preparedStatement2 = connection.prepareStatement("select policy_id_seq.currval from dual");
	//	resultSet = preparedStatement2.executeQuery();
	//	while(resultSet.next()){
	//		policyNumber = resultSet.getLong(1);
	//	}
		return 1;
	}

	@Override
	public List<ReportGeneration> generateReport(String userName) throws SQLException, ClassNotFoundException, FileNotFoundException {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		int serialNo = 1;
		preparedStatement = connection.prepareStatement("select a.account_number,b.policy_premium,b.policy_number from accounts a,policy b where a.insured_name=? and a.account_number=b.account_number");
		preparedStatement.setString(1, userName);
		resultSet = preparedStatement.executeQuery();
		List<ReportGeneration> reportGenerationList = new ArrayList<ReportGeneration>();
		while(resultSet.next()){
			ReportGeneration reportGeneration = new ReportGeneration();
			reportGeneration.setSerialNo(serialNo);
			reportGeneration.setAccountNumber(resultSet.getLong(1));
			reportGeneration.setPolicyPremium(resultSet.getDouble(2));
			reportGeneration.setPolicyNumber(resultSet.getLong(3));
			serialNo++;
			reportGenerationList.add(reportGeneration);
		}
		return reportGenerationList;
	}

	@Override
	public DetailedReportBean getDetailedreport(long policyNumber) throws ClassNotFoundException, FileNotFoundException, SQLException {
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		PreparedStatement preparedStatement1=null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		
		preparedStatement = connection.prepareStatement("select a.insured_name,a.insured_street,a.insured_city,a.insured_state,a.insured_zip,a.business_segment,b.policy_premium from accounts a,policy b where b.policy_number=? and a.account_number=b.account_number");
		preparedStatement.setLong(1, policyNumber);
		resultSet = preparedStatement.executeQuery();
		
		preparedStatement1 = connection.prepareStatement("select a.pol_ques_desc from policy_questions a,policy b,policy_details c where b.policy_number = ? and c.question_id = a.pol_ques_id and b.policy_number=c.policy_details");
		resultSet1 = preparedStatement1.executeQuery();
		
		DetailedReportBean detailedReportBean = new DetailedReportBean();
		while(resultSet.next()){
			detailedReportBean.setInsuredName(resultSet.getString(1));
			detailedReportBean.setInsuredStreet(resultSet.getString(2));
			detailedReportBean.setInsuredCity(resultSet.getString(3));
			detailedReportBean.setInsuredState(resultSet.getString(4));
			detailedReportBean.setInsuredZip(resultSet.getInt(5));
			detailedReportBean.setBusinessSegment(resultSet.getString(6));
			detailedReportBean.setPremiumAmount(resultSet.getDouble(7));
		}
		while(resultSet1.next()){
			detailedReportBean.setQuesDesc1(resultSet1.getString(1));
			//detailedReportBean.setQuesDesc2(resultSet1.getString(2));
		}
		return detailedReportBean;
	}

	@Override
	public void addDetailsOfUser(UserLoginBean userLoginBean) throws ClassNotFoundException, FileNotFoundException, SQLException 
	{
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		preparedStatement=connection.prepareStatement("insert into Login_credentials values(?,?,1)");
		preparedStatement.setString(1,userLoginBean.getLoginId());
		preparedStatement.setString(2,userLoginBean.getPassword());
		preparedStatement.executeUpdate();
	}

	@Override
	public List<BusinessSegmentBean> getBusSegDetails() throws SQLException, ClassNotFoundException, FileNotFoundException 
	{
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		preparedStatement=connection.prepareStatement("select * from business_segment");
		resultSet=preparedStatement.executeQuery();
		List<BusinessSegmentBean> businessList=new ArrayList<>();
		while(resultSet.next())
		{
			BusinessSegmentBean businessSegmentBean=new BusinessSegmentBean();
			businessSegmentBean.setBusSegId(resultSet.getString(1));
			businessSegmentBean.setBusSegName(resultSet.getString(2));
			businessList.add(businessSegmentBean);
		}
		
		return businessList;
	}
	}
	

