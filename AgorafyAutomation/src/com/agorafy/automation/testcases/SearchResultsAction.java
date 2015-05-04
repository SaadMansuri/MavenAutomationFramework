package com.agorafy.automation.testcases;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.SearchResultsPage;
import com.agorafy.automation.pageobjects.reports.Reports;
import com.agorafy.automation.pageobjects.upsellpopups.LoginPopUp;
import com.agorafy.automation.utilities.Login;

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
    private HashMap<String, String> dataFromCSV = new HashMap<>();
    private Reports reports = null;
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
        verifyIfAnalyticsViewButtonIsHiddenForShortSearchTerm();
        verifyIfAnalyticsViewButtonIsDisplayedForLongSearchTerm();
        HashMap<String, String> viewtype = testCaseData.get("ViewType");
        verifyIfMapViewButtonIsClicked(viewtype);
        verifyIfMapViewPageContents();
        verifyIfListViewButtonIsClicked(viewtype);
        verifyIfListViewPageContents();
        verifyLoginOnAnalyticsButtonClick(viewtype);
        verifyLoginOnCreateYourProfileButtonClick();
        verifyAnalyticsViewPageContents();
        verifyAnalyticsClickInLoggedInState(viewtype);
        verifyIfExportsButtonIsEnabled();
        verifySessionExpireTestcases();

        
