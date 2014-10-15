package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.MembershipBenefit;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

/**
 * Test whether 'Members' Benefit' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationMemberBenefitAction extends AutomationTestCaseVerification
{
    public SubnavigationMemberBenefitAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        HashMap<String, String> memberExpectedData = testCaseData.get("Member");

        MembershipBenefit memberBenefit = subnavigation.clickLinkMemberBenefits();
        Assert.assertEquals(memberBenefit.currentURL(), memberBenefit.membershipBenefitPageUrl(), "Member Benefits Page URL is not as expected after clicking the link.");
        Assert.assertEquals(memberBenefit.currentPageTitle(), memberExpectedData.get("title"), "Member Benefits Page title does not match to the expected");
        Assert.assertEquals(memberBenefit.headingText(), memberExpectedData.get("heading"), "Member Benefits Page is not loaded with correct Heading");
        AutomationLog.info("Member Benefits page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "Members' Benefits link in Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for Members' Benefits link in Subnavigation Failed";
    }
}
