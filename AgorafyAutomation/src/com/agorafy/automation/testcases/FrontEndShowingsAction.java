package com.agorafy.automation.testcases;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.FrontEndShowings;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.MyListings;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

public class FrontEndShowingsAction extends AutomationTestCaseVerification
{

    private Header header;
    private HeaderLoginForm headerloginform;
    private Homepage homepage;
    private SubNavigation subnavigation = SubNavigation.subNavigation();
    private MyListings myListings;
    private FrontEndShowings frontendshowings;

	public FrontEndShowingsAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        header = Header.header();
        try
        {
            headerloginform = header.openHeaderLoginForm();
            Credentials credentials = userCredentials();
            homepage = headerloginform.doSuccessfulLogin(credentials.getEmail(), credentials.getPassword());
            WaitFor.presenceOfTheElement(Page.driver, homepage.getHomepageGreetingsLocator());
            myListings = subnavigation.clickLinkMyListings();
            WaitFor.sleepFor(10000);
        }
        catch(Exception e)
        {
            AutomationLog.error("Login failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
       verifyIfClickingScheduleNowLinkShowsShowingsPopUp();
    }

    public void verifyIfClickingScheduleNowLinkShowsShowingsPopUp() throws Exception
    {
        frontendshowings = myListings.clickOnShowingsLink("100 Maspeth Avenue");
        Assert.assertTrue(frontendshowings.popup_FrontEndShowings().isDisplayed(), "Expected FrontEnd Showings PopUp not shown");
        AutomationLog.info("Clicking schedule now link show login Popup");
        
    }

    @Override
    protected String successMessage()
    {
        return "passed";
    }

    @Override
    protected String failureMessage()
    {
        return "failed";
    }
}
