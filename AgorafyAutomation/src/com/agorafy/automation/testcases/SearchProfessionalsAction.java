package com.agorafy.automation.testcases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.SearchProfessionalsPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

/**
 * Precondition:Navigate to Search Professionals Page 
 * Verify if Random Search is performed shows proper Result Message
 * verify if Search By Expertise Clears Agent/Company Search Text
 * verify that agents returned the 'exclusive' count of listings they hold
 * verify that companies in search result have 'exclusive' count of listings against their names
 * verify that user searches by expertise or neighborhood and switches back to search by agent/company name then Neighborhoods selected (if any) or the checkboxes is getting clear
 * verify that Maximum 5 neighborhoods should be allowed from the dropdown for Neighborhoods
 * verify if auto complete menu comes after typing text on neighborhood street address zipcode search area
 * verify that if User enters neighborhoods under Commercial brokerage tab and toggles to Residential brokerage, togles back to commercial then checkbox of expertise and concentration must be uncheck
 * verify that if user add five neighborhoods and then deleting one and adding one another and click on search then only same five latest neighborhoods is shown.
 */
public class SearchProfessionalsAction extends AutomationTestCaseVerification 
{
    private SubNavigation subnavigation = null;
    private SearchProfessionalsPage searchprofessional = null;
    
    public SearchProfessionalsAction()
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
            searchprofessional = subnavigation.clickLinkSearchProfessionals();
            WaitFor.sleepFor(10000);
            AutomationLog.info("Redirected to Search Professionals page  ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to Search Professionals Page");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        HashMap<String, String> agentCompanySearch = testCaseData.get("agentCompanySearch");
        verifyIfRandomAgentCompanySearchShowsAppropriateMessage(searchprofessional,agentCompanySearch);

        HashMap<String, String> agentName = testCaseData.get("agentName");
        verifyIfAgentSearchShowsExcusiveListingsCount(searchprofessional,agentName);

        HashMap<String, String> companyName = testCaseData.get("companySearch");
        verifyIfCompanySearchShowsExclusivesListingCount(searchprofessional, companyName);

        HashMap<String, String> search = testCaseData.get("agentName");
        verifyIfSearchByExpertiseClearsAgentCompanySearchText(searchprofessional,search);

        HashMap<String, String> neighborName = testCaseData.get("Neighborhoods");
        verifyIfNeighborHoodDropBoxDoNotAddMoreThan5Neighborhoods(searchprofessional,neighborName);

        verifyIfuserSwitchBackFromSearchingExpertiseToAgentAndCompanySearch(searchprofessional,agentName);

        HashMap<String, String> neighbor = testCaseData.get("Neighborhoods");
        verifyIfClickingOnClearButtonClearsFieldsOnExpertiseSearchPanel(searchprofessional,neighbor);

        HashMap<String, String> propertyType = testCaseData.get("propertyType");
        verifyDetailsEnteredShouldNotPersist(searchprofessional,propertyType);

        verifyNeighborhoodsEnteredShouldNotPersist(searchprofessional,neighborName,propertyType);

