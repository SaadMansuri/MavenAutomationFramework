package com.agorafy.automation.testcases.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.FAQs;
import com.agorafy.automation.pageobjects.footer.FooterSupportLinks;
/**
 * Test FAQs link on Footer
 * Click FAQs link on the Home Page, verify FAQs Page is loaded 
 * Verify the URL of FAQs Page
 * Verify the title of FAQs Page
 * Verify the Heading Text on FAQs Page
 */
public class FooterFAQsAction extends AutomationTestCaseVerification
{
    public FooterFAQsAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases()
    {
        FooterSupportLinks supportLinks = Page.footer().supportLinks();
        FAQs fAQs = null;
        HashMap<String, String> faqMap = testCaseData.get("FAQs");
        try
        {
            fAQs = supportLinks.clickOnFAQsLink();
            AutomationLog.info("FAQs Page opened successfully");

            Assert.assertEquals(fAQs.currentURL(),fAQs.faqsPageUrl(), "FAQs Link did not Navigate to correct pageUrl");
            AutomationLog.info("FAQs Link navigates to FAQs URL");

            Assert.assertEquals(fAQs.currentPageTitle(), faqMap.get("title").trim(), "FAQs page does not show correct PageTitle");
            AutomationLog.info("FAQs page shows correct page title");

            Assert.assertEquals(fAQs.headingText(), faqMap.get("pageheading").trim(),"FAQs page does not show correct page Heading");
            AutomationLog.info("FAQs page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either FAQs page did not open successfully or FAQs page verification failed" + e.getMessage());
        }
    }

    @Override
    protected String successMessage()
    {
        return " Footer FAQs tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Footer FAQs Action Failed ";
    }
}