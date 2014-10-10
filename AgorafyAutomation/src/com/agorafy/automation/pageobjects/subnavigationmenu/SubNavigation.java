package com.agorafy.automation.pageobjects.subnavigationmenu;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.contentpages.Blog;
import com.agorafy.automation.pageobjects.contentpages.Careers;
import com.agorafy.automation.pageobjects.contentpages.Contact;
import com.agorafy.automation.pageobjects.contentpages.FAQs;
import com.agorafy.automation.pageobjects.contentpages.HowItWorks;
import com.agorafy.automation.pageobjects.contentpages.MembershipBenefit;

public class SubNavigation extends Page
{
    WebElement element = null;

    public SubNavigation(WebDriver driver)
    {
        super(driver);
    }

    public WebElement SubNavigationBar() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("subtopbar"));
            AutomationLog.info("Sub navigation bar found");
        }
        catch (Exception e)
        {
            AutomationLog.error("Sub navigation bar was not found");
            throw(e);
        }
        return element;
    }

    public WebElement link_Contact() throws Exception
    {
        try
        {
            element = SubNavigationBar().findElement(By.linkText("Contact"));
            AutomationLog.info("Contact Link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("Contact link not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public Contact clickLinkContact() throws Exception
    {
        try
        {
            link_Contact().click();
            AutomationLog.info("Contact link clicked");
        }
        catch (Exception e)
        {
        	AutomationLog.error("Contact link is not found");
            throw(e);
        }
        return new Contact(Page.driver);
    }

    public WebElement link_SearchProfessionals() throws Exception
    {
        try
        {
            element = SubNavigationBar().findElement(By.linkText("Search Professionals"));
            AutomationLog.info("Search professionals link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("Search Professional link not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public SearchProfessionalsPage clickLinkSearchProfessionals() throws Exception
    {
        try
        {
            link_SearchProfessionals().click();
            AutomationLog.info("Search Professionals link is clicked");
        }
        catch (Exception e)
        {
        	AutomationLog.error("Search Professionals link click operation not successful");
            throw(e);
        }
        return new SearchProfessionalsPage(Page.driver);
    }

    public WebElement link_HowItWorks() throws Exception
    {
        try
        {
            element = SubNavigationBar().findElement(By.linkText("How It Works"));
            AutomationLog.info("How it Works link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("How it Works link is not found in the sub navigation bar");
            throw(e);
        }
        return element;
    }

    public HowItWorks clickLinkHowitWorks() throws Exception
    {
        try
        {
            link_HowItWorks().click();
            AutomationLog.info("How it Works link is clicked");
        }
        catch(Exception e)
        {
        	AutomationLog.error("How it Works link click operation not successful");
            throw(e);
        }
        return new HowItWorks(Page.driver);
    }

    public WebElement link_MemberBenefits() throws Exception
    {
        try
        {
            element = SubNavigationBar().findElement(By.linkText("Members' Benefits"));
            AutomationLog.info("Members Benefits link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("Members Benefits link is not found in the sub navigation bar");
            throw(e);
        }
        return element;
    }

    public MembershipBenefit clickLinkMemberBenefits() throws Exception
    {
        try
        {
            link_MemberBenefits().click();
            AutomationLog.info("Member Benefits link clicked");
        }
        catch(Exception e)
        {
        	AutomationLog.error("Member Benefits link could not be clicked");
            throw(e);
        }
        return new MembershipBenefit(Page.driver);
    }

    public WebElement link_SearchProperties() throws Exception
    {
        try
        {
            element = SubNavigationBar().findElement(By.linkText("Search Properties"));
            AutomationLog.info("Search Properties link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("Search Properties link not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public SearchPropertiesPage clickLinkSearchProperties() throws Exception
    {
    	try
        {
            link_SearchProperties().click();
            AutomationLog.info("Search Properties link is clicked");
        }
        catch (Exception e)
        {
        	AutomationLog.error("Search Properties link click operation not successful");
            throw(e);
        }
        return new SearchPropertiesPage(Page.driver);
    }

    public WebElement link_Careers() throws Exception
    {
        try
        {
            element = SubNavigationBar().findElement(By.linkText("Careers"));
            AutomationLog.info("Careers link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("Careers link not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public Careers clickLinkCareers() throws Exception
    {
    	try
        {
            link_Careers().click();
            AutomationLog.info("Careers page link is clicked");
        }
        catch (Exception e)
        {
        	AutomationLog.error("Careers page link click operation not successful");
            throw(e);
        }
        return new Careers(Page.driver);
    }

    public WebElement link_AboutUs() throws Exception
    {
        try
        {
            element = SubNavigationBar().findElement(By.linkText("About Us"));
            AutomationLog.info("About Us link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("About Us link not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public AboutUs clickLinkAboutUs() throws Exception
    {
        try
        {
            link_AboutUs().click();
            AutomationLog.info("About Us link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("About Us link click operation not successful");
            throw(e);
        }
        return new AboutUs(Page.driver);
    }

    public WebElement link_Blog() throws Exception
    {
        try
        {
            element = SubNavigationBar().findElement(By.linkText("Blog"));
            AutomationLog.info("Blog link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("Blog link not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public Blog clickLinkBlog() throws Exception
    {
        try
        {
            link_Blog().click();
            Page.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            AutomationLog.info("Blog link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("Blog link could not be clicked");
            throw(e);
        }
        return new Blog(Page.driver);
    }

    public WebElement link_FAQ() throws Exception
    {
        try
        {
            element = SubNavigationBar().findElement(By.linkText("FAQs"));
            AutomationLog.info("FAQs link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("FAQs link not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public FAQs clickLinkFAQ() throws Exception
    {
        try
        {
            link_FAQ().click();
            AutomationLog.info("FAQs link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("FAQs link could not be clicked");
            throw(e);
        }
        return new FAQs(Page.driver);
    }
}
