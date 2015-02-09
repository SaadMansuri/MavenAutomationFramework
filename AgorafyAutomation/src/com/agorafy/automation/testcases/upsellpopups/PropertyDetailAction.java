package com.agorafy.automation.testcases.upsellpopups;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.upsellpopups.PropertyDetailPage;

public class PropertyDetailAction extends AutomationTestCaseVerification
{
    PropertyDetailPage propertydetails=new PropertyDetailPage();
    Header header=Homepage.header();
    
    
    public PropertyDetailAction()
    {
        super();
    }

    @Override
    public void setup()
    {
        super.setup();
        try
        {
              propertydetails.redirectedToPropertyPage();
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to Property Detail Page");
        }
    }
    
    @Override
    protected void verifyTestCases() throws Exception 
    {
        isLoginPopUpPresentVerification(propertydetails);
        
        Credentials ValidCredentials = userCredentials();
        isAfterLoginSameUrlAndPropertyRecordVerification(propertydetails,ValidCredentials);
        
        HashMap<String, String> userName = testCaseData.get("userName");
        contactInformationLogInAndCheckUserInformation(propertydetails,ValidCredentials,userName);
    }
    
    public void isLoginPopUpPresentVerification(PropertyDetailPage propertydetails) throws Exception
    {
        propertydetails.clickOnSignUpUpLink();
        AutomationLog.info("SignUp Link Clicked Successfully");
        Page.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(propertydetails.checkingLogInPopUpOnPropertyPage(),true,"Expected form is not present");
        AutomationLog.info("Login form is present on page");
        Assert.assertEquals(propertydetails.getTitleOfLogInPopUp(),"Log in","Expected Title is not present on Login Pop-Up");
        AutomationLog.info("Login Title on Pop-up is verified");
    }
    
    public void isAfterLoginSameUrlAndPropertyRecordVerification(PropertyDetailPage propertydetails,Credentials validCredentials) throws Exception
    {
        String beforeloginUrl=Page.driver.getCurrentUrl();
        propertydetails.loginProcessOnPropertyPage(validCredentials.getEmail(), validCredentials.getPassword());
        Assert.assertEquals(Page.driver.getCurrentUrl(),beforeloginUrl,"Expected Url is differnt then expected Url");
        AutomationLog.info("User after login stays on a same page");
        Assert.assertEquals(propertydetails.checkingPropertyRecordSection(),true,"Expected Property Record section is not present on Property Page");
        AutomationLog.info("Property Record section is present on property page");
    }
    
    public void contactInformationLogInAndCheckUserInformation(PropertyDetailPage propertydetails,Credentials validCredentials, HashMap<String, String> userName) throws Exception
    {
        Homepage homepage;
        homepage=header.logOutProceessOnPropertyDetailPage();
        propertydetails.redirectedToPropertyPage();
        String beforeloginUrl=Page.driver.getCurrentUrl();
        propertydetails.clickOnSignInToContactInformation();
        Assert.assertEquals(propertydetails.checkingLogInPopUpOnPropertyPage(),true,"Expected Login Pop form is not present");
        AutomationLog.info("Login pop-up is displayed");
        Assert.assertEquals(propertydetails.getTitleOfLogInPopUp(),"Log in","Expected Title is not present on Login Pop-Up");
        AutomationLog.info("Login Title on Pop-up is found successfully");
        propertydetails.loginProcessOnPropertyPage(validCredentials.getEmail(), validCredentials.getPassword());
        Assert.assertEquals(Page.driver.getCurrentUrl(),beforeloginUrl,"Expected Url is differnt then expected Url");
        AutomationLog.info("User after login stays on a same page");
        Assert.assertEquals(propertydetails.getTheUserNameAfterLogIn(),userName.get("information"),"Expected username is different then actual getting username");
        AutomationLog.info("Username is verified");
    }

    @Override
    protected String successMessage() {
        return "Test cases passed for Property Details";
    }

    @Override
    protected String failureMessage() {
        return "Test cases failed for Property Details";
    }
}