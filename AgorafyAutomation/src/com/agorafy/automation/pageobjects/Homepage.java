package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;


public class Homepage extends PageElement 
{
    private static WebElement element = null;

    public Homepage(WebDriver driver)
    {
        super(driver);
    }
    
    public static WebElement lnk_MyLogin() throws Exception
    {
        try
        { 
             element = driver.findElement(By.xpath(".//*[@id='mainNav']/li[3]/a/span"));
             AutomationLog.info("My login link found on the Home Page");
        }
        catch (Exception e)
        {
            AutomationLog.error("My login link was not found on the Home Page");
            throw(e);
        }

        return element;
    }
    
    public static LoginPage gotoLoginPage() throws Exception
    {
        LoginPage element = null;
        try
        { 
             lnk_MyLogin().click();
             element = new LoginPage(driver); 
             AutomationLog.info("Successfully navigated to login page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Not Able to navigate to login page");
            throw(e);
        }

        return element;
    }
}
