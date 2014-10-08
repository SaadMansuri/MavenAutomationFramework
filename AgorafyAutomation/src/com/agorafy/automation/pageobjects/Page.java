package com.agorafy.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.Configuration;
import com.agorafy.automation.pageobjects.footer.Footer;

public class Page 
{
    public static WebDriver driver;

    public Page(WebDriver driver)
    {
        Page.driver = driver;
    }

    protected String applicationUrl()
    {
        return Configuration.getConfigurationValueForProperty("applicationURL");
    }

    public static Header header()
    {
        return PageFactory.initElements(driver, Header.class);
    }

    public static Footer footer() 
    {
        return PageFactory.initElements(driver, Footer.class);
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
}
