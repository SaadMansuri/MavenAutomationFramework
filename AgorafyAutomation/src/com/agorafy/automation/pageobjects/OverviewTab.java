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
            AutomationLog.error("could not found username text box ");
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
            AutomationLog.error("could not found email text box");
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
            AutomationLog.error("could not found company name text box");
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
            AutomationLog.error("could not found work phone text box");
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
        }
        catch (Exception e)
        {
            AutomationLog.error("could not found mobile number text box");
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
           AutomationLog.error("could not found address1 text box");
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
            AutomationLog.error("could not found address2 text box");
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
            AutomationLog.error("could not found city text box");
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
            AutomationLog.error("could not found state text box");
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
            AutomationLog.error("could not found zip text box");
            throw (e);
        }
        return element;
    }

    public WebElement txtbx_DescribeYourself() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("aboutText"));
            AutomationLog.info(" Describe yourself found in over view page");
        }
        catch (Exception e)
        {
            AutomationLog.error("could not found Describe yourself text box");
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
            AutomationLog.error("could not found Describe yoursef text box");
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
            AutomationLog.error("could not found save button");
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
            AutomationLog.error("could not found link here text ");
            throw (e);
        }
        return element;
    }

    public void setName(String namefield) throws Exception
    {
        try
        {
            txtbx_Name().clear();
            txtbx_Name().sendKeys(namefield);
        }
        catch (Exception e)
        {
            AutomationLog.error(" could not found name in overview tab ");
            throw (e);
        }
    }

    public void setCompanyName(String companyfield) throws Exception
    {
        try
        {
            txtbx_CompanyName().clear();
            txtbx_CompanyName().sendKeys(companyfield);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not found company name in overview tab");
            throw (e);
        }
    }

    public void setWorkPhone(String Workphonefield) throws Exception
    {
        try
        {
            txtbx_WorkNum().clear();
            txtbx_WorkNum().sendKeys(Workphonefield);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not found workphone number in overview tab ");
            throw (e);
        }
    }

    public void setMobilephone(String Mobilephonefield) throws Exception
    {
        try
        {
            txtbx_MobilenNum().clear();
            txtbx_MobilenNum().sendKeys(Mobilephonefield);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not found mobilephone number in overview tab ");
            throw (e);
        }
    }

    public void setAddress1(String addressField1) throws Exception
    {
        try
        {
            txtbx_FirstAddressField().clear();
            txtbx_FirstAddressField().sendKeys(addressField1);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not found Address1 in overview tab");
            throw (e);
        }
    }

    public void setAddress2(String addressField2) throws Exception
    {
        try
        {
            txtbx_SecondAddressField().clear();
            txtbx_SecondAddressField().sendKeys(addressField2);
        }
        catch (Exception e)
        {
           AutomationLog.error("could not found Address2 in overview tab");
           throw (e);
        }
    }

    public void setCity(String city) throws Exception
    {
        try
        {
            txtbx_City().clear();
            txtbx_City().sendKeys(city);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not found city name in overview tab");
            throw (e);
        }
    }

    public void setState(String state) throws Exception
    {
        try
        {
            Select select = new Select(dropdown_State());
            select.selectByVisibleText(state);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not found state in overview tab");
            throw (e);
        }
    }

    public void setZipCode(String zipCode) throws Exception
    {
        try
        {
            txtbx_Zip().clear();
            txtbx_Zip().sendKeys(zipCode);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not found zipcode in overview tab");
            throw (e);
        }
    }

    public void setCountCharacter( String countCharacter) throws Exception
    {
        try
        {
            txtbx_DescribeYourself().clear();
            txtbx_DescribeYourself().sendKeys(countCharacter);
        }
        catch(Exception e)
        {
            AutomationLog.error("could not found count of character in overview tab");
            throw(e);
        }
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
            AutomationLog.error("could not populate overview details in overview tab");
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
           AutomationLog.error("could not save overview details in overview tab");
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
            AutomationLog.error("Neighborhood Not found in Text Box");
        }
        return multipleSelectNeighborhood;
    }

    public WebElement errorMessageWhenNameFieldIsEmpty() throws Exception
    {
       try
       {
           element=driver.findElement(By.xpath(".//*[@id='overviewForm']/div[2]/div[1]/div[1]/div/div"));
       }
       catch(Exception e)
       {
       throw(e);
       }
       return element;
    }

    public String getErrorMessageOfInvalidName() throws Exception
    {
        String name = "";
        try
        {
            name = errorMessageWhenNameFieldIsEmpty().getText();
            AutomationLog.info("Appropriate error message for name is shown");
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for name is not shown");
            throw(e);
        }
        return name;
     }

    public WebElement errorMessageWhenInvalidPhoneNumberIsFGiven() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='overviewForm']/div[2]/div[1]/div[4]/div/div[1]/div/div"));
        }
        catch(Exception e)
        {
        throw(e);
        }
        return element;
    }

    public String getErrorMessageOfInvalidPhoneNum() throws Exception
    {
        String phoneNum = "";
        try
        {
            phoneNum = errorMessageWhenInvalidPhoneNumberIsFGiven().getText();
            AutomationLog.info("Appropriate error message for phone number is shown");
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for phone number is not shown");
            throw(e);
        }
        return phoneNum;
    }

    public WebElement errorMessageWhenInvalidMobileNumberIsGiven() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='overviewForm']/div[2]/div[1]/div[4]/div/div[2]/div/div"));
        }
        catch(Exception e)
        {
        throw(e);
        }
        return element;
    }

    public String getErrorMessageOfInvalidMobileNum() throws Exception
    {
        String mobileNum = "";
        try
        {
            mobileNum = errorMessageWhenInvalidMobileNumberIsGiven().getText();
            AutomationLog.info("Appropriate error message for mobile number is shown");
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for mobile number is not shown");
            throw(e);
        }
        return mobileNum;
     }

    public WebElement errorMessageWhenAddressFieldIsLeftEmpty() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='overviewForm']/div[2]/div[1]/div[5]/div/div"));
        }
        catch(Exception e)
        {
        throw(e);
        }
        return element;
    }

    public String getErrorMessageOfEmptyAddressField() throws Exception
    {
        String addressField = "";
        try
        {
            addressField = errorMessageWhenAddressFieldIsLeftEmpty().getText();
            AutomationLog.info("Appropriate error message for Address1 is shown");
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for Address1 is not shown");
            throw(e);
        }
        return addressField;
     }

    public WebElement errorMessageWhenInvalidAddressField2IsEntered() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='overviewForm']/div[2]/div[1]/div[6]/div/div"));
        }
        catch(Exception e)
        {
        throw(e);
        }
    return element;
    }

    public String getErrorMessageOfAddressField2() throws Exception
    {
        String addressField2 = "";
        try
        {
            addressField2 = errorMessageWhenInvalidAddressField2IsEntered().getText();
            AutomationLog.info("Appropriate error message for Address2 is shown");
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for Address2 is not shown");
            throw(e);
        }
        return addressField2;
     }

    public WebElement errorMessageWhenCityIsLeftEmpty() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='overviewForm']/div[2]/div[1]/div[7]/div/div"));
        }
        catch(Exception e)
        {
        throw(e);
        }
    return element;
    }

    public String getErrorMessageOfCityWhenLeftEmpty() throws Exception
    {
        String city = "";
        try
        {
            city = errorMessageWhenCityIsLeftEmpty().getText();
            AutomationLog.info("Appropriate error message for city is shown");
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for city is not shown");
            throw(e);
        }
        return city;
     }

    public WebElement errorMessageWhenStateIsLeftEmpty() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='overviewForm']/div[2]/div[1]/div[8]/span/div/div"));
        }
        catch(Exception e)
        {
        throw(e);
        }
    return element;
    }

    public String getErrorMessageOfStateWhenLeftEmpty() throws Exception
    {
        String state = "";
        try
        {
            state = errorMessageWhenStateIsLeftEmpty().getText();
            AutomationLog.info("Appropriate error message for state is shown");
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for state is not shown");
            throw(e);
        }
        return state;
     }

    public WebElement errorMessageWhenZipIsLeftEmpty() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='overviewForm']/div[2]/div[1]/div[9]/div/div"));
        }
        catch(Exception e)
        {
        throw(e);
        }
    return element;
    }

    public String getErrorMessageOfZip() throws Exception
    {
        String zip = "";
        try
        {
            zip = errorMessageWhenZipIsLeftEmpty().getText();
            AutomationLog.info("Appropriate error message for zip is shown");
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for state is not shown");
            throw(e);
        }
        return zip;
     }

    public WebElement txtbx_countCharInDecribeYourself() throws Exception
    {
        try
        {
            element=driver.findElement(By.xpath(".//*[@id='overviewForm']/div[2]/div[2]/div[1]/label/span"));
        }
        catch(Exception e)
        {
        throw(e);
        }
    return element;
    }

    public String getTheCountOfDescYourself() throws Exception
    {
        String countOfChar = "";
        try
        {
            countOfChar = txtbx_countCharInDecribeYourself().getText();
            AutomationLog.info("Appropriate error message for count of character is shown");
        }
        catch (Exception e)
        {
            AutomationLog.error("error message for count of character is not shown");
            throw(e);
        }
        return countOfChar;
     }
}