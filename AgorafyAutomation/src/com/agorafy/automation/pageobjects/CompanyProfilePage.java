package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class CompanyProfilePage extends Page 
{

    private WebElement element;

	public CompanyProfilePage(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement agentsContainer() throws Exception
    {
        try
        {
            element =  driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/ul"));
            AutomationLog.info("Agents container found on company profile page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Failed to found agents container on company profile page");
            throw(e);
        }
        return element;
    }

    public WebElement listingsContainer() throws Exception
    {
        try
        {
            element =  driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div/div[1]/div[2]/ul"));
            AutomationLog.info("Listings container found on company profile page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Failed to found listings container on company profile page");
            throw(e);
        }
        return element;
    }

    public WebElement compnayName() throws Exception
    {
        try
        {
            element =  driver.findElement(By.className("page-banner-section")).findElement(By.className("col-sm-8")).findElement(By.className("profile-content")).findElement(By.tagName("h2"));
            AutomationLog.info("compny name is found on copmany profile page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Failed to found compnay name on company profile page");
            throw(e);
        }
        return element;
    }
}
