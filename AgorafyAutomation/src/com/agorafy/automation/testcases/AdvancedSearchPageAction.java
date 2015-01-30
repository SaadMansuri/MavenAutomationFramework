package com.agorafy.automation.testcases;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertySearch;
import com.agorafy.automation.pageobjects.subnavigationmenu.AdvancedSearchPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

public class AdvancedSearchPageAction extends AutomationTestCaseVerification
{
    private AdvancedSearchPage advancedsearch = null;
    private PropertySearch propsearch = null;
    private SubNavigation subnavigation = null;
    public AdvancedSearchPageAction() 
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        try 
        {
            subnavigation = Homepage.subNavigation();
            advancedsearch = subnavigation.clickLinkAdvancedSearch();
            AutomationLog.info("Redirected to advanced search page  ");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Could not navigate to Aadvanced search page");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        verifyIfResidentialListingCategoryIsSelected();
        verifyIfEmptySearchPerformed();
        verifyIfCommercialRadioButtonClicked();
        verifySearchByCommercial();
    }

    public void verifyIfResidentialListingCategoryIsSelected() throws Exception
    {
        advancedsearch.clickOnResidentialRadioButton();
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(advancedsearch.dropdown_ResidentialOnly().isDisplayed(), true, "Expected residential only drop down not shown");
        Assert.assertEquals(advancedsearch.txtboxes_ResidentialOnly().isDisplayed(), true, "Expected residential only textboxes not shown");
        AutomationLog.info("Clicking on Residential radio button shows residential only drop down and textboxes");
    }

    public void verifyIfEmptySearchPerformed() throws Exception
    {
        advancedsearch.clickOnSearchButton();
        Assert.assertEquals(advancedsearch.txtbx_SearchInput().getAttribute("required"), "true", "Expected SearchInput field is not mandatory");
        AutomationLog.info("Search Input field is mandatory");
    }

    public void verifyIfCommercialRadioButtonClicked() throws Exception
    {
        advancedsearch.clickOnCommercialRadioButton();
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(advancedsearch.dropdown_ResidentialOnly().isDisplayed(), false, "Expected residential only drop down not shown");
        Assert.assertEquals(advancedsearch.txtboxes_ResidentialOnly().isDisplayed(), false, "Expected residential only textboxes not shown");
        AutomationLog.info("Clicking back to commercial radio button hides residential only fields");
    }

    public void verifySearchByCommercial() throws Exception
    {
        HashMap<String, String> searchData = testCaseData.get("SearchCommercial");
        searchByAddress(searchData);
    }

    public void searchByAddress(HashMap<String, String> searchData) throws Exception
    {
        advancedsearch.selectBorough(searchData.get("borough"));
        advancedsearch.txtbx_SearchInput().sendKeys(searchData.get("searchTerm"));
        propsearch = advancedsearch.clickOnSearchButton();
        String titleText = "Results for Retail in "+ searchData.get("searchTerm");
        System.out.println(titleText);
        System.out.println(propsearch.title_SearchResult().getText());
        Assert.assertEquals(propsearch.title_SearchResult().getText(), titleText, "not same");
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
