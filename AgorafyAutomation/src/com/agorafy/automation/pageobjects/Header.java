package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class Header extends PageElement {

	private static WebElement element = null;
	
	public Header(WebDriver driver)
	{
		super(driver);
	}
	
	public static WebElement link_ProfileName() throws Exception
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
	
	 
	 public static WebElement link_Dashboard() throws Exception
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
	 
}
