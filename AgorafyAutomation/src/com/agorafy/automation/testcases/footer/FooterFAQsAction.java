package com.agorafy.automation.testcases.footer;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterSupportLinks;
import com.agorafy.automation.pageobjects.footer.support.FAQs;

public class FooterFAQsAction extends FooterAction
{
    public FooterFAQsAction()
    {
        super();
    }

    @Override
    void testLink()
    {
        FooterSupportLinks supportLinks = Page.footer().supportLinks();
        FAQs fAQs = null;
        try
        {
            fAQs = supportLinks.openFAQs();
            AutomationLog.info("FAQs Page opened successfully");

            Assert.assertEquals(fAQs.currentURL(),fAQs.faqsPageUrl(), "FAQs Link did not Navigate to correct pageUrl");
            AutomationLog.info("FAQs Link navigates to FAQs URL");

            Assert.assertEquals(fAQs.currentPageTitle(), "Agorafy - FAQ", "FAQs page does not show correct PageTitle");
            AutomationLog.info("FAQs page shows correct page title");

            Assert.assertEquals(fAQs.headingText(), "FREQUENTLY ASKED QUESTIONS","FAQs page does not show correct page Heading");
            AutomationLog.info("FAQs page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either FAQs page did not open successfully or FAQs page verification failed" + e.getMessage());
        }
    }

    @Override
	String successMessage()
    {
        return " Footer FAQs tested successfully";
    }

    @Override
    String failureMessage()
    {
        return "Footer FAQs Action Failed ";
    }
}