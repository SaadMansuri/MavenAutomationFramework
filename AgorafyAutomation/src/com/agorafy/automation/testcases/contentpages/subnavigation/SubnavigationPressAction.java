package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.support.Press;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

public class SubnavigationPressAction extends ContentPagesVerification 
{
    private SubNavigation subnavigation;
	private Press Press;
	private HashMap<String, String> expectedPressData;
	private ContentPagesLeftMenu leftMenu;
	private String actualActiveLeftMenu;
	private String expectedActiveLeftMenu;

	public SubnavigationPressAction() 
    {
        super();
    }

    @Override
    public void setup() 
    {
        super.setup();
        try 
        {
            subnavigation = Page.subNavigation();
            String dropdownMoreOption = "Press";
            Press = (Press) subnavigation.selectDropdownMoreOption(dropdownMoreOption);
            expectedPressData = testCaseData.get("Press");
            String url = Press.getApplicationUrl() + expectedPressData.get("pressPageUrl");
            expectedPressData.put("url", url);
            AutomationLog.info("Redirection to Press page passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Redirection to Press page failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyLink(Press, expectedPressData);

        AutomationLog.info("Testing whether Press link is active in left side started...");
        verifyLeftMenu();
    }

    private void verifyLeftMenu() throws Exception 
    {
        leftMenu = Page.contentPagesLeftMenu();
        actualActiveLeftMenu = leftMenu.getCurrentlyActiveLink();
        expectedActiveLeftMenu = leftMenu.PressLinkText();  
        Assert.assertEquals(actualActiveLeftMenu, expectedActiveLeftMenu,"Left menu does not show Press link as Active Link");
        AutomationLog.info("Left menu shows Press link as Active Link");
    }

    @Override
    protected String successMessage()
    {
        return "Press link on Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Press link Testing Failed ";
    }
}
