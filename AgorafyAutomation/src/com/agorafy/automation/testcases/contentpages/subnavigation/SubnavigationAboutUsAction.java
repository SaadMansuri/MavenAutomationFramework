package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.AboutUs;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test whether 'About Us' link appears in the subnavigation bar
 * Test whether it gets clicked
 * Test whether actual Url and expected Url are the same
 * Test whether actual Page Title and expected are the same
 * Test whether actual Page Heading and expected Heading match 
 *
 */

public class SubnavigationAboutUsAction extends ContentPagesVerification
{
    private AboutUs aboutUs;
    private HashMap<String, String> expectedAboutUsData = new HashMap<>();
	private SubNavigation subnavigation;
	private ContentPagesLeftMenu leftMenu;

	public SubnavigationAboutUsAction()
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
            aboutUs = subnavigation.clickLinkAboutUs();
            expectedAboutUsData = testCaseData.get("AboutUs");
            String url = aboutUs.getApplicationUrl() + expectedAboutUsData.get("aboutUsUrl");
            expectedAboutUsData.put("url", url);
            leftMenu = Page.contentPagesLeftMenu();
            AutomationLog.info("Redirection for About Us Page sucessfull");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Redirection for About Us Page failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        verifyLink(aboutUs, expectedAboutUsData);
        Assert.assertEquals(leftMenu.getCurrentlyActiveLink(), leftMenu.aboutUsLinkText(),"Left menu does not show About Us link as Active Link");
        AutomationLog.info("Left menu shows About Us link as Active Link");
        AutomationLog.info("AboutUs page is correctly loaded");
        verifyCategorySelectSearchBoxInAboutUsHeaderForDropDownOptions(aboutUs);
        verifySearchTextBoxInAboutUsHeader(aboutUs);
        verifyBoroughSelectSearchBoxInAboutUsHeaderForDropDownOptions(aboutUs);
    }

    public void verifyCategorySelectSearchBoxInAboutUsHeaderForDropDownOptions(AboutUs aboutUs) throws Exception
    {
        String verifyCategorySelectSearchBoxInHeaderForCommercialOption =aboutUs.clickHeaderCategorySearchBar();
        Assert.assertEquals(verifyCategorySelectSearchBoxInHeaderForCommercialOption,aboutUs.HeaderCategorySearchBar_DropDownCommercialOption(), "After click ,Fist option as Commercial is not Found in AboutUs Category Header Drop Down");
        AutomationLog.info("Commercial is Found in AboutUs Category Header Drop Down");

        String verifyCategorySelectSearchBoxInHeaderForResidentialOption = aboutUs.clickHeaderCategorySearchBar();
        Assert.assertEquals(verifyCategorySelectSearchBoxInHeaderForResidentialOption,aboutUs.HeaderCategorySearchBar__DropDownResidentialOption(), "After click ,Fist option as Residential is not Found in AboutUs Category Header Drop Down");
        AutomationLog.info("Residential is Found in AboutUs Category Header Drop Down");
    }

    public void verifySearchTextBoxInAboutUsHeader(AboutUs aboutUs) throws Exception
    {
        String verifySearchTextBoxInAboutUsHeader = aboutUs.getTextSearchBoxInput();
        Assert.assertEquals(verifySearchTextBoxInAboutUsHeader,"paris", "Didn't Found the text entered in the search text box of header for About Us Page");
        AutomationLog.info("Found the text entered in the search text box of header for About Us Page");

        String verifyDropDownTextInAboutUsHeaderSearchBox = aboutUs.getDropDownSearchBoxText();
        Assert.assertEquals(verifyDropDownTextInAboutUsHeaderSearchBox,"Find Listings", "Didn't Found the Drop Down text in the search text box of header for About Us Page");
        AutomationLog.info("Found the Drop Down text in the search text box of header for About Us Page");
    }

    public void verifyBoroughSelectSearchBoxInAboutUsHeaderForDropDownOptions(AboutUs aboutUs) throws Exception
    {
        String verifyBoroughSelectSearchBoxInHeaderForManhattanOption =aboutUs.clickHeaderBoroughSearchBarInAboutUsPage();
        Assert.assertEquals(verifyBoroughSelectSearchBoxInHeaderForManhattanOption,aboutUs.HeaderBoroughSearchBarInAboutUsPage_DropDownManhattanOption(), "Manhattan is not Found in AboutUs Borough Header Drop Down");
        AutomationLog.info("Manhattan Found in AboutUs Borough Header Drop Down");

        String verifyBoroughSelectSearchBoxInHeaderForBronxOption =aboutUs.clickHeaderBoroughSearchBarInAboutUsPage();
        Assert.assertEquals(verifyBoroughSelectSearchBoxInHeaderForBronxOption,aboutUs.HeaderBoroughSearchBarInAboutUsPage_DropDownBronxOption(), "Bronx is not Found in AboutUs Borough Header Drop Down");
        AutomationLog.info("Bronx Found in AboutUs Borough Header Drop Down");

        String verifyBoroughSelectSearchBoxInHeaderForBrooklynOption =aboutUs.clickHeaderBoroughSearchBarInAboutUsPage();
        Assert.assertEquals(verifyBoroughSelectSearchBoxInHeaderForBrooklynOption,aboutUs.HeaderBoroughSearchBarInAboutUsPage_DropDownBrooklynOption(), "Brooklyn is not Found in AboutUs Borough Header Drop Down");
        AutomationLog.info("Brooklyn Found in AboutUs Borough Header Drop Down");

        String verifyBoroughSelectSearchBoxInHeaderForQueensOption =aboutUs.clickHeaderBoroughSearchBarInAboutUsPage();
        Assert.assertEquals(verifyBoroughSelectSearchBoxInHeaderForQueensOption,aboutUs.HeaderBoroughSearchBarInAboutUsPage_DropDownQueensOption(), "Queens is not Found in AboutUs Borough Header Drop Down");
        AutomationLog.info("Queens Found in AboutUs Borough Header Drop Down");

        String verifyBoroughSelectSearchBoxInHeaderForStatenIslandOption =aboutUs.clickHeaderBoroughSearchBarInAboutUsPage();
        Assert.assertEquals(verifyBoroughSelectSearchBoxInHeaderForStatenIslandOption,aboutUs.HeaderBoroughSearchBarInAboutUsPage_DropDownStatenIslandOption(), "StatenIsland is not Found in AboutUs Borough Header Drop Down");
        AutomationLog.info("StatenIsland Found in AboutUs Borough Header Drop Down");
    }

    @Override
    protected String successMessage()
    {
        return "About Us link in Subnavigation tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Test for About Us link in Subnavigation Failed";
    }
}
