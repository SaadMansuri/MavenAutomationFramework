package com.agorafy.automation.testcases.contentpages.subnavigation;

 import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;
import com.agorafy.automation.utilities.Login;
/**
 * Test whether 'My Dashboard' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 *
 */
public class MyDashboardAction extends ContentPagesVerification
{

    private Homepage homePage;
    private Dashboard myDashboardPage;
    private HashMap<String, String> expectedMyDashboardData;
	private ContentPagesLeftMenu leftMenu;
	private String actualActiveLeftMenu;
	private String expectedActiveLeftMenu;

    public MyDashboardAction() 
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();
        try 
        {
            homePage = Login.doSuccessfullLoginFromHeaderLoginForm();
            SubNavigation subnavigation = Page.subNavigation();
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            myDashboardPage = subnavigation.clickLinkMyDashboard(); 
            expectedMyDashboardData = testCaseData.get("MyDashboard");
            Page.urlStatus = false;
            String url = myDashboardPage.getApplicationURL() + expectedMyDashboardData.get("myDashboardPageUrl");
            expectedMyDashboardData.put("url", url);
            AutomationLog.info("Redirecting to My Dashboard page sucessfull");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Redirecting to My Dashboard page failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        verifyLink(myDashboardPage, expectedMyDashboardData);

        AutomationLog.info("Testing whether My Dashboard link is active in left side started...");
        verifyLeftMenu();

        verifyLeftMenuSessionExpireTestCases();
    }

    private void verifyLeftMenu() throws Exception 
    {
        leftMenu = Page.contentPagesLeftMenu();
        actualActiveLeftMenu = leftMenu.getCurrentlyActiveLink();
        expectedActiveLeftMenu = leftMenu.MyDashboardLinkText();  
        Assert.assertEquals(actualActiveLeftMenu, expectedActiveLeftMenu,"Left menu does not show My Dashboard link as Active Link");
        AutomationLog.info("Left menu shows My Dashboard link as Active Link");
    }

    public void verifyLeftMenuSessionExpireTestCases() throws Exception 
    {
        verifySessionExpireOnMyListingsLink();
        verifySessionExpireOnMySubscriptionsLink();
        verifySessionExpireOnEditProfileLink();
        verifySessionExpireOnAccountSettingsLink();
        verifyOnSubmitListingLinkSessionExpire();
    }

    public void verifySessionExpireOnMyListingsLink() throws Exception
    {
        String pageurl = Page.driver.getCurrentUrl();
        Page.driver.manage().deleteCookieNamed("PHPSESSID");
        myDashboardPage.clickOnMyListingsLink();
        WaitFor.sleepFor(2000);
        Page.urlStatus = true;
        String expectedUrl = myDashboardPage.getApplicationurl() + expectedMyDashboardData.get("loginUrl");
        Assert.assertEquals(myDashboardPage.getCurrentUrl(), expectedUrl, "Expected page is not shown");
        AutomationLog.info("Clicking My Listings link After Session Expire redirects to Login page");
        WaitFor.sleepFor(2000);
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
    }

    public void verifySessionExpireOnMySubscriptionsLink() throws Exception
    {
        String pageurl = Page.driver.getCurrentUrl();
        Page.driver.manage().deleteCookieNamed("PHPSESSID");
        myDashboardPage.clickOnMySubscriptionsLink();
        WaitFor.sleepFor(2000);
        Page.urlStatus = true;
        String expectedUrl = myDashboardPage.getApplicationurl() + expectedMyDashboardData.get("loginUrl");
        Assert.assertEquals(myDashboardPage.getCurrentUrl(), expectedUrl, "Expected page is not shown");
        AutomationLog.info("Clicking My Subscription link After Session Expire redirects to Login page");
        WaitFor.sleepFor(2000);
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
    }

    public void verifySessionExpireOnEditProfileLink() throws Exception
    {
        String pageurl = Page.driver.getCurrentUrl();
        Page.driver.manage().deleteCookieNamed("PHPSESSID");
        myDashboardPage.link_EditProfile().click();
        WaitFor.sleepFor(2000);
        Page.urlStatus = true;
        String expectedUrl = myDashboardPage.getApplicationurl() + expectedMyDashboardData.get("loginUrl");
        Assert.assertEquals(myDashboardPage.getCurrentUrl(), expectedUrl, "Expected page is not shown");
        AutomationLog.info("Clicking Edit Profile link After Session Expire redirects to Login page");
        WaitFor.sleepFor(2000);
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
    }

    public void verifySessionExpireOnAccountSettingsLink() throws Exception 
    {
        String pageurl = Page.driver.getCurrentUrl();
        Page.driver.manage().deleteCookieNamed("PHPSESSID");
        myDashboardPage.link_AccountSettings().click();
        WaitFor.sleepFor(2000);
        Page.urlStatus = true;
        String expectedUrl = myDashboardPage.getApplicationurl() + expectedMyDashboardData.get("loginUrl");
        Assert.assertEquals(myDashboardPage.getCurrentUrl(), expectedUrl, "Expected page is not shown");
        AutomationLog.info("Clicking Account Settings link After Session Expire redirects to Login page");
        WaitFor.sleepFor(2000);
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
    }

    public void verifyOnSubmitListingLinkSessionExpire() throws Exception
    {
        String pageurl = Page.driver.getCurrentUrl();
        Page.driver.manage().deleteCookieNamed("PHPSESSID");
        myDashboardPage.clickOnSubmitListingButton();
        WaitFor.sleepFor(2000);
        Page.urlStatus = true;
        String expectedUrl = myDashboardPage.getApplicationurl() + expectedMyDashboardData.get("loginUrl");
        Assert.assertEquals(myDashboardPage.getCurrentUrl(), expectedUrl, "Expected page is not shown");
        AutomationLog.info("Clicking Submit Listing link After Session Expire redirects to Login page");
        WaitFor.sleepFor(2000);
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
    }

    @Override
    protected String successMessage() 
    {
        return "Tested My Dashboard sucessfully";
    }

    @Override
    protected String failureMessage() 
    {
        return "Failed to test My Dashboard";
    }

}
