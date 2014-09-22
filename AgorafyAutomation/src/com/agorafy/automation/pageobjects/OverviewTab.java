package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.agorafy.automation.automationframework.AutomationLog;

public class OverviewTab extends Page {
   
	private WebElement element= null;

	public OverviewTab(WebDriver driver) {
		super(driver);
	}

	public WebElement txtbx_Name() throws Exception
	{
	  try 
	  {
		element= driver.findElement(By.id("name"));
		AutomationLog.info("username text box found in overview page"); 
	  } 
	  catch (Exception e) 
	  {
		  
		AutomationLog.error("username text box not found  in overview page");
		
		throw(e);
		
	  }
		return element;
	}
		
	public WebElement default_Email() throws Exception 
	{
		try 
		{
			element=driver.findElement(By.id("email"));
			AutomationLog.info("email text box found in overview page");
			
	    } catch (Exception e) 
		
		{
	    	AutomationLog.error("email text box found in overview page");
	    	throw(e);
		}
			return element;
	}	
			
	public WebElement txtbx_CompanyName() throws Exception
	{ 
		try 
		{
			element=driver.findElement(By.id("company-name"));
			AutomationLog.info("company-name found in overview page");
			
		} catch (Exception e) 
		
		{
			AutomationLog.error("company-name found in overview page");
			throw(e);
			
		}
		return element;
	}
	
	public WebElement txtbx_WorkNum() throws Exception
	{
		try 
		{
			element=driver.findElement(By.id("work"));
			AutomationLog.info("work-phone nos found in overview page");
			
		} catch (Exception e)
		{
			AutomationLog.error("work-phone nos found in overview page");
			throw(e);
		}
		return element;
	}
		
	public WebElement txtbx_MobilenNum() throws Exception
	{
		try 
		{	
			element=driver.findElement(By.id("mobile"));
			AutomationLog.info("mobile nos found in overview page");
			
		} catch (Exception e) 
		{
			AutomationLog.error("mobile nos found in overview page");
			throw(e);
		}
		return element;
	}
		
		
		public WebElement txtbx_FirstAddressField() throws Exception
		{
			try 
			{
				element=driver.findElement(By.name("address[address1]"));
				AutomationLog.info("address1 found in overview page");
				
			} catch (Exception e) 
			{
				AutomationLog.error("address1 found in overview page");
				throw(e);
			}
			return element;
		}
		
	   public WebElement txtbx_SecondAddressField() throws Exception
	   {
		   try 
		   {
			   element=driver.findElement(By.name("address[address2]"));
			   AutomationLog.info("address2 found in overview page");
			
		} catch (Exception e) 
		   {
			AutomationLog.error("address2 not found in overview page");
			throw(e);
		}
		return element;
	   }
	
       public WebElement txtbx_City() throws Exception
       { 
    	   try 
    	   {
    		   element=driver.findElement(By.id("city"));
  		   AutomationLog.info("City found in over view page");
			
		} catch (Exception e) 
    	   {
			AutomationLog.error("City not found in over view page");
			throw(e);
			
		  }
		return element;
       }
       
       public WebElement dropdown_State() throws Exception
       {
    	   try 
    	   {
    		   element=driver.findElement(By.id("state"));
    		   AutomationLog.info("State found in over view page");
			
		   } catch (Exception e) 
    	  {
			AutomationLog.error("State not found in over view page");
			throw(e);
			
		 }
		return element;
       }
       
       public WebElement txtbx_Zip() throws Exception
       {
    	   try 
    	   {
    		   element=driver.findElement(By.id("zip"));
    		   AutomationLog.info("Zip found in over view page");
    		   
			
		  } catch (Exception e) 
    	   {
			AutomationLog.error("Zip not found in over view page");
			throw(e);
			
		   }
		return element;
       }
       
       public WebElement txtbx_DescribeYourself() throws Exception
       {
    	   try 
    	   {
    		   element=driver.findElement(By.id("aboutText"));
    		   AutomationLog.info(" Describe yoursef found in over view page");
			
		  } catch (Exception e) 
    	  {
			AutomationLog.error("Describe yoursef not found in over view page");
			throw(e);
		  }
		return element;
       }
       
       public WebElement txtbx_Neigborhood() throws Exception
       {
    	   try 
    	   {	
               element=driver.findElement(By.className("default"));
               AutomationLog.info(" Neigborhood found in over view page");
               
		   } catch (Exception e) 
    	   { 	
			  AutomationLog.error("Neigborhood found in over view page");
    	      throw(e);
    	   }
		return element;
          
       }
       
       public WebElement btn_Save() throws Exception
       {
    	   try 
    	   {
    		   element=driver.findElement(By.id("overviewSubmit"));
    		   AutomationLog.info("save found in overview page");
			
		   } catch (Exception e) 
    	   {
			throw(e);
			
		   }
		return element;
          }

       public WebElement link_Here() throws Exception
       {
    	   try 
    	   {
    		   element=driver.findElement(By.linkText("here"));
    		   AutomationLog.info("link text 'here' is found on overview tab");
			
		} catch (Exception e) {
			// TODO: handle exception
			AutomationLog.error("link text 'here' is found on overview tab");
			throw(e);
		}
		return element;
       }
      }


