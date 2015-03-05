package com.agorafy.automation.pageobjects.submitlisting;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;

public class SubmitListingDetailsFormResidentialPage extends SubmitListingDetailsFormBasePage 
{
    public SubmitListingDetailsFormResidentialPage(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement dropdown_ResidentialType() throws Exception 
    {
        try
        {
            element = driver.findElement(By.name("ls_residential_type"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Residential Type dropdown not found");
            throw e;
        }
    }

    public void selectResidentialTypeDropdown(String residentialType) throws Exception
    {
        try 
        {
            dropdown = new Select(dropdown_ResidentialType());
            dropdown.selectByVisibleText(residentialType);
            AutomationLog.info(residentialType+" selected");
        }
        catch (Exception e) 
        {
            AutomationLog.error(residentialType+" failed to select");
            throw e;
        }
    }

    public List<WebElement> allResidentialTypes() throws Exception 
    {
        List<WebElement> allResidentialTypes;
        try
        {
            element = dropdown_ResidentialType();
            allResidentialTypes = element.findElements(By.tagName("option"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Residential Types not found");
            throw (e);
        }
        return allResidentialTypes;
    }

    public ArrayList<String> txt_AllDisplayedResidentialTypes() throws Exception 
    {
        ArrayList<String> stringAllDisplayedResidentialTypes = new ArrayList<>();
        List<WebElement> allResidentialTypes;
        String display;
        try
        {
            allResidentialTypes = allResidentialTypes(); 
            for (WebElement element : allResidentialTypes)
            {
                display = element.getCssValue("display");
                if(display.equals("block") )
                stringAllDisplayedResidentialTypes.add(element.getText());
            }
        }
        catch(Exception e)
        {
            AutomationLog.error("Residential Types not found");
            throw (e);
        }
        return stringAllDisplayedResidentialTypes;
    }

    public WebElement dropdown_NoOfUnits() throws Exception 
    {
        try
        {
            element = driver.findElement(By.name("ls_space_unit"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("NoOfUnits dropdown not found");
            throw e;
        }
    }

    public void selectNoOfUnitsDropdown(String noOfUnits) throws Exception
    {
        try 
        {
            dropdown = new Select(dropdown_NoOfUnits());
            dropdown.selectByVisibleText(noOfUnits);
            AutomationLog.info(noOfUnits+" selected");
        }
        catch (Exception e) 
        {
            AutomationLog.error(noOfUnits+" failed to select");
            throw e;
        }
    }

    public String get_SelectedNoOfUnits() throws Exception 
    {
        String noOfUnits;
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='property']/div[2]/div/div/div/span/span"));  
            noOfUnits = element.getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("NoOfUnits dropdown not found");
            throw e;
        }
        return noOfUnits;
    }

    public List<WebElement> allNoOfUnits() throws Exception 
    {
        List<WebElement> allNoOfUnits;
        try
        {
            element = dropdown_NoOfUnits();
            allNoOfUnits = element.findElements(By.tagName("option"));
        }
        catch(Exception e)
        {
            AutomationLog.error("No Of Units not found");
            throw (e);
        }
        return allNoOfUnits;
    }

    public ArrayList<String> txt_AllDisplayedNoOfUnits() throws Exception 
    {
        ArrayList<String> stringAllDisplayedNoOfUnits = new ArrayList<>();
        List<WebElement> allNoOfUnits;
        String display;
        try
        {
            allNoOfUnits = allNoOfUnits(); 
            for (WebElement element : allNoOfUnits)
            {
                display = element.getCssValue("display");
                if(display.equals("block") )
                stringAllDisplayedNoOfUnits.add(element.getText());
            }
        }
        catch(Exception e)
        {
            AutomationLog.error("No Of Units not found");
            throw (e);
        }
        return stringAllDisplayedNoOfUnits;
    }

    public WebElement txtbx_PropertyName() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_residential_property_name"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("PropertyName txt Box not found");
            throw e;
        }
    }

    public void setPropertyName(String propertyName) throws Exception
    {
        try 
        {
            txtbx_PropertyName().sendKeys(propertyName);
            AutomationLog.info("property Name is set to:" +propertyName );
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set property Name to:" +propertyName);
            throw e;
        }
    }

    public void clearPropertyName() throws Exception
    {
        try 
        {
            txtbx_PropertyName().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear propertyName");
            throw e;
        }
    }

    public WebElement txtbx_SpaceSizeMin() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_residential_space_size_min"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Space size Min txt Box not found");
            throw e;
        }
    }

