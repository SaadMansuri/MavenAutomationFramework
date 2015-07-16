package com.agorafy.automation.testcases.smoketest;

import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.datamodel.profile.UserProfile;
import com.agorafy.automation.testcases.editprofile.OverviewTabAction;

public class EditProfileOverviewSmokeAction extends OverviewTabAction
{

	public EditProfileOverviewSmokeAction()
    {
        super("OverviewTabAction");
    }

    @Override
    public void setup()
    {
        super.setup();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        UserProfile userData = getTestOverviewData();
        populateOverivewData(userData);
        WaitFor.sleepFor(5000);

        verifyUpdatedOverviewBanner(userData);
        verifyUpdatedOverviewTabForm(userData);

    }
}