/*        verifySizeInAdvanceSearch();
        verifyPriseInAdvanceSearch();

        AutomationLog.info("Verification of search results page after entering pin code which is less 5 digits");
        verifyInvalidPinCode();

        AutomationLog.info("Verification of search result page after entering valid input combination, but dont have results for that");
        verifyNoResultsCombination();

        AutomationLog.info("Verification of search result page after entering special character in search criteria");
        verifySpecialCharacterInSearch();
*/
    }

    public void verifyIfAnalyticsViewButtonIsHiddenForShortSearchTerm() throws Exception 
    {
        searchdata = testCaseData.get("SearchData");
        searchresult = homepage.populateSearchTermTextBox(searchdata.get("borough"),searchdata.get("listingcategory"),searchdata.get("searchterm"));
        AutomationLog.info("Successfully Redirected to Property Search page ");
        WaitFor.sleepFor(5000);
        Assert.assertFalse(searchresult.isAnalyticsViewButtonPresent(), "Expected Analytics view button is not hidden ");
        AutomationLog.info("Short searchterm does not show analytics view button");
    }

    public void verifyIfAnalyticsViewButtonIsDisplayedForLongSearchTerm() throws Exception 
    {
        header.txtbx_SearchInput().clear();
        header.enterSearchTextInSearchInputTextBox(searchdata.get("longsearchterm"));
        WaitFor.sleepFor(5000);
        header.clickOnSearchFormButton();
        WaitFor.sleepFor(10000);
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
        boolean isloggedIn = true;
       // searchresult.scrollPage(700, 0);
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
        WaitFor.waitForPageToLoad(Page.driver);
        WaitFor.sleepFor(30000);
        String url = searchresult.getCurrentUrl();
        Map<String, String> params=searchresult.getQueryMap(url);
        String actualviewtype =(String)params.get("view");
        Assert.assertEquals(actualviewtype, viewtype.get("view3"), "Expected MapView page is not shown");
        AutomationLog.info("Clicking MapView button redirects to MapView page ");
    }

    public void verifyIfListViewButtonIsClicked(HashMap<String, String> viewtype) throws Exception 
    {
        searchresult.clickOnListViewButton();
        WaitFor.sleepFor(10000);
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
        String sizefrom = searchresult.FilterSize_SquareFeet_From().getText().replaceAll("\\D", "");
        String sizeto = searchresult.FilterSize_SquareFeet_To().getText().replaceAll("\\D", "");
        String actualsize = sizefrom+"-"+sizeto;
        Assert.assertEquals(actualsize, "5000-10000", "Expected size is not found");
        AutomationLog.info("Changing size in advance Search reflects in Sqft range in filter section ");
    }

    public void verifyPriseInAdvanceSearch() throws Exception 
    {
        header.clickOnAdvanceSearchDropDownIcon();
        header.enterPriceInAdvanceSearchPriceTextBox("5000-15000");
        header.clickOnSearchButtonOnAdvanceSearchform();
        String pricefrom = searchresult.FilterPrice_From().getText().replaceAll("\\D", "");
        String priceto = searchresult.FilterPrice_To().getText().replaceAll("\\D", "");
        String actualsize = pricefrom+"-"+priceto;
        Assert.assertEquals(actualsize, "5000-15000", "Expected price is not found");
        AutomationLog.info("Changing price in advance Search reflects in Price Range  in filter section ");
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
            Assert.assertEquals(errorMsgStatus, true, "Error msg for no results is not generated, if invalid pin is added, invalid pin is as follows:"+pinCombination);
            AutomationLog.info("Error msg for no results is sucessfully generated, if invalid pin is added");
            pinCombination = null;
        }
    }

    public void verifyLoginOnCreateYourProfileButtonClick() throws Exception
    {
        String beforURL = searchresult.currentURL();
        searchresult.scrollPage(0, 700);
        Page.driver.navigate().refresh();
        loginpopup = searchresult.clickOnCreateProfileButton();
        WaitFor.ElementToBeDisplayed(Page.driver, loginpopup.getLoginPopUpLocator());
        Assert.assertEquals(searchresult.loginPopUpIsDisplayed(loginpopup),true,"Expected login pop up could not found");
        Assert.assertEquals(searchresult.getTitleForLoginPopUp(loginpopup), "Log in", "Could not Get login pop up title");
        Credentials ValidCredentials = userCredentials();
        loginpopup.populateLoginPopUpData(ValidCredentials.getEmail(), ValidCredentials.getPassword());
        //searchresult = (SearchResultsPage) loginpopup.clickLoginButtonOnUpsell();
        loginpopup.btn_LogIntoMyAccount().click();
        WaitFor.sleepFor(20000);
        String afterURL = searchresult.currentURL();
        Assert.assertEquals(beforURL, afterURL, "Expected url match failed");
        AutomationLog.info("Clicking on Create Your Profile button displays Login popup and when logged in using valid credentials same page is shown");
    }

    public void verifyIfExportsButtonIsEnabled() throws Exception
    {
        Assert.assertTrue(searchresult.btn_Exports().isEnabled(), "Expected button is not enabled");
        AutomationLog.info("Exports button is enabled ");
    }

    public void verifyIfExportsButtonIsClickedAfterExpiringSession() throws Exception
    {
        String pageurl = Page.driver.getCurrentUrl();
        Page.driver.manage().deleteAllCookies();
        searchresult.clickOnExportsButton();
        Assert.assertEquals(searchresult.getCurrentUrl(), "https://beta.agorafy.com/login", "Expected page is not shown");
        AutomationLog.info("Expiring Session on Analytics view page redirects to Login page");
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
        searchresult.clickOnListViewButton();
    }

    public void verifyIfExpiringSessionOnListViewPage() throws Exception 
    {
        String pageurl = Page.driver.getCurrentUrl();
        Page.driver.manage().deleteAllCookies();
        searchresult.btn_AnalyticsView().click();
        Assert.assertEquals(searchresult.getCurrentUrl(), "https://beta.agorafy.com/login", "Expected page is not shown");
        AutomationLog.info("Expiring Session on list view page redirects to Login page");
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
    }

    public void verifyIfMapViewPageContents() throws Exception
    {
        Assert.assertTrue(searchresult.div_Advertisement().isDisplayed(), "Expected Advertisement div is not present");
        Assert.assertFalse(searchresult.isCreateYourProfileButtonPresent(), "Expected CreateYourProfile button not present");
        AutomationLog.info("Map view page contains Advertisement div and not Create your profile button");
    }

    public void verifyIfListViewPageContents() throws Exception 
    {
        Assert.assertTrue(searchresult.div_Advertisement().isDisplayed(), "Expected Advertisement div is not present");
        Assert.assertTrue(searchresult.btn_CreateYourProfile().isDisplayed(), "Expected CreateYourProfile button not present");
        AutomationLog.info("List view page contains Advertisement div and Create your profile button");
    }

    public void verifyAnalyticsViewPageContents() throws Exception 
    {
        Assert.assertTrue(searchresult.div_Advertisement().isDisplayed(), "Expected Advertisement div is not present");
        Assert.assertTrue(searchresult.btn_CreateYourProfile().isDisplayed(), "Expected CreateYourProfile button not present");
        AutomationLog.info("Analytics view page contains Advertisement div and Create your profile button");
    }

    public void verifySessionExpireTestcases() throws Exception
    {
        verifyIfExportsButtonIsClickedAfterExpiringSession();
        verifyIfExpiringSessionOnListViewPage(); 
        verifyIfClickingSubscribeToThisSearchLinkAfterSessionExpire();
        verifyIfClickingOnPinCushionAfterSessionExpire();
        verifyIfClickingRemovefromReportPinCushionAfterSessionExpire();
        verifyIfClickingCreateYourProfileButtonAfterSessionExpire();
    }

    public void verifyIfClickingOnPinCushionAfterSessionExpire() throws Exception 
    {
        int i = 0;
        String pageurl = Page.driver.getCurrentUrl();
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.manage().deleteAllCookies();
        searchresult.hoverOnSearchResult(i);
        searchresult.hoverAndClickOnPincushionIcon(i);
        Assert.assertTrue(searchresult.loginPopUpIsDisplayed(loginpopup), "Expected Login PopUp is not Displayed");
        AutomationLog.info("Login PopUp is shown on Clicking Pincushion icon After session expire");
        searchresult.closeLoginPoPup(loginpopup);
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
    }

    public void verifyIfClickingRemovefromReportPinCushionAfterSessionExpire() throws Exception
    {
        int i = 0;
        Page.driver.manage().deleteAllCookies();
        String pageurl = Page.driver.getCurrentUrl();
        searchresult.hoverOnSearchResult(i);
        searchresult.hoverAndClickOnPincushionIcon(i);
        Page.driver.manage().deleteAllCookies();
        Assert.assertTrue(searchresult.loginPopUpIsDisplayed(loginpopup), "Expected Login PopUp is not Displayed");
        AutomationLog.info("Login PopUp is shown on Clicking Pincushion icon After session expire");
        searchresult.closeLoginPoPup(loginpopup);
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
        
    }

    public void verifyIfClickingSubscribeToThisSearchLinkAfterSessionExpire() throws Exception 
    {
        Page.driver.manage().deleteAllCookies();
        Page.driver.navigate().refresh();
        loginpopup = (LoginPopUp) searchresult.clickOnSubscribeToThisSearchLink(false);
        Assert.assertTrue(searchresult.loginPopUpIsDisplayed(loginpopup), "Expected Login PopUp is not Displayed");
        AutomationLog.info("Login PopUp is shown on Clicking Pincushion icon After session expire");
        searchresult.closeLoginPoPup(loginpopup);
    }

    public void verifyIfClickingCreateYourProfileButtonAfterSessionExpire() throws Exception
    {
        String pageurl = Page.driver.getCurrentUrl();
        Page.driver.manage().deleteAllCookies();
        searchresult.btn_CreateYourProfile().click();
        Assert.assertEquals(searchresult.getCurrentUrl(), "https://beta.agorafy.com/login", "Expected page is not shown");
        AutomationLog.info("Expiring Session on list view page redirects to Login page");
        Login.doSuccessfullLoginFromHeaderLoginForm();
        Page.driver.get(pageurl);
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
