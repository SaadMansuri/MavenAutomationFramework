package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.MyListings;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;
import com.agorafy.automation.utilities.Login;

public class SubnavigationMyListingAction extends ContentPagesVerification
{
    private SubNavigation subnavigation;
    private Homepage homePage;
    private MyListings myListings;
    private HashMap<String, String> expectedmyListingsData;
    private ContentPagesLeftMenu leftMenu;

	public SubnavigationMyListingAction()
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();
        try 
        {
        subnavigation = Page.subNavigation();
        homePage = Login.doSuccessfullLoginFromHeaderLoginForm();
        WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
        myListings = subnavigation.clickLinkMyListings(); 
        expectedmyListingsData = testCaseData.get("MyListings");
        Page.urlStatus = false;
        String url = myListings.getApplicationurl() + expectedmyListingsData.get("myListingsPageUrl");
        expectedmyListingsData.put("url", url);
        AutomationLog.info("Redirection to MyListing is sucessfull");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Redirection to MyListing is failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyLink(myListings, expectedmyListingsData);

        AutomationLog.info("Testing whether My Listings link is active in left side started...");
        verifyLeftMenu();
    }

    public void verifyLeftMenu() throws Exception 
    {
        String actualActiveLeftMenu;
        String expectedActiveLeftMenu;
        leftMenu = Page.contentPagesLeftMenu();
        actualActiveLeftMenu = leftMenu.getCurrentlyActiveLink();
        expectedActiveLeftMenu = leftMenu.MyListingsLinkText();  
        Assert.assertEquals(actualActiveLeftMenu, expectedActiveLeftMenu,"Left menu does not show My Listings link as Active Link");
        AutomationLog.info("Left menu shows My Listings link as Active Link");
    }

    @Override
    protected String successMessage()
    {
        return "Sucessfully tested My Listing page";
    }

    @Override
    protected String failureMessage()
    {
        return "Failed to test My listing page";
    }

}
