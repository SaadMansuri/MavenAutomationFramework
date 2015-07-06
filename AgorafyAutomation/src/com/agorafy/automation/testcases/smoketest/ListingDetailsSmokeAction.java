package com.agorafy.automation.testcases.smoketest;

import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.testcases.upsellpopups.ListingDetailPageAction;

public class ListingDetailsSmokeAction extends ListingDetailPageAction
{
    public ListingDetailsSmokeAction()
    {
        super("ListingDetailPageAction");
    }

    @Override
    public void setup()
    {
        super.setup();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        Credentials validCredentials = userCredentials();
        verifySubscribeToListingLinkUpsell(validCredentials);
    }
}
