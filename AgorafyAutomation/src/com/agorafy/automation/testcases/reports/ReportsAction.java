package com.agorafy.automation.testcases.reports;

 import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.reports.ReportsPopUp;
import com.agorafy.automation.pageobjects.SearchResultsPage;
import com.agorafy.automation.pageobjects.reports.Reports;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;
import com.agorafy.automation.utilities.Login;


public class ReportsAction extends AutomationTestCaseVerification
{
    private Reports reports = new Reports(Page.driver);
    private Header header = null;
    private Homepage homePage = null;
    private SearchResultsPage searchresult = null;
    private ListingDetailPage listingdetail = null;
    private ReportsPopUp reportspopup = null;
    String curHandle;
    static int reportcount = 15;
    
    public ReportsAction()
    {
        super();
    }

    public ReportsAction(String string) 
    {
        super(string);
	}

	@Override
    public void setup()
    {
        super.setup();
        try
        {
            homePage = Login.doSuccessfullLoginFromHeaderLoginForm();
            header = Header.header();
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            HashMap<String, String> search = testCaseData.get("SearchData");
            searchresult = homePage.populateSearchTermTextBox(search.get("borough"), search.get("listingcategory"), search.get("searchterm"));
            AutomationLog.info("Successfully redirected to SearchResults page");
            curHandle = Page.driver.getWindowHandle();
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to SearchResults page");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifySearchResultPageTestCases();
        verifyListingDetailPageTestCases();
    }

    public void verifySearchResultPageTestCases() throws Exception
    {
        verifyIfMouseHoverOnTile();
        veifyIfMouseHoverOnPinCushionReportIcon();
        verifyIfClickedOnPinCushionReportIcon();
        verifyIfPinCushionReportIconIsFixed();
        verifyIfMouseHoverOnFixedPinCushionReportIcon();
        verifyIfClickedOnFixedPinCushionReportIcon();
        verifyIfClickedOnReportsLinkInProfileNameDropDown();
        verifyIfClickedOnClearLinkOnReportsBox();
        verifyIfClickedOnCloseIconForIndividualListingInReportsBox();

        verifyIfReportsCountIsSameOnBothWindows();
        verifyIfMoreThanFifteenListingAdded();
        verifyIfClickedOnCloseIconOnReportsList();

        verifyIfPrintLinkIsShownOnReportsBox();
        verifyIfClickingPrintLinkOpensPopUp();
    }

    public void verifyListingDetailPageTestCases() throws Exception
    {
        verifyIfAddToReportLinkIsPresent();
        verifyIfClickedAddToReportLink();
        verifyIfClickedRemoveFromReportLink();
        verifyIfClickedOnReportsLink();
        verifyIfClickedOnClearLinkOnReportsBox();
        verifyIfClickedCloseIconForIndividualListing();
        verifyIfListingIsAddedFromSearchResultsPage();
        verifyIfAddToReportLinkIsClicked();
    }

    public void verifyIfMouseHoverOnTile() throws Exception
    {
        searchresult.hoverOnFirstSearchResultTile();
        Assert.assertEquals(searchresult.icon_PinCushionReport().isDisplayed(), true, "Expected icon is not displayed");
        AutomationLog.info("On Mouse hover tile PinCushionReport icon is shown");
    }

    public void veifyIfMouseHoverOnPinCushionReportIcon() throws Exception
    {
        searchresult.hoverOnPinCushionReportIcon();
        WaitFor.presenceOfTheElement(Page.driver, searchresult.Tooltiplocator());
        Assert.assertEquals(searchresult.tooltip_PinCushionReport().getText(), "Add to Report", "Expected tooltip is not shown");
        AutomationLog.info("On mouse hover PinCushionReport icon tooltip is shown");
    }

    public void verifyIfClickedOnPinCushionReportIcon() throws Exception
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
        Assert.assertEquals(searchresult.icon_PinCushionReport().isDisplayed(), true, "Expected icon is not fixed");
        AutomationLog.info("PinCushionReport icon is Fixed");
    }

