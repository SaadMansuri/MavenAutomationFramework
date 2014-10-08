package com.agorafy.automation.pageobjects.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class FooterCompanyInfo extends Page
{
    private WebElement element = null;
    public FooterCompanyInfo(WebDriver driver)
    {
        super(driver);
    }

    public String text_CompanyName() throws Exception
    {
        String companyName = "";
        try
        {
            companyName = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/h5")).getText();
            AutomationLog.info("Company Name found on the Footer");		
        }
        catch(Exception e)
        {
            AutomationLog.error("Company Name not found on the Footer");
            throw(e);
        }
        return companyName;
    }

    public String text_CompanyAddress1() throws Exception
    {
        String companyAddress1 = "";
        try
        {
            companyAddress1 = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[1]/p[1]")).getText();
            AutomationLog.info("Company Address1 found on the Footer");			
        }
        catch(Exception e)
        {
            AutomationLog.error("Company Address1 not found on the Footer");
            throw(e);
        }
        return companyAddress1;
    }

    public String text_CompanyAddress2() throws Exception 
    {
        String companyAddress2 = "";
        try
        {
            companyAddress2 = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[1]/p[2]")).getText();
            AutomationLog.info("Company Address2 found on the Footer");			
        }
        catch(Exception e)
        {
            AutomationLog.error("Company Address2 not found on the Footer");
            throw(e);
        }
        return companyAddress2;
    }

    public String text_CompanyPhoneNumber() throws Exception
    {
        String companyPhoneNumber = "";
        try
        {
            companyPhoneNumber = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[3]/p[1]")).getText();
            AutomationLog.info("Company Phone Number found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Phone Number not found on the Footer");
            throw(e);
        }
        return companyPhoneNumber;
    }

    public WebElement link_MailTo() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[3]/p[2]/a"));
            AutomationLog.info("Mail To link found on the footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Mail To link not found on the footer");
            throw(e);
        }
        return element;
    }

    public String link_MailToText() throws Exception
    {
        String mailToText = "";
        try
        {
            mailToText = link_MailTo().getText();
            AutomationLog.info("MailTo text found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("MailTo text not found on Footer");
            throw(e);
        }
        return mailToText;
    }

    public String link_MailToAdressText() throws Exception
    {
        String mailToAddress = "";
        try
        {
            mailToAddress = link_MailTo().getAttribute("href");
            AutomationLog.info("MailTo Address found");
        }
        catch(Exception e)
        {
            AutomationLog.error("MailTo Address not found");
            throw(e);
        }
        return mailToAddress;
    }

    public String text_Copyright() throws Exception
    {
        String copyrightText = "";
        try
        {
            copyrightText = driver.findElement(By.xpath(".//*[@id='footer']/div/div[2]/div/span")).getText();
            AutomationLog.info("Copyright Text found on the footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Copyright Text not found on footer");
            throw(e);
        }
        return copyrightText;
    }
}