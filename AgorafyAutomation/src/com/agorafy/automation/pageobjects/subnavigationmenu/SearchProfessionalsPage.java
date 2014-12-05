package com.agorafy.automation.pageobjects.subnavigationmenu;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    
    public WebElement link_searchProfessionalsElement() throws Exception
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
        	link_searchProfessionalsElement().click();
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
    
    public WebElement txtbx_agentSearch_element() throws Exception
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
    
    public SearchProfessionalsPage sendDataToAgentSearchTextBox(String agentname) throws Exception
    {
        SearchProfessionalsPage searchprofessional = null;
        try
        {
        	txtbx_agentSearch_element().sendKeys(agentname);
            searchprofessional = new SearchProfessionalsPage(driver);
            AutomationLog.info("Agent name is successfully enterted in textbox");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to fill agent name and click on search button");
            throw(e);
        }
            return searchprofessional;
    }
    
    
    public WebElement btn_AgentSearchSearch_element() throws Exception
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
        	txtbx_agentSearch_element().sendKeys(agentname);
            searchprofessional = new SearchProfessionalsPage(driver);
            AutomationLog.info("Agent name is successfully enterted in textbox");
            btn_AgentSearchSearch_element().click();
            AutomationLog.info("Clicked on Agent Search- search button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to fill agent name and click on search button");
            throw(e);
        }
            return searchprofessional;
    }

    public void enterSearchcontentInAgentCompanySearchTextBox(String searchtext) throws Exception
    {
        try
        {
            agentSearchTextBox_element().clear();
            agentSearchTextBox_element().sendKeys(searchtext);
            AutomationLog.info("Successfully entered search text for agent company search");
            
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to enter search text for agent company search ");
            throw(e);
        }
    }

    public WebElement agentTerryExclusives_element() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//div[@class='agent-details'][a[contains(text(),'Terry Bater')]]/p[contains(text(),'exclusive')]"));
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
    
    public WebElement link_companiesTabOnSearchProfessionals_element() throws Exception
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
        	link_companiesTabOnSearchProfessionals_element().click();
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
    
    public WebElement dropBox_NeighborhoodsSearch_element() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//div[@id='commercial_neighborhoodSelect_chosen']//input[@value='Select neighborhoods']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Neighborhoods Search TextBox Not found");
            throw(e);
        }
        return element;
    }
    
    public WebElement clickOnNeighborhoodsSearchDropBox() throws Exception
    {
        try
        {
        	dropBox_NeighborhoodsSearch_element().click();
            AutomationLog.info("Successfully click on Neighborhoods Search DropBox");
        }
        catch(Exception e)
        {
            AutomationLog.error("Neighborhoods Search TextBox Not found");
            throw(e);
        }
        return element;
    }
        
    public WebElement dropboxOptionListing_neighborhoods_element(String neighbor) throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//li[@class='active-result group-option'][contains(text(),'"+neighbor+"')]"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Neighborhoods Search Button Not found");
            throw(e);
        }
        return element;
    }
    
    public SearchProfessionalsPage clickOnneighborhoodsOptionListing(String neighbor) throws Exception
    {
        SearchProfessionalsPage searchprofessional = null;
        try
        {
        	dropboxOptionListing_neighborhoods_element(neighbor).click();
            searchprofessional = new SearchProfessionalsPage(driver);
            AutomationLog.info("Clicked on neighborhoods "+neighbor+" Option from Listing");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Clicked on neighborhoods Option Listing");
            throw(e);
        }
            return searchprofessional;
    }
    
    public WebElement dropbox_autocompleteMenu_Of_NeighborhoodsList_element() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//div[@class='chosen-drop']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Neighborhoods List Of Options Not found");
            throw(e);
        }
        return element;
    }
        
    public SearchProfessionalsPage ActionToProvideFocusOnDropBox() throws Exception
    {
        SearchProfessionalsPage searchprofessional = null;
        try
        {
            new Actions(driver).moveToElement(dropbox_autocompleteMenu_Of_NeighborhoodsList_element()).perform();
            searchprofessional = new SearchProfessionalsPage(driver);
            AutomationLog.info("Focus Provided to Neighborhoods dropbox is successful");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Provide Focus to Neighborhoods dropbox");
            throw(e);
        }
            return searchprofessional;
    }
    
    public boolean checkingNeighborhoodsDropBoxVisibility() throws Exception
    {
        boolean bool;
        try
        {
            bool=dropbox_autocompleteMenu_Of_NeighborhoodsList_element().isDisplayed();
        }
        catch(Exception e)
        {
            AutomationLog.error("Fail to check Neighborhoods DropBox Visibility");
            throw(e);
        }
        return bool;
     }
    
    public WebElement checkbox_OfOfficeLeasingInExpertise_element() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//input[@id='exp_office']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Checkbox of Office Leasing In Expertise Not found");
            throw(e);
        }
        return element;
    }
    
    public SearchProfessionalsPage clickingOncheckboxOfOfficeLeasingInExpertise() throws Exception
    {
        SearchProfessionalsPage searchprofessional = null;
        try
        {
        	checkbox_OfOfficeLeasingInExpertise_element().click();
            searchprofessional = new SearchProfessionalsPage(driver);
            AutomationLog.info("Clicked on Checkbox of Office Leasing In Expertise");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Clicked on Checkbox of Office Leasing In Expertise");
            throw(e);
        }
            return searchprofessional;
    }

    public WebElement checkbox_OfRetailLeasingInExpertise_element() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//input[@id='exp_retail']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Checkbox of Retail Leasing In Expertise Not found");
            throw(e);
        }
        return element;
    }
    
    public SearchProfessionalsPage clickingOncheckboxOfRetailLeasingInExpertise() throws Exception
    {
        SearchProfessionalsPage searchprofessional = null;
        try
        {
        	checkbox_OfRetailLeasingInExpertise_element().click();
            searchprofessional = new SearchProfessionalsPage(driver);
            AutomationLog.info("Clicked on Checkbox of RetailLeasing In Expertise");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Clicked on Checkbox of Retail Leasing In Expertise");
            throw(e);
        }
            return searchprofessional;
    }
    
    public WebElement checkbox_OfLandlordRepresentationInConcentration_element() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("rep_landlord"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Checkbox of Landlord Representation In Concentration Not found");
            throw(e);
        }
        return element;
    }
    
    public SearchProfessionalsPage clickingOnLandlordRepresentationInConcentration() throws Exception
    {
        SearchProfessionalsPage searchprofessional = null;
        try
        {
        	checkbox_OfLandlordRepresentationInConcentration_element().click();
            searchprofessional = new SearchProfessionalsPage(driver);
            AutomationLog.info("Clicked on Checkbox of Landlord Representation In Concentration");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Clicked on Checkbox of Landlord Representation In Expertise");
            throw(e);
        }
            return searchprofessional;
    }
    
    public WebElement checkbox_OfTenantRepresentationInConcentration_element() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("rep_tenant"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Checkbox of Tenant Representation In Concentration Not found");
            throw(e);
        }
        return element;
    }
    
    public SearchProfessionalsPage clickingOncheckboxOfTenantRepresentationInConcentration() throws Exception
    {
        SearchProfessionalsPage searchprofessional = null;
        try
        {
        	checkbox_OfTenantRepresentationInConcentration_element().click();
            searchprofessional = new SearchProfessionalsPage(driver);
            AutomationLog.info("Clicked on Checkbox of Tenant Representation In Concentration");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Clicked on Checkbox of Tenant Representation In Concentration");
            throw(e);
        }
            return searchprofessional;
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
