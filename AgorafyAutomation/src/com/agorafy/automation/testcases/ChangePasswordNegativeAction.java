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
import com.agorafy.automation.pageobjects.Page;

public class ChangePasswordNegativeAction extends AutomationTestCase 
    {
        private Homepage homePage = null;
        private HeaderLoginForm headerLoginForm = null;

        public ChangePasswordNegativeAction() 
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
        // Verify this is the correct homepage.
        WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
        Header header = homePage.header();
        header.openActiveProfile();
        // Verify Drowndown is displayed.
        Dashboard dashboard = header.openDashboard();
        AccountSettings accountSettings = dashboard.accountSettings();
        ChangePasswordTab changePasswordTab = accountSettings.clickOnChangePasswordTab();
          
        // Verify this is the correct OverviewTab tab.
        populateAndVerifyChangePasswordDetails(changePasswordTab);
        verifyOldPassowrdLeftBlank(changePasswordTab);
        verifyNewPassowrdLeftBlank(changePasswordTab);
        verifyRetypeNewPasswordLeftBlank(changePasswordTab);
        verifyIfWrongOldPasswordEntered(changePasswordTab);
        verifyIfNewAndRetypeNewPasswordIsLessThenEightChar(changePasswordTab);
        verifyIfNewpasswordAndRetypeNewpasswordAreNotSame(changePasswordTab);
        testcasePassed("Invalid Test Cases Change Password Action perfomed successfully.");
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
        AutomationLog.error("InValid Test Cases Change Password Action  Failed: " + message);
        throw (new Exception("InValid Test Cases Change Password Action  Failed" + message));
    }
public void populateAndVerifyChangePasswordDetails(ChangePasswordTab changePasswordTab) throws Exception
   {
        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();
          
        String oldErrorPasswordMessage = changePasswordTab.errorMessageOldPassword().getText();
        Assert.assertEquals(oldErrorPasswordMessage, "* This field is required\n* Invalid Password", "The proper error messgae for old password is not displayed ");
        AutomationLog.info("The appropriate error message for old password is dispalyed when no input is provided");
         
        String newErrorPasswordMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(newErrorPasswordMessage, "* This field is required\n* Minimum 8 characters required\n* Invalid Password" , "The proper error messgae for new password is not displayed ");
        AutomationLog.info("The appropriate error message for new password is dispalyed when no input is provided");

        String retypeNewErrorPasswordMessage=changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(retypeNewErrorPasswordMessage, "* This field is required" , "The proper error messgae for retype new password is not displayed");
        AutomationLog.info("The appropriate error message for retype new password is displayed when no input is provided");
    }

public void verifyOldPassowrdLeftBlank(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();
        changepassworddata.setOldPassword("");
        changepassworddata.setNewPassword("12345678a");
        changepassworddata.setRetypeNewPassword("12345678a");
        changePasswordTab.populateChangePasswordData(changepassworddata);
          
        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String newErrorOldMesagePassword = changePasswordTab.errorMessageOldPassword().getText();
        Assert.assertEquals(newErrorOldMesagePassword, "* This field is required\n* Invalid Password", "The proper error messgae for new password is not displayed when OldPassword is left empty");
        AutomationLog.info("The appropriate error message for old password is dispalyed when other text fields are entered");
    }

public void verifyNewPassowrdLeftBlank(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();
        changepassworddata.setOldPassword("anjan991");
        changepassworddata.setNewPassword("");
        changepassworddata.setRetypeNewPassword("anjan995@");
        changePasswordTab.populateChangePasswordData(changepassworddata);
          
        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifynewPasswordErrorMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(verifynewPasswordErrorMessage, "* This field is required\n* Minimum 8 characters required\n* Invalid Password", "The proper error messgae for new password is not displayed when NewPassword is left empty" );
        AutomationLog.info("The appropriate error message for New password is dispalyed when other text fields are entered");
          
        String verifyretypeNewPasswordErrorMessage = changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(verifyretypeNewPasswordErrorMessage,  "* Fields do not match" , "The proper error messgae for new password is not displayed when NewPassword is left empty" );
        AutomationLog.info("The appropriate error message for Retype New password is dispalyed when other text fields are entered");
    }

