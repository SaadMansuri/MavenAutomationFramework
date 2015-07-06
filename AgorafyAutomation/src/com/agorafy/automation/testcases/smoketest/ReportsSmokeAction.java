package com.agorafy.automation.testcases.smoketest;

import com.agorafy.automation.testcases.reports.ReportsAction;

public class ReportsSmokeAction extends ReportsAction
{
    public ReportsSmokeAction()
    {
        super("ReportsAction");
    }

    @Override
    public void setup()
    {
        super.setup();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifySearchResultPageTestCases();
    }

    public void verifySearchResultPageTestCases() throws Exception
    {
        verifyIfClickedOnPinCushionReportIcon();
        verifyIfClickedOnFixedPinCushionReportIcon();
        verifyIfMoreThanFifteenListingAdded();
    }
}
