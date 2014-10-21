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
    public SubnavigationFaqAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        FAQs faqs = subnavigation.clickLinkFAQ();

        Assert.assertEquals(faqs.currentURL(),faqs.faqsPageUrl(), "Link did not redirect to correct PageUrl ");
        AutomationLog.info("Link redirects to correct PageUrl");

        HashMap<String, String> expectedFAQsData = testCaseData.get("FAQ");
        Assert.assertEquals(faqs.currentPageTitle(), expectedFAQsData.get("title"), "Page does not show correct Page Title");
        AutomationLog.info("Page shows correct page Title");

        AutomationLog.info("FAQ Page is correctly loaded");
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
