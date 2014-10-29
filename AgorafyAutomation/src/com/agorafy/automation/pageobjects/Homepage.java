package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.AutomationLog;

public class Homepage extends Page 
{
    private WebElement element = null;

    public Homepage(WebDriver driver)
    {
        super(driver);
    }

    public String homepageUrl()
    {
        return applicationUrl() + "/home/";
    }

    public static Homepage homePage()
    {
        return PageFactory.initElements(driver, Homepage.class);
    }

    public By getHomepageGreetingsLocator()
    {
        return By.xpath(".//*[@id='mainNav']/li[3]/a[1]/span[2]");
    }

    public WebElement link_Login() throws Exception
    {
        try
        {
             element = driver.findElement(By.xpath(".//*[@id='mainNav']/li[3]/a/span"));
             AutomationLog.info("Log In link found on the Home Page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Log In link was Not found on the Home Page");
            throw(e);
        }
        return element;
    }

    public HeaderLoginForm openHeaderLoginForm() throws Exception
    {
        HeaderLoginForm element = null;
        try
        {
            link_Login().click();
            element = new HeaderLoginForm(driver);
            AutomationLog.info("Header login form appears");
        }
        catch (Exception e)
        {
            AutomationLog.error("Header login form does Not appear");
            throw(e);
        }
        return element;
    }
}