    public void verifyIfMouseHoverOnFixedPinCushionReportIcon() throws Exception 
    {
        searchresult.hoverOnPinCushionReportIcon();
        WaitFor.presenceOfTheElement(Page.driver, searchresult.Tooltiplocator());
        Assert.assertEquals(searchresult.tooltip_PinCushionReport().getText(), "Remove from Report", "Expected tooltip is not shown");
        AutomationLog.info("On mouse hover fixed PinCushionReport icon, Remove from Report tooltip is shown");
    }

    public void verifyIfClickedOnFixedPinCushionReportIcon() throws Exception
    {
        int beforeCount = Integer.parseInt(reports.getReportCount());
        removeReportUsingPinCushionReportIcon();
        WaitFor.sleepFor(2000);
        int afterCount = Integer.parseInt(reports.getReportCount());
        Assert.assertEquals(afterCount, beforeCount-1, "Expected reports count in not decremented");
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(searchresult.icon_PinCushionReport().isDisplayed(), false, "Expected icon is not fixed");
        searchresult.hoverOnFirstSearchResultTile();
        Assert.assertEquals(searchresult.icon_PinCushionReport().isDisplayed(), true, "Expected icon is not displayed");
        AutomationLog.info("Clicking On PinCushionReport icon decrements the reports count ");
    }

    public void addReportUsingPinCushionReportIcon() throws Exception
    {
        searchresult.hoverOnFirstSearchResultTile();
        searchresult.hoverOnPinCushionReportIcon();
        searchresult.clickOnPinCushionReportIcon();
    }

    public void removeReportUsingPinCushionReportIcon() throws Exception
    {
        searchresult.hoverOnFirstSearchResultTile();
        searchresult.hoverOnPinCushionReportIcon();
        searchresult.clickOnPinCushionReportIcon();
    }

    public void verifyIfClickedOnReportsLinkInProfileNameDropDown() throws Exception
    {
        addReportUsingPinCushionReportIcon();
        WaitFor.sleepFor(2000);
        header.clickOnProfileNameDropdownArrow();
        reports = header.clickOnReportsLink();
        WaitFor.sleepFor(2000);
        WaitFor.presenceOfTheElement(Page.driver, reports.getReportBoxLocator());
        Assert.assertEquals(reports.reportBox().isDisplayed(), true, "Expected reports Box is not shown");
        AutomationLog.info("Clicking On Reports Link In Profile Name DropDown Shows Reports Box");
    }

    public void verifyIfClickedOnClearLinkOnReportsBox() throws Exception
    {
        String text = null;
        reports.clickOnClearLink();
        WaitFor.sleepFor(5000);
        for(WebElement ele : reports.resultsetReportList())
        {
           text = ele.getText();
        }
        Assert.assertEquals(text, "No items in report.", "Expected List is not cleared");
        AutomationLog.info("Clicking on Clear Link On ReportsBox Clears ReportsList ");
        reports.clickOnReportWindowCloseIcon();
    }

    public void verifyIfAddToReportLinkIsPresent() throws Exception
    {
        listingdetail = searchresult.clickSearchResult();
        SwitchToNextWindow();
        WaitFor.sleepFor(2000);
        Assert.assertEquals(listingdetail.link_addToReport().isDisplayed(), true, "Expected Add to Report link is not displayed");
        AutomationLog.info("Add to Report link is present on listing detail page");
    }

    public void verifyIfClickedAddToReportLink() throws Exception
    {
        boolean isLoggedIn = true;
        int beforcount = Integer.parseInt(reports.getReportCount());
        listingdetail.clickOnAddToReportLink(isLoggedIn);
        WaitFor.sleepFor(2000);
        int aftercount = Integer.parseInt(reports.getReportCount());
        Assert.assertEquals(aftercount, beforcount+1, "Expected report count is not incremented");
        Assert.assertEquals(listingdetail.link_removeFromReport().isDisplayed(), true, "Expected RemoveFromReport link is not shown");
        AutomationLog.info("Clicking AddToReport link increaments Reports count by 1 and RemoveFromReport link displayed");
    }

