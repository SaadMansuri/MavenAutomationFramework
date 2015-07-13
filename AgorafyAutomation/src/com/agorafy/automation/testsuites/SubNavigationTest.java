package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.Init;
import com.agorafy.automation.testcases.contentpages.subnavigation.MyDashboardAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationAboutUsAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationAdvancedSearchAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationBlogAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationCareersAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationContactAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationEditProfileAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationFaqAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationFeedbackAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationHowItWorksAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationMemberBenefitAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationMyListingAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationMySubscriptionsAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationPressAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationSearchProfessionalsAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationSearchPropertiesAction;
import com.agorafy.automation.testcases.contentpages.subnavigation.SubnavigationTeamAction;

/**
 * Test the links present in the subnavigation bar in Logged in logged out states
 */

public class SubNavigationTest
{
    @BeforeSuite
    public void Init()
    {
        Init.globalConfiguration();
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

    @Test
    public void testMoreLink() throws Exception
    {
        try
        {
            new SubnavigationTeamAction().Execute();
            new SubnavigationCareersAction().Execute();
            new SubnavigationPressAction().Execute();
            new SubnavigationFeedbackAction().Execute();
            new SubnavigationContactAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testMyDashboardLink() throws Exception
    {
        try
        {
            new MyDashboardAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testMyListingLink() throws Exception
    {
        try
        {
            new SubnavigationMyListingAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testMySubscriptionsLink() throws Exception
    {
        try
        {
            new SubnavigationMySubscriptionsAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

    @Test
    public void testEditProfileLink() throws Exception
    {
        try
        {
            new SubnavigationEditProfileAction().Execute();
        }
        catch(Exception e)
        {
            throw(e);
        }
    }

}
