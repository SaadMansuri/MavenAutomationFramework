package com.agorafy.automation.testcases;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        //verifyIfMouseHoverOnTile();
        //veifyIfMouseHoverAddToReportIcon();
        //verifyIfClickOnAddToReportIcon();
        //verifyIfAddToReportIconIsFixed();
        //verifyIfHoverOnFixedAddToReportIcon();
        //verifyIfClickedOnFixedAddToReportIcon();
        //verifyIfClickedOnReportsLinkInProfileNameDropDown();
        //verifyIfClearLinkOnReportsBoxIsClicked();
        verifyAddToReportlinkOnListingDetailPage();
        verifyRemoveFromReportLinkOnListingDetailPage();
        
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
        System.out.println(beforeCount);
        //Thread.sleep(10000);
        addReportUsingAddToReportIcon();
        Thread.sleep(10000);
        int afterCount = Integer.parseInt(reports.getReportCount());
        System.out.println(afterCount);

        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(afterCount, beforeCount+1, "Expected report count is not incremented");
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
        AutomationLog.info("On mouse hover fixed addtoreport icon, Remove from Report tooltip is shown");
    }

    public void verifyIfClickedOnFixedAddToReportIcon() throws Exception
    {
    	int beforeCount = Integer.parseInt(reports.getReportCount());
        System.out.println(beforeCount);

        addReportUsingAddToReportIcon();
        Thread.sleep(10000);
        int afterCount = Integer.parseInt(reports.getReportCount());
        System.out.println(afterCount);

        Assert.assertEquals(afterCount, beforeCount-1, "Expected report count in not decremented");
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(propertysearch.icon_AddToReport().isDisplayed(), false, "Expected icon is not fixed");
        propertysearch.hoverOnFirstSearchResultTile();
        Assert.assertEquals(propertysearch.icon_AddToReport().isDisplayed(), true, "Expected icon is not displayed");
        AutomationLog.info("Clicking Remove From Report icon decreaments the reports count ");
    }

    public void addReportUsingAddToReportIcon() throws Exception
    {
        propertysearch.hoverOnFirstSearchResultTile();
        propertysearch.hoverOnAddToReportIcon();
        //WaitFor.presenceOfTheElement(Page.driver, propertysearch.Tooltiplocator());
        propertysearch.clickOnAddToReportIcon();
        //Thread.sleep(10000);
        //WaitFor.waitUntilElementIsLoaded(Page.driver, reports.getReportBoxLocator());
    }

    public void verifyIfClickedOnReportsLinkInProfileNameDropDown() throws Exception
    {
        addReportUsingAddToReportIcon();
        header.clickOnProfileNameDropdownArrow();
        reports = header.clickOnReportsLink();
        Assert.assertEquals(reports.reportBox().isDisplayed(), true, "Expected reports Box is not shown");
        AutomationLog.info("Clicking on reports link shows Reports Box");
        
    }

    public void verifyIfClearLinkOnReportsBoxIsClicked() throws Exception
    {
        String text = null;
        reports.clickOnClearLink();
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for(WebElement ele : reports.resultsetReportList())
        {
           text = ele.getText();
           System.out.println(text);
        }
        Assert.assertEquals(text, "No items in report.", "Expected List is not cleared");
        AutomationLog.info("Clicking on Clear button Reports List is cleared");
        reports.clickOnCloseIcon();
    }

    public void verifyAddToReportlinkOnListingDetailPage() throws Exception
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
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        listingdetail.clickOnAddToReportLink(isLoggedIn);
        WaitFor.waitUntilElementIsLoaded(Page.driver, reports.getReportBoxLocator());
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        int aftercount = Integer.parseInt(reports.getReportCount());
        Assert.assertEquals(aftercount, beforcount+1, "Expected report count is not incremented");
        Assert.assertEquals(listingdetail.link_removeFromReport().isDisplayed(), true, "Expected RemoveFromReport link is not shown");
        AutomationLog.info("Clicking AddToReport link increaments Reports count by 1 and RemoveFromReport link displayed");
    }

    public void verifyRemoveFromReportLinkOnListingDetailPage() throws Exception
    {
        int beforcount = Integer.parseInt(reports.getReportCount());
        System.out.println(beforcount);
        listingdetail.clickOnRemoveFromReportLink();
        Thread.sleep(10000);
        //WaitFor.waitUntilElementIsLoaded(Page.driver, reports.getReportBoxLocator());
        int aftercount = Integer.parseInt(reports.getReportCount());
        System.out.println(aftercount);

        Assert.assertEquals(aftercount, beforcount-1, "Expected reports count is not decremented ");
        Assert.assertEquals(listingdetail.link_addToReport().isDisplayed(), true, "Expected addToReport link is not shown");
        AutomationLog.info("Clicking AddToReport link decreaments Reports count by 1 and addToReport link displayed");
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
