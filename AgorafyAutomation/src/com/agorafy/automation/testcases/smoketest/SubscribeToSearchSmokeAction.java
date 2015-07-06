package com.agorafy.automation.testcases.smoketest;

import com.agorafy.automation.testcases.subscriptions.SubscribeToSearchAction;

public class SubscribeToSearchSmokeAction extends SubscribeToSearchAction
{
    public SubscribeToSearchSmokeAction()
    {
        super("SubscribeToSearchAction");
    }

    @Override
    public void setup()
    {
        super.setup();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifySubscriptionBoxDisplay();
        verifySearchTerm();
    }
}
