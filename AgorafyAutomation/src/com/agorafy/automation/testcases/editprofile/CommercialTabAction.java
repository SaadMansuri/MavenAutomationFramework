package com.agorafy.automation.testcases.editprofile;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.editprofile.CommercialTab;
import com.agorafy.automation.pageobjects.Page;

/**
 * To Test Commercial Tab on Edit/View profile  Page
 * Precondition : Page redirected to Edit/View profile  Page
 * Commercial Tab is present
 * verify Exclusive Tenant representation text area takes only 1000 characters
 * verify Less character input user can add upto 1000 characters 
 * verify save button functionality Characters remaining increases or decreases as character are added or removed from Exclusive Tenant representation text area 
 */
public class CommercialTabAction extends OverviewTabAction
{
    private CommercialTab commercial;

    public CommercialTabAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        try
        {
            commercial = new CommercialTab(Page.driver);
            super.setup();
            commercial.clickOnCommercialTab();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        HashMap<String, String> tenantText = testCaseData.get("TenantText");
        verifyIfSuccessMessageShownOnMarkingCheckboxesInAreasOfExpertiseAndClickedOnSaveButton();
        verifyIfSuccessMessageShownOnMarkingCheckboxesInAreasOfFocusAndClickedOnSaveButton();
        verifyIfMoreThanThousandCharactersCanbeAddedInExclusiveTenantTextBox(commercial,tenantText);
        verifyIfLessThanThousandCharactesInExclusiveTenantTextBoxAddsRemainingCharacters(commercial,tenantText);
        verifyIfMoreThanThousandCharactersCanbeAddedInTenantRequirementsTextBox(commercial,tenantText);
        verifyIfLessThanThousandCharactesInTenantRequirementsTextBoxAddsRemainingCharacters(commercial,tenantText);
        verifyIfAddOrRemoveCharacterFromExclusiveTenantRepresentationTextBoxChangesCharactersRemaining(commercial,tenantText);
        verifyIfAddOrRemoveCharacterFromTenantRequirementsTextBoxChangesCharactersRemaining(commercial,tenantText);
        verifyIfCharacterRemainingShowsSameNoOfRemainingCharactersForExclusiveTenantAndSuccessMessageAfterSave(commercial,tenantText);
        verifyIfCharacterRemainingShowsSameNoOfRemainingCharactersForTenantRequirementAndSuccessMessageAfterSave(commercial,tenantText);
        
    }

    public void verifyIfMoreThanThousandCharactersCanbeAddedInExclusiveTenantTextBox(CommercialTab commercial,HashMap<String, String> tenantText) throws Exception
    {
        commercial.txtbx_ExclusiveTenantRepresentation().clear();
        commercial.enterTextInExclusiveTenantRepresentationTextBox(tenantText.get("text"));
        String str2 = commercial.txtbx_ExclusiveTenantRepresentation().getAttribute("value");
        String ch = "x";
        commercial.enterTextInExclusiveTenantRepresentationTextBox(ch);
        String str = commercial.txtbx_ExclusiveTenantRepresentation().getAttribute("value");
        String str1 = str2 + ch;
        Assert.assertEquals(str.equalsIgnoreCase(str1), false, "More than Thousand characters can be entered in Exclusive tenant Representation text box ");
        AutomationLog.info("Could not enter more than thousand characters in Exclusive tenant representation textbox is Successfull ");
        
    }

    public void verifyIfLessThanThousandCharactesInExclusiveTenantTextBoxAddsRemainingCharacters(CommercialTab commercial,HashMap<String, String> tenantText) throws Exception
    {
        commercial.txtbx_ExclusiveTenantRepresentation().clear();
        commercial.enterTextInExclusiveTenantRepresentationTextBox(tenantText.get("text").substring(0, 990));
        String charsRemaining = commercial.txt_CharactersRemainingExclusiveTenant().getText();
        Assert.assertEquals(charsRemaining, "10", "Expected characters remaining is wrong");
        AutomationLog.info("Check for If less than thousand charactes entered, shows no of characters remaining is Successfull");
        commercial.enterTextInExclusiveTenantRepresentationTextBox(tenantText.get("text").substring(990, 1000));
        charsRemaining = commercial.txt_CharactersRemainingExclusiveTenant().getText();
        Assert.assertEquals(charsRemaining, "0", "Expected characters remaining is wrong");
        AutomationLog.info("Check for If no of characters remaining accepts same no of characters  is Successfull");
    }

    public void verifyIfMoreThanThousandCharactersCanbeAddedInTenantRequirementsTextBox(CommercialTab commercial,HashMap<String, String> tenantText) throws Exception
    {
        commercial.txtbx_TenantRequirements().clear();
        commercial.enterTextInTenantRequirementsTextBox(tenantText.get("text"));
        String str2 = commercial.txtbx_TenantRequirements().getAttribute("value");
        String ch = "x";
        commercial.enterTextInTenantRequirementsTextBox(ch);
        String str = commercial.txtbx_TenantRequirements().getAttribute("value");
        String str1 = str2 + ch;
        Assert.assertEquals(str.equalsIgnoreCase(str1), false, "More than Thousand characters can be entered in Tenant Requirements Text box ");
        AutomationLog.info("Could not enter more than thousand characters in Tenant Requirements textbox is Successfull ");
        
    }

