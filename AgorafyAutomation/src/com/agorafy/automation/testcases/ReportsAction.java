package com.agorafy.automation.testcases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertySearch;
import com.agorafy.automation.pageobjects.Reports;

public class ReportsAction extends AutomationTestCaseVerification
{
    private Reports reports = new Reports(Page.driver);
    private Homepage homePage = null;
    private HeaderLoginForm headerLoginForm =null;
    private PropertySearch propertysearch = null;
    
    public ReportsAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        homePage = Homepage.homePage();
        try
        {
            headerLoginForm = homePage.openHeaderLoginForm();

            HashMap<String, String> loginData =  testCaseData.get("validCredential");
            String UserName = loginData.get("username");
            String Password = loginData.get("password");
            homePage = headerLoginForm.doSuccessfulLogin(UserName, Password);
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            HashMap<String, String> search = testCaseData.get("SearchData");
            propertysearch = homePage.populateSearchTermTextBox(search.get("borough"), search.get("listingcategory"), search.get("searchterm"));
            AutomationLog.info("Successfully redirected to page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to page");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyIfMouseHoverOnTile();
        veifyIfMouseHoverAddToReportIcon();
        verifyIfClickOnAddToReportIcon();
    }

    public void verifyIfMouseHoverOnTile() throws Exception
    {
         propertysearch.hoverOnFirstSearchResultTile();
         Assert.assertEquals(propertysearch.icon_AddToReport().isDisplayed(), true, "Expected icon is not displayed");
         AutomationLog.info("On Mouse hover tile Add to report icon is shown");
    }

    public void veifyIfMouseHoverAddToReportIcon() throws Exception
    {
        propertysearch.hoverOnAddToReportIcon();
        WaitFor.presenceOfTheElement(Page.driver, propertysearch.Tooltiplocator());
        Assert.assertEquals(propertysearch.tooltip_AddToReport().getText(), "Add to Report", "Expected tooltip is not shown");
        AutomationLog.info("On mouse hover addtoreport icon tooltip is shown");
    }

    public void verifyIfClickOnAddToReportIcon() throws Exception
    {
        String beforeCount = reports.getReportCount();
        propertysearch.hoverOnFirstSearchResultTile();
        propertysearch.hoverOnAddToReportIcon();
        WaitFor.presenceOfTheElement(Page.driver, propertysearch.Tooltiplocator());
        reports = propertysearch.clickOnAddToReportIcon();
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String afterCount = reports.getReportCount();
        Assert.assertEquals(beforeCount.equalsIgnoreCase(afterCount), false, "not");
        

    }

    @Override
    protected String successMessage()
    {
        return null;
    }

    @Override
    protected String failureMessage()
    {
        return null;
    }

}
