package com.agorafy.automation.pageobjects.footer.legal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class TermsAndConditions extends Page
{
    private WebElement element = null;
    public TermsAndConditions(WebDriver driver)
    {
        super(driver);
    }

    public String termsAndConditionsPageUrl()
    {
        return applicationUrl() + "/terms/";
    }

    public WebElement pageHeading() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div[1]/h2"));
            AutomationLog.info("About Us Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find About Us Page Heading");
            throw(e);
        }
        return element;
    }

    public String headingText() throws Exception
    {
        return getTextfromElement(pageHeading());
    }
}