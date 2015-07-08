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
        HashMap<String, String> testdata = testCaseData.get("searchData");
        verifyIfEmptySearchIsPerformed();
        verifyIFAdvancedSearchFormPresent();
        verifyIfLoginPopUpIsDisplayed();
        //verifyIfInvestmentPropertyTypeIsSelected(testdata);
        verifyTogglingBoroughsClearsSearchInputText(testdata);
        verifyTogglingListingTypeClearsSearchInputText(testdata);
        verifySearchInputTextForAdvanceSearchResidentialProperty(testdata);
        verifySearchInputBoxAutoCompleteMenu(testdata);
    }

    public void verifySearchInputTextForAdvanceSearchResidentialProperty(HashMap<String, String> testdata) throws Exception
    {
        verifyPropertyType(testdata);
    }

    public void verifyPropertyType(HashMap<String, String> testdata) throws Exception
    {
        String searchText = testdata.get("searchtext");
        String searchterm = "s in chelsea";
        String expectedText = null; 
        String actualText = null;
        header.clickOnSelectBoroughIcon();
        WaitFor.sleepFor(1000);
        header.selectBorough(testdata.get("borough1"));
        WaitFor.sleepFor(1000);
        header.clickOnSelectListingCategoryIcon();
        header.selectListingCategory(testdata.get("listingCategory1"));
        WaitFor.sleepFor(1000);
        header.enterSearchTextInSearchInputTextBox(searchText);
        WaitFor.sleepFor(1000);
        header.clickOnAdvanceSearchDropDownIcon();
        WaitFor.sleepFor(1000);
        header.clickOnPropertyTypeDropdown();
        for(String property : header.getPropertyTypeList())
        {
            header.selectPropertyType(property);
            actualText = header.getSelectedPropertyType() + searchterm;
            WaitFor.sleepFor(2000);
            expectedText = header.txtbx_SearchInput().getAttribute("value");
            Assert.assertEquals(actualText, expectedText, "Changing property type in advance search form does not change search input text");
        }
        AutomationLog.info("Changing property type Changes search input text");
    }

	public void verifyTogglingListingTypeClearsSearchInputText(HashMap<String, String> testdata) throws Exception
    {
        header.enterSearchTextInSearchInputTextBox(testdata.get("searchtext"));
        WaitFor.sleepFor(1000);
        header.clickOnSelectListingCategoryIcon();
        header.selectListingCategory(testdata.get("listingCategory2"));
        WaitFor.sleepFor(1000);
        Assert.assertEquals(header.txtbx_SearchInput().getText(), "", "Toggling Listing types do not clear search input text");
        AutomationLog.info("Toggling Listing types clears search input text ");
    }

	public void verifyTogglingBoroughsClearsSearchInputText(HashMap<String, String> testdata) throws Exception
    {
        header.clickOnSelectBoroughIcon();
        header.selectBorough(testdata.get("borough1"));
        WaitFor.sleepFor(1000);
        header.clickOnSelectListingCategoryIcon();
        header.selectListingCategory("listingCategory3");
        WaitFor.sleepFor(1000);
        header.enterSearchTextInSearchInputTextBox(testdata.get("searchtext"));
        header.clickOnSelectBoroughIcon();
        WaitFor.sleepFor(1000);
        header.selectBorough(testdata.get("borough2"));
        Assert.assertEquals(header.txtbx_SearchInput().getText(), "", "Toggling boroughs do not clear search input text");
        AutomationLog.info("Toggling boroughs clears search input text ");
    }

	public void verifyIfLoginPopUpIsDisplayed() throws Exception
    {
        boolean status = false;
        loginpopup = (LoginPopUp) header.clickSubmitListing(status);
        WaitFor.ElementToBeDisplayed(Page.driver, loginpopup.getLoginPopUpLocator());
        Assert.assertEquals(loginpopup.checkingLogInPopUp(),true,"Expected login pop up Not found");
        AutomationLog.info("Clicking on submit listing link in header displays Login popup ");
        header.clickOnCloseLoginPopUp();
    }

    public void verifyIFAdvancedSearchFormPresent() throws Exception
    {
        header.clickOnAdvanceSearchDropDownIcon();
        Assert.assertEquals(header.form_AdvancedSearch().isDisplayed(), true, "Expected error message when the Advanced Search Form is not Visible");
        AutomationLog.info("Advanced Search Form is Visible");
        header.clickOnAdvanceSearchDropDownIcon();
    }

    public void verifyIfEmptySearchIsPerformed() throws Exception
    {
        header.clickOnSearchFormButton();
        WaitFor.sleepFor(1000);
        Assert.assertEquals(header.msg_ZebraTooltip().isDisplayed(), true, "Expected tooltip is not shown when empty search is performed");
        AutomationLog.info("Tool Tip is Shown when clicked on search button with empty text");
    }

    public void verifySearchInputBoxAutoCompleteMenu(HashMap<String, String> testdata) throws Exception
    {
        header.enterSearchTextInSearchInputTextBox(testdata.get("data"));
        WaitFor.ElementToBeDisplayed(Page.driver, header.getAutoCompleteMenuDropboxLoactor());
        Assert.assertEquals(header.searchBox_AutoCompleteMenu().isDisplayed(), true, "Expected AutoCompleteMenu dropbox is not Show when Text is entered in SearchInput textbox");
        AutomationLog.info("Sucessfully found AutoCompleteMenu dropbox which Comes After Typing Text in SearchInput Textbox");
    }

    public void verifyIfInvestmentPropertyTypeIsSelected(HashMap<String, String> testdata) throws Exception
    {
        header.clickOnSelectBoroughIcon();
        header.selectBorough(testdata.get("borough1"));
        WaitFor.sleepFor(2000);
        header.clickOnSelectListingCategoryIcon();
        header.selectListingCategory(testdata.get("listingCategory"));
        WaitFor.sleepFor(2000);
        String actualtext = header.txtbx_SearchInput().getAttribute("value");
        String expectedtext = testdata.get("investmentText");
        Assert.assertFalse(header.icon_AdvanceSearchDropDown().isDisplayed(), "Selecting Investment property type does not hide Advanced Dropdown icon");
        Assert.assertFalse(header.txtbx_SearchInput().isEnabled(), "Selecting Investment property type does not disable the search input box");
        Assert.assertEquals(actualtext, expectedtext, "Expected investment proprty type searchtext not found");
        AutomationLog.info("Selecting Investment property type disables search input box, hides advance search icon and ");
    }

    @Override
    protected String successMessage()
    {
        return "Test cases passed for Header ";
    }

    @Override
    protected String failureMessage()
    {
        return "Test cases failed for Header";
    }
}
