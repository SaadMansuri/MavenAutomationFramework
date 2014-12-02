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

    public WebElement txtbx_SearchTerm() throws Exception
    {
        try
        {
            element= driver.findElement(By.id("searchInput"));
            AutomationLog.info("SearchTerm text box found ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found SearchTerm text box ");
            throw(e);
        }
        return element;
    }

    public WebElement dropdown_SelectListingCategoryIcon() throws Exception 
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='listingCategorySelect']/div/span"));
            AutomationLog.info("Select Listing Catrgory Icon found ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Select Listing Catrgory Icon ");
            throw(e);
        }
        return element;
    }

    public void clickOnSelectListingCategoryIcon() throws Exception
    {
        try
        {
            dropdown_SelectListingCategoryIcon().click();
            AutomationLog.info("Successfully clicked on SelectListingCategoryIcon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on SelectListingCategoryIcon");
            throw(e);
        }
    }
    public WebElement dropdownOption_Residential() throws Exception
    {
        try
        {
            element= driver.findElement(By.xpath(".//*[@id='listingCategorySelect']/ul/li[2]/a"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Residential category in dropdown");
            throw(e);
        }
        return element;
    }

    public void selectResidentialListingCategory() throws Exception
    {
        try
        {
            dropdownOption_Residential().click();
            AutomationLog.info("Successfully selected residential category option ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not select Residential category option");
            throw(e);
        }
    }
    public WebElement btn_Search() throws Exception 
    {
        try
        {
            element=driver.findElement(By.id("searchFormButton"));
            AutomationLog.info("Search button found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Search button");
            throw(e);
        }
        return element;
    }

    public void clickOnSearchButtton() throws Exception
    {
        try
        {
            btn_Search().click();
            AutomationLog.info("Clicked on search button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not clicked on Search button");
            throw(e);
        }
    }

    public PropertySearch populateSearchTermTextBox() throws Exception
    {
        PropertySearch propertysearch=null;
        try
        {
            clickOnSelectListingCategoryIcon();
            selectResidentialListingCategory();
            txtbx_SearchTerm().sendKeys("Rentals in 10010");
            clickOnSearchButtton();
            propertysearch=new PropertySearch(driver);
            AutomationLog.info("Search is performed successfully");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not performed Search");
            throw(e);
        }
        return propertysearch;
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
