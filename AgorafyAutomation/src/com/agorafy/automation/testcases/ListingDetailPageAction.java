package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.ListingDetailPage;
import com.agorafy.automation.pageobjects.Page;

public class ListingDetailPageAction extends AutomationTestCaseVerification 
{
    private ListingDetailPage listingDetailPage = null;

    public ListingDetailPageAction()
    {
        super();
    }

    public void setup()
    {
    	listingDetailPage = ListingDetailPage.listingDetailPage();
    	try
        {
            super.setup();
            Page.driver.get("http://www.agorafy.com/listing/27833/224-232-West-35th-Street-Office-for-Lease-Suite-506");
            listingDetailPage.clickSubscribeToListingLinkInListingDetailPage();
            AutomationLog.info("Able to Navigate to Subscribe To Listing Detail Page popup");
            
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not Navigate to Subscribe To Listing Detail Page popup");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
           HashMap<String, String> getvalidcrendial = testCaseData.get("validCredential");
           verifySubscribeToListingLinkInListingDetailPage(listingDetailPage,getvalidcrendial);
    }

    public void verifySubscribeToListingLinkInListingDetailPage(ListingDetailPage subscribeListingPopup, HashMap<String, String> getvalidcrendial) throws Exception
    {
        try
        {
        	subscribeListingPopup.populateLoginPopUpDataForListingDetailPage(getvalidcrendial.get("username"),getvalidcrendial.get("password"));
            Assert.assertEquals(subscribeListingPopup.currentURL(),"http://www.agorafy.com/listing/27833/224-232-West-35th-Street-Office-for-Lease-Suite-506","unsuccessfull login after entering valid credentials for ListingDetailPage" );
            AutomationLog.info("successfull login after entering valid credentials for ListingDetailPage");

            String verifyChangedTextOfSubscribeToLinkInListingDetailPage = listingDetailPage.getUnSubscribeToListingLinkTextInListingDetailPage();
            Assert.assertEquals(verifyChangedTextOfSubscribeToLinkInListingDetailPage,"Unsubscribe listing", "Didn't Found the changed text for Subscribe to listing link In Listing Detail Page");
            AutomationLog.info("Found the changed text for Subscribe to listing link In Listing Detail Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not send credentials to login pop up of ListingDetailPage");
        }
    }

@Override
    protected String successMessage()
     {
            return "Funtionality of SubscribeToListingLink on ListingDetailPage is Passed";
     }

@Override
    protected String failureMessage()
    {
            return "Funtionality of SubscribeToListingLink on ListingDetailPage is Failed";
    }
}
