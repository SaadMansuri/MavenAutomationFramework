package com.agorafy.automation.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;

public class Admin extends Page 
{
    private WebElement element;

	public Admin(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement link_Listings() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("listing")).findElement(By.tagName("a"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Listings link on admin page");
            throw(e);
        }
        return element;
    }

    public void clickOnListingsLink() throws Exception
    {
        try
        {
            link_Listings().click();
            AutomationLog.info("Successfully clicked on Link listings");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on link listings");
        }
    }

    public void navigateToListing() throws Exception
    {
        try
        {
            driver.get("http://beta.agorafy.com/manage/admin/listing/39973");
            AutomationLog.info("Successfully navigated to listing page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not navigate to listing page");
        }
    }

    public WebElement link_AddShowing() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("showingButton"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Add Showing link");
            throw(e);
        }
        return element;
    }

    public AdminShowings clickOnAddShowingLink() throws Exception
    {
        AdminShowings adminshowings = null;
        try
        {
            link_AddShowing().click();
            adminshowings = new AdminShowings(driver);
            AutomationLog.info("Successfully clicked on Add Showing Link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Add Showing Link");
            throw(e);
        }
        return adminshowings;
    }

    public WebElement btn_Save() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("save"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Save button");
            throw(e);
        }
        return element;
    }

    public void clickOnSaveButton() throws Exception
    {
        try
        {
            btn_Save().click();
            AutomationLog.info("Successfully clicked on save button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on save button");
            throw(e);
        }
    }

    public List<WebElement> list_Showings() throws Exception
    {
        List<WebElement> list = new ArrayList<WebElement>();
        try
        {
            list = driver.findElement(By.id("showingsListDiv")).findElements(By.tagName("li"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Showings list");
            throw(e);
        }
        return list;
    }

    public WebElement icon_DeleteFirstShowing() throws Exception
    {
        try
        {
            element = getFirstShowing().findElement(By.className("fa-trash-o"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find delete icon");
            throw(e);
        }
        return element;
    }

    public void clickOnFirstShowingDeleteIcon() throws Exception 
    {
        try
        {
            icon_DeleteFirstShowing().click();
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on delete icon ");
            throw(e);
        }
    }

    
    public WebElement icon_EditFirstShowing() throws Exception
    {
        try
        {
            element = getFirstShowing().findElement(By.className("fa-edit"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find delete icon");
            throw(e);
        }
        return element;
    }

    public void clickOnFirstShowingEditIcon() throws Exception 
    {
        try
        {
        	icon_EditFirstShowing().click();
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on delete icon ");
            throw(e);
        }
    }

    public WebElement getFirstShowing() throws Exception
    {
        try
        {
            element = list_Showings().get(0);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not get first showing");
            throw(e);
        }
        return element;
    }

    public boolean isShowingPresent() throws Exception
    {
        boolean status = false;
        try
        {
            if(getFirstShowing().findElements(By.className("showings-actions")).size() > 0)
            {
                status = true;
            }
            else
            {
                status = false;
            }
        }
        catch(Exception e)
        {
            throw(e);
        }
        return status;
    }

    public WebElement icon_ListingDetail() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("addressHeading")).findElement(By.className("btn-icon-external"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find ListingDetail icon");
            throw(e);
        }
        return element;
    }

    public ListingDetailPage clickOnListingDetailIcon() throws Exception
    {
        ListingDetailPage listingdetail = null;
        try
        {
            icon_ListingDetail().click();
            listingdetail = new ListingDetailPage(driver);
            AutomationLog.info("Successfully clicked on Listing Detail Icon");
        }
        catch(Exception e)
        {
             AutomationLog.error("Could not click on Listing Detail Icon");
             throw(e);
        }
        return listingdetail;
    }

}
