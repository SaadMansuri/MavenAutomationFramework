package com.agorafy.automation.appmodules;

import java.util.Iterator;

import org.openqa.selenium.By;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPage;
import com.agorafy.automation.pageobjects.OverviewTab;
import com.agorafy.automation.pageobjects.Page;

public class OverviewAction extends AutomationTestCase 
{
    private Homepage homePage = null;
    private LoginPage loginpage = null;

    public OverviewAction() 
    {
        super(OverviewAction.class.getName());
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
			WaitFor.presenceOfTheElement(Page.driver, homePage.getGreetingsLocator());
			Header header = homePage.header();
			header.openActiveProfile();
			// Verify Drowndown is displayed.
			Dashboard dashboard = header.openDashboard();
			//Verify this is the correct dashboard.
			OverviewTab overviewTab = dashboard.editProfile();
			// Verify this is the correct OverviewTab tab.
			toEnterNameEmailCompanyName(overviewTab);
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
	
	public void toEnterNameEmailCompanyName(OverviewTab overviewTab) throws Exception
	{
	    // Get overview data from CSV.
	    overviewTab.txtbx_Name().clear();
	    overviewTab.txtbx_Name().sendKeys("Anjan");
	    overviewTab.txtbx_CompanyName().clear();
	    overviewTab.txtbx_CompanyName().sendKeys("Cuelogic");
	    overviewTab.txtbx_MobilenNum().clear();
	    overviewTab.txtbx_MobilenNum().sendKeys("997-561-8858");
	}
	
	public void toVerifyBannerDetails(OverviewTab overviewTab) throws Exception 
	{
	    overviewTab.link_Here().click();
		Iterator<String> AllWindowsOpen= Page.driver.getWindowHandles().iterator();  //get handles of all open windows, here 2 windows will be found
	    String parent = AllWindowsOpen.next();
	    String child = AllWindowsOpen.next();
	    Page.driver.switchTo().window(child);
	    
		
	}

}
