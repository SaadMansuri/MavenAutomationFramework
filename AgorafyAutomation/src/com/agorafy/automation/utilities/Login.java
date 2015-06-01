package com.agorafy.automation.utilities;


import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.automationframework.AutomationTestCase;

public class Login 
{

    public static Homepage doSuccessfullLoginFromHeaderLoginForm() throws Exception 
    {
        Homepage homepage = null;
        try
        {
            Header header = Header.header();
            HeaderLoginForm headerLoginForm = header.openHeaderLoginForm();
            AutomationLog.info("Log In link is clicked");
            WaitFor.sleepFor(2000);
            Credentials ValidCredentials = AutomationTestCase.userCredentials();
            homepage = headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
            AutomationLog.info("Login Successfull");
        }
        catch(Exception e)
        {
            AutomationLog.error("Login failed");
        }
        return homepage;
    }
}
