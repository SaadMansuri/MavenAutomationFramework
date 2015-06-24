package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Blog;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test whether 'Blog' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 *
 */

public class SubnavigationBlogAction extends ContentPagesVerification
{
    private SubNavigation subnavigation;
    private Blog blog;
    private HashMap<String, String> expectedBlogData;

    public SubnavigationBlogAction()
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
            blog = subnavigation.clickLinkBlog();
            expectedBlogData = testCaseData.get("Blog");
            AutomationLog.info("Redirection to Blog page sucessfull");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Redirection to Blog page failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyBlogPagePrimaryContents();
/*        Assert.assertEquals(blog.currentURL(), expectedBlogData.get("blogUrl"), "Link did not redirect to correct Page Url");
        AutomationLog.info("Link redirects to correct Page Url");

        Assert.assertEquals(blog.currentPageTitle(), expectedBlogData.get("title"), "Page does not show correct Page Title");
        AutomationLog.info("Page shows correct Page Title");*/

        AutomationLog.info("Blog Page is correctly loaded");
    }

    public void verifyBlogPagePrimaryContents() throws Exception 
    {
        Assert.assertEquals(blog.currentURL(), expectedBlogData.get("blogUrl"), "Link did not redirect to correct Page Url");
        AutomationLog.info("Link redirects to correct Page Url");

        Assert.assertEquals(blog.currentPageTitle(), expectedBlogData.get("title"), "Page does not show correct Page Title");
        AutomationLog.info("Page shows correct Page Title");
    }

    @Override
    protected String successMessage()
    {
        return "Blog link in Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for Blog link in Subnavigation Failed";
    }
}
