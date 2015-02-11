package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.company.Team;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;
/**
 * Test whether 'More->Team' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */
public class SubnavigationTeamAction extends ContentPagesVerification 
{
    HashMap<String, String> expectedTeamData;
    SubNavigation subnavigation;
    Team team;
	private ContentPagesLeftMenu leftMenu;
	private String actualActiveLeftMenu;
	private String expectedActiveLeftMenu;

    @Override
    protected void verifyTestCases() throws Exception 
    {
        subnavigation = Page.subNavigation();
        String dropdownMoreOption = "Team";
        team = (Team) subnavigation.selectDropdownMoreOption(dropdownMoreOption);
        expectedTeamData = testCaseData.get("More->TeamPageData");
        expectedTeamData.put("url", team.teamPageUrl());
        verifyLink(team, expectedTeamData);

        AutomationLog.info("Testing whether Team link is active in left side started...");
        verifyLeftMenu();
    }

    private void verifyLeftMenu() throws Exception 
    {
        leftMenu = Page.contentPagesLeftMenu();
        actualActiveLeftMenu = leftMenu.getCurrentlyActiveLink();
        expectedActiveLeftMenu = leftMenu.TeamLinkText();  
        Assert.assertEquals(actualActiveLeftMenu, expectedActiveLeftMenu,"Left menu does not show My Team link as Active Link");
        AutomationLog.info("Left menu shows My Team link as Active Link");
    }

    @Override
    protected String successMessage() 
    {
        return "Team option in more dropdown in subnavigation tested sucessfully";
    }

    @Override
    protected String failureMessage() 
    {
        return "Team option in more dropdown in subnavigation testing failed";
    }
}
