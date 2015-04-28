package com.agorafy.automation.pageobjects.footer.legal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class PrivacyPolicy extends Page
{
    private WebElement element = null;
    public PrivacyPolicy(WebDriver driver)
    {
        super(driver);
    }

    public String getApplicationUrl()
    {
        return applicationUrl();
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div[1]/h2"));
            AutomationLog.info("Privacy Policy Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Privacy Policy Page Heading Not found");
            throw(e);
        }
        return element;
    }

    @Override
    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }
}