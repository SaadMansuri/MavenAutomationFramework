package com.agorafy.automation.pageobjects.footer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.contentpages.Blog;
import com.agorafy.automation.pageobjects.contentpages.FAQs;
import com.agorafy.automation.pageobjects.contentpages.HowItWorks;
import com.agorafy.automation.pageobjects.footer.support.Feedback;
import com.agorafy.automation.pageobjects.footer.support.Press;

public class FooterSupportLinks extends Page
{
    private WebElement element = null;
    public FooterSupportLinks(WebDriver driver)
    {
        super(driver);
    }

    public WebElement link_HowItWorks() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[1]/div/div[2]/ul/li[1]/a"));
            AutomationLog.info("How It Works link found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("How It Works link not found on the Footer");
            throw(e);
        }
        return element;
    }

    public HowItWorks openHowItWorks() throws Exception
    {
        HowItWorks howItWorks = null;
        try
        {
            link_HowItWorks().click();
            howItWorks = new HowItWorks(driver);
            AutomationLog.info("How It Works link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("How It Works link is not clicked");
            throw(e);
        }
        return howItWorks;
    }

    public WebElement link_Blog() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[1]/div/div[2]/ul/li[2]/a"));
            AutomationLog.info("Blog link found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Blog link not found on the Footer");
            throw(e);
        }
        return element;
    }

    public Blog openBlog() throws Exception
    {
        Blog blog = null;
        try
        {
            link_Blog().click();
            blog = new Blog(driver);
            AutomationLog.info("Blog link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Blog link is not clicked");
            throw(e);
        }
        return blog;
    }

    public WebElement link_Press() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[1]/div/div[2]/ul/li[3]/a"));
            AutomationLog.info("Press link found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Press link not found on the Footer");
            throw(e);
        }
        return element;
    }

    public Press openPress() throws Exception
    {
        Press press = null;
        try
        {
            link_Press().click();
            press = new Press(driver);
            AutomationLog.info("Press link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Press link is not clicked");
            throw(e);
        }
        return press;
    }

    public WebElement link_FAQs() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[1]/div/div[2]/ul/li[4]/a"));
            AutomationLog.info("FAQs link found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("FAQs link not found on the Footer");
            throw(e);
        }
        return element;
    }

    public FAQs openFAQs() throws Exception
    {
        FAQs fAQs = null;
        try
        {
            link_FAQs().click();
            fAQs = new FAQs(driver);
            AutomationLog.info("FAQs link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("FAQs link is not clicked");
            throw(e);
        }
        return fAQs;
    }

    public WebElement link_Feedback() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='footer']/div/div[1]/div[1]/div/div[2]/ul/li[5]/a"));
            AutomationLog.info("Feedback link found on the Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Feedback link not found on the Footer");
            throw(e);
        }
        return element;
    }

    public Feedback openFeedback() throws Exception
    {
        Feedback feedback = null;
        try
        {
            link_Feedback().click();
            feedback = new Feedback(driver);
            AutomationLog.info("Feedback link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Feedback link is not clicked");
            throw(e);
        }
        return feedback;
    }
}