package com.agorafy.automation.testcases;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.ChangePasswordData;
import com.agorafy.automation.pageobjects.AccountSettings;
import com.agorafy.automation.pageobjects.ChangePasswordTab;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;
import com.agorafy.automation.pageobjects.Page;

public class ChangePasswordPositiveAction extends AutomationTestCase
    {
        private Homepage homePage = null;
        private HeaderLoginForm headerLoginForm;
        public ChangePasswordPositiveAction() 
    {
        super();
    }
public void setup() 
    {
        super.setup();
        homePage = Homepage.homePage();
    }
public void cleanup()
    {
        super.cleanup();
    }
      
public void Execute() throws Exception
    {
        try
    {
        setup();
     // TODO: get this from CSV data.
        headerLoginForm = homePage.openHeaderLoginForm();
        homePage = headerLoginForm.doSuccessfulLogin("chandrani.bhagat@cuelogic.co.in", "cuelogic77");
      //Verify this is the correct homepage.
        WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
        Header header = homePage.header();
        header.openActiveProfile();
     // Verify Drowndown is displayed.
        Dashboard dashboard = header.openDashboard();
        AccountSettings accountSettings = dashboard.accountSettings();
        ChangePasswordTab changePasswordTab = accountSettings.clickOnChangePasswordTab();
        verifyIfAllTheValidFieldsAreEntered(changePasswordTab);
     // Verify this is the correct OverviewTab tab.
        testcasePassed("Valid test Cases Change Password Action perfomed successfully.");
    } 
        catch (Exception e) 
    {
        handleTestCaseFailure(e.getMessage());
    }
        catch(Throwable throwable)
    {
        handleTestCaseFailure(throwable.getMessage());
    }
        finally 
    {
        cleanup();
    }
    }
private void handleTestCaseFailure(String message) throws Exception 
    {
        AutomationLog.error("Valid Test Cases Change Password Action  Failed: " + message);
        throw (new Exception("Valid Test Cases Change Password Action  Failed" + message));
    }
      
public void verifyIfAllTheValidFieldsAreEntered(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();
        changepassworddata.setOldPassword("cuelogic77");
        changepassworddata.setNewPassword("cuelogic");
        changepassworddata.setRetypeNewPassword("cuelogic");
        changePasswordTab.populateChangePasswordData(changepassworddata);
            
        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();
        String verifySuccesfullPasswordMessage = changePasswordTab.passwordChangedSuceessfully().getText();
        Assert.assertEquals(verifySuccesfullPasswordMessage, "Your password has been changed.", "Password not Changed successfully when valid credentials are entered");
        AutomationLog.info("The Password Changed successfully when all the Valid Credintials Are Entered");
    }
    }
