package com.agorafy.automation.testcases.smoketest;

import com.agorafy.automation.testcases.showings.FrontEndShowingsAction;

public class ShowingsSmokeAction extends FrontEndShowingsAction
{
    public ShowingsSmokeAction()
    {
        super("FrontEndShowingsAction");
    }

    @Override
    public void setup()
    {
        super.setup();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyIfClickedOnScheduleNowLink();
        verifyIfAddedShowingIsSeenOnListingDetailsPage();
        verifyUpcomingShowingsCountOnAddingShowing();
        verifyUpcomingShowingsCountOnDeletingShowings();
    }
}
