package com.agorafy.automation.testcases;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.contentpages.Blog;
import com.agorafy.automation.pageobjects.contentpages.Careers;
import com.agorafy.automation.pageobjects.contentpages.Contact;
import com.agorafy.automation.pageobjects.contentpages.FAQs;
import com.agorafy.automation.pageobjects.contentpages.HowItWorks;
import com.agorafy.automation.pageobjects.contentpages.MembershipBenefit;
import com.agorafy.automation.pageobjects.subnavigationmenu.SearchProfessionalsPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.SearchPropertiesPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

/**
 * Test all the links in Sub-navigation bar

 * Click Contact page link in sub-navigation bar, verify Contact page is loaded
 * Click Search Professionals link in sub-navigation bar, verify expected page is loaded
 * Click How It Works link in sub-navigation bar, verify expected page is loaded
 * Click Search Properties link in sub-navigation bar, verify expected page is loaded
 * Click Members' Benefits link in sub-navigation bar, verify expected page is loaded
 * Click About Us link in sub-navigation bar, verify expected page is loaded
 * Click Careers link in sub-navigation bar, verify URL and page heading
 * Click Blog link in sub-navigation bar, verify URL
 * Navigate back to previous page
 * Click FAQs link in sub-navigation bar, verify URL
 */
public class SubNavigationAction extends AutomationTestCase
{
    Homepage homepage;
    SubNavigation subnavigation = null;

    public SubNavigationAction()
    {
        super();
    }

    public void setUp()
    {
        super.setup();
        homepage = Homepage.homePage();
    }

    public void cleanUp()
    {
        super.cleanup();
    }

    public void Execute() throws Exception
    {
        try
        {
            setUp();
            subnavigation = Page.subNavigation();
            verifyContactPage(subnavigation);

            verifyHowitWorksPage(subnavigation);
            verifySearchPropertiesPage(subnavigation);
            verifyCareersPage(subnavigation);
            verifyAboutUsPage(subnavigation);

            verifyFAQs(subnavigation);
            Page.goToPreviousPage();
            WaitFor.waitForPageToLoad(Page.driver);

            verifyBlog(subnavigation);
            Page.goToPreviousPage();
            WaitFor.waitForPageToLoad(Page.driver);

            verifySearchProfessionalsPage(subnavigation);
            verifyMemberBenefitsPageHeading(subnavigation);

            testcasePassed("Links in Subnavigation have been tested");
        }
        catch(Exception e)
        {
            handleTestCaseFailure(e.getMessage());
        }
        catch(Throwable throwable)
        {
            handleTestCaseFailure(throwable.getMessage());
        }
        finally
        {
            cleanUp();
        }
    }

    private void handleTestCaseFailure(String message) throws Exception 
    {
        AutomationLog.error("SubNavigation Action  Failed: " + message);
        testcaseFailed("SubNavigation Action  Failed" + message);
        throw (new Exception("SubNavigation Action  Failed" + message));
    }

    public void verifyContactPage(SubNavigation subnavigation) throws Exception
    {
        Contact contactpage = subnavigation.clickLinkContact();
        Assert.assertEquals(contactpage.currentURL(), contactpage.contactPageUrl(), "Contact page URL is not as expected after clicking the link");
        Assert.assertEquals(contactpage.currentPageTitle(), "AGORAFY - Contact", "Contact page title does not match to the expected");
        Assert.assertEquals(contactpage.headingText(), "Contact", "Contact page is not loaded with correct Heading and content");
        AutomationLog.info("Contact page is correctly loaded");
    }

    public void verifyHowitWorksPage(SubNavigation subnavigation) throws Exception
    {
    	HowItWorks howitworks = subnavigation.clickLinkHowitWorks();
        Assert.assertEquals(howitworks.currentURL(), howitworks.howItWorksPageUrl(), "How it Works Page URL is not as expected after clicking the link.");
        Assert.assertEquals(howitworks.currentPageTitle(), "AGORAFY - Tips and How-Tos", "How it Works Page title does not match to the expected");
        Assert.assertEquals(howitworks.headingText(), "How It Works", "How it Works Page is not loaded with correct Heading and content");
        AutomationLog.info("How it Works page is correctly loaded");
    }

