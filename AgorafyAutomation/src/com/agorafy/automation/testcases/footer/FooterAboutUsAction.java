package com.agorafy.automation.testcases.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;
import com.agorafy.automation.testcases.ContentPagesVerification;

/**
 * Test About Us link on Footer
 * Click About Us link on the Home Page, verify About Us Page is loaded 
 * Verify the URL of About Us Page
 * Verify the title of About Us Page
 * Verify the Heading Text on About Us Page
 */

public class FooterAboutUsAction extends ContentPagesVerification
{
    public FooterAboutUsAction()
    {
        super();
    }

    @Override
	protected void verifyTestCases() throws Exception
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        AboutUs aboutUs = companyLinks.clickOnAboutUsLink();

        HashMap<String, String> expectedAboutUsData = testCaseData.get("AboutUs");
        expectedAboutUsData.put("url", aboutUs.aboutUsPageUrl());
        verifyLink(aboutUs, expectedAboutUsData);

        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.aboutUsLinkText(),"Left menu does not show About Us link as Active Link");
        AutomationLog.info("Left menu shows About Us link as Active Link");

        AutomationLog.info("AboutUs page is correctly loaded");
    }

    @Override
	protected String successMessage()
    {
        return " Footer AboutUs tested successfully";
    }

    @Override
	protected String failureMessage()
    {
        return "Footer AboutUs Action Failed ";
    }
}