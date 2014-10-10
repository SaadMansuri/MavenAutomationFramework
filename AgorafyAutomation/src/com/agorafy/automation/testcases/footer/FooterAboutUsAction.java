package com.agorafy.automation.testcases.footer;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;

public class FooterAboutUsAction extends FooterAction
{
    public FooterAboutUsAction()
    {
        super();
    }

    @Override
    void testLink()
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        AboutUs aboutUs=null;
        try
        {
            aboutUs = companyLinks.openAboutUs();
            AutomationLog.info("AboutUs Page opened successfully");

            Assert.assertEquals(aboutUs.currentURL(), aboutUs.aboutUsPageUrl(), "About Us Link did not Navigate to correct pageUrl");
            AutomationLog.info("About Us Link navigates to About Us URL");

            Assert.assertEquals(aboutUs.currentPageTitle(), "AGORAFY - About Us", "About Us page does not show correct PageTitle");
            AutomationLog.info("About Us Page shows correct PageTitle");

            Assert.assertEquals(aboutUs.headingText(), "About Us", "About Us page does not show correct Page Heading");
            AutomationLog.info("About Us Page shows correct Page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either About Us page did not open successfully or About Us page verification failed" + e.getMessage());
        }
    }

    @Override
    String successMessage()
    {
        return " Footer AboutUs tested successfully";
    }

    @Override
    String failureMessage()
    {
        return "Footer AboutUs Action Failed ";
    }
}