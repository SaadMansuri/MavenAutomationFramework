package com.agorafy.automation.testcases;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertySearch;
import com.agorafy.automation.pageobjects.Reports;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;


public class ReportsAction extends AutomationTestCaseVerification
{
    private Reports reports = new Reports(Page.driver);
    private Header header = Page.header();
    private Homepage homePage = null;
    private HeaderLoginForm headerLoginForm =null;
    private PropertySearch propertysearch = null;
    private ListingDetailPage listingdetail = null;
    
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
        verifyIfAddToReportIconIsFixed();
        verifyIfHoverOnFixedAddToReportIcon();
        verifyIfClickedOnFixedAddToReportIcon();
        verifyIfClickedOnReportsLinkInProfileNameDropDown();
        verifyAddToReportlinkOnListingDetailPage();
        
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
        int beforeCount = Integer.parseInt(reports.getReportCount());
        addReportUsingAddToReportIcon();
        int afterCount = Integer.parseInt(reports.getReportCount());
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(afterCount, beforeCount+1, "Expected report count in not incremented");
        AutomationLog.info("Clicking add to report icon increaments the reports count");
    }

    public void verifyIfAddToReportIconIsFixed() throws Exception
    {
        System.out.println(propertysearch.icon_AddToReport().isDisplayed());
        Assert.assertEquals(propertysearch.icon_AddToReport().isDisplayed(), true, "Expected icon is not fixed");
        AutomationLog.info("Add To Report icon is Fixed");
    }

    public void verifyIfHoverOnFixedAddToReportIcon() throws Exception 
    {
        propertysearch.hoverOnAddToReportIcon();
        WaitFor.presenceOfTheElement(Page.driver, propertysearch.Tooltiplocator());
        Assert.assertEquals(propertysearch.tooltip_AddToReport().getText(), "Remove from Report", "Expected tooltip is not shown");
        AutomationLog.info("On mouse hover fixed addtoreport icon tooltip is shown");
    }

    public void verifyIfClickedOnFixedAddToReportIcon() throws Exception
    {
    	int beforeCount = Integer.parseInt(reports.getReportCount());
        addReportUsingAddToReportIcon();
        int afterCount = Integer.parseInt(reports.getReportCount());
        Assert.assertEquals(afterCount, beforeCount-1, "Expected report count in not incremented");
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(propertysearch.icon_AddToReport().isDisplayed(), false, "Expected icon is not fixed");
        propertysearch.hoverOnFirstSearchResultTile();
        Assert.assertEquals(propertysearch.icon_AddToReport().isDisplayed(), true, "Expected icon is not displayed");
        AutomationLog.info("Clicking add to report icon decreaments the reports count");
    }

    public void addReportUsingAddToReportIcon() throws Exception
    {
        propertysearch.hoverOnFirstSearchResultTile();
        propertysearch.hoverOnAddToReportIcon();
        WaitFor.presenceOfTheElement(Page.driver, propertysearch.Tooltiplocator());
        propertysearch.clickOnAddToReportIcon();
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void verifyIfClickedOnReportsLinkInProfileNameDropDown() throws Exception
    {
        addReportUsingAddToReportIcon();
        header.clickOnProfileNameDropdownArrow();
        reports = header.clickOnReportsLink();
        Assert.assertEquals(reports.reportBox().isDisplayed(), true, "Expected reports Box is not shown");
        AutomationLog.info("Clicking on reports link shows Reports Box");
    }

    public void verifyAddToReportlinkOnListingDetailPage() throws Exception
    {
        String curHandle = Page.driver.getWindowHandle();
        listingdetail = propertysearch.clickSearchResult();
        Set<String> handleset = Page.driver.getWindowHandles();
        for(String handle : handleset)
        {
            if(!handle.equals(curHandle))
            {
                Page.driver.switchTo().window(handle);
                break;
            }
        }
        
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
