package com.agorafy.automation.testcases.contentpages.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;
import com.agorafy.automation.pageobjects.footer.company.Team;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test Team link on Footer
 * Click Team link on the Home Page, verify Team Page is loaded 
 * Verify the URL of Team Page
 * Verify the title of Team Page
 * Verify the Heading Text on Team Page
 */
public class FooterTeamAction extends ContentPagesVerification
{
    public FooterTeamAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        Team team = companyLinks.clickOnTeamLink();;

        HashMap<String, String> expectedTeamData = testCaseData.get("Team");
        expectedTeamData.put("url", team.teamPageUrl());
        verifyLink(team, expectedTeamData);

        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.teamLinkText(), "Left menu does not show Team link as Active Link");
        AutomationLog.info("Left menu shows Team link as Active Link");

        AutomationLog.info("Team page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "Team link on Footer tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Team link Test Failed ";
    }
}