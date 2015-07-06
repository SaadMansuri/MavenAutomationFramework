package com.agorafy.automation.pageobjects.subnavigationmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.contentpages.Blog;
import com.agorafy.automation.pageobjects.contentpages.Careers;
import com.agorafy.automation.pageobjects.contentpages.Contact;
import com.agorafy.automation.pageobjects.contentpages.FAQs;
import com.agorafy.automation.pageobjects.contentpages.HowItWorks;
import com.agorafy.automation.pageobjects.contentpages.MembershipBenefit;
import com.agorafy.automation.pageobjects.footer.company.Team;
import com.agorafy.automation.pageobjects.footer.support.Feedback;
import com.agorafy.automation.pageobjects.footer.support.Press;

public class SubNavigation extends Page
{
    WebElement element = null;

    public SubNavigation(WebDriver driver)
    {
        super(driver);
    }

    public WebElement subNavigationBar() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("subtopbar"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Sub navigation bar Not found");
            throw(e);
        }
        return element;
    }

    public WebElement link_Contact() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("Contact"));
            AutomationLog.info("Contact Link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("Contact link Not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public Contact clickLinkContact() throws Exception
    {
        Contact contact;
        try
        {
            link_Contact().click();
            contact = new Contact(driver);
            AutomationLog.info("Contact link clicked");
        }
        catch (Exception e)
        {
        	AutomationLog.error("Contact link could not be clicked");
            throw(e);
        }
        return contact;
    }

    public WebElement link_SearchProfessionals() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("Search Professionals"));
            AutomationLog.info("Search professionals link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("Search Professional link Not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public SearchProfessionalsPage clickLinkSearchProfessionals() throws Exception
    {
        SearchProfessionalsPage searchprofessionals;
        try
        {
            link_SearchProfessionals().click();
            searchprofessionals = new SearchProfessionalsPage(driver);
            AutomationLog.info("Search Professionals link is clicked");
        }
        catch (Exception e)
        {
        	AutomationLog.error("Search Professionals link could not be clicked");
            throw(e);
        }
        return searchprofessionals;
    }

    public WebElement link_HowItWorks() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("How It Works"));
            AutomationLog.info("How it Works link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("How it Works link Not found in the sub navigation bar");
            throw(e);
        }
        return element;
    }

    public HowItWorks clickLinkHowitWorks() throws Exception
    {
        HowItWorks howitworks;
        try
        {
            link_HowItWorks().click();
            howitworks = new HowItWorks(driver);
            AutomationLog.info("How it Works link is clicked");
        }
        catch(Exception e)
        {
        	AutomationLog.error("How it Works link could not be clicked");
            throw(e);
        }
        return howitworks;
    }

    public WebElement link_MemberBenefits() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("Members' Benefits"));
            AutomationLog.info("Members Benefits link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("Members Benefits link Not found in the sub navigation bar");
            throw(e);
        }
        return element;
    }

    public MembershipBenefit clickLinkMemberBenefits() throws Exception
    {
    	MembershipBenefit membership;
        try
        {
            link_MemberBenefits().click();
            membership = new MembershipBenefit(driver);
            AutomationLog.info("Members' Benefits link clicked");
        }
        catch(Exception e)
        {
        	AutomationLog.error("Members' Benefits link could not be clicked");
            throw(e);
        }
        return membership;
    }

    public WebElement link_SearchProperties() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("Search Properties"));
            AutomationLog.info("Search Properties link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("Search Properties link Not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public SearchPropertiesPage clickLinkSearchProperties() throws Exception
    {
        SearchPropertiesPage searchproperties;
        try
        {
            link_SearchProperties().click();
            searchproperties = new SearchPropertiesPage(driver);
            AutomationLog.info("Search Properties link is clicked");
        }
        catch (Exception e)
        {
        	AutomationLog.error("Search Properties link could not be clicked");
            throw(e);
        }
        return searchproperties;
    }

    public WebElement link_AboutUs() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("About Us"));
            AutomationLog.info("About Us link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("About Us link Not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public AboutUs clickLinkAboutUs() throws Exception
    {
        AboutUs aboutus;
        try
        {
            link_AboutUs().click();
            aboutus = new AboutUs(driver);
            AutomationLog.info("About Us link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("About Us link could not be clicked");
            throw(e);
        }
        return aboutus;
    }

    public WebElement link_Blog() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("Blog"));
            AutomationLog.info("Blog link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("Blog link Not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public Blog clickLinkBlog() throws Exception
    {
        Blog blog;
        try
        {
            link_Blog().click();
            blog = new Blog(driver);
            AutomationLog.info("Blog link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("Blog link could not be clicked");
            throw(e);
        }
        return blog;
    }

    public WebElement link_FAQ() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("FAQs"));
            AutomationLog.info("FAQs link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("FAQs link Not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public FAQs clickLinkFAQ() throws Exception
    {
        FAQs faq;
        try
        {
            link_FAQ().click();
            faq = new FAQs(driver);
            AutomationLog.info("FAQs link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("FAQs link could not be clicked");
            throw(e);
        }
        return faq;
    }

    public WebElement link_AdvancedSearch() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("Advanced Search"));
            AutomationLog.info("Advanced Search link found in Subnavigation bar");
        }
        catch (Exception e)
        {
            AutomationLog.error("Advanced Search link not found in Subnavigation bar");
            throw(e);
        }
        return element;
    }

    public WebElement link_MyDashboard() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("My Dashboard"));
            AutomationLog.info("My Dashboard link found in sub-navigation tab");
        }
        catch (Exception e) 
        {
            AutomationLog.error("My Dashboard link does not found in sub-navigation tab");
            throw (e);
        }
        return element;
    }

    public Dashboard clickLinkMyDashboard() throws Exception
    {
        Dashboard dashboard;
        try
        {
            link_MyDashboard().click();
            dashboard = new Dashboard(driver);
            AutomationLog.info("My Dashboard link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("My Dashboard link click operation not successful");
            throw(e);
        }
        return dashboard;
    }
    
    public AdvancedSearchPage clickLinkAdvancedSearch() throws Exception
    {
        AdvancedSearchPage advancedSearch;
        try
        {
            link_AdvancedSearch().click();
            advancedSearch = new AdvancedSearchPage(driver);
            AutomationLog.info("Advanced Search link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("Advanced Search link click operation not successfull");
            throw(e);
        }
        return advancedSearch;
    }

    public WebElement link_MyListings() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("My Listings"));
            AutomationLog.info("My Listings link found in sub-navigation tab");
        }
        catch (Exception e) 
        {
            AutomationLog.error("My Listings link does not found in sub-navigation tab");
            throw (e);
        }
        return element;
    }

    public MyListings clickLinkMyListings() throws Exception
    {
        MyListings myListings;
        try
        {
            link_MyListings().click();
            myListings = new MyListings(driver);
            AutomationLog.info("My Listings link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("My Listings link click operation not successful");
            throw(e);
        }
        return myListings;
    }

    public WebElement link_MySubscriptions() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("My Subscriptions"));
            AutomationLog.info("My Subscriptions link found in sub-navigation tab");
        }
        catch (Exception e) 
        {
            AutomationLog.error("My Subscriptions link does not found in sub-navigation tab");
            throw (e);
        }
        return element;
    }

    public MySubscriptions clickLinkMySubscriptions() throws Exception
    {
        MySubscriptions mySubscriptions;
        try
        {
            link_MySubscriptions().click();
            mySubscriptions = new MySubscriptions(driver);
            AutomationLog.info("My Subscriptions link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("My Subscriptions link click operation not successful");
            throw(e);
        }
        return mySubscriptions;
    }

    public WebElement link_EditProfile() throws Exception
    {
        try
        {
            element = subNavigationBar().findElement(By.linkText("Edit Profile"));
            AutomationLog.info("Edit Profile link found in sub-navigation tab");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Edit Profile link does not found in sub-navigation tab");
            throw (e);
        }
        return element;
    }

    public EditProfile clickLinkEditProfile() throws Exception
    {
        EditProfile editProfile;
        try
        {
            link_EditProfile().click();
            editProfile = new EditProfile(driver);
            AutomationLog.info("Edit Profile link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("Edit Profile link click operation not successful");
            throw(e);
        }
        return editProfile;
    }

    public WebElement dropdown_MoreLink() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("more-link"));
            AutomationLog.info("drop down More found in sub-navigation tab");
        }
        catch (Exception e) 
        {
            AutomationLog.error("drop down More does not found in sub-navigation tab");
            throw (e);
        }
        return element;
    }

    public WebElement link_More_Team() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Team"));
            AutomationLog.info("drop down More-Team Option found in sub-navigation tab");
        }
        catch (Exception e) 
        {
            AutomationLog.error("drop down More-Team Option does not found in sub-navigation tab");
            throw (e);
        }
        return element;
    }

    public WebElement link_More_Careers() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Careers"));
            AutomationLog.info("drop down More-Careers Option found in sub-navigation tab");
        }
        catch (Exception e) 
        {
            AutomationLog.error("drop down More-Careers Option does not found in sub-navigation tab");
            throw (e);
        }
        return element;
    }

    public WebElement link_More_Press() throws Exception
    {	
        try
        {
            element = driver.findElement(By.linkText("Press"));
            AutomationLog.info("drop down More-Press Option found in sub-navigation tab");
        }
        catch (Exception e) 
        {
            AutomationLog.error("drop down More-Press Option does not found in sub-navigation tab");
            throw (e);
        }
        return element;
    }

    public WebElement link_More_Feedback() throws Exception
    {	
        try
        {
            element = driver.findElement(By.linkText("Feedback"));
            AutomationLog.info("drop down More-Feedback Option found in sub-navigation tab");
        }
        catch (Exception e) 
        {
            AutomationLog.error("drop down More-Feedback Option does not found in sub-navigation tab");
            throw (e);
        }
        return element;
    }

    public WebElement link_More_Contact() throws Exception
    {	
        try
        {
            element = driver.findElement(By.linkText("Contact"));
            AutomationLog.info("drop down More-Contact Option found in sub-navigation tab");
        }
        catch (Exception e) 
        {
            AutomationLog.error("drop down More-Contact Option does not found in sub-navigation tab");
            throw (e);
        }
        return element;
    }

    public Page selectDropdownMoreOption(String dropdownMoreOption) throws Exception
    {
        Page page = null;
        try
        {
            dropdown_MoreLink().click();
            switch (dropdownMoreOption)
            {
                case "Team":
                    link_More_Team().click();
                    page = new Team(driver);
                    break;

                case "Careers":
                    link_More_Careers().click();
                    page = new Careers(driver);
                    break;

                case "Press":
                    link_More_Press().click();
                    page = new Press(driver);
                    break;

                case "Feedback":
                    link_More_Feedback().click();
                    page = new Feedback(driver);
                    break;

                case "Contact":
                    link_More_Contact().click();
                    page = new Contact(driver);
                    break;
            }
            AutomationLog.info("Successfully clicked on More drop down option" + dropdownMoreOption );
        }
        catch (Exception e)
        {
            AutomationLog.error("failed to click" + dropdownMoreOption  +"-drop down option from More");
            throw(e);
        }
        return page;
    }
}
