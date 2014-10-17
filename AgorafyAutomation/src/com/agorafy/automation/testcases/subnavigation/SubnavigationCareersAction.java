package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Careers;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.ContentPagesVerification;

/**
 * Test whether 'Careers' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationCareersAction extends ContentPagesVerification
{
    public SubnavigationCareersAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        Careers careerPage = subnavigation.clickLinkCareers();

        HashMap<String, String> expectedCareersData = testCaseData.get("Careers");
        expectedCareersData.put("url", careerPage.careersPageUrl());
        verifyLink(careerPage, expectedCareersData);

        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.careersLinkText(),"Left menu does not show Careers link as Active Link");
        AutomationLog.info("Left menu shows Careers link as Active Link");

        AutomationLog.info("Careers page is correctly loaded");
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
