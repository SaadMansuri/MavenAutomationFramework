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
/**
 * Test whether 'My Listings' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 *
 */
public class MyListingsAction extends ContentPagesVerification 
{

    private Homepage homePage;
    private MyListings myListingsPage;
    private HashMap<String, String> expectedmyListingsData;
    private SubNavigation subnavigation;
    private ContentPagesLeftMenu leftMenu;
    private String actualActiveLeftMenu;
    private String expectedActiveLeftMenu;

    public MyListingsAction() 
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
        myListingsPage = subnavigation.clickLinkMyListings(); 
        expectedmyListingsData = testCaseData.get("MyListings");
        String url = myListingsPage.getApplicationUrl() + expectedmyListingsData.get("myListingsPageUrl");
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

       verifyLink(myListingsPage, expectedmyListingsData);

        AutomationLog.info("Testing whether My Listings link is active in left side started...");
        verifyLeftMenu();
    }

    private void verifyLeftMenu() throws Exception 
    {
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
