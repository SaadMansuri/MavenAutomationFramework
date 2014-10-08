package com.agorafy.automation.testcases.footer;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterCompanyInfo;

public class FooterCompanyInfoAction extends FooterAction
{
    FooterCompanyInfo companyInfo=null;
    public FooterCompanyInfoAction()
    {
        super();
    }

    @Override
    void testLink()
    {
        companyInfo = Page.footer().companyInfo();
        try
        {
            Assert.assertEquals(companyInfo.text_CompanyName(), "Agorafy, Inc.", "Company Name on Footer is not valid");
            AutomationLog.info("CompanyName on footer is valid");

            Assert.assertEquals(companyInfo.text_CompanyAddress1(),"235 West 23rd Street, 5th Floor", "Company Address1 on footer is not valid");
            AutomationLog.info("Company Address1 on footer is valid");

            Assert.assertEquals(companyInfo.text_CompanyAddress2(),"New York, NY 10011", "Company Address2 on footer is not valid");
            AutomationLog.info("Company Address2 on footer is valid");

            Assert.assertEquals(companyInfo.text_CompanyPhoneNumber(), "(212) 401-4231", "Company Phone Number on footer is not valid");
            AutomationLog.info("Company Phone Number on footer is valid");

            Assert.assertEquals(companyInfo.link_MailToText(), "hello@agorafy.com", "Mail To text on footer is not valid");
            AutomationLog.info("Mail To text on footer is valid");

            Assert.assertEquals(companyInfo.link_MailToAdressText().startsWith("mailto:"), true, "Company support mail address does not confirm to mail to protocol");
            AutomationLog.info("Company support mail address confirms to mail to protocol");

            Assert.assertEquals(companyInfo.text_Copyright(), "All Content Copyright © 2014 , Agorafy Inc.", "Copyright text on footer is not valid");
            AutomationLog.info("Copyright text on footer is valid");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    String successMessage()
    {
        return "Footer Company Info tested successfully";
    }

    @Override
    String failureMessage()
    {
        return "Footer CompanyInfo Action failed";
    }
}