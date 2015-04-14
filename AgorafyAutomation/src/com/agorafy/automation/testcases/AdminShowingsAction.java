package com.agorafy.automation.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Admin;
import com.agorafy.automation.pageobjects.AdminShowings;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;

public class AdminShowingsAction extends AutomationTestCaseVerification
{
    private Header header = null;
    private HeaderLoginForm headerloginform = null;
    private Homepage homepage = null;
    private Admin admin = null;
    private AdminShowings adminshowings = null;
	private ListingDetailPage listingdetail = null;

    public AdminShowingsAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        header = Header.header();
        try
        {
            headerloginform = header.openHeaderLoginForm();
            Credentials credentials = userCredentials();
            homepage = headerloginform.doSuccessfulLogin(credentials.getEmail(), credentials.getPassword());
            WaitFor.presenceOfTheElement(Page.driver, homepage.getHomepageGreetingsLocator());
            header.clickOnProfileNameDropdownArrow();
            admin = header.clickSwitchToAdminLinkBelowProfilePic();
            WaitFor.sleepFor(10000);
        }
        catch(Exception e)
        {
            AutomationLog.error("Login failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyIfAdminShowingsPopUpIsClosedWithoutSaving(); 
        verifyIfSaveButtonClickedWithoutSelectingDateForShowing();
        verifyIfInvalidDateIsEntered();
        verifyIfAddedShowingFromAdminEnd(); 
        verifyIfEditIconIsClicked();
        verifyIfDeleteShowingIsCanceled();
        verifyIfDeleteShowingIsConfirmed();
        verifyIfAddedShowingIsSeenOnShowingPopUpOnMyListingsPage();
    }

    public String getCurrentDate() throws Exception 
    {
        DateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String datestring = simpledateformat.format(date);
        return datestring;
    }

    public String getCurrentTime(String min) throws Exception
    {
        long ltime = System.currentTimeMillis();
        String hours = new SimpleDateFormat("h").format(new Date(ltime));
        String amPm = new SimpleDateFormat("a").format(ltime).toLowerCase();
        String realtime = hours + ":"+ min + amPm; 
        return realtime;
    }

    public void verifyIfAdminShowingsPopUpIsClosedWithoutSaving() throws Exception 
    {
        admin.navigateToListing();
        adminshowings = admin.clickOnAddShowingLink();
        WaitFor.sleepFor(2000);
        adminshowings.enterDateInDatePickerTextBox(getCurrentDate());
        adminshowings.selectStartTime(getCurrentTime("30"));
        adminshowings.clickOnCloseButton();
        Assert.assertFalse(admin.isShowingPresent(), "Expected Showing not to be added is failed");
        AutomationLog.info("Closing AdminShowingsPopUp without save does not add Showing");
    }

    public void verifyIfSaveButtonClickedWithoutSelectingDateForShowing() throws Exception
    {
        adminshowings = admin.clickOnAddShowingLink();
        WaitFor.sleepFor(2000);
        adminshowings.selectStartTime(getCurrentTime("30"));
        adminshowings.clickOnSaveButton();
        Assert.assertEquals(adminshowings.text_MessageBar().getText(), "Please enter date.", "Expected text message is not shown");
        AutomationLog.info("Clicking save button without selecting date shows Error Message");
    }

    public void verifyIfInvalidDateIsEntered() throws Exception 
    {
        adminshowings.enterDateInDatePickerTextBox("1234");
        adminshowings.selectStartTime(getCurrentTime("30"));
        adminshowings.clickOnSaveButton();
        Assert.assertEquals(adminshowings.text_MessageBar().getText(), "Please enter valid date.", "Expected text message is not shown");
        AutomationLog.info("Clicking save button with Invalid date shows Error Message");
        adminshowings.clickOnCloseButton();
    }

    public void verifyIfAddedShowingFromAdminEnd() throws Exception
    {
        adminshowings = admin.clickOnAddShowingLink();
        WaitFor.sleepFor(2000);
        adminshowings.enterDateInDatePickerTextBox(getCurrentDate());
        adminshowings.selectStartTime(getCurrentTime("00"));
        adminshowings.clickOnSaveButton();
        admin.clickOnSaveButton();
        String expected = admin.getFirstShowing().getText();
        String curHandle = Page.driver.getWindowHandle();
        listingdetail  = admin.clickOnListingDetailIcon();
        Set<String> handles = Page.driver.getWindowHandles();
        for(String handle : handles)
        {
            if(!handle.equals(curHandle))
            {
                Page.driver.switchTo().window(handle);
            }
        }
        String actual = listingdetail.getFirstShowingFromShowingsList().getText();
        Assert.assertEquals(actual, expected, "Expected showing is not present on Listing details page");
        AutomationLog.info("Adding showing from admin end shows showing on listing detail page");
        Page.driver.close();
        Page.driver.switchTo().window(curHandle);
    }

    public void verifyIfEditIconIsClicked() throws Exception
    {
        admin.clickOnFirstShowingEditIcon();
        Assert.assertTrue(adminshowings.popup_AdminShowings().isDisplayed(), "Expected AdminShowings PopUp is not shown");
        AutomationLog.info("Clicking on Edit icon shows AdminShowings PopUp");
        adminshowings.clickOnCloseButton();
    }

    public void verifyIfDeleteShowingIsCanceled() throws Exception
    {
        admin.clickOnFirstShowingDeleteIcon();
        Alert alert = Page.driver.switchTo().alert();
        alert.dismiss();
        admin.clickOnSaveButton();
        Assert.assertTrue(admin.isShowingPresent(), "Expected Showing is not present");
        AutomationLog.info("Canceling Delete Showing does not remove the Showing");
    }



    public void verifyIfAddedShowingIsSeenOnShowingPopUpOnMyListingsPage() throws Exception 
    {
        
    }
    

    public void verifyIfDeleteShowingIsConfirmed() throws Exception
    {
        admin.clickOnFirstShowingDeleteIcon();
        Alert alert = Page.driver.switchTo().alert();
        alert.accept();
        admin.clickOnSaveButton();
        Assert.assertFalse(admin.isShowingPresent(), "Expected Showing is not deleted");
        AutomationLog.info("Confirming Delete showing removes the Showing");
    }

    @Override
    protected String successMessage()
    {
        return "";
    }

    @Override
    protected String failureMessage()
    {
        return "";
    }
}
