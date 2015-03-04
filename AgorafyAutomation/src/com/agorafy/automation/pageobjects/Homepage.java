package com.agorafy.automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.subnavigationmenu.MySubscriptions;

public class Homepage extends Page 
{
    private WebElement element = null;

    public Homepage(WebDriver driver)
    {
        super(driver);
    }

    public Homepage() {
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

    public WebElement dropdown_SelectBoroughIcon() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='boroughSelect']/div/span"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Select Borough Icon ");
        }
        return element;
    }

    public void clickOnSelectBoroughIcon() throws Exception
    {
        try
        {
            dropdown_SelectBoroughIcon().click();
            AutomationLog.info("Successfully clicked on Select Borough Icon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Select Borough Icon");
        }
    }

    public WebElement dropdown_SelectListingCategoryIcon() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='listingCategorySelect']/div/span"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Select Borough Icon ");
        }
        return element;
    }

    public void clickOnSelectListingCategoryIcon() throws Exception
    {
        try
        {
            dropdown_SelectListingCategoryIcon().click();
            AutomationLog.info("Successfully clicked on Select Listing CategoryIcon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Select Listing Category Icon");
        }
    }

    public WebElement dropdown_SelectListingCategory() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("listingCategorySelect"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Select Listing Catrgory Icon ");
            throw(e);
        }
        return element;
    }

    public WebElement dropdown_Borough() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("boroughSelect"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Boroughs dropdown");
            throw(e);
        }
        return element;
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

    public void selectListingCategory(String selectcategory) throws Exception
    {
        try
        {
            WebElement select = driver.findElement(By.id("listingCategorySelect"));
            List<WebElement> listingcategories = select.findElements(By.className("dd-option-text"));
            for(WebElement listingcategory:listingcategories)
            {
                if((listingcategory.getText()).equalsIgnoreCase(selectcategory))
                {
                    listingcategory.click();
                    break;
                }
            }
            AutomationLog.info("Successfully selected listing category");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not select listing category");
            throw(e);
        }
    }

    public void selectBorough(String selectborough) throws Exception
    {
        try
        {
            WebElement select = driver.findElement(By.id("boroughSelect"));
            List<WebElement> boroughs = select.findElements(By.className("dd-option-text"));
            for(WebElement borough:boroughs)
            {
                if((borough.getText()).equalsIgnoreCase(selectborough))
                {
                    borough.click();
                    break;
                }
            }
            AutomationLog.info("Successfully selected borough");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not select borough");
            throw(e);
        }
    }

    public WebElement link_MyDashboard() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='mainHeader']/div[3]/div/ul/li[2]/a"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found link My Dashboard");
            throw(e);
        }
        return element;
    }

    public Dashboard clickOnMyDashboardLink() throws Exception 
    {
        Dashboard dashboard = null; 
        try
        {
            link_MyDashboard().click();
            dashboard = new Dashboard(driver);
            AutomationLog.info("Successfully clicked on My Dashboard link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on My dashboard link");
            throw(e);
        }
        return dashboard;
    }
     
    public PropertySearch populateSearchTermTextBox(String boroughname,String listingcategory,String searchstring) throws Exception
    {
        PropertySearch propertysearch=null;
        try
        {
            clickOnSelectBoroughIcon();
            selectBorough(boroughname);
            clickOnSelectListingCategoryIcon();
            selectListingCategory(listingcategory);
            txtbx_SearchTerm().sendKeys(searchstring);
            clickOnSearchButtton();
            propertysearch=new PropertySearch(driver);
            WaitFor.waitUntilElementIsLoaded(driver, By.id("resultsHeader"));
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

    public WebElement dropdown_LoginAvatar() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='mainNav']/li[4]/a[1]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found dropdown of Login avatar");
            throw(e);
        }
        return element;
    }

    /*public Page selectDropdownOptionFromProfilePic(String dropdownOption) 
    {
        Page page = null;
        switch (dropdownOption)
        {
            case "My Dashboard":
            
            page = new Dashboard(driver);
            break;

            case "Switch To Admin":
            page = new Admin(driver);
            break;

            case "Logout":
            page = new Homepage(driver);
            break;
        }
        return page;
    }*/
}
