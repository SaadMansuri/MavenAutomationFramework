package com.agorafy.automation.appmodules;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.agorafy.automation.automationframework.AppDriver;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCase;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.OverviewTab;

public class OverviewAction extends AutomationTestCase 
{
	SigninAction signinAgorafyObject = new SigninAction();
	WebDriver driver;
	public void setup() 
	{
		super.setup();
//		try 
//		{
//			//driver = new AppDriver().getDriver();
//			//signinAgorafyObject.Execute();	
//		} catch (Exception e) {
//			// TODO: handle exception
//			AutomationLog.error("Login operation unsuccessful");
//		}
//		
		
	}
	
	public void cleanup()
	{
		super.cleanup();
	}
	
	public void Execute()
	{
		try 
		{
			setup();
			signinAgorafyObject.doLogin();
			Header.link_ProfileName().click();
			Header.link_Dashboard().click();
			Dashboard.link_EditProfile().click();
			
			toEnterNameEmailCompanyName();
			OverviewTab.btn_Save().click();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			AutomationLog.error("Save button could not be found");
		}
		finally
		{
			cleanup();
		}
		
	}
	
	public void toEnterNameEmailCompanyName() throws Exception
	
	{
		OverviewTab.txtbx_Name().clear();
		OverviewTab.txtbx_Name().sendKeys("Anjan");
		OverviewTab.txtbx_CompanyName().clear();
		OverviewTab.txtbx_CompanyName().sendKeys("Cuelogic");
		OverviewTab.txtbx_MobilenNum().clear();
		OverviewTab.txtbx_MobilenNum().sendKeys("997-561-8858");
		
		
	}
	
	public void toVerifyBannerDetails() throws Exception 
	{
		OverviewTab.link_Here().click();
		
		Iterator<String> AllWindowsOpen= driver.getWindowHandles().iterator();  //get handles of all open windows, here 2 windows will be found
	    String parent = AllWindowsOpen.next();
	    String child = AllWindowsOpen.next();
	    driver.switchTo().window(child);
	    
		
	}

}