    public void setSpaceSizeMin(String spaceSizeMin) throws Exception
    {
        try 
        {
            txtbx_SpaceSizeMin().sendKeys(spaceSizeMin);;
            AutomationLog.info("space size Min set to:"+spaceSizeMin);
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set space size Min to:"+spaceSizeMin);
            throw e;
        }
    }

    public void clearSpaceSizeMin() throws Exception
    {
        try 
        {
            txtbx_SpaceSizeMin().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear space size Min");
            throw e;
        }
    }

    public WebElement txtbx_SpaceSizeMax() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_residential_space_size_max"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Space size Max txt Box not found");
            throw e;
        }
    }

    public void setSpaceSizeMax(String spaceSizeMax) throws Exception
    {
        try 
        {
            txtbx_SpaceSizeMax().sendKeys(spaceSizeMax);;
            AutomationLog.info("space size Max set to:"+spaceSizeMax);
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set space size Max to:"+spaceSizeMax);
            throw e;
        }
    }

    public void clearSpaceSizeMax() throws Exception
    {
        try 
        {
            txtbx_SpaceSizeMax().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear space size Max");
            throw e;
        }
    }

    public WebElement txtbx_Bedrooms() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_bedrooms"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Bedrooms txt Box not found");
            throw e;
        }
    }	

    public void setBedrooms(String Bedrooms) throws Exception
    {
        try 
        {
            txtbx_Bedrooms().sendKeys(Bedrooms);
            AutomationLog.info("Bedrooms is set to:" +Bedrooms );
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set Bedrooms to:" +Bedrooms);
            throw e;
        }
    }

    public void clearBedrooms() throws Exception
    {
        try 
        {
            txtbx_Bedrooms().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear Bedrooms");
            throw e;
        }
    }

    public WebElement txtbx_Bathrooms() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_bathrooms"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Bathrooms txt Box not found");
            throw e;
        }
    }

    public void setBathrooms(String Bathrooms) throws Exception
    {
        try 
        {
            txtbx_Bathrooms().sendKeys(Bathrooms);
            AutomationLog.info("Bathrooms is set to:" +Bathrooms );
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set Bathrooms to:" +Bathrooms);
            throw e;
        }
    }

    public void clearBathrooms() throws Exception
    {
        try 
        {
             txtbx_Bathrooms().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear Bathrooms");
            throw e;
        }
    }

    public WebElement txtbx_AskingPriceMin() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_price_min"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("AskingPrice Min txt Box not found");
            throw e;
        }
    }	

    public void setAskingPriceMin(String askingPriceMin) throws Exception
    {
        try 
        {
            txtbx_AskingPriceMin().sendKeys(askingPriceMin);;
            AutomationLog.info("asking Price Min set to:"+askingPriceMin);
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set asking Price Min to:"+askingPriceMin);
            throw e;
        }
    }

    public void clearAskingPriceMin() throws Exception
    {
        try 
        {
            txtbx_AskingPriceMin().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed clear to Asking Price Min");
            throw e;
        }
    }

    public WebElement txtbx_AskingPriceMax() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_price_max"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("AskingPrice Max txt Box not found");
            throw e;
        }
    }

    public void setAskingPriceMax(String askingPriceMax) throws Exception
    {
        try
        {
            txtbx_AskingPriceMax().sendKeys(askingPriceMax);;
            AutomationLog.info("asking Price Max set to:"+askingPriceMax);
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set asking Price Max to:"+askingPriceMax);
            throw e;
        }
    }

    public void clearAskingPriceMax() throws Exception
    {
        try 
        {
            txtbx_AskingPriceMax().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear Asking Price Max");
            throw e;
        }
    }

}
