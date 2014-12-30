package com.agorafy.automation.testcases;


import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.ResidentialTab;


public class ResidentialTabAction extends OverviewTabAction
{
    private ResidentialTab residential;
    public ResidentialTabAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        try
        {
        	residential = new ResidentialTab(Page.driver);
            super.setup();
            residential.clickOnResidentialTab();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyIfSuccessMessageShownOnMarkingCheckboxesInAreasOfExpertiseAndClickedOnSaveButton();  
        verifyIfSuccessMessageShownOnMarkingCheckboxesInAreasOfFocusAndClickedOnSaveButton();
    }

    public void verifyIfSuccessMessageShownOnMarkingCheckboxesInAreasOfExpertiseAndClickedOnSaveButton() throws Exception
    {
    	residential.markAllCheckboxesInAreasofExpertise();
    	residential.clickOnSaveButton();
        String msg = residential.msg_Success().getText();
        Assert.assertEquals(msg, "Success!", "Expected Success Message is not shown");
        AutomationLog.info("Success message is shown After marking checkboxes in areas of expertise and clicked on save button ");
    }
    public void verifyIfSuccessMessageShownOnMarkingCheckboxesInAreasOfFocusAndClickedOnSaveButton() throws Exception
    {
    	residential.markAllCheckboxesInAreasofFocus();
    	residential.clickOnSaveButton();
        String msg = residential.msg_Success().getText();
        Assert.assertEquals(msg, "Success!", "Expected Success Message is not shown");
        AutomationLog.info("Success message is shown After marking checkboxes in areas of focus and clicked on save button ");
    }
}
