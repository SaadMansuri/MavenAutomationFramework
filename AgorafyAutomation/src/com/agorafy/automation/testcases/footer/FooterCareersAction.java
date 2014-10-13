package com.agorafy.automation.testcases.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Careers;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;
/**
 * Test Careers link on Footer
 * Click Careers link on the Home Page, verify Careers Page is loaded 
 * Verify the URL of Careers Page
 * Verify the title of Careers Page
 * Verify the Heading Text on Careers Page
 */
public class FooterCareersAction extends AutomationTestCaseVerification
{
    public FooterCareersAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases()
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        HashMap<String, String> careersMap = testCaseData.get("Careers");
        Careers career = null;
        try
        {
            career = companyLinks.clickOnCareersLink();
            AutomationLog.info("Careers Page opened successfully");

            Assert.assertEquals(career.currentURL(), career.careersPageUrl(), "Careers Link did not Navigate to correct pageUrl");
            AutomationLog.info("Careers Link navigates to Careers URL");

            Assert.assertEquals(career.currentPageTitle(), careersMap.get("title").trim(), "Careers page does not show correct PageTitle");
            AutomationLog.info("Careers page shows correct page title");

            Assert.assertEquals(career.headingText(), careersMap.get("pageheading").trim(),"Careers page does not show correct page Heading");
            AutomationLog.info("Careers page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either Careers page did not open successfully or Careers page verification failed" + e.getMessage());
        }
    }

    @Override
    protected String successMessage()
    {
        return " Footer Careers tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Footer Careers Action Failed ";
    }
}