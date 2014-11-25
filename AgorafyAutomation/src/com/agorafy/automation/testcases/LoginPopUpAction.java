package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPopUp;
import com.agorafy.automation.pageobjects.SignUp;

public class LoginPopUpAction extends AutomationTestCaseVerification
{
    private SignUp signup=null;
    private Header header=null;
    private Homepage homepage=null;
    private LoginPopUp loginpopup=null;

    public LoginPopUpAction()  
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();

        try
        {
            header=Homepage.header();
            signup=header.clickOnSignUpUpLink();
            loginpopup=signup.clickOnLoginLink();
            //WaitFor.presenceOfTheElement(Page.driver, loginpopup.getLoginPopUpLocator());
        }
        catch(Exception e)
        {
            AutomationLog.error("could not navigate to login pop up");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        HashMap<String, String> getvalidcrendial = testCaseData.get("validCredential");
        verifyIfHomePageIsShownOnSuccessfullLogin(loginpopup,getvalidcrendial);
    }

    public void verifyIfHomePageIsShownOnSuccessfullLogin(LoginPopUp loginpopup, HashMap<String, String> getvalidcrendial) throws Exception
    {
        try
        {
            homepage=loginpopup.populateLoginPopUpData(getvalidcrendial.get("username"),getvalidcrendial.get("password"));
            Assert.assertEquals(homepage.currentURL(),homepage.homepageUrl(),"unsuccessfull login" );
            AutomationLog.info("expected page is loaded after login");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not navigate to login pop up");
        }
    }

    @Override
    protected String successMessage()
    {
        return "loginpopup test case passed";
    }

    @Override
    protected String failureMessage()
    {
        return "loginpopup test case failed";
    }
}
