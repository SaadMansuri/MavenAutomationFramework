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

    public WebElement footer_SupportLinks() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("footer-left-section")).findElements(By.tagName("div")).get(1);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find FooterCompanyLinks");
            throw(e);
        }
        return element;
    }

    public WebElement link_HowItWorks() throws Exception
    {
        try
        {
            element = footer_SupportLinks().findElement(By.linkText("How It Works"));
            AutomationLog.info("How It Works link found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("How It Works link not found on Footer");
            throw(e);
        }
        return element;
    }

    public HowItWorks clickOnHowItWorksLink() throws Exception
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
            AutomationLog.error("How It Works link could not be clicked");
            throw(e);
        }
        return howItWorks;
    }

    public WebElement link_Blog() throws Exception
    {
        try
        {
            element = footer_SupportLinks().findElement(By.linkText("Blog"));
            AutomationLog.info("Blog link found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Blog link not found on Footer");
            throw(e);
        }
        return element;
    }

    public Blog clickOnBlogLink() throws Exception
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
            AutomationLog.error("Blog link could not be clicked");
            throw(e);
        }
        return blog;
    }

    public WebElement link_Press() throws Exception
    {
        try
        {
            element = footer_SupportLinks().findElement(By.linkText("Press"));
            AutomationLog.info("Press link found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Press link not found on Footer");
            throw(e);
        }
        return element;
    }

    public Press clickOnPressLink() throws Exception
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
            AutomationLog.error("Press link could not be clicked");
            throw(e);
        }
        return press;
    }

    public WebElement link_FAQs() throws Exception
    {
        try
        {
            element = footer_SupportLinks().findElement(By.linkText("FAQs"));
            AutomationLog.info("FAQs link found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("FAQs link not found on Footer");
            throw(e);
        }
        return element;
    }

    public FAQs clickOnFAQsLink() throws Exception
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
            AutomationLog.error("FAQs link could not be clicked");
            throw(e);
        }
        return fAQs;
    }

    public WebElement link_Feedback() throws Exception
    {
        try
        {
            element = footer_SupportLinks().findElement(By.linkText("Feedback"));
            AutomationLog.info("Feedback link found on Footer");
        }
        catch(Exception e)
        {
            AutomationLog.error("Feedback link not found on Footer");
            throw(e);
        }
        return element;
    }

    public Feedback clickOnFeedbackLink() throws Exception
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
            AutomationLog.error("Feedback link could not be clicked");
            throw(e);
        }
        return feedback;
    }
}