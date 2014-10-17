package com.agorafy.automation.pageobjects.footer.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class Press extends Page
{
    private WebElement element = null;
    public Press(WebDriver driver)
    {
        super(driver);
    }

    public String pressPageUrl()
    {
        return applicationUrl() + "/press/";
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("Press Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Press Page Heading");
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