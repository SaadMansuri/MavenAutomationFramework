package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class Dashboard extends Page {

	private WebElement element = null;
	
	public Dashboard(WebDriver driver)
	{
		super(driver);
	}
	
	public WebElement link_EditProfile() throws Exception
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
	
	public WebElement link_AccountSettings() throws Exception
	{
		 try
	        { 
	             element = driver.findElement(By.linkText("Account Settings"));
	             AutomationLog.info("My AccountSetting link found on the Dashboard");
	        }
	        catch (Exception e)
	        {
	            AutomationLog.error("My AccountSetting link not found on the Dashboard");
	            throw(e);
	        }

	        return element;
	 }
	
	
	public OverviewTab editProfile() throws Exception
	{
	    OverviewTab element = null;
	    try
        { 
	        link_EditProfile().click();
	        element = new OverviewTab(driver);
            AutomationLog.info("OverviewTab was opened successfully.");
        }
        catch (Exception e)
        {
            AutomationLog.error("Not able to navigate to overview tab");
            throw(e);
        }

        return element;
	}
	
	public AccountSettings accountSettings() throws Exception
	{
	    AccountSettings element = null;
	    try
        { 
	    	link_AccountSettings().click();
	        element = new AccountSettings(driver);
            AutomationLog.info("Succesfully Navigated to account Settings page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Not able to Navigate to account Settings page");
            throw(e);
        }

        return element;
	}
}
