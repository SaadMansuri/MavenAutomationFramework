package com.agorafy.automation.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.agorafy.automation.automationframework.Configuration;
import com.agorafy.automation.pageobjects.footer.Footer;
import com.agorafy.automation.pageobjects.subnavigationmenu.SubNavigation;

public class Page 
{
    public static WebDriver driver;
    public static boolean urlStatus = false;

    public Page(WebDriver driver)
    {
        Page.driver = driver;
    }

    protected String applicationUrl()
    {
        String protocol = "http://";
        if(isSecured())
        {
            protocol = "https://";
        }
        return (protocol + Configuration.getConfigurationValueForProperty("applicationURL"));
    }

    protected boolean isSecured()
    {
        return urlStatus;
    }

    public static Header header()
    {
        return PageFactory.initElements(driver, Header.class);
    }

    public static Footer footer() 
    {
        return PageFactory.initElements(driver, Footer.class);
    }

    public static ContentPagesLeftMenu contentPagesLeftMenu()
    {
        return PageFactory.initElements(driver, ContentPagesLeftMenu.class);
    }

    public String currentURL() throws Exception
    {
        return driver.getCurrentUrl();
    }

    public String currentPageTitle() throws Exception
    {
        return driver.getTitle();
    }

    protected String getTextfromElement(WebElement element) throws Exception
    {
        return element.getText();
    }

    public static SubNavigation subNavigation()
    {
        return PageFactory.initElements(driver, SubNavigation.class);
    }

    public String pageHeading() throws Exception
    { 
        return "";
    }

    public void refreshPage() 
    {
        driver.navigate().refresh();
    }

    public boolean alertAccept() 
    {
        driver.switchTo().alert().accept();
        return true;
    }

    public void alertDismiss() 
    {
        driver.switchTo().alert().dismiss();
    }

    public static void navigateToPreviousPage() 
    {
        driver.navigate().back();
    }

    public static void scrollPage(int x, int y) 
    {
         JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
         jsExecutor.executeScript("window.scrollBy("+x+","+y+")", "");
    }

    public WebElement getVisibleElement(By element)
    {
        List<WebElement> list = new ArrayList<WebElement>();
        WebElement visibleElement = null;
        try
        {
            list = driver.findElements(element);
            for(WebElement ele : list)
            {
                if(ele.isDisplayed())
                {
                    visibleElement = ele;
                }
            }
        }
        catch(Exception e)
        {
            throw(e);
        }
        return visibleElement;
    }
}
