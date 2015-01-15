package com.agorafy.automation.pageobjects.upsellpopups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends LoginPopUp
{
    WebElement element = null;
    public SearchResultsPage(WebDriver driver)
    {
        super(driver);
    }

    public WebElement searchResultsContainer() throws Exception
    {
        try
        {
            driver.findElement(By.id("resultsLineItems"));
        }
        catch(Exception e)
        {
            System.out.println("Results container Not found");
        }
        return element;
    }

    
}
