package org.noobiez;
import java.io.*;
import java.util.*;

public class LoginProcessor {

	private static Scanner cin;
	private String userID;
	
	/**
	 * Constructor with login user ID.
	 * @param String the user's ID number.
	 */
	public LoginProcessor(String userInput)
	{
		userID = userInput;
	}
	
	/**
	 * Accesses user file to check user ID
	 * @return String with the user type
	 * @throws FileNotFoundException
	 */
	public String[] determineUserTypeAndName() throws FileNotFoundException
	{
		String temp = "";
		String[] userInfo = new String[2];
		File storedUsersFile = new File(System.getProperty("user.dir") + "\\users.dat");
		cin = new Scanner(storedUsersFile);
		
		while(cin.hasNextLine())
		{
			temp = cin.next();
			
			if (temp.equals(userID))
			{
				userInfo[0] = cin.next();
				userInfo[1] = cin.next();
			}
		}
		
		cin.close();
		
		return userInfo;
	}

}
