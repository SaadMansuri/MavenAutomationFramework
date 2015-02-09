package com.agorafy.automation.testcases.contentpages.subnavigation;

import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

public class MyListingsAction extends ContentPagesVerification 
{

    @Override
    protected void verifyTestCases() throws Exception 
    {
        
		
    }

    @Override
    protected String successMessage() 
    {
        return "Sucessfully tested My Listing page";
    }

    @Override
    protected String failureMessage() 
    {
        return "Failed to test My listing page";
    }

}
