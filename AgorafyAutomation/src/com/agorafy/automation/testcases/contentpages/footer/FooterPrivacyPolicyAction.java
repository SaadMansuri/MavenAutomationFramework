package com.agorafy.automation.testcases.footer;

import java.util.HashMap;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterLegalLinks;
import com.agorafy.automation.pageobjects.footer.legal.PrivacyPolicy;
import com.agorafy.automation.testcases.ContentPagesVerification;

/**
 * Test PrivacyPolicy link on Footer
 * Click PrivacyPolicy link on the Home Page, verify PrivacyPolicy Page is loaded 
 * Verify the URL of PrivacyPolicy Page
 * Verify the title of PrivacyPolicy Page
 * Verify the Heading Text on PrivacyPolicy Page
 */
public class FooterPrivacyPolicyAction extends ContentPagesVerification
{
    public FooterPrivacyPolicyAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        FooterLegalLinks legalLinks = Page.footer().legalLinks();
        PrivacyPolicy privacyPolicy = legalLinks.clickOnPrivacyPolicyLink();

        HashMap<String, String> expectedPrivacyPolicyData = testCaseData.get("PrivacyPolicy");
        expectedPrivacyPolicyData.put("url", privacyPolicy.privacyPolicyPageUrl());
        verifyLink(privacyPolicy, expectedPrivacyPolicyData);

        AutomationLog.info("Privacy Policy Page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return " Footer PrivacyPolicy tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Footer PrivacyPolicy Action Failed ";
    }
}