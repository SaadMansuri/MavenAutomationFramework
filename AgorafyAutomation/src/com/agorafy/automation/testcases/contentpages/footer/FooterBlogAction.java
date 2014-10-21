package com.agorafy.automation.testcases.contentpages.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Blog;
import com.agorafy.automation.pageobjects.footer.FooterSupportLinks;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test Blog link on Footer
 * Click Blog link on the Home Page, verify Blog Page is loaded 
 * Verify the URL of Blog Page
 * Verify the title of Blog Page * 
 */
public class FooterBlogAction extends ContentPagesVerification
{
    public FooterBlogAction()
    {
        super();
    }

    @Override
	protected void verifyTestCases() throws Exception
    {
        FooterSupportLinks supportLinks = Page.footer().supportLinks();
        Blog blog = supportLinks.clickOnBlogLink();;

        Assert.assertEquals(blog.currentURL(), blog.blogPageUrl(), "Link did not redirect to correct Page Url");
        AutomationLog.info("Link redirects to correct Page Url");

        HashMap<String, String> expectedBlogData = testCaseData.get("Blog");
        Assert.assertEquals(blog.currentPageTitle(), expectedBlogData.get("title"), "Page does not show correct PageTitle");
        AutomationLog.info("Page shows correct Page Title");

        AutomationLog.info("Blog Page is correctly loaded");
    }

    @Override
	protected String successMessage()
    {
        return " Footer Blog tested successfully";
    }

    @Override
	protected String failureMessage()
    {
        return "Footer Blog Action Failed ";
    }
}