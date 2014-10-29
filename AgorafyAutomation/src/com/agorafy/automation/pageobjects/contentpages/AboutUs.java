package com.agorafy.automation.pageobjects.contentpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



//import org.openqa.selenium.WebElement;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class AboutUs extends Page
{
    private WebElement element = null;
    public AboutUs(WebDriver driver)
    {
        super(driver);
    }

    public String aboutUsPageUrl()
    {
        return applicationUrl() + "/about/";
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("About Us Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("About Us Page Heading Not found");
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