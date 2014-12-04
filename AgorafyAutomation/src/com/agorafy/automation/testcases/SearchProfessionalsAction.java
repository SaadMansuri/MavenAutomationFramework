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
        /*HashMap<String, String> agentName = testCaseData.get("agentName");
        isExclusivesCountPresentOnAgentListing(searchprofessional,agentName);
        
        HashMap<String, String> companyName = testCaseData.get("companySearch");
        isExclusivesCountPresentOnCompanyListing(searchprofessional, companyName);
        
        HashMap<String, String> agentCompanySearch = testCaseData.get("agentCompanySearch");
        verifyIFSearchResultMessageIsShown(searchprofessional,agentCompanySearch);
        
        verifyNeighborHoodDropBoxDoNotAddMoreThen5Neighbor(searchprofessional);*/
        
        userSwitchBackFromSearchingExpertiseToAgentAndCompanySearch(searchprofessional);
    }
    
    public void isExclusivesCountPresentOnAgentListing(SearchProfessionalsPage searchprofessional,HashMap<String, String> agentName) throws Exception
    {
        searchprofessional.enterAgentOrCompanyNameinAgentSearchAndClickonSearchButton(agentName.get("name"));
        AutomationLog.info("Agent Search is successful and its Exclusive Count = "+searchprofessional.getTheCountOFAgentTerryExclusives());
    }
    
    public void isExclusivesCountPresentOnCompanyListing(SearchProfessionalsPage searchprofessional,HashMap<String, String> companyName) throws Exception
    {
        searchprofessional.agentSearchTextBox_element().clear();
        searchprofessional.enterAgentOrCompanyNameinAgentSearchAndClickonSearchButton(companyName.get("name"));
        searchprofessional.clickOnCompaniesTabOnSearchProfessionals();
        AutomationLog.info("Company Search is successful and its Exclusive Count = "+searchprofessional.getTheCountOFCompanyDumannExclusive());
    }

    public void verifyIFSearchResultMessageIsShown(SearchProfessionalsPage searchprofessional,HashMap<String, String> agentCompanySearch) throws Exception
    {
        WebElement element=null;
        searchprofessional.agentSearchTextBox_element().clear();
        searchprofessional.enterAgentOrCompanyNameinAgentSearchAndClickonSearchButton(agentCompanySearch.get("text"));
        element=searchprofessional.searchAgentResultMessage();
        Assert.assertEquals(searchprofessional.getTextForSearch(element),"No agents found", "Expected Search result message not found");
        searchprofessional.clickOnCompaniesTabOnSearchProfessionals();
        element=searchprofessional.searchCompaniesResultMessage();
        Assert.assertEquals(searchprofessional.getTextForSearch(element),"No companies found", "Expected Search result message not found");
    }
    
    public void verifyNeighborHoodDropBoxDoNotAddMoreThen5Neighbor(SearchProfessionalsPage searchprofessional) throws Exception
    {
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing("Financial District");
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing("Battery Park City");
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing("City Hall / Civic Center");
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing("Little Italy");
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing("Chinatown");
        searchprofessional.clickOnNeighborhoodsSearchDropBox();
        Assert.assertEquals(searchprofessional.checkingNeighborhoodsDropBoxVisibility(),false ,"Neighborhoods DropBox must not be visible");
        AutomationLog.info("5 Neighborhood is added successful and user is successfully not able to add further Neighbors as Droxbox is not longer visible after adding 5 Neighbors");
    }
    
    public void userSwitchBackFromSearchingExpertiseToAgentAndCompanySearch(SearchProfessionalsPage searchprofessional) throws Exception
    {
        searchprofessional.neighborhoodsSearchDropBox_element().click();
        searchprofessional.ActionToProvideFocusOnDropBox();
        searchprofessional.clickOnneighborhoodsOptionListing("Financial District");
        searchprofessional.clickingOncheckboxOfOfficeLeasingInExpertise();
        searchprofessional.clickingOncheckboxOfRetailLeasingInExpertise();
        searchprofessional.clickingOncheckboxOfTenantRepresentationInConcentration();
        searchprofessional.clickingOnLandlordRepresentationInConcentration();
        Page.driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        searchprofessional.sendDataToAgentSearchTextBox("mm");
        Assert.assertEquals(searchprofessional.neighborhoodsSearchDropBox_element().getText(),"" ,"Excepted result is the neighborhoods Search DropBox must get empty");
        AutomationLog.info("neighborhoods Search DropBox all text gets removed successfully");
        Assert.assertEquals(searchprofessional.checkboxOfOfficeLeasingInExpertise_element().isSelected(),false ,"Excepted result is false and checkbox must not be clicked");
        Assert.assertEquals(searchprofessional.checkboxOfRetailLeasingInExpertise_element().isSelected(),false ,"Excepted result is false and checkbox must not be clicked");
        Assert.assertEquals(searchprofessional.checkboxOfTenantRepresentationInConcentration_element().isSelected(),false ,"Excepted result is false and checkbox must not be clicked");
        Assert.assertEquals(searchprofessional.checkboxOfLandlordRepresentationInConcentration_element().isSelected(),false ,"Excepted result is false and checkbox must not be clicked");
        AutomationLog.info("All Checkbox is successfully uncheck and text on neighborhoods Search DropBox is also removed");
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
