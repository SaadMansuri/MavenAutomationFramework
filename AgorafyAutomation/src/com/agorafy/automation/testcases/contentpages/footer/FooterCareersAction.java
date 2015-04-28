package com.agorafy.automation.testcases.contentpages.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Careers;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;
/**
 * Test Careers link on Footer
 * Click Careers link on the Home Page, verify Careers Page is loaded 
 * Verify the URL of Careers Page
 * Verify the title of Careers Page
 * Verify the Heading Text on Careers Page
 */
public class FooterCareersAction extends ContentPagesVerification
{
    public FooterCareersAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        Careers career = companyLinks.clickOnCareersLink();

        HashMap<String, String> expectedCareersData = testCaseData.get("Careers");
        String url = career.getApplicationUrl() + expectedCareersData.get("careersUrl");
        expectedCareersData.put("url", url);
        verifyLink(career, expectedCareersData);

        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.careersLinkText(), "Left menu does not show Careers link as Active Link");
        AutomationLog.info("Left menu shows Careers link as Active Link");

        AutomationLog.info("Careers page is correctly loaded");
    }

    @Override
    protected String successMessage()
    {
        return "Careers link on Footer tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Careers link Test Failed";
    }
}