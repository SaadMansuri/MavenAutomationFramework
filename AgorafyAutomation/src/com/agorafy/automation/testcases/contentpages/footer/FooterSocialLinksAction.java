package com.agorafy.automation.testcases.contentpages.footer;

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
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

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

        expectedSocialLinksData = testCaseData.get("LinkedIn");
        Assert.assertEquals(agorafyLinkedIn.currentURL(),expectedSocialLinksData.get("agorafyLinkedInPageUrl"), "LinkedIn IconLink did not navigate to correct page Url");
        AutomationLog.info("LinkedIn IconLink navigates to AgorafyLinkedIn page Url");


        Assert.assertEquals(agorafyLinkedIn.currentPageTitle(),expectedSocialLinksData.get("title"), "Agorafy LinkedIn Page does not show correct page title");
        AutomationLog.info("Agorafy LinkedIn Page shows correct page Title");

        AutomationLog.info("Agorafy LinkedIn Page is correctly loaded");
        switchToHomePage();
    }

    private void verifyAgorafyGooglePlusLink() throws Exception
    {
        AgorafyGooglePlusPage agorafyGooglePlus = socialLinks.clickOnGooglePlusIconLink();
        switchToNewWindow();

        expectedSocialLinksData = testCaseData.get("GooglePlus");
        Assert.assertEquals(agorafyGooglePlus.currentURL(),expectedSocialLinksData.get("agorafyGooglePlusPageUrl"), "GooglePlus IconLink did not navigate to correct page Url");
        AutomationLog.info("GooglePlus IconLink navigates to AgorafyGooglePlus page Url");


        Assert.assertEquals(agorafyGooglePlus.currentPageTitle(),expectedSocialLinksData.get("title"), "Agorafy GooglePlus Page does not show correct page title");
        AutomationLog.info("Agorafy GooglePlus Page shows correct page Title");

        AutomationLog.info("Agorafy Google Plus Page is correctly loaded");
        switchToHomePage();
    }

    private void verifyAgorafyYoutubeLink() throws Exception
    {
        AgorafyYoutubePage agorafyYoutube = socialLinks.clickOnYoutubeIconLink();
        switchToNewWindow();

        expectedSocialLinksData = testCaseData.get("Youtube");
        Assert.assertEquals(agorafyYoutube.currentURL(),expectedSocialLinksData.get("agorafyYoutubePageUrl"), "YouTube IconLink did not navigate to correct page Url");
        AutomationLog.info("Youtube IconLink navigates to AgorafyYoutube page Url");

        Assert.assertEquals(agorafyYoutube.currentPageTitle(),expectedSocialLinksData.get("title"), "Agorafy Youtube Page does not show correct page title");
        AutomationLog.info("Agorafy Youtube Page shows correct page Title");

        AutomationLog.info("Agorafy Youtube Page is correctly loaded");
        switchToHomePage();
    }

    private void verifyAgorafyFacebookLink() throws Exception
    {
        AgorafyFacebookPage agorafyFacebook = socialLinks.clickOnFacebookIconLink();
        switchToNewWindow();

        expectedSocialLinksData = testCaseData.get("Facebook");
        Assert.assertEquals(agorafyFacebook.currentURL(),expectedSocialLinksData.get("agorafyFacebookPageUrl"), "Facebook IconLink did not navigate to correct page Url");
        AutomationLog.info("Facebook IconLink navigates to AgorafyFacebook page Url");


        Assert.assertEquals(agorafyFacebook.currentPageTitle(),expectedSocialLinksData.get("title"), "Agorafy Facebook Page does not show correct page title");
        AutomationLog.info("Agorafy Facebook Page shows correct page Title");

        AutomationLog.info("Agorafy Facebook Page is correctly loaded");
        switchToHomePage();
    }

    private void verifyAgorafyTwitterLink() throws Exception
    {
        AgorafyTwitterPage agorafyTwitter = socialLinks.clickOnTwitterIconLink();
        switchToNewWindow();

        expectedSocialLinksData = testCaseData.get("Twitter");
        Assert.assertEquals(agorafyTwitter.currentURL(),expectedSocialLinksData.get("agorafyTwitterPageUrl"), "Twitter IconLink did not navigate to correct page Url");
        AutomationLog.info("Twitter IconLink navigates to AgorafyTwitter page Url");


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
        return "Social Networking IconLinks on Footer tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Social Networking IconLinks Test Failed";
    }
}