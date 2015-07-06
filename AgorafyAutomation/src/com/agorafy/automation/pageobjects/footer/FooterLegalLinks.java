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


    public WebElement footer_LegalLinks() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("footer-left-section")).findElements(By.tagName("div")).get(2);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find FooterCompanyLinks");
            throw(e);
        }
        return element;
    }

    public WebElement link_TermsAndConditions() throws Exception
    {
        try
        {
            element = footer_LegalLinks().findElement(By.linkText("Terms and Conditions"));
            AutomationLog.info("Terms And Conditions link found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Terms And Conditions link not found on Footer");
            throw(e);
        }
        return element;
    }

    public TermsAndConditions clickOnTermsAndConditionsLink() throws Exception
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
            AutomationLog.error("Terms And Conditions link could not be clicked");
            throw(e);
        }
        return termsAndConditions;
    }

    public WebElement link_PrivacyPolicy() throws Exception
    {
        try
        {
            element = footer_LegalLinks().findElement(By.linkText("Privacy Policy"));
            AutomationLog.info("Privacy Policy link found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Privacy Policy link not found on Footer");
            throw(e);
        }
        return element;
    }

    public PrivacyPolicy clickOnPrivacyPolicyLink() throws Exception
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
            AutomationLog.error("Privacy Policy link could not be clicked");
            throw(e);
        }
        return privacyPolicy;
    }
}