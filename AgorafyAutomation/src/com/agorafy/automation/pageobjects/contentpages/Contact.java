package com.agorafy.automation.pageobjects.contentpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.footer.support.Press;

public class Contact extends Page
{
    private WebElement element = null;
    public Contact(WebDriver driver)
    {
        super(driver);
    }

    public String getApplicationUrl()
    {
        return applicationUrl();
    }

    public WebElement pageHeadingSection() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("page-column")).findElement(By.className("page-desc"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Page Heading Section");
            throw(e);
        }
        return element;
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = pageHeadingSection().findElement(By.tagName("h2"));
            AutomationLog.info("Contact Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Contact Page Heading Not found");
            throw(e);
        }
        return element;
    }

    @Override
    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }

    public WebElement link_FAQs() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/p/a"));
            AutomationLog.info("FAQs link found on Contact Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find FAQs link on the Contact Page");
            throw(e);
        }
        return element;
    }

    public FAQs clickOnFAQsLink() throws Exception
    {
        FAQs faqs = null;
        try
        {
            link_FAQs().click();
            faqs = new FAQs(driver);
            AutomationLog.info("FAQs link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("FAQs link could not be clicked");
            throw(e);
        }
        return faqs;
    }

    public String newListingHeading() throws Exception
    {
        String headingText = "";
        try
        {
            headingText = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[1]/div/h3")).getText();
            AutomationLog.info("New Listing and Updates heading found on Contact Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find New Listing And Updates heading on Contact Page");
            throw(e);
        }
        return headingText;
    }

    public WebElement listingSupportEmail() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[1]/div/a"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Support Email for New Listing and Updates");
            throw(e);
        }
        return element;
    }

    public String listingSupportEmailText() throws Exception
    {
        return listingSupportEmail().getText();
    }

    public String listingSupportEmailAddressText() throws Exception
    {
        return listingSupportEmail().getAttribute("href");
    }

    public String businessDevelopmentHeading() throws Exception
    {
        String headingText = "";
        try
        {
            headingText = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[2]/div/h3")).getText();
            AutomationLog.info("Business Development and Partnership heading found on Contact Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Business Development and Partnership heading on Contact Page");
            throw(e);
        }
        return headingText;
    }

    public WebElement partnersSupportEmail() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[2]/div/a"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Support Email for Business Development and Partnership");
            throw(e);
        }
        return element;
    }

    public String partnersSupportEmailText() throws Exception
    {
        return partnersSupportEmail().getText();
    }

    public String partnersSupportEmailAddressText() throws Exception
    {
        return partnersSupportEmail().getAttribute("href");
    }

    public String pressAndMarketingHeading() throws Exception
    {
        String headingText = "";
        try
        {
            headingText = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[3]/div/h3")).getText();
            AutomationLog.info("Press And Marketing heading found on Contact Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Press And Marketing heading on Contact Page");
            throw(e);
        }
        return headingText;
    }

    public WebElement link_Press() throws Exception
    {
        try
        {
            //element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[3]/div/a[1]"));
            element = driver.findElement(By.linkText("Visit the Press Room"));
            AutomationLog.info("Visit Press Link found on Contact Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Visit Press Link on Contact Page");
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

    public WebElement pressSupportEmail() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[3]/div/a[2]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Support Email for Press And Marketing");
            throw(e);
        }
        return element;
    }

    public String pressSupportEmailText() throws Exception
    {
        return pressSupportEmail().getText();
    }

    public String pressSupportEmailAddressText() throws Exception
    {
        return pressSupportEmail().getAttribute("href");
    }

    public String investorsRelationHeading() throws Exception
    {
        String headingText = "";
        try
        {
            headingText = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[4]/div/h3")).getText();
            AutomationLog.info("Investor Relations heading found on Contact Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Investor Relations heading on Contact Page");
            throw(e);
        }
        return headingText;
    }

    public WebElement investSupportEmail() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[4]/div/a"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Support Email for Investor Relations");
            throw(e);
        }
        return element;
    }

    public String investSupportEmailText() throws Exception
    {
        return investSupportEmail().getText();
    }

    public String investSupportEmailAddressText() throws Exception
    {
        return investSupportEmail().getAttribute("href");
    }

    public String workHeading() throws Exception
    {
        String headingText = "";
        try
        {
            headingText = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[5]/div/h3")).getText();
            AutomationLog.info("Work at Amazing Company heading found on Contact Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Work at Amazing Company heading on Contact Page");
            throw(e);
        }
        return headingText;
    }

    public WebElement link_Careers() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[5]/div/a[1]"));
            AutomationLog.info("Current Openings Link found on Contact page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Current Openings Link on Contact page");
            throw(e);
        }
        return element;
    }

    public Careers clickOnCareersLink() throws Exception
    {
        Careers careers = null;
        try
        {
            link_Careers().click();
            careers = new Careers(driver);
            AutomationLog.info("Current Openings Link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Current Openings link could not be clicked");
            throw(e);
        }
        return careers;
    }

    public WebElement jobsSupportEmail() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[5]/div/a[2]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Support Email for Work at Amazing Company");
            throw(e);
        }
        return element;
    }

    public String jobsSupportEmailText() throws Exception
    {
        return jobsSupportEmail().getText();
    }

    public String jobsSupportEmailAddressText() throws Exception
    {
        return jobsSupportEmail().getAttribute("href");
    }

    public String generalQuestionsHeading() throws Exception
    {
        String headingText = "";
        try
        {
            headingText = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[6]/div/h3")).getText();
            AutomationLog.info("General Questions And Feedback heading found on Contact Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find General Questions And Feedback heading on Contact Page");
            throw(e);
        }
        return headingText;
    }

    public WebElement link_fAQsUrl() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[6]/div/a[2]"));
            AutomationLog.info("FAQs Link found on Contact page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find FAQs Link on Contact page");
            throw(e);
        }
        return element;
    }

    public FAQs clickOnFAQsUrl() throws Exception
    {
        FAQs faqs = null;
        try
        {
            link_fAQsUrl();
            faqs = new FAQs(driver);
            AutomationLog.info("Blog Link is clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Blog link could not be clicked");
            throw(e);
        }
        return faqs;
    }

    public WebElement helloSupportEmail() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[6]/div/a[1]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Support Email for General Questions And Feedback");
            throw(e);
        }
        return element;
    }

    public String helloSupportEmailText() throws Exception
    {
        return helloSupportEmail().getText();
    }

    public String helloSupportEmailAddressText() throws Exception
    {
        return helloSupportEmail().getAttribute("href");
    }

    public String headquartersHeading() throws Exception
    {
        String headingText = "";
        try
        {
            headingText = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[7]/div/h3")).getText();
            AutomationLog.info("HeadQuarters heading found on Contact Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find HeadQuarters heading on Contact Page");
            throw(e);
        }
        return headingText;
    }

    public WebElement headquartersInfo() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[2]/ul/li[7]/div/p"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Headquarters Info could not be found");
            throw(e);
        }
        return element;
    }

    public String headquartersInfoText() throws Exception
    {
        return headquartersInfo().getText();
    }
}