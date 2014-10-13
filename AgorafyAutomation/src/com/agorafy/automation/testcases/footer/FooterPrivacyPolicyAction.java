package com.agorafy.automation.testcases.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterLegalLinks;
import com.agorafy.automation.pageobjects.footer.legal.PrivacyPolicy;
/**
 * Test PrivacyPolicy link on Footer
 * Click PrivacyPolicy link on the Home Page, verify PrivacyPolicy Page is loaded 
 * Verify the URL of PrivacyPolicy Page
 * Verify the title of PrivacyPolicy Page
 * Verify the Heading Text on PrivacyPolicy Page
 */
public class FooterPrivacyPolicyAction extends AutomationTestCaseVerification
{
    public FooterPrivacyPolicyAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases()
    {
        FooterLegalLinks legalLinks = Page.footer().legalLinks();
        PrivacyPolicy privacyPolicy = null;
        HashMap<String, String> privacyPolicyMap = testCaseData.get("PrivacyPolicy"); 
        try
        {
            privacyPolicy = legalLinks.clickOnPrivacyPolicyLink();
            AutomationLog.info("PrivacyPolicy Page opened successfully");

            Assert.assertEquals(privacyPolicy.currentURL(), privacyPolicy.privacyPolicyPageUrl(), "PrivacyPolicy Link did not Navigate to correct pageUrl");
            AutomationLog.info("PrivacyPolicy Link navigates to PrivacyPolicy URL");

            Assert.assertEquals(privacyPolicy.currentPageTitle(), privacyPolicyMap.get("title").trim(), "PrivacyPolicy page does not show correct PageTitle");
            AutomationLog.info("PrivacyPolicy page shows correct page title");

            Assert.assertEquals(privacyPolicy.headingText(), privacyPolicyMap.get("pageheading").trim(),"PrivacyPolicy page does not show correct page Heading");
            AutomationLog.info("PrivacyPolicy page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either PrivacyPolicy page did not open successfully or PrivacyPolicy page verification failed" + e.getMessage());
        }
    }

    @Override
    protected String successMessage()
    {
        return " Footer PrivacyPolicy tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Footer PrivacyPolicy Action Failed ";
    }
}