package com.cg.plp.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	public static Connection getConnection() throws ClassNotFoundException, SQLException, FileNotFoundException
    {
  	//Class.forName("oracle.jdbc.driver.OracleDriver");
  	//Connection con= DriverManager.getConnection("jdbc:oracle:thin:@10.219.34.3:1521:orcl","trg710","training710");
  	
  	//Statement st= con.createStatement();
  	try
  	{
  	FileInputStream fs1= new FileInputStream("resources/MyProp.properties");
  	Properties p= new Properties();
  	p.load(fs1);
  	String a= p.getProperty("url");
  	
  	String b= p.getProperty("driver");
  	
  	String c= p.getProperty("username");
  	
  	String d= p.getProperty("password");
  	
  	Class.forName(b);
  	
  	Connection connection= DriverManager.getConnection(a,c,d);
  	
  	return connection;
  	
  	}
  	catch(Exception e1)
  	{
  		System.out.println(e1);
  	}
		return getConnection();
    }
}

