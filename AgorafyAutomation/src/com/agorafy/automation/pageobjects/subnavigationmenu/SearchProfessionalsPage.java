package com.agorafy.automation.pageobjects.subnavigationmenu;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.Page;

public class SearchProfessionalsPage extends Page
{
    private WebElement element = null;
    private List<WebElement> options=null;
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

    public WebElement btn_ClearOnExpertiseSearch() throws Exception
    {
        try
        {
            element=driver.findElement(By.id("brokerClearButton"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find clear button on expertise search panel");
            throw(e);
        }
        return element;
    }

    public void clickOnClearButtonOnExpertiesSearchPanel() throws Exception
    {
        try
        {
            btn_ClearOnExpertiseSearch().click();
            AutomationLog.info("Successfully clicked on Clear button on Expertise search panel");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could no click on Clear button");
            throw(e);
        }
        
        
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
            AutomationLog.error("Failed to Click on Search Professionals link");
            throw(e);
        }
            return searchprofessional;
    }
    
    public WebElement txtbx_agentSearch() throws Exception
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
    
    public void sendDataToAgentSearchTextBox(String agentname) throws Exception
    {
        try
        {
            txtbx_agentSearch().sendKeys(agentname);
            AutomationLog.info("Agent name is successfully enterted in textbox");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to fill agent name and click on search button");
            throw(e);
        }
    }
    
    
    public WebElement btn_AgentSearchSearch() throws Exception
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
    
    public void enterAgentOrCompanyNameinAgentSearchAndClickonSearchButton(String agentname) throws Exception
    {
        try
        {
            txtbx_agentSearch().sendKeys(agentname);
            AutomationLog.info("Agent name is successfully enterted in textbox");
            btn_AgentSearchSearch().click();
            AutomationLog.info("Clicked on Agent Search- search button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to fill agent name and click on search button");
            throw(e);
        }
    }

    public void enterSearchcontentInAgentCompanySearchTextBox(String searchtext) throws Exception
    {
        try
        {
            txtbx_agentSearch().clear();
            txtbx_agentSearch().sendKeys(searchtext);
            AutomationLog.info("Successfully entered search text for agent company search");
            
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to enter search text for agent company search ");
            throw(e);
        }
    }

    public WebElement agentTerryExclusives() throws Exception
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
            Countofagentexclusives = agentTerryExclusives().getText();
         }
        catch(Exception e)
        {
            AutomationLog.error("Agent Terry Exclusives Not found");
            throw(e);
        }
        return Countofagentexclusives;
    }
    
    public WebElement link_companiesTabOnSearchProfessionals() throws Exception
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
    
    public void clickOnCompaniesTabOnSearchProfessionals() throws Exception
    {
        try
        {
            link_companiesTabOnSearchProfessionals().click();
            AutomationLog.info("Clicked on Companies Tab On SearchProfessionals Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on Companies Tab On SearchProfessionals Page");
            throw(e);
        }
    }
    
    public WebElement companyDumannExclusive() throws Exception
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
            Countofcompanyexclusive = companyDumannExclusive().getText();
         }
        catch(Exception e)
        {
            AutomationLog.error("Company Dumann Realty Exclusive is Not found");
            throw(e);
        }
        return Countofcompanyexclusive;
    }
    
    public WebElement dropBox_NeighborhoodsSearch() throws Exception
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
    
    public void clickOnNeighborhoodsSearchDropBox() throws Exception
    {
        try
        {
            dropBox_NeighborhoodsSearch().click();
            AutomationLog.info("Successfully click on Neighborhoods Search DropBox");
        }
        catch(Exception e)
        {
            AutomationLog.error("Neighborhoods Search TextBox Not found");
            throw(e);
        }
    }
        
    public WebElement dropboxOptionListing_neighborhoods(String neighbor) throws Exception
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
    
    public void clickOnneighborhoodsOptionListing(String neighbor) throws Exception
    {
        try
        {
            dropboxOptionListing_neighborhoods(neighbor).click();
            AutomationLog.info("Clicked on neighborhoods "+neighbor+" Option from Listing");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on neighborhoods Option Listing");
            throw(e);
        }
    }
    
    public WebElement dropbox_autocompleteMenu_Of_NeighborhoodsList() throws Exception
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
        
    public void ActionToProvideFocusOnDropBox() throws Exception
    {
        try
        {
            new Actions(driver).moveToElement(dropbox_autocompleteMenu_Of_NeighborhoodsList()).perform();
            AutomationLog.info("Focus Provided to Neighborhoods dropbox is successful");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Provide Focus to Neighborhoods dropbox");
            throw(e);
        }
    }
    
    public boolean checkingNeighborhoodsDropBoxVisibility() throws Exception
    {
        boolean bool;
        try
        {
            bool=dropbox_autocompleteMenu_Of_NeighborhoodsList().isDisplayed();
        }
        catch(Exception e)
        {
            AutomationLog.error("Fail to check Neighborhoods DropBox Visibility");
            throw(e);
        }
        return bool;
     }
    
    public WebElement checkbox_OfOfficeLeasingInExpertise() throws Exception
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
    
    public void clickingOncheckboxOfOfficeLeasingInExpertise() throws Exception
    {
        try
        {
            checkbox_OfOfficeLeasingInExpertise().click();
            AutomationLog.info("Clicked on Checkbox of Office Leasing In Expertise");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on Checkbox of Office Leasing In Expertise");
            throw(e);
        }
    }

    public WebElement checkbox_OfRetailLeasingInExpertise() throws Exception
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
    
    public void clickingOncheckboxOfRetailLeasingInExpertise() throws Exception
    {
        try
        {
            checkbox_OfRetailLeasingInExpertise().click();
            AutomationLog.info("Clicked on Checkbox of RetailLeasing In Expertise");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on Checkbox of Retail Leasing In Expertise");
            throw(e);
        }
    }
    
    public WebElement checkbox_OfLandlordRepresentationInConcentration() throws Exception
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
    
    public void clickingOnLandlordRepresentationInConcentration() throws Exception
    {
        try
        {
            checkbox_OfLandlordRepresentationInConcentration().click();
            AutomationLog.info("Clicked on Checkbox of Landlord Representation In Concentration");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on Checkbox of Landlord Representation In Expertise");
            throw(e);
        }
    }
    
    public WebElement checkbox_OfTenantRepresentationInConcentration() throws Exception
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
    
    public void clickingOncheckboxOfTenantRepresentationInConcentration() throws Exception
    {
        try
        {
            checkbox_OfTenantRepresentationInConcentration().click();
            AutomationLog.info("Clicked on Checkbox of Tenant Representation In Concentration");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on Checkbox of Tenant Representation In Concentration");
            throw(e);
        }
    }

    public WebElement checkbox_BuildingManagament() throws Exception
    {
        try
        {
            element=driver.findElement(By.id("exp_building"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find checkbox for Building managament");
            throw(e);
        }
        return element;
    }

    public void clickOnBuildingManagementCheckBox() throws Exception
    {
        try
        {
            checkbox_BuildingManagament().click();
            AutomationLog.info("Successfully clicked on Building management checkbox");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Building management checkbox");
            throw(e);
        }
    }
    public WebElement checkbox_InvestmentSales() throws Exception
    {
        try
        {
            element=driver.findElement(By.id("exp_investment"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find checkbox for InvestmentSales");
            throw(e);
        }
        return element;
    }

    public void clickOnInvestmentSalesCheckBox() throws Exception
    {
        try
        {
            checkbox_InvestmentSales().click();
            AutomationLog.info("Successfully clicked on InvestmentSales checkbox");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on InvestmentSales checkbox");
            throw(e);
        }
    }

    public void markCheckboxesInExpertiseAndConcentration() throws Exception
    {
        try
        {
            WebElement select = driver.findElement(By.id("commercialBrokerage"));
            options = select.findElements(By.name("expertises[]"));
            for(WebElement option:options)
            {
                option.click();
            }

            options = select.findElements(By.name("representations[]"));
            for(WebElement option:options)
            {
                option.click();
            }
            AutomationLog.info("Successfully marked all the checkboxes  ");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could no mark all checkboxes in ExpertiseAndConcentration ");
            throw(e);
        }
    }

    public boolean isCheckboxSelected() throws Exception
    {
        boolean val = false,finalval = false;
        int count=0;
        try
        {
        	WebElement select = driver.findElement(By.id("commercialBrokerage"));
            options = select.findElements(By.name("expertises[]"));
            for(WebElement option:options)
            {
                val = option.isSelected();
                if(!val)
                {
                   count++;
                }
            }
            options = select.findElements(By.name("representations[]"));
            for(WebElement option:options)
            {
                val = option.isSelected();
                if(!val)
                {
                   count++;
                }
            }
            if(count==6)
            {
                finalval=val;
            }
            else
            {
                finalval=true;
            }
        }
        catch(Exception e)
        {
            
        }
        return finalval;
    }

           
    public void clickOnSelectOptions(String title) throws Exception
    {
        try
        {
            Select droplist = new Select(driver.findElement(By.name("context")));   
            droplist.selectByVisibleText(title);
            AutomationLog.info("Successfully click on Select Option "+title+"");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Select Option "+title+"");
            throw(e);
        }
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
