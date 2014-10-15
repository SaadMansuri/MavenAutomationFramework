package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.FAQs;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

public class SubnavigationFaqAction extends AutomationTestCaseVerification
{
    public SubnavigationFaqAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        HashMap<String, String> blogExpectedData = testCaseData.get("faq");
        
        FAQs faqs = subnavigation.clickLinkFAQ();

        Assert.assertEquals(faqs.currentURL(), faqs.faqsPageUrl(), "FAQ Page URL is not as expected after clicking the link.");
        Assert.assertEquals(faqs.currentPageTitle(), blogExpectedData.get("title"), "Careers Page title does not match to the expected");
        AutomationLog.info("FAQ page is correctly loaded");

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
