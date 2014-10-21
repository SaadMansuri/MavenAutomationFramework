package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.ContentPagesVerification;

/**
 * Test whether 'About Us' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 *
 */

public class SubnavigationAboutUsAction extends ContentPagesVerification
{
    public SubnavigationAboutUsAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        AboutUs aboutUs = subnavigation.clickLinkAboutUs();

        HashMap<String, String> expectedAboutUsData = testCaseData.get("AboutUs");
        expectedAboutUsData.put("url", aboutUs.aboutUsPageUrl());
        verifyLink(aboutUs, expectedAboutUsData);

        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.aboutUsLinkText(),"Left menu does not show About Us link as Active Link");
        AutomationLog.info("Left menu shows About Us link as Active Link");

        AutomationLog.info("AboutUs page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "About Us link in Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for About Us link in Subnavigation Failed";
    }
}
