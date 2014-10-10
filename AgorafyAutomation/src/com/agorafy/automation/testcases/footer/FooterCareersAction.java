package com.agorafy.automation.testcases.footer;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Careers;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;

public class FooterCareersAction extends FooterAction
{
    public FooterCareersAction()
    {
        super();
    }

    @Override
    void testLink()
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        Careers career = null;
        try
        {
            career = companyLinks.openCareers();
            AutomationLog.info("Careers Page opened successfully");

            Assert.assertEquals(career.currentURL(), career.careersPageUrl(), "Careers Link did not Navigate to correct pageUrl");
            AutomationLog.info("Careers Link navigates to Careers URL");

            Assert.assertEquals(career.currentPageTitle(), "AGORAFY - Careers", "Careers page does not show correct PageTitle");
            AutomationLog.info("Careers page shows correct page title");

            Assert.assertEquals(career.headingText(), "Careers","Careers page does not show correct page Heading");
            AutomationLog.info("Careers page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either Careers page did not open successfully or Careers page verification failed" + e.getMessage());
        }
    }

    @Override
    String successMessage()
    {
        return " Footer Careers tested successfully";
    }

    @Override
    String failureMessage()
    {
        return "Footer Careers Action Failed ";
    }
}