package com.agorafy.automation.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
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
    private Homepage homepage = Homepage.homePage();
    private SearchResultsPage searchresult;
    private LoginPopUp loginpopup;
    private Header header = Header.header();
    private HeaderLoginForm headerloginform;
    private HashMap<String, String> dataFromCSV = new HashMap<>();
    HashMap<String, String> searchdata; 

    public SearchResultsAction()
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
/*        verifyIfLoginPopUpIsShownOnSubscribeToThisSearchLink();*/
        verifyIfAnalyticsViewButtonIsHiddenForShortSearchTerm();
        verifyIfAnalyticsViewButtonIsDisplayedForLongSearchTerm();
        HashMap<String, String> viewtype = testCaseData.get("ViewType");
        verifyIfMapViewButtonIsClicked(viewtype);
        verifyIfListViewButtonIsClicked(viewtype);
        verifyLoginOnAnalyticsButtonClick(viewtype);
        verifyAnalyticsClickInLoggedInState(viewtype);
        verifySizeInAdvanceSearch();


        /*verifyIfSearchByBedsShowsPropertiesWithNoOfBeds();
        verifyPropertiesWithXBathsAndYBedsAndDifferentCombinations();
        verifyUserSearchesforZeroBathsAndZerobedsShowsNoResultsFound();
        verifyIfSearchByBathsShowsPropertiesWithNoOfBaths();*/
        //verifyIfLoginPopUpIsShownOnClickOfCreateYourProfileButton();

        /*AutomationLog.info("Verification of search results page after entering pin code which is less 5 digits");
        verifyInvalidPinCode();

        AutomationLog.info("Verification of search result page after entering valid input combination, but dont have results for that");
        verifyNoResultsCombination();

        AutomationLog.info("Verification of search result page after entering special character in search criteria");
        verifySpecialCharacterInSearch();*/

    }

    public void verifyIfAnalyticsViewButtonIsHiddenForShortSearchTerm() throws Exception 
    {
        searchdata = testCaseData.get("SearchData");
        searchresult = homepage.populateSearchTermTextBox(searchdata.get("borough"),searchdata.get("listingcategory"),searchdata.get("searchterm"));
        AutomationLog.info("Successfully Redirected to Property Search page ");
        WaitFor.sleepFor(10000);
        Assert.assertFalse(searchresult.isAnalyticsViewButtonPresent(), "Expected Analytics view button is not hidden ");
        AutomationLog.info("Short searchterm does not show analytics view button");
    }

    public void verifyIfAnalyticsViewButtonIsDisplayedForLongSearchTerm() throws Exception 
    {
        header.txtbx_SearchInput().clear();
        header.enterSearchTextInSearchInputTextBox(searchdata.get("longsearchterm"));
        WaitFor.sleepFor(10000);
        header.clickOnSearchFormButton();
        WaitFor.sleepFor(20000);
        Assert.assertTrue(searchresult.isAnalyticsViewButtonPresent(), "Expected Analytics view button is not displayed");
        AutomationLog.info("Long searchterm shown analytics view button");
    }

    public void verifyLoginOnAnalyticsButtonClick(HashMap<String, String> viewtype) throws Exception 
    {
        boolean isloggedIn = false;
        loginpopup = (LoginPopUp) searchresult.clickOnAnalyticsViewButton(isloggedIn);
        WaitFor.ElementToBeDisplayed(Page.driver, loginpopup.getLoginPopUpLocator());
        Assert.assertEquals(searchresult.loginPopUpIsDisplayed(loginpopup),true,"Expected login pop up could not found");
        AutomationLog.info("Clicking AnalyticsView button in logged out state shows LoginPopUp  ");
        searchresult.closeLoginPoPup(loginpopup);
    }

    public void verifyAnalyticsClickInLoggedInState(HashMap<String, String> viewtype) throws Exception 
    {
        headerloginform = header.openHeaderLoginForm();
        WaitFor.sleepFor(2000);
        Credentials ValidCredentials = userCredentials();
        headerloginform.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
        boolean isloggedIn = true;
        searchresult = (SearchResultsPage) searchresult.clickOnAnalyticsViewButton(isloggedIn);
        String url = searchresult.getCurrentUrl();
        Map<String, String> params=searchresult.getQueryMap(url);
        String actualviewtype =(String)params.get("view");
        Assert.assertEquals(actualviewtype, viewtype.get("view1"), "Expected AnalyticsView page is not shown");
        AutomationLog.info("Clicking AnalyticsView button in logged in state redirects to Analytics page");
    }

    public void verifyIfMapViewButtonIsClicked(HashMap<String, String> viewtype) throws Exception 
    {
        searchresult.clickOnMapViewButton();
        WaitFor.sleepFor(20000);
        String url = searchresult.getCurrentUrl();
        Map<String, String> params=searchresult.getQueryMap(url);
        String actualviewtype =(String)params.get("view");
        Assert.assertEquals(actualviewtype, viewtype.get("view3"), "Expected MapView page is not shown");
        AutomationLog.info("Clicking MapView button redirects to MapView page ");
    }

    public void verifyIfListViewButtonIsClicked(HashMap<String, String> viewtype) throws Exception 
    {
        searchresult.clickOnListViewButton();
        WaitFor.sleepFor(20000);
        String url = searchresult.getCurrentUrl();
        Map<String, String> params=searchresult.getQueryMap(url);
        String actualviewtype =(String)params.get("view");
        Assert.assertEquals(actualviewtype, viewtype.get("view2"), "Expected ListView page is not shown");
        AutomationLog.info("Clicking ListView button redirects to ListView page ");
    }

    public void verifySizeInAdvanceSearch() throws Exception
    {
        header.clickOnAdvanceSearchDropDownIcon();
        header.enterSizeInAdvanceSearchSizeTextBox("5000-10000");
        header.clickOnSearchButtonOnAdvanceSearchform();
        String sizefrom = searchresult.Filter_SquareFeet_From().getText().replaceAll("\\D", "");
        String sizeto = searchresult.Filter_SquareFeet_To().getText().replaceAll("\\D", "");
        String actualsize = sizefrom+"-"+sizeto;
        Assert.assertEquals(actualsize, "5000-10000", "Expected size is not found");
        AutomationLog.info("Successfully got size on filter section");
    }

    private void verifySpecialCharacterInSearch() throws Exception 
    {
        searchresult = homepage.populateSearchTermTextBox(null, null, "$");
        boolean errorMsgStatus = false;
        errorMsgStatus = searchresult.noResultsErrorMsg().isDisplayed();
        Assert.assertEquals(errorMsgStatus, true, "Msg for no results is not generated");
        AutomationLog.info("Msg for no results is sucessfully generated");
    }

	private void verifyNoResultsCombination() throws Exception 
    {
        dataFromCSV = testCaseData.get("ValidSearchInputWithNoResults");
        searchresult = homepage.populateSearchTermTextBox(dataFromCSV.get("borough"), dataFromCSV.get("listingcategory"), dataFromCSV.get("searchterm"));
        boolean errorMsgStatus = false;
        errorMsgStatus = searchresult.noResultsErrorMsg().isDisplayed();
        Assert.assertEquals(errorMsgStatus, true, "Msg for no results is not generated");
        AutomationLog.info("Msg for no results is sucessfully generated");
    }

	private void verifyInvalidPinCode() throws Exception 
    {
        Integer pinCombinationNo;
        String pinCombination;
        String pinCombinationString;
        dataFromCSV = testCaseData.get("InvalidPinData");
        for(pinCombinationNo = 1; pinCombinationNo<3; pinCombinationNo++)
        {
            pinCombination = "invalidPin";
            pinCombination = pinCombination.concat(pinCombinationNo.toString());
            pinCombinationString = dataFromCSV.get(pinCombination);
            searchresult = homepage.populateSearchTermTextBox(null, null, pinCombinationString);
            boolean errorMsgStatus = false;
            errorMsgStatus = searchresult.noResultsErrorMsg().isDisplayed();
            System.out.println(searchresult.noResultsErrorMsg().getText());
            Assert.assertEquals(errorMsgStatus, true, "Error msg for no results is not generated, if invalid pin is added, invalid pin is as follows:"+pinCombination);
            AutomationLog.info("Error msg for no results is sucessfully generated, if invalid pin is added");
            pinCombination = null;
        }
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

/*    public void verifyIfSearchByBedsShowsPropertiesWithNoOfBeds() throws Exception
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
    }*/

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
