package com.agorafy.automation.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.SearchResultsPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.AdvancedSearchPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;

public class AdvancedSearchPageAction extends AutomationTestCaseVerification
{
    private AdvancedSearchPage advancedsearch = null;
    private SearchResultsPage propsearch = null;
    private ListingDetailPage listingdetail = null;
    private SubNavigation subnavigation = null;
    private List<String> list = new ArrayList<String>();
    private Homepage homepage = Homepage.homePage();

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
            subnavigation = Page.subNavigation();
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
        verifyIfCommercialListingCategoryIsSelected();
        verifySearchByCommercial();
        verifySearchByResidential();

        AutomationLog.info("Verify whether auto compile is provided for search criteria");
        verifyAutoComplete();
    }

    private void verifyAutoComplete() throws Exception 
    {
        advancedsearch.txtbx_SearchInput().sendKeys("1");
        WaitFor.sleepFor(1000);
        boolean autoCompleteBoxStatus = false;
        autoCompleteBoxStatus = advancedsearch.autoComplete().isDisplayed();
        Assert.assertEquals(autoCompleteBoxStatus, true, "Auto complete box is not displayed");
        AutomationLog.info("Auto complete box is displayed sucessfully");
    }

	public void verifyIfResidentialListingCategoryIsSelected() throws Exception
    {
        advancedsearch.clickOnResidentialRadioButton();
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(advancedsearch.dropdown_PropertyType().isDisplayed(), true, "Expected residential only drop down not shown");
        Assert.assertEquals(advancedsearch.txtboxes_BedsNBaths().isDisplayed(), true, "Expected residential only textboxes not shown");
        AutomationLog.info("Clicking on Residential radio button shows PropertyType drop down and Beds and Baths textboxes");
    }

    public void verifyIfEmptySearchPerformed() throws Exception
    {
        advancedsearch.clickOnSearchButton();
        Assert.assertEquals(advancedsearch.txtbx_SearchInput().getAttribute("required"), "true", "Expected SearchInput field is not mandatory");
        AutomationLog.info("Search Input field is mandatory");
    }

    public void verifyIfCommercialListingCategoryIsSelected() throws Exception
    {
        advancedsearch.clickOnCommercialRadioButton();
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(advancedsearch.dropdown_PropertyType().isDisplayed(), false, "Expected residential only drop down not shown");
        Assert.assertEquals(advancedsearch.txtboxes_BedsNBaths().isDisplayed(), false, "Expected residential only textboxes not shown");
        AutomationLog.info("Clicking on commercial radio button hides PropertyType drop down and Beds and Baths textboxes");
    }

    public void verifySearchByCommercial() throws Exception
    {
        HashMap<String, String> searchData = testCaseData.get("SearchCommercial");
        searchByAddress(searchData);
        searchByListingtype();
        searchBySize(searchData);
        searchByPrice(searchData);
    }

    public void verifySearchByResidential() throws Exception
    {
        HashMap<String, String> searchData = testCaseData.get("SearchResidential");
        searchResidential(searchData);
        advancedsearch.navigateToPreviousPage();
    }

    public void searchByAddress(HashMap<String, String> searchData) throws Exception
    {
        advancedsearch.selectBorough(searchData.get("borough"));
        advancedsearch.txtbx_SearchInput().clear();
        advancedsearch.txtbx_SearchInput().sendKeys(searchData.get("searchTerm"));
        propsearch = advancedsearch.clickOnSearchButton();
        String titleText = searchData.get("searchText") + searchData.get("searchTerm");
        Assert.assertEquals(propsearch.title_SearchResult().getText(), titleText, "Expected search Result title is not same");
        AutomationLog.info("Search Result page title is same as search term ");
        Page.driver.navigate().back();
    }

    public void searchByListingtype() throws Exception
    {
        list.addAll(advancedsearch.listingType());
        for(int i=1;i<(list.size());i++)
        {
            advancedsearch.selectListingType(list.get(i));
            propsearch = advancedsearch.clickOnSearchButton();
            String curHandle = Page.driver.getWindowHandle();
            listingdetail = propsearch.clickSearchResult();
            Set<String> handleset = Page.driver.getWindowHandles();
            for(String handle : handleset)
            {
                 if(!handle.equals(curHandle))
                 {
                     Page.driver.switchTo().window(handle);
                     break;
                 }
            }
            String expected  = "Retail for " + list.get(i).replace("-","");
            String actual = listingdetail.getTitleOfListingTypeSearched();
            list.clear();
            Assert.assertEquals(actual, expected,"Expected title is not shown");
            AutomationLog.info("Search is Successfull");
            Page.driver.close();
            Page.driver.switchTo().window(curHandle);
            Page.driver.navigate().back();
        }
        
    }

    public void searchBySize(HashMap<String, String> searchData) throws Exception
    {
        advancedsearch.txtbx_SizeInput().clear();
        advancedsearch.txtbx_SizeInput().sendKeys(searchData.get("size"));
        String expectedSize = searchData.get("size")+"sqft";
        propsearch = advancedsearch.clickOnSearchButton();
        String actualSize = propsearch.FilterText_Size().getText().replaceAll("[,\\s]", "");
        Assert.assertEquals(actualSize, expectedSize, "Expected search size is not shown");
        AutomationLog.info("Search by Filter size is Successfull ");
        Page.driver.navigate().back();
    }

    public void searchByPrice(HashMap<String, String> searchData) throws Exception
    {
        list.addAll(advancedsearch.priceType());
        advancedsearch.txtbx_Price().clear();
        advancedsearch.txtbx_Price().sendKeys(searchData.get("price"));
        advancedsearch.selectPriceType(list.get(0));
        String expectedSize = searchData.get("price")+"/mo";
        propsearch = advancedsearch.clickOnSearchButton();
        String actualSize = propsearch.FilterText_Price().getText().replaceAll("[$,\\s]", "");
        Assert.assertEquals(actualSize, expectedSize, "Expected search size is not shown");
        AutomationLog.info("Search by Filter price is Successfull ");
        Page.driver.navigate().back();
    }

    public void searchResidential(HashMap<String, String> searchData) throws Exception
    {
        advancedsearch.selectBorough(searchData.get("borough"));
        advancedsearch.clickOnResidentialRadioButton();
        advancedsearch.txtbx_SearchInput().clear();
        advancedsearch.txtbx_SearchInput().sendKeys(searchData.get("searchTerm"));
        advancedsearch.txtbx_Price().clear();
        advancedsearch.txtbx_SizeInput().clear();
        propsearch = advancedsearch.clickOnSearchButton();
        String titleText = searchData.get("searchText") + searchData.get("searchTerm");
        WaitFor.sleepFor(2000);
        Assert.assertEquals(propsearch.title_SearchResult().getText(), titleText, "Expected search Result title is not same");
        AutomationLog.info("Search Result page title is same as search term ");

    }

    @Override
    protected String successMessage() 
    {
    	return "test cases for AdvanceSearch page passed" ;
    }

    @Override
    protected String failureMessage() 
    {
    	return "test cases for AdvanceSearch page failed";
    }
    
}
