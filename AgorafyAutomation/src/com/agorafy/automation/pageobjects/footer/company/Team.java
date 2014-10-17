package com.agorafy.automation.pageobjects.footer.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class Team extends Page
{
    private WebElement element = null;
    public Team(WebDriver driver)
    {
        super(driver);
    }

    public String teamPageUrl()
    {
        return applicationUrl() + "/team/";
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("Team page Heading found on the page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Team page Heading");
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