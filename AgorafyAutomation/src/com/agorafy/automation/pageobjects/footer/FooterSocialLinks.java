package com.agorafy.automation.pageobjects.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.social.AgorafyFacebookPage;
import com.agorafy.automation.pageobjects.footer.social.AgorafyGooglePlusPage;
import com.agorafy.automation.pageobjects.footer.social.AgorafyLinkedInPage;
import com.agorafy.automation.pageobjects.footer.social.AgorafyTwitterPage;
import com.agorafy.automation.pageobjects.footer.social.AgorafyYoutubePage;

public class FooterSocialLinks extends Page
{
    private WebElement element = null;
    public FooterSocialLinks(WebDriver driver)
    {
        super(driver);
    }

    public WebElement link_TwitterLogo() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[5]/a[1]"));
            AutomationLog.info("Twitter Logo found on footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Twitter Logo Not found on the Footer");
            throw(e);
        }
        return element;
    }

    public AgorafyTwitterPage openTwitterPage() throws Exception
    {
        AgorafyTwitterPage agorafyTwitter = null;
        try
        {
            link_TwitterLogo().click();
            agorafyTwitter = new AgorafyTwitterPage(driver);
            AutomationLog.info("Agorafy Twitter link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Agorafy Twitter link is not clicked");
            throw(e);
        }
        return agorafyTwitter;
    }

    public WebElement link_FacebookLogo() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[5]/a[2]"));
            AutomationLog.info("Facebook Logo found on footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Facebook Logo Not found on the Footer");
            throw(e);
        }
        return element;
    }

    public AgorafyFacebookPage openFacebookPage() throws Exception
    {
        AgorafyFacebookPage agorafyFacebook = null;
        try
        {
            link_FacebookLogo().click();
            agorafyFacebook = new AgorafyFacebookPage(driver);
            AutomationLog.info("Agorafy Facebook link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Agorafy Facebook link is not clicked");
            throw(e);
        }
        return agorafyFacebook;
    }

    public WebElement link_YoutubeLogo() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[5]/a[3]"));
            AutomationLog.info("Youtube Logo found on footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Youtube Logo Not found on the Footer");
            throw(e);
        }
        return element;
    }

    public AgorafyYoutubePage openYoutubePage() throws Exception
    {
        AgorafyYoutubePage agorafyYoutube = null;
        try
        {
            link_YoutubeLogo().click();
            agorafyYoutube = new AgorafyYoutubePage(driver);
            AutomationLog.info("Agorafy Youtube page link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Agorafy Youtube page link is not clicked");
            throw(e);
        }
        return agorafyYoutube;
    }

    public WebElement link_GooglePlusLogo() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[5]/a[4]"));
            AutomationLog.info("GooglePlus Logo found on footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("GooglePlus Logo Not found on the Footer");
            throw(e);
        }
        return element;
    }

    public AgorafyGooglePlusPage openGooglePlusPage() throws Exception
    {
        AgorafyGooglePlusPage agorafyGooglePlus = null;
        try
        {
            link_GooglePlusLogo().click();
            agorafyGooglePlus = new AgorafyGooglePlusPage(driver);
            AutomationLog.info("Agorafy Google Plus link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Agorafy Google Plus link is not clicked");
            throw(e);
        }
        return agorafyGooglePlus;
    }

    public WebElement link_LinkedInLogo() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[5]/a[5]"));
            AutomationLog.info("LinkedIn Logo found on footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("LinkedIn Logo Not found on the Footer");
            throw(e);
        }
        return element;
    }

    public AgorafyLinkedInPage openLinkedInPage() throws Exception
    {
        AgorafyLinkedInPage agorafyLinkedIn = null;
        try
        {
            link_LinkedInLogo().click();
            agorafyLinkedIn = new AgorafyLinkedInPage(driver);
            AutomationLog.info("Agorafy LinkedIn link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Agorafy LinkedIn link is not clicked");
            throw(e);
        }
        return agorafyLinkedIn;
    }
}