package com.agorafy.automation.testcases.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterSupportLinks;
import com.agorafy.automation.pageobjects.footer.support.Feedback;
/**
 * Test Feedback link on Footer
 * Click Feedback link on the Home Page, verify Feedback Page is loaded 
 * Verify the URL of Feedback Page
 * Verify the title of Feedback Page
 * Verify the Heading Text on Feedback Page
 */
public class FooterFeedbackAction extends AutomationTestCaseVerification
{
    public FooterFeedbackAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases()
    {
        FooterSupportLinks supportLinks = Page.footer().supportLinks();
        Feedback feedback = null;
        HashMap<String, String> feedbackMap = testCaseData.get("Feedback");
        try
        {
            feedback = supportLinks.clickOnFeedbackLink();
            AutomationLog.info("Feedback Page opened successfully");

            Assert.assertEquals(feedback.currentURL(), feedback.feedbackPageUrl(), "Feedback Link did not Navigate to correct pageUrl");
            AutomationLog.info("Feedback Link navigates to Feedback URL");

            Assert.assertEquals(feedback.currentPageTitle(), feedbackMap.get("title").trim(), "Feedback page does not show correct PageTitle");
            AutomationLog.info("Feedback page shows correct page title");

            Assert.assertEquals(feedback.headingText(), feedbackMap.get("pageheading").trim(),"Feedback page does not show correct page Heading");
            AutomationLog.info("Feedback page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either Feedback page did not open successfully or Feedback page verification failed" + e.getMessage());
        }
    }

    @Override
    protected String successMessage()
    {
        return " Footer Feedback tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Footer Feedback Action Failed ";
    }
}