package com.agorafy.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;

public class PersonalInfo extends Page
{
    private WebElement element = null;
    public PersonalInfo(WebDriver driver)
    {
        super(driver);
    }

    public WebElement textBox_Name() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("name"));
            AutomationLog.info("Name Text field found on Personal Information form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Name Text field not found on Personal Information form");
            throw(e);
        }
        return element;
    }

    public String textBox_NameValue() throws Exception
    {
        String name = "";
        try
        {
            name = textBox_Name().getAttribute("value");
            AutomationLog.info("Retrieved name from Name Text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve name from Name Text field");
            throw(e);
        }
        return name;
    }

    public WebElement textBox_Email() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("email"));
            AutomationLog.info("Email Id Text field found on Personal Information form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Email Id Text field not found on Personal Information form");
            throw(e);
        }
        return element;
    }

    public String textbox_EmailValue() throws Exception
    {
        String email = "";
        try
        {
            email = textBox_Email().getAttribute("value");
            AutomationLog.info("Retrieved email from Email Id Text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve email from Email Id Text field");
            throw(e);
        }
        return email;
    }

    public boolean checkEnablityofEmailTextField() throws Exception
    {
        return textBox_Email().isEnabled();
    }

    public WebElement textBox_Company() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("company"));
            AutomationLog.info("Company Text field found on Personal Information form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Company Text field not found on Personal Information form");
            throw(e);
        }
        return element;
    }

    public String textbox_CompanyValue() throws Exception
    {
        String company = "";
        try
        {
            company = textBox_Company().getAttribute("value");
            AutomationLog.info("Retrieved Company from Company Text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not company from Company Text field");
            throw(e);
        }
        return company;
    }

    public WebElement textBox_Address1() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("address1"));
            AutomationLog.info("Address1 Text field found on Personal Information form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Address1 Text field not found on Personal Information form");
            throw(e);
        }
        return element;
    }

    public String textbox_Address1Value() throws Exception
    {
        String address1 = "";
        try
        {
            address1 = textBox_Address1().getAttribute("value");
            AutomationLog.info("Retrieved address from Address1 Text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve address from Address1 Text field");
            throw(e);
        }
        return address1;
    }

    public WebElement textBox_Address2() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("address2"));
            AutomationLog.info("Address2 Text field found on Personal Information form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Address2 Text field not found on Personal Information form");
            throw(e);
        }
        return element;        
    }

    public String textbox_Address2Value() throws Exception
    {
        String address2 = "";
        try
        {
            address2 = textBox_Address2().getAttribute("value");
            AutomationLog.info("Retrieved address from Address2 Text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve address from Address2 Text field");
            throw(e);
        }
        return address2;
    }

    public WebElement textBox_City() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("city"));
            AutomationLog.info("City Text field found on Personal Information form");
        }
        catch(Exception e)
        {
            AutomationLog.error("City Text field not found on Personal Information form");
            throw(e);
        }
        return element;
    }

    public String textbox_CityValue() throws Exception
    {
        String city = "";
        try
        {
            city = textBox_City().getAttribute("value");
            AutomationLog.info("Retrieved city name from City Text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve city name from City Text field");
            throw(e);
        }
        return city;
    }

    public WebElement dropdown_State() throws Exception 
    {
        try 
        {
            element = driver.findElement(By.id("state"));
            AutomationLog.info("State Dropdown found on Personal Information form");
        } 
        catch (Exception e)
        {
            AutomationLog.error("State Dropdown not found on Personal Information form");
            throw (e);
        }
        return element;
    }

    public String getDropdownSelectedState() throws Exception
    {
        String selectedState = "";
        try
        {
            Select select = new Select(dropdown_State());
            selectedState = select.getFirstSelectedOption().getText();
            AutomationLog.info("Retrieved selected state from State Dropdown");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve Selected State from Dropdown");
            throw (e);
        }
        return selectedState;
    }

    public WebElement textBox_Zip() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("zip"));
            AutomationLog.info("Zip Text field found on Personal Information form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Zip Text field not found on Personal Information form");
            throw(e);
        }
        return element;
    }

    public String textbox_ZipValue() throws Exception
    {
        String zip = "";
        try
        {
            zip = textBox_Zip().getAttribute("value");
            AutomationLog.info("Retrieved company name from Company Text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve company name from Company Text field");
            throw(e);
        }
        return zip;
    }

    public WebElement dropdown_PhNoType1() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("phoneNumber1Type"));
            AutomationLog.info("PhoneNumber1 Type Dropdown found on Personal Information form");
        } 
        catch (Exception e)
        {
            AutomationLog.error("PhoneNumber1 Type Dropdown not found on Personal Information form");
            throw (e);
        }
        return element;
    }

    public String getDropdownSelectedPhoneNumber1Type() throws Exception
    {
        String selectedphoneNumber1Type = "";
        try
        {
            Select select = new Select(dropdown_PhNoType1());
            selectedphoneNumber1Type = select.getFirstSelectedOption().getText();
            AutomationLog.info("Retrieved selected PhoneNumber1 Type from Dropdown");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve Selected PhoneNumber1 Type from Dropdown");
            throw (e);
        }
        return selectedphoneNumber1Type;
    }

    public WebElement dropdown_PhNoType2() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("phoneNumber2Type"));
            AutomationLog.info("PhoneNumber2 Type Dropdown found on Personal Information form");
        } 
        catch (Exception e)
        {
            AutomationLog.error("PhoneNumber2 Type Dropdown not found on Personal Information form");
            throw (e);
        }
        return element;
    }

    public String getDropdownSelectedPhoneNumber2Type() throws Exception
    {
        String selectedphoneNumber2Type = "";
        try
        {
            Select select = new Select(dropdown_PhNoType2());
            selectedphoneNumber2Type = select.getFirstSelectedOption().getText();
            AutomationLog.info("Retrieved selected PhoneNumber2 Type from Dropdown");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve Selected PhoneNumber2 Type from Dropdown");
            throw (e);
        }
        return selectedphoneNumber2Type;
    }

    public WebElement dropdown_PhNoType3() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("phoneNumber3Type"));
            AutomationLog.info("PhoneNumber3 Type Dropdown found on Personal Information form");
        } 
        catch (Exception e)
        {
            AutomationLog.error("PhoneNumber3 Type Dropdown not found on Personal Information form");
            throw (e);
        }
        return element;
    }

    public String getDropdownSelectedPhoneNumber3Type() throws Exception
    {
        String selectedphoneNumber3Type = "";
        try
        {
            Select select = new Select(dropdown_PhNoType3());
            selectedphoneNumber3Type = select.getFirstSelectedOption().getText();
            AutomationLog.info("Retrieved selected PhoneNumber3 Type from Dropdown");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve Selected PhoneNumber3 Type from Dropdown");
            throw (e);
        }
        return selectedphoneNumber3Type;
    }

    public WebElement dropdown_PhNoType4() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("phoneNumber4Type"));
            AutomationLog.info("PhoneNumber4 Type Dropdown found on Personal Information form");
        } 
        catch (Exception e)
        {
            AutomationLog.error("PhoneNumber4 Type Dropdown not found on Personal Information form");
            throw (e);
        }
        return element;
    }

    public String getDropdownSelectedPhoneNumber4Type() throws Exception
    {
        String selectedphoneNumber4Type = "";
        try
        {
            Select select = new Select(dropdown_PhNoType4());
            selectedphoneNumber4Type = select.getFirstSelectedOption().getText();
            AutomationLog.info("Retrieved selected PhoneNumber4 Type from Dropdown");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve Selected PhoneNumber4 Type from Dropdown");
            throw (e);
        }
        return selectedphoneNumber4Type;
    }

    public WebElement textBox_PhoneNum1() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("phoneNumber1"));
            AutomationLog.info("Phone Number 1 Text field found on Personal Information form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Phone Number 1 Text field not found on Personal Information form");
            throw (e);
        }
        return element;
    }

    public String textBox_PhoneNum1Value() throws Exception
    {
        String phNo1 = "";
        try
        {
            phNo1 = textBox_PhoneNum1().getText();
            AutomationLog.info("Retrieved phone number 1 from PhoneNumber1 Text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve phone number 1 from PhoneNumber1 Text field ");
            throw (e);
        }
        return phNo1;
    }

    public WebElement textBox_PhoneNum2() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("phoneNumber2"));
            AutomationLog.info("Phone Number 2 Text field found on Personal Information form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Phone Number 2 Text field not found on Personal Information form");
            throw (e);
        }
        return element;
    }

    public String textBox_PhoneNum2Value() throws Exception
    {
        String phNo2 = "";
        try
        {
            phNo2 = textBox_PhoneNum2().getText();
            AutomationLog.info("Retrieved phone number 2 from PhoneNumber2 Text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve phone number 2 from PhoneNumber2 Text field ");
            throw (e);
        }
        return phNo2;
    }

    public WebElement textBox_PhoneNum3() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("phoneNumber3"));
            AutomationLog.info("Phone Number 3 Text field found on Personal Information form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Phone Number 3 Text field not found on Personal Information form");
            throw (e);
        }
        return element;
    }

    public String textBox_PhoneNum3Value() throws Exception
    {
        String phNo3 = "";
        try
        {
            phNo3 = textBox_PhoneNum3().getText();
            AutomationLog.info("Retrieved phone number 3 from PhoneNumber3 Text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve phone number 3 from PhoneNumber3 Text field ");
            throw (e);
        }
        return phNo3;
    }

    public WebElement textBox_PhoneNum4() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("phoneNumber4"));
            AutomationLog.info("Phone Number 4 Text field found on Personal Information form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Phone Number 4 Text field not found on Personal Information form");
            throw (e);
        }
        return element;
    }

    public String textBox_PhoneNum4Value() throws Exception
    {
        String phNo4 = "";
        try
        {
            phNo4 = textBox_PhoneNum4().getText();
            AutomationLog.info("Retrieved phone number 4 from PhoneNumber4 Text field");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not retrieve phone number 4 from PhoneNumber4 Text field ");
            throw (e);
        }
        return phNo4;
    }

    public WebElement btn_SaveChanges() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("submit-info"));
            AutomationLog.info("Save Changes button found on Personal Information form");
        }
        catch(Exception e)
        {
            AutomationLog.error("Save Changes button not found on Personal Information form");
            throw (e);
        }
        return element;
    }

    public PersonalInfo clickOnSaveChangesBtn() throws Exception
    {
        PersonalInfo info = null;
        try
        {
            btn_SaveChanges().click();
            info = new PersonalInfo(driver);            
            AutomationLog.info("Save Changes Button clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("There was a problem in clicking Save Changes button");
            throw (e);
        }
        return info;
    }
}