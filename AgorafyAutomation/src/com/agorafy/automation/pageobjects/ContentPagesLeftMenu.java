package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.contentpages.Careers;
import com.agorafy.automation.pageobjects.contentpages.Contact;
import com.agorafy.automation.pageobjects.contentpages.HowItWorks;
import com.agorafy.automation.pageobjects.contentpages.MembershipBenefit;
import com.agorafy.automation.pageobjects.footer.company.Team;
import com.agorafy.automation.pageobjects.footer.support.Feedback;
import com.agorafy.automation.pageobjects.footer.support.Press;

public class ContentPagesLeftMenu extends Page
{
    private WebElement element = null;
    public ContentPagesLeftMenu(WebDriver driver)
    {
        super(driver);
    }

    public WebElement link_AboutUs() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("About Us"));
            AutomationLog.info("About Us Link found on Content Pages Left Menu");
        }
        catch(Exception e)
        {
            AutomationLog.error("About Us Link Not found on Content Pages Left Menu");
            throw(e);
        }
        return element;
    }

    public String aboutUsLinkText() throws Exception
    {
        return link_AboutUs().getText();
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

    public WebElement link_HowItWorks() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("How It Works"));
            AutomationLog.info("How It Works link found on Content Pages Left Menu");
        }
        catch(Exception e)
        {
            AutomationLog.error("How It Works link Not found on Content Pages Left Menu");
            throw(e);
        }
        return element;
    }

    public String howItWorksLinkText() throws Exception
    {
        return link_HowItWorks().getText();
    }

    public HowItWorks clickOnHowItWorksLink() throws Exception
    {
        HowItWorks howItWorks = null;
        try
        {
            link_HowItWorks().click();
            howItWorks = new HowItWorks(driver);
            AutomationLog.info("How It Works link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("How It Works link could not be clicked");
            throw(e);
        }
        return howItWorks;
    }

    public WebElement link_MembershipBenefit() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Members' Benefits"));
            AutomationLog.info("Members' Benefits link found on Content Pages Left Menu");
        }
        catch(Exception e)
        {
            AutomationLog.error("Members' Benefits link Not found on Content Pages Left Menu");
            throw(e);
        }
        return element;
    }

    public String membershipBenefitLinkText() throws Exception
    {
        return link_MembershipBenefit().getText();
    }

    public MembershipBenefit clickOnMembershipBenefitLink() throws Exception 
    {
        MembershipBenefit membershipBenefit = null;
        try
        {
            link_MembershipBenefit().click();
            membershipBenefit = new MembershipBenefit(driver);
            AutomationLog.info("Members'Benefits link clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Members' Benefits link could not be clicked");
            throw(e);
        }
        return membershipBenefit;
    }

    public WebElement link_Press() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Press"));
            AutomationLog.info("Press link found on Content Pages Left Menu");
        }
        catch(Exception e)
        {
            AutomationLog.error("Press link Not found on Content Pages Left Menu");
            throw(e);
        }
        return element;
    }

    public String pressLinkText() throws Exception
    {
        return link_Press().getText();
    }

    public Press clickOnPressLink() throws Exception
    {
        Press press = null;
        try
        {
            link_Press().click();
            press = new Press(driver);
            AutomationLog.info("Press link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Press link could not be clicked");
            throw(e);
        }
        return press;
    }

    public WebElement link_Team() throws Exception 
    {
        try
        {
            element = driver.findElement(By.linkText("Team"));
            AutomationLog.info("Team link found on Content Pages Left Menu");
        }
        catch(Exception e)
        {
            AutomationLog.error("Team link Not found on Content Pages Left Menu");
            throw(e);
        }
        return element;
    }

    public String teamLinkText() throws Exception
    {
        return link_Team().getText();
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
            element = driver.findElement(By.linkText("Careers"));
            AutomationLog.info("Careers link found on Content Pages Left Menu");
        }
        catch(Exception e)
        {
            AutomationLog.error("Careers link Not found on Content Pages Left Menu");
            throw(e);
        }
        return element;
    }

    public String careersLinkText() throws Exception
    {
        return link_Careers().getText();
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

    public WebElement link_Feedback() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Feedback"));
            AutomationLog.info("Feedback link found on Content Pages Left Menu");
        }
        catch(Exception e)
        {
            AutomationLog.error("Feedback link Not found on Content Pages Left Menu");
            throw(e);
        }
        return element;
    }

    public String feedbackLinkText() throws Exception
    {
        return link_Feedback().getText();
    }

    public Feedback clickOnFeedbackLink() throws Exception
    {
        Feedback feedback = null;
        try
        {
            link_Feedback().click();
            feedback = new Feedback(driver);
            AutomationLog.info("Feedback link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Feedback link could not be clicked");
            throw(e);
        }
        return feedback;
    }

    public WebElement link_Contact() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Contact"));
            AutomationLog.info("Contact link found on Content Pages Left Menu");
        }
        catch(Exception e)
        {
            AutomationLog.error("Contact link Not found on Content Pages Left Menu");
            throw(e);
        }
        return element;
    }

    public String contactLinkText() throws Exception
    {
        return link_Contact().getText();
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

    public WebElement leftMenuLinks() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div/ul"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Left Menu on the Page");
            throw(e);
        }
        return element;
    }

    @SuppressWarnings("static-access")
    public String getCurrentlyActiveLink()
    {
        String activeLinkText = "";
        try
        {
            element = leftMenuLinks().findElement(By.tagName("li").className("active"));
            activeLinkText = element.getText();
        }
        catch (Exception e)
        {
            AutomationLog.error("Left Menu does not show any link active");
        }
        return activeLinkText;
    } 

    public WebElement link_EditAndViewProfile() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div/ul/li[4]/a"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find link Edit And View Profile on left hand side");
            throw(e);
        }
        return element;
    }

    public String EditProfileLinkText() throws Exception 
    {
    	return link_EditAndViewProfile().getText();
    }

    public WebElement link_MySubscriptions() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div/ul/li[3]/a"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find link My Subscriptions on left hand side");
            throw(e);
        }
        return element;
    }

    public String MySubscriptionsLinkText() throws Exception 
    {
    	return link_MySubscriptions().getText();
    }

    public WebElement link_MyListings() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div/ul/li[2]/a"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find link My Listings on left hand side");
            throw(e);
        }
        return element;
    }

    public String MyListingsLinkText() throws Exception 
    {
        return link_MyListings().getText();
    }

    public WebElement link_MyDashboard() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[1]/div/ul/li[1]/a"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find link My Dashboard on left hand side");
            throw(e);
        }
        return element;
    }

    public String MyDashboardLinkText() throws Exception 
    {
        return link_MyDashboard().getText();
    }

    public String TeamLinkText() throws Exception 
    {
        return link_Team().getText();
    }

    public String CareersLinkText() throws Exception 
    {
        return link_Careers().getText();
    }
}	