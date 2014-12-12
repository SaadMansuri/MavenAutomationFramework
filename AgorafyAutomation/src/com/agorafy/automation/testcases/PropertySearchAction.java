package com.agorafy.automation.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.LoginPopUp;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertySearch;

public class PropertySearchAction extends AutomationTestCaseVerification
{
    private Homepage homepage;
    private PropertySearch propertysearch;
    private LoginPopUp loginpopup;

    public PropertySearchAction()
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();
        try
        {
            homepage=Homepage.homePage();
            Page.driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
            propertysearch=homepage.populateSearchTermTextBox("Manhattan","Residential","Rentals in 10010");
            loginpopup=new LoginPopUp(Page.driver);
            AutomationLog.info("Redirected to Property Search page ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not be redirected to Property Search page");
            e.getMessage();
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        verifyIfLoginPopUpIsShownOnSubscribeToThisSearchLink();
        verifyIfSearchByBedsShowsPropertiesWithNoOfBeds();
        verifyPropertiesWithXBathsAndYBedsAndDifferentCombinations();
    }

    public void verifyIfLoginPopUpIsShownOnSubscribeToThisSearchLink() throws Exception
    {
        propertysearch.clickOnSubscribeToThisSearchLink();
        WaitFor.ElementToBeDisplayed(Page.driver, loginpopup.getLoginPopUpLocator());
        Assert.assertEquals(propertysearch.loginPopUpIsDisplayed(loginpopup),true,"Expected login pop up could not found");
        Assert.assertEquals(propertysearch.getTitleForLoginPopUp(), "Log in", "Could not Get login pop up title");
        AutomationLog.info("Clicking on Subscribe to this search link displays Login popup ");
    }

    public void verifyIfSearchByBedsShowsPropertiesWithNoOfBeds() throws Exception
    {
        String result = null;
        propertysearch.closeLoginPoPup(loginpopup);
        propertysearch.searchByNoOfBeds("2");
        result = propertysearch.NoOfBedsInPropertiesSearch();
        Assert.assertEquals(result, "2", "Expected Properties with specified beds is not shown");
    }

    public void verifyPropertiesWithXBathsAndYBedsAndDifferentCombinations() throws Exception
    {
        propertysearch.clickOnAdvanceSearchDropDownIcon();
        propertysearch.BedsInAdvanceSearchForm("2");
        propertysearch.clickOnSearchButtonOnAdvanceSearchform();
        Assert.assertEquals(propertysearch.NoOfBedsInPropertiesSearch(), "2", "Expected Properties with specified beds is not shown");
        Assert.assertEquals(propertysearch.FilterText_Bath().getText(), "2", "Expected Properties with specified beds is not shown");
    }

    @Override
    protected String successMessage() 
    {
    	return "Test case for LoginPopUp on PropertySearch passed";
    }

    @Override
    protected String failureMessage() 
    {
    	return "Test case for LoginPopUp on PropertySearch failed";
    }

}
