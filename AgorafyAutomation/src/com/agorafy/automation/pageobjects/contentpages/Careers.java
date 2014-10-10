package com.agorafy.automation.pageobjects.contentpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class Careers extends Page
{
    private WebElement element = null;
    public Careers(WebDriver driver)
    {
        super(driver);
    }

    public String careersPageUrl()
    {
        return applicationUrl() + "/careers/";
    }

    public WebElement pageHeading() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("Careers Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Careers Page Heading");
            throw(e);
        }
        return element;
    }

    public String headingText() throws Exception
    {
        return getTextfromElement(pageHeading());
    }
}