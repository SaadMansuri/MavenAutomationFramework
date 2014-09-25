package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.datamodel.profile.OverviewData;

public class OverviewTab extends Page 
{
	private WebElement element = null;

	public OverviewTab(WebDriver driver) 
	{
		super(driver);
	}

	public OverviewBanner banner() 
	{
		return PageFactory.initElements(driver, OverviewBanner.class);
	}

	public WebElement txtbx_Name() throws Exception 
	{
		try 
		{
			element = driver.findElement(By.id("name"));
			AutomationLog.info("username text box found in overview page");
		}
		catch (Exception e) 
		{
			AutomationLog.error("username text box not found  in overview page");
			throw (e);
		}
		return element;
	}

	public WebElement default_Email() throws Exception 
	{
		try 
		{
			element = driver.findElement(By.id("email"));
			AutomationLog.info("email text box found in overview page");
		}
		catch (Exception e)
		{
			AutomationLog.error("email text not box found in overview page");
			throw (e);
		}
		return element;
	}

	public WebElement txtbx_CompanyName() throws Exception 
	{
		try 
		{
			element = driver.findElement(By.id("company-name"));
			AutomationLog.info("company-name found in overview page");
		} 
		catch (Exception e)
		{
			AutomationLog.error("company-name not found in overview page");
			throw (e);

		}
		return element;
	}

	public WebElement txtbx_WorkNum() throws Exception 
	{
		try 
		{
			element = driver.findElement(By.id("work"));
			AutomationLog.info("work-phone nos found in overview page");
		} 
		catch (Exception e) 
		{
			AutomationLog.error("work-phone nos found in overview page");
			throw (e);
		}
		return element;
	}

	public WebElement txtbx_MobilenNum() throws Exception
	{
		try 
		{
			element = driver.findElement(By.id("mobile"));
			AutomationLog.info("mobile nos found in overview page");
		} catch (Exception e)
		{
			AutomationLog.error("mobile nos found in overview page");
			throw (e);
		}
		return element;
	}

	public WebElement txtbx_FirstAddressField() throws Exception 
	{
		try 
		{
			element = driver.findElement(By.name("address[address1]"));
			AutomationLog.info("address1 found in overview page");

		}
		catch (Exception e)
		{
			AutomationLog.error("address1 found in overview page");
			throw (e);
		}
		return element;
	}

	public WebElement txtbx_SecondAddressField() throws Exception 
	{
		try 
		{
			element = driver.findElement(By.name("address[address2]"));
			AutomationLog.info("address2 found in overview page");
		}
		catch (Exception e)
		{
			AutomationLog.error("address2 not found in overview page");
			throw (e);
		}
		return element;
	}

	public WebElement txtbx_City() throws Exception
	{
		try
		{
			element = driver.findElement(By.id("city"));
			AutomationLog.info("City found in over view page");
		} 
		catch (Exception e)
		{
			AutomationLog.error("City not found in over view page");
			throw (e);
		}
		return element;
	}

	public WebElement dropdown_State() throws Exception 
	{
		try 
		{
			element = driver.findElement(By.id("state"));
			AutomationLog.info("State found in over view page");
		} 
		catch (Exception e)
		{
			AutomationLog.error("State not found in over view page");
			throw (e);
		}
		return element;
	}

	public WebElement txtbx_Zip() throws Exception 
	{
		try 
		{
			element = driver.findElement(By.id("zip"));
			AutomationLog.info("Zip found in over view page");
		}
		catch (Exception e)
		{
			AutomationLog.error("Zip not found in over view page");
			throw (e);
		}
		return element;
	}

	public WebElement txtbx_DescribeYourself() throws Exception
	{
		try 
		{
			element = driver.findElement(By.id("aboutText"));
			AutomationLog.info(" Describe yoursef found in over view page");
		}
		catch (Exception e)
		{
			AutomationLog.error("Describe yoursef not found in over view page");
			throw (e);
		}
		return element;
	}

	public WebElement txtbx_Neigborhood() throws Exception
	{
		try 
		{
			element = driver.findElement(By.className("default"));
			AutomationLog.info(" Neigborhood found in over view page");
		}
		catch (Exception e)
		{
			AutomationLog.error("Neigborhood not found in over view page");
			throw (e);
		}
		return element;
	}

	public WebElement btn_Save() throws Exception
	{
		try
		{
			element = driver.findElement(By.id("overviewSubmit"));
			AutomationLog.info("save button found in overview page");
		}
		catch (Exception e)
		{
			AutomationLog.error("save button not found on overview tab");
			throw (e);
		}
		return element;
	}

	public WebElement link_Here() throws Exception
	{
		try
		{
			element = driver.findElement(By.linkText("here"));
			AutomationLog.info("link text 'here' is found on overview tab");
		} 
		catch (Exception e)
		{
			AutomationLog.error("link text 'here' not found on overview tab");
			throw (e);
		}
		return element;
	}

