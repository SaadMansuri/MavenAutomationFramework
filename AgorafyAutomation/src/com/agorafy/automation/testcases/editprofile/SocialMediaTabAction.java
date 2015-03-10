package com.agorafy.automation.testcases.editprofile;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.editprofile.SocialMediaTab;

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
        verifyIfTweeterProfileTextBoxAcceptAllCharactersAsInput();
        verifyIfSuccessMessageShownOnEnteringTwitterProfileAndClickedOnSaveButton();
    }

    public void verifyIfSuccessMessageShownOnEnteringTwitterProfileAndClickedOnSaveButton() throws Exception
    {
        HashMap<String, String> profile = testCaseData.get("validTwitterProfile");
        socialmedia.validTwitterProfileName(profile.get("profileName"));
        socialmedia.clickOnSaveButton();
        String msg = socialmedia.msg_Success().getText();
        Assert.assertEquals(msg, "Success!", "Expected Success Message is not shown");
        AutomationLog.info("Success message is shown on entering twitter profile and clicked on save button ");
    }

    public void verifyIfTweeterProfileTextBoxAcceptAllCharactersAsInput() throws Exception
    {
    	HashMap<String, String> profile = testCaseData.get("TweeterInput");
        socialmedia.validTwitterProfileName(profile.get("username"));
        socialmedia.clickOnSaveButton();
        String msg = socialmedia.msg_Success().getText();
        Assert.assertEquals(msg, "Success!", "Expected Success Message is not shown");
        AutomationLog.info("Twitter profile text box accepts all characters as input");
    }
}
