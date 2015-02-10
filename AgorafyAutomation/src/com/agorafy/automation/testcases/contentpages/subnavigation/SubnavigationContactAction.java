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
