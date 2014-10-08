package com.agorafy.automation.testcases.footer;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;
import com.agorafy.automation.pageobjects.footer.company.Team;

public class FooterTeamAction extends FooterAction
{
    public FooterTeamAction()
    {
        super();
    }

    @Override
    protected void testLink()
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        Team team = null;
        try
        {
            team = companyLinks.openTeam();
            AutomationLog.info("Team Page opened successfully");

            Assert.assertEquals(team.currentURL(), team.teamPageUrl(), "Team Link did not Navigate to correct pageUrl");
            AutomationLog.info("Team Link navigates to Team URL");

            Assert.assertEquals(team.currentPageTitle(), "AGORAFY - Team", "Team page does not show correct PageTitle");
            AutomationLog.info("Team page shows correct page title");

            Assert.assertEquals(team.headingText(), "Team","Team page does not show correct page Heading");
            AutomationLog.info("Team page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either Team page did not open successfully or Team page verification failed" + e.getMessage());
        }
    }

    @Override
    String successMessage()
    {
        return " Footer Team tested successfully";
    }

    @Override
    String failureMessage()
    {
        return "Footer Team Action Failed ";
    }
}