package com.agorafy.automation.pageobjects.upsellpopups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Homepage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.PropertySearch;

public class LoginPopUp extends Page 
{
    private WebElement element=null;
    private Homepage homepage;

    public LoginPopUp(WebDriver driver)
    {
        super(driver);
    }

    public By getLoginPopUpLocator()
    {
        return By.id("upsellPopup");
    }

    public WebElement popUp_Login() throws Exception
    {
        try
        {
            element=driver.findElement(getLoginPopUpLocator());
        }
        catch(Exception e)
        {
            AutomationLog.error("could not found login pop up");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_Email() throws Exception
    {
        try
        {
            element = popUp_Login().findElement(By.name("_username"));
            AutomationLog.info("Email textbox found on login pop up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Email textbox not found on login pop up");
            throw(e);
        }
        return element;
        }

    public WebElement txtbx_Password() throws Exception
    {
        try
        {
            element = popUp_Login().findElement(By.name("_password"));
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
            element = popUp_Login().findElement(By.className("btn-primary"));
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

    public WebElement icon_CloseOnLoginPopUp() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[5]/div[1]/a"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Close icon on login popup");
            throw(e);
        }
        return element;
    }

    public WebElement title_LoginPopUp() throws Exception
    {
        try
        {
            element=driver.findElement(By.id("ui-dialog-title-upsellPopup"));
            AutomationLog.info("Title found on login pop up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found title on login pop up");
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

    public Object clickLoginButtonOnUpsell() throws Exception
    {
        Object pageObject = null;
        try
        {
            pageObject = objectTypeBeingLookedFor();
            btn_LogIntoMyAccount().click();
            AutomationLog.info("Login button clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on login button");
        }
        return pageObject;
    }

    public Homepage populateHomePageLoginPopUpData(String Email, String Password ) throws Exception
    {
        Homepage homepage;
        try
        {
            Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement email = txtbx_Email();
            WebElement pass  = txtbx_Password();
            email.clear();
            email.sendKeys(Email);
            pass.clear();
            pass.sendKeys(Password);
            clickLoginButtonOnUpsell();
            homepage=new Homepage(driver);
            AutomationLog.info("Successfully populated data in login pop up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not populate data into login pop up");
            throw(e);
        }
        return homepage;
    }

    public void populateLoginPopUpData(String Email, String Password ) throws Exception
    {
        try
        {
            Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement email = txtbx_Email();
            WebElement pass  = txtbx_Password();
            email.clear();
            email.sendKeys(Email);
            pass.clear();
            pass.sendKeys(Password);
            AutomationLog.info("Successfully populated data in login pop up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not populate data into login pop up");
            throw(e);
        }
    }

    public Object objectTypeBeingLookedFor() throws Exception
    {
        Object pageObject = null;
        String objectOfPage;
        String [] urlOfPage = null;
        objectOfPage = driver.getCurrentUrl();
        urlOfPage = objectOfPage.split("/");

        switch (urlOfPage[3])
        {
            case "search":
                pageObject = new PropertySearch(driver);

            break;

            case "listing":
                pageObject = new ListingDetailPage(driver);

                break;

            case "profile":
                pageObject = new ProfessionalProfilePage(driver);

            case "home":
                pageObject = new Homepage();

        default:
            break;
        }
        return pageObject;
    }

    public boolean checkingLogInPopUp() throws Exception
    {
        boolean bool;
        try
        {
            bool = popUp_Login().isDisplayed();
        }
        catch(Exception e)
        {
            AutomationLog.error("Login pop-up is not displayed on Property Page");
            throw(e);
        }
        return bool;
     }
}
