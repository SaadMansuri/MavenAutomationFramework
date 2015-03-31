package com.agorafy.automation.testcases.upsellpopups;


import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.automationframework.Credentials;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.upsellpopups.LoginPopUp;
import com.agorafy.automation.pageobjects.upsellpopups.ProfessionalProfilePage;

public class ProfessionalProfileLoginUpsellAction extends AutomationTestCaseVerification 
{
    private ProfessionalProfilePage professionalProfilePage = null;
    private LoginPopUp loginpopup = null;

    public ProfessionalProfileLoginUpsellAction()
    {
        super();
    }

    public void setup()
    {
        professionalProfilePage = ProfessionalProfilePage.professionalProfilePage();
        try
        {
            super.setup();
            Page.driver.get("http://www.agorafy.com/profile/44386");
            AutomationLog.info("Able to Navigate to Professional Page popup");
            
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not navigate to Professional Page");
        }
    }

@Override
     protected void verifyTestCases() throws Exception
     {
            Credentials validCredentials = userCredentials();
            //HashMap<String, String> getvalidcrendial = testCaseData.get("validCredential");
            verifysendEmailLinkLoginUpsell(professionalProfilePage,validCredentials);
     }

    public void verifysendEmailLinkLoginUpsell(ProfessionalProfilePage professionalPopUp, Credentials getvalidcrendial) throws Exception
    {
        try
        {
            loginpopup = professionalProfilePage.clickSendEmailbtnOnProfessionalProfile();
            String Url = Page.driver.getCurrentUrl();
            Thread.sleep(5000);
            Assert.assertEquals(loginpopup.checkingLogInPopUp(), true, "Upsell Login popup Not found");
            loginpopup.populateLoginPopUpData(getvalidcrendial.getEmail(), getvalidcrendial.getPassword());
            professionalProfilePage = (ProfessionalProfilePage) loginpopup.clickLoginButtonOnUpsell();

            //professionalPopUp.populateLoginPopUpDataForProfessionalPage(getvalidcrendial.get("username"),getvalidcrendial.get("password"));
            Assert.assertEquals(professionalProfilePage.currentURL(),Url,"unsuccessfull login after entering valid credentials for Professional Page" );
            AutomationLog.info("successfull login after entering valid credentials for Professional Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not send credentials to login pop up of Professional Page");
        }
    }

    @Override
    protected String successMessage()
    {
        return "Funtionality of Send Email button on ProfessionalPage is Passed";
    }

    @Override
    protected String failureMessage()
    {
        return "Funtionality of Send Email button on ProfessionalPage is Failed";
    }
}
