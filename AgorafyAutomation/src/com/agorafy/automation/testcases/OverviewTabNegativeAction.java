package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.OverviewTab;
import com.agorafy.automation.pageobjects.Page;

/**
 * Preconditions: Home page is loaded and login done.
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
 * verifyIfNameFieldIsEmpty
 * verifyIfInvalidNameIsGiven
 * verifyIfNameDigitIsGiven
 * verifyIfCompanyNameIsEmpty
 * verifyIfCompanyNameIsEntered
 * verifyIfInvalidWorkPhoneIsEntered
 * verifyInvalidCharacterInWorkPhoneIsEntered
 *verifyIfWorkPhoneIsEmpty
 *verifyIfInvalidMobilePhoneIsEntered
 *verifyInvalidCharacterInMobileNumIsEntered
 *verifyIfMobileNumIsEmpty
 *verifyIfAddressFieldIsEmpty
 *verifyIfInvalidDataEnteredInAddress1
 *verifyIfAddressField2IsEmpty
 *verifyIfInvalidAddressField2IsEntered
 *verifyIfCityIsLeftEmpty
 *verifyIfInvalidCityDataIsEntered
 *verifyIfStateIsEmpty
 *verifyIfZipCodeLeftEmpty
 *verifyIfInvalidZipCodeIsEntered
 *verifyCountOfCharInDescYoursef
 *verifyIfCharactersAreMoreThanLimit
 */
public class OverviewTabNegativeAction extends AutomationTestCaseVerification
{
    private Homepage homePage = null;
    private HeaderLoginForm headerLoginForm = null;
    private Header header = null;
    private Dashboard dashboard = null;
    private OverviewTab overviewTab = null;
    private HashMap<String, String> invalidTestData = null;
    static HashMap<String,String> stateAbbMap;

    public OverviewTabNegativeAction()
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

            // Verify header is displayed.
             dashboard = header.openDashboard();

