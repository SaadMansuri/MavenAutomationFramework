package com.agorafy.automation.testcases.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.AutomationTestCaseVerification;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterCompanyInfo;

/**
 * Test Company Info Text on Footer
 * Verify the Company Name, Address and Phone Number 
 * Verify the support mail text and address
 * Verify the title of Careers Page
 * Verify the copyright text
 */
public class FooterCompanyInfoAction extends AutomationTestCaseVerification
{
    FooterCompanyInfo companyInfo=null;
    public FooterCompanyInfoAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases()
    {
        companyInfo = Page.footer().companyInfo();
        HashMap<String, String> companyInfoMap = testCaseData.get("CompanyInfo");
        try
        {
            Assert.assertEquals(companyInfo.text_CompanyName(),companyInfoMap.get("companyname").trim(), "Company Name on Footer is not valid");
            AutomationLog.info("CompanyName on footer is valid");

            Assert.assertEquals(companyInfo.text_CompanyAddress1(),companyInfoMap.get("companyaddr1").trim(), "Company Address1 on footer is not valid");
            AutomationLog.info("Company Address1 on footer is valid");

            Assert.assertEquals(companyInfo.text_CompanyAddress2(),companyInfoMap.get("companyaddr2").trim(), "Company Address2 on footer is not valid");
            AutomationLog.info("Company Address2 on footer is valid");

            Assert.assertEquals(companyInfo.text_CompanyPhoneNumber(), companyInfoMap.get("companyphoneNo").trim(), "Company Phone Number on footer is not valid");
            AutomationLog.info("Company Phone Number on footer is valid");

            Assert.assertEquals(companyInfo.link_SupportEmailText(), companyInfoMap.get("supportemail").trim(), "Support Email Text on footer is not valid");
            AutomationLog.info("Support Email Text on footer is valid");

            Assert.assertEquals(companyInfo.link_SupportEmailAddressText().startsWith("mailto:"), true, "Company support mail address does not confirm to mailto: protocol");
            AutomationLog.info("Company support mail address confirms to mailto: protocol");

            Assert.assertEquals(companyInfo.text_Copyright(), companyInfoMap.get("copyright").trim(), "Copyright text on footer is not valid");
            AutomationLog.info("Copyright text on footer is valid");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected String successMessage()
    {
        return "Footer Company Info tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Footer CompanyInfo Action failed";
    }
}