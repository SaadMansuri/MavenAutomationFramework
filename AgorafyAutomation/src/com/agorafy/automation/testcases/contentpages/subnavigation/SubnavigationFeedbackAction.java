package com.agorafy.automation.testcases.contentpages.subnavigation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.ContentPagesLeftMenu;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.support.Feedback;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;


public class SubnavigationFeedbackAction extends ContentPagesVerification 
{

    private SubNavigation subnavigation;
    private Feedback feedback;
    private HashMap<String, String> expectedFeedbackData;
    private ContentPagesLeftMenu leftMenu;
    private String actualActiveLeftMenu;
    private String expectedActiveLeftMenu;

    public SubnavigationFeedbackAction() 
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
            String dropdownMoreOption = "Feedback";
            feedback = (Feedback) subnavigation.selectDropdownMoreOption(dropdownMoreOption);
            expectedFeedbackData = testCaseData.get("More->FeedbackPageData");
            expectedFeedbackData.put("url", feedback.feedbackPageUrl());
            AutomationLog.info("Redirection to feedback page sucessfull");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Redirection to feedback page failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        verifyLink(feedback, expectedFeedbackData);

        AutomationLog.info(" testing of dropdown options for subject started...");
        testSubjectDropdown();

        AutomationLog.info("negative form fill up sarted....");
        testNegativeFormFillup();

        AutomationLog.info("positive form fill up sarted....");
        testPositiveFormFillup();

