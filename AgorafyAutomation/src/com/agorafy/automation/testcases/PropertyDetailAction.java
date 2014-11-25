package com.agorafy.automation.testcases;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertyDetailPage;

public class PropertyDetailAction extends AutomationTestCaseVerification
{

        PropertyDetailPage propertydetails=new PropertyDetailPage();
	
    public PropertyDetailAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        try
        {
              propertydetails.redirectedToPropertyPage();
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to Property Detail Page");
        }
    }
	
	@Override
	protected void verifyTestCases() throws Exception {
		
		isLoginPopUpPresentVerification(propertydetails);
		
		HashMap<String, String> getvalidcrendial = testCaseData.get("validCredential");
		isAfterLoginSameUrlPresentVerification(propertydetails,getvalidcrendial);
		
	}
	
    public void isLoginPopUpPresentVerification(PropertyDetailPage propertydetails) throws Exception
    {
    	propertydetails.clickOnSignUpUpLink();
    	AutomationLog.info("SignUp Link Click Successfully");
    	Page.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(propertydetails.CheckingLogInPopOnPropertyPage(),true,"Expected form is not present");
        AutomationLog.info("Login in Page is present");
    	Assert.assertEquals(propertydetails.getTitleOfLogInPopUp(),"Log in","Expected Title is not present on Login Pop Up");
        AutomationLog.info("Login Title on Pop-up is verified");
    }
    
    public void isAfterLoginSameUrlPresentVerification(PropertyDetailPage propertydetails,HashMap<String, String> getvalidcrendial) throws Exception
    {
    	String beforeloginUrl=Page.driver.getCurrentUrl();
    	propertydetails.loginProcessOnPropertyPage(getvalidcrendial.get("username"), getvalidcrendial.get("password"));
    	Assert.assertEquals(Page.driver.getCurrentUrl(),beforeloginUrl,"Expected Url is differnt then expected Url");
        AutomationLog.info("User after login redirected to same page successfully");
    }

	@Override
	protected String successMessage() {
		return "Test cases passed for Property Details";
	}

	@Override
	protected String failureMessage() {
		return "Test cases failed for Property Details";
	}
}
