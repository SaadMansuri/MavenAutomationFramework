package com.agorafy.automation.testsuites;

import org.testng.annotations.AfterSuite;


public class SendMail 
{

    @AfterSuite
    public void sendReport() throws Exception
    {
        try
        {
           mailReport.SendMail.execute("Subscribe To Search");
        }
        catch(Exception e)
        {
            throw(e);
        }
    }
}
