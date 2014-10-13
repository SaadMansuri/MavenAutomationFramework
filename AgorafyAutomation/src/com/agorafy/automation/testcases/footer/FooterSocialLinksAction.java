package com.agorafy.automation.testcases.footer;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterSocialLinks;
import com.agorafy.automation.pageobjects.footer.social.AgorafyFacebookPage;
import com.agorafy.automation.pageobjects.footer.social.AgorafyGooglePlusPage;
import com.agorafy.automation.pageobjects.footer.social.AgorafyLinkedInPage;
import com.agorafy.automation.pageobjects.footer.social.AgorafyTwitterPage;
import com.agorafy.automation.pageobjects.footer.social.AgorafyYoutubePage;
/**
 * Test SocialNetworking IconLinks on Footer
 * Click Twitter iconlink on the Home Page, verify AgorafyTwitter Page is loaded by checking its URL and title
 * Click Facebook iconlink on the Home Page, verify AgorafyFacebook Page is loaded by checking its URL and title 
 * Click GooglePlus iconlink on the Home Page, verify AgorafyGooglePlus Page is loaded by checking its URL and title
 * Click Youtube iconlink on the Home Page, verify AgorafyYoutube Page is loaded by checking its URL and title
 * Click LinkedIn iconlink on the Home Page, verify AgorafyLinkedIn Page is loaded by checking its URL and title
 */
public class FooterSocialLinksAction extends AutomationTestCaseVerification
{
    FooterSocialLinks socialLinks = null;
    String homePageHandle = "";
    AgorafyTwitterPage agorafyTwitter = null;
    AgorafyFacebookPage agorafyFacebook = null;
    AgorafyYoutubePage agorafyYoutube = null;
    AgorafyLinkedInPage agorafyLinkedIn = null;
    AgorafyGooglePlusPage agorafyGooglePlus = null;

