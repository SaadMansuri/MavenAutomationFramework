package com.agorafy.automation.pageobjects.subnavigationmenu;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.CompanyProfilePage;
import com.agorafy.automation.pageobjects.Page;


public class SearchProfessionalsPage extends Page
{
    private WebElement element = null;
    private List<WebElement> options = null;

    public SearchProfessionalsPage(WebDriver driver)
    {
        super(driver);
    }

    public SearchProfessionalsPage()
    {
        super(driver);
    }

    public WebElement btn_ClearOnExpertiseSearch() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("brokerClearButton"));
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

    public WebElement txtbx_AgentCompanySearch() throws Exception
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

    public WebElement btn_AgentCompanySearch() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("agentSearchButton"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find AgentCompanySearch button ");
            throw(e);
        }
        return element;
    }

    public void searchByAgentOrCompanyName(String name) throws Exception
    {
        try
        {
            enterSearchTextInAgentCompanySearchTextBox(name);
            WaitFor.sleepFor(2000);
            btn_AgentCompanySearch().click();
            AutomationLog.info("Clicked on AgentCompanySearch button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to fill agentcompany name and click on AgentCompanySearch button");
            throw(e);
        }
    }

    public void enterSearchTextInAgentCompanySearchTextBox(String searchtext) throws Exception
    {
        try
        {
            txtbx_AgentCompanySearch().clear();
            txtbx_AgentCompanySearch().sendKeys(searchtext);
            AutomationLog.info("Successfully entered search text for agent company search");
            
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to enter search text for agent company search ");
            throw(e);
        }
    }

    public boolean isAgentExclusivesCountPresent(String name) throws Exception
    { 
        return agentExclusivesCount(name).isDisplayed();
    }

    public WebElement agentExclusivesCount(String name)  throws Exception
    {
        WebElement element = null;
        try
        {
            WebElement select = driver.findElement(By.id("brokerResults"));
            List<WebElement> options = select.findElements(By.className("agent-details"));
            for(WebElement option : options)
            {
                if(option.findElement(By.tagName("a")).getText().equalsIgnoreCase(name))
                {
                    element = option.findElement(By.tagName("p"));
                    break;
                }
            }
            AutomationLog.info("Found Agent Exclusives Count");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Agent Exclusives Count ");
        }
        return element;
    }

    public WebElement link_CompaniesTab() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Companies"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Top Companies Tab is not found on Search Professionals Page");
            throw(e);
        }
        return element;
    }

    public void clickOnCompaniesTabOnSearchProfessionals() throws Exception
    {
        try
        {
            link_CompaniesTab().click();
            AutomationLog.info("Clicked on Companies Tab On SearchProfessionals Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on Companies Tab On SearchProfessionals Page");
            throw(e);
        }
    }

    public WebElement searchAgentResultMessage() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("resultsLineItemsAgents"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Agent Search Result text");
            throw(e);
        }
        return element;
        
    }

    public WebElement searchCompaniesResultMessage() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("resultsLineItemsCompanies"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Company Search Result text");
            throw(e);
        }
        return element;
        
    }

    public boolean isCompanyExclusivesCountPresent(String name) throws Exception 
    {
        return companyExclusiveCount(name).isDisplayed();
    }

    public WebElement companyExclusiveCount(String name)  throws Exception
    {
        WebElement element = null;
        try
        {
            WebElement select = driver.findElement(By.id("companyResults"));
            List<WebElement> options = select.findElements(By.className("agent-details"));
            for(WebElement option : options)
            {
                if(option.findElement(By.tagName("a")).getText().equalsIgnoreCase(name))
                {
                    element = option.findElement(By.tagName("p"));
                    break;
                }
            }
            AutomationLog.info("Found Company Exclusives Count");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not Find Company Exclusives Count");
            throw(e);
        }
        return element;
    }

    public WebElement dropBox_NeighborhoodsSearch() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("s2id_autogen1"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Neighborhoods Search DropBox Not found");
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
            AutomationLog.error("Could not click on Neighborhoods Search DropBox ");
            throw(e);
        }
    }

    public void clickOnNeighborhoodsOptionListing(String neighbor) throws Exception
    {
        try
        {
           WebElement select = driver.findElement(By.id("select2-drop"));
           List<WebElement> options = select.findElements(By.className("select2-result-label"));
           for(WebElement option : options)
           {
               if(option.getText().equalsIgnoreCase(neighbor))
               {
                   option.click();
                   break;
               }
           }
        }
        catch(Exception e)
        {
           AutomationLog.error("Could not select neighborhood");
           throw(e);
        }
    }

    public void clearNeighorhoods() throws Exception
    {
        WebElement select = driver.findElement(By.className("select2-choices"));
        List<WebElement> options = select.findElements(By.className("select2-search-choice-close"));
        for(WebElement optionElement : options)
        {
             optionElement.click();
        }
    }

    public WebElement msg_NeighborhoodsSelectionLimit() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("select2-selection-limit"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Selection limit message");
            throw(e);
        }
        return element;
    }

    public int getNeighborhoodsDropboxCount() throws Exception
    {
        int count = 0;
        WebElement select = driver.findElement(By.className("select2-choices"));
        List<WebElement> options = select.findElements(By.tagName("li"));
        count = options.size();
        return count;
    }

    public WebElement checkbox_OfficeLeasingInExpertise() throws Exception
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

    public void clickOncheckboxOfOfficeLeasingInExpertise() throws Exception
    {
        try
        {
            checkbox_OfficeLeasingInExpertise().click();
            AutomationLog.info("Clicked on Checkbox of Office Leasing In Expertise");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on Checkbox of Office Leasing In Expertise");
            throw(e);
        }
    }

    public WebElement checkbox_RetailLeasingInExpertise() throws Exception
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

    public void clickOncheckboxOfRetailLeasingInExpertise() throws Exception
    {
        try
        {
            checkbox_RetailLeasingInExpertise().click();
            AutomationLog.info("Clicked on Checkbox of RetailLeasing In Expertise");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on Checkbox of Retail Leasing In Expertise");
            throw(e);
        }
    }

    public WebElement checkbox_LandlordRepresentationInConcentration() throws Exception
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

    public void clickOnLandlordRepresentationInConcentration() throws Exception
    {
        try
        {
            checkbox_LandlordRepresentationInConcentration().click();
            AutomationLog.info("Clicked on Checkbox of Landlord Representation In Concentration");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Click on Checkbox of Landlord Representation In Expertise");
            throw(e);
        }
    }

    public WebElement checkbox_TenantRepresentationInConcentration() throws Exception
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

    public void clickOncheckboxOfTenantRepresentationInConcentration() throws Exception
    {
        try
        {
            checkbox_TenantRepresentationInConcentration().click();
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
            element = driver.findElement(By.id("exp_building"));
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
            element = driver.findElement(By.id("exp_investment"));
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

    public WebElement icon_NeighborhoodSearchChoiceClose() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='s2id_commercial_neighborhoodSelect']/ul/li[5]/a"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find close icon on Neighborhood Search Choice");
            throw(e);
        }
        return element;
    }

    public void clickOnNeighborhoodsSearchChoiceCloseIcon() throws Exception
    {
        try
        {
            icon_NeighborhoodSearchChoiceClose().click();
            AutomationLog.info("Successfully clicked close icon of Neighborhoods Search Choice");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click close icon of Neighborhoods Search Choice");
            throw(e);
        }
    }

    public List<WebElement> addedNeighborhoods() throws Exception
    {
        WebElement select = driver.findElement(By.className("select2-choices"));
        List<WebElement> options = select.findElements(By.className("select2-search-choice"));
        return options;
    }

    public WebElement btn_brokerNeighborSearchButton() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("brokerSearchButton"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Neighbor Search Button button");
            throw(e);
        }
        return element;
    }

    public void clickOnbrokerNeighborSearchButton() throws Exception
    {
        try
        {
            btn_brokerNeighborSearchButton().click();
            AutomationLog.info("Successfully click Neighbor Search Button button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click Neighbor Search Button button");
            throw(e);
        }
    }

    public WebElement heading_SearchProfessionalPage() throws Exception
    {
        try
        {
            element =  driver.findElement(By.className("content-block")).findElement(By.tagName("h2"));
            AutomationLog.info("Found Heading for SearchProfessionals page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not find Heading for SearchProfessionals page");
            throw(e);
        }
        return element;
    }

    public WebElement element_AgentsContainer() throws Exception
    {
        try
        {
            element =  driver.findElement(By.id("agents"));
            AutomationLog.info("Agents container found on SearchProfessionals page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Failed to found Agents container on SearchProfessionals page");
            throw(e);
        }
        return element;
    }

    public WebElement element_CompaniesContainer() throws Exception
    {
        try
        {
            element =  driver.findElement(By.id("companies"));
            AutomationLog.info("Companies container found on SearchProfessionals page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Failed to found companies container on SearchProfessionals page");
            throw(e);
        }
        return element;
    }

    public WebElement tab_TopAgents() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Top Agents"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Top Agents Tab is not found on Search Professionals Page");
            throw(e);
        }
        return element;
    }

    public WebElement tab_TopCompanies() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Top Companies"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Top Companies Tab is not found on Search Professionals Page");
            throw(e);
        }
        return element;
    }

    public void clickOnTopAgentsTab() throws Exception
    {
        try
        {
            tab_TopAgents().click();
            AutomationLog.info("Successfully clicked top agents tab");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to click top agents tab");
            throw(e);
        }
    }

    public void clickOnTopCompaniesTab() throws Exception
    {
        try
        {
            tab_TopCompanies().click();
            AutomationLog.info("Successfully clicked top companies tab");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to click top companies tab");
            throw(e);
        }
    }

    public WebElement firstCompanyUnderCompaniesTab() throws Exception
    {
        List<WebElement> allCompaniesSet = new ArrayList<>();
        List<WebElement> allCompanies = new ArrayList<>();
        try
        {
            element =  driver.findElement(By.id("resultsLineItemsCompanies"));
            allCompaniesSet = element.findElements(By.tagName("ul"));
            allCompanies = allCompaniesSet.get(0).findElements(By.tagName("li"));
            AutomationLog.info("Companies container found on SearchProfessionals page");
        }
        catch (Exception e)
        {
            AutomationLog.error("Failed to found companies container on SearchProfessionals page");
            throw(e);
        }
        return allCompanies.get(0);
    }

    public CompanyProfilePage clickOnFirstCompany() throws Exception
    {
        CompanyProfilePage companyProfilePage;
        try
        {
            firstCompanyUnderCompaniesTab().findElement(By.tagName("a")).click();;
            companyProfilePage = new CompanyProfilePage(driver);
            AutomationLog.info("Successfully clicked first company");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to click first company");
            throw(e);
        }
        return companyProfilePage;
    }

    public String singleAgentsName() throws Exception
    {
        String agentName = null;
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='brokerResults']/li[2]/div[2]/a"));
            agentName = element.getText();
            AutomationLog.info("Successfully fetched single agent name");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to fetch single agent name");
            throw(e);
        }
        return agentName;
    }

    public String firstCompnayName() throws Exception
    {
        String compnayName = null;
        try
        {
            compnayName = firstCompanyUnderCompaniesTab().findElement(By.tagName("a")).getText();
            AutomationLog.info("Successfully fetched single compnay name");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to fetch single compnay name");
            throw(e);
        }
        return compnayName;
    }

    public boolean agentsStatus() throws Exception
    {
        boolean agentsStatus = false;
        try
        {
            int agents = element_AgentsContainer().findElement(By.id("resultsLineItemsAgents")).findElements(By.tagName("h4")).size();
            if(agents == 0)
            agentsStatus = true;
            else if (agents == 1) 
            agentsStatus = false;
            AutomationLog.info("Successfully found whether multiple agents are present or not");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to found whether multiple agents are present or not");
            throw(e);
        }
        return agentsStatus;
    }

    @Override
    public String pageHeading() throws Exception
    {
        return heading_SearchProfessionalPage().getText();
    }

    public String getURL()
    {
        return applicationUrl() + "/search/agent";
    }

    public boolean lazyLoadingStatus() 
    {
        boolean lazyLoadingStatus = false;
        Integer noOfulTags = 0;
        try 
        {
            element = driver.findElement(By.id("resultsLineItemsAgents"));
            noOfulTags = element.findElements(By.tagName("ul")).size();
            if(noOfulTags > 0)
            {
                lazyLoadingStatus = true;
            }
            else
            {
                lazyLoadingStatus = false;
            }
        }
        catch (Exception e) 
        {
            AutomationLog.error("Falied to get lazy loading status");
        }
        return lazyLoadingStatus;
    }

    public WebElement link_LatestAgentsTab() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Latest Agents"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find tab Latest Agents");
            throw(e);
        }
        return element;
    }

}
