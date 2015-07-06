package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

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
    private AboutUs aboutUs;
    private HashMap<String, String> expectedAboutUsData = new HashMap<>();
	private SubNavigation subnavigation;
	private ContentPagesLeftMenu leftMenu;

	public SubnavigationAboutUsAction()
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();
        try 
        {
            subnavigation = Page.subNavigation();
            aboutUs = subnavigation.clickLinkAboutUs();
            expectedAboutUsData = testCaseData.get("AboutUs");
            String url = aboutUs.getApplicationUrl() + expectedAboutUsData.get("aboutUsUrl");
            expectedAboutUsData.put("url", url);
            leftMenu = Page.contentPagesLeftMenu();
            AutomationLog.info("Redirection for About Us Page sucessfull");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Redirection for About Us Page failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyLink(aboutUs, expectedAboutUsData);
        verifyLeftMenuActiveLink();
        AutomationLog.info("AboutUs page is correctly loaded");
    }

    public void verifyLeftMenuActiveLink() throws Exception
    {
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.aboutUsLinkText(),"Left menu does not show About Us link as Active Link");
        AutomationLog.info("Left menu shows About Us link as Active Link");
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
