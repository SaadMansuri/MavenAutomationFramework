package com.agorafy.automation.testcases.footer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterSocialLinks;
import com.agorafy.automation.pageobjects.footer.social.AgorafyFacebookPage;
import com.agorafy.automation.pageobjects.footer.social.AgorafyGooglePlusPage;
import com.agorafy.automation.pageobjects.footer.social.AgorafyLinkedInPage;
import com.agorafy.automation.pageobjects.footer.social.AgorafyTwitterPage;
import com.agorafy.automation.pageobjects.footer.social.AgorafyYoutubePage;
import com.agorafy.automation.testcases.ContentPagesVerification;

/**
 * Test SocialNetworking IconLinks on Footer
 * Click Twitter iconlink on the Home Page, verify AgorafyTwitter Page is loaded by checking its URL and title
 * Click Facebook iconlink on the Home Page, verify AgorafyFacebook Page is loaded by checking its URL and title 
 * Click GooglePlus iconlink on the Home Page, verify AgorafyGooglePlus Page is loaded by checking its URL and title
 * Click Youtube iconlink on the Home Page, verify AgorafyYoutube Page is loaded by checking its URL and title
 * Click LinkedIn iconlink on the Home Page, verify AgorafyLinkedIn Page is loaded by checking its URL and title
 */
public class FooterSocialLinksAction extends ContentPagesVerification
{
    String homePageHandle = "";
    FooterSocialLinks socialLinks = null;
    HashMap<String, String> expectedSocialLinksData = null;

    public FooterSocialLinksAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        socialLinks = Page.footer().socialLinks();
        homePageHandle = Page.driver.getWindowHandle();
        verifyAgorafyTwitterLink();
        verifyAgorafyFacebookLink();
        verifyAgorafyYoutubeLink();
        verifyAgorafyGooglePlusLink();
        verifyAgorafyLinkedInLink();
    }

    private void verifyAgorafyLinkedInLink() throws Exception
    {
        AgorafyLinkedInPage agorafyLinkedIn = socialLinks.clickOnLinkedInIconLink();
        switchToNewWindow();

        Assert.assertEquals(agorafyLinkedIn.currentURL(),agorafyLinkedIn.agorafyLinkedInPageUrl(), "LinkedIn Icon Link did not navigate to correct page Url");
        AutomationLog.info("LinkedIn icon link navigates to LinkedIn Url");

        expectedSocialLinksData = testCaseData.get("LinkedIn");
        Assert.assertEquals(agorafyLinkedIn.currentPageTitle(),expectedSocialLinksData.get("title"), "Agorafy LinkedIn Page does not show correct page title");
        AutomationLog.info("Agorafy LinkedIn Page shows correct page Title");

        AutomationLog.info("Agorafy LinkedIn Page is correctly loaded");
        switchToHomePage();
    }

    private void verifyAgorafyGooglePlusLink() throws Exception
    {
        AgorafyGooglePlusPage agorafyGooglePlus = socialLinks.clickOnGooglePlusIconLink();
        switchToNewWindow();

        Assert.assertEquals(agorafyGooglePlus.currentURL(),agorafyGooglePlus.agorafyGooglePlusPageUrl(), "GooglePlus Icon Link did not navigate to correct page Url");
        AutomationLog.info("GooglePlus icon link navigates to GooglePlus Url");

        expectedSocialLinksData = testCaseData.get("GooglePlus");
        Assert.assertEquals(agorafyGooglePlus.currentPageTitle(),expectedSocialLinksData.get("title"), "Agorafy GooglePlus Page does not show correct page title");
        AutomationLog.info("Agorafy GooglePlus Page shows correct page Title");

        AutomationLog.info("Agorafy Google Plus Page is correctly loaded");
        switchToHomePage();
    }

    private void verifyAgorafyYoutubeLink() throws Exception
    {
        AgorafyYoutubePage agorafyYoutube = socialLinks.clickOnYoutubeIconLink();
        switchToNewWindow();

        Assert.assertEquals(agorafyYoutube.currentURL(),agorafyYoutube.agorafyYoutubePageUrl(), "YouTube Icon Link did not navigate to correct page Url");
        AutomationLog.info("Youtube icon link navigates to Youtube Url");

        expectedSocialLinksData = testCaseData.get("Youtube");
        Assert.assertEquals(agorafyYoutube.currentPageTitle(),expectedSocialLinksData.get("title"), "Agorafy Youtube Page does not show correct page title");
        AutomationLog.info("Agorafy Youtube Page shows correct page Title");

        AutomationLog.info("Agorafy Youtube Page is correctly loaded");
        switchToHomePage();
    }

    private void verifyAgorafyFacebookLink() throws Exception
    {
        AgorafyFacebookPage agorafyFacebook = socialLinks.clickOnFacebookIconLink();
        switchToNewWindow();

        Assert.assertEquals(agorafyFacebook.currentURL(),agorafyFacebook.agorafyFacebookPageUrl(), "Facebook Icon Link did not navigate to correct page Url");
        AutomationLog.info("Facebook icon link navigates to Facebook Url");

        expectedSocialLinksData = testCaseData.get("Facebook");
        Assert.assertEquals(agorafyFacebook.currentPageTitle(),expectedSocialLinksData.get("title"), "Agorafy Facebook Page does not show correct page title");
        AutomationLog.info("Agorafy Facebook Page shows correct page Title");

        AutomationLog.info("Agorafy Facebook Page is correctly loaded");
        switchToHomePage();
    }

    private void verifyAgorafyTwitterLink() throws Exception
    {
        AgorafyTwitterPage agorafyTwitter = socialLinks.clickOnTwitterIconLink();
        switchToNewWindow();

        Assert.assertEquals(agorafyTwitter.currentURL(),agorafyTwitter.agorafyTwitterPageUrl(), "Twitter Icon Link did not navigate to correct page Url");
        AutomationLog.info("Twitter icon link navigates to Twitter Url");

        expectedSocialLinksData = testCaseData.get("Twitter");
        Assert.assertEquals(agorafyTwitter.currentPageTitle(),expectedSocialLinksData.get("title"), "Agorafy Twitter Page does not show correct page title");
        AutomationLog.info("Agorafy Twitter Page shows correct page Title");

        AutomationLog.info("Agorafy Twitter Page is correctly loaded");
        switchToHomePage();
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