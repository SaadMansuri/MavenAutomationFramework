package com.agorafy.automation.testcases.smoketest;

import java.util.HashMap;

import com.agorafy.automation.testcases.SearchProfessionalsAction;

public class SearchProfessionalsSmokeAction extends SearchProfessionalsAction
{
    public SearchProfessionalsSmokeAction()
    {
        super("SearchProfessionalsAction");
    }

    @Override
    public void setup()
    {
        super.setup();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        HashMap<String, String> agentName = testCaseData.get("agentName");
        verifyAgentExcusiveListingsCount(agentName);
    }

    @Override
    protected String successMessage()
    {
        return "passed";
    }

    @Override
    protected String failureMessage()
    {
        return "failed";
    }

}
