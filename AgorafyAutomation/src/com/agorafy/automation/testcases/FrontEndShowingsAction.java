package com.agorafy.automation.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.FrontEndShowings;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.MyListings;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;

public class FrontEndShowingsAction extends AutomationTestCaseVerification
{

    private Header header;
    private HeaderLoginForm headerloginform;
    private Homepage homepage;
    private SubNavigation subnavigation = SubNavigation.subNavigation();
    private MyListings myListings;
    private FrontEndShowings frontendshowings;
    private String curHandle = null;
	private ListingDetailPage listingdetail;

    public FrontEndShowingsAction()
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
            myListings = subnavigation.clickLinkMyListings();
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
       verifyIfClickingScheduleNowLinkShowsShowingsPopUp();
       verifyIfFrontEndShowingsPopUpIsClosedWithoutSaving(); 
       verifyIfSaveButtonClickedWithoutSelectingDateForShowing();
       verifyIfInvalidDateIsEntered();
       verifyIfDuplicateShowingsCanBeAdded();
       verifyIfPastDateIsEntered();
       verifyIfEditIconClicked();
       verifyIfshowingScheduleIsModified();
       verifyIfShowingIsDeleted();
       verifyIfAddedShowingIsSeenOnListingDetailsPage();
       verifyIfAddingShowingsIncrementsUpcomingShowingsCount();
       verifyIfDeletingShowingsDecrementsUpcomingShowingsCount();
       deleteShowings();
    }

    public void verifyIfClickingScheduleNowLinkShowsShowingsPopUp() throws Exception
    {
        frontendshowings = myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        Assert.assertTrue(frontendshowings.popup_FrontEndShowings().isDisplayed(), "Expected FrontEnd Showings PopUp not shown");
        AutomationLog.info("Clicking schedule now link show Showings Popup");
        
    }

    public String getCurrentDate() throws Exception 
    {
        DateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String datestring = simpledateformat.format(date);
        return datestring;
    }

    public String getPrevDate() throws Exception
    {
        DateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        Date date = cal.getTime();
        String prevdate = simpledateformat.format(date);
        return prevdate;
    }


    public String getNextDate(int index) throws Exception
    {
        DateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,index);
        Date date = cal.getTime();
        String nextdate = simpledateformat.format(date);
        return nextdate;
   }

    public String enterStartTime() throws Exception 
    {
        String time = validateTime();
        if(time.equalsIgnoreCase(frontendshowings.getFirstStartTime()))
        {
            frontendshowings.enterDateInDatePickerTextBox(getNextDate(1));
        }
        WaitFor.sleepFor(2000);
        return time;
    }

    public String validateTime() throws Exception 
    {
        String realtime = getCurrentTime();
        if(frontendshowings.startTimeList().contains(realtime))
        {
            return realtime;
        }
        else
        {
            return frontendshowings.getFirstStartTime();
        }
    }

    public String getCurrentTime() throws Exception
    {
        long ltime = System.currentTimeMillis();
        String hour, mins;
        int hours = Integer.parseInt(new SimpleDateFormat("h").format(ltime));
        String amPm = new SimpleDateFormat("a").format(ltime).toLowerCase();
        int minutes = Integer.parseInt(new SimpleDateFormat("m").format(ltime));

        if(hours == 12)
        {
            hours = 1;
        }

        if(minutes > 30)
        {
            hours++;
            minutes = 0;
            if(hours == 12)
            {
                amPm = "pm";
            }
        }
        else
        {
            minutes = 30;
        }

        if (minutes == 0)
        {
            mins = "00";
        }
        else
        {
            mins = String.valueOf(minutes);
        }

        hour = String.valueOf(hours);
        String realtime = hour + ":" + mins + amPm;
        return realtime;
    }

    public void addShowing() throws Exception
    {
        myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        WaitFor.sleepFor(2000);
        frontendshowings.enterDateInDatePickerTextBox(getCurrentDate());
        WaitFor.sleepFor(1000);
        frontendshowings.selectStartTime(enterStartTime());
        frontendshowings.clickOnSaveButton();
    }

    public void verifyIfFrontEndShowingsPopUpIsClosedWithoutSaving() throws Exception
    {
        frontendshowings.enterDateInDatePickerTextBox(getCurrentDate());
        frontendshowings.selectStartTime(enterStartTime());
        frontendshowings.clickOnCloseButton();
        Assert.assertEquals(myListings.txt_UpcomingShowings("100 Maspeth Avenue").getText(), "None scheduled","Expected text not found" );
        AutomationLog.info("Closing FrontEndShowingsPopUp without save does not add Showing");
    }

    public void verifyIfSaveButtonClickedWithoutSelectingDateForShowing() throws Exception 
    {
        myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        WaitFor.sleepFor(2000);
        frontendshowings.selectStartTime(frontendshowings.getFirstStartTime());
        frontendshowings.clickOnSaveButton();
        Assert.assertEquals(myListings.txt_UpcomingShowings("100 Maspeth Avenue").getText(), "None scheduled","Expected text not found" );
        AutomationLog.info("Clicking save button without selecting date does not add Showing");
    }

    public void verifyIfInvalidDateIsEntered() throws Exception 
    {
        myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        WaitFor.sleepFor(2000);
        frontendshowings.enterDateInDatePickerTextBox("1234");
        frontendshowings.clickOnSaveButton();
        Assert.assertEquals(frontendshowings.text_MessageBar().getText(), "Please enter valid date.", "Expected text message is not shown");
        AutomationLog.info("Clicking save button with Invalid date shows Error Message");
        frontendshowings.clickOnCloseButton();
    }

    public void verifyIfDuplicateShowingsCanBeAdded() throws Exception 
    {
        addShowing();
        WaitFor.sleepFor(2000);
        addShowing();
        WaitFor.sleepFor(1000);
        Assert.assertEquals(frontendshowings.text_MessageBar().getText(), "Showing already scheduled on given times", "Expected text message is not shown");
        AutomationLog.info("Clicking save button with duplicate showing schedule shows Error Message");
        frontendshowings.clickOnCloseButton();
    }

    public void verifyIfPastDateIsEntered() throws Exception 
    {
        myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        frontendshowings.enterDateInDatePickerTextBox(getPrevDate());
        frontendshowings.selectStartTime(frontendshowings.getFirstStartTime());
        frontendshowings.clickOnSaveButton();
        Assert.assertEquals(frontendshowings.text_MessageBar().getText(), "Invalid showing schedule", "Expected text message is not shown");
        AutomationLog.info("Clicking save button with past showing schedule shows Error Message");
        frontendshowings.clickOnCloseButton();
    }

    public void verifyIfEditIconClicked() throws Exception 
    {
        myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        frontendshowings.hoverOnShowing(0);
        frontendshowings.clickOnEditShowingIcon(0);
        String expectedDate = frontendshowings.changeDateFormat();
        String actualdate = frontendshowings.getSelectedDate();
        Assert.assertEquals(actualdate, expectedDate, "Expected date is not same");
        String[] time = frontendshowings.getTime();
        Assert.assertEquals(frontendshowings.getSelectedStartTime(), time[0], "Expected start time is not same");
        Assert.assertEquals(frontendshowings.getSelectedEndTime(), time[1], "Expected endtime is not same");
        AutomationLog.info("Clicking edit shows same date and time");

    }

    public void verifyIfShowingIsDeleted() throws Exception
    {
        myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        frontendshowings.hoverOnShowing(0);
        frontendshowings.clickOnDeleteShowingIcon(0);
        frontendshowings.clickOnSaveButton();
        WaitFor.sleepFor(2000);
        Assert.assertEquals(myListings.txt_UpcomingShowings("100 Maspeth Avenue").getText(), "None scheduled", "Expected showing is not deleted ");
        AutomationLog.info("Clicking delete icon removes showing from upcoming showing");
    }

    public void verifyIfAddingShowingsIncrementsUpcomingShowingsCount() throws Exception 
    {
        deleteShowings();
        WaitFor.sleepFor(2000);
        int count = 0;
        for(int i = 1; i <= 3 ; i++)
        {
            myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
            WaitFor.sleepFor(2000);
            frontendshowings.enterDateInDatePickerTextBox(getNextDate(i));
            WaitFor.sleepFor(2000);
            frontendshowings.selectStartTime(frontendshowings.getFirstStartTime());
            frontendshowings.clickOnSaveButton();
            WaitFor.sleepFor(2000);
            count++;
        }
        String expected = count + " upcoming";
        Assert.assertEquals(myListings.txt_UpcomingShowings("100 Maspeth Avenue").getText(), expected, "Expected count is not same");
        AutomationLog.info("Adding Showings increments upcoming showings count");
    }

    public void verifyIfshowingScheduleIsModified() throws Exception 
    {
        frontendshowings.enterDateInDatePickerTextBox(getNextDate(1));
        frontendshowings.clickOnSaveButton();
        WaitFor.sleepFor(2000);
        myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        frontendshowings.hoverOnShowing(0);
        frontendshowings.clickOnEditShowingIcon(0);
        String expectedDate = frontendshowings.changeDateFormat();
        String actualdate = frontendshowings.getSelectedDate();
        frontendshowings.clickOnCloseButton();
        Assert.assertEquals(actualdate, expectedDate, "Expected date is not same");
        AutomationLog.info("Modifying schedule is successful");
    }

    public void verifyIfDeletingShowingsDecrementsUpcomingShowingsCount() throws Exception 
    {
        myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        int showingsCount = frontendshowings.getUpcomingShowingsList().size();
        int deletedCount = 2;
        frontendshowings.deleteUpcomingShowings(deletedCount);
        frontendshowings.clickOnSaveButton();
        WaitFor.sleepFor(2000);
        String actual = myListings.txt_UpcomingShowings("100 Maspeth Avenue").getText();
        String expected = (showingsCount-deletedCount) + " upcoming";
        Assert.assertEquals(actual, expected, "Expected showings not deleted");
        AutomationLog.info("Deleting showings decrements upcoming showings count");
    }

    public void verifyIfAddedShowingIsSeenOnListingDetailsPage() throws Exception 
    {
        addShowing();
        WaitFor.sleepFor(2000);
        Assert.assertEquals(myListings.txt_UpcomingShowings("100 Maspeth Avenue").getText(), "1 upcoming", "Expected showing is not added ");
        //AutomationLog.info("Entering valid schedule time adds upcoming showing");
        myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        String expected = frontendshowings.getFirstUpcomingShowing().getText();
        frontendshowings.clickOnCloseButton();
        curHandle = Page.driver.getWindowHandle();
        listingdetail  = myListings.clickOnListingNameLink("100 Maspeth Avenue");
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
        AutomationLog.info("Adding showing from Mylisting Schedule Now link shows showing on listing detail page");
        Page.driver.close();
        Page.driver.switchTo().window(curHandle);
    }

    public void deleteShowings() throws Exception
    {
        myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        frontendshowings.clearAllUpcomingShowings(); 
    }

    @Override
    protected String successMessage()
    {
        return "passed";
    }

    @Override
    protected String failureMessage()
    {
        return "failed";
    }
}
