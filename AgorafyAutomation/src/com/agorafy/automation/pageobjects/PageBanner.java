package com.agorafy.automation.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class PageBanner extends Page
{
    private WebElement element = null;
    public PageBanner(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement profile_Content() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("profile-content"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Profile Contents");
        }
        return element;
    }

    public String getBannerText() throws Exception
    {
        String bannerText="";
        try
        {
            bannerText= profile_Content().findElement(By.tagName("h2")).getText();
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
            companyText =profile_Content().findElement(By.tagName("p")).getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("Company name not found in Overview tab form");
            throw(e);
        }
        return companyText;
    }

    public List<WebElement> ContactDetails() throws Exception
    {
        List<WebElement> list = new ArrayList<WebElement>();
        try
        {
            list = driver.findElement(By.className("contact-details")).findElements(By.tagName("p"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not Contact details Section");
            throw(e);
        }
        return list;
    }

    public String getBannerWorkPhoneText() throws Exception
    {
        String workPhoneText="";
        try
        {
            element = phoneDetails().get(7);
            workPhoneText = element.getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("WorkPhone number  not found in Overview tab form");
            throw(e);
        }
        return workPhoneText;
    }

    public List<WebElement> phoneDetails() throws Exception
    {
        List<WebElement> list = new ArrayList<WebElement>();
        try
        {
            list = driver.findElement(By.className("contact-details")).findElements(By.tagName("span"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find phoneDeatails on Page Banner");
            throw(e);
        }
        return list;
    }

    public String getBannerMobilePhoneText() throws Exception
    {
        String mobileText="";
        try
        {
            element = phoneDetails().get(0);
            mobileText = element.getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("Mobile number  not found in Overview tab form");
            throw(e);
        }
        return mobileText;
    }

    public String getBannerAddressText() throws Exception
    {
        String addressText="";
        try
        {
            element = ContactDetails().get(1);
            addressText= element.getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("Address not found in Overview tab form");
            throw(e);
        }
        return addressText;
    }

    public String getBannerEmailText() throws Exception
    {
        String emailText="";
        try
        {
            element = ContactDetails().get(2);
            emailText= element.getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("emailText not found in Overview tab form");
            throw(e);
        }
        return emailText;
    }
}
