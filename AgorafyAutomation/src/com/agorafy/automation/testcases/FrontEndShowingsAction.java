package com.agorafy.automation.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

public class FrontEndShowingsAction extends AutomationTestCaseVerification
{

    private Header header;
    private HeaderLoginForm headerloginform;
    private Homepage homepage;
    private SubNavigation subnavigation = SubNavigation.subNavigation();
    private MyListings myListings;
    private FrontEndShowings frontendshowings;

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
       verifyIfShowingIsDeleted();
       verifyIfShowingIsAdded();
       verifyIfAddingShowingsIncrementsUpcomingShowingsCount();

    }

    public void verifyIfClickingScheduleNowLinkShowsShowingsPopUp() throws Exception
    {
        frontendshowings = myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        Assert.assertTrue(frontendshowings.popup_FrontEndShowings().isDisplayed(), "Expected FrontEnd Showings PopUp not shown");
        AutomationLog.info("Clicking schedule now link show login Popup");
        
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
        frontendshowings.selectStartTime(getCurrentTime());
        frontendshowings.clickOnSaveButton();
    }

    public void verifyIfFrontEndShowingsPopUpIsClosedWithoutSaving() throws Exception
    {
        frontendshowings.enterDateInDatePickerTextBox(getCurrentDate());
        frontendshowings.selectStartTime(getCurrentTime());
        frontendshowings.clickOnCloseButton();
        Assert.assertEquals(myListings.txt_UpcomingShowings("100 Maspeth Avenue").getText(), "None scheduled","Expected text not found" );
        AutomationLog.info("Closing FrontEndShowingsPopUp without save does not add Showing");
    }

    public void verifyIfSaveButtonClickedWithoutSelectingDateForShowing() throws Exception 
    {
        myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        WaitFor.sleepFor(2000);
        frontendshowings.selectStartTime(getCurrentTime());
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
        frontendshowings.selectStartTime(getCurrentTime());
        frontendshowings.clickOnSaveButton();
        Assert.assertEquals(frontendshowings.text_MessageBar().getText(), "Invalid showing schedule", "Expected text message is not shown");
        AutomationLog.info("Clicking save button with past showing schedule shows Error Message");
        frontendshowings.clickOnCloseButton();
    }

    public void verifyIfShowingIsAdded() throws Exception 
    {
        addShowing();
        Assert.assertEquals(myListings.txt_UpcomingShowings("100 Maspeth Avenue"), "1 upcoming", "Expected showing is not added ");
        AutomationLog.info("Entering valid schedule time adds upcoming showing");
    }

    public void verifyIfShowingIsDeleted() throws Exception
    {
        myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
        frontendshowings.hoverOnShowing();
        frontendshowings.clickOnDeleteShowingIcon();
        frontendshowings.clickOnSaveButton();
        WaitFor.sleepFor(2000);
        Assert.assertEquals(myListings.txt_UpcomingShowings("100 Maspeth Avenue").getText(), "None scheduled", "Expected showing is not deleted ");
        AutomationLog.info("Clicking delete icon removes showing from upcoming showing");
    }

    public void verifyIfAddingShowingsIncrementsUpcomingShowingsCount() throws Exception 
    {
        int count = 0;
        for(int i = 1; i <= 3 ; i++)
        {
            myListings.clickOnScheduleNowLink("100 Maspeth Avenue");
            frontendshowings.enterDateInDatePickerTextBox(getNextDate(i));
            frontendshowings.selectStartTime(getCurrentTime());
            frontendshowings.clickOnSaveButton();
            count++;
        }
        Assert.assertEquals(frontendshowings.getNoOfAddedShowings(), count, "Expected count is not same");
        AutomationLog.info("Adding Showings increments upcoming showings count");
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
