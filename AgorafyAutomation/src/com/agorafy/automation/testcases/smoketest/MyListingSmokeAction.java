package com.agorafy.automation.testcases.smoketest;

import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.testcases.contentpages.subnavigation.MyListingsAction;

public class MyListingSmokeAction extends MyListingsAction
{
    public MyListingSmokeAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        Page.scrollPage(0, 300);
        verifyUpdateListingLink();
        verifyAddMediaLink();
    }
}
