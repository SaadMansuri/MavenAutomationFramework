package com.agorafy.automation.pageobjects.footer.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class Feedback extends Page
{
    private WebElement element = null;
    public Feedback(WebDriver driver)
    {
        super(driver);
    }

    public String feedbackPageUrl()
    {
        return applicationUrl() + "/feedback/";
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("Feedback Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Feedback Page Heading Not found");
            throw(e);
        }
        return element;
    }

    @Override
    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }

    WebElement textBox_Name() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("name"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Name Text Field on Feedback form");
            throw(e);
        }
        return element;
    }

    String textBox_NameValue() throws Exception
    {
        String name = "";
        try
        {
            textBox_Name().getAttribute("value");
            AutomationLog.info("Name found in Name text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find name in name field");
            throw(e);
        }
        return name;
    }

    WebElement textBox_Email() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("exampleInputEmail1"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Email Text Field on Feedback form");
            throw(e);
        }
        return element;
    }

    String textBox_EmailValue() throws Exception
    {
        String email = "";
        try
        {
            textBox_Email().getAttribute("value");
            AutomationLog.info("Email found in email text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find email in Email field");
            throw(e);
        }
        return email;
    }

    WebElement dropdown_Subject() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("subject"));
            AutomationLog.info("Subject Dropdown found on Feedback form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Subject dropdown on feedback form");
        }
        return element;
    }
}