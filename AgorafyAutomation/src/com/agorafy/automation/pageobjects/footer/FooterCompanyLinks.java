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
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[1]/div/div[1]/ul/li[1]/a"));
            AutomationLog.info(" About us link found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("About us link not found on the Footer");
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

    public WebElement link_MembershipBenefit() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[1]/div/div[1]/ul/li[2]/a"));
            AutomationLog.info("Membership's Benefit link found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Membership's Benefit link not found on the Footer");
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
            AutomationLog.info("Membership Benefit link clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Membership Benefit link could not be clicked");
            throw(e);
        }
        return membershipBenefit;
    }

    public WebElement link_Team() throws Exception 
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[1]/div/div[1]/ul/li[3]/a"));
            AutomationLog.info("Team link found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Team link not found on the Footer");
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
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[1]/div/div[1]/ul/li[4]/a"));
            AutomationLog.info("Careers link found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Careers link not found on the Footer");
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
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[1]/div/div[1]/ul/li[5]/a"));
            AutomationLog.info("Contact link found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Contact link not found on the Footer");
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