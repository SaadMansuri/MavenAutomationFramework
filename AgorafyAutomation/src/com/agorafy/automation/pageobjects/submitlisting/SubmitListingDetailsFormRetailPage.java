package com.agorafy.automation.pageobjects.submitlisting;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.agorafy.automation.automationframework.AutomationLog;

public class SubmitListingDetailsFormRetailPage extends SubmitListingDetailsFormBasePage 
{
    public SubmitListingDetailsFormRetailPage(WebDriver driver) 
    {
         super(driver);
    }

    public WebElement radiobtn_CombinableYes() throws Exception 
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='space-form']/div[4]/div/label[1]/input"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("radio btn CombinableYes not found");
            throw e;
        }
    }

    public void setCombinableYes() throws Exception
    {
        try 
        {
            radiobtn_CombinableYes().click();
            AutomationLog.info("radiobtn_Combinable Yes is set");
        }
        catch (Exception e) 
        {
            AutomationLog.error("radiobtn_Combinable Yes failed to set");
            throw e;
        }
    }

    public WebElement radiobtn_CombinableNo() throws Exception 
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='space-form']/div[4]/div/label[2]"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("radio btn CombinableNo not found");
            throw e;
        }
    }

    public void setCombinableNo() throws Exception
    {
        try 
        {
            radiobtn_CombinableNo().click();
            AutomationLog.info("radiobtn_Combinable No is set");
        }
        catch (Exception e) 
        {
            AutomationLog.error("radiobtn_Combinable No failed to set");
            throw e;
        }
    }

    public String whichCombinableIsChecked() throws Exception
    {
        String value =null;

        try 
        {
            value = radiobtn_CombinableYes().getAttribute("value");
            if(value.equals("Yes"))
                return "Yes";
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to detect which combinable option is checked");
            throw (e);
        }
        return "No";

    }

    public WebElement txtbx_Frontage() throws Exception 
    {
        try
        {
            element = driver.findElement(By.id("ls_frontage"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("Frontage txt Box not found");
            throw e;
        }
    }	

    public void setFrontage(String frontage) throws Exception
    {
        try 
        {
            txtbx_Frontage().sendKeys(frontage);
            AutomationLog.info("Frontage is set to:" +frontage );
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to set Frontage to:" +frontage);
            throw e;
        }
    }

    public void clearFrontage() throws Exception
    {
        try 
        {
            txtbx_Frontage().clear();
        }
        catch (Exception e) 
        {
            AutomationLog.error("failed to clear frontage");
            throw e;
        }
    }

    public WebElement radiobtn_FoodYes() throws Exception 
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='property']/div[11]/div/p[1]/label[2]/input"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("radio btn Food Yes not found");
            throw e;
        }
    }

    public void setFoodYes() throws Exception
    {
        try 
        {
            radiobtn_FoodYes().click();
            AutomationLog.info("radio btn Food-Yes is set");
        }
        catch (Exception e) 
        {
            AutomationLog.error("radio btn Food-Yes failed to set");
            throw e;
        }
    }

    public WebElement radiobtn_FoodNo() throws Exception 
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='property']/div[11]/div/p[1]/label[3]/input"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("radio btn Food No not found");
            throw e;
        }
    }

    public void setFoodNo() throws Exception
    {
        try 
        {
            radiobtn_FoodNo().click();
            AutomationLog.info("radio btn Food-No is set");
        }
        catch (Exception e) 
        {
            AutomationLog.error("radio btn Food-No failed to set");
            throw e;
        }
    }

    public WebElement radiobtn_CookingYes() throws Exception 
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='property']/div[11]/div/p[2]/label[2]/input"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("radio btn Cooking Yes not found");
            throw e;
        }
    }

    public void setCookingYes() throws Exception
    {
        try 
        {
            radiobtn_CookingYes().click();
            AutomationLog.info("radio btn Cooking-Yes is set");
        }
        catch (Exception e) 
        {
            AutomationLog.error("radio btn Cooking-Yes failed to set");
            throw e;
        }
    }

    public WebElement radiobtn_CookingNo() throws Exception 
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='property']/div[11]/div/p[2]/label[3]/input"));
            return element;
        }
        catch(Exception e)
        {
            AutomationLog.error("radio btn Cooking No not found");
            throw e;
        }
    }

    public void setCookingNo() throws Exception
    {
        try 
        {	
            radiobtn_CookingNo().click();
            AutomationLog.info("radio btn Cooking-No is set");
        }
        catch (Exception e) 
        {
            AutomationLog.error("radio btn Cooking-No failed to set");
            throw e;
        }
    }
/*This method is used to fill Submit listing details -retail form and return media form*/
    public SubmitListingMediaFormPage fillCurrentFormAndClickSaveAndContinue(HashMap<String, String> dummyRetailData) throws Exception
    {
        SubmitListingMediaFormPage submitListingMediaFormPage;
        try 
        {
            if(dummyRetailData.get("ListingOfferForRetail")!= null)
                selectListingOfferDropdown(dummyRetailData.get("ListingOfferForRetail"));

            if(dummyRetailData.get("AddSpace")!= null)
                addSpaceWithCombinableOption(true, dummyRetailData);

            if(dummyRetailData.get("AskingPrice")!= null)
                setAskingPrice(dummyRetailData.get("AskingPrice"));

            if(dummyRetailData.get("AskingPriceUnit")!= null)
                selectAskingPriceUnit(dummyRetailData.get("AskingPriceUnit"));

            if(dummyRetailData.get("Frontage")!= null)
                setFrontage(dummyRetailData.get("Frontage"));

            if(dummyRetailData.get("CeilingHeight")!= null)
                setCeilingHeight(dummyRetailData.get("CeilingHeight"));

            if(dummyRetailData.get("FoodAllowed") != null)
                setFoodYes();
            else
                setFoodNo();

            if(dummyRetailData.get("CookingAllowed") != null)
            	setCookingYes();
            else 
            	setCookingNo();

            if(dummyRetailData.get("Description") != null)
            setDescription(dummyRetailData.get("Description"));

            clickSaveAndContinue();

            submitListingMediaFormPage = new SubmitListingMediaFormPage(driver);
            AutomationLog.info("detail-retail form filled sucessfully");
        }
        catch (Exception e) 
        {
            AutomationLog.error("fill details form and click save and continue failed");
            throw (e);
        }
        return submitListingMediaFormPage;
    }

    /*This method does the same work as above method but used for set up of preview and submit form*/
    public SubmitListingMediaFormPage fillDetailsRetailFormForPreviewSetup(HashMap<String, HashMap<String, String>> data) throws Exception
    {
    	return fillCurrentFormAndClickSaveAndContinue(data.get("TotalRetailFormData"));
    }

    public void addSpaceWithCombinableOption(Boolean combinable, HashMap<String, String> dataFromCSV) throws Exception 
    {
    	selectSpaceName();
    	setSpaceSize(dataFromCSV.get("SpaceSize1"));
        if(combinable)
            setCombinableYes();
        else
            setCombinableNo();
        clickAddSpace();
    }

}