public void verifyRetypeNewPasswordLeftBlank(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();
        changepassworddata.setOldPassword("anjan9195");
        changepassworddata.setNewPassword("anj101195@");
        changepassworddata.setRetypeNewPassword("");
        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifyNewPassworderrorMessage = changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(verifyNewPassworderrorMessage, "* This field is required\n* Fields do not match", "The proper error messgae for Retype new password is not displayed when NewPassword is left empty" );
        AutomationLog.info("The appropriate error message for Retype New password is dispalyed when other text fields are entered");
    }

public void verifyIfWrongOldPasswordEntered(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();
        changepassworddata.setOldPassword("anjan991");
        changepassworddata.setNewPassword("");
        changepassworddata.setRetypeNewPassword("");
        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifyNewPasswordMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(verifyNewPasswordMessage, "* This field is required\n* Minimum 8 characters required\n* Invalid Password", "The proper error messgae for  new password is not displayed when OldPassword is entered wrong");
        AutomationLog.info("The appropriate error message for New password is dispalyed when Old password is Entered wrong");
         
        String verifyRetypeNewPassword = changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(verifyRetypeNewPassword, "* This field is required", "The proper error messgae for Retype new password is not displayed when OldPassword is entered wrong" );
        AutomationLog.info("The appropriate error message for Retype New password is dispalyed when Old password is Entered wrong");
    }

public void verifyIfNewAndRetypeNewPasswordIsLessThenEightChar(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();
        changepassworddata.setOldPassword("");
        changepassworddata.setNewPassword("anjan1");
        changepassworddata.setRetypeNewPassword("anjan1");
        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifyOldPasswordMessage = changePasswordTab.errorMessageOldPassword().getText();
        Assert.assertEquals(verifyOldPasswordMessage, "* This field is required\n* Invalid Password", "The proper error messgae for Old password is not displayed when new password and Retype New Password is less than eight Character");
        AutomationLog.info("The appropriate error message for Old password is dispalyed when New Password And retype New Password is less then Eight Character");

        String verifyNewPasswordMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(verifyNewPasswordMessage, "* Minimum 8 characters required", "The proper error messgae for New password is not displayed when new password and Retype New Password is less than eight Character");
        AutomationLog.info("The appropriate error message for New password is dispalyed when New Password And retype New Password is less then Eight Character");
    }

public void verifyIfNewpasswordAndRetypeNewpasswordAreNotSame(ChangePasswordTab changePasswordTab) throws Exception
    {
        ChangePasswordData changepassworddata = new ChangePasswordData();
        changepassworddata.setOldPassword("");
        changepassworddata.setNewPassword("anjan1");
        changepassworddata.setRetypeNewPassword("anjan2");
        changePasswordTab.populateChangePasswordData(changepassworddata);

        changePasswordTab = changePasswordTab.clickOnSubmitButtonChangePassword();

        String verifyOldPasswordMessage = changePasswordTab.errorMessageOldPassword().getText();
        Assert.assertEquals(verifyOldPasswordMessage, "* This field is required\n* Invalid Password", "The proper error messgae for Old password is not displayed when new password and Retype New Password is not same");
        AutomationLog.info("The appropriate error message for Old password is dispalyed when New Password And retype New Password is not same");

        String verifyNewPasswordMessage = changePasswordTab.errorMessageNewPassword().getText();
        Assert.assertEquals(verifyNewPasswordMessage, "* Minimum 8 characters required", "The proper error messgae for New password is not displayed when new password and Retype New Password is not same");
        AutomationLog.info("The appropriate error message for New password is dispalyed when New Password And retype New Password is not same");

        String verifyRetypeNewPasswordMessage = changePasswordTab.errorRetypeNewPassword().getText();
        Assert.assertEquals(verifyRetypeNewPasswordMessage, "* Fields do not match", "The proper error messgae for Retype New password is not displayed when new password and Retype New Password is not same");
        AutomationLog.info("The appropriate error message for Retype New password is dispalyed when New Password And retype New Password is not same");
    }
    }

