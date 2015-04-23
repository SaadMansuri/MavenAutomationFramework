package com.agorafy.automation.testcases.editprofile;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.editprofile.OverviewTab;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.utilities.Login;

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
    private Dashboard dashboard = null;
    private OverviewTab overviewTab = null;
    private HashMap<String, String> invalidTestData = null;
	private SubNavigation subnavigation = null;
	private Header header;
    static HashMap<String,String> stateAbbMap;

    public OverviewTabNegativeAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        try
        {
            homePage = Login.doSuccessfullLoginFromHeaderLoginForm();
/*            header = Header.header();
            headerLoginForm = header.openHeaderLoginForm();
            Credentials ValidCredentials = userCredentials();
            homePage = headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
*/            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());

            subnavigation  = Page.subNavigation();
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
        Assert.assertEquals(emptyNameField, invalidTestData.get("errorMsg3"), "Expected error message for empty name field is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for empty name field is displayed in Overview Tab");
    }

    public void verifyIfInvalidNameIsGiven(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("name");
        overviewTab.setName(invalidTestData.get("invalid"));
        overviewTab = overviewTab.saveOverviewDetails();

        String invalidNameField = overviewTab.getErrorMessageOfInvalidName();
        Assert.assertEquals(invalidNameField, invalidTestData.get("errorMsg1"), "Expected error message for invalid name field is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for invalid name field is displayed in Overview Tab");
    }

    public void verifyIfNameDigitIsGiven(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("name");
        overviewTab.setName(invalidTestData.get("withDigit"));
        overviewTab = overviewTab.saveOverviewDetails();

        String invalidNameOrder = overviewTab.getErrorMessageOfInvalidName();
        Assert.assertEquals(invalidNameOrder, invalidTestData.get("errorMsg2"), "Expected error message for invalid name with digit is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for invalid name with digit is displayed in Overview Tab");
    }

    public void verifyIfCompanyNameIsEmpty(OverviewTab overviewTab) throws Exception
    {
        overviewTab.setCompanyName("");
        overviewTab = overviewTab.saveOverviewDetails();

        String emptyCompanyName = overviewTab.getTextBoxCompanyName();
        Assert.assertEquals(emptyCompanyName, "" , " No error message is displayed when company field is left empty in Overview Tab");
        AutomationLog.info("Company name do not show any error message when left empty in Overview Tab");
    }

    public void verifyIfCompanyNameIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("company");
        overviewTab.setCompanyName(invalidTestData.get("alphanumeric"));
        overviewTab = overviewTab.saveOverviewDetails();

        String companyName = overviewTab.getTextBoxCompanyName();
        Assert.assertEquals(companyName, invalidTestData.get("alphanumeric") , "Error message is displayed when company name with alphanumeric characters is entered in Overview Tab");
        AutomationLog.info("Company name does not show any error message when alphanumeric character is entered in Overview Tab");
    }

    public void verifyIfInvalidWorkPhoneIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("workPhone");
        overviewTab.setWorkPhone(invalidTestData.get("invalidWorkPhone"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterWorkPhoneNum = overviewTab.getErrorMessageOfInvalidPhoneNum();
        Assert.assertEquals(enterWorkPhoneNum, invalidTestData.get("errorMsg1"), "Expected error message for Invalid work phone is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for Invalid work phone is displayed in Overview Tab");
    }

    public void verifyInvalidCharacterInWorkPhoneIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("workPhone");
        overviewTab.setWorkPhone(invalidTestData.get("withAlphaChar"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidCharWorkPhoneNum = overviewTab.getErrorMessageOfInvalidPhoneNum();
        Assert.assertEquals(enterInvalidCharWorkPhoneNum, invalidTestData.get("errorMsg1"), "Expected error message for Invalid work phone with character is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for Invalid work phone with character is displayed in Overview Tab");
    }

    public void verifyIfWorkPhoneIsEmpty(OverviewTab overviewTab) throws Exception
    {
        overviewTab.setWorkPhone("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterWorkphoneEmpty = overviewTab.getTextBoxWorkPhoneNumber();
        Assert.assertEquals(enterWorkphoneEmpty, "", "Expected error message for Empty work phone is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for empty work phone is displayed in Overview Tab");
    }

    public void verifyIfInvalidMobilePhoneIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("mobilePhone");
        overviewTab.setMobilephone(invalidTestData.get("invalidMobileNumber"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterMobilePhoneNum = overviewTab.getErrorMessageOfInvalidMobileNum();
        Assert.assertEquals(enterMobilePhoneNum, invalidTestData.get("errorMsg1"), "Expected error message for Invalid mobile phone is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for Invalid mobile phone is displayed in Overview Tab");
    }

    public void verifyInvalidCharacterInMobileNumIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("mobilePhone");
        overviewTab.setMobilephone(invalidTestData.get("withAlphaNumChar"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidCharMobileNum = overviewTab.getErrorMessageOfInvalidMobileNum();
        Assert.assertEquals(enterInvalidCharMobileNum, invalidTestData.get("errorMsg1"), "Expected error message for Invalid mobile phone with character is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for Invalid mobile phone with character is displayed in Overview Tab");
    }

    public void verifyIfMobileNumIsEmpty(OverviewTab overviewTab) throws Exception
    {
        overviewTab.setMobilephone("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterWorkphoneEmpty = overviewTab.getTextBoxMobileNumber();
        Assert.assertEquals(enterWorkphoneEmpty, "", "Expected error message for empty mobile phone is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for empty mobile phone is displayed in Overview Tab");
    }

    public void verifyIfAddressFieldIsEmpty(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("address1");
        overviewTab.setAddress1("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyAddress1 = overviewTab.getErrorMessageOfEmptyAddressField();
        Assert.assertEquals(enterEmptyAddress1, invalidTestData.get("emptyErrorAddressMsg"), "Expected error message for empty Address1 is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for empty Address1 is displayed in Overview Tab");
    }

    public void verifyIfInvalidDataEnteredInAddress1(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("address1");
        overviewTab.setAddress1(invalidTestData.get("invalidAddress1"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidAddress1 = overviewTab.getErrorMessageOfEmptyAddressField();
        Assert.assertEquals(enterInvalidAddress1, invalidTestData.get("invalidDataErrorMsg2"), "Expected error message for Address1 with invalid data is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for Address1 with invalid data is displayed in Overview Tab");
    }

    public void verifyIfAddressField2IsEmpty(OverviewTab overviewTab) throws Exception
    {
        overviewTab.setAddress2("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyAddress2 = overviewTab.getTextBoxAddress2();
        Assert.assertEquals(enterEmptyAddress2, "", "Expected error message for empty Address2 is not displayed in Overview Tab");
        AutomationLog.info("No error message displayed for empty Address2 field in Overview Tab");
    }

    public void verifyIfInvalidAddressField2IsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("address2");
        overviewTab.setAddress2(invalidTestData.get("invalidAddress2"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidAddress2 = overviewTab.getErrorMessageOfAddressField2();
        Assert.assertEquals(enterInvalidAddress2, invalidTestData.get("invalidErrorMsg"), "Expected error message for Address2 with invalid data is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for Address2 with invalid data is displayed in Overview Tab");
    }

    public void verifyIfCityIsLeftEmpty(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("city");
        overviewTab.setCity("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyCity = overviewTab.getErrorMessageOfCityWhenLeftEmpty();
        Assert.assertEquals(enterEmptyCity, invalidTestData.get("errorMsg1"), "Expected error message for Empty City is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for Empty City is displayed in Overview Tab");
    }

    public void verifyIfInvalidCityDataIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("city");
        overviewTab.setCity(invalidTestData.get("invalidCity"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidCity = overviewTab.getErrorMessageOfCityWhenLeftEmpty();
        Assert.assertEquals(enterInvalidCity, invalidTestData.get("errorMsg2"), "Expected error message for City with invalid data is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for City with invalid data is displayed in Overview Tab");
    }

    public void verifyIfStateIsEmpty(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("state");
        overviewTab.setState("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyState = overviewTab.getErrorMessageOfStateWhenLeftEmpty();
        Assert.assertEquals(enterEmptyState, invalidTestData.get("errorMsg"), "Expected error message for Empty State is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for Empty State is displayed in Overview Tab");
    }

    public void verifyIfZipCodeLeftEmpty(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("zipCode");
        overviewTab.setZipCode("");
        overviewTab = overviewTab.saveOverviewDetails();

        String enterEmptyZip = overviewTab.getErrorMessageOfZip();
        Assert.assertEquals(enterEmptyZip, invalidTestData.get("errorMsg1"), "Expected error message for Empty Zip code is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for Empty Zip code is displayed in Overview Tab");
    }

    public void verifyIfInvalidZipCodeIsEntered(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("zipCode");
        overviewTab.setZipCode(invalidTestData.get("invalidZip"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterInvalidZip = overviewTab.getErrorMessageOfZip();
        Assert.assertEquals(enterInvalidZip, invalidTestData.get("errorMsg2"), "Expected error message for Zip code with invalid data is not displayed in Overview Tab");
        AutomationLog.info("Expected error message for Zip code with invalid data is displayed in Overview Tab");
    }

    public void verifyCountOfCharInDescYoursef(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("describeYourself");
        overviewTab.setCountCharacter(invalidTestData.get("countCharacter"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterTotalCount = overviewTab.getTheCountOfDescYourself();
        Assert.assertEquals(enterTotalCount, invalidTestData.get("countMsgData"), "Expected count of character is not displayed in Overview Tab");
        AutomationLog.info("Expected count of character is displayed in Overview Tab");
    }

    public void verifyIfCharactersAreMoreThanLimit(OverviewTab overviewTab) throws Exception
    {
        invalidTestData = testCaseData.get("maxLimit");
        overviewTab.setCountCharacter(invalidTestData.get("maxLimitOfChar"));
        overviewTab = overviewTab.saveOverviewDetails();

        String enterTotalCountExceeds = overviewTab.getTheCountOfDescYourself();
        Assert.assertEquals(enterTotalCountExceeds, invalidTestData.get("countMsgData"), "Expected count of character is not displayed when the character exceeds the limit in Overview Tab");
        AutomationLog.info("Expected count of character is displayed when the character exceeds the limit in Overview Tab");
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
