package com.agorafy.automation.testcases.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;
import com.agorafy.automation.pageobjects.footer.company.Team;
/**
 * Test Team link on Footer
 * Click Team link on the Home Page, verify Team Page is loaded 
 * Verify the URL of Team Page
 * Verify the title of Team Page
 * Verify the Heading Text on Team Page
 */
public class FooterTeamAction extends AutomationTestCaseVerification
{
    public FooterTeamAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases()
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        Team team = null;
        HashMap<String, String> teamMap = testCaseData.get("Team");
        try
        {
            team = companyLinks.clickOnTeamLink();
            AutomationLog.info("Team Page opened successfully");

            Assert.assertEquals(team.currentURL(), team.teamPageUrl(), "Team Link did not Navigate to correct pageUrl");
            AutomationLog.info("Team Link navigates to Team URL");

            Assert.assertEquals(team.currentPageTitle(), teamMap.get("title").trim(), "Team page does not show correct PageTitle");
            AutomationLog.info("Team page shows correct page title");

            Assert.assertEquals(team.headingText(), teamMap.get("pageheading").trim(),"Team page does not show correct page Heading");
            AutomationLog.info("Team page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either Team page did not open successfully or Team page verification failed" + e.getMessage());
        }
    }

    @Override
    protected String successMessage()
    {
        return " Footer Team tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Footer Team Action Failed ";
    }
}