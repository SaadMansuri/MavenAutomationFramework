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
    }

    private void verifyLeftMenu() throws Exception 
    {
        leftMenu = Page.contentPagesLeftMenu();
        actualActiveLeftMenu = leftMenu.getCurrentlyActiveLink();
        expectedActiveLeftMenu = leftMenu.MyDashboardLinkText();  
        Assert.assertEquals(actualActiveLeftMenu, expectedActiveLeftMenu,"Left menu does not show My Dashboard link as Active Link");
        AutomationLog.info("Left menu shows My Dashboard link as Active Link");
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
