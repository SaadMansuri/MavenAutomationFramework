package com.agorafy.automation.testcases.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;
/**
 * Test About Us link on Footer
 * Click About Us link on the Home Page, verify About Us Page is loaded 
 * Verify the URL of About Us Page
 * Verify the title of About Us Page
 * Verify the Heading Text on About Us Page
 */
public class FooterAboutUsAction extends AutomationTestCaseVerification
{
    public FooterAboutUsAction()
    {
        super();
    }

    @Override
	protected void verifyTestCases()
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        AboutUs aboutUs=null;
        HashMap<String, String> aboutUsMap = testCaseData.get("AboutUs");
        try
        {
            aboutUs = companyLinks.clickOnAboutUsLink();
            AutomationLog.info("AboutUs Page opened successfully");

            Assert.assertEquals(aboutUs.currentURL(), aboutUs.aboutUsPageUrl(), "About Us Link did not Navigate to correct pageUrl");
            AutomationLog.info("About Us Link navigates to About Us URL");

            Assert.assertEquals(aboutUs.currentPageTitle(), aboutUsMap.get("title").trim(), "About Us page does not show correct PageTitle");
            AutomationLog.info("About Us Page shows correct PageTitle");

            Assert.assertEquals(aboutUs.headingText(), aboutUsMap.get("pageheading").trim(), "About Us page does not show correct Page Heading");
            AutomationLog.info("About Us Page shows correct Page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either About Us page did not open successfully or About Us page verification failed" + e.getMessage());
        }
    }

    @Override
	protected String successMessage()
    {
        return " Footer AboutUs tested successfully";
    }

    @Override
	protected String failureMessage()
    {
        return "Footer AboutUs Action Failed ";
    }
}