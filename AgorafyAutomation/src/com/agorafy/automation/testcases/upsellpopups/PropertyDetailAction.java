package com.agorafy.automation.testcases.upsellpopups;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertySearch;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;
import com.agorafy.automation.pageobjects.upsellpopups.PropertyDetailPage;

/**
 * Verify whether login pop up is seen when link for 'NYC property records' is clicked in Logged out state
 * Verify whether login pop up is seen when link for 'Contact information' is clicked in Logged out state
 */

public class PropertyDetailAction extends AutomationTestCaseVerification
{
    ListingDetailPage listingDetailPage;
    PropertySearch searchResultsPage;
    PropertyDetailPage propertydetails;
    Header header=Homepage.header();

    public PropertyDetailAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        listingDetailPage = ListingDetailPage.listingDetailPage();
        try
        {
            super.setup();

            Homepage homepage = Homepage.homePage();
            searchResultsPage = homepage.populateSearchTermTextBox("Manhattan","Commercial","Retail in 10010");
            String handle = Page.driver.getWindowHandle();
            listingDetailPage = searchResultsPage.clickSearchResult();
            

            Set<String> numbers = Page.driver.getWindowHandles();
            numbers.remove(handle);
            String newHandle = numbers.iterator().next();
            Page.driver.switchTo().window(newHandle);
            
            propertydetails = listingDetailPage.clickPropertyDetailLink();
            AutomationLog.info("Navigating to Property Detail page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to Property Detail Page");
        }
    }
    
    @Override
    protected void verifyTestCases() throws Exception 
    {
        verifyLoginPopupOnPropertyRecords(propertydetails);

        Credentials ValidCredentials = userCredentials();
        verifyPageAfterLogin(propertydetails,ValidCredentials);

        preconditionForNextTest();
        verifyLoginPopupOnContactInformation(propertydetails, ValidCredentials);
    }

    public void verifyLoginPopupOnPropertyRecords(PropertyDetailPage propertydetails) throws Exception
    {
        propertydetails.clickOnPropertyRecordsLink();
        AutomationLog.info("Signin Link Clicked Successfully");
        Page.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(propertydetails.checkingLogInPopUpUpsell(),true,"Expected form is not present");
        AutomationLog.info("Login popup form is present on page");
        Assert.assertEquals(propertydetails.getTitleOfLogInPopUp(),"Log in","Expected Title is not present on Login Pop-Up");
        AutomationLog.info("Login Title on Pop-up is verified");
    }

    public void verifyPageAfterLogin(PropertyDetailPage propertydetails,Credentials validCredentials) throws Exception
    {
        String beforeloginUrl=Page.driver.getCurrentUrl();
        propertydetails.loginProcess(validCredentials.getEmail(), validCredentials.getPassword());
        Assert.assertEquals(Page.driver.getCurrentUrl(),beforeloginUrl,"Expected Url is differnt then expected Url");
        AutomationLog.info("User after login stays on a same page");
        Assert.assertEquals(propertydetails.checkingPropertyRecordSection(),true,"Expected Property Record section is not present on Property Page");
        AutomationLog.info("Property Record section is present on property page");
    }

    public void preconditionForNextTest() throws Exception
    {
        String currentUrl = listingDetailPage.currentURL();
        header.logout();
        Page.driver.get(currentUrl);
    }

    public void verifyLoginPopupOnContactInformation(PropertyDetailPage propertydetails,Credentials validCredentials) throws Exception
    {
        String beforeloginUrl=Page.driver.getCurrentUrl();
        propertydetails.clickOnContactInformation();
        Assert.assertEquals(propertydetails.checkingLogInPopUpUpsell(),true,"Expected Login Pop form is not present");
        AutomationLog.info("Login pop-up is displayed");
        Assert.assertEquals(propertydetails.getTitleOfLogInPopUp(),"Log in","Expected Title is not present on Login Pop-Up");
        AutomationLog.info("Login Title on Pop-up is found successfully");
        propertydetails.loginProcess(validCredentials.getEmail(), validCredentials.getPassword());
        Assert.assertEquals(Page.driver.getCurrentUrl(),beforeloginUrl,"Expected Url is differnt then expected Url");
        AutomationLog.info("User after login stays on a same page");
    }

    @Override
    protected String successMessage() {
        return "Test for verifying login pop-ups on Property Detail page has Passed";
    }

    @Override
    protected String failureMessage() {
        return "Test for verifying login pop-ups on Property Detail page has Failed";
    }
}
