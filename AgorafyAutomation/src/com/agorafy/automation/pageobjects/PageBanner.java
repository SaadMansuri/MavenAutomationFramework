package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.agorafy.automation.automationframework.AutomationLog;

public class PageBanner extends Page
{
    public PageBanner(WebDriver driver) 
    {
        super(driver);
    }

    public By getBannerTextLocater()
    {
        return By.xpath("html/body/div[2]/div/div[1]/div/div[2]/div/h2");
    }

    public String getBannerText() throws Exception
    {
        String bannerText="";
        try
        {
            bannerText= driver.findElement(getBannerTextLocater()).getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("Banner Text not found in Overview page");
            throw(e);
        }
        return bannerText;
    }

    public String getBannerCompanyText() throws Exception
    {
        String companyText="";
        try
        {
            companyText =driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div/div[2]/div/p")).getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("Company name not found in Overview page");
            throw(e);
        }
        return companyText;
    }

    public String getBannerWorkPhoneText() throws Exception
    {
        String workPhoneText="";
        try
        {
            workPhoneText= driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div/div[2]/div/div/p[1]/span[1]")).getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("WorkPhone number  not found in Overview page");
            throw(e);
        }
        return workPhoneText;
    }

    public String getBannerMobilePhoneText() throws Exception
    {
        String mobileText="";
        try
        {
        mobileText= driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div/div[2]/div/div/p[1]/span[2]")).getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("Mobile number  not found in Overview page");
            throw(e);
        }
        return mobileText;
    }

    public String getBannerAddressText() throws Exception
    {
        String addressText="";
        try
        {
            addressText= driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div/div[2]/div/div/p[2]")).getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("Address not found in Overview page");
            throw(e);
        }
        return addressText;
    }
}