    public FooterSocialLinksAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases()
    {
        socialLinks = Page.footer().socialLinks();
        homePageHandle = Page.driver.getWindowHandle();
        try 
        {
            verifyAgorafyTwitterLink();
            verifyAgorafyFacebookLink();
            verifyAgorafyYoutubeLink();
            verifyAgorafyGooglePlusLink();
            verifyAgorafyLinkedInLink();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void verifyAgorafyLinkedInLink() throws Exception
    {
        try
        {
            agorafyLinkedIn = socialLinks.clickOnLinkedInIconLink();
            AutomationLog.info("Agorafy LinkedIn Page opened successfully");

            switchToNewWindow();

            Assert.assertEquals(agorafyLinkedIn.currentURL(),agorafyLinkedIn.agorafyLinkedInPageUrl(),"LinkedIn Icon Link did not navigate to correct page Url");
            AutomationLog.info("LinkedIn icon link navigates to LinkedIn Url");

            Assert.assertEquals(agorafyLinkedIn.currentPageTitle(), "Agorafy | LinkedIn","Agorafy LinkedIn Page does not show correct page title");
            AutomationLog.info("Agorafy LinkedIn Page shows correct page Title");

            switchToHomePage();
        }
        catch(Exception e)
        {
            AutomationLog.error("Either AgorafyLinkedIn page did not open successfully or AgorafyLinkedIn page verification failed" + e.getMessage());
        }
    }

    private void verifyAgorafyGooglePlusLink() throws Exception
    {
        try
        {
            agorafyGooglePlus = socialLinks.clickOnGooglePlusIconLink();
            AutomationLog.info("Agorafy Google Plus Page opened successfully");

            switchToNewWindow();

            Assert.assertEquals(agorafyGooglePlus.currentURL(),agorafyGooglePlus.agorafyGooglePlusPageUrl(),"GooglePlus Icon Link did not navigate to correct page Url");
            AutomationLog.info("GooglePlus icon link navigates to GooglePlus Url");

            Assert.assertEquals(agorafyGooglePlus.currentPageTitle(), "Agorafy - Google+","Agorafy GooglePlus Page does not show correct page title");
            AutomationLog.info("Agorafy GooglePlus Page shows correct page Title");

            switchToHomePage();
        }
        catch(Exception e)
        {
            AutomationLog.error("Either AgorafyGooglePlus page did not open successfully or AgorafyGooglePlus page verification failed" + e.getMessage());
        }
    }

    private void verifyAgorafyYoutubeLink() throws Exception
    {
        try 
        {
            agorafyYoutube = socialLinks.clickOnYoutubeIconLink();
            AutomationLog.info("Agorafy Youtube Page opened successfully");

            switchToNewWindow();

            Assert.assertEquals(agorafyYoutube.currentURL(),agorafyYoutube.agorafyYoutubePageUrl(),"YouTube Icon Link did not navigate to correct page Url");
            AutomationLog.info("Youtube icon link navigates to Youtube Url");

            Assert.assertEquals(agorafyYoutube.currentPageTitle(), "agorafy - YouTube","Agorafy Youtube Page does not show correct page title");
            AutomationLog.info("Agorafy Youtube Page shows correct page Title");

            switchToHomePage();
        }
        catch(Exception e)
        {
            AutomationLog.error("Either AgorafyYoutube page did not open successfully or AgorafyYoutube page verification failed" + e.getMessage());
        }
    }

    private void verifyAgorafyFacebookLink() throws Exception
    {
        try 
        {
            agorafyFacebook = socialLinks.clickOnFacebookIconLink();
            AutomationLog.info("Agorafy Facebook Page opened successfully");

            switchToNewWindow();

            Assert.assertEquals(agorafyFacebook.currentURL(),agorafyFacebook.agorafyFacebookPageUrl(),"Facebook Icon Link did not navigate to correct page Url");
            AutomationLog.info("Facebook icon link navigates to Facebook Url");

            Assert.assertEquals(agorafyFacebook.currentPageTitle(), "Agorafy - New York, New York - Real Estate | Facebook","Agorafy Facebook Page does not show correct page title");
            AutomationLog.info("Agorafy Facebook Page shows correct page Title");

            switchToHomePage();
        }
        catch (Exception e)
        {
            AutomationLog.error("Either AgorafyFacebook page did not open successfully or AgorafyFacebook page verification failed" + e.getMessage());
        }
    }

    private void verifyAgorafyTwitterLink() throws Exception
    {
        try
        {
            agorafyTwitter = socialLinks.clickOnTwitterIconLink();
            AutomationLog.info("Agorafy Twitter Page opened successfully");

            switchToNewWindow();

            Assert.assertEquals(agorafyTwitter.currentURL(), agorafyTwitter.agorafyTwitterPageUrl(), "Twitter Icon Link did not navigate to correct page Url");
            AutomationLog.info("Twitter icon link navigates to Twitter Url");

            Assert.assertEquals(agorafyTwitter.currentPageTitle(), "Agorafy (@agorafy) | Twitter","Agorafy Twitter Page does not show correct page title");
            AutomationLog.info("Agorafy Twitter Page shows correct page Title");

            switchToHomePage();
        }
        catch (Exception e)
        {
            AutomationLog.error("Either AgorafyTwitter page did not open successfully or AgorafyTwitter page verification failed" + e.getMessage());
        }
    }

    private void switchToHomePage() throws Exception
    {
        Page.driver.close();
        Page.driver.switchTo().window(homePageHandle);
    }

    private void switchToNewWindow() throws Exception
    {
        List<String> newTab = new ArrayList<String>(Page.driver.getWindowHandles());
        newTab.remove(homePageHandle);
        Page.driver.switchTo().window(newTab.get(0));
        WaitFor.waitForPageToLoad(Page.driver);
    }

    @Override
    protected String successMessage()
    {
        return "Footer Social Networking Links tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Footer Social Links Action Failed";
    }
}