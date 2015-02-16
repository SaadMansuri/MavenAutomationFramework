package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Dashboard;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertySearch;
import com.agorafy.automation.pageobjects.subnavigationmenu.MySubscriptions;

public class SubscriptionsAction extends AutomationTestCaseVerification 
{

    private Homepage homePage;
    private HeaderLoginForm headerLoginForm;
    private HashMap<String, String> dataFromCSV;
    private PropertySearch propertySearch;
	private boolean actualStatusOfElement;

    public SubscriptionsAction() 
    {
        super();
    }

    @Override
    public void setup()
    {
        try 
        {
            super.setup();
            homePage = Homepage.homePage();
            headerLoginForm = homePage.openHeaderLoginForm();
            Credentials ValidCredentials = userCredentials();
            homePage = headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            dataFromCSV = testCaseData.get("SearchCombination");
            propertySearch = homePage.populateSearchTermTextBox(dataFromCSV.get("boroughname"), dataFromCSV.get("listingcategory"), dataFromCSV.get("searchstring"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Failed setup for Subscription test cases");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        /*AutomationLog.info("Verify whether Subscription box display's under username after clicking Subscribe to this search link ");
        verifySubscriptionBoxDisplay();

        AutomationLog.info("Verify whether same search term reflects in Subscription window under user's avator");
        verifySearchTerm();

        AutomationLog.info("Verify whether Subscribe to this search link vanishes after clicking Subscribe in subscription box under user's avatar");
        verifySubscriptionTextVanishing();

        AutomationLog.info("Verify whether pop-up window opens when you subscribe the already subscribed search");
        verifyPopUpAlreadySubscribed();
*/
        AutomationLog.info("Verify whether Subscriptions window has view more subscriptions link");
        verifyViewMoreSubscriptionsLink();
    }

    private void verifyViewMoreSubscriptionsLink() throws Exception 
    {
        propertySearch.refreshPage();
        propertySearch.clickOnSubscribeToThisSearchLink();
        try 
        {
            WaitFor.waitUntilElementIsLoaded(Page.driver, By.xpath(".//*[@id='subscriptionsContainer']/blockquote/div[5]/a"));
            AutomationLog.info("View More Subscriptions link is found in subcriptions window");
        }
        catch (Exception e) 
        {
            AutomationLog.error("View More Subscriptions link is not found in subcriptions window");
        }

    }

	private void verifyPopUpAlreadySubscribed() throws Exception 
    {
        propertySearch.refreshPage();
        propertySearch.clickOnSubscribeToThisSearchLink();
        propertySearch.clickSubscribeInSubscriptionWindow();
        try 
        {
            propertySearch.alertAccept();
            AutomationLog.info("Alert is present as expected, if we subscribe already subscribed search");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Alert is expected since current search subscription is already subscribed");
        }
        propertySearch.closeSubscriptionWindow();
    }

    private void verifySearchTerm() throws Exception 
    {
        propertySearch.clickOnSubscribeToThisSearchLink();
        String searchText = propertySearch.getSearchStringInSubscriptionWindow();
        dataFromCSV = testCaseData.get("SearchCombination");
        Assert.assertEquals(searchText, dataFromCSV.get("searchstring"), "Data mismatch in search text from search navigation and Subscription window from user's dropdown");
        AutomationLog.info("Same Search string data is shown in search in navigation bar and subscription window under user name");
        propertySearch.closeSubscriptionWindow();
    }

    private void verifySubscriptionTextVanishing() throws Exception 
    {
        propertySearch.clickOnSubscribeToThisSearchLink();
        propertySearch.clickSubscribeInSubscriptionWindow();
        actualStatusOfElement = false;
        actualStatusOfElement = propertySearch.link_SubscribeToThisSearch().isDisplayed();
        Assert.assertEquals(actualStatusOfElement, false, "Subscribe to this search link still persists, it should be vanished");
        AutomationLog.info("Subscribe to this search link vanishes sucessfully");
        propertySearch.closeSubscriptionWindow();
    }

	private void verifySubscriptionBoxDisplay() throws Exception 
    {
        propertySearch.clickOnSubscribeToThisSearchLink();
        actualStatusOfElement = false;
        actualStatusOfElement = propertySearch.element_SubscriptionWindow().isDisplayed();
        Assert.assertEquals(actualStatusOfElement, true, "Subscription Box under user's Avatar is not displayed");
        AutomationLog.info("Subscription Box under user's Avatar is displayed sucessfully");
        propertySearch.closeSubscriptionWindow();
    }

	@Override
    protected String successMessage() 
    {
        return "Subscriptions page tested successfully";
    }

    @Override
    protected String failureMessage() 
    {
        return "Failed to test Subscriptions page";
    }
}
