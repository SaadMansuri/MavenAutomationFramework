package com.agorafy.automation.testcases.contentpages;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;

public abstract class ContentPagesVerification extends AutomationTestCaseVerification
{
    protected ContentPagesVerification()
    {
        // This constructor passes its class name so that other classes (Footer, SubNavigation, LeftMenu) 
        // extending from this class can read common data from single CSV file
        super(ContentPagesVerification.class.getSimpleName());
    }

    public void verifyLink(Page verificationPage, HashMap<String, String> expectedData)
    {
        try
        {
            Assert.assertEquals(verificationPage.currentURL(), expectedData.get("url"), "Page URL is not as expected after clicking the link.");
            AutomationLog.info("Link redirects to Expected Page URL");

            Assert.assertEquals(verificationPage.currentPageTitle(), expectedData.get("title"), "Page title does not match to the expected");
            AutomationLog.info("Page shows Expected Page Title");

            Assert.assertEquals(verificationPage.pageHeading(), expectedData.get("heading"), "Page is not loaded with Expected Heading");
            AutomationLog.info("Page is loaded with Expected Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error(e.getMessage());
        }
    }
}
