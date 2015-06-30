package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.FAQs;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

public class SubnavigationFaqAction extends ContentPagesVerification
{
    private SubNavigation subnavigation;
    private FAQs faqs;
    private HashMap<String, String> expectedFAQsData = new HashMap<>();

    public SubnavigationFaqAction()
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
            faqs = subnavigation.clickLinkFAQ();
            expectedFAQsData = testCaseData.get("FAQ");

            AutomationLog.info("Redirection to FAQ page passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Redirection to FAQ page failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyFAQPagePrimaryContents();
        AutomationLog.info("FAQ Page is correctly loaded");
    }

    public void verifyFAQPagePrimaryContents() throws Exception
    {
        Assert.assertEquals(faqs.currentURL(),expectedFAQsData.get("faqsPageUrl"), "Link did not redirect to correct PageUrl ");
        AutomationLog.info("Link redirects to correct PageUrl");

        Assert.assertEquals(faqs.currentPageTitle(), expectedFAQsData.get("title"), "Page does not show correct Page Title");
        AutomationLog.info("Page shows correct page Title");
    }

    @Override
    protected String successMessage()
    {
        return "FAQs link in Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for FAQs link in Subnavigation Failed";
    }
}
