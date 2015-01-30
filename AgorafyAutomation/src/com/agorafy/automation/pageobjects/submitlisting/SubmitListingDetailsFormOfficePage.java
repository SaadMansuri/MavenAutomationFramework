package com.agorafy.automation.pageobjects.submitlisting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;

public class SubmitListingDetailsFormOfficePage extends SubmitListingDetailsFormBasePage 
{

    public SubmitListingDetailsFormOfficePage(WebDriver driver) 
    {
        super(driver);
    }

    public WebElement dropdown_SpaceType() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_space_type"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Space Type dropdown not found");
            throw e;
        }
    }

    public void selectSpaceType(String SpaceType) throws Exception
    {
        try 
        {
            dropdown = new Select(dropdown_SpaceType());
            dropdown.selectByVisibleText(SpaceType);
            AutomationLog.info(SpaceType+" selected");
        }
        catch (Exception e) 
        {
            AutomationLog.error(SpaceType+" failed to select");
            throw e;
        }
    }

    public String getSelectedSpaceType() throws Exception
    {
        String spaceType= null;
        try 
        {
            element =  dropdown_SpaceType();
            spaceType = element.findElement(By.xpath("//*[@id='space-form']/div[1]/div/span/span")).getText();
            //spaceType = element.findElement(By.cssSelector("selected")).getText();
        }
        catch (Exception e) 
        {
            AutomationLog.error("selected space type not found");
            throw e;
        }
        return spaceType;
    }

    public WebElement txtbx_CeilingHeight() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_ceiling_height"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("txtbx_CeilingHeight not found");
            throw (e);
        }
        return element;
    }

    public void clearCeilingHeight() throws Exception
    {
        try 
        {
            txtbx_CeilingHeight().clear();
            AutomationLog.info("clearCeilingHeight passed");
        }
        catch (Exception e) 
        {
            AutomationLog.error("clearCeilingHeight failed");
            throw (e);
        }
    }

    public WebElement txtbx_Combinable() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_combinable"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("txtbx_Combinable not found");
            throw (e);
        }
        return element;
    }

    public WebElement txtbx_Electricity() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("ls_electricity"));
        }
        catch (Exception e) 
        {
            AutomationLog.error("txtbx_Electricity not found");
            throw (e);
        }
        return element;
    }

    public void setCombinable(String combinable) throws Exception
    {
        try 
        {
            txtbx_Combinable().sendKeys(combinable);
            AutomationLog.info("combinable set to:" + combinable);
        }
        catch (Exception e) 
        {
            AutomationLog.error("combinable failed to set:" + combinable);
            throw e;
        }
    }

    public void clearCombinable() throws Exception
    {
        try 
        {
            txtbx_Combinable().clear();
            AutomationLog.info("cleared combinable sucessfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Combinable txt Box not cleared");
            throw (e);
        }
    }

    public void setElectricity(String electricity) throws Exception
    {
        try 
        {
            txtbx_Electricity().sendKeys(electricity);
            AutomationLog.info("electricity set to:" + electricity);
        }
        catch (Exception e) 
        {
            AutomationLog.error("electricity failed to set:" + electricity);
            throw e;
        }
    }

    public void clearElectricity() throws Exception
    {
        try 
        {
            txtbx_Electricity().clear();
            AutomationLog.info("cleared electricity sucessfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Electricity txt Box not cleared");
            throw (e);
        }
    }

    public void setCeilingHeight(String ceilingHeight) throws Exception
    {
        try 
        {
            txtbx_CeilingHeight().sendKeys(ceilingHeight);
            AutomationLog.info("ceiling Height set to:" + ceilingHeight);
        }
        catch (Exception e) 
        {
            AutomationLog.error("ceiling Height failed to set:" + ceilingHeight);
            throw e;
        }
    }

}
