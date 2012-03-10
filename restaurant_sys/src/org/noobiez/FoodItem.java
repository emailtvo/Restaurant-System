package org.noobiez;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FoodItem 
{
	protected double itemPrice;
	protected String itemName;
	
	public FoodItem(String nameOfItem)
	{
		itemName = nameOfItem;
		
		try 
		{
			itemPrice = determineItemPrice(nameOfItem);
		}
		catch (FileNotFoundException e) 
		{
			itemPrice = 0;
		}
	}
	
	public double getPrice()
	{
		return itemPrice;
	}
	
	public String getName()
	{
		return itemName;
	}
	
	private double determineItemPrice(String nameOfItem) throws FileNotFoundException
	{
		//Open prices file
		File storedPricesFile = new File(System.getProperty("user.dir") + Messages.FoodItem_prices_file); //$NON-NLS-1$
		Scanner cin = new Scanner(storedPricesFile);
		String temp;
		String price = Messages.FoodItem_default_price_value;
		
		//Read file for name of FoodItem
		while(cin.hasNextLine())
		{
			temp = cin.next();
			
			if (temp.equals(nameOfItem))
			{
				price = cin.next();
				cin.close();
				return Double.valueOf(price);
			}
		}
		
		cin.close();
		return Double.valueOf(price);
	}
}