        verifyIfNeighborhoodCanBeAddedAfterRemovefromNeighborhoodsDropbox(searchprofessional, neighborName);
    }

    public void verifyIfAgentSearchShowsExcusiveListingsCount(SearchProfessionalsPage searchprofessional,HashMap<String, String> agentName) throws Exception
    {
        String name = agentName.get("name");
        searchprofessional.searchByAgentOrCompanyName(name);
        WaitFor.sleepFor(1000);
        Assert.assertEquals(searchprofessional.isAgentExclusivesCountPresent(name), true, "Expected Exclusives count is not present");
        AutomationLog.info("Agent Search is successful and its Exclusive Count = "+searchprofessional.agentExclusivesCount(name).getText());
    }

    public void verifyIfCompanySearchShowsExclusivesListingCount(SearchProfessionalsPage searchprofessional,HashMap<String, String> companyName) throws Exception
    {
        String name = companyName.get("name");
        searchprofessional.txtbx_AgentCompanySearch().clear();
        searchprofessional.searchByAgentOrCompanyName(name);
        searchprofessional.clickOnCompaniesTabOnSearchProfessionals();
        WaitFor.sleepFor(1000);
        Assert.assertEquals(searchprofessional.isCompanyExclusivesCountPresent(name), true, "Expected Company Exclusives Count is not present");
        AutomationLog.info("Company Search is successful and its Exclusive Count = "+searchprofessional.companyExclusiveCount(name).getText());
    }

    public void verifyIfRandomAgentCompanySearchShowsAppropriateMessage(SearchProfessionalsPage searchprofessional,HashMap<String, String> agentCompanySearch) throws Exception
    {
        WebElement element=null;
        WaitFor.sleepFor(1000);
        searchprofessional.txtbx_AgentCompanySearch().clear();
        searchprofessional.searchByAgentOrCompanyName(agentCompanySearch.get("text"));
        element = searchprofessional.searchAgentResultMessage();
        Assert.assertEquals(element.getText(),"No agents found", "Expected Search result message not found");
        searchprofessional.clickOnCompaniesTabOnSearchProfessionals();
        element=searchprofessional.searchCompaniesResultMessage();
        Assert.assertEquals(element.getText(),"No companies found", "Expected Search result message not found");
        AutomationLog.info("Appropriate message is shown on entering a random search text");
    }

     public void addNeighborhoods(HashMap<String, String> neighborName) throws Exception
     {
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.clickOnNeighborhoodsOptionListing(neighborName.get("neighbor1"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.clickOnNeighborhoodsOptionListing(neighborName.get("neighbor2"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.clickOnNeighborhoodsOptionListing(neighborName.get("neighbor3"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.clickOnNeighborhoodsOptionListing(neighborName.get("neighbor4"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.clickOnNeighborhoodsOptionListing(neighborName.get("neighbor5"));
        AutomationLog.info("Successfully added Neighborhoods");
     }

    public void verifyIfNeighborHoodDropBoxDoNotAddMoreThan5Neighborhoods(SearchProfessionalsPage searchprofessional, HashMap<String, String> neighborName) throws Exception
    {
        addNeighborhoods(neighborName);
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        Assert.assertEquals(searchprofessional.msg_NeighborhoodsSelectionLimit().getText(), neighborName.get("neighborsLimitMsg"), "Expected message is not shown");
        AutomationLog.info("Not able to add more than 5 Neighborhoods");
    }

    public void clickCheckboxesUnderExpertiseAndConcentration() throws Exception
    {
        searchprofessional.clickOncheckboxOfOfficeLeasingInExpertise();
        searchprofessional.clickOncheckboxOfRetailLeasingInExpertise();
        searchprofessional.clickOncheckboxOfTenantRepresentationInConcentration();
        searchprofessional.clickOnLandlordRepresentationInConcentration();
    }

    public void verifyIfCheckboxesUnderExpertiseNConcentrationAreCleared() throws Exception
    {
        Assert.assertEquals(searchprofessional.checkbox_OfficeLeasingInExpertise().isSelected(),false ,"Excepted result is false and checkbox must not be clicked");
        AutomationLog.info("successfully verified that checkbox Of Office Leasing In Expertise is uncheck");
        Assert.assertEquals(searchprofessional.checkbox_RetailLeasingInExpertise().isSelected(),false ,"Excepted result is false and checkbox must not be clicked");
        AutomationLog.info("successfully verified that checkbox Of Retail Leasing In Expertise is uncheck");
        Assert.assertEquals(searchprofessional.checkbox_TenantRepresentationInConcentration().isSelected(),false ,"Excepted result is false and checkbox must not be clicked");
        AutomationLog.info("successfully verified that checkbox Of Tenant Representation In Concentration is uncheck");
        Assert.assertEquals(searchprofessional.checkbox_LandlordRepresentationInConcentration().isSelected(),false ,"Excepted result is false and checkbox must not be clicked");
        AutomationLog.info("successfully verified that checkbox Of Landlord Representation In Concentration is uncheck");
        AutomationLog.info("All Checkbox is successfully uncheck and text on neighborhoods Search DropBox is also removed");
    }

    public void verifyIfNeighborhoodsDropboxIsCleared() throws Exception
    {
        Assert.assertEquals(searchprofessional.getNeighborhoodsDropboxCount(), 1, "Toggling search doesnot clear Neighborhoods dropbox");
        AutomationLog.info("neighborhoods Search DropBox all text gets removed successfully");
    }

    public void verifyIfuserSwitchBackFromSearchingExpertiseToAgentAndCompanySearch(SearchProfessionalsPage searchprofessional, HashMap<String, String> agentName) throws Exception
    {
        clickCheckboxesUnderExpertiseAndConcentration();
        Page.driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        searchprofessional.enterSearchTextInAgentCompanySearchTextBox(agentName.get("name"));
        verifyIfCheckboxesUnderExpertiseNConcentrationAreCleared();
        verifyIfNeighborhoodsDropboxIsCleared();
        AutomationLog.info("Switching from Expertise search to Agent/Company Search unmarks checkbox in Expertise search");
    }

    public void verifyIfSearchByExpertiseClearsAgentCompanySearchText(SearchProfessionalsPage searchprofessional,HashMap<String, String> search) throws Exception
    {
        WebElement element=null;
        searchprofessional.enterSearchTextInAgentCompanySearchTextBox(search.get("name"));
        searchprofessional.clickOncheckboxOfOfficeLeasingInExpertise();
        element = searchprofessional.txtbx_AgentCompanySearch();
        Assert.assertEquals(element.getText(), "", "Expected Agent search textbox is not cleard ");
        AutomationLog.info("Switching from agent /company search to expertise search clears agent/company search text ");
    }

    public void verifyIfClickingOnClearButtonClearsFieldsOnExpertiseSearchPanel(SearchProfessionalsPage searchProfessional, HashMap<String, String> neighbor) throws Exception
    {
       searchProfessional.clearNeighorhoods();
       searchprofessional.markCheckboxesInExpertiseAndConcentration();
       addNeighborhoods(neighbor);
       searchProfessional.clickOnClearButtonOnExpertiesSearchPanel();
       Assert.assertEquals(searchProfessional.isCheckboxSelected(), false, "Expected checkboxes are not cleared");
       AutomationLog.info("Clicking clear button clears checkboxes and boroughs");
    }
    
    public void verifyDetailsEnteredShouldNotPersist(SearchProfessionalsPage searchProfessional, HashMap<String, String> propertyType) throws Exception
    {
        clickCheckboxesUnderExpertiseAndConcentration();
        searchprofessional.clickOnSelectOptions(propertyType.get("res"));
        searchprofessional.clickOnSelectOptions(propertyType.get("com"));
        verifyIfCheckboxesUnderExpertiseNConcentrationAreCleared();
    }
    
    public void verifyNeighborhoodsEnteredShouldNotPersist(SearchProfessionalsPage searchProfessional, HashMap<String, String> neighborName, HashMap<String, String> propertyType) throws Exception
    {
        addNeighborhoods(neighborName);
        searchprofessional.clickOnSelectOptions(propertyType.get("res"));
        searchprofessional.clickOnSelectOptions(propertyType.get("com"));
        verifyIfNeighborhoodsDropboxIsCleared();
    }
    
    public void verifyIfNeighborhoodCanBeAddedAfterRemovefromNeighborhoodsDropbox(SearchProfessionalsPage searchProfessional, HashMap<String, String> neighborName) throws Exception
    {
        addNeighborhoods(neighborName);
        int beforeCount = searchProfessional.getNeighborhoodsDropboxCount();
        searchprofessional.clickOnNeighborhoodsSearchChoiceCloseIcon();
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        Page.driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        searchprofessional.clickOnNeighborhoodsOptionListing(neighborName.get("neighbor6"));
        List<String> neighbors = new ArrayList<String>();
        List<WebElement > elements = searchProfessional.addedNeighborhoods();
        for(WebElement ele : elements)
        {
            neighbors.add(ele.getText());
        }
        Assert.assertEquals(neighbors.contains(neighborName.get("neighbor6")), true, "Excpected neighborhood is not added");
        int afterCount = searchProfessional.getNeighborhoodsDropboxCount();
        Page.driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        Assert.assertEquals(beforeCount, afterCount, "Expected Neghiborhood is not added after removing ");
        AutomationLog.info("Successfully added one neighborhood after removing one from Neighborhoods dropbox");
    }

    @Override
    protected String successMessage() 
    {
        return "Test cases passed for Search Professionals";
    }

    @Override
    protected String failureMessage() 
    {
        return "Test cases failed for Search Professionals";
    }

}
