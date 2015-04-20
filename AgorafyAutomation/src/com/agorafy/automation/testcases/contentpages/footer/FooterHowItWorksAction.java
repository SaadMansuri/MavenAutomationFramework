package com.agorafy.automation.testcases.contentpages.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.HowItWorks;
import com.agorafy.automation.pageobjects.footer.FooterSupportLinks;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test HowItWorks link on Footer
 * Click HowItWorks link on the Home Page, verify HowItWorks Page is loaded 
 * Verify the URL of HowItWorks Page
 * Verify the title of HowItWorks Page
 * Verify the Heading Text on HowItWorks Page
 */
public class FooterHowItWorksAction extends ContentPagesVerification
{
    public FooterHowItWorksAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        FooterSupportLinks supportLinks = Page.footer().supportLinks();
        HowItWorks howItWorks = supportLinks.clickOnHowItWorksLink();

        HashMap<String, String> expectedHowItWorksData = testCaseData.get("HowItWorks");
        String url = howItWorks.getApplicationUrl() + expectedHowItWorksData.get("howItWorksPageUrl");
        expectedHowItWorksData.put("url", url);
        verifyLink(howItWorks, expectedHowItWorksData);

        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.howItWorksLinkText(), "Left menu does not show How It Works link as Active Link");
        AutomationLog.info("Left menu shows How It Works link as Active Link");

        AutomationLog.info("How It Works Page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "HowItWorks link on Footer tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "HowItWorks link Test Failed ";
    }
}