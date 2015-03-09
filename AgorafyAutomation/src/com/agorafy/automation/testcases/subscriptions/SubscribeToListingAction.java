package com.agorafy.automation.testcases.subscriptions;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.IntermidiatePage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertySearch;
import com.agorafy.automation.pageobjects.subnavigationmenu.MySubscriptions;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;
import com.agorafy.automation.utilities.HandlingWindows;

public class SubscribeToListingAction extends AutomationTestCaseVerification
{

    private Homepage homePage;
    private HeaderLoginForm headerLoginForm;
    private HashMap<String, String> dataFromCSV = new HashMap<> ();
    private PropertySearch propertySearch;
    private IntermidiatePage intermidiatePage = null;
    private ListingDetailPage listingDetailPage;
    private String destinationPage;
    private Header header = Header.header(); 
    private MySubscriptions mySubscriptions;
    private boolean loginStatus;

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
            setupToReachListingDetailsPage();
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

        AutomationLog.info("Verify whether Subscribe To Listing option changes to Unsubscribe To Listing option started...");
        verifySubscribeToListingOption();

        AutomationLog.info("Verify whether listing name sholud be reflected in subscribe to respective listing in subscription window started...");
        verifyListingNameInSubscribeToRespectiveListingOptionInSubscriptionWindow();

        AutomationLog.info("Verify whether Subscribe To respective listing option in subscriptions window below profile pic changes to Unsubscribe To respective Listing option started...");
        verifySubscribeToRespectiveListingOptionInSubscriptionWindow();

        AutomationLog.info("Verify whether Subscribe To respective listing option in listing details page changes to Unsubscribe To respective Listing option started...");
        verifyListingDetailsPageAfterClickSubscribeToListingInSubscriptionWindow();

