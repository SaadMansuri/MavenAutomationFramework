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
    
    public WebElement propertyRecordSignUpLink_element() throws Exception
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
    
    public PropertyDetailPage clickOnSignUpUpLink() throws Exception
    {
        PropertyDetailPage propertydetail = null;
        try
        {
            propertyRecordSignUpLink_element().click();
            propertydetail = new PropertyDetailPage(driver);
            AutomationLog.info("Clicked on signup link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not clicked on signUp link");
            throw(e);
        }
            return propertydetail;
    }
    
    public WebElement getLoginPopUp_element() throws Exception
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
            bool=getLoginPopUp_element().isDisplayed();
        }
        catch(Exception e)
        {
            AutomationLog.error("Login pop-up is not displayed on Property Page");
            throw(e);
        }
        return bool;
     }
    
    public WebElement logInPopUpHeadingText_element() throws Exception
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
            Titlename=logInPopUpHeadingText_element().getText();
            AutomationLog.info("Fetching the title of login pop-up");
        }
        catch(Exception e)
        {
            AutomationLog.error("Fetching Login pop-up box title is failed");
            throw(e);
        }
        return Titlename;
     }
    
    public WebElement emailTextBox_element() throws Exception
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
    
    public WebElement passwordTextBox_element() throws Exception
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
    
    public WebElement loginPopUpSubmitButton_element() throws Exception
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
        PropertyDetailPage propertydetail = null;
        try
        {
            emailTextBox_element().sendKeys(email);
            propertydetail = new PropertyDetailPage(driver);
            AutomationLog.info("Email id is entered in textbox successfully");
            passwordTextBox_element().sendKeys(Password);
            loginPopUpSubmitButton_element().click();
            AutomationLog.info("Login Done");
        }
        catch(Exception e)
        {
            AutomationLog.error("Login process was not done");
            throw(e);
        }
            return propertydetail;
    }
    
    public WebElement propertyRecordSection_element() throws Exception
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
            bool=propertyRecordSection_element().isDisplayed();
        }
        catch(Exception e)
        {
            AutomationLog.error("Property Record Section is not displayed");
            throw(e);
        }
        return bool;
     }
    
    public WebElement signInToContactInformation_element() throws Exception
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
    
    public PropertyDetailPage clickOnSignInToContactInformation() throws Exception
    {
        PropertyDetailPage propertydetail = null;
        try
        {
            signInToContactInformation_element().click();
            propertydetail = new PropertyDetailPage(driver);
            AutomationLog.info("Clicked on 'Sign in to see contact information' link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on 'Sign in to see contact information' link");
            throw(e);
        }
            return propertydetail;
    }
    
    public WebElement userNameElementAfterLogIn_element() throws Exception
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
            username=userNameElementAfterLogIn_element().getText();
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
