package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.MembershipBenefit;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.ContentPagesVerification;

/**
 * Test whether 'Members' Benefit' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationMemberBenefitAction extends ContentPagesVerification
{
    public SubnavigationMemberBenefitAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        MembershipBenefit memberBenefit = subnavigation.clickLinkMemberBenefits();

        HashMap<String, String> expectedMembershipBenefitData = testCaseData.get("Member");
        expectedMembershipBenefitData.put("url", memberBenefit.membershipBenefitPageUrl());
        verifyLink(memberBenefit, expectedMembershipBenefitData);

        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.membershipBenefitLinkText(),"Left menu does not show Membership Benefit link as Active Link");
        AutomationLog.info("Left menu shows Membership Benefit link as Active Link");

        AutomationLog.info("Membership Benefit is correctly loaded");
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
