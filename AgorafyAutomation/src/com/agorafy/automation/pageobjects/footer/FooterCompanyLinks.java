package com.agorafy.automation.pageobjects.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.contentpages.Careers;
import com.agorafy.automation.pageobjects.contentpages.Contact;
import com.agorafy.automation.pageobjects.contentpages.MembershipBenefit;
import com.agorafy.automation.pageobjects.footer.company.Team;

public class FooterCompanyLinks extends Page
{
    private WebElement element = null;
    public FooterCompanyLinks(WebDriver driver)
    {
        super(driver);
    }

    public WebElement link_AboutUs() throws Exception 
    {
        try
        {
            element = driver.findElement(By.linkText("About Us"));
            AutomationLog.info(" About Us link found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("About Us link not found on Footer");
            throw(e);
        }
        return element;
    }

    public AboutUs clickOnAboutUsLink() throws Exception 
    {
        AboutUs aboutUs = null;
        try
        {
            link_AboutUs().click();
            aboutUs = new AboutUs(driver);
            AutomationLog.info("About Us link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("About Us link could not be clicked");
            throw(e);
        }
        return aboutUs;
    }

    public WebElement footer_CompanyLinks() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("footer-left-section")).findElements(By.tagName("div")).get(0);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find FooterCompanyLinks");
            throw(e);
        }
        return element;
    }

    public WebElement link_MembershipBenefit() throws Exception
    {
        try
        {
            element = footer_CompanyLinks().findElement(By.linkText("Members' Benefits"));
            AutomationLog.info("Members' Benefits link found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Members' Benefits link not found on Footer");
            throw(e);
        }
        return element;
    }

    public MembershipBenefit clickOnMembershipBenefitLink() throws Exception 
    {
        MembershipBenefit membershipBenefit = null;
        try
        {
            link_MembershipBenefit().click();
            membershipBenefit = new MembershipBenefit(driver);
            AutomationLog.info("Members' Benefits link clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Members' Benefits link could not be clicked");
            throw(e);
        }
        return membershipBenefit;
    }

    public WebElement link_Team() throws Exception 
    {
        try
        {
            element = footer_CompanyLinks().findElement(By.linkText("Team"));
            AutomationLog.info("Team link found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Team link not found on Footer");
            throw(e);
        }
        return element;
    }

    public Team clickOnTeamLink() throws Exception
    {
        Team team = null;
        try
        {
            link_Team().click();
            team = new Team(driver);
            AutomationLog.info("Team link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Team link could not be clicked ");
            throw(e);
        }
        return team;
    }

    public WebElement link_Careers() throws Exception
    {
        try
        {
            element = footer_CompanyLinks().findElement(By.linkText("Careers"));
            AutomationLog.info("Careers link found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Careers link not found on Footer");
            throw(e);
        }
        return element;
    }

    public Careers clickOnCareersLink() throws Exception
    {
        Careers careers = null;
        try
        {
            link_Careers().click();
            careers = new Careers(driver);
            AutomationLog.info("Careers link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Careers link could not be clicked");
            throw(e);
        }
        return careers;
    }

    public WebElement link_Contact() throws Exception
    {
        try
        {
            element = footer_CompanyLinks().findElement(By.linkText("Contact"));
            AutomationLog.info("Contact link found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Contact link not found on Footer");
            throw(e);
        }
        return element;
    }

    public Contact clickOnContactLink() throws Exception
    {
        Contact contact = null;
        try
        {
            link_Contact().click();
            contact = new Contact(driver);
            AutomationLog.info("Contact link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Contact link could not be clicked");
            throw(e);
        }
        return contact;
    }
}