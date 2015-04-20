package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.MembershipBenefit;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test whether 'Members' Benefit' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 */

public class SubnavigationMemberBenefitAction extends ContentPagesVerification
{
    private SubNavigation subnavigation;
    private MembershipBenefit memberBenefit;
    private HashMap<String, String> expectedMembershipBenefitData = new HashMap<>();
	private ContentPagesLeftMenu leftMenu;

    public SubnavigationMemberBenefitAction()
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();
        try 
        {
            subnavigation = Page.subNavigation();
            memberBenefit = subnavigation.clickLinkMemberBenefits();

            expectedMembershipBenefitData  = testCaseData.get("Member");
            String url = memberBenefit.getApplicationUrl() + expectedMembershipBenefitData.get("membersPageUrl");
            expectedMembershipBenefitData.put("url", url);

            leftMenu = Page.contentPagesLeftMenu();

            AutomationLog.info("Redirection to Member's benefit page passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Redirection to Member's benefit page failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyLink(memberBenefit, expectedMembershipBenefitData);

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
