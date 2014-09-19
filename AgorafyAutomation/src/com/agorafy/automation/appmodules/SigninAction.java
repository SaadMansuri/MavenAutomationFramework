package com.agorafy.automation.appmodules;


import java.util.HashMap;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;

public class SigninAction  extends AutomationTestCase
{
    
    public void setup() 
    {
    	super.setup();
    }

    public void cleanup() 
    {
    	super.cleanup();
    }

    
    public void doLogin() throws Exception
    {
    	LoginPage loginpage = Homepage.gotoLoginPage();
        AutomationLog.info("Click action is perfromed on My login link");

        // Storing the UserName in to a String variable and Getting the
        // UserName from Test Data CSV
   /*     HashMap<String, String> loginData =  data.get("Deepak");
        String sUserName = loginData.get("userName");						*/
        // Sending the UserName string to the UserName Textbox on the LogIN
        // Page
        LoginPage.txtbx_UserName().sendKeys("chandrani.bhagat@cuelogic.co.in");

        // Printing the logs for what we have just performed
        AutomationLog.info("Username is entered in UserName text box");

        String sPassword = "";
        LoginPage.txtbx_Password().sendKeys("cuelogic77");
        AutomationLog.info("Password is entered in Password text box");

        LoginPage.btn_LogIn().click();
        AutomationLog.info("Click action is performed on Submit button");

        // Utils.waitForElement(Home_Page.lnk_LogOut());
        AutomationLog.info("SignIn Action is successfully perfomred");
        testcasePassed("SignIn Action is successfully perfomred");

    }
    
    
    public void Execute() throws Exception
    {
        // Clicking on the login link on the Home Page
        try {
        	setup();
        	doLogin();
        } 
        catch (Exception e) 
        {
            testcaseFailed("SignIn Action  Failed");
            throw(e);
        }
        finally 
        {
            cleanup();
        }
    }
}
