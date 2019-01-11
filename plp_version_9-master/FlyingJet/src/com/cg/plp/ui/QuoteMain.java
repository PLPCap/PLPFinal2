package com.cg.plp.ui;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.cg.plp.bean.AccountCreationBean;
import com.cg.plp.bean.BusinessSegmentBean;
import com.cg.plp.bean.DetailedReportBean;
import com.cg.plp.bean.NewPolicyCreationBean;
import com.cg.plp.bean.PolicyBean;
import com.cg.plp.bean.PolicyCreationBean;
import com.cg.plp.bean.PolicyQuestions;
import com.cg.plp.bean.ReportGeneration;
//import com.cg.plp.bean.UserCreationBean;
import com.cg.plp.bean.UserLoginBean;
import com.cg.plp.service.IQuoteService;
import com.cg.plp.service.QuoteServiceImpl;

public class QuoteMain {

	static Scanner sc=new Scanner(System.in);
	static UserLoginBean userLoginBean=null;
	static AccountCreationBean accountCreationBean=null;
	static PolicyCreationBean policyCreationBean=null;
	static PolicyQuestions policyQuestions=null;
	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException
	
	{
		while(true) 
		
		{	
		System.out.println("*******************Welcome To Online Insurance Quote Generation****************");
		System.out.println("Login Id:");
		String id=sc.next();
		System.out.println("Password:");
		String pass=sc.next();
		//System.out.print("1.user\t 2.Agent\t 3.Admin");
		userLoginBean=new UserLoginBean();
		userLoginBean.setLoginId(id);
		userLoginBean.setPassword(pass);
		
		IQuoteService iQuoteService=new QuoteServiceImpl();
		
		int role_code=iQuoteService.checkValidLogin(userLoginBean);
		System.out.println("your role code is:"+role_code);
		
		if(role_code!=1 && role_code!=2 && role_code!=3)// || role_code!=2 || role_code!=3) 
		{
		
		System.out.println("Details Not found!!!!!");
		System.out.println("Do You Want To Create a new Profile\n1.Yes \n2.No");
		int option0=sc.nextInt();
		switch(option0)
		{
		
				case 1:
					System.out.println("Enter the following details:-> ");
					System.out.println("Login Id:");
					String id0 = sc.next();
					System.out.println("Password:");
					String pass0 = sc.next();
					int role0 = 1;
					userLoginBean.setLoginId(id0);
					userLoginBean.setPassword(pass0);
					userLoginBean.setRoleCode(role0);
					iQuoteService.profileCreation(userLoginBean);
					
					break;

				case 2:
					System.exit(0);
					break;
		}
		
		
}
		if( role_code==1) {
			System.out.println("Welcome User!!!");
			System.out.println("1.Account creation");
			System.out.println("2.View Policy");
			
			
			System.out.println("Enter your option: ");
			int option1=sc.nextInt();
			switch(option1) {
			
			case 1:
			
			System.out.println("Enter the following details:-> ");
			System.out.println("Insured Name: ");
			String name=sc.next();
			AccountCreationBean accountCreationBean=new AccountCreationBean();
			accountCreationBean.setInsuredName(name);
			//accountCreationBean.setInsuredName(sc.next());
			System.out.println("Insured Street: ");
			accountCreationBean.setInsuredStreet(sc.next());
			System.out.println("Insured City: ");
			accountCreationBean.setInsuredCity(sc.next());
			System.out.println("Insured State: ");
			accountCreationBean.setInsuredState(sc.next());
			System.out.println("Insured Zip: ");
			accountCreationBean.setInsuredZip(sc.nextInt());
			
			System.out.println("Business Segment: ");
			System.out.println("Please enter from the following options in String format:\n1.Vehicle\n2.Restaurant\n3.Apartment");
			String segment=sc.next();
			
			List<PolicyQuestions> policyQuestionsList = new ArrayList<PolicyQuestions>();
			policyQuestionsList = iQuoteService.getQuestions(segment);
			Iterator<PolicyQuestions> policyQuestionsIterator = policyQuestionsList.iterator();
			//String installment = null;
			int premium = 0;
	//		System.out.println(policyQuestionsList);
			if(segment == "Vehicle"){
				accountCreationBean.setPremium(2000);
				
			}
			else if(segment == "Restaurant"){
				accountCreationBean.setPremium(5000); 
			}
			else if(segment == "Apartment"){
				accountCreationBean.setPremium(7000);
			}
			while(policyQuestionsIterator.hasNext()){
				PolicyQuestions policyQuestions = new PolicyQuestions();
				policyQuestions = policyQuestionsIterator.next();
				System.out.println(policyQuestions.getQuesDesc());
				System.out.println("select from 1."+policyQuestions.getAns1()+" \n 2."+policyQuestions.getAns2()+" \n 3."+policyQuestions.getAns3()+" \n 4. "+policyQuestions.getAns4());
				//System.out.println("enter options 1 / 2 / 3 / 4");
				int ans = sc.nextInt();
				
				
				switch(ans){
					case 1:
						premium = accountCreationBean.getPremium();
						premium = premium + policyQuestions.getPol_Ques_Ans1_weightage();
						accountCreationBean.setPremium(premium);
			//			installment = iQuoteService.setPremium(premium,userName);
			//			System.out.println(installment);
						break;
					case 2:
						premium = premium + policyQuestions.getPol_Ques_Ans2_weightage();
			//			installment = iQuoteService.setPremium(premium, userName);
					//	System.out.println(installment);
						break;
					case 3:
						premium = premium + policyQuestions.getPol_Ques_Ans3_weightage();
			//			installment = iQuoteService.setPremium(premium,userName);
				//		System.out.println(installment);
						break;
					case 4:
						premium = premium + policyQuestions.getPol_Ques_Ans4_weightage();
			//			installment = iQuoteService.setPremium(premium,userName);
					//	System.out.println(installment);
						break;
					default:
						System.out.println("enter valid option..");
						break;
				}
				accountCreationBean.setPremium(premium);
			}
	//		System.out.println(" enter user name of customer");
	//		String customerName = sc.next();
			System.out.println(accountCreationBean.getPremium());
			
	//		System.out.println(installment);
			accountCreationBean.setAccountNo((double)(Math.random()*100000000));
			accountCreationBean.setUsername(id);
			iQuoteService.accountCreation(accountCreationBean);
			//installment = iQuoteService.setPremium(accountCreationBean.getPremium(),id);
			//System.out.println(installment);
			break;
			
			case 2:
				List<PolicyBean> li = new ArrayList<>();
				String userName = null;
				System.out.println(" enter username to get policies");
				userName = sc.next();
				iQuoteService = new QuoteServiceImpl();
				li = iQuoteService.getMyPolicies(userName);
				
				System.out.println(li);
				
				break;
				
			}
			
		}
		
		if(role_code==2) {
			System.out.println("Agent Priviledges Granted!!!");
			System.out.println("1.Account creation");
			System.out.println("2.Policy creation");
			System.out.println("3.View Policy");
			
			System.out.println("Enter your option: ");
			int option2=sc.nextInt();
			switch(option2) {
			
			case 1:
				iQuoteService=new QuoteServiceImpl();
				System.out.println("Login Id:");
				String id1=sc.next();
				System.out.println("Password:");
				String pass1=sc.next();
				
				userLoginBean.setLoginId(id1);
				userLoginBean.setPassword(pass1);
				iQuoteService.addDetailsOfUser(userLoginBean);
				break;
			case 2:
				
				iQuoteService=new QuoteServiceImpl();
				List<PolicyQuestions> policyList = new ArrayList<PolicyQuestions>();
				//policyList=iQuoteService.retrieveAll();
			
				//if (policyList != null) {
					Iterator<PolicyQuestions> i = policyList.iterator();
					while (i.hasNext())
					{
						PolicyQuestions policyQuestions=new PolicyQuestions();
						policyQuestions = i.next();
						System.out.println(policyQuestions.getQuesDesc());
				
				
			
				break;
					}
			case 3:
				System.out.println("View my customers policies");
				iQuoteService = new QuoteServiceImpl();
				List<PolicyBean> li = new ArrayList<PolicyBean>();
				System.out.println("enter your agent id");
				int agentId = sc.nextInt();
				li = iQuoteService.getMyCustomerPolicies(agentId);
				
				break;
		}
		}
		if(role_code==3)
		{
			System.out.println("Admin Priviledges Granted!!!");
			System.out.println("1.New Profile creation");
			System.out.println("2.Account creation");
			System.out.println("3.Policy creation");
			System.out.println("4.View Policy");
			System.out.println("5.Report generation");
			System.out.println("0.Exit");
			
			System.out.println("Enter your option: ");
			int option3=sc.nextInt();
			
			
			
			switch(option3)
			{
				case 1:
					System.out.println("Enter the following details:-> ");
					System.out.println("Login Id:");
					String id1=sc.next();
					System.out.println("Password:");
					String pass1=sc.next();
					System.out.println("Role Code:");
					int role1=sc.nextInt();
					userLoginBean.setLoginId(id1);
					userLoginBean.setPassword(pass1);
					userLoginBean.setRoleCode(role1);
					iQuoteService.profileCreation(userLoginBean);
					break;
			
				case 2:
					System.out.println("Enter the following details:-> ");
					System.out.println("Insured Name: ");
					String name=sc.next();
					AccountCreationBean accountCreationBean=new AccountCreationBean();
					accountCreationBean.setInsuredName(name);
					//accountCreationBean.setInsuredName(sc.next());
					System.out.println("Insured Street: ");
					accountCreationBean.setInsuredStreet(sc.next());
					System.out.println("Insured City: ");
					accountCreationBean.setInsuredCity(sc.next());
					System.out.println("Insured State: ");
					accountCreationBean.setInsuredState(sc.next());
					System.out.println("Insured Zip: ");
					accountCreationBean.setInsuredZip(sc.nextInt());
					
					System.out.println("Business Segment: ");
					System.out.println("Please enter from the following options:\n1.Vehicle\n2.Shop\n3.Apartment");
					int segment=sc.nextInt();
					
					
					switch(segment)
					{
					case 1:
						String segment1="Vehicle";
						accountCreationBean.setBusinessSegment(segment1);
						break;
					case 2:
						String segment2="Shop";
						accountCreationBean.setBusinessSegment(segment2);
						break;
					case 3:

						String segment3="Apartment";
						accountCreationBean.setBusinessSegment(segment3);
						break;
					}
					
					
					
					//accountCreationBean.setBusinessSegment(sc.next());a
					
					System.out.println("Account Number: ");
					accountCreationBean.setAccountNo((double)(Math.random()*100000000));
					
					iQuoteService.accountCreation(accountCreationBean);
					
					break;
				case 3:
					policyCreationBean=new PolicyCreationBean();
					
					iQuoteService=new QuoteServiceImpl();
					List<PolicyQuestions> policyList = new ArrayList<PolicyQuestions>();
					List<BusinessSegmentBean> busSegList=new ArrayList<>();
					busSegList=iQuoteService.getBusSegdetails();
					Iterator<BusinessSegmentBean> busItr=busSegList.iterator();
					while(busItr.hasNext())
					{
						BusinessSegmentBean businessSegmentBean=new BusinessSegmentBean();
						businessSegmentBean=busItr.next();
						System.out.println("Business_Segment_ID\t\t Business_Segment_Name");
						System.out.println(businessSegmentBean.getBusSegId()+"\t\t"+businessSegmentBean.getBusSegName());
					}
					System.out.println("Choose Any One Option From The Above Options :");
					String bus_seg_id=sc.next();
					policyList=iQuoteService.retrieveAll(bus_seg_id);
					int premium=5000;
					//if (policyList != null) {
						Iterator<PolicyQuestions> i = policyList.iterator();
						while (i.hasNext())
						{
							PolicyQuestions policyQuestions=new PolicyQuestions();
							policyQuestions = i.next();
							System.out.println(policyQuestions.getQuesDesc());
						
							System.out.println("Options available are:\n1."+policyQuestions.getAns1()+"\n2."+policyQuestions.getAns2()+"\n3."+policyQuestions.getAns3()+"\n4."+policyQuestions.getAns4());
							System.out.println("Choose Any one Option\n------------------------------------------------- ");
							int answer=0;
							answer = sc.nextInt();
							
							switch(answer) {
							case 1:
								premium += policyQuestions.getPol_Ques_Ans1_weightage();
								System.out.println("Premium of  "+policyQuestions.getQuesDesc()+" is "+premium);
								iQuoteService = new QuoteServiceImpl();
								String prem = policyCreationBean.setPolicyPremium(premium);
								break;
							case 2:
								
								premium += policyQuestions.getPol_Ques_Ans2_weightage();
								System.out.println("Premium of  "+policyQuestions.getQuesDesc()+" is "+premium);
								break;
							case 3:
								premium += policyQuestions.getPol_Ques_Ans3_weightage();
								System.out.println("Premium of  "+policyQuestions.getQuesDesc()+" is "+premium);
								break;
							case 4:
								premium += policyQuestions.getPol_Ques_Ans4_weightage();
								System.out.println("Premium of  "+policyQuestions.getQuesDesc()+" is "+premium);
								break;
								
								}
					
						}
						break;
				
				case 4:
					
					List<PolicyBean> adminList = new ArrayList<>();
					
					String userName1 = null;
					System.out.println(" enter username to get policies");
					userName1 = sc.next();
					iQuoteService = new QuoteServiceImpl();
					adminList = iQuoteService.getMyPolicies(userName1);
					Iterator<PolicyBean> adminItr = adminList.iterator();
					while(adminItr.hasNext())
					{
						PolicyBean policyBean=new PolicyBean();
						policyBean=adminItr.next();
						System.out.println(policyBean);
					}
					
					break;
				case 5:
					iQuoteService = new QuoteServiceImpl();
					System.out.println("Enter Username ");
					String userName = sc.next();
					List<ReportGeneration> li = new ArrayList<>();
					li =  iQuoteService.generateReport(userName);
					Iterator<ReportGeneration> itr = li.iterator();
					while(itr.hasNext()) {
						System.out.println(itr.next());
					}
					
					System.out.println("        ");
					System.out.println(" 1. get detailed policy view ");
					System.out.println(" 2. exit  ");
					System.out.println("             ");
					System.out.println("select option ");
			/*//		int view=0;
			//		switch(view) {
					case 1:
						DetailedReportBean detailedReportBean = new DetailedReportBean();
						System.out.println(" enter policy number to get detailed report ");
						long policyNumber = sc.nextLong();
						detailedReportBean = iQuoteService.getDetailedReport(policyNumber);
						System.out.println(detailedReportBean);
						break;
					case 2:
						System.exit(0);
					default:
						System.out.println("invalid option ");
						break;
					}*/
					break;
						
						
						
						
				case 0:
					System.exit(0);
					break;
			
			
			
			}
			
			
			
		}	
			
			
			
		}
		
		
	}
}