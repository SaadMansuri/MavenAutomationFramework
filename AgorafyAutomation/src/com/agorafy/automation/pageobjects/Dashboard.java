package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class Dashboard extends PageElement {

	private static WebElement element = null;
	
	public Dashboard(WebDriver driver)
	{
		super(driver);
	}
	
	public static WebElement link_EditProfile() throws Exception
	{
		 try
	        { 
	             element = driver.findElement(By.linkText("Edit / View My Profile"));
	             AutomationLog.info("My Edit profile link found on the Home Page");
	        }
	        catch (Exception e)
	        {
	            AutomationLog.error("My Edit profile link was not found on the Home Page");
	            throw(e);
	        }

	        return element;
	 }
	
}