	public void populateOverviewDetails(OverviewData data) throws Exception
	{
		try
		{
			txtbx_Name().clear();
			txtbx_Name().sendKeys(data.getName());
			txtbx_CompanyName().clear();
			txtbx_CompanyName().sendKeys(data.getCompanyName());
			txtbx_MobilenNum().clear();
			txtbx_MobilenNum().sendKeys(data.getMobilePhone());
			txtbx_WorkNum().clear();
			txtbx_WorkNum().sendKeys(data.getWorkPhone());
			txtbx_FirstAddressField().clear();
			txtbx_FirstAddressField().sendKeys(data.getAddress1());
			txtbx_SecondAddressField().clear();
			txtbx_SecondAddressField().sendKeys(data.getAddress2());
			txtbx_City().clear();
			txtbx_City().sendKeys(data.getCity());
			txtbx_Zip().clear();
			txtbx_Zip().sendKeys(data.getZipCode());
			Select select = new Select(dropdown_State());
			select.selectByVisibleText(data.getState());
			txtbx_DescribeYourself().clear();
			txtbx_DescribeYourself().sendKeys(data.getDescribe());
		} 
		catch (Exception e) 
		{
			AutomationLog.error("Not able to populate Overview tab with Details.");
			throw (e);
		}
	}

	public OverviewTab saveOverviewDetails() throws Exception
	{
		OverviewTab tab = null;
		try
		{
			btn_Save().click();
			tab = new OverviewTab(driver);
		} 
		catch (Exception e)
		{
			// TODO: handle exception
			AutomationLog.error("link text 'here' is found on overview tab");
			throw (e);
		}
		return tab;
	}

	public String getTextBoxName() throws Exception
	{
		String nameTextBox = "";
		try
		{
			nameTextBox = txtbx_Name().getAttribute("value");
		} 
		catch (Exception e) 
		{
			AutomationLog.error("Name not found in Text Box");
		}
		return nameTextBox;
	}

	public String getTextBoxCompanyName() throws Exception
	{
		String comapnyNameTextBox = "";
		try
		{
			comapnyNameTextBox = txtbx_CompanyName().getAttribute("value");
		} 
		catch (Exception e)
		{
			AutomationLog.error("Company name not found in Text Box");
		}
		return comapnyNameTextBox;
	}

	public String getTextBoxWorkPhoneNumber() throws Exception
	{
		String workPhoneTextBox = "";
		try
		{
			workPhoneTextBox = txtbx_WorkNum().getAttribute("value");
		} 
		catch (Exception e)
		{
			AutomationLog.error("WorkPhone not found in Text Box ");
		}
		return workPhoneTextBox;
	}

	public String getTextBoxMobileNumber() throws Exception
	{
		String mobilePhoneTextBox = "";
		try
		{
			mobilePhoneTextBox = txtbx_MobilenNum().getAttribute("value");
		}
		catch (Exception e)
		{
			AutomationLog.error("MobilePhone not found in Text Box");
		}
		return mobilePhoneTextBox;
	}

	public String getTextBoxAddress1() throws Exception
	{
		String address1TextBox = "";
		try
		{
			address1TextBox = txtbx_FirstAddressField().getAttribute("value");
		} 
		catch (Exception e)
		{
			AutomationLog.error("AddressField1 Not found in Text Box");
		}
		return address1TextBox;
	}

	public String getTextBoxAddress2() throws Exception 
	{
		String address2TextBox = "";
		try 
		{
			address2TextBox = txtbx_SecondAddressField().getAttribute("value");
		}
		catch (Exception e)
		{
			AutomationLog.error("AddressField2 Not found in Text Box");
		}
		return address2TextBox;
	}

	public String getTextBoxCity() throws Exception
	{
		String cityTextBox = "";
		try
		{
			cityTextBox = txtbx_City().getAttribute("value");
		}
		catch (Exception e)
		{
			AutomationLog.error("City Not found in Text Box");
		}
		return cityTextBox;
	}

	public String getDropdownState() throws Exception 
	{
		String stateDropdown = "";
		try
		{
			Select select = new Select(dropdown_State());
			stateDropdown = select.getFirstSelectedOption().getText();
		}
		catch (Exception e) 
		{
			AutomationLog.error("State Not found in Text Box");
		}
		return stateDropdown;
	}

	public String getTextBoxZip() throws Exception
	{
		String zipTextBox = "";
		try 
		{
			zipTextBox = txtbx_Zip().getAttribute("value");
		}
		catch (Exception e)
		{
			AutomationLog.error("State Not found in Text Box");
		}
		return zipTextBox;
	}

	public String getTextBoxDescribeYorself() throws Exception
	{
		String DescribeYourselfTextBox = "";
		try
		{
			DescribeYourselfTextBox = txtbx_DescribeYourself().getAttribute("value");
		} 
		catch (Exception e)
		{
			AutomationLog.error("Describe Yourself Not found in Text Box");
		}
		return DescribeYourselfTextBox;
	}

	public String getMultipleSelectNeighborhood() throws Exception 
	{
		String multipleSelectNeighborhood = "";
		try 
		{
			multipleSelectNeighborhood = txtbx_Neigborhood().getAttribute("value");
		} 
		catch (Exception e)
		{
			AutomationLog.error("Describe Yourself Not found in Text Box");
		}
		return multipleSelectNeighborhood;
	}

}
