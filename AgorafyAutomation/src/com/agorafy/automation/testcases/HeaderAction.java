package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.upsellpopups.*;
import com.agorafy.automation.pageobjects.Page;

/**
 * verify if clicking the arrow shows advanced search options
 * validate and display an alert message asking for a search text if user does not type any search item, clicks search
 * verify if autoComplete menu comes after typing text on neighborhood street address zipcode search
 */
public class HeaderAction extends AutomationTestCaseVerification 
{
    private Header header;
    private LoginPopUp loginpopup;

    public HeaderAction()
    {
        super();
    }

        @Override
        public void setup()
        {
            super.setup();
            try
            {
                header = Homepage.header();
                header.clickOnSignUpUpLink();
           
            }
            catch(Exception e)
            {
                AutomationLog.error("Could not navigate to Sign Up Page");
            }
        }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyIFAdvancedSearchFormPresent();
        verifyIfLoginPopUpIsDisplayed();
        verifyIfEmptySearchIsPerformed();

        HashMap<String, String> searchterm = testCaseData.get("searchData");
        verifySearchInputBoxAutoCompleteMenu(searchterm);
    }

    public void verifyIfLoginPopUpIsDisplayed() throws Exception
    {
        boolean status = false;
        loginpopup = (LoginPopUp) header.clickSubmitListing(status);
        WaitFor.ElementToBeDisplayed(Page.driver, loginpopup.getLoginPopUpLocator());
        Assert.assertEquals(loginpopup.checkingLogInPopUp(),true,"Expected login pop up Not found");
        AutomationLog.info("Clicking on submit listing link in header displays Login popup ");
    }

    public void verifyIFAdvancedSearchFormPresent() throws Exception
    {
        header.clickOndropbox_searchInputBox();
        Assert.assertEquals(header.form_AdvancedSearch().isDisplayed(), true, "Expected error message when the Advanced Search Form is not Visible");
        AutomationLog.info("Advanced Search Form is Visible");
    }

    public void verifyIfEmptySearchIsPerformed() throws Exception
    {
        header.clickOnCloseLoginPopUp();
        header.clickOnSearchFormButton();
        WaitFor.sleepFor(1000);
        Assert.assertEquals(header.msg_ZebraTooltip().isDisplayed(), true, "Expected tooltip is not shown when empty search is performed");
        AutomationLog.info("Tool Tip is Shown when clicked on search button with empty text");
    }

    public void verifySearchInputBoxAutoCompleteMenu(HashMap<String, String> searchterm) throws Exception
    {
        header.enterSearchTextInSearchInputTextBox(searchterm.get("data"));
        WaitFor.ElementToBeDisplayed(Page.driver, header.getAutoCompleteMenuDropboxLoactor());
        Assert.assertEquals(header.searchBox_AutoCompleteMenu().isDisplayed(), true, "Expected AutoCompleteMenu dropbox is not Show when Text is entered in SearchInput textbox");
        AutomationLog.info("Sucessfully found AutoCompleteMenu dropbox which Comes After Typing Text in SearchInput Textbox");
    }

    @Override
    protected String successMessage() {
        return "Test cases passed for Header ";
    }

    @Override
    protected String failureMessage() {
        return "Test cases failed for Header";
    }
}