    public void verifyIfClickedRemoveFromReportLink() throws Exception
    {
        int beforcount = Integer.parseInt(reports.getReportCount());
        listingdetail.clickOnRemoveFromReportLink();
        WaitFor.sleepFor(2000);
        int aftercount = Integer.parseInt(reports.getReportCount());

        Assert.assertEquals(aftercount, beforcount-1, "Expected reports count is not decremented ");
        Assert.assertEquals(listingdetail.link_addToReport().isDisplayed(), true, "Expected addToReport link is not shown");
        AutomationLog.info("Clicking RemoveFromReport link decrements Reports count by 1 and addToReport link displayed");
    }

    public void verifyIfClickedOnCloseIconForIndividualListingInReportsBox() throws Exception
    {
    	verifyIfClickedOnClearLinkOnReportsBox();
        int beforeCount = Integer.parseInt(reports.getReportCount());
        reports.hoverOnFirstDeleteListingIcon();
        reports.clickOnFirstDeleteListingIcon();
        WaitFor.sleepFor(2000);
        int afterCount = Integer.parseInt(reports.getReportCount());
        Assert.assertEquals(afterCount, beforeCount-1, "Expected reports count in not decremented");
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(searchresult.icon_PinCushionReport().isDisplayed(), false, "Expected icon is not fixed");
        AutomationLog.info("Clicking On Delete Listing icon decrements the reports count and Removes listing from Reports box ");
        reports.clickOnReportWindowCloseIcon();
    }

    public void verifyIfClickedOnReportsLink() throws Exception
    {
        boolean isLoggedIn = true;
        listingdetail.clickOnAddToReportLink(isLoggedIn);
        header.clickOnProfileNameDropdownArrow();
        header.clickOnReportsLink();
        WaitFor.sleepFor(2000);
        WaitFor.presenceOfTheElement(Page.driver, reports.getReportBoxLocator());
        Assert.assertEquals(reports.reportBox().isDisplayed(), true, "Expected reports Box is not shown");
        AutomationLog.info("Clicking On Reports Link In Profile Name DropDown Shows Reports Box");
    }

    public void verifyIfClickedCloseIconForIndividualListing() throws Exception
    {
        boolean isLoggedIn = true;
        listingdetail.clickOnAddToReportLink(isLoggedIn);
        WaitFor.sleepFor(2000);
        int beforeCount = Integer.parseInt(reports.getReportCount());
        header.clickOnProfileNameDropdownArrow();
        header.clickOnReportsLink();
        WaitFor.sleepFor(2000);
        WaitFor.presenceOfTheElement(Page.driver, reports.getReportBoxLocator());
        reports.hoverOnFirstDeleteListingIcon();
        reports.clickOnFirstDeleteListingIcon();
        WaitFor.sleepFor(2000);
        int afterCount = Integer.parseInt(reports.getReportCount());
        Assert.assertEquals(afterCount, beforeCount-1, "Expected reports count in not decremented");
        AutomationLog.info("Clicking On Delete Listing icon decrements the reports count and Removes listing from Reports box  ");
    }

    public void verifyIfListingIsAddedFromSearchResultsPage() throws Exception
    {
        Page.driver.close();
        Page.driver.switchTo().window(curHandle);
        Page.driver.navigate().refresh();
        WaitFor.waitForPageToLoad(Page.driver);
        addReportUsingPinCushionReportIcon();
        WaitFor.sleepFor(1000);
        listingdetail = searchresult.clickSearchResult();
        SwitchToNextWindow();
        WaitFor.sleepFor(5000);
        Assert.assertEquals(listingdetail.link_removeFromReport().isDisplayed(), true, "Expected Remove From Report Link is Not shown");
        AutomationLog.info("Remove From report Link is shown When ListingIsAddedFromSearchResultsPage");
        listingdetail.clickOnRemoveFromReportLink();
        Page.driver.close();
        Page.driver.switchTo().window(curHandle);
        Page.driver.navigate().refresh();

    }

