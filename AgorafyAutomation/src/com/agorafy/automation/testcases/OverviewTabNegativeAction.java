package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.OverviewTab;
import com.agorafy.automation.pageobjects.Page;

public class OverviewTabNegativeAction extends AutomationTestCase
{
    private Homepage homePage = null;
    private HeaderLoginForm headerLoginForm = null;
    static HashMap<String,String> stateAbbMap;

    public OverviewTabNegativeAction()
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

            HashMap<String, String> loginData =  testCaseData.get("validCredential");
            String UserName = loginData.get("username");
            String Password = loginData.get("password");

            homePage = headerLoginForm.doSuccessfulLogin(UserName, Password);
            // Verify this is the correct homepage.
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());

            Header header = Page.header();
            header.openActiveProfile();

            // Verify header is displayed.
            Dashboard dashboard = header.openDashboard();

            // Verify this is the correct dashboard.
            OverviewTab overviewTab = dashboard.editProfile();

            // Verify this is the correct OverviewTab tab.
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

            testcasePassed("Overview Action perfomed successfully.");
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

    public void handleTestCaseFailure(String message) throws Exception
    {
        AutomationLog.error("Overview Tab Negative Action Failed: " + message);
        testcaseFailed("Overview Tab Negative Action  Failed" + message);
        throw (new Exception("Overview Tab Negative Action  Failed" + message));
    }

    public void verifyIfNameFieldIsEmpty(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> nameTestData = testCaseData.get("name");
        overviewTab.setName("");
        overviewTab = overviewTab.saveOverviewDetails();

        String emptyNameField = overviewTab.getErrorMessageOfInvalidName();
        Assert.assertEquals(emptyNameField, nameTestData.get("errorMsg3"), "The proper error message for empty name field is not displayed");
        AutomationLog.info("The appropriate error message found in overview tab when the name field is left empty");
    }

    public void verifyIfInvalidNameIsGiven(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> nameTestData = testCaseData.get("name");
        overviewTab.setName(nameTestData.get("invalid"));
        overviewTab = overviewTab.saveOverviewDetails();

        String invalidNameField = overviewTab.getErrorMessageOfInvalidName();
        Assert.assertEquals(invalidNameField, nameTestData.get("errorMsg1"), "The proper error message for invalid name is not displayed");
        AutomationLog.info("The appropriate error message found in overview tab when the invalid name is entered");
    }

    public void verifyIfNameDigitIsGiven(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> nameTestData = testCaseData.get("name");
        overviewTab.setName(nameTestData.get("withDigit"));
        overviewTab = overviewTab.saveOverviewDetails();

        String invalidNameOrder = overviewTab.getErrorMessageOfInvalidName();
        Assert.assertEquals(invalidNameOrder, nameTestData.get("errorMsg2"), "The proper error message for invalid name is not displayed when name with digit is entered");
        AutomationLog.info("The appropriate error message found in overview tab when name with digit is entered");
    }

    public void verifyIfCompanyNameIsEmpty(OverviewTab overviewTab) throws Exception
    {
        overviewTab.setCompanyName("");
        overviewTab = overviewTab.saveOverviewDetails();

        String emptyCompanyName = overviewTab.getTextBoxCompanyName();
        Assert.assertEquals(emptyCompanyName, "" , "The proper error message for company name is not displayed");
        AutomationLog.info("The appropriate error message found in overview tab when the company name is empty");
    }

    public void verifyIfCompanyNameIsEntered(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> companyTestData = testCaseData.get("company");
        overviewTab.setCompanyName(companyTestData.get("alphanumeric"));
        overviewTab = overviewTab.saveOverviewDetails();

        String emptyCompanyName = overviewTab.getTextBoxCompanyName();
        Assert.assertEquals(emptyCompanyName, companyTestData.get("alphanumeric") , "The proper error message for company name is not displayed when the company name is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the company name is entered");
    }

    public void verifyIfInvalidWorkPhoneIsEntered(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> workPhoneTestData = testCaseData.get("workPhone");
        overviewTab.setWorkPhone(workPhoneTestData.get("invalidWorkPhone"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterWorkPhoneNum = overviewTab.getErrorMessageOfInvalidPhoneNum();
        Assert.assertEquals(enterWorkPhoneNum, workPhoneTestData.get("errorMsg1"), "The proper error message for Invalid Workphone is not displayed when the Workphone is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the Invalid workphone number is entered");
    }

    public void verifyInvalidCharacterInWorkPhoneIsEntered(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> workPhoneTestData = testCaseData.get("workPhone");
        overviewTab.setWorkPhone(workPhoneTestData.get("withAlphaChar"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidCharWorkPhoneNum = overviewTab.getErrorMessageOfInvalidPhoneNum();
        Assert.assertEquals(enterInvalidCharWorkPhoneNum, workPhoneTestData.get("errorMsg1"), "The proper error message for Invalid Workphone is not displayed when the special Character is entered");
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
        HashMap<String, String> mobilePhoneTestData = testCaseData.get("mobilePhone");
        overviewTab.setMobilephone(mobilePhoneTestData.get("invalidMobileNumber"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterMobilePhoneNum = overviewTab.getErrorMessageOfInvalidMobileNum();
        Assert.assertEquals(enterMobilePhoneNum, mobilePhoneTestData.get("errorMsg1"), "The proper error message for Invalid mobile number is not displayed when the mobile number is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the Invalid mobile number is entered");
    }

    public void verifyInvalidCharacterInMobileNumIsEntered(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> mobilePhoneTestData = testCaseData.get("mobilePhone");
        overviewTab.setMobilephone(mobilePhoneTestData.get("withAlphaNumChar"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidCharMobileNum = overviewTab.getErrorMessageOfInvalidMobileNum();
        Assert.assertEquals(enterInvalidCharMobileNum, mobilePhoneTestData.get("errorMsg1"), "The proper error message for Invalid mobile number is not displayed when the character is entered");
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
    	HashMap<String, String> address1TestData = testCaseData.get("address1");
        overviewTab.setAddress1("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyAddress1 = overviewTab.getErrorMessageOfEmptyAddressField();
        Assert.assertEquals(enterEmptyAddress1, address1TestData.get("emptyErrorAddressMsg"), "The proper error message for AddressField1 is not displayed when the AddressField1 is empty");
        AutomationLog.info("The appropriate error message found in overview tab when the Addressfield1 is left empty");
    }

    public void verifyIfInvalidDataEnteredInAddress1(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> address1TestData = testCaseData.get("address1");
        overviewTab.setAddress1(address1TestData.get("invalidAddress1"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidAddress1 = overviewTab.getErrorMessageOfEmptyAddressField();
        Assert.assertEquals(enterInvalidAddress1, address1TestData.get("invalidDataErrorMsg2"), "The proper error message for AddressField1 is not displayed when the invalid data is entered in AddressField1");
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
        HashMap<String, String> address2TestData = testCaseData.get("address2");
        overviewTab.setAddress2(address2TestData.get("invalidAddress2"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidAddress2 = overviewTab.getErrorMessageOfAddressField2();
        Assert.assertEquals(enterInvalidAddress2, address2TestData.get("invalidErrorMsg"), "The proper error message for AddressField2 is not displayed when the invalid AddressField2 is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the invalid AddressField2 is entered");
    }

    public void verifyIfCityIsLeftEmpty(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> cityTestData = testCaseData.get("city");
        overviewTab.setCity("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyCity = overviewTab.getErrorMessageOfCityWhenLeftEmpty();
        Assert.assertEquals(enterEmptyCity, cityTestData.get("errorMsg1"), "The proper error message for city is not displayed when the city is left empty");
        AutomationLog.info("The appropriate error message found in overview tab when the city is left empty ");
    }

    public void verifyIfInvalidCityDataIsEntered(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> cityTestData = testCaseData.get("city");
        overviewTab.setCity(cityTestData.get("invalidCity"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidCity = overviewTab.getErrorMessageOfCityWhenLeftEmpty();
        Assert.assertEquals(enterInvalidCity, cityTestData.get("errorMsg2"), "The proper error message for city is not displayed when the invalid city name is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the the invalid city name is entered ");
    }

    public void verifyIfStateIsEmpty(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> stateTestData = testCaseData.get("state");
        overviewTab.setState("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyState = overviewTab.getErrorMessageOfStateWhenLeftEmpty();
        Assert.assertEquals(enterEmptyState, stateTestData.get("errorMsg"), "The proper error message for State is not displayed when the State is empty");
        AutomationLog.info("The appropriate error message found in overview tab when the when the State is empty");
    }

    public void verifyIfZipCodeLeftEmpty(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> zipTestData = testCaseData.get("zipCode");
        overviewTab.setZipCode("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyZip = overviewTab.getErrorMessageOfZip();
        Assert.assertEquals(enterEmptyZip, zipTestData.get("errorMsg1"), "The proper error message for Zip code is not displayed when the Zip code is left empty");
        AutomationLog.info("The appropriate error message found in overview tab when the Zip code is left empty ");
    }

    public void verifyIfInvalidZipCodeIsEntered(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> zipTestData = testCaseData.get("zipCode");
        overviewTab.setZipCode(zipTestData.get("invalidZip"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidZip = overviewTab.getErrorMessageOfZip();
        Assert.assertEquals(enterInvalidZip, zipTestData.get("errorMsg2"), "The proper error message for Zip code is not displayed when the invalid Zip code is entered");
        AutomationLog.info("The appropriate error message found in overview tab when the invalid Zip code is entered ");
    }

    public void verifyCountOfCharInDescYoursef(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> countTestData = testCaseData.get("describeYourself");
        overviewTab.setCountCharacter(countTestData.get("countCharacter"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterTotalCount = overviewTab.getTheCountOfDescYourself();
        Assert.assertEquals(enterTotalCount, countTestData.get("countMsgData"), "The proper count of character of describe yourself not found");
        AutomationLog.info("The appropriate count of character of describe yourself found ");
    }

    public void verifyIfCharactersAreMoreThanLimit(OverviewTab overviewTab) throws Exception
    {
        HashMap<String, String> countMaxLimitTestData = testCaseData.get("maxLimit");
        overviewTab.setCountCharacter(countMaxLimitTestData.get("maxLimitOfChar"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterTotalCountExceeds = overviewTab.getTheCountOfDescYourself();
        Assert.assertEquals(enterTotalCountExceeds, countMaxLimitTestData.get("countMsgData"), "The proper count of character of describe yourself not found when the character excceds then the limit");
        AutomationLog.info("The appropriate count of character of describe yourself found when the character excceds then the limit ");
    }
}
