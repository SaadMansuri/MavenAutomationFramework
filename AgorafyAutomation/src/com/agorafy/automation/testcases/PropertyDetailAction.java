package com.agorafy.automation.testcases;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.pageobjects.Header;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertyDetailPage;

/**
 * verify if user after sign in stays on the same page and broker information should be visible
 * verify if clicking on 'Sign in to see NYC Department of Buildings and Finance records.' from property record section and click if Log-in pop-Up appears
 * verify if user after sign in stays on the same page and user information should be visible
 * verify if click on 'Sign in to see contact information' and click if Log-in pop-Up appears or not
 * verify if 
 */
public class PropertyDetailAction extends AutomationTestCaseVerification
{
    PropertyDetailPage propertydetails=new PropertyDetailPage();
    Homepage homepage=new Homepage();
    Header header=Homepage.header();;
    
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
        isClickOnloginlinkfrompropertyrecord(propertydetails);
        
        Credentials ValidCredentials = userCredentials();
        isAfterLoginSameUrlAndPropertyRecordVerification(propertydetails,ValidCredentials);
        
        logout();
        
        HashMap<String, String> userName = testCaseData.get("userName");
        contactInformationLogInAndCheckUserInformation(propertydetails,ValidCredentials,userName);
    }
    
    public void isLoginPopUpPresentVerification() throws Exception
    {
        Page.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(propertydetails.checkingLogInPopUpOnPropertyPage(),true,"Expected form is not present");
        AutomationLog.info("Login form is present on page");
        Assert.assertEquals(propertydetails.getTitleOfLogInPopUp(),"Log in","Expected Title is not present on Login Pop-Up");
        AutomationLog.info("Login Title on Pop-up is verified");
    }
    
    public void isClickOnloginlinkfrompropertyrecord(PropertyDetailPage propertydetails) throws Exception
    {
        propertydetails.clickOnLogInLink();
        AutomationLog.info("SignUp Link Clicked Successfully");
        isLoginPopUpPresentVerification();
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
    
    public void logout() throws Exception
    {
        homepage=header.logOutProceessOnPropertyDetailPage();
    }
    
    public void contactInformationLogInAndCheckUserInformation(PropertyDetailPage propertydetails,Credentials validCredentials, HashMap<String, String> userName) throws Exception
    {
        propertydetails.redirectedToPropertyPage();
        String beforeloginUrl=Page.driver.getCurrentUrl();
        propertydetails.clickOnSignInToContactInformation();
        isLoginPopUpPresentVerification();
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
