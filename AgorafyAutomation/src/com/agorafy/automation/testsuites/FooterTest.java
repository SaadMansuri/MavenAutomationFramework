package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.testcases.footer.FooterAboutUsAction;
import com.agorafy.automation.testcases.footer.FooterBlogAction;
import com.agorafy.automation.testcases.footer.FooterCareersAction;
import com.agorafy.automation.testcases.footer.FooterCompanyInfoAction;
import com.agorafy.automation.testcases.footer.FooterContactAction;
import com.agorafy.automation.testcases.footer.FooterFAQsAction;
import com.agorafy.automation.testcases.footer.FooterFeedbackAction;
import com.agorafy.automation.testcases.footer.FooterHowItWorksAction;
import com.agorafy.automation.testcases.footer.FooterMembershipBenefitsAction;
import com.agorafy.automation.testcases.footer.FooterPressAction;
import com.agorafy.automation.testcases.footer.FooterPrivacyPolicyAction;
import com.agorafy.automation.testcases.footer.FooterSocialLinksAction;
import com.agorafy.automation.testcases.footer.FooterTeamAction;
import com.agorafy.automation.testcases.footer.FooterTermsAndConditionAction;

public class FooterTest
{
    @BeforeSuite
    public void Init()
    {
        // TODO: Move this to some TestNg XML configuration file, so that we can set config file path
        // when running in headless mode.
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test
    public void testFooterAboutUs() throws Exception
    {
        try
        {
            new FooterAboutUsAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }

    @Test
    public void testFooterMembershipBenefits() throws Exception
    {
        try
        {
            new FooterMembershipBenefitsAction().Execute();
        }
        catch (Exception e)
        {
            // This will print the error log message
            AutomationLog.error(e.getMessage());
            // Again throwing the exception to fail the test completely in the TestNG results
            throw (e);
        }
    }

    @Test
    public void testFooterTeam() throws Exception
    {
        try
        {
            new FooterTeamAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }

    @Test
    public void testFooterCareers() throws Exception
    {
        try
        {
            new FooterCareersAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }

    @Test
    public void testFooterContact() throws Exception
    {
        try
        {
            new FooterContactAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }

    @Test
    public void testFooterHowItWorks() throws Exception
    {
        try
        {
            new FooterHowItWorksAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }

    @Test
    public void testFooterBlog() throws Exception
    {
        try
        {
            new FooterBlogAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }

    @Test
    public void testFooterPress() throws Exception
    {
        try
        {
            new FooterPressAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }

    @Test
    public void testFooterFAQs() throws Exception
    {
        try
        {
            new FooterFAQsAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }

    @Test
    public void testFooterFeedback() throws Exception
    {
        try
        {
            new FooterFeedbackAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }

    @Test
    public void testFooterTermsAndCondition() throws Exception
    {
        try
        {
            new FooterTermsAndConditionAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }

    @Test
    public void testFooterPrivacyPolicy() throws Exception
    {
        try
        {
            new FooterPrivacyPolicyAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }

    @Test
    public void testFooterSocialLinks() throws Exception
    {
        try
        {
            new FooterSocialLinksAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }

    @Test
    public void testFooterCompanyInfo() throws Exception
    {
        try
        {
            new FooterCompanyInfoAction().Execute();
        }
        catch(Exception e)
        {
            AutomationLog.error(e.getMessage());
            throw(e);
        }
    }
}