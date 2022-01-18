package com.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;


/**
 * Database Utility class
 * @author Pavan
 *
 */
public class DataBaseUtility 
{ 
	Connection connection = null;
   
    /**
     * This method will create the connection to the database
     * @throws SQLException 
     */
	public void connectToDB() throws SQLException 
	{
		 Driver driver = new Driver();
		 DriverManager.registerDriver(driver);
		 connection = DriverManager.getConnection(EndPoints.DB_URL,"root","root");
	
	}
	
		
	/**
	 * This method will close the database connection 
	 */
	public void closeDB()
	{
		try 
		{
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method will return all the data from database
	 * @param query
	 * @return
	 */
	public ResultSet getAllData(String query)
	{
		ResultSet result = null;
		try 
		{
		    result = connection.createStatement().executeQuery(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	/**
	 * This method will get the data and verify
	 * @param query
	 * @param columnNumber
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public String getAndVerifyTheData(String query, int columnNumber, String expectedData) throws SQLException
	{
		  ResultSet result = connection.createStatement().executeQuery(query);
		  String actualData= null;
		  boolean flag = false;
		  try 
			{
			   while(result.next())
			   {
				   String dbData= result.getString(columnNumber);
				   if(dbData.equals(expectedData))
				   {
					   actualData= dbData;
					   flag=true;
					   break;
				   }
			   }
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		  
		  if(flag)
		  {
			  System.out.println("Data is present and verified");
			  return actualData;
		  }
		  else
		  {
			  System.out.println("Data is not present int database");
			  return actualData;
		  }
		  
	}
	
	
	
	
	
	
	
}
