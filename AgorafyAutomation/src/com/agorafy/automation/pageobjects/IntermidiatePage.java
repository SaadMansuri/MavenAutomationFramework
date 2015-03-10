package com.agorafy.automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.upsellpopups.ListingDetailPage;

public class IntermidiatePage extends Page 
{

    WebElement element; 
    public IntermidiatePage(WebDriver driver) 
    {
        super(driver);
    }

    public List<WebElement> allListingsInCurrentProperty() throws Exception 
    {
        List<WebElement> allListingElements = null;
        try 
        {
            WebElement parent1 = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div[2]/div"));
            WebElement child = parent1.findElement(By.tagName("tbody"));
            allListingElements = child.findElements(By.tagName("tr"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("Failed to locate all elements of listings in current property");
            throw (e);
        }
        return allListingElements;
    }

    public ListingDetailPage selectFirstListingOnIntermidiatePage() throws Exception
    {
        ListingDetailPage listingDetailPage;
        for(WebElement singleListing : allListingsInCurrentProperty())
        {
            singleListing.click();
            break;
        }
        listingDetailPage = new ListingDetailPage(driver);
        return listingDetailPage;
    }

}
