package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Careers;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test whether 'Careers' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationCareersAction extends ContentPagesVerification
{
    private ContentPagesLeftMenu leftMenu;
	private String actualActiveLeftMenu;
	private String expectedActiveLeftMenu;

	public SubnavigationCareersAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
    	SubNavigation subnavigation = Page.subNavigation();
        Careers careerPage = (Careers) subnavigation.selectDropdownMoreOption("Careers");

        HashMap<String, String> expectedCareersData = testCaseData.get("More->CareersPageData");
        expectedCareersData.put("url", careerPage.careersPageUrl());
        verifyLink(careerPage, expectedCareersData);

        AutomationLog.info("Careers page is correctly loaded");

        AutomationLog.info("Testing whether Carrers link is active in left side started...");
        verifyLeftMenu();
    }

    private void verifyLeftMenu() throws Exception 
    {
        leftMenu = Page.contentPagesLeftMenu();
        actualActiveLeftMenu = leftMenu.getCurrentlyActiveLink();
        expectedActiveLeftMenu = leftMenu.CareersLinkText();  
        Assert.assertEquals(actualActiveLeftMenu, expectedActiveLeftMenu,"Left menu does not show Carrers link as Active Link");
        AutomationLog.info("Left menu shows Carrers link as Active Link");
    }

    @Override
    protected String successMessage()
    {
        return "Careers link in Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for Careers link in Subnavigation Failed";
    }
}