        AutomationLog.info("Verify whether subscribed listing in listing details page reflects in My subscriptions page started...");
        verifySubscribedListingInMySubscriptionsPage();
    }

    private void verifySubscribedListingInMySubscriptionsPage() throws Exception 
    {
        loginStatus = true;
        listingDetailPage.clickOnSubscribeToListingLink(loginStatus);
        String expectedListingTitle = listingDetailPage.txt_listingTitle();
        expectedListingTitle = expectedListingTitle.replaceAll("Property Details", "");
        header.clickOnProfileNameDropdownArrow();
        header.clickSubscriptionsLinkBelowProfilePic();
        mySubscriptions.clickViewMoreSubscriptionsInSubscriptionWindow();
        List<WebElement> allListings =  mySubscriptions.list_AllSubscribedListings();
        String actualListingTitle;
        boolean actualListingPresentStatus = false;
        for(WebElement singleListing : allListings)
        {
            actualListingTitle = singleListing.getText();
            if(actualListingTitle.matches(expectedListingTitle))
            {
                actualListingPresentStatus = true;
                mySubscriptions.deleteSubscribedSearchOnRHS(singleListing);
            }
        }
        Assert.assertEquals(actualListingPresentStatus, true, "Listing subscribed on listing details page does not seen on My Subscriptions page, RHS under listing subscriptions");
        AutomationLog.info("Listing subscribed on listing details page successfully seen on My Subscriptions page, RHS under listing subscriptions");
        Page.navigateToPreviousPage();
    }

    private void verifyListingDetailsPageAfterClickSubscribeToListingInSubscriptionWindow() throws Exception 
    {
        header.clickOnProfileNameDropdownArrow();
        mySubscriptions = header.clickSubscriptionsLinkBelowProfilePic();
        mySubscriptions.clickSubscribeToRespectiveListingInSubscriptionWindow();
        dataFromCSV = testCaseData.get("ExpectedUnsubscribeToListingText");
        String expectedString = dataFromCSV.get("ExpectedText");
        Thread.sleep(1000);
        String actualStringAfterSubscribeListing = listingDetailPage.link_UnsubscribeListing().getText();
        Assert.assertEquals(actualStringAfterSubscribeListing, expectedString, "After performing click operation on Subscribe to respective listing in subscription window, Subscribe to listing does not change to unsubscribe listing on listing details page");
        AutomationLog.info("After performing click operation on Subscribe to respective listing in subscription window, Subscribe to listing changes to unsubscribe listing on listing details page");
        mySubscriptions.clickUnsubscribeFromRespectiveListingInSubscriptionWindow();
        mySubscriptions.closeSubscriptionWindow();
    }

    private void verifyListingNameInSubscribeToRespectiveListingOptionInSubscriptionWindow() throws Exception 
    {
        header.clickOnProfileNameDropdownArrow();
        mySubscriptions = header.clickSubscriptionsLinkBelowProfilePic();
        String subscribeToRespectiveListingTextOnListingDetailsPage = listingDetailPage.txt_listingTitle();
        subscribeToRespectiveListingTextOnListingDetailsPage = subscribeToRespectiveListingTextOnListingDetailsPage.replaceAll("Property Details", "");
        String subscribeToRespectiveListingTextInSubscriptionWindow = mySubscriptions.txt_SubscribeToRespectiveListingInSubscriptionWindow();
        subscribeToRespectiveListingTextOnListingDetailsPage = "Subscribe to " + subscribeToRespectiveListingTextOnListingDetailsPage;
        Assert.assertEquals(subscribeToRespectiveListingTextInSubscriptionWindow, subscribeToRespectiveListingTextOnListingDetailsPage, "listing title on listing details page and in subscription window below profile pic does not match");
        AutomationLog.info("listing title on listing details page and in subscription window below profile pic match perfectly");
        mySubscriptions.closeSubscriptionWindow();
    }

    private void verifySubscribeToRespectiveListingOptionInSubscriptionWindow() throws Exception 
    {
        try 
        {
            header.clickOnProfileNameDropdownArrow();
            mySubscriptions = header.clickSubscriptionsLinkBelowProfilePic();
            mySubscriptions.clickSubscribeToRespectiveListingInSubscriptionWindow();
            String expectedString = "Unsubscribe from ";
            String listingNameOnListingDetailsPage = listingDetailPage.txt_listingTitle();
            expectedString = expectedString.concat(listingNameOnListingDetailsPage);
            expectedString = expectedString.replaceAll("Property Details", "");
            Thread.sleep(1000);
            String actualStringAfterSubscribing = mySubscriptions.txt_UnsubscrubeFromRespectiveListingInSubscriptionWindow();
            actualStringAfterSubscribing = actualStringAfterSubscribing.replaceAll("Property Details", "");
            Assert.assertEquals(actualStringAfterSubscribing, expectedString, "Subscribe to respective listing option in subscription window below profile pic does not change to Unsubscribe from listing after click performed");
            AutomationLog.info("Subscribe to respective listing option in subscription window below profile pic changes to Unsubscribe from listing after click performed");
            mySubscriptions.clickUnsubscribeFromRespectiveListingInSubscriptionWindow();
            mySubscriptions.closeSubscriptionWindow();
        }
        catch (Exception e) 
        {
            AutomationLog.error("Subscribe to respective listing link in subscription window failed");
            throw (e);
        }
    }

    private void verifySubscribeToListingOption() throws Exception
    {
        loginStatus = true;
        try 
        {
            listingDetailPage.clickOnSubscribeToListingLink(loginStatus);
            Thread.sleep(1000);
            String actualSubscribeStatus = listingDetailPage.link_UnsubscribeListing().getText();
            dataFromCSV = testCaseData.get("ExpectedUnsubscribeToListingText");
            String expectedSubscriptionStatus = dataFromCSV.get("ExpectedText");
            Assert.assertEquals(actualSubscribeStatus, expectedSubscriptionStatus, "In Listing details page, Subscribe to listing link does not change to Unsubscribe listing");
            listingDetailPage.clickOnUnsubscribeListingLink();
            AutomationLog.info("Subscribe to link testing passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Subscribe to link testing failed");
            throw (e);
        }
    }

    public void setupToReachListingDetailsPage() throws Exception
    {
        try 
        {
            String noOfSearchResults = propertySearch.noOfSearchResults();
            if(!(noOfSearchResults.equals("0 matches")))/*checks whether search results are more than 0*/
            {
                boolean multipleListingsStatus;
                multipleListingsStatus = propertySearch.checkForMultiplelistingsInFirstProperty();
                /*first search result can have multiple listings or single listing depends on that it navigates to listing details page or intermidiate page*/
                if(multipleListingsStatus)
                {
                    intermidiatePage = (IntermidiatePage) propertySearch.selectFirstListingOnPropertySearchPage(multipleListingsStatus);
                }
                else
                {
                    listingDetailPage = (ListingDetailPage) propertySearch.selectFirstListingOnPropertySearchPage(multipleListingsStatus);
                }
                Integer windowNoToSwitch = 2;
                HandlingWindows.switchToWindow(Page.driver, windowNoToSwitch);
                if(intermidiatePage != null)/*If there are multiple listings then it needs one more click to reach listing details page*/
                {
                    listingDetailPage = intermidiatePage.selectFirstListingOnIntermidiatePage();
                    windowNoToSwitch = 3;
                    HandlingWindows.switchToWindow(Page.driver, windowNoToSwitch);
                }
            }
            else
            {
                AutomationLog.error("SubscribeToListing.csv file (SearchInputCombination) -input combination should result atleast one property listing");
            }
            
            AutomationLog.info("Set up to reach listing details page successfull");
        }
        catch (Exception e)	
        {
            AutomationLog.error("Set up to reach listing details page failed");
            throw (e);
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
