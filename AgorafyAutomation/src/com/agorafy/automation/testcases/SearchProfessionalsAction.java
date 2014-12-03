package com.agorafy.automation.testcases;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.subnavigationmenu.SearchProfessionalsPage;

public class SearchProfessionalsAction extends AutomationTestCaseVerification {
    
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
    protected void verifyTestCases() throws Exception {
        
        HashMap<String, String> agentName = testCaseData.get("agentName");
        isExclusivesCountPresentOnAgentListing(searchprofessional,agentName);
        
        HashMap<String, String> companyName = testCaseData.get("companySearch");
        isExclusivesCountPresentOnCompanyListing(searchprofessional, companyName);
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

    @Override
    protected String successMessage() {
        return "Test cases passed for Search Professionals";
    }

    @Override
    protected String failureMessage() {
        return "Test cases failed for Search Professionals";
    }

}
