package com.agorafy.automation.testcases.contentpages.footer;

import java.util.HashMap;

import org.testng.Assert;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.FooterCompanyInfo;
import com.agorafy.automation.testcases.contentpages.ContentPagesVerification;

/**
 * Test Company Info Text on Footer
 * Verify the Company Name, Address and Phone Number 
 * Verify the support mail text and address
 * Verify the title of Careers Page
 * Verify the copyright text
 */
public class FooterCompanyInfoAction extends ContentPagesVerification
{
    public FooterCompanyInfoAction()
    {
        super();
    }

    @Override
    protected void verifyTestCases() throws Exception
    {
        FooterCompanyInfo companyInfo = Page.footer().companyInfo();
        HashMap<String, String> expectedCompanyInfoData = testCaseData.get("CompanyInfo");

        verifyFooterCompanyInfo(companyInfo, expectedCompanyInfoData);
/*        Assert.assertEquals(companyInfo.companyName(), expectedCompanyInfoData.get("companyname"), "Company Name on Footer is not valid");
        AutomationLog.info("CompanyName on footer is valid");

        Assert.assertEquals(companyInfo.companyAddress1(), expectedCompanyInfoData.get("companyaddr1"), "Company Address1 on footer is not valid");
        AutomationLog.info("Company Address1 on footer is valid");

        Assert.assertEquals(companyInfo.companyAddress2(),expectedCompanyInfoData.get("companyaddr2"), "Company Address2 on footer is not valid");
        AutomationLog.info("Company Address2 on footer is valid");

        Assert.assertEquals(companyInfo.companyPhoneNumber(), expectedCompanyInfoData.get("companyphoneNo"), "Company Phone Number on footer is not valid");
        AutomationLog.info("Company Phone Number on footer is valid");

        Assert.assertEquals(companyInfo.supportEmailText(), expectedCompanyInfoData.get("supportemail"), "Support Email Text on footer is not valid");
        AutomationLog.info("Support Email Text on footer is valid");

        Assert.assertEquals(companyInfo.supportEmailAddressText().startsWith("mailto:"), true, "Company support mail address does not confirm to mailto: protocol");
        AutomationLog.info("Company support mail address confirms to mailto: protocol");

        Assert.assertEquals(companyInfo.copyrightText(), expectedCompanyInfoData.get("copyright"), "Copyright text on footer is not valid");
        AutomationLog.info("Copyright text on footer is valid");*/
    }

    public void verifyFooterCompanyInfo(FooterCompanyInfo companyInfo, HashMap<String, String> expectedCompanyInfoData) throws Exception
    {
        Assert.assertEquals(companyInfo.companyName(), expectedCompanyInfoData.get("companyname"), "Company Name on Footer is not valid");
        AutomationLog.info("CompanyName on footer is valid");

        Assert.assertEquals(companyInfo.companyAddress1(), expectedCompanyInfoData.get("companyaddr1"), "Company Address1 on footer is not valid");
        AutomationLog.info("Company Address1 on footer is valid");

        Assert.assertEquals(companyInfo.companyAddress2(),expectedCompanyInfoData.get("companyaddr2"), "Company Address2 on footer is not valid");
        AutomationLog.info("Company Address2 on footer is valid");

        Assert.assertEquals(companyInfo.companyPhoneNumber(), expectedCompanyInfoData.get("companyphoneNo"), "Company Phone Number on footer is not valid");
        AutomationLog.info("Company Phone Number on footer is valid");

        Assert.assertEquals(companyInfo.supportEmailText(), expectedCompanyInfoData.get("supportemail"), "Support Email Text on footer is not valid");
        AutomationLog.info("Support Email Text on footer is valid");

        Assert.assertEquals(companyInfo.supportEmailAddressText().startsWith("mailto:"), true, "Company support mail address does not confirm to mailto: protocol");
        AutomationLog.info("Company support mail address confirms to mailto: protocol");

        Assert.assertEquals(companyInfo.copyrightText(), expectedCompanyInfoData.get("copyright"), "Copyright text on footer is not valid");
        AutomationLog.info("Copyright text on footer is valid");
    }

    @Override
    protected String successMessage()
    {
        return "Company Information on Footer tested successfully";
    }

    @Override
    protected String failureMessage()
    {
        return "Company Information Test Failed";
    }
}