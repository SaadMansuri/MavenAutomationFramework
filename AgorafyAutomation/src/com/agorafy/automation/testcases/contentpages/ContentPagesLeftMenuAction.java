package com.agorafy.automation.testcases.contentpages;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.contentpages.Careers;
import com.agorafy.automation.pageobjects.contentpages.Contact;
import com.agorafy.automation.pageobjects.contentpages.HowItWorks;
import com.agorafy.automation.pageobjects.contentpages.MembershipBenefit;
import com.agorafy.automation.pageobjects.footer.company.Team;
import com.agorafy.automation.pageobjects.footer.support.Feedback;
import com.agorafy.automation.pageobjects.footer.support.Press;

/**
 * Test links on LeftMenu
 * Click About Us link on the LeftMenu, verify About Us Page is loaded 
 * Verify the URL of About Us Page
 * Verify that LeftMenu highlights About Us Link
 * Verify the same for other links on LeftMenu
 */
public class ContentPagesLeftMenuAction extends ContentPagesVerification
{
    ContentPagesLeftMenu leftMenu = null;
    HashMap<String, String> testData = null;

    public ContentPagesLeftMenuAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        leftMenu = Page.contentPagesLeftMenu();
        verifyAboutUsLinkOnLeftMenu();
        verifyHowItWorksLinkOnLeftMenu();
        verifyMembershipBenefitLinkOnLeftMenu();
        verifyPressLinkOnLeftMenu();
        verifyTeamLinkOnLeftMenu();
        verifyCareersLinkOnLeftMenu();
        verifyFeedbackLinkOnLeftMenu();
        verifyContactLinkOnLeftMenu();
    }

    private void verifyContactLinkOnLeftMenu() throws Exception
    {
        Contact contact = leftMenu.clickOnContactLink();
        testData = testCaseData.get("Contact");
        testData.put("url", contact.contactPageUrl());
        verifyLink(contact, testData);

        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.contactLinkText(), "Left menu does not show Contact link as Active Link");
        AutomationLog.info("Left menu shows Contact link as Active Link");
        AutomationLog.info("Contact page is correctly loaded");
    }

    private void verifyFeedbackLinkOnLeftMenu() throws Exception
    {
        Feedback feedback = leftMenu.clickOnFeedbackLink();
        testData = testCaseData.get("Feedback");
        testData.put("url", feedback.feedbackPageUrl());
        verifyLink(feedback, testData);

        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.feedbackLinkText(), "Left menu does not show Feedback link as Active Link");
        AutomationLog.info("Left menu shows Feedback link as Active Link");
        AutomationLog.info("Feedback page is correctly loaded");
    }

    private void verifyCareersLinkOnLeftMenu() throws Exception
    {
        Careers careers = leftMenu.clickOnCareersLink();
        testData = testCaseData.get("Careers");
        testData.put("url", careers.careersPageUrl());
        verifyLink(careers, testData);

        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.careersLinkText(), "Left menu does not show Careers link as Active Link");
        AutomationLog.info("Left menu shows Careers link as Active Link");
        AutomationLog.info("Careers page is correctly loaded");
    }

    private void verifyTeamLinkOnLeftMenu() throws Exception
    {
        Team team = leftMenu.clickOnTeamLink();
        testData = testCaseData.get("Team");
        testData.put("url", team.teamPageUrl());
        verifyLink(team, testData);

        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.teamLinkText(), "Left menu does not show Team link as Active Link");
        AutomationLog.info("Left menu shows Team link as Active Link");
        AutomationLog.info("Team page is correctly loaded");
    }

    private void verifyPressLinkOnLeftMenu() throws Exception
    {
        Press press = leftMenu.clickOnPressLink();
        testData = testCaseData.get("Press");
        testData.put("url", press.pressPageUrl());
        verifyLink(press, testData);

        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.pressLinkText(), "Left menu does not show Press link as Active Link");
        AutomationLog.info("Left menu shows Press link as Active Link");
        AutomationLog.info("Press page is correctly loaded");
    }

    private void verifyMembershipBenefitLinkOnLeftMenu() throws Exception
    {
        MembershipBenefit benefits = leftMenu.clickOnMembershipBenefitLink();
        testData = testCaseData.get("Member");
        testData.put("url", benefits.membershipBenefitPageUrl());
        verifyLink(benefits, testData);

        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.membershipBenefitLinkText(), "Left menu does not show Membership Benefit link as Active Link");
        AutomationLog.info("Left menu shows Membership Benefit link as Active Link");
        AutomationLog.info("Membership Benefit is correctly loaded");
    }

    private void verifyHowItWorksLinkOnLeftMenu() throws Exception
    {
        HowItWorks howItWorks = leftMenu.clickOnHowItWorksLink();
        testData = testCaseData.get("HowItWorks");
        testData.put("url", howItWorks.howItWorksPageUrl());
        verifyLink(howItWorks, testData);

        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.howItWorksLinkText(), "Left menu does not show How It Works link as Active Link");
        AutomationLog.info("Left menu shows How It Works link as Active Link");
        AutomationLog.info("How It Works Page is correctly loaded");
    }

    private void verifyAboutUsLinkOnLeftMenu() throws Exception
    {
        AboutUs aboutUs = leftMenu.clickOnAboutUsLink();
        testData = testCaseData.get("AboutUs");
        testData.put("url", aboutUs.aboutUsPageUrl());
        verifyLink(aboutUs, testData);

        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.aboutUsLinkText(), "Left menu does not show About Us link as Active Link");
        AutomationLog.info("Left menu shows About Us link as Active Link");
        AutomationLog.info("AboutUs page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "Content Pages Left Menu tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Content Pages Left Menu Failed";
    }
}