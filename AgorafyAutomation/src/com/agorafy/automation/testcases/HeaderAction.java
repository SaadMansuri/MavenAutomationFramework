package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.datamodel.profile.EmailData;
import com.agorafy.automation.pageobjects.ForgotPassword;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.SignUp;

public class HeaderAction extends AutomationTestCaseVerification 
{
	private Header header;
	private SignUp signup;

	public HeaderAction()
    {
        super();
    }

	    @Override
	    public void setup()
	    {
	        super.setup();
	        try
	        {
	            header = Homepage.header();
	            signup = header.clickOnSignUpUpLink();
	       
	        }
	        catch(Exception e)
	        {
	            AutomationLog.error("Could not navigate to Sign Up Page");
	        }
	    }

	@Override
	protected void verifyTestCases() throws Exception {
		verifyIFAdvancedSearchFormPresent(header);
		
	}
	
    public void verifyIFAdvancedSearchFormPresent(Header header) throws Exception
    {
    	header.clickOndropbox_searchInputBox();
        Assert.assertEquals(header.verifyAdvancedSearchFormVisibity(), true, "Expected error message when the Advanced Search Form is not Visible");
        AutomationLog.info("Advanced Search Form is Visible");
    }

	@Override
	protected String successMessage() {
		return "Test cases passed for Header ";
	}

	@Override
	protected String failureMessage() {
		return "Test cases failed for Header";
	}

}
