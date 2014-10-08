package com.agorafy.automation.testcases.footer;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterLegalLinks;
import com.agorafy.automation.pageobjects.footer.legal.PrivacyPolicy;

public class FooterPrivacyPolicyAction extends FooterAction
{
    public FooterPrivacyPolicyAction()
    {
        super();
    }

    @Override
    void testLink()
    {
        FooterLegalLinks legalLinks = Page.footer().legalLinks();
        PrivacyPolicy privacyPolicy = null;
        try
        {
            privacyPolicy = legalLinks.openPrivacyPolicy();
            AutomationLog.info("PrivacyPolicy Page opened successfully");

            Assert.assertEquals(privacyPolicy.currentURL(), privacyPolicy.privacyPolicyPageUrl(), "PrivacyPolicy Link did not Navigate to correct pageUrl");
            AutomationLog.info("PrivacyPolicy Link navigates to PrivacyPolicy URL");

            Assert.assertEquals(privacyPolicy.currentPageTitle(), "AGORAFY - Privacy Policy", "PrivacyPolicy page does not show correct PageTitle");
            AutomationLog.info("PrivacyPolicy page shows correct page title");

            Assert.assertEquals(privacyPolicy.headingText(), "Privacy Policy","PrivacyPolicy page does not show correct page Heading");
            AutomationLog.info("PrivacyPolicy page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either PrivacyPolicy page did not open successfully or PrivacyPolicy page verification failed" + e.getMessage());
        }
    }

    @Override
    String successMessage()
    {
        return " Footer PrivacyPolicy tested successfully";
    }

    @Override
    String failureMessage()
    {
        return "Footer PrivacyPolicy Action Failed ";
    }
}