    public void verifyIfLessThanThousandCharactesInTenantRequirementsTextBoxAddsRemainingCharacters(CommercialTab commercial,HashMap<String, String> tenantText) throws Exception
    {
        commercial.txtbx_TenantRequirements().clear();
        commercial.enterTextInTenantRequirementsTextBox(tenantText.get("text").substring(0, 990));
        String charsRemaining = commercial.txt_CharactersRemainingTenantRequirement().getText();
        Assert.assertEquals(charsRemaining, "10", "Expected characters remaining is wrong");
        AutomationLog.info("Check for If less than thousand charactes entered, shows no of characters remaining is Successfull");
        commercial.enterTextInTenantRequirementsTextBox(tenantText.get("text").substring(990, 1000));
        charsRemaining = commercial.txt_CharactersRemainingTenantRequirement().getText();
        Assert.assertEquals(charsRemaining, "0", "Expected characters remaining is wrong");
        AutomationLog.info("Check for If no of characters remaining accepts same no of characters  is Successfull");
    }

    public void verifyIfAddOrRemoveCharacterFromExclusiveTenantRepresentationTextBoxChangesCharactersRemaining(CommercialTab commercial,HashMap<String, String> tenantText) throws Exception
    {
    	commercial.txtbx_ExclusiveTenantRepresentation().clear();
        commercial.enterTextInExclusiveTenantRepresentationTextBox(tenantText.get("text").substring(0,100));
        String charsRemaining = commercial.txt_CharactersRemainingExclusiveTenant().getText();
        Assert.assertEquals(charsRemaining, "900", "Expected characters remaining decrease is failed");
        AutomationLog.info("Check for If adding charactes decrease no of characters remaining is Successfull");
        commercial.RemoveCharactersFromExclusiveTenantRepresentationTextBox(10);
        charsRemaining = commercial.txt_CharactersRemainingExclusiveTenant().getText();
        Assert.assertEquals(charsRemaining, "910", "Expected characters remaining increase is failed");
        AutomationLog.info("Check for If removing charactes increase no of characters remaining is Successfull");
    }

    public void verifyIfAddOrRemoveCharacterFromTenantRequirementsTextBoxChangesCharactersRemaining(CommercialTab commercial,HashMap<String, String> tenantText) throws Exception
    {
    	commercial.txtbx_TenantRequirements().clear();
        commercial.enterTextInTenantRequirementsTextBox(tenantText.get("text").substring(0,100));
        String charsRemaining = commercial.txt_CharactersRemainingTenantRequirement().getText();
        Assert.assertEquals(charsRemaining, "900", "Expected characters remaining decrease is failed");
        AutomationLog.info("Check for If adding charactes decrease no of characters remaining is Successfull");
        commercial.RemoveCharactersFromTenantRequirementsTextBox(10);
        charsRemaining = commercial.txt_CharactersRemainingTenantRequirement().getText();
        Assert.assertEquals(charsRemaining, "910", "Expected characters remaining increase is failed");
        AutomationLog.info("Check for If removing charactes increase no of characters remaining is Successfull");
    }

    public void verifyIfCharacterRemainingShowsSameNoOfRemainingCharactersForExclusiveTenantAndSuccessMessageAfterSave(CommercialTab commercial,HashMap<String, String> tenantText) throws Exception
    {
    	commercial.txtbx_ExclusiveTenantRepresentation().clear();
        commercial.enterTextInExclusiveTenantRepresentationTextBox(tenantText.get("text").substring(0,100));
        String charsRemaining = commercial.txt_CharactersRemainingExclusiveTenant().getText();
        commercial.clickOnSaveButton();
        String msg = commercial.msg_Success().getText();
        String charRemainingAfterSave = commercial.txt_CharactersRemainingExclusiveTenant().getText();
        Assert.assertEquals(charsRemaining.equalsIgnoreCase(charRemainingAfterSave), true, "Characters remaining After save is not same ");
        Assert.assertEquals(msg, "Success!", "Expected Success Message is not shown");
        AutomationLog.info("Characters remaining is same after save for Exclusive Tenant representation is Successfull");
        AutomationLog.info("Success message is shown After save ");
    }

    public void verifyIfCharacterRemainingShowsSameNoOfRemainingCharactersForTenantRequirementAndSuccessMessageAfterSave(CommercialTab commercial,HashMap<String, String> tenantText) throws Exception
    {
    	commercial.txtbx_TenantRequirements().clear();
        commercial.enterTextInTenantRequirementsTextBox(tenantText.get("text").substring(0,100));
        String charsRemaining = commercial.txt_CharactersRemainingTenantRequirement().getText();
        commercial.clickOnSaveButton();
        String msg = commercial.msg_Success().getText();
        String charRemainingAfterSave = commercial.txt_CharactersRemainingTenantRequirement().getText();
        Assert.assertEquals(charsRemaining.equalsIgnoreCase(charRemainingAfterSave), true, "Characters remaining After save is not same ");
        Assert.assertEquals(msg, "Success!", "Expected Success Message is not shown");
        AutomationLog.info("Characters remaining is same after save for Tenant Requirements is Successfull");
        AutomationLog.info("Success message is shown After save ");
    }

    public void verifyIfSuccessMessageShownOnMarkingCheckboxesInAreasOfExpertiseAndClickedOnSaveButton() throws Exception
    {
        commercial.markCheckBoxInAreasOFExpertise();
        commercial.clickOnSaveButton();
        String msg = commercial.msg_Success().getText();
        Assert.assertEquals(msg, "Success!", "Expected Success Message is not shown");
        AutomationLog.info("Success message is shown After marking checkboxes in areas of expertise and clicked on save button ");
    }
    public void verifyIfSuccessMessageShownOnMarkingCheckboxesInAreasOfFocusAndClickedOnSaveButton() throws Exception
    {
        commercial.markCheckBoxInAreasOFFocus();
        commercial.clickOnSaveButton();
        String msg = commercial.msg_Success().getText();
        Assert.assertEquals(msg, "Success!", "Expected Success Message is not shown");
        AutomationLog.info("Success message is shown After marking checkboxes in areas of focus and clicked on save button ");
    }
}
