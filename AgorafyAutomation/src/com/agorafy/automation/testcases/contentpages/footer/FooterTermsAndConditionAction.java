package com.agorafy.automation.testcases.footer;

import java.util.HashMap;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterLegalLinks;
import com.agorafy.automation.pageobjects.footer.legal.TermsAndConditions;
import com.agorafy.automation.testcases.ContentPagesVerification;

/**
 * Test TermsAndCondition link on Footer
 * Click TermsAndCondition link on the Home Page, verify TermsAndCondition Page is loaded 
 * Verify the URL of TermsAndCondition Page
 * Verify the title of TermsAndCondition Page
 * Verify the Heading Text on TermsAndCondition Page
 */
public class FooterTermsAndConditionAction extends ContentPagesVerification
{
    public FooterTermsAndConditionAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        FooterLegalLinks legalLinks = Page.footer().legalLinks();
        TermsAndConditions termsAndConditions = legalLinks.clickOnTermsAndConditionsLink();;

        HashMap<String, String> expectedTermsData = testCaseData.get("Terms");
        expectedTermsData.put("url", termsAndConditions.termsAndConditionsPageUrl());
        verifyLink(termsAndConditions, expectedTermsData);

        AutomationLog.info("Terms And Conditions Page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return " Footer TermsAndConditions tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Footer TermsAndConditions Action Failed ";
    }
}