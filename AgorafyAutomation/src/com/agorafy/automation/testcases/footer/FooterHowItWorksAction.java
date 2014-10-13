package com.agorafy.automation.testcases.footer;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.HowItWorks;
import com.agorafy.automation.pageobjects.footer.FooterSupportLinks;
/**
 * Test HowItWorks link on Footer
 * Click HowItWorks link on the Home Page, verify HowItWorks Page is loaded 
 * Verify the URL of HowItWorks Page
 * Verify the title of HowItWorks Page
 * Verify the Heading Text on HowItWorks Page
 */
public class FooterHowItWorksAction extends AutomationTestCaseVerification
{
    public FooterHowItWorksAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases()
    {
        FooterSupportLinks supportLinks = Page.footer().supportLinks();
        HowItWorks howItWorks = null;
        try
        {
            howItWorks = supportLinks.clickOnHowItWorksLink();
            AutomationLog.info("HowItWorks Page opened successfully");

            Assert.assertEquals(howItWorks.currentURL(), howItWorks.howItWorksPageUrl(), "HowItWorks Link did not Navigate to correct pageUrl");
            AutomationLog.info("HowItWorks Link navigates to HowItWorks URL");

            Assert.assertEquals(howItWorks.currentPageTitle(), "AGORAFY - Tips and How-Tos", "HowItWorks page does not show correct PageTitle");
            AutomationLog.info("HowItWorks page shows correct page title");

            Assert.assertEquals(howItWorks.headingText(), "How It Works","HowItWorks page does not show correct page Heading");
            AutomationLog.info("HowItWorks page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either HowItWorks page did not open successfully or HowItWorks page verification failed" + e.getMessage());
        }
    }

    @Override
    protected String successMessage()
    {
        return " Footer HowItWorks tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Footer HowItWorks Action Failed ";
    }
}