package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.SocialMediaTab;

public class SocialMediaTabAction extends OverviewTabAction
{
    private SocialMediaTab socialmedia;
    public SocialMediaTabAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        try
        {
            socialmedia = new SocialMediaTab(Page.driver);
            super.setup();
            socialmedia.clickOnSocialMediaTab();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyIfSuccessMessageShownOnEnteringTwitterProfileAndClickedOnSaveButton();
    }


    public void verifyIfSuccessMessageShownOnEnteringTwitterProfileAndClickedOnSaveButton() throws Exception
    {
        HashMap<String, String> profile = testCaseData.get("validTwitterProfile");
        socialmedia.validTwitterProfileName(profile.get("profileName"));
        String msg = socialmedia.msg_Success().getText();
        Assert.assertEquals(msg, "Success!", "Expected Success Message is not shown");
        AutomationLog.info("Success message is shown on entering twitter profile and clicked on save button ");
    }

}