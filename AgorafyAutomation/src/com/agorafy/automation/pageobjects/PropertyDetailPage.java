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
            AutomationLog.info("Redirected to property Page,hard code property");
        }
        catch(Exception e)
        {
            AutomationLog.error("Redirected to property Page is failed");
            throw(e);
        }
        return propertydetail;
    }
    
    public WebElement PropertyRecordSignUpLink_element() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//a[@class='upsell ga-track'][@data-ga-label='ViewPropertyRecords']"));
            AutomationLog.info("Signup link found in the Property Detail Page");
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
            PropertyRecordSignUpLink_element().click();
            propertydetail = new PropertyDetailPage(driver);
            AutomationLog.info("Clicked on signup button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not clicked on signUp button");
            throw(e);
        }
            return propertydetail;
    }
    
    public WebElement getIdOfLoginPop_element() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//form[@class='upsellLoginForm']"));
            AutomationLog.info("Getting Id Of Login popup ");
            }
        catch (Exception e)
        {
            AutomationLog.error("Login popup element is not found in Property Detail");
            throw(e);
        }
        return element;
    }
    
    public boolean CheckingLogInPopOnPropertyPage() throws Exception
    {
        boolean bool;
        try
        {
            bool=getIdOfLoginPop_element().isDisplayed();
            AutomationLog.info("Login pop up is displaying on Property Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Login pop up is not displaying on Property Page");
            throw(e);
        }
        return bool;
     }
    
    public WebElement logInPopTextTitle_element() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//span[@class='ui-dialog-title']"));
            AutomationLog.info("Login popup Title webelement in the Property Detail");
            }
        catch (Exception e)
        {
            AutomationLog.error("Login popup Title webelement is not found in Property Detail");
            throw(e);
        }

        return element;
    }
    
    public String getTitleOfLogInPopUp() throws Exception
    {
        String Titlename;
        try
        {
            Titlename=logInPopTextTitle_element().getText();
            AutomationLog.info("Getting title text of Login popup");
        }
        catch(Exception e)
        {
            AutomationLog.error("Title text of Login popup not found");
            throw(e);
        }
        return Titlename;
     }
    
    public WebElement emailTextBox_element() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//div[@class='form-group']/input[@value='']"));
            AutomationLog.info("Email locator is done");
            }
        catch (Exception e)
        {
            AutomationLog.error("Email locator is not done");
            throw(e);
        }

        return element;
    }
    
    public WebElement passwordTextBox_element() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//div[@class='form-group']/input[@placeholder='Enter Password']"));
            AutomationLog.info("Password locator is done");
            }
        catch (Exception e)
        {
            AutomationLog.error("Password locator is not done");
            throw(e);
        }

        return element;
    }
    
    public WebElement loginPopUpSubmitButton_element() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//input[@value='Log in to my account']"));
            AutomationLog.info("Password text is entered in texbox successully");
            }
        catch (Exception e)
        {
            AutomationLog.error("Password text is not entered in texbox");
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
            AutomationLog.info("Property Record Section is found");
            }
        catch (Exception e)
        {
            AutomationLog.error("Property Record Section is not found");
            throw(e);
        }
        return element;
    }
    
    public boolean CheckingPropertyRecordSection() throws Exception
    {
        boolean bool;
        try
        {
            bool=propertyRecordSection_element().isDisplayed();
            AutomationLog.info("Property Record Section is displaying on Property Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Property Record Section is not displaying on Property Page");
            throw(e);
        }
        return bool;
     }
    
    public WebElement signInToContactInformation_element() throws Exception
    {
        try 
        {
            element = driver.findElement(By.xpath("//a[@data-ga-label='ViewContactInformation']"));
            AutomationLog.info("Sign in to contact information is found");
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
            AutomationLog.info("Clicked on Sign in to contact information");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not clicked on Sign in to contact information");
            throw(e);
        }
            return propertydetail;
    }
    
    public WebElement userNameElementAfterLogIn_element() throws Exception
    {
        try 
        {
            element = driver.findElement(By.cssSelector(".profile-name"));
            
            AutomationLog.info("User Name element is found Successfully");
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
