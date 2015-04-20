package com.agorafy.automation.testcases.contentpages.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.MembershipBenefit;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test MembershipBenefit link on Footer
 * Click MembershipBenefit link on the Home Page, verify MembershipBenefit Page is loaded 
 * Verify the URL of MembershipBenefit Page
 * Verify the title of MembershipBenefit Page
 * Verify the Heading Text on MembershipBenefit Page
 */
public class FooterMembershipBenefitsAction extends ContentPagesVerification
{
    public FooterMembershipBenefitsAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        MembershipBenefit membershipBenefit = companyLinks.clickOnMembershipBenefitLink();

        HashMap<String, String> expectedMembershipBenefitData = testCaseData.get("Member");
        String url = membershipBenefit.getApplicationUrl() + expectedMembershipBenefitData.get("membersPageUrl");
        expectedMembershipBenefitData.put("url", url);
        verifyLink(membershipBenefit, expectedMembershipBenefitData);

        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.membershipBenefitLinkText(), "Left menu does not show Members' Benefits link as Active Link");
        AutomationLog.info("Left menu shows Members' Benefits link as Active Link");

        AutomationLog.info("Members' Benefits Page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "Members' Benefits link on Footer tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Members' Benefits link Test Failed";
    }
}