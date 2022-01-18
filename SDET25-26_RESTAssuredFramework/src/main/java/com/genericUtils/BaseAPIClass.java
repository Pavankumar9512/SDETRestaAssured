package com.genericUtils;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;
/**
 * BaseAPIclass is used to provide all the repeated actions
 * @author LENOVO
 *
 */
public class BaseAPIClass 
{
    public DataBaseUtility dbUtil = new DataBaseUtility();
    public JavaUtility jUtil = new JavaUtility();
    public JsonUtility jsonUtil = new JsonUtility();
    
	@BeforeSuite
	public void BS() throws SQLException
	{
		System.out.println("Database connection is started");
		dbUtil.connectToDB();
		System.out.println("Connected to datbase");
		baseURI = "http://localhost";
		port = 8084;
	}
	
	@AfterSuite
	public void AS()
	{
		
		dbUtil.closeDB();
		System.out.println("database is closed");
		
	}
}
