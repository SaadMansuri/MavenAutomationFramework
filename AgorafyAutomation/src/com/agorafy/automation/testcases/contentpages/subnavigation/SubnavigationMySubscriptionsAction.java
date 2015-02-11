package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.MySubscriptions;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;
/**
 * Test whether 'MySubscriptions' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 *
 */
public class SubnavigationMySubscriptionsAction extends ContentPagesVerification
{

    private Homepage homePage;
    private HeaderLoginForm headerLoginForm;
    private MySubscriptions mySubscriptionsPage;
    private HashMap<String, String> expectedMySubscriptionsData;
    private SubNavigation subnavigation;
	private ContentPagesLeftMenu leftMenu;
	private String actualActiveLeftMenu;
	private String expectedActiveLeftMenu;

    public SubnavigationMySubscriptionsAction() 
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        subnavigation = Page.subNavigation();
        homePage = Homepage.homePage();
        headerLoginForm = homePage.openHeaderLoginForm();
        Credentials ValidCredentials = userCredentials();
        homePage = headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
        WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
        mySubscriptionsPage = subnavigation.clickLinkMySubscriptions(); 
        expectedMySubscriptionsData = testCaseData.get("MySubscriptions");
        expectedMySubscriptionsData.put("url", mySubscriptionsPage.getURL());
        verifyLink(mySubscriptionsPage, expectedMySubscriptionsData);

        AutomationLog.info("verification of whether My Subscription link is active in left side started...");
        verifyLeftMenu();
    }

    private void verifyLeftMenu() throws Exception 
    {
        leftMenu = Page.contentPagesLeftMenu();
        actualActiveLeftMenu = leftMenu.getCurrentlyActiveLink();
        expectedActiveLeftMenu = leftMenu.MySubscriptionsLinkText();  
        Assert.assertEquals(actualActiveLeftMenu, expectedActiveLeftMenu,"Left menu does not show My Subscriptions link as Active Link");
        AutomationLog.info("Left menu shows My Subscriptions link as Active Link");
    }

    @Override
    protected String successMessage() 
    {
        return "Sucessfully tested Subnavigation My Subscriptions Action";
    }

    @Override
    protected String failureMessage() 
    {
        return "Failed to test Subnavigation My Subscriptions Action";
    }

}
