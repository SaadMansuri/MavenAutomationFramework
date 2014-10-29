package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationAboutUsAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationAdvancedSearchAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationBlogAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationCareersAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationContactAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationFaqAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationHowItWorksAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationMemberBenefitAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationSearchProfessionalsAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationSearchPropertiesAction;

/**
 * Test the links present in the subnavigation bar
 */

public class SubNavigationTest
{
    @BeforeSuite
    public void Init() throws Exception
    {
        String globalConfigureationFileWithPath = "src/com/agorafy/automation/configuration/config.properties";
        AutomationFramework.initWithGlobalConfiguration(globalConfigureationFileWithPath);
    }

    @Test
    public void testAboutUsLink() throws Exception
    {
        try
        {
            new SubnavigationAboutUsAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testBlogLink() throws Exception
    {
        try
        {
            new SubnavigationBlogAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testCareersLink() throws Exception
    {
        try
        {
            new SubnavigationCareersAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testContactLink() throws Exception
    {
        try
        {
            new SubnavigationContactAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testFAQLink() throws Exception
    {
        try
        {
            new SubnavigationFaqAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testHowItWorksLink() throws Exception
    {
        try
        {
            new SubnavigationHowItWorksAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testMemberBenefitLink() throws Exception
    {
        try
        {
            new SubnavigationMemberBenefitAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testSearchProfessionalsLink() throws Exception
    {
        try
        {
            new SubnavigationSearchProfessionalsAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testSearchPropertiesLink() throws Exception
    {
        try
        {
            new SubnavigationSearchPropertiesAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testAdvancedSearchLink() throws Exception
    {
        try
        {
            new SubnavigationAdvancedSearchAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }
}
