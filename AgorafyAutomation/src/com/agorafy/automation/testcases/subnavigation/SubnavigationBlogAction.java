package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Blog;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.ContentPagesVerification;

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
    public SubnavigationBlogAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        Blog blog = subnavigation.clickLinkBlog();

        Assert.assertEquals(blog.currentURL(), blog.blogPageUrl(), "Link did not redirect to correct Page Url");
        AutomationLog.info("Link redirects to correct Page Url");

        HashMap<String, String> expectedBlogData = testCaseData.get("Blog");
        Assert.assertEquals(blog.currentPageTitle(), expectedBlogData.get("title"), "Page does not show correct Page Title");
        AutomationLog.info("Page shows correct Page Title");

        AutomationLog.info("Blog Page is correctly loaded");
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
