package com.agorafy.automation.testcases.contentpages.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterSupportLinks;
import com.agorafy.automation.pageobjects.footer.support.Feedback;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test Feedback link on Footer
 * Click Feedback link on the Home Page, verify Feedback Page is loaded 
 * Verify the URL of Feedback Page
 * Verify the title of Feedback Page
 * Verify the Heading Text on Feedback Page
 */
public class FooterFeedbackAction extends ContentPagesVerification
{
    public FooterFeedbackAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        FooterSupportLinks supportLinks = Page.footer().supportLinks();
        Feedback feedback = supportLinks.clickOnFeedbackLink();

        HashMap<String, String> expectedFeedbackData = testCaseData.get("Feedback");
        String url = feedback.getApplicationUrl() + expectedFeedbackData.get("feedbackUrl");
        expectedFeedbackData.put("url", url);
        verifyLink(feedback, expectedFeedbackData);

        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.feedbackLinkText(), "Left menu does not show Feedback link as Active Link");
        AutomationLog.info("Left menu shows Feedback link as Active Link");

        AutomationLog.info("Feedback page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "Feedback link on Footer tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Feedback link Test Failed";
    }
}