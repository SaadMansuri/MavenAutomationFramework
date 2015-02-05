package com.agorafy.automation.testcases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.SearchProfessionalsPage;

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
    
    SearchProfessionalsPage searchprofessional = new SearchProfessionalsPage();
    
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
            searchprofessional.clickOnSearchProfessionalsLink();
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to Search Professionals Page");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        HashMap<String, String> agentName = testCaseData.get("agentName");
        isExclusivesCountPresentOnAgentListing(searchprofessional,agentName);
        
        HashMap<String, String> companyName = testCaseData.get("companySearch");
        isExclusivesCountPresentOnCompanyListing(searchprofessional, companyName);
        
        HashMap<String, String> agentCompanySearch = testCaseData.get("agentCompanySearch");
        verifyIFSearchResultMessageIsShown(searchprofessional,agentCompanySearch);
        
        HashMap<String, String> neighborName = testCaseData.get("Neighborhoods");
        verifyNeighborHoodDropBoxDoNotAddMoreThen5Neighbor(searchprofessional,neighborName);
        
        userSwitchBackFromSearchingExpertiseToAgentAndCompanySearch(searchprofessional,agentName);
        
        HashMap<String, String> search = testCaseData.get("agentName");
        verifyIfSearchByExpertiseClearsAgentCompanySearchText(searchprofessional,search);
        
        HashMap<String, String> neighbor = testCaseData.get("Neighborhoods");
        verifyIfClickingOnClearButtonClearsFieldsOnExpertiseSearchPanel(searchprofessional,neighbor);
        
        HashMap<String, String> propertyType = testCaseData.get("propertyType");
        verifyDetailsEnteredShouldNotPersist(searchprofessional,propertyType);
        
        verifyNeighborhoodsEnteredShouldNotPersist(searchprofessional,neighborName,propertyType);
        
        verifyAfterSearchIsPerformedThereShouldBeFiveNeighborhoodsAfterDeletingOneAndAddingOneAgain(searchprofessional, neighborName, propertyType);
    }
    
    public void isExclusivesCountPresentOnAgentListing(SearchProfessionalsPage searchprofessional,HashMap<String, String> agentName) throws Exception
    {
        searchprofessional.enterAgentOrCompanyNameinAgentSearchAndClickonSearchButton(agentName.get("name"));
        AutomationLog.info("Agent Search is successful and its Exclusive Count = "+searchprofessional.getTheCountOFExclusives(agentName.get("name")));
    }
    
    public void isExclusivesCountPresentOnCompanyListing(SearchProfessionalsPage searchprofessional,HashMap<String, String> companyName) throws Exception
    {
        searchprofessional.txtbx_agentSearch().clear();
        searchprofessional.enterAgentOrCompanyNameinAgentSearchAndClickonSearchButton(companyName.get("name"));
        searchprofessional.clickOnCompaniesTabOnSearchProfessionals();
        AutomationLog.info("Company Search is successful and its Exclusive Count = "+searchprofessional.getTheCountOFCompanyExclusive(companyName.get("name")));
    }

    public void verifyIFSearchResultMessageIsShown(SearchProfessionalsPage searchprofessional,HashMap<String, String> agentCompanySearch) throws Exception
    {
        WebElement element=null;
        searchprofessional.txtbx_agentSearch().clear();
        searchprofessional.enterAgentOrCompanyNameinAgentSearchAndClickonSearchButton(agentCompanySearch.get("text"));
        element=searchprofessional.searchAgentResultMessage();
        Assert.assertEquals(element.getText(),"No agents found", "Expected Search result message not found");
        searchprofessional.clickOnCompaniesTabOnSearchProfessionals();
        element=searchprofessional.searchCompaniesResultMessage();
        Assert.assertEquals(element.getText(),"No companies found", "Expected Search result message not found");
        AutomationLog.info("Appropriate message is shown on entering a random search text");
    }
    
     public void putDataInNeighborHoodDropBox(HashMap<String, String> neighborName) throws Exception
     {
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        //searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing(neighborName.get("neighbor1"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        //searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing(neighborName.get("neighbor2"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        //searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing(neighborName.get("neighbor3"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        //searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing(neighborName.get("neighbor4"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        //searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing(neighborName.get("neighbor5"));
     }
        
    public void verifyNeighborHoodDropBoxDoNotAddMoreThen5Neighbor(SearchProfessionalsPage searchprofessional, HashMap<String, String> neighborName) throws Exception
    {
        putDataInNeighborHoodDropBox(neighborName);
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        //Assert.assertEquals(searchprofessional.checkingNeighborhoodsDropBoxVisibility(),false ,"Neighborhoods DropBox must not be visible");
        Assert.assertEquals(searchprofessional.msg_NeighborhoodsSelectionLimit().getText(), neighborName.get("neighborsLimitMsg"), "Expected message is not shown");
        //AutomationLog.info("5 Neighborhood is added successful and user is successfully not able to add further Neighbors as Droxbox is not longer visible after adding 5 Neighbors");
        AutomationLog.info("Not able to add more than 5 Neighborhoods");
    }
    
    public void clickingCheckboxOFExpertiseAndConcentration() throws Exception
    {
        searchprofessional.clickOncheckboxOfOfficeLeasingInExpertise();
        searchprofessional.clickOncheckboxOfRetailLeasingInExpertise();
        searchprofessional.clickOncheckboxOfTenantRepresentationInConcentration();
        searchprofessional.clickOnLandlordRepresentationInConcentration();
    }
    
    public void AssertToVerifyThatCheckboxOFExpertiseAndConcentrationMustBeUncheck() throws Exception
    {
        Assert.assertEquals(searchprofessional.dropBox_NeighborhoodsSearch().getText(),"" ,"Excepted result is the neighborhoods Search DropBox must get empty");
        AutomationLog.info("neighborhoods Search DropBox all text gets removed successfully");
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
    
    public void userSwitchBackFromSearchingExpertiseToAgentAndCompanySearch(SearchProfessionalsPage searchprofessional, HashMap<String, String> agentName) throws Exception
    {
        clickingCheckboxOFExpertiseAndConcentration();
        Page.driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        searchprofessional.sendDataToAgentSearchTextBox(agentName.get("name"));
        AssertToVerifyThatCheckboxOFExpertiseAndConcentrationMustBeUncheck();
        AutomationLog.info("Switching from Expertise search to Agent/Company Search unmarks checkbox in Expertise search");
    }

    public void verifyIfSearchByExpertiseClearsAgentCompanySearchText(SearchProfessionalsPage searchprofessional,HashMap<String, String> search) throws Exception
    {
        WebElement element=null;
        searchprofessional.enterSearchcontentInAgentCompanySearchTextBox(search.get("name"));
        searchprofessional.clickOncheckboxOfOfficeLeasingInExpertise();
        element=searchprofessional.txtbx_agentSearch();
        Assert.assertEquals(element.getText(), "", "Expected Agent search textbox is not cleard ");
        AutomationLog.info("Switching from agent /company search to expertise search clears agent/company search text ");
    }

    public void verifyIfClickingOnClearButtonClearsFieldsOnExpertiseSearchPanel(SearchProfessionalsPage searchProfessional, HashMap<String, String> neighbor) throws Exception
    {
       searchprofessional.markCheckboxesInExpertiseAndConcentration();
       putDataInNeighborHoodDropBox(neighbor);
       searchProfessional.clickOnClearButtonOnExpertiesSearchPanel();
       Assert.assertEquals(searchProfessional.isCheckboxSelected(), false, "Expected checkboxes are not cleared");
       Assert.assertEquals(searchProfessional.checkingNeighborhoodsDropBoxVisibility(), false, "Expected empty dropbox is not empty");
       AutomationLog.info("Clicking clear button clears checkboxes and boroughs");
    }
    
    public void verifyDetailsEnteredShouldNotPersist(SearchProfessionalsPage searchProfessional, HashMap<String, String> propertyType) throws Exception
    {
        clickingCheckboxOFExpertiseAndConcentration();
        searchprofessional.clickOnSelectOptions(propertyType.get("res"));
        searchprofessional.clickOnSelectOptions(propertyType.get("com"));
        AssertToVerifyThatCheckboxOFExpertiseAndConcentrationMustBeUncheck();
    }
    
    public void verifyNeighborhoodsEnteredShouldNotPersist(SearchProfessionalsPage searchProfessional, HashMap<String, String> neighborName, HashMap<String, String> propertyType) throws Exception
    {
        putDataInNeighborHoodDropBox(neighborName);
        searchprofessional.clickOnSelectOptions(propertyType.get("res"));
        searchprofessional.clickOnSelectOptions(propertyType.get("com"));
        AssertToVerifyThatCheckboxOFExpertiseAndConcentrationMustBeUncheck();
    }
    
    public void verifyAfterSearchIsPerformedThereShouldBeFiveNeighborhoodsAfterDeletingOneAndAddingOneAgain(SearchProfessionalsPage searchProfessional, HashMap<String, String> neighborName, HashMap<String, String> propertyType) throws Exception
    {
        putDataInNeighborHoodDropBox(neighborName);
        Assert.assertEquals(searchprofessional.gettingNeighborhoodsSearchSelectedData(), searchprofessional.convertingDataFromListToStringArray(neighborName.get("neighbor1"),neighborName.get("neighbor2"),neighborName.get("neighbor3"),neighborName.get("neighbor4"),neighborName.get("neighbor5")), "Expected neighbours details is not found/match");
        searchprofessional.clickOnNeighborhoodsSearchSelectedDataCloseSign();
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.ActionToProvideFocusOnDropBox();
        Page.driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        searchprofessional.clickOnneighborhoodsOptionListing(neighborName.get("neighbor6"));
        searchprofessional.clickOnbrokerNeighborSearchButton();
        Page.driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        Assert.assertEquals(searchprofessional.gettingNeighborhoodsSearchSelectedData(), searchprofessional.convertingDataFromListToStringArray(neighborName.get("neighbor2"),neighborName.get("neighbor3"),neighborName.get("neighbor5"),neighborName.get("neighbor4"),neighborName.get("neighbor6")), "Expected neighbours details is not found/match");
    }

    @Override
    protected String successMessage() {
        return "Test cases passed for Search Professionals";
    }

    @Override
    protected String failureMessage() {
        return "Test cases failed for Search Professionals";
    }

}
