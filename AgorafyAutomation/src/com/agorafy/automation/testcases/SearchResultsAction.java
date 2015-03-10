package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.SearchResultsPage;
import com.agorafy.automation.pageobjects.upsellpopups.LoginPopUp;

/**
 * Precondition:Do search for property 
 * Verify if Login PopUp Is Shown Clicking On  Subscribe To This Search Link
 * verify if Search By Beds Shows Properties With No Of Beds
 * verify if Search By Baths Shows Properties With No Of Baths
 * verify that Only properties with 'x+' baths and 'y+' beds and different combinations of those only displayed on results page
 * verify if user searches for zero baths and zero beds shows no results found
 */
public class SearchResultsAction extends AutomationTestCaseVerification
{
    private Homepage homepage;
    private SearchResultsPage searchresult;
    private LoginPopUp loginpopup;
    private Header header = Header.header();

    public SearchResultsAction()
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();
        try
        {
            homepage = Homepage.homePage();
            HashMap<String, String> data = testCaseData.get("SearchData");
            searchresult = homepage.populateSearchTermTextBox(data.get("borough"),data.get("listingcategory"),data.get("searchterm"));
            AutomationLog.info("Successfully Redirected to Property Search page ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not be redirected to Property Search page");
            e.getMessage();
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        verifyIfLoginPopUpIsShownOnSubscribeToThisSearchLink();
        verifyIfSearchByBedsShowsPropertiesWithNoOfBeds();
        verifyPropertiesWithXBathsAndYBedsAndDifferentCombinations();
        verifyUserSearchesforZeroBathsAndZerobedsShowsNoResultsFound();
        verifyIfSearchByBathsShowsPropertiesWithNoOfBaths();
        verifyIfLoginPopUpIsShownOnClickOfCreateYourProfileButton();
    }

    public void verifyIfLoginPopUpIsShownOnSubscribeToThisSearchLink() throws Exception
    {
        boolean Status = false;
        loginpopup = (LoginPopUp) searchresult.clickOnSubscribeToThisSearchLink(Status);
        WaitFor.ElementToBeDisplayed(Page.driver, loginpopup.getLoginPopUpLocator());
        Assert.assertEquals(searchresult.loginPopUpIsDisplayed(loginpopup),true,"Expected login pop up could not found");
        Assert.assertEquals(searchresult.getTitleForLoginPopUp(loginpopup), "Log in", "Could not Get login pop up title");
        AutomationLog.info("Clicking on Subscribe to this search link displays Login popup ");
        searchresult.closeLoginPoPup(loginpopup);
    }

    public void verifyIfSearchByBedsShowsPropertiesWithNoOfBeds() throws Exception
    {
        String result = null;
        header.clickOnAdvanceSearchDropDownIcon();
        header.searchByNoOfBeds("2");
        header.clickOnSearchButtonOnAdvanceSearchform();
        result = searchresult.NoOfBedsInPropertiesSearch();
        Assert.assertEquals(result, "2", "Expected Properties with specified beds is not shown");
        AutomationLog.info("Successfully shown Properties with x beds");
    }

    public void verifyPropertiesWithXBathsAndYBedsAndDifferentCombinations() throws Exception
    {
        header.clickOnAdvanceSearchDropDownIcon();
        header.searchByNoOfBeds("3");
        header.searchByNoOfBaths("3");
        header.clickOnSearchButtonOnAdvanceSearchform();
        Assert.assertEquals(searchresult.NoOfBedsInPropertiesSearch(), "3", "Expected Properties with specified beds is not shown");
        Assert.assertEquals(searchresult.NoOfBathsInPropertiesSearch(), "3", "Expected Properties with specified bath is not shown");
        AutomationLog.info("Properties with X baths And Y Beds And Different Combinations is verified");
    }
    
    public void verifyUserSearchesforZeroBathsAndZerobedsShowsNoResultsFound() throws Exception
    {
        header.clickOnAdvanceSearchDropDownIcon();
        header.searchByNoOfBeds("0");
        header.searchByNoOfBaths("0");
        header.clickOnSearchButtonOnAdvanceSearchform();
        Assert.assertEquals(searchresult.loadingMessage().getText(), "NO RESULTS FOUND.", "Expected message is Not Shown");
        AutomationLog.info("Successfully verified that by searching with 0 bath and 0 bed, appropiate message comes up");
    }

    
    public void verifyIfSearchByBathsShowsPropertiesWithNoOfBaths() throws Exception
    {
        String result = null;
        header.clickOnAdvanceSearchDropDownIcon();
        header.searchByNoOfBaths("2");
        header.clickOnSearchButtonOnAdvanceSearchform();
        result = searchresult.NoOfBathsInPropertiesSearch();
        Assert.assertEquals(result, "2", "Expected Properties with specified baths is not shown");
        AutomationLog.info("Successfully shown Properties with x baths");
    }

    public void verifyIfLoginPopUpIsShownOnClickOfCreateYourProfileButton() throws Exception
    {
        String beforURL = searchresult.currentURL();
        loginpopup = searchresult.clickOnCreateProfileButton();
        WaitFor.ElementToBeDisplayed(Page.driver, loginpopup.getLoginPopUpLocator());
        Assert.assertEquals(searchresult.loginPopUpIsDisplayed(loginpopup),true,"Expected login pop up could not found");
        Assert.assertEquals(searchresult.getTitleForLoginPopUp(loginpopup), "Log in", "Could not Get login pop up title");
        Credentials ValidCredentials = userCredentials();
        loginpopup.populateLoginPopUpData(ValidCredentials.getEmail(), ValidCredentials.getPassword());
        searchresult = (SearchResultsPage) loginpopup.clickLoginButtonOnUpsell();
        String afterURL = searchresult.currentURL();
        Assert.assertEquals(beforURL, afterURL, "Expected url match failed");
        AutomationLog.info("Clicking on Create Your Profile button displays Login popup and when logged in using valid credentials same page is shown");
    }

    @Override
    protected String successMessage() 
    {
        return "Test case for SearchResults passed";
    }

    @Override
    protected String failureMessage() 
    {
        return "Test case for SearchResults failed";
    }

}
