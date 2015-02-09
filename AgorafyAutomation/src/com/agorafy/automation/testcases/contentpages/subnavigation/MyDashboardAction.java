package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;
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
    private HeaderLoginForm headerLoginForm;
    private Dashboard myDashboardPage;
    private HashMap<String, String> expectedMyDashboardData;

    public MyDashboardAction() 
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        SubNavigation subnavigation = Page.subNavigation();
        homePage = Homepage.homePage();
        headerLoginForm = homePage.openHeaderLoginForm();
        Credentials ValidCredentials = userCredentials();
        homePage = headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
        WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
        myDashboardPage = subnavigation.clickLinkMyDashboard(); 
        expectedMyDashboardData = testCaseData.get("MyDashboard");
        expectedMyDashboardData.put("url", myDashboardPage.getURL());
        verifyLink(myDashboardPage, expectedMyDashboardData);

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
