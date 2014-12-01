package com.agorafy.automation.testcases;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.ProfessionalProfilePage;

public class ProfessionalProfilePageAction extends AutomationTestCaseVerification 
{
    private ProfessionalProfilePage professionalProfilePage = null;;

    public ProfessionalProfilePageAction()
    {
        super();
    }

    public void setup()
    {
    	professionalProfilePage = ProfessionalProfilePage.professionalProfilePage();
    	try
        {
            super.setup();
            Page.driver.get("http://www.agorafy.com/profile/44386/rajesh-titan");
            professionalProfilePage.clickSendEmailbtnInProfessionalProfilePage();
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
            HashMap<String, String> getvalidcrendial = testCaseData.get("validCredential");
            verifysendEmailfromProfessionalProfilePage(professionalProfilePage,getvalidcrendial);
     }

    public void verifysendEmailfromProfessionalProfilePage(ProfessionalProfilePage professionalPopUp, HashMap<String, String> getvalidcrendial) throws Exception
    {
        try
        {
            professionalPopUp.populateLoginPopUpDataForProfessionalPage(getvalidcrendial.get("username"),getvalidcrendial.get("password"));
            Assert.assertEquals(professionalPopUp.currentURL(),"http://www.agorafy.com/profile/44386/rajesh-titan","unsuccessfull login after entering valid credentials for Professional Page" );
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