    public void verifyIfAddToReportLinkIsClicked() throws Exception
    {
        boolean isLoggedIn = true;
        listingdetail = searchresult.clickSearchResult();
        SwitchToNextWindow();
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        listingdetail.clickOnAddToReportLink(isLoggedIn);
        Page.driver.close();
        Page.driver.switchTo().window(curHandle);
        Page.driver.navigate().refresh();
        verifyIfPinCushionReportIconIsFixed();
        searchresult.clickOnPinCushionReportIcon();
    }

    public void verifyIfReportsCountIsSameOnBothWindows() throws Exception
    {
        boolean isLoggedIn = true;
        listingdetail = searchresult.clickSearchResult();
        SwitchToNextWindow();
        listingdetail.clickOnAddToReportLink(isLoggedIn);
        int listingpagecount = Integer.parseInt(reports.getReportCount());
        Page.driver.close();
        Page.driver.switchTo().window(curHandle);
        Page.driver.navigate().refresh();
        WaitFor.sleepFor(2000);
        int searchpagecount = Integer.parseInt(reports.getReportCount());
        Assert.assertEquals(listingpagecount, searchpagecount, "Expected Reports Count is not increased on both windows ");
        header.clickOnProfileNameDropdownArrow();
        reports = header.clickOnReportsLink();
        WaitFor.sleepFor(2000);
        WaitFor.presenceOfTheElement(Page.driver, reports.getReportBoxLocator());
        reports.clickOnClearLink();
        reports.clickOnReportWindowCloseIcon();
        AutomationLog.info("Adding report increase Count in both windows");
    }

    public void SwitchToNextWindow() throws Exception
    {
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

    public void verifyIfMoreThanFifteenListingAdded() throws Exception
    {
        int licount = 0;
        int count = 1;
        int total = searchresult.getResultSetListingsConut();
        for(int i=0;i<total;i++)
        {
            if(reportcount < 0)
            {
                break;
            }
            searchresult.hoverOnSearchResult(i);
            searchresult.hoverAndClickOnPincushionIcon(i);
            --reportcount;
            
            if(++licount >=3*count)
            {
                searchresult.scrollPage(0, 300);
                ++count;
            }
        }
        WaitFor.sleepFor(2000);
        Assert.assertTrue(searchresult.popup_ErrorDialog().isDisplayed(), "Expected Error dialog pop up is not shown");
        searchresult.clickCloseIconOnErrorDialogPopUp();
        AutomationLog.info("Error Dialog is shown if more than fifteen listings tried to add ");
    }

    public void verifyIfClickedOnCloseIconOnReportsList() throws Exception
    {
        int index = 0;
        header.clickOnProfileNameDropdownArrow();
        reports = header.clickOnReportsLink();
        WaitFor.sleepFor(5000);
        WaitFor.presenceOfTheElement(Page.driver, reports.getReportBoxLocator());
        reports.hoverOnFirstDeleteListingIcon();
        reports.clickOnFirstDeleteListingIcon();
        WaitFor.sleepFor(1000);
        Assert.assertFalse(searchresult.icon_PinCushion(index).isDisplayed(), "Expected AddToReport icon for first listingd is not unFixed");
        AutomationLog.info("On Removing First listing by clicking close icon in Reports List unfix AddToReport icon for the first Listing in Search Results");
    }

    public void verifyIfPrintLinkIsShownOnReportsBox() throws Exception
    {
        Assert.assertTrue(reports.link_Print().isDisplayed(), "Excpected pincushionl Link is not present");
    }

    public void verifyIfClickingPrintLinkOpensPopUp() throws Exception 
    {
        reportspopup = reports.clickOnPrintLink();
        WaitFor.sleepFor(2000);
        Assert.assertTrue(reportspopup.popup_Reports().isDisplayed(), "Expected popup is not shown");
        reportspopup.clickOnCloseButton();
        reports.clickOnReportWindowCloseIcon();
        AutomationLog.info("Clicking on print link shows popup");
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