            //Verify this is the correct dashboard.
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
        verifyIfNameFieldIsEmpty(overviewTab);
        verifyIfInvalidNameIsGiven(overviewTab);
        verifyIfNameDigitIsGiven(overviewTab);
        verifyIfCompanyNameIsEmpty(overviewTab);
        verifyIfCompanyNameIsEntered(overviewTab);
        verifyIfInvalidWorkPhoneIsEntered(overviewTab);
        verifyInvalidCharacterInWorkPhoneIsEntered(overviewTab);
        verifyIfWorkPhoneIsEmpty(overviewTab);
        verifyIfInvalidMobilePhoneIsEntered(overviewTab);
        verifyInvalidCharacterInMobileNumIsEntered(overviewTab);
        verifyIfMobileNumIsEmpty(overviewTab);
        verifyIfAddressFieldIsEmpty(overviewTab);
        verifyIfInvalidDataEnteredInAddress1(overviewTab);
        verifyIfAddressField2IsEmpty(overviewTab);
        verifyIfInvalidAddressField2IsEntered(overviewTab);
        verifyIfCityIsLeftEmpty(overviewTab);
        verifyIfInvalidCityDataIsEntered(overviewTab);
        verifyIfStateIsEmpty(overviewTab);
        verifyIfZipCodeLeftEmpty(overviewTab);
        verifyIfInvalidZipCodeIsEntered(overviewTab);
        verifyCountOfCharInDescYoursef(overviewTab);
        verifyIfCharactersAreMoreThanLimit(overviewTab);
}

    public void verifyIfNameFieldIsEmpty(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("name");
        overviewTab.setName("");
        overviewTab = overviewTab.saveOverviewDetails();

        String emptyNameField = overviewTab.getErrorMessageOfInvalidName();
        Assert.assertEquals(emptyNameField, invalidTestData.get("errorMsg3"), "The proper error message for empty name field is not displayed");
        AutomationLog.info("The appropriate error message found in overview tab when the name field is left empty");
    }

    public void verifyIfInvalidNameIsGiven(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("name");
        overviewTab.setName(invalidTestData.get("invalid"));
        overviewTab = overviewTab.saveOverviewDetails();

        String invalidNameField = overviewTab.getErrorMessageOfInvalidName();
        Assert.assertEquals(invalidNameField, invalidTestData.get("errorMsg1"), "The proper error message for invalid name is not displayed");
        AutomationLog.info("The appropriate error message found in overview tab when the invalid name is entered");
    }

    public void verifyIfNameDigitIsGiven(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("name");
        overviewTab.setName(invalidTestData.get("withDigit"));
        overviewTab = overviewTab.saveOverviewDetails();

        String invalidNameOrder = overviewTab.getErrorMessageOfInvalidName();
        Assert.assertEquals(invalidNameOrder, invalidTestData.get("errorMsg2"), "The proper error message for invalid name is not displayed when name with digit is entered");
        AutomationLog.info("The appropriate error message found in overview tab when name with digit is entered");
    }

    public void verifyIfCompanyNameIsEmpty(OverviewTab overviewTab) throws Exception
    {
        overviewTab.setCompanyName("");
        overviewTab = overviewTab.saveOverviewDetails();

        String emptyCompanyName = overviewTab.getTextBoxCompanyName();
        Assert.assertEquals(emptyCompanyName, "" , "There is no error message when company is empty");
        AutomationLog.info("Company name do not show any error message when left empty");
    }

    public void verifyIfCompanyNameIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("company");
        overviewTab.setCompanyName(invalidTestData.get("alphanumeric"));
        overviewTab = overviewTab.saveOverviewDetails();

        String emptyCompanyName = overviewTab.getTextBoxCompanyName();
        Assert.assertEquals(emptyCompanyName, invalidTestData.get("alphanumeric") , "The proper error message for company name is not displayed when the company name is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the company name is entered");
    }

    public void verifyIfInvalidWorkPhoneIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("workPhone");
        overviewTab.setWorkPhone(invalidTestData.get("invalidWorkPhone"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterWorkPhoneNum = overviewTab.getErrorMessageOfInvalidPhoneNum();
        Assert.assertEquals(enterWorkPhoneNum, invalidTestData.get("errorMsg1"), "The proper error message for Invalid Workphone is not displayed when the invalid Workphone is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the Invalid workphone number is entered");
    }

    public void verifyInvalidCharacterInWorkPhoneIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("workPhone");
        overviewTab.setWorkPhone(invalidTestData.get("withAlphaChar"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidCharWorkPhoneNum = overviewTab.getErrorMessageOfInvalidPhoneNum();
        Assert.assertEquals(enterInvalidCharWorkPhoneNum, invalidTestData.get("errorMsg1"), "The proper error message for Invalid Workphone is not displayed when the special Character is entered");
        AutomationLog.info("The appropriate error message found in overview tab for WorkPhone when Special character is entered");
    }

    public void verifyIfWorkPhoneIsEmpty(OverviewTab overviewTab) throws Exception
    {
        overviewTab.setWorkPhone("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterWorkphoneEmpty = overviewTab.getTextBoxWorkPhoneNumber();
        Assert.assertEquals(enterWorkphoneEmpty, "", "The proper error message for Empty Workphone is not displayed when the workphone is empty");
        AutomationLog.info("No error message was shown when the Work Phone is left empty");
    }

    public void verifyIfInvalidMobilePhoneIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("mobilePhone");
        overviewTab.setMobilephone(invalidTestData.get("invalidMobileNumber"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterMobilePhoneNum = overviewTab.getErrorMessageOfInvalidMobileNum();
        Assert.assertEquals(enterMobilePhoneNum, invalidTestData.get("errorMsg1"), "The proper error message for mobile number is not displayed when the Invalid mobile number is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the Invalid mobile number is entered");
    }

    public void verifyInvalidCharacterInMobileNumIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("mobilePhone");
        overviewTab.setMobilephone(invalidTestData.get("withAlphaNumChar"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidCharMobileNum = overviewTab.getErrorMessageOfInvalidMobileNum();
        Assert.assertEquals(enterInvalidCharMobileNum, invalidTestData.get("errorMsg1"), "The proper error message for Invalid mobile number is not displayed when the character is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the Invalid mobile number character is entered");
    }

    public void verifyIfMobileNumIsEmpty(OverviewTab overviewTab) throws Exception
    {
        overviewTab.setMobilephone("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterWorkphoneEmpty = overviewTab.getTextBoxMobileNumber();
        Assert.assertEquals(enterWorkphoneEmpty, "", "The proper error message for Empty Mobile number is not displayed when the Mobile number is empty");
        AutomationLog.info("No error message was shown when the Mobile number is left empty");
    }

    public void verifyIfAddressFieldIsEmpty(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("address1");
        overviewTab.setAddress1("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyAddress1 = overviewTab.getErrorMessageOfEmptyAddressField();
        Assert.assertEquals(enterEmptyAddress1, invalidTestData.get("emptyErrorAddressMsg"), "The proper error message for AddressField1 is not displayed when the AddressField1 is empty");
        AutomationLog.info("The appropriate error message found in overview tab when the Addressfield1 is left empty");
    }

    public void verifyIfInvalidDataEnteredInAddress1(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("address1");
        overviewTab.setAddress1(invalidTestData.get("invalidAddress1"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidAddress1 = overviewTab.getErrorMessageOfEmptyAddressField();
        Assert.assertEquals(enterInvalidAddress1, invalidTestData.get("invalidDataErrorMsg2"), "The proper error message for AddressField1 is not displayed when the invalid data is entered in AddressField1");
        AutomationLog.info("The appropriate error message found in overview tab when the invalid data is entered in Addressfield1");
    }

    public void verifyIfAddressField2IsEmpty(OverviewTab overviewTab) throws Exception
    {
        overviewTab.setAddress2("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyAddress2 = overviewTab.getTextBoxAddress2();
        Assert.assertEquals(enterEmptyAddress2, "", "The proper error message for AddressField2 is not displayed when the AddressField1 is empty");
        AutomationLog.info("No error message was found when AddressField 2 is left empty");
    }

    public void verifyIfInvalidAddressField2IsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("address2");
        overviewTab.setAddress2(invalidTestData.get("invalidAddress2"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidAddress2 = overviewTab.getErrorMessageOfAddressField2();
        Assert.assertEquals(enterInvalidAddress2, invalidTestData.get("invalidErrorMsg"), "The proper error message for AddressField2 is not displayed when the invalid AddressField2 is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the invalid AddressField2 is entered");
    }

    public void verifyIfCityIsLeftEmpty(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("city");
        overviewTab.setCity("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyCity = overviewTab.getErrorMessageOfCityWhenLeftEmpty();
        Assert.assertEquals(enterEmptyCity, invalidTestData.get("errorMsg1"), "The proper error message for city is not displayed when the city is left empty");
        AutomationLog.info("The appropriate error message found in overview tab when the city is left empty ");
    }

    public void verifyIfInvalidCityDataIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("city");
        overviewTab.setCity(invalidTestData.get("invalidCity"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidCity = overviewTab.getErrorMessageOfCityWhenLeftEmpty();
        Assert.assertEquals(enterInvalidCity, invalidTestData.get("errorMsg2"), "The proper error message for city is not displayed when the invalid city name is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the the invalid city name is entered ");
    }

    public void verifyIfStateIsEmpty(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("state");
        overviewTab.setState("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyState = overviewTab.getErrorMessageOfStateWhenLeftEmpty();
        Assert.assertEquals(enterEmptyState, invalidTestData.get("errorMsg"), "The proper error message for State is not displayed when the State is empty");
        AutomationLog.info("The appropriate error message found in overview tab when the when the State is empty");
    }

    public void verifyIfZipCodeLeftEmpty(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("zipCode");
        overviewTab.setZipCode("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyZip = overviewTab.getErrorMessageOfZip();
        Assert.assertEquals(enterEmptyZip, invalidTestData.get("errorMsg1"), "The proper error message for Zip code is not displayed when the Zip code is left empty");
        AutomationLog.info("The appropriate error message found in overview tab when the Zip code is left empty ");
    }

    public void verifyIfInvalidZipCodeIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("zipCode");
        overviewTab.setZipCode(invalidTestData.get("invalidZip"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidZip = overviewTab.getErrorMessageOfZip();
        Assert.assertEquals(enterInvalidZip, invalidTestData.get("errorMsg2"), "The proper error message for Zip code is not displayed when the invalid Zip code is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the invalid Zip code is entered ");
    }

    public void verifyCountOfCharInDescYoursef(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("describeYourself");
        overviewTab.setCountCharacter(invalidTestData.get("countCharacter"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterTotalCount = overviewTab.getTheCountOfDescYourself();
        Assert.assertEquals(enterTotalCount, invalidTestData.get("countMsgData"), "The proper count of character of describe yourself not found");
        AutomationLog.info("The appropriate count of character of describe yourself found ");
    }

    public void verifyIfCharactersAreMoreThanLimit(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("maxLimit");
        overviewTab.setCountCharacter(invalidTestData.get("maxLimitOfChar"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterTotalCountExceeds = overviewTab.getTheCountOfDescYourself();
        Assert.assertEquals(enterTotalCountExceeds, invalidTestData.get("countMsgData"), "The proper count of character of describe yourself not found when the character excceds then the limit");
        AutomationLog.info("The appropriate count of character of describe yourself found when the character excceds then the limit ");
    }

    @Override
    protected String successMessage()
    {
        return "Overview tab Negative action tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Overview tab Negative action failed";
    }
}
