package com.agorafy.automation.testcases.contentpages.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

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
        String url = aboutUs.getApplicationUrl() + expectedAboutUsData.get("aboutUsUrl");
        expectedAboutUsData.put("url", url);
        verifyLink(aboutUs, expectedAboutUsData);

        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.aboutUsLinkText(),"Left menu does not show About Us link as Active Link");
        AutomationLog.info("Left menu shows About Us link as Active Link");

        AutomationLog.info("AboutUs page is correctly loaded");
    }

    @Override
	protected String successMessage()
    {
        return "About Us link on Footer tested successfully";
    }

    @Override
	protected String failureMessage()
    {
        return "About Us link Test Failed";
    }
}