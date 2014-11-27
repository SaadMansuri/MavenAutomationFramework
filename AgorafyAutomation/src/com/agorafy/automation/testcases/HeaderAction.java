package com.agorafy.automation.testcases;


import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPopUp;
import com.agorafy.automation.pageobjects.Page;

public class HeaderAction extends AutomationTestCaseVerification 
{
    private Header header;
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
                header.clickOnSignUpUpLink();
           
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
        verifyIFTooltipMessageComesAfterClickingOnSearchButton(header);
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
    
    public void verifyIFTooltipMessageComesAfterClickingOnSearchButton(Header header) throws Exception
    {
        header.clickOnCloseLoginPopUp();
        header.clickOnSearchFormButton();
        Assert.assertEquals(header.verifyZebraTooltipMessageComesAfterClickingEmptySearchbuttonVisibity(), true, "Expected error message when Tool Tip is not Visible which should come after clicking on empty search button");
        AutomationLog.info("Tool Tip is Visible which comes after clicking on empty search button");
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
