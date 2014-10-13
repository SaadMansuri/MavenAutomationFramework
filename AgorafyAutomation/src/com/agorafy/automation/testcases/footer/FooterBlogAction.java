package com.agorafy.automation.testcases.footer;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Blog;
import com.agorafy.automation.pageobjects.footer.FooterSupportLinks;
/**
 * Test Blog link on Footer
 * Click Blog link on the Home Page, verify Blog Page is loaded 
 * Verify the URL of Blog Page
 * Verify the title of Blog Page * 
 */
public class FooterBlogAction extends AutomationTestCaseVerification
{
    public FooterBlogAction()
    {
        super();
    }

    @Override
	protected void verifyTestCases()
    {
        FooterSupportLinks supportLinks = Page.footer().supportLinks();
        Blog blog = null;
        try
        {
            blog = supportLinks.clickOnBlogLink();
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