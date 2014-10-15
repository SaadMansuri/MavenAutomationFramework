package com.agorafy.automation.testcases.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Blog;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

/**
 * Test whether 'Blog' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 *
 */

public class SubnavigationBlogAction extends AutomationTestCaseVerification
{
    public SubnavigationBlogAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        SubNavigation subnavigation = Page.subNavigation();
        HashMap<String, String> blogExpectedData = testCaseData.get("blog");
        
        Blog blog = subnavigation.clickLinkBlog();
        Assert.assertEquals(blog.currentURL(), blog.blogPageUrl(), "Agorafy Blog URL is not as expected after clicking the link.");
        Assert.assertEquals(blog.currentPageTitle(), blogExpectedData.get("title"), "Agorafy Blog title does not match to the expected");
        AutomationLog.info("Agorafy Blog is correctly loaded");
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
