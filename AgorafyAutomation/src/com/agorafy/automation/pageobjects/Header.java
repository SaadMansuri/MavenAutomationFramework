package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class Header extends Page
{
    private WebElement element = null;

    public Header(WebDriver driver)
    {
        super(driver);
        }

    public WebElement link_Login() throws Exception
    {
        try 
        {
            element = driver.findElement(By.linkText("Log In"));
            AutomationLog.info("Login link found in the Header");
            }
        catch (Exception e)
        {
            AutomationLog.error("Login link was not found in the Header");
            throw(e);
        }

        return element;
    }

    public WebElement link_SignUp() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='headerRegisterButton']/span"));
            AutomationLog.info("SignUp link found in the Header");
        }
        catch (Exception e)
        {
            AutomationLog.error("Sign up link was not found in the Header");
            throw(e);
        }

        return element;
    }

    public SignUp clickOnSignUpUpLink() throws Exception
    {
        SignUp signup = null;
        try
        {
            link_SignUp().click();
            signup = new SignUp(driver);
            AutomationLog.info("Clicked on signup button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not clicked on signUp button");
            throw(e);
        }
            return signup;
    }

    public WebElement link_SubmitListing() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='mainNav']/li[1]/a"));
            AutomationLog.info("Submit listing link found in the Header");
        }
        catch (Exception e)
        {
            AutomationLog.error("Submit listing link was not found in the Header");
            throw(e);
        }
        return element;
    }

    public LoginPopUp clickOnSubmitListingLink() throws Exception
    {
        LoginPopUp loginpopup=null;
        try
        {
            link_SubmitListing().click();
            loginpopup=new LoginPopUp(driver);
            AutomationLog.info("Successfully clicked on submit listing link");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not click on submit listing link");
            throw(e);
        }
        return loginpopup;
    }
    
    public boolean loginPopUpIsDisplayed(LoginPopUp loginpopup) throws Exception
    {
        try
        {
            loginpopup.popUp_Login().isDisplayed();
            AutomationLog.info("login pop up is displayed");
        }
        catch(Exception e)
        {
            AutomationLog.error("Login pop up is not displayed");
            throw(e);
        }
        return true;
    }

    //Links below are seen when user is logged in

    public WebElement link_ProfileNameOnDashboardAfterLogin() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='mainNav']/li[3]/a[1]/span[2]"));
            AutomationLog.info("Profile name found in the Header");
        }
        catch (Exception e)
        {
            AutomationLog.error("Profile name was not found in the Header");
            throw(e);
        }
        return element;
     }

    public WebElement link_Dashboard() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='mainNav']/li[3]/ul/li[1]/a"));
            AutomationLog.info("My Dashboard link found when Profile name is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("My Dashboard link not found when Profile name is clicked");
            throw(e);
        }
        return element;
    }

    public WebElement link_Logout() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Logout"));
            AutomationLog.info("Logout link found in the Header");
        }
        catch (Exception e)
        {
            AutomationLog.error("Logout link Not found in the Header");
            throw(e);
        }
        return element;
    }

    public void openActiveProfile() throws Exception
    {
        try
        {
            link_ProfileNameOnDashboardAfterLogin().click();
            AutomationLog.info("Opened drop down for active profile link");
        }
        catch (Exception e)
        {
        	AutomationLog.error("Not able to open drop down for active profile link");
        	throw(e);
        }
    }

    public Dashboard openDashboard() throws Exception
     {
        Dashboard element = null;
        try
        {
             link_Dashboard().click();
             element = new Dashboard(driver);
             AutomationLog.info("Opened Dashboard successfully");
         }
         catch (Exception e)
         {
             AutomationLog.error("Not able to open Dashboard");
             throw(e);
         }
         return element;
     }

    public WebElement text_ProfileName() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='mainNav']/li[4]/a[1]/span[2]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Profile Name not found on header");
            throw(e);
        }
        return element;
    }

    public String profileName() throws Exception
    {
        String profileName = "";
        try
        {
            profileName = text_ProfileName().getText();
            AutomationLog.info("Name of LoggedIn user found on header");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve Profile Name");
            throw(e);
        }
        return profileName;
    }

    public String greeting() throws Exception
    {
        String greeting="";
        try
        {
            greeting = driver.findElement(By.xpath(".//*[@id='mainNav']/li[3]/a[1]/span[2]")).getText();
            AutomationLog.info("Greeting found after successful Login");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Greeting after successful Login");
            throw(e);
        }
        return greeting;
    }
    
    public WebElement dropbox_searchInputBox() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("advancedSearch"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Search Input dropbox is not present");
            throw(e);
        }
        return element;
    }
    
    public SignUp clickOndropbox_searchInputBox() throws Exception
    {
    	SignUp signup = null;
        try
        {
        	dropbox_searchInputBox().click();
        	signup = new SignUp(driver);
            AutomationLog.info("Successfully clicked on dropbox_searchInputBox");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on dropbox_searchInputBox ");
            throw(e);
        }
        return signup;
    }
    
    public WebElement advancedSearchFormId() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("advancedSearchForm"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Search advancedSearchForm is not present");
            throw(e);
        }
        return element;
    }
    
    public boolean verifyAdvancedSearchFormVisibity() throws Exception
    {
    	boolean Heading;
        try
        {
        	Heading=advancedSearchFormId().isDisplayed();
            AutomationLog.info("visbility of Advanced Search Form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Heading of LoginPage not found");
            throw(e);
        }
        return Heading;
     }
}
