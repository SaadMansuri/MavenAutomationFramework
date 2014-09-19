package com.agorafy.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.TestNG;
import org.testng.annotations.Test;

import com.agorafy.automation.appmodules.OverviewAction;
import com.agorafy.automation.automationframework.AppDriver;

public class ProfileOverviewTest 
{
	@Test
	public void Test() 
	{
		
		try
		{
			
			new OverviewAction().Execute();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

}
