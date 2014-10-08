package com.agorafy.automation.testcases.footer;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterSupportLinks;
import com.agorafy.automation.pageobjects.footer.support.Blog;

public class FooterBlogAction extends FooterAction
{
    public FooterBlogAction()
    {
        super();
    }

    @Override
    void testLink()
    {
        FooterSupportLinks supportLinks = Page.footer().supportLinks();
        Blog blog = null;
        try
        {
            blog = supportLinks.openBlog();
            AutomationLog.info("Blog Page opened successfully");

            Assert.assertEquals(blog.currentURL(), blog.blogPageUrl(), "Blog Link did not Navigate to correct pageUrl");
            AutomationLog.info("Blog Link navigates to Blog URL");

            Assert.assertEquals(blog.currentPageTitle(), "Agorafy - Home", "Blog page does not show correct PageTitle");
            AutomationLog.info("Blog page shows correct page title");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either Blog page did not open successfully or Blog page verification failed" + e.getMessage());
        }
    }

    @Override
    String successMessage()
    {
        return " Footer Blog tested successfully";
    }

    @Override
    String failureMessage()
    {
        return "Footer Blog Action Failed ";
    }
}