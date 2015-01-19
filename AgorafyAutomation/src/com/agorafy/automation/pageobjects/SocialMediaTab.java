package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;

public class SocialMediaTab extends Page
{
    private WebElement element = null;

    public SocialMediaTab(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement tab_SocialMedia() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='tabs']/li[4]/a"));
            AutomationLog.info("SocialMedia tab found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found SocialMedia Tab");
            throw(e);
        }
        return element;
        
    }

    public WebElement btn_SignInWithLinkedIn() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("li_ui_li_gen_1420010421520_0-title"));
            AutomationLog.info("Sign in with Linkedin button found ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Sign in with Linkedin button");
            throw(e);
        }
        return element;
    }

    public void clickOnSignInWithLinkedInButton() throws Exception
    {
        try
        {
            btn_SignInWithLinkedIn().click();
            AutomationLog.info("Successfully clicked on SignInWithLinkedIn button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on SignInWithLinkedIn button");
            throw(e);
        }
    }
    
    public void clickOnSocialMediaTab() throws Exception
    {
        try
        {
            tab_SocialMedia().click();
            AutomationLog.info("Successfully clicked on SocialMedia Tab");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on SocialMedia tab");
            throw(e);
        }
    }

    public WebElement txtbx_ConnectYourTwitterProfile() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("twitter"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Connect Your Twitter Profile Textbox");
            throw(e);
        }
        return element;
    }

    public WebElement btn_Save() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("socialSubmit"));
            AutomationLog.info("Save button found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Save button");
            throw(e);
        }
        return element;
        
    }

    public By successMessageLocator() throws Exception
    {
        return By.xpath("//div[@style='display: block;']");
    }

    public void clickOnSaveButton() throws Exception
    {
        try
        {
            btn_Save().click();
            WaitFor.waitForPageToLoad(driver, "Success!", successMessageLocator());
            AutomationLog.info("Successfully clicked on Save button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Save button");
            throw(e);
        }
    }

    public WebElement msg_Success() throws Exception
    {
        try
        {
            element = driver.findElement(successMessageLocator());
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find success message");
            throw(e);
        }
        return element;
    }

    public void validTwitterProfileName(String name) throws Exception
    {
        txtbx_ConnectYourTwitterProfile().clear();
        txtbx_ConnectYourTwitterProfile().sendKeys(name);
        AutomationLog.info("Successfully entered text in ConnectYourTwitterProfile text box");
    }
}
