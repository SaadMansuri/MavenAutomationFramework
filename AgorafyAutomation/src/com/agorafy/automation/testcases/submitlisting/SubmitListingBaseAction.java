package com.agorafy.automation.testcases.submitlisting;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingDetailsFormBasePage;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingLocationFormPage;
import com.agorafy.automation.utilities.Login;


public abstract class SubmitListingBaseAction extends AutomationTestCaseVerification
{
    private Homepage homePage = null;
    private Dashboard dashboard = null;
    protected SubmitListingLocationFormPage locationPage;
    protected SubmitListingDetailsFormBasePage detailsBasePage;
    HashMap<String, String> dataFromCSV;

    public SubmitListingBaseAction()
    {
        super(SubmitListingBaseAction.class.getSimpleName());
    }

    @Override
    public void setup()
    {
        super.setup();
        try
        {
            homePage = Login.doSuccessfullLoginFromHeaderLoginForm();
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            dashboard = homePage.clickOnMyDashboardLink();
            Page.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            locationPage = dashboard.clickOnSubmitListingButton();
            AutomationLog.info("Successfully redirected to Submit Listing Form");
         }
         catch(Exception e)
         {
             AutomationLog.error("Could not redirect to Submit Listing page");
         }
    }

}
