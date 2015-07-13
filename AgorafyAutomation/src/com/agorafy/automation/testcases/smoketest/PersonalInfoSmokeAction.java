package com.agorafy.automation.testcases.smoketest;

import com.agorafy.automation.datamodel.profile.UserProfile;
import com.agorafy.automation.testcases.accountsettings.PersonalInfoPositiveAction;

public class PersonalInfoSmokeAction extends PersonalInfoPositiveAction
{
    public PersonalInfoSmokeAction()
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
        UserProfile profileData = getUserProfileData();
        populateFields( profileData);

        verifyNameAfterSavingForm(profileData);
    }

}
