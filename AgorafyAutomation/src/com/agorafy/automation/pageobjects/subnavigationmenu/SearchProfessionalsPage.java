package com.agorafy.automation.pageobjects.subnavigationmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Page;

public class SearchProfessionalsPage extends Page
{
    private WebElement element = null;
    public SearchProfessionalsPage(WebDriver driver)
    {
        super(driver);
    }
    
    public SearchProfessionalsPage()
    {
        super(driver);
    }

    public By getAgentLocator() throws Exception
    {
    	return By.xpath(".//*[@id='brokerResults']/li[6]/div[1]/img");
    }
    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div/div[1]/div/h2"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Search Professionals page heading Not found");
            throw(e);
        }
        return element;
    }
    
    public WebElement searchProfessionalsElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//li[4]//a[@href='/search/agent'][contains(.,'Search Professionals')]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Search Professionals page heading Not found");
            throw(e);
        }
        return element;
    }
    
    public SearchProfessionalsPage clickOnSearchProfessionalsLink() throws Exception
    {
        SearchProfessionalsPage searchprofessional = null;
        try
        {
            searchProfessionalsElement().click();
            searchprofessional = new SearchProfessionalsPage(driver);
            WaitFor.waitForPageToLoad(driver);
            AutomationLog.info("Clicked on Search Professionals link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Clicked on Search Professionals link");
            throw(e);
        }
            return searchprofessional;
    }
    
    public WebElement agentSearchTextBox_element() throws Exception
    {
        try
        {
            element = driver.findElement(By.name("name"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Agent Search Text Box is Not found");
            throw(e);
        }
        return element;
    }
    
    public WebElement agentSearchSearchButton_element() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("agentSearchButton"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Agent Search- Search button Not found");
            throw(e);
        }
        return element;
    }
    
    public SearchProfessionalsPage enterAgentOrCompanyNameinAgentSearchAndClickonSearchButton(String agentname) throws Exception
    {
        SearchProfessionalsPage searchprofessional = null;
        try
        {
            agentSearchTextBox_element().sendKeys(agentname);
            searchprofessional = new SearchProfessionalsPage(driver);
            AutomationLog.info("Agent name is successfully enterted in textbox");
            agentSearchSearchButton_element().click();
            AutomationLog.info("Clicked on Agent Search- search button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to fill agent name and click on search button");
            throw(e);
        }
            return searchprofessional;
    }
    
    public WebElement agentTerryExclusives_element() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//div[@class='agent-details'][a[contains(text(),'Terry Bater')]]/p[contains(text(),'exclusives')]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Agent Terry Exclusives Not found");
            throw(e);
        }
        return element;
    }
    
    public String getTheCountOFAgentTerryExclusives()  throws Exception
    {
        String Countofagentexclusives="";
        try{
            Countofagentexclusives = agentTerryExclusives_element().getText();
         }
        catch(Exception e)
        {
            AutomationLog.error("Agent Terry Exclusives Not found");
            throw(e);
        }
        return Countofagentexclusives;
    }
    
    public WebElement companiesTabOnSearchProfessionals_element() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//a[@href='#companies']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Companies Tab is not found on Search Professionals Page");
            throw(e);
        }
        return element;
    }
    
    public SearchProfessionalsPage clickOnCompaniesTabOnSearchProfessionals() throws Exception
    {
        SearchProfessionalsPage searchprofessional = null;
        try
        {
            companiesTabOnSearchProfessionals_element().click();
            searchprofessional = new SearchProfessionalsPage(driver);
            AutomationLog.info("Clicked on Companies Tab On SearchProfessionals Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Clicked on Companies Tab On SearchProfessionals Page");
            throw(e);
        }
            return searchprofessional;
    }
    
    public WebElement companyDumannExclusive_element() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//div[@class='agent-details'][a[contains(text(),'Dumann Realty')]]/p[contains(text(),'exclusive')]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Company Dumann Realty is Not found");
            throw(e);
        }
        return element;
    }

    public WebElement searchAgentResultMessage() throws Exception 
    {
        try
        {
            element =driver.findElement(By.id("resultsLineItemsAgents"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Agent Search Result text");
            throw(e);
        }
        return element;
        
    }

    public WebElement searchCompaniesResultMessage() throws Exception 
    {
        try
        {
            element =driver.findElement(By.id("resultsLineItemsCompanies"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Company Search Result text");
            throw(e);
        }
        return element;
        
    }
    public String getTextForSearch(WebElement element) throws Exception
    {
        String searchmsg=null;
        WebElement searchelement=element;
        try
        {
            searchmsg=searchelement.getText();
            AutomationLog.info("Get search result message successfull");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not get search result message");
            throw(e);
        }
        return searchmsg;
    }

    public String getTheCountOFCompanyDumannExclusive()  throws Exception
    {
        String Countofcompanyexclusive="";
        try{
            Countofcompanyexclusive = companyDumannExclusive_element().getText();
         }
        catch(Exception e)
        {
            AutomationLog.error("Company Dumann Realty Exclusive is Not found");
            throw(e);
        }
        return Countofcompanyexclusive;
    }

    @Override
    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }

    public String getURL()
    {
        return applicationUrl() + "/search/agent";
    }
}
