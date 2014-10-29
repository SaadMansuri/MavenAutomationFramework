package com.agorafy.automation.testcases.contentpages.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.FAQs;
import com.agorafy.automation.pageobjects.footer.FooterSupportLinks;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test FAQs link on Footer
 * Click FAQs link on the Home Page, verify FAQs Page is loaded 
 * Verify the URL of FAQs Page
 * Verify the title of FAQs Page
 * Verify the Heading Text on FAQs Page
 */
public class FooterFAQsAction extends ContentPagesVerification
{
    public FooterFAQsAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        FooterSupportLinks supportLinks = Page.footer().supportLinks();
        FAQs fAQs = supportLinks.clickOnFAQsLink();

        Assert.assertEquals(fAQs.currentURL(),fAQs.faqsPageUrl(), "Link did not redirect to correct Page Url");
        AutomationLog.info("Page redirects to correct Page Url");

        HashMap<String, String> expectedFAQsData = testCaseData.get("FAQ");
        Assert.assertEquals(fAQs.currentPageTitle(), expectedFAQsData.get("title"), "Page does not show correct PageTitle");
        AutomationLog.info("Page shows correct Page Title");

        AutomationLog.info("FAQ Page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "FAQs link on Footer tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "FAQs link Test Failed ";
    }
}