package com.agorafy.automation.testcases.contentpages.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterSupportLinks;
import com.agorafy.automation.pageobjects.footer.support.Press;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test Press link on Footer
 * Click Press link on the Home Page, verify Press Page is loaded 
 * Verify the URL of Press Page
 * Verify the title of Press Page
 * Verify the Heading Text on Press Page
 */
public class FooterPressAction extends ContentPagesVerification
{
    public FooterPressAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        FooterSupportLinks supportLinks = Page.footer().supportLinks();
        Press press = supportLinks.clickOnPressLink();

        HashMap<String, String> expectedPressData = testCaseData.get("Press");
        String url = press.getApplicationUrl() + expectedPressData.get("pressPageUrl");
        expectedPressData.put("url", url);

        verifyLink(press, expectedPressData);
        verifyActiveLeftMenu();

        AutomationLog.info("Press page is correctly loaded");
    }

    public void verifyActiveLeftMenu() throws Exception
    {
        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.pressLinkText(), "Left menu does not show Press link as Active Link");
        AutomationLog.info("Left menu shows Press link as Active Link");
    }


    @Override
    protected String successMessage()
    {
        return "Press link on Footer tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Press link Test Failed ";
    }
}