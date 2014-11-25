package com.agorafy.automation.pageobjects;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.agorafy.automation.automationframework.AutomationLog;

public class LoginPopUp extends Page 
{
    private WebElement element=null;
    private Homepage homepage;

    public LoginPopUp(WebDriver driver)
    {
        super(driver);
    }

    public WebElement txtbx_Email() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='upsellPopup']/form/div[1]/input"));
            AutomationLog.info("Email textbox found on login pop up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Email textbox not found on login pop up");
            throw(e);
        }
        return element;
        }

    public By getLoginPopUpLocator()
    {
        return By.xpath(".//*[@id='upsellPopup']");
    }

    public WebElement popUp_Login() throws Exception
    {
        try
        {
            element=driver.findElement(By.id("upsellPopup"));
            AutomationLog.info("Login pop up is found");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not found login pop up");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_Password() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='upsellPopup']/form/div[2]/input"));
            AutomationLog.info("Password textbox found on login pop up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Password textbox not found on login pop up");
            throw(e);
        }
        return element;
    }

    public WebElement btn_LogIntoMyAccount() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='upsellPopup']/form/div[3]/input"));
            AutomationLog.info("Log into my account button found on login pop up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Log into my account button not found on login pop up");
            throw(e);
        }
        return element;
    }

    public WebElement label_StayLoggedIn() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='upsellRememberMeLabel']"));
            AutomationLog.info("Stay logged in label found on login pop up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Stay logged in label not found on login pop up");
            throw(e);
        }
        return element;
    }

    public WebElement checkbox_StayLoggedIn() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='upsellRememberMe']"));
            AutomationLog.info("Stay logged in checkbox found on login pop up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Stay logged in checkbox found on login pop up");
            throw(e);
        }
        return element;
    }

    public Homepage populateLoginPopUpData(String email, String Password ) throws Exception
    {
        homepage=new Homepage(driver);
        try
        {
            //WaitFor.presenceOfTheElement(Page.driver,getLoginPopUpLocator());
            Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            txtbx_Email().clear();
            txtbx_Email().sendKeys(email);
            txtbx_Password().clear();
            txtbx_Password().sendKeys(Password);
            btn_LogIntoMyAccount().click();
            AutomationLog.info("Successfully populated data in login pop up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not populate data into login pop up");
            throw(e);
        }
        return homepage;
    }

}
