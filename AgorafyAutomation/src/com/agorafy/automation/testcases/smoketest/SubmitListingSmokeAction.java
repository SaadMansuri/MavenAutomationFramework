package com.agorafy.automation.testcases.smoketest;

import com.agorafy.automation.testcases.submitlisting.SubmitListingPreviewAndSubmitFormAction;
public class SubmitListingSmokeAction extends SubmitListingPreviewAndSubmitFormAction
{
    public SubmitListingSmokeAction()
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
        verifyIfPreviewAndSubmitContainsAllListingForms();
        verifyDifferentFormsDataOnPreviewAndSubmitForm();
    }
}
