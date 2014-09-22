package com.agorafy.automation.testcases;

import org.testng.annotations.Test;
import com.agorafy.automation.appmodules.OverviewAction;

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
