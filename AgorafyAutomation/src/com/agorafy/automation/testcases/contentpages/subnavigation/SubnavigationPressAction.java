package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.support.Press;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

public class SubnavigationPressAction extends ContentPagesVerification 
{
    private SubNavigation subnavigation;
	private Press Press;
	private HashMap<String, String> expectedPressData;

	public SubnavigationPressAction() 
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        subnavigation = Page.subNavigation();
        String dropdownMoreOption = "Press";
        Press = (Press) subnavigation.selectDropdownMoreOption(dropdownMoreOption);
        expectedPressData = testCaseData.get("More->PressPageData");
        expectedPressData.put("url", Press.pressPageUrl());
        verifyLink(Press, expectedPressData);
    }

    @Override
    protected String successMessage()
    {
        return "Press link on Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Press link Test Failed ";
    }
}
