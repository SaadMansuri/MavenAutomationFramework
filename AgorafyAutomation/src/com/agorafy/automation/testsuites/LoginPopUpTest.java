package com.agorafy.automation.testsuites;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.agorafy.automation.automationframework.AutomationFramework;
import com.agorafy.automation.automationframework.Init;
import com.agorafy.automation.testcases.upsellpopups.ListingDetailPageAction;
import com.agorafy.automation.testcases.upsellpopups.ProfessionalProfileLoginUpsellAction;
import com.agorafy.automation.testcases.upsellpopups.PropertyDetailAction;
import com.agorafy.automation.testcases.upsellpopups.SignupPageLoginAction;

public class LoginPopUpTest 
{
    @BeforeSuite
    public void Init()
    {
        Init.globalConfiguration();
    }

    @Test
    public void testForLoginPopUpSignupPage() throws Exception
    {
        try
        {
            new SignupPageLoginAction().Execute();
        }
        catch (Exception e) 
        {
            throw (e);
        }
    }

    @Test
    public void testForLoginPopUpListingPage() throws Exception
    {
        try
        {
            new ListingDetailPageAction().Execute();
        }
        catch (Exception e) 
        {
            throw (e);
        }
    }

    @Test
    public void testForLoginPopUpProfessionalProfilePage() throws Exception
    {
        try
        {
            new ProfessionalProfileLoginUpsellAction().Execute();
        }
        catch (Exception e) 
        {
            throw (e);
        }
    }

    @Test
    public void testForLoginPopUpPropertyDetailsPage() throws Exception
    {
        try
        {
            new PropertyDetailAction().Execute();
        }
        catch (Exception e) 
        {
            throw (e);
        }
    }

}
