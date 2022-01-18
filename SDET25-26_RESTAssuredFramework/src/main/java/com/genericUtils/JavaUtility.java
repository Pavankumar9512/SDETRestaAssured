package com.genericUtils;

import java.util.Date;
import java.util.Random;

/**
 *   * This class contains all java specific generic libraries
	 * @author Pavankumar
	 *
	 */
	 public class JavaUtility {
	/**
    * It is used to generate integer RandomNumber within the boundary of 0 to 10000	
	 * @return intData
	 */
		
	public int getRandomNumber()
	{
		Random ran = new Random();
		int randomNum = ran.nextInt(10000);
		return randomNum;
				
	}
			
				
  /**
 * It is used to get the current System date and time
	  * @return string System Date
	  */
	public String getSystemDate()
	{
		Date date = new Date();
	//  String SystemDateAndTime = date.toString();
	    String SystemDateAndTime = date.toString().replace(":","_");
		return SystemDateAndTime;
				
	}
}
