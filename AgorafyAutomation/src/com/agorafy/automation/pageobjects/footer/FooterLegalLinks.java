package com.agorafy.automation.pageobjects.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.legal.PrivacyPolicy;
import com.agorafy.automation.pageobjects.footer.legal.TermsAndConditions;

public class FooterLegalLinks extends Page
{
    private WebElement element = null;
    public FooterLegalLinks(WebDriver driver)
    {
        super(driver);
    }

    public WebElement link_TermsAndConditions() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[1]/div/div[3]/ul/li[1]/a"));
            AutomationLog.info("Terms And Conditions link found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Terms And Conditions link not found on the Footer");
            throw(e);
        }
        return element;
    }

    public TermsAndConditions openTermsAndConditions() throws Exception
    {
        TermsAndConditions termsAndConditions = null;
        try
        {
            link_TermsAndConditions().click();
            termsAndConditions = new TermsAndConditions(driver);
            AutomationLog.info("Terms And Conditions link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Terms And Conditions link is not clicked");
            throw(e);
        }
        return termsAndConditions;
    }

    public WebElement link_PrivacyPolicy() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[1]/div/div[3]/ul/li[2]/a"));
            AutomationLog.info("Privacy Policy link found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Privacy Policy link not found on the Footer");
            throw(e);
        }
        return element;
    }

    public PrivacyPolicy openPrivacyPolicy() throws Exception
    {
        PrivacyPolicy privacyPolicy = null;
        try
        {
            link_PrivacyPolicy().click();
            privacyPolicy = new PrivacyPolicy(driver);
            AutomationLog.info("Privacy Policy link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Privacy Policy link is not clicked");
            throw(e);
        }
        return privacyPolicy;
    }
}