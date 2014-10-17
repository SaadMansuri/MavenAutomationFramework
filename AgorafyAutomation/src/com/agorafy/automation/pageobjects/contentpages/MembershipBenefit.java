package com.agorafy.automation.pageobjects.contentpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class MembershipBenefit extends Page
{
    private WebElement element  = null;
    public MembershipBenefit(WebDriver driver)
    {
        super(driver);
    }

    public String membershipBenefitPageUrl()
    {
        return applicationUrl() + "/benefits/";
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("Membership Benefit Page Heading found on the page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Membership benefit page Heading");
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