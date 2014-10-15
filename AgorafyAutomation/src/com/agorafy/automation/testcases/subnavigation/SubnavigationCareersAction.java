package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;
import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Careers;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

/**
 * Test whether 'Careers' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationCareersAction extends AutomationTestCaseVerification
{
    public SubnavigationCareersAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        HashMap<String, String> careerExpectedData = testCaseData.get("Careers");

        Careers careerPage = subnavigation.clickLinkCareers();
        Assert.assertEquals(careerPage.currentURL(), careerPage.careersPageUrl(), "Careers Page URL is not as expected after clicking the link.");
        Assert.assertEquals(careerPage.currentPageTitle(), careerExpectedData.get("title"), "Careers Page title does not match to the expected");
        Assert.assertEquals(careerPage.headingText(), careerExpectedData.get("heading"), "Careers Page is not loaded with correct Heading");
        AutomationLog.info("Careers page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "Careers link in Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for Careers link in Subnavigation Failed";
    }
}
