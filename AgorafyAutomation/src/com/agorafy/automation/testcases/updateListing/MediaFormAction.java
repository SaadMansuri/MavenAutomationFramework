package com.agorafy.automation.testcases.updateListing;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Configuration;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.HeaderLoginForm;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.updatelisting.*;
//import com.agorafy.automation.pageobjects.submitlisting.SubmitListingContactsFormPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.MyListings;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;
import com.agorafy.automation.utilities.HandlingWindows;

public class MediaFormAction extends AutomationTestCaseVerification
{

    private Homepage homePage;
    private Header header;
    private HeaderLoginForm headerLoginForm;
    private SubNavigation subNavigation;
    private MyListings myListings;
    private AvailabilityAndDetailsForm updateListingPage;
    private MediaForm media; 
    private AvailabilityAndDetailsForm details ;
    public String exefilepath = Configuration.getConfigurationValueForProperty("exe-path-to-upload");
    HashMap<String, String> mediadata = new HashMap<>();
    ContactsForm contactsPage;

    public MediaFormAction() 
    {
        super("UpdateListing");
    }

    @Override
    public void setup() 
    {
        super.setup();
        AutomationLog.info("Setup to reach Media page of the user started...");
        try 
        {
            homePage = Homepage.homePage();
            header = Header.header();
            headerLoginForm = header.openHeaderLoginForm();
            Credentials ValidCredentials = userCredentials();
            homePage = headerLoginForm.doSuccessfulLogin(ValidCredentials.getEmail(), ValidCredentials.getPassword());
            WaitFor.presenceOfTheElement(Page.driver, homePage.getHomepageGreetingsLocator());
            subNavigation = SubNavigation.subNavigation();
            myListings = subNavigation.clickLinkMyListings();
            myListings.scrollPage(0, 300);
            myListings.hoverOverFirstListing();
            myListings.hoverOverUpdate();
            updateListingPage = myListings.clickUpdateOfFirstListing();
            HandlingWindows.closeCurrentWindow(Page.driver);
            HandlingWindows.switchToWindow(Page.driver, 1);
            WaitFor.sleepFor(2000);
            updateListingPage.btn_SaveAndContinue().click();
            media = updateListingPage.clickSaveAndContinueOnDetailsForm();
            AutomationLog.info("Setup to reach media page of the user passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Setup to reach media page of the user failed");
        }
    }

    @Override
    protected void verifyTestCases() throws Exception 
    {
        AutomationLog.info("Verify email address from on media page");
        verifyEmailAddress();

        mediadata = testCaseData.get("MediaFormData");
        String highResFile = exefilepath + mediadata.get("highResFile");
        String lowResFile = exefilepath + mediadata.get("lowResFile");

        verifyIfClickingAddfilesAddImageToUpload(highResFile); 

        verifyIfClickingCancelButtonRemovesAddedImage();

        verifyIfClickingStartUpdateUploadsTheImage(highResFile);

        verifyIfclickingDeleteButtonRemoveUploadedImage();

        verifyIfLowResolutionImageCantBeUploaded(lowResFile);

        verifyIfClickingOnBackButtonRedirectsToDetailsForm();

        verifyIfclickingOnSaveAndContinueRedirectsToContactsPage();
    }

    public void verifyIfClickingAddfilesAddImageToUpload(String highResFile) throws Exception
    {
        try
        {
            media.clickOnAddFilesButton();
            Runtime.getRuntime().exec(highResFile);
            WaitFor.presenceOfTheElement(Page.driver, media.listingImageLocator()); 
            Assert.assertEquals(media.img_Listing().isDisplayed(), true, "Expected AddFiles button does not add image for upload");
            AutomationLog.info("Clicking AddFiles adds image to be uploaded successfully");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not open windows file upload");
            throw(e);
        }
    }

    public void verifyIfClickingCancelButtonRemovesAddedImage() throws Exception
    {
        try
        {
            media.clickOnCancelBbutton();
            Thread.sleep(1000);
            Assert.assertEquals(media.template_Upload(), false, "Expected Cancel button does not remove image ");
            AutomationLog.info("Clicking cancel removes image to be uploaded ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not open windows file upload");
            throw(e);
        }
    }

