package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.Reports;
import com.agorafy.automation.pageobjects.ReportsPopUp;
import com.agorafy.automation.pageobjects.SearchResultsPage;

public class ReportsPopUpAction extends AutomationTestCaseVerification
{
    private Header header;
    private HeaderLoginForm headerLoginForm;
    private Homepage homePage;
    private SearchResultsPage searchresult;
    private Reports reports;
    private ReportsPopUp reportspopup;
    HashMap<String, String> emaildata;
    HashMap<String, String> phonedata;


	public ReportsPopUpAction() 
    {
        super();
    }

    @Override public void setup() 
    {
        super.setup();
        try
        {
            header = Header.header();
            headerLoginForm = header.openHeaderLoginForm();
            Credentials ValidCredentials = userCredentials();
            homePage = headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            HashMap<String, String> search = testCaseData.get("SearchData");
            searchresult = homePage.populateSearchTermTextBox(search.get("borough"), search.get("listingcategory"), search.get("searchterm"));
            for(int i=0;i<3;i++)
            {
                searchresult.hoverOnSearchResult(i);
                searchresult.hoverAndClickOnPincushionIcon(i);
            }
            header.clickOnProfileNameDropdownArrow();
            reports = header.clickOnReportsLink();
            WaitFor.sleepFor(2000);
            reportspopup = reports.clickOnPrintLink();
            AutomationLog.info("Successfully navigated to Reports PopUp ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to Reports PopUp");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        phonedata = testCaseData.get("InvalidPhone");
        emaildata = testCaseData.get("InvalidEmail");
        verifyIfNameFieldIsEmpty();
        verifyIfPhoneFieldIsEmpty();
        verifyIfEmailFieldIsEmpty();
        verifyIfInvalidPhoneIsEntered(phonedata);
        verifyIfBothPhoneAndEmailFieldsAreEmpty();
        verifyIfInvalidEmailIsEntered(emaildata);
    }

    public void verifyIfNameFieldIsEmpty() throws Exception
    {
        reportspopup.txtbx_Name().clear();
        reportspopup.clickOnSelectButtonForCustomizedReports();
        Assert.assertTrue(reportspopup.msg_NameError().isDisplayed(), "Expected Name Error message is not shown");
        AutomationLog.info("Error message shown if Name field is empty ");
    }

    public void verifyIfPhoneFieldIsEmpty() throws Exception
    {
          reportspopup.txtbx_Phone().clear();
          reportspopup.clickOnSelectButtonForCustomizedReports();
          Assert.assertFalse(reportspopup.isPhoneAndEmailErrorMsgPresent(), "Expected Error message for Phone Field is not shown");
          AutomationLog.info("Error message not shown if Only Phone field is empty ");
    }

    public void verifyIfEmailFieldIsEmpty() throws Exception 
    {
        reportspopup.txtbx_Phone().sendKeys("213-555-5555");
        reportspopup.txtbx_Email().clear();
        reportspopup.clickOnSelectButtonForCustomizedReports();
        Assert.assertFalse(reportspopup.isPhoneAndEmailErrorMsgPresent(), "Expected Email Error message is not shown");
        AutomationLog.info("Error message not shown if Only Email field is entered ");
    }

    public void verifyIfInvalidPhoneIsEntered(HashMap<String, String> phonedata) throws Exception 
    {
        for(int i=1;i<=3;i++)
        {
            String phno = "phone"+i;
            reportspopup.txtbx_Phone().clear();
            reportspopup.txtbx_Phone().sendKeys(phonedata.get(phno));
            reportspopup.clickOnSelectButtonForCustomizedReports();
            Assert.assertTrue(reportspopup.msg_InvalidPhone().isDisplayed(), "Expected Phone error message not shown");
        }
            AutomationLog.info("Error message is shown if Invalid phone combination is entered");
    }

    public void verifyIfBothPhoneAndEmailFieldsAreEmpty() throws Exception
    {
        reportspopup.txtbx_Phone().clear();
        reportspopup.txtbx_Email().clear();
        WaitFor.sleepFor(2000);
        reportspopup.clickOnSelectButtonForCustomizedReports();
        Assert.assertTrue(reportspopup.isPhoneAndEmailErrorMsgPresent(), "Expected Error Message not shown");
        AutomationLog.info("Error message is shown if both email and phone fields are empty");
    }

    public void verifyIfInvalidEmailIsEntered(HashMap<String, String> emaildata) throws Exception
    {
        for(int i=1;i<=3;i++)
        {
            String em = "email"+i;
            reportspopup.txtbx_Email().clear();
            reportspopup.txtbx_Email().sendKeys(emaildata.get(em));
            reportspopup.clickOnSelectButtonForCustomizedReports();
            Assert.assertTrue(reportspopup.msg_InvalidEmail().isDisplayed(), "Expected Invalid Email error message is not shown");
        }
        AutomationLog.info("Error message is shown when invalid email combination is entered");
    }

    @Override
    protected String successMessage()
    {
        return "test cases for ReportsPopUp passed";
    }

    @Override
    protected String failureMessage()
    {
        return "test cases for ReportsPopUp failed";
    }

}
