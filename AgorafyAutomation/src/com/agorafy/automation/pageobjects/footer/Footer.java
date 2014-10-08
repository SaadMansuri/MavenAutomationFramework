package com.agorafy.automation.pageobjects.footer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.pageobjects.Page;

public class Footer extends Page
{
    public Footer(WebDriver driver)
    {
        super(driver);
    }

    public FooterCompanyLinks companyLinks()
    {
        return PageFactory.initElements(driver, FooterCompanyLinks.class);
    }

    public FooterSupportLinks supportLinks()
    {
        return PageFactory.initElements(driver, FooterSupportLinks.class);
    }

    public FooterSocialLinks socialLinks()
    {
        return PageFactory.initElements(driver, FooterSocialLinks.class);
    }

    public FooterLegalLinks legalLinks() 
    {
        return PageFactory.initElements(driver, FooterLegalLinks.class);
    }

    public FooterCompanyInfo companyInfo()
    {
        return PageFactory.initElements(driver, FooterCompanyInfo.class);
    }
}