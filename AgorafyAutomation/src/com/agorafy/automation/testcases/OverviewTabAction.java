package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.OverviewData;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.OverviewBanner;
import com.agorafy.automation.pageobjects.OverviewTab;
import com.agorafy.automation.pageobjects.Page;

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
    private HeaderLoginForm headerLoginForm = null;
    private Header header = null;
    private Dashboard dashboard = null;
    private OverviewTab overviewTab = null;
    static HashMap<String,String> stateAbbMap;

    public OverviewTabAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        homePage = Homepage.homePage();
        try
        {
            headerLoginForm = homePage.openHeaderLoginForm();

            HashMap<String, String> loginData =  testCaseData.get("validCredential");
            String UserName = loginData.get("username");
            String Password = loginData.get("password");

            homePage = headerLoginForm.doSuccessfulLogin(UserName, Password);
            // Verify this is the correct homepage.
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());

            header = Page.header();
            header.openActiveProfile();

             // Verify Drowndown is displayed.
            dashboard = header.openDashboard();

            // Verify this is the correct dashboard.
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
        OverviewData overviewData = getTestOverviewData();

        overviewTab.populateOverviewDetails(overviewData);
        overviewTab = overviewTab.saveOverviewDetails();

        OverviewBanner banner = overviewTab.banner();
        WaitFor.waitForPageToLoad(Page.driver, overviewData.getName(),banner.getBannerTextLocater());

        verifyUpdatedOverviewBanner(banner, overviewData);
        verifyUpdatedOverviewTabForm(overviewTab, overviewData);
    }

    private OverviewData getTestOverviewData()
    {
        HashMap<String, String> overviewTestData = testCaseData.get("OverviewData");

        OverviewData overviewData = new OverviewData();
        overviewData.setName(overviewTestData.get("validName"));
        overviewData.setCompanyName(overviewTestData.get("companyName"));
        overviewData.setWorkPhone(overviewTestData.get("validWorkPhone"));
        overviewData.setMobilePhone(overviewTestData.get("validMobileNumber"));
        overviewData.setAddress1(overviewTestData.get("validAddress1"));
        overviewData.setAddress2(overviewTestData.get("validAddress2"));
        overviewData.setCity(overviewTestData.get("validCity"));
        overviewData.setState(overviewTestData.get("validState"));
        overviewData.setZipCode(overviewTestData.get("validZip"));
        overviewData.setDescribe(overviewTestData.get("character"));
        overviewData.setNeighbour(overviewTestData.get("validNeighbour"));

        return overviewData;
    }

    private void verifyUpdatedOverviewBanner(OverviewBanner banner, OverviewData overviewData) throws Exception
    {
        verifyBannerDetails(banner, overviewData);
        testBannerAddressDetails(banner, overviewData);
        testBannerPhoneDetails(banner, overviewData);
        testBannerMobileDetails(banner, overviewData);
    }

    private void verifyUpdatedOverviewTabForm(OverviewTab overviewTab, OverviewData overviewData) throws Exception
    {
        verifyTextBoxName(overviewTab, overviewData);
        verifyTextBoxComapnyName(overviewTab, overviewData);
        verifyTextBoxMobilePhoneNumber(overviewTab, overviewData);
        verifyTextBoxMobilePhoneNumber(overviewTab, overviewData);
        verifyTextBoxWorkPhoneNumber(overviewTab, overviewData);
        verifyTextBoxAddress1(overviewTab, overviewData);
        verifyTextBoxAddress2(overviewTab, overviewData);
        verifyTextBoxCity(overviewTab, overviewData);
        verifyTextBoxState(overviewTab, overviewData);
        verifyTextBoxZip(overviewTab, overviewData);
        verifyTextBoxDescribeYourself(overviewTab, overviewData);
        // TODO: Add test to verify neighborhood as it is a complex ui
        //verifyTextBoxNeigborhood(overviewTab, overviewData);
    }

    public void verifyBannerDetails(OverviewBanner banner, OverviewData overviewData) throws Exception
    {
        String newBannerNameAfterSavingOverviewData = banner.getBannerText();
        Assert.assertEquals(newBannerNameAfterSavingOverviewData, overviewData.getName(), "The correct name is not displayed in banner");
        AutomationLog.info("Updated Name Displayed successfully on Banner");
    }

    public void verifyTextBoxName(OverviewTab overviewTab,OverviewData overviewData) throws Exception
    {
        String verifyNamePresentInTextBox = overviewTab.getTextBoxName();
        Assert.assertEquals(verifyNamePresentInTextBox, overviewData.getName(), "Name not found");
        AutomationLog.info(" Appropriate Name found As per the Text Box");
    }

    public void verifyTextBoxComapnyName(OverviewTab overviewTab,OverviewData overviewData) throws Exception
    {
        String verifyComapnyNamePresentInTextBox = overviewTab.getTextBoxCompanyName();
        Assert.assertEquals(verifyComapnyNamePresentInTextBox, overviewData.getCompanyName(), "company name not found");
        AutomationLog.info(" Appropriate CompanyName found As per the Text Box");
    }

    public void verifyTextBoxMobilePhoneNumber(OverviewTab overviewTab,OverviewData overviewData) throws Exception
    {
        String verifyWorkMobileNumberPresentInTextBox = overviewTab.getTextBoxMobileNumber();
        Assert.assertEquals(verifyWorkMobileNumberPresentInTextBox, overviewData.getMobilePhone(), "Mobile nos not found");
        AutomationLog.info(" Appropriate MobileNumber found As per the Text Box");
    }

    public void verifyTextBoxWorkPhoneNumber(OverviewTab overviewTab,OverviewData overviewData) throws Exception
    {
        String verifyWorkPhoneNumberPresentInTextBox = overviewTab.getTextBoxWorkPhoneNumber();
        Assert.assertEquals(verifyWorkPhoneNumberPresentInTextBox, overviewData.getWorkPhone(), "Workphone nos not found");
        AutomationLog.info(" Appropriate WorkPhoneNumber found As per the Text Box");
    }

    public void verifyTextBoxAddress1(OverviewTab overviewTab,OverviewData overviewData) throws Exception
    {
        String verifyAddress1PresentInTextBox = overviewTab.getTextBoxAddress1();
        Assert.assertEquals(verifyAddress1PresentInTextBox, overviewData.getAddress1(), "Address1 not found");
        AutomationLog.info(" Appropriate Address1 found As per the Text Box");
    }

    public void verifyTextBoxAddress2(OverviewTab overviewTab,OverviewData overviewData) throws Exception
    {
        String verifyAddress2PresentInTextBox = overviewTab.getTextBoxAddress2();
        Assert.assertEquals(verifyAddress2PresentInTextBox, overviewData.getAddress2(), "Address2 not found");
        AutomationLog.info("Appropriate Address2 found As per the Text Box");
    }

    public void verifyTextBoxCity(OverviewTab overviewTab,OverviewData overviewData) throws Exception
    {
        String verifyCityPresentInTextBox = overviewTab.getTextBoxCity();
        Assert.assertEquals(verifyCityPresentInTextBox, overviewData.getCity(), "City not found");
        AutomationLog.info("Appropriate City found As per the Text Box");
    }

    public void verifyTextBoxState(OverviewTab overviewTab,OverviewData overviewData) throws Exception
    {
        String verifyStatePresentInTextBox = overviewTab.getDropdownState();
        Assert.assertEquals(verifyStatePresentInTextBox, overviewData.getState(), "State not found");
        AutomationLog.info("Appropriate State found As per the Text Box");
    }

    public void verifyTextBoxZip(OverviewTab overviewTab,OverviewData overviewData) throws Exception
    {
        String verifyZipPresentInTextBox = overviewTab.getTextBoxZip();
        Assert.assertEquals(verifyZipPresentInTextBox, overviewData.getZipCode(), "Zip not found");
        AutomationLog.info("Appropriate Zip found As per the Text Box");
    }

    public void verifyTextBoxDescribeYourself(OverviewTab overviewTab,OverviewData overviewData) throws Exception
    {
        String verifydescribeYourselfPresentInTextBox = overviewTab.getTextBoxDescribeYorself();
        Assert.assertEquals(verifydescribeYourselfPresentInTextBox, overviewData.getDescribe(), "Describe yourself not found");
        AutomationLog.info("Appropriate Description found As per the Text Box");
    }

    public void verifyTextBoxNeigborhood(OverviewTab overviewTab,OverviewData overviewData) throws Exception
    {
        String verifyNeighborhoodPresentInTextBox = overviewTab.getMultipleSelectNeighborhood();
        Assert.assertEquals(verifyNeighborhoodPresentInTextBox, overviewData.getNeighbour(), "Neigborhood not found");
        AutomationLog.info("Appropriate Neighborhood found As per the Text Box");
    }

    public void testBannerAddressDetails(OverviewBanner banner, OverviewData overviewData) throws Exception
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

    public void testBannerPhoneDetails(OverviewBanner banner, OverviewData overviewData) throws Exception
    {
        String phoneDetails = banner.getBannerWorkPhoneText();
        String phoneToken[] = phoneDetails.split(": ");
        String formattedPhoneNumber = formatPhoneNumber(overviewData.getWorkPhone());
        Assert.assertEquals(phoneToken[1], formattedPhoneNumber, "The correct Workphone is not displayed in banner");
        AutomationLog.info("Updated WorkPhone found in banner");
    }

    public void testBannerMobileDetails(OverviewBanner banner,OverviewData overviewData) throws Exception
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
        String phoneToken[] = phoneNumber.split("-");
        return "(" + phoneToken[0] +") "+phoneToken[1]+"-"+phoneToken[2];
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