package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Contact;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test whether 'Contact' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationContactAction extends ContentPagesVerification
{
    private Contact contactPage;
	private ContentPagesLeftMenu leftMenu;
	private String actualActiveLeftMenu;
	private String expectedActiveLeftMenu;

	public SubnavigationContactAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {

        SubNavigation subnavigation = Page.subNavigation();
        String dropdownMoreOption = "Contact";
        contactPage = (Contact) subnavigation.selectDropdownMoreOption(dropdownMoreOption);

        HashMap<String, String> expectedContactData = testCaseData.get("Contact");
        expectedContactData.put("url", contactPage.contactPageUrl());
        verifyLink(contactPage, expectedContactData);

        AutomationLog.info("Contact page is correctly loaded");

        AutomationLog.info("Testing whether Contact link is active in left side started...");
        verifyLeftMenu();
    }

    private void verifyLeftMenu() throws Exception 
    {
        leftMenu = Page.contentPagesLeftMenu();
        actualActiveLeftMenu = leftMenu.getCurrentlyActiveLink();
        expectedActiveLeftMenu = leftMenu.ContactLinkText();  
        Assert.assertEquals(actualActiveLeftMenu, expectedActiveLeftMenu,"Left menu does not show Contact link as Active Link");
        AutomationLog.info("Left menu shows Contact link as Active Link");
    }

    @Override
    protected String successMessage()
    {
        return "Contact link in Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for Contact link in Subnavigation Failed";
    }
}
