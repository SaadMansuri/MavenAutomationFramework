package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.footer.Footer;


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
    
    public String getTitle()
    {
        return driver.getTitle();
    }

    public WebElement link_Login() throws Exception
    {
        try
        {
             element = driver.findElement(By.xpath(".//*[@id='mainNav']/li[3]/a/span"));
             AutomationLog.info("My login link found on the Home Page");
        }
        catch (Exception e)
        {
            AutomationLog.error("My login link was not found on the Home Page");
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
            AutomationLog.info("Successfully navigated to login page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Not Able to navigate to login page");
            throw(e);
        }

        return element;
    }

}
