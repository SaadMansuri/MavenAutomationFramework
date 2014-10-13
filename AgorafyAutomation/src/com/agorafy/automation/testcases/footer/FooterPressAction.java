package com.agorafy.automation.testcases.footer;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterSupportLinks;
import com.agorafy.automation.pageobjects.footer.support.Press;
/**
 * Test Press link on Footer
 * Click Press link on the Home Page, verify Press Page is loaded 
 * Verify the URL of Press Page
 * Verify the title of Press Page
 * Verify the Heading Text on Press Page
 */
public class FooterPressAction extends AutomationTestCaseVerification
{
    public FooterPressAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases()
    {
        FooterSupportLinks supportLinks = Page.footer().supportLinks();
        Press press = null;
        try
        {
            press = supportLinks.clickOnPressLink();
            AutomationLog.info("Press Page opened successfully");

            Assert.assertEquals(press.currentURL(),press.pressPageUrl(), "Press Link did not Navigate to correct pageUrl");
            AutomationLog.info("Press Link navigates to Press URL");

            Assert.assertEquals(press.currentPageTitle(), "AGORAFY - Press", "Press page does not show correct PageTitle");
            AutomationLog.info("Press page shows correct page title");

            Assert.assertEquals(press.headingText(), "Press","Press page does not show correct page Heading");
            AutomationLog.info("Press page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either Press page did not open successfully or Press page verification failed" + e.getMessage());
        }
    }

    @Override
    protected String successMessage()
    {
        return " Footer Press tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Footer Press Action Failed ";
    }
}