package com.agorafy.automation.testcases.footer;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Contact;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;

public class FooterContactAction extends FooterAction
{
    public FooterContactAction()
    {
        super();
    }

    @Override
    void testLink()
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        Contact contact = null;
        try
        {
            contact = companyLinks.openContact();
            AutomationLog.info("Contact Page opened successfully");

            Assert.assertEquals(contact.currentURL(), contact.contactPageUrl(), "Contact Link did not Navigate to correct pageUrl");
            AutomationLog.info("Contact Link navigates to Team URL");

            Assert.assertEquals(contact.currentPageTitle(), "AGORAFY - Contact", "Contact page does not show correct PageTitle");
            AutomationLog.info("Contact page shows correct page title");

            Assert.assertEquals(contact.headingText(), "Contact","Contact page does not show correct page Heading");
            AutomationLog.info("Contact page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either Contact page did not open successfully or Contact page verification failed" + e.getMessage());
        }
    }

    @Override
    String successMessage()
    {
        return " Footer Contact tested successfully";
    }

    @Override
    String failureMessage()
    {
        return "Footer Contact Action Failed ";
    }
}