    public void verifySearchPropertiesPage(SubNavigation subnavigation) throws Exception
    {
        SearchPropertiesPage searchproperties = subnavigation.clickLinkSearchProperties();
        Assert.assertEquals(searchproperties.currentURL(), searchproperties.getURL(), "Search Properties Page URL is not as expected after clicking the link.");
        Assert.assertEquals(searchproperties.currentPageTitle(), "AGORAFY - Search", "Search Properties Page title does not match to the expected");
        Assert.assertEquals(searchproperties.pageHeading(), "Search Properties in New York City", "Search Properties Page is not loaded with correct Heading and content");
        AutomationLog.info("Search Properties page is correctly loaded");
    }

    public void verifyCareersPage(SubNavigation subnavigation) throws Exception
    {
        Careers careerpage = subnavigation.clickLinkCareers();
        Assert.assertEquals(careerpage.currentURL(), careerpage.careersPageUrl(), "Careers Page URL is not as expected after clicking the link.");
        Assert.assertEquals(careerpage.currentPageTitle(), "AGORAFY - Careers", "Careers Page title does not match to the expected");
        Assert.assertEquals(careerpage.headingText(), "Careers", "Careers Page is not loaded with correct Heading and content");
        AutomationLog.info("Careers page is correctly loaded");
    }

    public void verifySearchProfessionalsPage(SubNavigation subnavigation) throws Exception
    {
        SearchProfessionalsPage searchprofessionals = subnavigation.clickLinkSearchProfessionals();
        Assert.assertEquals(searchprofessionals.currentURL(), searchprofessionals.getURL(), "Search Professionals page URL is not as expected after clicking the link");
        Assert.assertEquals(searchprofessionals.currentPageTitle(), "AGORAFY - Agent and Company Search", "Search Professionals page title does not match to the expected");
        Assert.assertEquals(searchprofessionals.pageHeading(), "Agent and Company Search", "Search Professionals page is not loaded with correct Heading and content");
        AutomationLog.info("Search Professionals page is correctly loaded");
    }

    public void verifyAboutUsPage(SubNavigation subnavigation) throws Exception
    {
        AboutUs aboutus = subnavigation.clickLinkAboutUs();
        Assert.assertEquals(aboutus.currentURL(), aboutus.aboutUsPageUrl(), "About Us Page URL is not as expected after clicking the link.");
        Assert.assertEquals(aboutus.currentPageTitle(), "AGORAFY - About Us", "About Us Page title does not match to the expected");
        Assert.assertEquals(aboutus.headingText(), "About Us", "About Us Page is not loaded with correct Heading and content");
        AutomationLog.info("About Us page is correctly loaded");
    }

    public void verifyMemberBenefitsPageHeading(SubNavigation subnavigation) throws Exception
    {
    	MembershipBenefit memberbenefit = subnavigation.clickLinkMemberBenefits();
        Assert.assertEquals(memberbenefit.currentURL(), memberbenefit.membershipBenefitPageUrl(), "Member Benefits Page URL is not as expected after clicking the link.");
        Assert.assertEquals(memberbenefit.currentPageTitle(), "AGORAFY - Members' Benefits", "Member Benefits Page title does not match to the expected");
        Assert.assertEquals(memberbenefit.headingText(), "Members' Benefits", "Member Benefits Page is not loaded with correct Heading and content");
        AutomationLog.info("Member Benefits page is correctly loaded");
    }

    public void verifyBlog(SubNavigation subnavigation) throws Exception
    {
        Blog blog = subnavigation.clickLinkBlog();
        Assert.assertEquals(blog.currentURL(), blog.blogPageUrl(), "Agorafy Blog URL is not as expected after clicking the link.");
        Assert.assertEquals(blog.currentPageTitle(), "Agorafy - Home", "Agorafy Blog title does not match to the expected");
        AutomationLog.info("Agorafy Blog is correctly loaded");
    }

    public void verifyFAQs(SubNavigation subnavigation) throws Exception
    {
        FAQs faqs = subnavigation.clickLinkFAQ();
        Assert.assertEquals(faqs.currentURL(), faqs.faqsPageUrl(), "FAQ Page URL is not as expected after clicking the link.");
        Assert.assertEquals(faqs.currentPageTitle(), "Agorafy - FAQ", "Careers Page title does not match to the expected");
        AutomationLog.info("FAQ page is correctly loaded");
    }
}
