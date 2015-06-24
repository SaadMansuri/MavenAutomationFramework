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

    public WebElement footer_SocialLinks() throws Exception 
    {
        try
        {
            element = driver.findElement(By.className("footer-right-section")).findElement(By.className("follow-us"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find footer Social links");
            throw(e);
        }
        return element;
    }

    public WebElement link_TwitterLogo() throws Exception
    {
        try
        {
            //element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[5]/a[1]"));
            element = footer_SocialLinks().findElement(By.className("tw"));
            AutomationLog.info("Twitter Logo found on footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Twitter Logo Not found on Footer");
            throw(e);
        }
        return element;
    }

    public AgorafyTwitterPage clickOnTwitterIconLink() throws Exception
    {
        AgorafyTwitterPage agorafyTwitter = null;
        try
        {
            link_TwitterLogo().click();
            agorafyTwitter = new AgorafyTwitterPage(driver);
            AutomationLog.info("Twitter IconLink is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Twitter IconLink could not be clicked");
            throw(e);
        }
        return agorafyTwitter;
    }

    public WebElement link_FacebookLogo() throws Exception
    {
        try
        {
            //element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[5]/a[2]"));
            element = footer_SocialLinks().findElement(By.className("fb"));
            AutomationLog.info("Facebook Logo found on footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Facebook Logo Not found on Footer");
            throw(e);
        }
        return element;
    }

    public AgorafyFacebookPage clickOnFacebookIconLink() throws Exception
    {
        AgorafyFacebookPage agorafyFacebook = null;
        try
        {
            link_FacebookLogo().click();
            agorafyFacebook = new AgorafyFacebookPage(driver);
            AutomationLog.info("Facebook IconLink is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Facebook IconLink could not be clicked");
            throw(e);
        }
        return agorafyFacebook;
    }

    public WebElement link_YoutubeLogo() throws Exception
    {
        try
        {
            //element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[5]/a[3]"));
            element = footer_SocialLinks().findElement(By.className("yt"));
            AutomationLog.info("Youtube Logo found on footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Youtube Logo Not found on Footer");
            throw(e);
        }
        return element;
    }

    public AgorafyYoutubePage clickOnYoutubeIconLink() throws Exception
    {
        AgorafyYoutubePage agorafyYoutube = null;
        try
        {
            link_YoutubeLogo().click();
            agorafyYoutube = new AgorafyYoutubePage(driver);
            AutomationLog.info("Youtube IconLink is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Youtube IconLink could not be clicked");
            throw(e);
        }
        return agorafyYoutube;
    }

    public WebElement link_GooglePlusLogo() throws Exception
    {
        try
        {
            //element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[5]/a[4]"));
            element = footer_SocialLinks().findElement(By.className("gp"));
            AutomationLog.info("GooglePlus Logo found on footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("GooglePlus Logo Not found on Footer");
            throw(e);
        }
        return element;
    }

    public AgorafyGooglePlusPage clickOnGooglePlusIconLink() throws Exception
    {
        AgorafyGooglePlusPage agorafyGooglePlus = null;
        try
        {
            link_GooglePlusLogo().click();
            agorafyGooglePlus = new AgorafyGooglePlusPage(driver);
            AutomationLog.info("Google Plus IconLink is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Google Plus IconLink could not be clicked");
            throw(e);
        }
        return agorafyGooglePlus;
    }

    public WebElement link_LinkedInLogo() throws Exception
    {
        try
        {
            //element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[2]/div/div[5]/a[5]"));
            element = footer_SocialLinks().findElement(By.className("in"));
            AutomationLog.info("LinkedIn Logo found on footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("LinkedIn Logo Not found on Footer");
            throw(e);
        }
        return element;
    }

    public AgorafyLinkedInPage clickOnLinkedInIconLink() throws Exception
    {
        AgorafyLinkedInPage agorafyLinkedIn = null;
        try
        {
            link_LinkedInLogo().click();
            agorafyLinkedIn = new AgorafyLinkedInPage(driver);
            AutomationLog.info("LinkedIn IconLink is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("LinkedIn IconLink could not be clicked");
            throw(e);
        }
        return agorafyLinkedIn;
    }
}