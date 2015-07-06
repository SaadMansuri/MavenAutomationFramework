package com.agorafy.automation.testcases.editprofile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.UserProfile;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.editprofile.OverviewTab;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PageBanner;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.utilities.Login;

/**
 * Preconditions: Home page is loaded and login done.
 * 
 * Verify Active profile link present.
 * Click active profile link. 
 * Verify Dropdown present.
 * Verify Dashboard link present.
 * Click Dashboard link.
 * Verify Page navigates to Dashboard page.
 * Verify Edit profile link present.
 * Click on Edit profile link.
 * Verify Page navigates to Overview tab.
 * Verify Overview tab elements present.
 * Populate Overview tab elements with test data.
 * Click on submit. Verify Profile is updated.
 * Verify Banner is updated.
 */
public class OverviewTabAction extends AutomationTestCaseVerification
{
    private Homepage homePage = null;
    private Dashboard dashboard = null;
    private OverviewTab overviewTab = null;
    private SubNavigation subnavigation = null;
    static HashMap<String,String> stateAbbMap;
    private PageBanner pageBanner = null;

    public OverviewTabAction()
    {
        super();
    }

    public OverviewTabAction(String testcasename)
    {
        super(testcasename);
    }

	@Override
    public void setup()
    {
        super.setup();
        try
        {
            homePage = Login.doSuccessfullLoginFromHeaderLoginForm();
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            subnavigation = Page.subNavigation();
            dashboard = subnavigation.clickLinkMyDashboard();
            overviewTab = dashboard.editProfile();
        }
        catch(Exception e)
        {
            AutomationLog.error("Overview tab not found");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        UserProfile userData = getTestOverviewData();
        populateOverivewData(userData);
/*        overviewTab.populateOverviewDetails(userData);
        overviewTab = overviewTab.saveOverviewDetails();
*/        WaitFor.sleepFor(5000);

        pageBanner = dashboard.pageBanner();

        verifyUpdatedOverviewBanner(pageBanner, userData);
        verifyUpdatedOverviewTabForm(userData);

        verifyIfEmailFieldIsEditable(); 

        verifyIfClickedOnSpecializedNeighborhoods();
        verifyIfMoreThanFiveNeighborhoodsAdded();
    }

    public UserProfile getTestOverviewData()
    {
        HashMap<String, String> overviewTestData = testCaseData.get("OverviewData");

        UserProfile userData = new UserProfile();
        userData.setName(overviewTestData.get("validName"));
        userData.setCompanyName(overviewTestData.get("companyName"));
        userData.setWorkPhone(overviewTestData.get("validWorkPhone"));
        userData.setMobilePhone(overviewTestData.get("validMobileNumber"));
        userData.setAddress1(overviewTestData.get("validAddress1"));
        userData.setAddress2(overviewTestData.get("validAddress2"));
        userData.setCity(overviewTestData.get("validCity"));
        userData.setState(overviewTestData.get("validState"));
        userData.setZipCode(overviewTestData.get("validZip"));
        userData.setDescribe(overviewTestData.get("character"));
        userData.setNeighbour(overviewTestData.get("validNeighbour"));

        return userData;
    }

    public void verifyUpdatedOverviewBanner(PageBanner banner, UserProfile overviewData) throws Exception
    {
        verifyBannerDetails(banner, overviewData);
        testBannerAddressDetails(banner, overviewData);
        testBannerMobileDetails(banner, overviewData);
        testBannerPhoneDetails(banner, overviewData);

    }

    public void verifyIfEmailFieldIsEditable() throws Exception
    {
        Assert.assertEquals(overviewTab.default_Email().isEnabled(), true, "Email field is not editable");
        AutomationLog.info("Expected Email field is editable ");
    }

    public void verifyUpdatedOverviewTabForm(UserProfile overviewData) throws Exception
    {
        verifyTextBoxName(overviewData);
        verifyTextBoxComapnyName(overviewData);
        verifyTextBoxMobilePhoneNumber(overviewData);
        verifyTextBoxWorkPhoneNumber(overviewData);
        verifyTextBoxAddress1(overviewData);
        verifyTextBoxAddress2(overviewData);
        verifyTextBoxCity(overviewData);
        verifyTextBoxState(overviewData);
        verifyTextBoxZip(overviewData);
        verifyTextBoxDescribeYourself(overviewData);
        // TODO: Add test to verify neighborhood as it is a complex ui
        //verifyTextBoxNeigborhood(overviewTab, overviewData);
    }

    public void populateOverivewData(UserProfile userData) throws Exception 
    {
        overviewTab.populateOverviewDetails(userData);
        overviewTab = overviewTab.saveOverviewDetails();
    }

    public void verifyBannerDetails(PageBanner banner, UserProfile overviewData) throws Exception
    {
        String newBannerNameAfterSavingOverviewData = banner.getBannerText();
        Assert.assertEquals(newBannerNameAfterSavingOverviewData, overviewData.getName(), "Expected name is not displayed in banner");
        AutomationLog.info("Updated Name displayed on Banner");
    }

    public void verifyTextBoxName(UserProfile overviewData) throws Exception
    {
        String verifyNamePresentInTextBox = overviewTab.getTextBoxName();
        Assert.assertEquals(verifyNamePresentInTextBox, overviewData.getName(), "Expected name not found");
        AutomationLog.info("Expected Name found As per the Text Box");
    }

    public void verifyTextBoxComapnyName(UserProfile overviewData) throws Exception
    {
        String verifyComapnyNamePresentInTextBox = overviewTab.getTextBoxCompanyName();
        Assert.assertEquals(verifyComapnyNamePresentInTextBox, overviewData.getCompanyName(), "company name not found");
        AutomationLog.info("Expected Company Name found As per the Text Box");
    }

    public void verifyTextBoxMobilePhoneNumber(UserProfile overviewData) throws Exception
    {
        String mobile = overviewTab.getTextBoxMobileNumber();
        String verifyWorkMobileNumberPresentInTextBox = mobile.replaceAll("-", "");
        Assert.assertEquals(verifyWorkMobileNumberPresentInTextBox, overviewData.getMobilePhone(), "Mobile nos not found");
        AutomationLog.info("Expected Mobile Number found As per the Text Box");
    }

    public void verifyTextBoxWorkPhoneNumber(UserProfile overviewData) throws Exception
    {
        String work = overviewTab.getTextBoxWorkPhoneNumber();
        String verifyWorkPhoneNumberPresentInTextBox = work.replaceAll("-", "");
        Assert.assertEquals(verifyWorkPhoneNumberPresentInTextBox, overviewData.getWorkPhone(), "Workphone nos not found");
        AutomationLog.info("Expected Work Phone number found As per the Text Box");
    }

    public void verifyTextBoxAddress1(UserProfile overviewData) throws Exception
    {
        String verifyAddress1PresentInTextBox = overviewTab.getTextBoxAddress1();
        Assert.assertEquals(verifyAddress1PresentInTextBox, overviewData.getAddress1(), "Address1 not found");
        AutomationLog.info("Expected Address1 found As per the Text Box");
    }

    public void verifyTextBoxAddress2(UserProfile overviewData) throws Exception
    {
        String verifyAddress2PresentInTextBox = overviewTab.getTextBoxAddress2();
        Assert.assertEquals(verifyAddress2PresentInTextBox, overviewData.getAddress2(), "Address2 not found");
        AutomationLog.info("Expected Address2 found As per the Text Box");
    }

    public void verifyTextBoxCity(UserProfile overviewData) throws Exception
    {
        String verifyCityPresentInTextBox = overviewTab.getTextBoxCity();
        Assert.assertEquals(verifyCityPresentInTextBox, overviewData.getCity(), "City not found");
        AutomationLog.info("Expected City found As per the Text Box");
    }

    public void verifyTextBoxState(UserProfile overviewData) throws Exception
    {
        String verifyStatePresentInTextBox = overviewTab.getDropdownState();
        Assert.assertEquals(verifyStatePresentInTextBox, overviewData.getState(), "State not found");
        AutomationLog.info("Expected State found As per the Text Box");
    }

    public void verifyTextBoxZip(UserProfile overviewData) throws Exception
    {
        String verifyZipPresentInTextBox = overviewTab.getTextBoxZip();
        Assert.assertEquals(verifyZipPresentInTextBox, overviewData.getZipCode(), "Zip not found");
        AutomationLog.info("Expected Zip found As per the Text Box");
    }

    public void verifyTextBoxDescribeYourself(UserProfile overviewData) throws Exception
    {
        String verifydescribeYourselfPresentInTextBox = overviewTab.getTextBoxDescribeYorself();
        Assert.assertEquals(verifydescribeYourselfPresentInTextBox, overviewData.getDescribe(), "Describe yourself not found");
        AutomationLog.info("Expected Description found As per the Text Box");
    }

    public void verifyTextBoxNeigborhood(OverviewTab overviewTab,UserProfile overviewData) throws Exception
    {
        String verifyNeighborhoodPresentInTextBox = overviewTab.getMultipleSelectNeighborhood();
        Assert.assertEquals(verifyNeighborhoodPresentInTextBox, overviewData.getNeighbour(), "Neigborhood not found");
        AutomationLog.info("Expected Neighborhood found As per the Text Box");
    }

    public void testBannerAddressDetails(PageBanner banner, UserProfile overviewData) throws Exception
    {
        String addressDetails = banner.getBannerAddressText();
        String addressToken[] = addressDetails.split(", ");
        Assert.assertEquals(addressToken[0], overviewData.getAddress1(), "The correct Address1 is not displayed in banner");
        AutomationLog.info("Updated address1 found in banner");

        Assert.assertEquals(addressToken[1], overviewData.getAddress2(), "The correct Address2 is not displayed in banner");
        AutomationLog.info("Updated address2  found in banner");

        Assert.assertEquals(addressToken[2], overviewData.getCity(), "The correct City is not displayed in banner");
        AutomationLog.info("Updated City found in banner");

        createStateAbbreviationMap();

        String stateAndZipcode[] = addressToken[3].split(" ");
        String abbreviation = getStateAbbreviation(overviewData.getState());
        Assert.assertEquals(stateAndZipcode[0], abbreviation, "The correct state is not displayed in banner");
        AutomationLog.info("Updated State found in banner");

        Assert.assertEquals(stateAndZipcode[1], overviewData.getZipCode(), "The correct Zipcode is not displayed in banner");
        AutomationLog.info("Updated Zip found in banner");
    }

    public void testBannerPhoneDetails(PageBanner banner, UserProfile overviewData) throws Exception
    {
        String phoneDetails = banner.getBannerWorkPhoneText();
        String phoneToken[] = phoneDetails.split(": ");
        String formattedPhoneNumber = formatPhoneNumber(overviewData.getWorkPhone());
        Assert.assertEquals(phoneToken[1], formattedPhoneNumber, "The correct Workphone is not displayed in banner");
        AutomationLog.info("Updated WorkPhone found in banner");
    }

    public void testBannerMobileDetails(PageBanner banner,UserProfile overviewData) throws Exception
    {
        String mobileDetails = banner.getBannerMobilePhoneText();
        String mobileToken[] = mobileDetails.split(": ");
        String formattedMobileNumber=formatPhoneNumber(overviewData.getMobilePhone());
        Assert.assertEquals(mobileToken[1], formattedMobileNumber, "The correct Mobile number is not displayed in banner");
        AutomationLog.info(" Updated MobileNumber found in banner");
    }

    public static void createStateAbbreviationMap()
    {
        stateAbbMap = new HashMap<String, String>();
        stateAbbMap.put("Georgia", "GA");
        stateAbbMap.put("Arizona", "AZ");
    }

    public static String getStateAbbreviation(String nameOfState)
    {
        String stateAbb = "";
        if(stateAbbMap.containsKey(nameOfState))
        {
            stateAbb = stateAbbMap.get(nameOfState);
        }
        return stateAbb;
    }

    public static String formatPhoneNumber(String phoneNumber)
    {
        return "(" +phoneNumber.substring(0, 3) +") "+phoneNumber.substring(3, 6)+"-"+phoneNumber.substring(6,10);
    }

    public void verifyIfClickedOnSpecializedNeighborhoods() throws Exception
    {
        HashMap<String, String> getNeighborhood = testCaseData.get("NeighborHoods");
        overviewTab.clearSpecializedNeighborhoodsTextBox();
        addNeighborhoodsInSpecializedNeighborhoods(getNeighborhood);
        overviewTab.saveOverviewDetails();
        WaitFor.waitForPageToLoad(Page.driver, overviewTab.msg_SuccessAfterSave().getText(), overviewTab.neighborhoodlocator());
        List<String> neighbors = new ArrayList<String>();
        List<WebElement > elements = overviewTab.addedNeighborhoods();
        for(WebElement ele : elements)
        {
            neighbors.add(ele.getText());
        }
        Assert.assertEquals(neighbors.contains(getNeighborhood.get("neighbor1")), true, "Excpected neighborhood is not added");
        AutomationLog.info("Clicking Specialized neighborhoods shows drop down to selects neighborhoods successfully");
    }

    public void verifyIfMoreThanFiveNeighborhoodsAdded() throws Exception
    {
        overviewTab.clickOnNeighborhoodDropdown();
        Assert.assertEquals(overviewTab.msg_SelectionLimit().getText(), "You can only select 5 items", "Expected message is not shown");
        AutomationLog.info("Message is shown if try to add more than 5 neighborhoods ");
    }

    public void addNeighborhoodsInSpecializedNeighborhoods(HashMap<String, String> getNeighborhood) throws Exception
    {
        overviewTab.clickOnNeighborhoodDropdown();
        overviewTab.selectNeighborhood(getNeighborhood.get("neighbor1"));
        overviewTab.clickOnNeighborhoodDropdown();
        overviewTab.selectNeighborhood(getNeighborhood.get("neighbor2"));
        overviewTab.clickOnNeighborhoodDropdown();
        overviewTab.selectNeighborhood(getNeighborhood.get("neighbor3"));
        overviewTab.clickOnNeighborhoodDropdown();
        overviewTab.selectNeighborhood(getNeighborhood.get("neighbor4"));
        overviewTab.clickOnNeighborhoodDropdown();
        overviewTab.selectNeighborhood(getNeighborhood.get("neighbor5"));
        AutomationLog.info("Successfully added Neighborhoods in Specialized Neighborhoods ");
    }

    @Override
    protected String successMessage()
    {
        return "Overview tab action tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Overview tab action failed";
    }
}