package com.agorafy.automation.testcases.smoketest;

import com.agorafy.automation.testcases.subscriptions.SubscribeToListingAction;

public class SubscribeToListingSmokeAction extends SubscribeToListingAction
{
    public SubscribeToListingSmokeAction()
    {
        super("SubscribeToListingAction");
    }

    @Override
    public void setup()
    {
        super.setup();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifySubscribeToListingOption();
        verifyListingNameInSubscriptionWindow();
    }
}
