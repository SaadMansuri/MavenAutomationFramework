package com.agorafy.automation.testcases.footer;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterLegalLinks;
import com.agorafy.automation.pageobjects.footer.legal.TermsAndConditions;

public class FooterTermsAndConditionAction extends FooterAction
{
    public FooterTermsAndConditionAction()
    {
        super();
    }

    @Override
    void testLink()
    {		
        FooterLegalLinks legalLinks = Page.footer().legalLinks();
        TermsAndConditions termsAndConditions = null;
        try
        {
            termsAndConditions = legalLinks.openTermsAndConditions();
            AutomationLog.info("Terms And Conditions Page opened successfully");

            Assert.assertEquals(termsAndConditions.currentURL(), termsAndConditions.termsAndConditionsPageUrl(), "TermsAndConditions Link did not Navigate to correct pageUrl");
            AutomationLog.info("TermsAndConditions Link navigates to TermsAndConditions URL");

            Assert.assertEquals(termsAndConditions.currentPageTitle(), "AGORAFY - Terms and Conditions", "TermsAndConditions page does not show correct PageTitle");
            AutomationLog.info("TermsAndConditions page shows correct page title");

            Assert.assertEquals(termsAndConditions.headingText(), "Terms and Conditions","TermsAndConditions page does not show correct page Heading");
            AutomationLog.info("TermsAndConditions page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either TermsAndConditions page did not open successfully or TermsAndConditions page verification failed" + e.getMessage());
        }
    }

    @Override
    String successMessage()
    {
        return " Footer TermsAndConditions tested successfully";
    }

    @Override
    String failureMessage()
    {
        return "Footer TermsAndConditions Action Failed ";
    }
}