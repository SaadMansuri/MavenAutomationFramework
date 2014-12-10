package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class Header extends Page
{
    private WebElement element = null;
    private boolean val=false;

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
            AutomationLog.info("Successfully clicked on signup Link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on signUp Link");
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
            val=loginpopup.popUp_Login().isDisplayed();
            AutomationLog.info("login pop up is displayed");
        }
        catch(Exception e)
        {
            AutomationLog.error("Login pop up is not displayed");
            throw(e);
        }
        return val;
    }

    //Links below are seen when user is logged in

    public WebElement link_ProfileNameOnDashboardAfterLogin() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='mainNav']/li[3]/a[1]/span[2]"));
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
    
    public WebElement dropbox_navigateArrowsearchInputBox() throws Exception
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
    
    public void clickOndropbox_searchInputBox() throws Exception
    {
        try
        {
        	dropbox_navigateArrowsearchInputBox().click();
            AutomationLog.info("Successfully clicked on navigate arrow of dropbox_searchInputBox");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not clicked on navigate arrow of dropbox_searchInputBox ");
            throw(e);
        }
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
        }
        catch(Exception e)
        {
            AutomationLog.error("Heading of LoginPage not found");
            throw(e);
        }
        return Heading;
     }
    
    public WebElement arrowToNavigateForLogout() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//b[@class='caret']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Arrow to navigate for Logout is not  found");
            throw(e);
        }
        return element;
    }
    
    public WebElement logoutXpathonPropertyPage() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//ul[@class='userDropdown dropdown-menu']//a[@href='/logout']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Arrow to navigate for Logout is not  found");
            throw(e);
        }
        return element;
    }
    
    public Homepage logOutProceessOnPropertyDetailPage() throws Exception
    {
    	Homepage homepage = null;
        try
        {
        	arrowToNavigateForLogout().click();
            AutomationLog.info("Successfully click on arrow to navigate to logout");
            logoutXpathonPropertyPage().click();
            homepage = new Homepage(driver);
            AutomationLog.info("Successfully Logout from Property Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Logout from Property Page");
            throw(e);
        }
        return homepage;
    }
    
    public WebElement closeLoginPopUp() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//a[@role='button']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Login Pop Up close button is not found");
            throw(e);
        }
        return element;
    }
    
    public void clickOnCloseLoginPopUp() throws Exception
    {
        try
        {
        	closeLoginPopUp().click();
            AutomationLog.info("Successfully click on Login pop-up close icon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to click on Login pop-up close icon");
            throw(e);
        }
    }
    
    public WebElement btn_searchForm() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("searchFormButton"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Search from button is not found on header");
            throw(e);
        }
        return element;
    }
    
    public void clickOnSearchFormButton() throws Exception
    {
        try
        {
        	btn_searchForm().click();
            AutomationLog.info("Successfully click on Search Form button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to click on Search Form button");
            throw(e);
        }
    }
    
    public WebElement tooltipMessageOnclickingOnEmptySearch() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//div[@class='Zebra_Tooltip_Message']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Tool Tip Message is not found on Header after clicking on empty search button");
            throw(e);
        }
        return element;
    }
    
    public boolean verifyZebraTooltipMessageComesAfterClickingEmptySearchbuttonVisibity() throws Exception
    {
        boolean tooltip;
        try
        {
            tooltip=tooltipMessageOnclickingOnEmptySearch().isDisplayed();
        }
        catch(Exception e)
        {
            AutomationLog.error("Tool Tip After clicking on Empty Search button is failed");
            throw(e);
        }
        return tooltip;
     }
    
    public WebElement dropbox_NeighborhoodStreetAddressZipcodeSearch() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("searchInput"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Neighborhood Street Address Zipcode dropbox is not found");
            throw(e);
        }
        return element;
    }
    
    public void sendDataToNeighborhoodStreetAddressZipcodeSearchDropbox(String data) throws Exception
    {
        try
        {
        	dropbox_NeighborhoodStreetAddressZipcodeSearch().sendKeys(data);
            AutomationLog.info("Successfully enter data in Neighborhood Street Address Zipcode Search Dropbox");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to enter data in Neighborhood Street Address Zipcode Search Dropbox");
            throw(e);
        }
    }
    
    public WebElement autocompleteMenu_ComesAfterTypingTextOnNeighborhoodStreetAddressZipcodeSearchDropbox() throws Exception
    {
        try
        {
        	element = driver.findElement(By.xpath("//li[@class='ui-autocomplete-category']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Autocomplete Menu which Comes After Typing Text On Neighborhood Street Address Search");
            throw(e);
        }
        return element;
    }
    
    public boolean checkingAutoCompleteMenuComesAfterTypingTextOnNeighborhoodStreetAddressZipcodeSearchVisibility() throws Exception
    {
        boolean bool;
        try
        {
            bool=autocompleteMenu_ComesAfterTypingTextOnNeighborhoodStreetAddressZipcodeSearchDropbox().isDisplayed();
        }
        catch(Exception e)
        {
            AutomationLog.error("Fail to check Neighborhoods DropBox Visibility");
            throw(e);
        }
        return bool;
     }
    
}
