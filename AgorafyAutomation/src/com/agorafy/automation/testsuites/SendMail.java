package com.agorafy.automation.testsuites;

import org.testng.annotations.AfterSuite;

public class SendMail 
{

    @AfterSuite
    public void sendReport() throws Exception
    {
        try
        {
           mailReport.SendMail.execute("Total regression report");
        }
        catch(Exception e)
        {
            throw(e);
        }
    }
}
