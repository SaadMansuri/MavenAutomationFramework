package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class Header extends Page {

	private WebElement element = null;
	
	public Header(WebDriver driver)
	{
		super(driver);
	}
	
	public WebElement link_ProfileName() throws Exception
	{
		 try
	        { 
	             element = driver.findElement(By.xpath(".//*[@id='mainNav']/li[3]/a[1]/span[2]"));
	             AutomationLog.info("My profile link found on the Home Page");
	        }
	        catch (Exception e)
	        {
	            AutomationLog.error("My profile link was not found on the Home Page");
	            throw(e);
	        }

	        return element;
	 }
	
	 
	 public WebElement link_Dashboard() throws Exception
	 {
		 try
	        { 
	             element = driver.findElement(By.xpath(".//*[@id='mainNav']/li[3]/ul/li[1]/a"));
	             AutomationLog.info("My Dashboard link found on the Home Page");
	        }
	        catch (Exception e)
	        {
	            AutomationLog.error("My Dashboard link was not found on the Home Page");
	            throw(e);
	        }

	        return element;
	 }
	 
	 public void openActiveProfile() throws Exception
	 {
	     try
         { 
	         link_ProfileName().click();
             AutomationLog.info("Opened drop down for active profile link");
         }
         catch (Exception e)
         {
             AutomationLog.error("Not able to open drop down for active profile link");
             throw(e);
         }

	 }
	 
	 public Dashboard openDashboard() throws Exception
     {
	     Dashboard element = null;
         try
         { 
             link_Dashboard().click();
             element = new Dashboard(driver);
             AutomationLog.info("Opened Dashboard successfully");
         }
         catch (Exception e)
         {
             AutomationLog.error("Not able to open Dashboard");
             throw(e);
         }
         return element;
     }
}
