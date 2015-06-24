package com.agorafy.automation.testcases.contentpages.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Contact;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test Contact link on Footer
 * Click Contact link on the Home Page, verify Contact Page is loaded 
 * Verify the URL of Contact Page
 * Verify the title of Contact Page
 * Verify the Heading Text on Contact Page
 */
public class FooterContactAction extends ContentPagesVerification
{
    public FooterContactAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        Contact contact = companyLinks.clickOnContactLink();

        HashMap<String, String> expectedContactData = testCaseData.get("Contact");
        String url = contact.getApplicationUrl() + expectedContactData.get("contactsUrl");
        expectedContactData.put("url", url);
        verifyLink(contact, expectedContactData);

        verifyActiveLeftMenu();
/*        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.contactLinkText(), "Left menu does not show Contact link as Active Link");
        AutomationLog.info("Left menu shows Contact link as Active Link");
*/
        //verifyContactPage(contact);
        AutomationLog.info("Contact page is correctly loaded");
    }

    public void verifyActiveLeftMenu() throws Exception
    {
        ContentPagesLeftMenu leftMenu = Page.contentPagesLeftMenu();
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.contactLinkText(), "Left menu does not show Contact link as Active Link");
        AutomationLog.info("Left menu shows Contact link as Active Link");
    }

    @Override
    protected String successMessage()
    {
        return "Contact link on Footer tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Contact link Test Failed ";
    }
}