    public void verifyIfClickingStartUpdateUploadsTheImage(String highResFile) throws Exception
    {
        verifyIfClickingAddfilesAddImageToUpload(highResFile); 
        media.clickOnStartUploadButton();
        WaitFor.ElementToBeDisplayed(Page.driver, media.uploadImagelocator());
        Assert.assertEquals(media.img_Uploaded().isDisplayed(), true, "Expected image is not uploaded");
        AutomationLog.info("Image Uploaded successfully");
    }

    public void verifyIfclickingDeleteButtonRemoveUploadedImage() throws Exception
    {
        WaitFor.ElementToBeDisplayed(Page.driver, media.uploadImagelocator());
        media.clickOnDeleteButton();
        Thread.sleep(2000);
        Assert.assertEquals(media.template_Upload(), false, "Expected image is not removed ");
        AutomationLog.info("Clicking delete button removes uploaded image");
    }

    public void verifyIfLowResolutionImageCantBeUploaded(String lowResFile) throws Exception
    {
        media.clickOnAddFilesButton();
        Runtime.getRuntime().exec(lowResFile);
        WaitFor.presenceOfTheElement(Page.driver, media.listingImageLocator()); 
        media.clickOnStartUploadButton();
        Thread.sleep(10000);
        Assert.assertEquals(media.template_Upload(), false, "Low resolution image can be uploaded");
        AutomationLog.info("Low resolution image cant be uploaded");
    }

    public void verifyIfclickingOnSaveAndContinueRedirectsToContactsPage() throws Exception
    {
        contactsPage = media.clickOnSaveAndContinueButton();;
        Assert.assertEquals(contactsPage.form_Contacts().isDisplayed(), true, "Expected contacts form is not shown");
        AutomationLog.info("Contacts form is shown after clicking save and continue button with valid media form  input ");
        contactsPage.clickOnBackButton();
    }

    public ContactsForm  moveToContactsForm(HashMap<String, HashMap<String, String>> data) throws Exception
   {
       ContactsForm contacts = null;
       mediadata = data.get("MediaFormData");
       String highResFile = exefilepath + mediadata.get("highResFile");
       try
       {
           if(!(media.form_Media().isDisplayed()))
           {
               //detailsRetailAction.fillDetailsFormAndMoveToMediaForm(data);
               
           }
           media.clickOnAddFilesButton();
           Runtime.getRuntime().exec(highResFile);
           WaitFor.presenceOfTheElement(Page.driver, media.listingImageLocator()); 
           media.clickOnStartUploadButton();
           WaitFor.presenceOfTheElement(Page.driver, media.uploadImagelocator());
           media.clickOnSaveAndContinueButton();
           Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
           contacts = new ContactsForm(Page.driver);
       }
       catch(Exception e)
       {
           AutomationLog.error("Could not go to Contacts form ");
           throw(e);
       }
       return contacts;
    }

    public void verifyIfClickingOnBackButtonRedirectsToDetailsForm() throws Exception
    {
        details = media.clickOnBackButtonOnMediaPage();
        Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Assert.assertEquals(details.form_Property().isDisplayed(), true, "Expected form is not shown");
        AutomationLog.info("Clicking back button on media form redirects details page");
        details.clickSaveAndContinueOnDetailsForm();
    }

    private void verifyEmailAddress() throws Exception 
    {
        String EmailIdOnMediaForm = media.txt_EmailAddress().getText();
        String EmailIdOnBanner =  media.txt_EmailAddressOnBanner().getText();
        boolean emailIdStatus = false;
        emailIdStatus = EmailIdOnMediaForm.equals(EmailIdOnBanner);
        Assert.assertEquals(emailIdStatus, true, "Email id on banner not matches with email id on media form");
        AutomationLog.info("Email id on banner matches with email id on media form");
    }

	@Override
    protected String successMessage() 
    {
        return "Sucessfully tested Update Listing Media Form";
    }

    @Override
    protected String failureMessage() 
    {
        return "Failed Update Listing Media Form";
    }
}
