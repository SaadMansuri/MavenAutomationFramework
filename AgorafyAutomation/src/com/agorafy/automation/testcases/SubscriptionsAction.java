package com.agorafy.automation.testcases;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.MySubscriptions;

public class SubscriptionsAction extends AutomationTestCaseVerification 
{

    private Homepage homePage;
    private HeaderLoginForm headerLoginForm;
    private MySubscriptions mySubscriptions;
    private Dashboard myDashboard;
    private String dropdownLoginAvatar;

    public SubscriptionsAction() 
    {
        super();
    }

    @Override
    public void setup()
    {
        try 
        {
            super.setup();
            homePage = Homepage.homePage();
            headerLoginForm = homePage.openHeaderLoginForm();
            Credentials ValidCredentials = userCredentials();
            homePage = headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed setup for Subscription test cases");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        

    }

    @Override
    protected String successMessage() 
    {
        return "Subscriptions page tested successfully";
    }

    @Override
    protected String failureMessage() 
    {
        return "Failed to test Subscriptions page";
    }
}
