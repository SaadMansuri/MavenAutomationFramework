package com.agorafy.automation.appmodules;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.OverviewData;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;
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
 * Click on submit.
 * Verify Profile is updated.
 */
public class OverviewAction extends AutomationTestCase 
{
    private Homepage homePage = null;
    private LoginPage loginpage = null;
    OverviewTab overviewTab;

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
			//Verify this is the correct dashboard.
			OverviewTab overviewTab = dashboard.editProfile();
			// Verify this is the correct OverviewTab tab.
			populateAndVerifyOverviewDetails(overviewTab);

			//OverviewTab.btn_Save().click();
			testcasePassed("Test is successfully perfomred");
		} catch (Exception e) {
			// TODO: handle exception
			AutomationLog.error("Save button could not be found");
			testcaseFailed("Overview Action  Failed");
			throw (e);
		}
		finally
		{
			cleanup();
		}
	}

	public void populateAndVerifyOverviewDetails(OverviewTab overviewTab) throws Exception
	{
		// TODO: Get this data from CSV files
		OverviewData overviewData = new OverviewData();
		overviewData.setName("Bnju");
		overviewData.setCompanyName("Titan");
		overviewData.setWorkPhone("234-567-7890");
		overviewData.setMobilePhone("779-585-5190");
		overviewData.setAddress1("New Jersey");
		overviewData.setAddress2("Los Angeles");
		overviewData.setCity("california");
		overviewData.setState("Georgia");
		overviewData.setZipCode("12345");
		overviewData.setDescribe("how are you?");
		overviewData.setNeighbour("Little Italy");

		overviewTab.populateOverviewDetails(overviewData);
		overviewTab = overviewTab.saveOverviewDetails();
		WaitFor.waitForPageToLoad(Page.driver, overviewData.getName(), overviewTab.getBannerTextLocater());
		verifyBannerDetails(overviewTab, overviewData);
	}
	
	public void verifyBannerDetails(OverviewTab overviewTab, OverviewData overviewData) throws Exception 
	{
		String newBannerNameAfterSavingOverviewData = overviewTab.getBannerText();
		if (!overviewData.getName().equals(newBannerNameAfterSavingOverviewData)) 
		{
			throw new IllegalStateException("This is not the correctBanner which we are looking for");
		}
	}
}
