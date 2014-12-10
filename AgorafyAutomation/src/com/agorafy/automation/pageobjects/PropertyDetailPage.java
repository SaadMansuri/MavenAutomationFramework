package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class PropertyDetailPage extends Page 
{
    private WebElement element = null;
    
    public PropertyDetailPage(WebDriver driver) {
        super(driver);
    }
    
    public PropertyDetailPage() {
        super(driver);
    }
    
    public PropertyDetailPage redirectedToPropertyPage() throws Exception
    {
        PropertyDetailPage propertydetail= null;
        try
        {
            driver.get("http://www.agorafy.com/property/826093/11-Madison-Avenue-Madison-Square-New-York");
            propertydetail = new PropertyDetailPage(driver);
            AutomationLog.info("Redirected to property Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Redirected to property Page is failed");
            throw(e);
        }
        return propertydetail;
    }
    
    public WebElement link_propertyRecordLogIn() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//a[@class='upsell ga-track'][@data-ga-label='ViewPropertyRecords']"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Signup link found was not found on the Property Detail Page");
            throw(e);
        }

        return element;
    }
    
    public LoginPopUp clickOnLogInLink() throws Exception
    {
        LoginPopUp loginpopup = null;
        try
        {
        	link_propertyRecordLogIn().click();
            loginpopup = new LoginPopUp(driver);
            AutomationLog.info("Clicked on login link from property record section");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to click on login link from property record section");
            throw(e);
        }
            return loginpopup;
    }
    
    public WebElement getLoginPopUp() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//form[@class='upsellLoginForm']"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Login pop-up element is not found in Property Detail");
            throw(e);
        }
        return element;
    }
    
    public boolean checkingLogInPopUpOnPropertyPage() throws Exception
    {
        boolean bool;
        try
        {
            bool=getLoginPopUp().isDisplayed();
        }
        catch(Exception e)
        {
            AutomationLog.error("Login pop-up is not displayed on Property Page");
            throw(e);
        }
        return bool;
     }
    
    public WebElement logInPopUpHeadingText() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//span[@class='ui-dialog-title']"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Login pop-up Title webelement is not found in Property Detail");
            throw(e);
        }

        return element;
    }

    public String getTitleOfLogInPopUp() throws Exception
    {
        String Titlename;
        try
        {
            Titlename=logInPopUpHeadingText().getText();
            AutomationLog.info("Fetching the title of login pop-up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Fetching Login pop-up box title is failed");
            throw(e);
        }
        return Titlename;
     }
    
    public WebElement txtbx_email() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//div[@class='form-group']/input[@value='']"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Email text field is not found");
            throw(e);
        }

        return element;
    }
    
    public WebElement txtbx_password() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//div[@class='form-group']/input[@placeholder='Enter Password']"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Password text field is not found");
            throw(e);
        }

        return element;
    }
    
    public WebElement btn_loginPopUpSubmit() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//input[@value='Log in to my account']"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Login Submit operation is failed");
            throw(e);
        }

        return element;
    }
    
    public PropertyDetailPage loginProcessOnPropertyPage(String email, String Password ) throws Exception
    {
        PropertyDetailPage propertypage=null;
        try
        {
        	txtbx_email().sendKeys(email);
            AutomationLog.info("Email id is entered in textbox successfully");
            txtbx_password().sendKeys(Password);
            AutomationLog.info("Password is entered in textbox successfully");
            btn_loginPopUpSubmit().click();
            AutomationLog.info("Cliked on 'Log in to my account' button");
            AutomationLog.info("Login Done");
            propertypage = new PropertyDetailPage();
        }
        catch(Exception e)
        {
            AutomationLog.error("Login process was not done");
            throw(e);
        }
        return propertypage;
    }
    
    public WebElement propertyRecordSection() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//div[@class='property-record-col row']"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Property Record Section is not found");
            throw(e);
        }
        return element;
    }
    
    public boolean checkingPropertyRecordSection() throws Exception
    {
        boolean bool;
        try
        {
            bool=propertyRecordSection().isDisplayed();
        }
        catch(Exception e)
        {
            AutomationLog.error("Property Record Section is not displayed");
            throw(e);
        }
        return bool;
     }
    
    public WebElement signInToContactInformation() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//a[@data-ga-label='ViewContactInformation']"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Sign in to contact information is not found");
            throw(e);
        }
        return element;
    }
    
    public LoginPopUp clickOnSignInToContactInformation() throws Exception
    {
        LoginPopUp loginpopup = null;
        try
        {
            signInToContactInformation().click();
            loginpopup = new LoginPopUp(driver);
            AutomationLog.info("Clicked on 'Sign in to see contact information' link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on 'Sign in to see contact information' link");
            throw(e);
        }
            return loginpopup;
    }
    
    public WebElement userNameElementAfterLogIn() throws Exception
    {
        try 
        {
            element = driver.findElement(By.cssSelector(".profile-name"));
        }
        catch (Exception e)
        {
            AutomationLog.error("User Name element is found Successfully is not found");
            throw(e);
        }
        return element;
    }
    
    public String getTheUserNameAfterLogIn() throws Exception
    {
        String username;
        try
        {
            username=userNameElementAfterLogIn().getText();
            AutomationLog.info("Getting User Name Successfully");
        }
        catch(Exception e)
        {
            AutomationLog.error("Getting User Name Failed");
            throw(e);
        }
        return username;
     }
}
