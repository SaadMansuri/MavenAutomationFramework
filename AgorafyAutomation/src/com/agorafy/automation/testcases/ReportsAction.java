package com.agorafy.automation.testcases;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.SearchResultsPage;
import com.agorafy.automation.pageobjects.Reports;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;


public class ReportsAction extends AutomationTestCaseVerification
{
    private Reports reports = new Reports(Page.driver);
    private Header header = Page.header();
    private Homepage homePage = null;
    private HeaderLoginForm headerLoginForm =null;
    private SearchResultsPage propertysearch = null;
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
            header = Header.header();
            headerLoginForm = header.openHeaderLoginForm();
            HashMap<String, String> loginData =  testCaseData.get("validCredential");
            String UserName = loginData.get("username");
            String Password = loginData.get("password");
            homePage = headerLoginForm.doSuccessfulLogin(UserName, Password);
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            HashMap<String, String> search = testCaseData.get("SearchData");
            propertysearch = homePage.populateSearchTermTextBox(search.get("borough"), search.get("listingcategory"), search.get("searchterm"));
            AutomationLog.info("Successfully redirected to PropertySearch page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to page");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyIfMouseHoverOnTileShowsPinCushionReportIcon();
        veifyIfMouseHoverOnPinCushionReportIconShowsToolTip();
        verifyIfClickingOnPinCushionReportIconIncrementsReportsCount();
        verifyIfPinCushionReportIconIsFixed();
        verifyIfMouseHoverOnFixedPinCushionReportIconShowsToolTip();
        verifyIfClickingOnFixedPinCushionReportIconDecrementsReportsCount();
        verifyIfClickingOnReportsLinkInProfileNameDropDownShowsReportsBox ();
        verifyIfClickingOnClearLinkOnReportsBoxClearsReportsList();
        verifyIfClickingAddToReportLinkOnListingDetailPageIncrementsReportsCount();
        verifyIfClickingRemoveFromReportLinkOnListingDetailPageDecrementsReportsCount();
    }

    public void verifyIfMouseHoverOnTileShowsPinCushionReportIcon() throws Exception
    {
         propertysearch.hoverOnFirstSearchResultTile();
         Assert.assertEquals(propertysearch.icon_PinCushionReport().isDisplayed(), true, "Expected icon is not displayed");
         AutomationLog.info("On Mouse hover tile PinCushionReport icon is shown");
    }

    public void veifyIfMouseHoverOnPinCushionReportIconShowsToolTip() throws Exception
    {
        propertysearch.hoverOnPinCushionReportIcon();
        WaitFor.presenceOfTheElement(Page.driver, propertysearch.Tooltiplocator());
        Assert.assertEquals(propertysearch.tooltip_PinCushionReport().getText(), "Add to Report", "Expected tooltip is not shown");
        AutomationLog.info("On mouse hover PinCushionReport icon tooltip is shown");
    }

    public void verifyIfClickingOnPinCushionReportIconIncrementsReportsCount() throws Exception
    {
        int beforeCount = Integer.parseInt(reports.getReportCount());
        addReportUsingPinCushionReportIcon();
        WaitFor.sleepFor(2000);
        int afterCount = Integer.parseInt(reports.getReportCount());
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(afterCount, beforeCount+1, "Expected Reports Count is not incremented");
        AutomationLog.info("Clicking PinCushionReport icon Increments the Reports Count");
    }

    public void verifyIfPinCushionReportIconIsFixed() throws Exception
    {
        Assert.assertEquals(propertysearch.icon_PinCushionReport().isDisplayed(), true, "Expected icon is not fixed");
        AutomationLog.info("PinCushionReport icon is Fixed");
    }

    public void verifyIfMouseHoverOnFixedPinCushionReportIconShowsToolTip() throws Exception 
    {
        propertysearch.hoverOnPinCushionReportIcon();
        WaitFor.presenceOfTheElement(Page.driver, propertysearch.Tooltiplocator());
        Assert.assertEquals(propertysearch.tooltip_PinCushionReport().getText(), "Remove from Report", "Expected tooltip is not shown");
        AutomationLog.info("On mouse hover fixed PinCushionReport icon, Remove from Report tooltip is shown");
    }

    public void verifyIfClickingOnFixedPinCushionReportIconDecrementsReportsCount() throws Exception
    {
        int beforeCount = Integer.parseInt(reports.getReportCount());
        removeReportUsingPinCushionReportIcon();
        WaitFor.sleepFor(2000);
        int afterCount = Integer.parseInt(reports.getReportCount());
        Assert.assertEquals(afterCount, beforeCount-1, "Expected reports count in not decremented");
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(propertysearch.icon_PinCushionReport().isDisplayed(), false, "Expected icon is not fixed");
        propertysearch.hoverOnFirstSearchResultTile();
        Assert.assertEquals(propertysearch.icon_PinCushionReport().isDisplayed(), true, "Expected icon is not displayed");
        AutomationLog.info("Clicking On PinCushionReport icon decrements the reports count ");
    }

    public void addReportUsingPinCushionReportIcon() throws Exception
    {
        propertysearch.hoverOnFirstSearchResultTile();
        propertysearch.hoverOnPinCushionReportIcon();
        propertysearch.clickOnPinCushionReportIcon();
    }

    public void removeReportUsingPinCushionReportIcon() throws Exception
    {
        propertysearch.hoverOnFirstSearchResultTile();
        propertysearch.hoverOnPinCushionReportIcon();
        propertysearch.clickOnPinCushionReportIcon();
    }

    public void verifyIfClickingOnReportsLinkInProfileNameDropDownShowsReportsBox() throws Exception
    {
        addReportUsingPinCushionReportIcon();
        WaitFor.sleepFor(2000);
        header.clickOnProfileNameDropdownArrow();
        reports = header.clickOnReportsLink();
        WaitFor.presenceOfTheElement(Page.driver, reports.getReportBoxLocator());
        Assert.assertEquals(reports.reportBox().isDisplayed(), true, "Expected reports Box is not shown");
        AutomationLog.info("Clicking On Reports Link In Profile Name DropDown Shows Reports Box");
        
    }

    public void verifyIfClickingOnClearLinkOnReportsBoxClearsReportsList() throws Exception
    {
        String text = null;
        reports.clickOnClearLink();
        WaitFor.sleepFor(2000);
        for(WebElement ele : reports.resultsetReportList())
        {
           text = ele.getText();
        }
        Assert.assertEquals(text, "No items in report.", "Expected List is not cleared");
        AutomationLog.info("Clicking on Clear Link On ReportsBox Clears ReportsList ");
        reports.clickOnCloseIcon();
    }

    public void verifyIfClickingAddToReportLinkOnListingDetailPageIncrementsReportsCount() throws Exception
    {
        boolean isLoggedIn = true;
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
        int beforcount = Integer.parseInt(reports.getReportCount());
        listingdetail.clickOnAddToReportLink(isLoggedIn);
        WaitFor.sleepFor(2000);
        int aftercount = Integer.parseInt(reports.getReportCount());
        Assert.assertEquals(aftercount, beforcount+1, "Expected report count is not incremented");
        Assert.assertEquals(listingdetail.link_removeFromReport().isDisplayed(), true, "Expected RemoveFromReport link is not shown");
        AutomationLog.info("Clicking AddToReport link increaments Reports count by 1 and RemoveFromReport link displayed");
    }

    public void verifyIfClickingRemoveFromReportLinkOnListingDetailPageDecrementsReportsCount() throws Exception
    {
        int beforcount = Integer.parseInt(reports.getReportCount());
        listingdetail.clickOnRemoveFromReportLink();
        WaitFor.sleepFor(2000);
        int aftercount = Integer.parseInt(reports.getReportCount());

        Assert.assertEquals(aftercount, beforcount-1, "Expected reports count is not decremented ");
        Assert.assertEquals(listingdetail.link_addToReport().isDisplayed(), true, "Expected addToReport link is not shown");
        AutomationLog.info("Clicking RemoveFromReport link decrements Reports count by 1 and addToReport link displayed");
    }

    @Override
    protected String successMessage()
    {
        return "test cases for Reports passed";
    }

    @Override
    protected String failureMessage()
    {
        return "test cases for Reports failed";
    }

}
