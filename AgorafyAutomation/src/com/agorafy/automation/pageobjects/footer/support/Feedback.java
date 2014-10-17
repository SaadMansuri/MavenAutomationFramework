package com.agorafy.automation.pageobjects.footer.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class Feedback extends Page
{
    private WebElement element = null;
    public Feedback(WebDriver driver)
    {
        super(driver);
    }

    public String feedbackPageUrl()
    {
        return applicationUrl() + "/feedback/";
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("Feedback Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Feedback Page Heading");
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