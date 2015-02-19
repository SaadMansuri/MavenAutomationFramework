package com.agorafy.automation.testcases.subscriptions;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AppDriver;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.IntermidiatePage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertySearch;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;
import com.agorafy.automation.utilities.HandlingWindows;

public class SubscribeToListingAction extends AutomationTestCaseVerification
{

    private Homepage homePage;
    private HeaderLoginForm headerLoginForm;
    private HashMap<String, String> dataFromCSV;
    private PropertySearch propertySearch;
    private IntermidiatePage intermidiatePage = null;
    private ListingDetailPage listingDetailPage;
	private String destinationPage;

	@Override
    public void setup() 
    {
        super.setup();
        try 
        {
            homePage = Homepage.homePage();
            headerLoginForm = homePage.openHeaderLoginForm();
            Credentials ValidCredentials = userCredentials();
            homePage = headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            dataFromCSV = testCaseData.get("SearchInputCombination");
            propertySearch = homePage.populateSearchTermTextBox(dataFromCSV.get("boroughname"), dataFromCSV.get("listingcategory"), dataFromCSV.get("searchstring"));
            AutomationLog.info("Subscribe To Listing Action setup sucessfull");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Setup failed for Subscribe To Listing Action");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        AutomationLog.info("Verify whether Subscribe To Listing link changes to Unsubscribe To Listing link started...");
        verifySubscribeToListingLink();
    }

    private void verifySubscribeToListingLink()  
    {
        try 
        {
            setupForVerifySubscribeToListingLink();
            listingDetailPage.clickSubscribeToListingLinkInLoggedInMode();
            String actualSubscribeStatus = listingDetailPage.getUnSubscribeToListingLinkTextInListingDetailPage();
            dataFromCSV = testCaseData.get("ExpectedUnsubscribeToListingText");
            String expectedSubscriptionStatus = dataFromCSV.get("ExpectedText");
            Assert.assertEquals(actualSubscribeStatus, expectedSubscriptionStatus, "In Listing details page, Subscribe to listing link does not change to Unsubscribe listing");
            listingDetailPage.clickUnsubscribeListingLink();
            AutomationLog.info("Subscribe to link testing passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Subscribe to link testing failed");
        }
    }

    public void setupForVerifySubscribeToListingLink() 
    {
        try 
        {
            String noOfSearchResults = propertySearch.noOfSearchResults();
            if(!(noOfSearchResults.equals("0 matches")))
            {
                boolean multipleListingsStatus;
                multipleListingsStatus = propertySearch.checkForMultiplelistingsInFirstProperty();
                if(multipleListingsStatus)
                {
                    destinationPage = "IntermidiatePage";
                    intermidiatePage = (IntermidiatePage) propertySearch.selectFirstListingOnPropertySearchPage(destinationPage);
                }
                else
                {
                    destinationPage = "ListingDetailPage";
                    listingDetailPage = (ListingDetailPage) propertySearch.selectFirstListingOnPropertySearchPage(destinationPage);
                }
                Integer windowNoToSwitch = 2;
                HandlingWindows.switchToWindow(Page.driver, windowNoToSwitch);
                if(intermidiatePage != null)
                {
                    listingDetailPage = intermidiatePage.selectFirstListingOnIntermidiatePage();
                    windowNoToSwitch = 3;
                    HandlingWindows.switchToWindow(Page.driver, windowNoToSwitch);
                }
            }
            else
            {
                AutomationLog.error("SubscribeToListing.csv file (SearchInputCombination) -input combination should result atleast one one property listing");
            }
            
            AutomationLog.info("Set up for Verify Subscribe To Listing Link test case passed");
        }
        catch (Exception e)	
        {
            AutomationLog.error("Set up for Verify Subscribe To Listing Link test case failed");
        }
    }

    @Override
    protected String successMessage() 
    {
        return "Subscribe To Listing Action passed";
    }

    @Override
    protected String failureMessage() 
    {	
        String note = "Test input data(SearchInputCombination) should produce atleast one search result, otherwise test case will produce false results";
        return "Subscribe To Listing Action Failed, Note:" +note;
    }

}
