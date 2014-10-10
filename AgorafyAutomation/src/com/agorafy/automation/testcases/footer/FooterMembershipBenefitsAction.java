package com.agorafy.automation.testcases.footer;

import org.testng.Assert;
import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.MembershipBenefit;
import com.agorafy.automation.pageobjects.footer.FooterCompanyLinks;

public class FooterMembershipBenefitsAction extends FooterAction
{
    public FooterMembershipBenefitsAction()
    {
        super();
    }

    @Override
    void testLink()
    {
        FooterCompanyLinks companyLinks = Page.footer().companyLinks();
        MembershipBenefit membershipBenefit = null;
        try
        {
            membershipBenefit = companyLinks.openMembershipbenefit();
            AutomationLog.info("Membership Benefit Page opened successfully");

            Assert.assertEquals(membershipBenefit.currentURL(), membershipBenefit.membershipBenefitPageUrl(), "Membership Benefit Link did not Navigate to correct pageUrl");
            AutomationLog.info("Membership Benefit Link navigates to Membership Benefit URL");

            Assert.assertEquals(membershipBenefit.currentPageTitle(), "AGORAFY - Members' Benefits", "Membership benefit page does not show correct PageTitle");
            AutomationLog.info("Membership Benefit page shows correct page title");

            Assert.assertEquals(membershipBenefit.headingText(), "Members' Benefits","Membership Benefit page does not show correct page Heading");
            AutomationLog.info("Membership Benefit page shows correct page Heading");
        }
        catch (Exception e)
        {
            AutomationLog.error("Either MembershipBenefit page did not open successfully or MembershipBenefit page verification failed" + e.getMessage());
        }
    }

    @Override
    String successMessage()
    {
        return " Footer Membership Benefit tested successfully";
    }

    @Override
    String failureMessage()
    {
        return "Footer MembershipBenefit Action Failed";
    }
}