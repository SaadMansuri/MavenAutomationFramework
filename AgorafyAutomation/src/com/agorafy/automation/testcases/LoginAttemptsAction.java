package com.agorafy.automation.testcases;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;
import com.agorafy.automation.pageobjects.Page;

public class LoginAttemptsAction extends AutomationTestCaseVerification
{
    protected Homepage homePage;
    protected LoginPage loginPage;
    protected HeaderLoginForm headerLogin;
    protected Header header;

    public LoginAttemptsAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        try
        {
            homePage = Homepage.homePage();
            header = Page.header();
            header = Header.header();
            headerLogin = header.openHeaderLoginForm();
            loginPage = headerLogin.doInvalidLogin("", "");
        }
        catch(Exception e)
        {
            AutomationLog.error("Error Logging In");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyCaptcha();
    }

    private void verifyCaptcha() throws Exception
    {
        int attempts = 1;
        while(attempts<10)
        {
            try
            {
                loginPage.doInvalidLogin("123", "123");
                attempts++;
            }
            catch(Exception e)
            {
                AutomationLog.error("Error Logging In");
            }
        }
        Assert.assertEquals(loginPage.isCaptchaPresent(), true, "Captcha is not seen after "+attempts);
    }

    @Override
    protected String successMessage()
    {
        return "Test for Captcha occurance after 10 login attempts Passed";
	}

    @Override
    protected String failureMessage()
    {
        return "Test for Captcha occurance after 10 login attempts Failed";
    }

}
