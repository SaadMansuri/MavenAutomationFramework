package com.agorafy.automation.testcases;

import java.util.HashMap;
import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.OverviewData;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;
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
public class OverviewAction extends AutomationTestCase
{
	private Homepage homePage = null;
	private LoginPage loginpage = null;
	static HashMap<String,String> stateAbbMap;

	public OverviewAction() 
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
			loginpage = homePage.gotoLoginPage();
			homePage = loginpage.doSuccessfulLogin("chandrani.bhagat@cuelogic.co.in", "cuelogic77");
			// Verify this is the correct homepage.
			WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());

			Header header = homePage.header();
			header.openActiveProfile();

			// Verify Drowndown is displayed.
			Dashboard dashboard = header.openDashboard();

			// Verify this is the correct dashboard.
			OverviewTab overviewTab = dashboard.editProfile();

			// Verify this is the correct OverviewTab tab.
			populateAndVerifyOverviewDetails(overviewTab);

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

	private void handleTestCaseFailure(String message) throws Exception 
	{
		AutomationLog.error("Overview Action  Failed: " + message);
		testcaseFailed("Overview Action  Failed" + message);
		throw (new Exception("Overview Action  Failed" + message));
	}

	public void populateAndVerifyOverviewDetails(OverviewTab overviewTab) throws Exception
	{
		OverviewData overviewData = getTestOverviewData();

		overviewTab.populateOverviewDetails(overviewData);
		overviewTab = overviewTab.saveOverviewDetails();

		OverviewBanner banner  = overviewTab.banner();
		WaitFor.waitForPageToLoad(Page.driver, overviewData.getName(),banner.getBannerTextLocater());

		verifyUpdatedOverviewBanner(banner, overviewData);
		verifyUpdatedOverviewTabForm(overviewTab, overviewData);
	}

	private OverviewData getTestOverviewData()
	{
		OverviewData overviewData = new OverviewData();
		overviewData.setName("yanju");
		overviewData.setCompanyName("reccent");
		overviewData.setWorkPhone("234-567-7890");
		overviewData.setMobilePhone("779-585-5190");
		overviewData.setAddress1("New Jersey");
		overviewData.setAddress2("Los Angeles");
		overviewData.setCity("california");
		overviewData.setState("Georgia");
		overviewData.setZipCode("12345");
		overviewData.setDescribe("how are you?");
		overviewData.setNeighbour("Little Italy");

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
		Assert.assertEquals(newBannerNameAfterSavingOverviewData, overviewData.getName(), "This is not the correct Name which we are looking for");
		AutomationLog.info("Updated Name Displayed succesffully on Banner");
	}

	public void verifyTextBoxName(OverviewTab overviewTab,OverviewData overviewData) throws Exception
	{
		String verifyNamePresentInTextBox=overviewTab.getTextBoxName();
		Assert.assertEquals(verifyNamePresentInTextBox, overviewData.getName(), "This is not the correct Name which we are looking for");
		AutomationLog.info("Name found As per the Text Box");
	}

	public void verifyTextBoxComapnyName(OverviewTab overviewTab,OverviewData overviewData) throws Exception
	{
		String verifyComapnyNamePresentInTextBox=overviewTab.getTextBoxCompanyName();
		Assert.assertEquals(verifyComapnyNamePresentInTextBox, overviewData.getCompanyName(), "This is not the correct ComapnyName which we are looking for");
		AutomationLog.info("CompanyName found As per the Text Box");
	}

	public void verifyTextBoxMobilePhoneNumber(OverviewTab overviewTab,OverviewData overviewData) throws Exception
	{
		String verifyWorkMobileNumberPresentInTextBox=overviewTab.getTextBoxMobileNumber();
		Assert.assertEquals(verifyWorkMobileNumberPresentInTextBox, overviewData.getMobilePhone(), "This is not the correct MobileNumber which we are looking for");
		AutomationLog.info("MobileNumber found As per the Text Box");
	}

	public void verifyTextBoxWorkPhoneNumber(OverviewTab overviewTab,OverviewData overviewData) throws Exception
	{
		String verifyWorkPhoneNumberPresentInTextBox=overviewTab.getTextBoxWorkPhoneNumber();
		Assert.assertEquals(verifyWorkPhoneNumberPresentInTextBox, overviewData.getWorkPhone(), "This is not the correct WorkPhoneNumber which we are looking for");
		AutomationLog.info("WorkPhoneNumber found As per the Text Box");
	}

	public void verifyTextBoxAddress1(OverviewTab overviewTab,OverviewData overviewData) throws Exception
	{
		String verifyAddress1PresentInTextBox=overviewTab.getTextBoxAddress1();
		Assert.assertEquals(verifyAddress1PresentInTextBox, overviewData.getAddress1(), "This is not the correct Address1 which we are looking for");
		AutomationLog.info("Address1 found As per the Text Box");
	}

	public void verifyTextBoxAddress2(OverviewTab overviewTab,OverviewData overviewData) throws Exception
	{
		String verifyAddress2PresentInTextBox=overviewTab.getTextBoxAddress2();
		Assert.assertEquals(verifyAddress2PresentInTextBox, overviewData.getAddress2(), "This is not the correct Address2 which we are looking for");
		AutomationLog.info("Address2 found As per the Text Box");
	}

	public void verifyTextBoxCity(OverviewTab overviewTab,OverviewData overviewData) throws Exception
	{
		String verifyCityPresentInTextBox=overviewTab.getTextBoxCity();
		Assert.assertEquals(verifyCityPresentInTextBox, overviewData.getCity(), "This is not the correct City which we are looking for");
		AutomationLog.info("City found As per the Text Box");
	}

	public void verifyTextBoxState(OverviewTab overviewTab,OverviewData overviewData) throws Exception
	{
		String verifyStatePresentInTextBox=overviewTab.getDropdownState();
		Assert.assertEquals(verifyStatePresentInTextBox, overviewData.getState(), "This is not the correct State which we are looking for");
		AutomationLog.info("State found As per the Text Box");
	}

	public void verifyTextBoxZip(OverviewTab overviewTab,OverviewData overviewData) throws Exception
	{
		String verifyZipPresentInTextBox=overviewTab.getTextBoxZip();
		Assert.assertEquals(verifyZipPresentInTextBox, overviewData.getZipCode(), "This is not the correct Zip which we are looking for");
		AutomationLog.info("Zip found As per the Text Box");
	}

	public void verifyTextBoxDescribeYourself(OverviewTab overviewTab,OverviewData overviewData) throws Exception
	{
		String verifydescribeYourselfPresentInTextBox=overviewTab.getTextBoxDescribeYorself();
		Assert.assertEquals(verifydescribeYourselfPresentInTextBox, overviewData.getDescribe(), "This is not the description which we are looking for");
		AutomationLog.info("Description found As per the Text Box");
	}

	public void verifyTextBoxNeigborhood(OverviewTab overviewTab,OverviewData overviewData) throws Exception
	{
		String verifyNeighborhoodPresentInTextBox=overviewTab.getMultipleSelectNeighborhood();
		Assert.assertEquals(verifyNeighborhoodPresentInTextBox, overviewData.getNeighbour(), "This is not the correct Neighborhood which we are looking for");
		AutomationLog.info("Neighborhood found As per the Text Box");
	}

	public void testBannerAddressDetails(OverviewBanner banner, OverviewData overviewData) throws Exception 
	{
		String addressDetails = banner.getBannerAddressText();
		String addressToken[] = addressDetails.split(", ");
		Assert.assertEquals(addressToken[0], overviewData.getAddress1(), "This is not the correct adrees1 in banner which we are looking for");
		AutomationLog.info(" address1 found in banner");
		
		Assert.assertEquals(addressToken[1], overviewData.getAddress2(), "This is not the correct adrees2 in banner which we are looking for");
		AutomationLog.info(" address2  found in banner");
		
		Assert.assertEquals(addressToken[2], overviewData.getCity(), "This is not the correct City in banner which we are looking for");
		AutomationLog.info(" City  found in banner");
	
		createStateAbbreviationMap();

		String stateAndZipcode[] = addressToken[3].split(" ");
		String abbreviation = getStateAbbreviation(overviewData.getState());
		Assert.assertEquals(stateAndZipcode[0], abbreviation, "This is not the correct State in banner which we are looking for");
		AutomationLog.info(" State  found in banner");
		
		Assert.assertEquals(stateAndZipcode[1], overviewData.getZipCode(), "This is not the correct Zip in banner which we are looking for");
		AutomationLog.info(" Zip  found in banner");
	}

	public void testBannerPhoneDetails(OverviewBanner banner, OverviewData overviewData) throws Exception 
	{
		String phoneDetails = banner.getBannerWorkPhoneText();
		String phoneToken[] = phoneDetails.split(": ");
		String formattedPhoneNumber = formatPhoneNumber(overviewData.getWorkPhone());
		Assert.assertEquals(phoneToken[1], formattedPhoneNumber, "This is not the correct WorkPhone in banner which we are looking for");
		AutomationLog.info("WorkPhone found in banner");
	}

	public void testBannerMobileDetails(OverviewBanner banner,OverviewData overviewData) throws Exception
    {
		String mobileDetails = banner.getBannerMobilePhoneText();
		String mobileToken[] = mobileDetails.split(": ");
		String formattedMobileNumber=formatPhoneNumber(overviewData.getMobilePhone());
		Assert.assertEquals(mobileToken[1], formattedMobileNumber, "This is not the MobilePhone in banner which we are looking for");
		AutomationLog.info("MobilePhone found in banner");
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
}