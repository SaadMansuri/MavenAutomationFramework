package com.agorafy.automation.testcases;


import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPopUp;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.SignUp;

public class HeaderAction extends AutomationTestCaseVerification 
{
	private Header header;
	private SignUp signup;
    private LoginPopUp loginpopup;

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
    protected void verifyTestCases() throws Exception
    {
        verifyIFAdvancedSearchFormPresent(header);
        verifyIfLoginPopUpIsDisplayed();
    }

	public void verifyIfLoginPopUpIsDisplayed() throws Exception
    {
        loginpopup=header.clickOnSubmitListingLink();
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(header.loginPopUpIsDisplayed(loginpopup),true,"Expected login pop up could not found");
        AutomationLog.info("Clicking on submit listing link in header displays Login popup ");
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