        AutomationLog.info("Testing whether Feedback link is active in left side started...");
        verifyLeftMenu();
    }

    private void testPositiveFormFillup() throws Exception 
    {
        clearFeedbackForm();
        expectedFeedbackData = testCaseData.get("FeedbackFormTotalData");
        fillFeedbackForm(expectedFeedbackData);
        feedback.clickSubmitFeedback();
        String successMsg = feedback.string_successMsgOfFormFillUp();
        expectedFeedbackData = testCaseData.get("SuccessMsg");
        Assert.assertEquals(successMsg, expectedFeedbackData.get("SuccessMsgForFeedbackForm"), "Success msg for feedback form fill up is not displayed as expected:");
        AutomationLog.info("Success msg for feedback form fill up is seen as expected");

    }

    private void verifyLeftMenu() throws Exception 
    {
        leftMenu = Page.contentPagesLeftMenu();
        actualActiveLeftMenu = leftMenu.getCurrentlyActiveLink();
        expectedActiveLeftMenu = leftMenu.FeedbackLinkText();  
        Assert.assertEquals(actualActiveLeftMenu, expectedActiveLeftMenu,"Left menu does not show Feedback link as Active Link");
        AutomationLog.info("Left menu shows Feedback link as Active Link");
    }

	private void testNegativeFormFillup() throws Exception 
    {
        testEmptyFormFillUp();
        testIfNameEmpty();
        testIfEmailEmpty();
        testIfSubjectEmpty();
        testIfMessageEmpty();
    }

    private void testIfMessageEmpty() throws Exception 
    {
        clearFeedbackForm();
        expectedFeedbackData = testCaseData.get("IfMessageEmpty");
        fillFeedbackForm(expectedFeedbackData);
        feedback.clickSubmitFeedback();
        String errorForMessage = feedback.string_ErrorForMessage();
        expectedFeedbackData = testCaseData.get("ErrorMessages");
        Assert.assertEquals(errorForMessage, expectedFeedbackData.get("ErrorForMessage"), "Error msg for Message is not displayed as expected:");
        AutomationLog.info("Error msg is seen for Message as expected");

        AutomationLog.info("Error msg is seen for Message as expected in case of absent Message");
    }

	private void testIfSubjectEmpty() throws Exception 
    {
        clearFeedbackForm();
        expectedFeedbackData = testCaseData.get("IfSubjectEmpty");
        fillFeedbackForm(expectedFeedbackData);
        feedback.clickSubmitFeedback();
        String errorForSubjectDropdown = feedback.string_ErrorForSubjectDropdown();
        expectedFeedbackData = testCaseData.get("ErrorMessages");
        Assert.assertEquals(errorForSubjectDropdown, expectedFeedbackData.get("ErrorForSubjectDropdown"), "Error msg for Subject Dropdown is not displayed as expected:");
        AutomationLog.info("Error msg is seen for Subject Dropdown as expected");

        AutomationLog.info("Error msg is seen for Subject as expected in case of absent Subject");
    }

	private void testIfEmailEmpty() throws Exception 
    {
        clearFeedbackForm();
        expectedFeedbackData = testCaseData.get("IfEmailEmpty");
        fillFeedbackForm(expectedFeedbackData);
        feedback.clickSubmitFeedback();
        String errorForEmail = feedback.string_ErrorForEmail();
        errorForEmail = errorForEmail.replace("\n", " ");
        expectedFeedbackData = testCaseData.get("ErrorMessages");
        Assert.assertEquals(errorForEmail, expectedFeedbackData.get("ErrorForEmail"), "Error msg for Email is not displayed as expected:");
        AutomationLog.info("Error msg is seen for Email as expected in case of absent Email");

    }

    private void testIfNameEmpty() throws Exception 
    {
        clearFeedbackForm();
        expectedFeedbackData = testCaseData.get("IfNameEmpty");
        fillFeedbackForm(expectedFeedbackData);
        feedback.clickSubmitFeedback();
        String errorForName = feedback.string_ErrorForName();
        expectedFeedbackData = testCaseData.get("ErrorMessages");
        Assert.assertEquals(errorForName, expectedFeedbackData.get("ErrorForName"), "Error msg for Name is not displayed as expected:");
        AutomationLog.info("Error msg is seen for Name as expected in case of absent Name");
    }

    private void testEmptyFormFillUp() throws Exception 
    {
        clearFeedbackForm();
        feedback.clickSubmitFeedback();
        expectedFeedbackData = testCaseData.get("ErrorMessages");

        String errorForName = feedback.string_ErrorForName();
        Assert.assertEquals(errorForName, expectedFeedbackData.get("ErrorForName"), "Error msg for Name is not displayed as expected:");
        AutomationLog.info("Error msg is seen for Name as expected");

        String errorForEmail = feedback.string_ErrorForEmail();
        errorForEmail = errorForEmail.replace("\n", " ");
        Assert.assertEquals(errorForEmail, expectedFeedbackData.get("ErrorForEmail"), "Error msg for Email is not displayed as expected:");
        AutomationLog.info("Error msg is seen for Email as expected");

        String errorForSubjectDropdown = feedback.string_ErrorForSubjectDropdown();
        Assert.assertEquals(errorForSubjectDropdown, expectedFeedbackData.get("ErrorForSubjectDropdown"), "Error msg for Subject Dropdown is not displayed as expected:");
        AutomationLog.info("Error msg is seen for Subject Dropdown as expected");

        String errorForMessage = feedback.string_ErrorForMessage();
        Assert.assertEquals(errorForMessage, expectedFeedbackData.get("ErrorForMessage"), "Error msg for Message is not displayed as expected:");
        AutomationLog.info("Error msg is seen for Message as expected");

        AutomationLog.info("testing for empty form fill up passed");
    }

    public void fillFeedbackForm(HashMap<String, String> dataFromCSV) throws Exception 
    {
        if(dataFromCSV.get("Name") != null)
            feedback.setName(dataFromCSV.get("Name"));

        if(dataFromCSV.get("Email") != null)
            feedback.setEmail(dataFromCSV.get("Email"));

        if(dataFromCSV.get("SubjectDropdown") != null)
            feedback.selectDropdownSubject(dataFromCSV.get("SubjectDropdown"));

        if(dataFromCSV.get("Message") != null)
            feedback.setMessage(dataFromCSV.get("Message"));
    }

    private void testSubjectDropdown() throws Exception 
    {
        Collection<String> allSubjectDropdowns = new ArrayList<>();
        expectedFeedbackData = testCaseData.get("SubjectDropdownOptions");
        allSubjectDropdowns = feedback.allSubjectDropdowns();
        boolean flag = compareTwoCollections(expectedFeedbackData.values(), allSubjectDropdowns);
        Assert.assertEquals(flag, true, "Dropdown options for subject do not match as expected:");
        AutomationLog.info("Dropdown options for subject dropdown are same as expected");
    }

    public void clearFeedbackForm() throws Exception 
    {
        feedback.textBox_Name().clear();
        feedback.textBox_Email().clear();
        feedback.textBox_Message().clear();
    }

    public boolean compareTwoCollections(Collection<String> collection1, Collection<String> collection2)
    {
        boolean flag = false;
        if(collection1.size() == collection2.size())
        {
            if(collection1.containsAll(collection2) && collection2.containsAll(collection1))
            {
                 flag = true;
            }
        }
        else 
            flag = false;
        return flag;
    }

    @Override
    protected String successMessage() 
    {
         return "Tested sucessfully subnavigation feedback link";
    }

    @Override
    protected String failureMessage() 
    {
         return "Failed testing of subnavigation feedback link";
    }
}
