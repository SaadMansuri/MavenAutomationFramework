package com.agorafy.automation.testcases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.subnavigationmenu.SearchProfessionalsPage;

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
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to Search Professionals Page");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
       /* HashMap<String, String> agentName = testCaseData.get("agentName");
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
        */
        verifyIfClickingOnClearButtonClearsFieldsOnExpertiseSearchPanel(searchprofessional);
    
    }
    
    public void isExclusivesCountPresentOnAgentListing(SearchProfessionalsPage searchprofessional,HashMap<String, String> agentName) throws Exception
    {
        searchprofessional.enterAgentOrCompanyNameinAgentSearchAndClickonSearchButton(agentName.get("name"));
        AutomationLog.info("Agent Search is successful and its Exclusive Count = "+searchprofessional.getTheCountOFAgentTerryExclusives());
    }
    
    public void isExclusivesCountPresentOnCompanyListing(SearchProfessionalsPage searchprofessional,HashMap<String, String> companyName) throws Exception
    {
        searchprofessional.txtbx_agentSearch().clear();
        searchprofessional.enterAgentOrCompanyNameinAgentSearchAndClickonSearchButton(companyName.get("name"));
        searchprofessional.clickOnCompaniesTabOnSearchProfessionals();
        AutomationLog.info("Company Search is successful and its Exclusive Count = "+searchprofessional.getTheCountOFCompanyDumannExclusive());
    }

    public void verifyIFSearchResultMessageIsShown(SearchProfessionalsPage searchprofessional,HashMap<String, String> agentCompanySearch) throws Exception
    {
        WebElement element=null;
        searchprofessional.txtbx_agentSearch().clear();
        searchprofessional.enterAgentOrCompanyNameinAgentSearchAndClickonSearchButton(agentCompanySearch.get("text"));
        element=searchprofessional.searchAgentResultMessage();
        Assert.assertEquals(searchprofessional.getTextForSearch(element),"No agents found", "Expected Search result message not found");
        searchprofessional.clickOnCompaniesTabOnSearchProfessionals();
        element=searchprofessional.searchCompaniesResultMessage();
        Assert.assertEquals(searchprofessional.getTextForSearch(element),"No companies found", "Expected Search result message not found");
    }
    
    public void verifyNeighborHoodDropBoxDoNotAddMoreThen5Neighbor(SearchProfessionalsPage searchprofessional, HashMap<String, String> neighborName) throws Exception
    {
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing(neighborName.get("neighbor1"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing(neighborName.get("neighbor2"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing(neighborName.get("neighbor3"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing(neighborName.get("neighbor4"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing(neighborName.get("neighbor5"));
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        Assert.assertEquals(searchprofessional.checkingNeighborhoodsDropBoxVisibility(),false ,"Neighborhoods DropBox must not be visible");
        AutomationLog.info("5 Neighborhood is added successful and user is successfully not able to add further Neighbors as Droxbox is not longer visible after adding 5 Neighbors");
    }
    
    public void userSwitchBackFromSearchingExpertiseToAgentAndCompanySearch(SearchProfessionalsPage searchprofessional, HashMap<String, String> agentName) throws Exception
    {
        searchprofessional.clickingOncheckboxOfOfficeLeasingInExpertise();
        searchprofessional.clickingOncheckboxOfRetailLeasingInExpertise();
        searchprofessional.clickingOncheckboxOfTenantRepresentationInConcentration();
        searchprofessional.clickingOnLandlordRepresentationInConcentration();
        Page.driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        searchprofessional.sendDataToAgentSearchTextBox(agentName.get("name"));
        Assert.assertEquals(searchprofessional.dropBox_NeighborhoodsSearch().getText(),"" ,"Excepted result is the neighborhoods Search DropBox must get empty");
        AutomationLog.info("neighborhoods Search DropBox all text gets removed successfully");
        Assert.assertEquals(searchprofessional.checkbox_OfOfficeLeasingInExpertise().isSelected(),false ,"Excepted result is false and checkbox must not be clicked");
        AutomationLog.info("successfully verified that checkbox Of Office Leasing In Expertise is uncheck");
        Assert.assertEquals(searchprofessional.checkbox_OfRetailLeasingInExpertise().isSelected(),false ,"Excepted result is false and checkbox must not be clicked");
        AutomationLog.info("successfully verified that checkbox Of Retail Leasing In Expertise is uncheck");
        Assert.assertEquals(searchprofessional.checkbox_OfTenantRepresentationInConcentration().isSelected(),false ,"Excepted result is false and checkbox must not be clicked");
        AutomationLog.info("successfully verified that checkbox Of Tenant Representation In Concentration is uncheck");
        Assert.assertEquals(searchprofessional.checkbox_OfLandlordRepresentationInConcentration().isSelected(),false ,"Excepted result is false and checkbox must not be clicked");
        AutomationLog.info("successfully verified that checkbox Of Landlord Representation In Concentration is uncheck");
        AutomationLog.info("All Checkbox is successfully uncheck and text on neighborhoods Search DropBox is also removed");
    }

    public void verifyIfSearchByExpertiseClearsAgentCompanySearchText(SearchProfessionalsPage searchprofessional,HashMap<String, String> search) throws Exception
    {
        WebElement element=null;
        searchprofessional.enterSearchcontentInAgentCompanySearchTextBox(search.get("name"));
        searchprofessional.clickingOncheckboxOfOfficeLeasingInExpertise();
        element=searchprofessional.txtbx_agentSearch();
        Assert.assertEquals(element.getText(), "", "Expected Agent search textbox is not cleard ");
    }

    public void verifyIfClickingOnClearButtonClearsFieldsOnExpertiseSearchPanel(SearchProfessionalsPage searchProfessional) throws Exception
    {
       searchprofessional.markCheckboxesInExpertiseAndConcentration();
       HashMap<String, String> neighbor = testCaseData.get("Neighborhoods");
       searchprofessional.enterNeighborhoodsForNeighborhoods(neighbor.get("neighbor1"), neighbor.get("neighbor2"),neighbor.get("neighbor3"),neighbor.get("neighbor4"),neighbor.get("neighbor5"));
       searchProfessional.clickOnClearButtonOnExpertiesSearchPanel();
       Assert.assertEquals(searchProfessional.isCheckboxSelected(), false, "Expected checkboxes are not cleared");
       Assert.assertEquals(searchProfessional.checkingNeighborhoodsDropBoxVisibility(), false, "Expected empty dropbox is not empty");
       AutomationLog.info("Clicking clear button clears checkboxes and boroughs");
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
