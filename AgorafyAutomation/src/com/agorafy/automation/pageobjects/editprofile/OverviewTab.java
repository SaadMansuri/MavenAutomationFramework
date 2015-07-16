package com.agorafy.automation.pageobjects.editprofile;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.datamodel.profile.UserProfile;
import com.agorafy.automation.pageobjects.Page;

public class OverviewTab extends Page 
{
    private WebElement element = null;
    private WebElement formField = null;

    public OverviewTab(WebDriver driver)
    {
        super(driver);
    }

    public WebElement txtbx_Name() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("name"));
            AutomationLog.info("username text box found in Overview tab form");
        }
        catch (Exception e) 
        {
            AutomationLog.error("Username text box Not found on Overview tab form");
            throw (e);
        }
        return element;
    }

    public WebElement txtbx_Email() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("email"));
            AutomationLog.info("Email text box found in Overview tab form");
        }
        catch (Exception e)
        {
            AutomationLog.error("Email text box Not found in Overview tab form");
            throw (e);
        }
        return element;
    }

    public WebElement txtbx_CompanyName() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("company-name"));
            AutomationLog.info("Company-name found in Overview tab form");
        }
        catch (Exception e)
        {
            AutomationLog.error("Company-name Not found in Overview tab form");
            throw (e);
        }
        return element;
    }

    public WebElement txtbx_WorkNum() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("work"));
            AutomationLog.info("Work-phone number found in Overview tab form");
        }
        catch (Exception e)
        {
            AutomationLog.error("Work-phone number Not found in Overview tab form");
            throw (e);
        }
        return element;
    }

    public WebElement txtbx_MobilenNum() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("mobile"));
            AutomationLog.info("Mobile number found in Overview tab form");
        }
        catch (Exception e)
        {
            AutomationLog.error("Mobile number Not found in Overview tab form");
            throw (e);
        }
        return element;
    }

    public WebElement txtbx_FirstAddressField() throws Exception
    {
        try
        {
            element = driver.findElement(By.name("address[address1]"));
            AutomationLog.info("Address1 found in Overview tab form");
        }
        catch (Exception e)
        {
           AutomationLog.error("Address1 Not found in Overview tab form");
           throw (e);
        }
        return element;
    }

    public WebElement txtbx_SecondAddressField() throws Exception
    {
        try
        {
            element = driver.findElement(By.name("address[address2]"));
            AutomationLog.info("Address2 found in Overview tab form");
        }
        catch (Exception e)
        {
            AutomationLog.error("Address2 Not found in Overview tab form");
            throw (e);
        }
        return element;
    }

    public WebElement txtbx_City() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("city"));
            AutomationLog.info("City found in Overview tab form");
        }
        catch (Exception e)
        {
            AutomationLog.error("City Not found in Overview tab form");
            throw (e);
        }
        return element;
    }

    public WebElement dropdown_State() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("state"));
            AutomationLog.info("State found in Overview tab form");
        }
        catch (Exception e)
        {
            AutomationLog.error("State Not found in Overview tab form");
            throw (e);
        }
        return element;
    }

    public WebElement txtbx_Zip() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("zip"));
            AutomationLog.info("Zip Code found in Overview tab form");
        }
        catch (Exception e)
        {
            AutomationLog.error("Zip Code Not found in Overview tab form");
            throw (e);
        }
        return element;
    }

    public WebElement txtbx_DescribeYourself() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("aboutText"));
            AutomationLog.info("Describe yourself found in Overview tab form");
        }
        catch (Exception e)
        {
            AutomationLog.error("Describe yourself Not found in Overview tab form");
            throw (e);
        }
        return element;
    }

    public WebElement txtbx_Neigborhood() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("default"));
            AutomationLog.info(" Neigborhood found in Overview tab form");
        }
        catch (Exception e)
        {
            AutomationLog.error("Neigborhood Not found in Overview tab form");
            throw (e);
        }
        return element;
    }

    public By neighborhoodlocator() throws Exception
    {
        return By.id("s2id_neighborhoodSelect");
    }

    public WebElement txtbx_NeigborhoodDropDown() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='s2id_autogen1']"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Neigborhood Not found in Overview tab form");
            throw (e);
        }
        return element;
    }

    public void clickOnNeighborhoodDropdown() throws Exception
    {
        try
        {
            txtbx_NeigborhoodDropDown().click();
        }
        catch(Exception e)
        {
            AutomationLog.error("could not clicked on neighborhood drop down ");
            throw(e);
        }
        
    }

    public void clearSpecializedNeighborhoodsTextBox() throws Exception
    {
        WebElement select = driver.findElement(By.className("select2-choices"));
        List<WebElement> options = select.findElements(By.className("select2-search-choice-close"));
        for(WebElement optionElement : options)
        {
             optionElement.click();
        }
    }

    public void selectNeighborhood(String neighor) throws Exception
    {
        WebElement select = driver.findElement(By.className("select2-results"));
        List<WebElement> options = select.findElements(By.className("select2-result-label"));
        for(WebElement optionElement : options)
        {
            if(optionElement.getText().equalsIgnoreCase(neighor))
            {
                optionElement.click();
                break;
            }
        }
        AutomationLog.info("Neighborhood Added Successfully");
    }

    public List<WebElement> addedNeighborhoods() throws Exception
    {
        WebElement select = driver.findElement(By.className("select2-choices"));
        List<WebElement> options = select.findElements(By.className("select2-search-choice"));
        
        return options;
    }

    public WebElement msg_SelectionLimit() throws Exception
    {
        try 
        {
            element = driver.findElement(By.className("select2-selection-limit"));
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Could not find Selection limit message");
            
        }
        return element;
    }

    public WebElement btn_Save() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("overviewSubmit"));
            AutomationLog.info("Save button found in Overview tab form");
        }
        catch (Exception e)
        {
            AutomationLog.error("Save button Not found in Overview tab form");
            throw (e);
        }
        return element;
    }

    public WebElement link_Here() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("here"));
            AutomationLog.info("link text 'here' is found on Overview tab form");
        }
        catch (Exception e)
        {
            AutomationLog.error("link text 'here' is Not found on Overview tab form");
            throw (e);
        }
        return element;
    }

    public void setName(String namefield) throws Exception
    {
        try
        {
            formField = txtbx_Name();
            formField.clear();
            formField.sendKeys(namefield);
        }
        catch (Exception e)
        {
            AutomationLog.error(" could not find name in Overview tab form ");
            throw (e);
        }
    }

    public void setCompanyName(String companyfield) throws Exception
    {
        try
        {
            formField = txtbx_CompanyName();
            formField.clear();
            formField.sendKeys(companyfield);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not find company name in Overview tab form");
            throw (e);
        }
    }

    public void setWorkPhone(String Workphonefield) throws Exception
    {
        try
        {
            formField = txtbx_WorkNum();
            formField.clear();
            formField.sendKeys(Workphonefield);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not find workphone number in Overview tab form ");
            throw (e);
        }
    }

    public void setMobilephone(String Mobilephonefield) throws Exception
    {
        try
        {
            formField = txtbx_MobilenNum();
            formField.clear();
            formField.sendKeys(Mobilephonefield);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not find mobilephone number in Overview tab form ");
            throw (e);
        }
    }

    public void setAddress1(String addressField1) throws Exception
    {
        try
        {
            formField = txtbx_FirstAddressField();
            formField.clear();
            formField.sendKeys(addressField1);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not find Address1 in Overview tab form");
            throw (e);
        }
    }

    public void setAddress2(String addressField2) throws Exception
    {
        try
        {
            formField = txtbx_SecondAddressField();
            formField.clear();
            formField.sendKeys(addressField2);
        }
        catch (Exception e)
        {
           AutomationLog.error("could not find Address2 in Overview tab form");
           throw (e);
        }
    }

    public void setCity(String city) throws Exception
    {
        try
        {
            formField = txtbx_City();
            formField.clear();
            formField.sendKeys(city);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not find city name in Overview tab form");
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
            AutomationLog.error("could not find state in Overview tab form");
            throw (e);
        }
    }

    public void setZipCode(String zipCode) throws Exception
    {
        try
        {
            formField = txtbx_Zip();
            formField.clear();
            formField.sendKeys(zipCode);
        }
        catch (Exception e)
        {
            AutomationLog.error("could not find zipcode in Overview tab form");
            throw (e);
        }
    }

    public void setCountCharacter( String countCharacter) throws Exception
    {
        try
        {
            formField = txtbx_DescribeYourself();
            formField.clear();
            formField.sendKeys(countCharacter);
        }
        catch(Exception e)
        {
            AutomationLog.error("could not find count of character in Overview tab form");
            throw(e);
        }
    }

    public void populateOverviewDetails(UserProfile data) throws Exception
    {
        WebElement name, companyName, email, mobileNum, workNum, address1, address2, city, zipCode, describe;
        try
        {
            name = txtbx_Name();
            name.clear();
            name.sendKeys(data.getName());

            companyName = txtbx_CompanyName();
            companyName.clear();
            companyName.sendKeys(data.getCompanyName());

            email = txtbx_Email();
            email.clear();
            email.sendKeys(data.getEmail());

            mobileNum = txtbx_MobilenNum();
            mobileNum.clear();
            mobileNum.sendKeys(data.getMobilePhone());

            workNum = txtbx_WorkNum();
            workNum.clear();
            workNum.sendKeys(data.getWorkPhone());

            address1 = txtbx_FirstAddressField();
            address1.clear();
            address1.sendKeys(data.getAddress1());

            address2 = txtbx_SecondAddressField();
            address2.clear();
            address2.sendKeys(data.getAddress2());

            city = txtbx_City();
            city.clear();
            city.sendKeys(data.getCity());

            zipCode = txtbx_Zip();
            zipCode.clear();
            zipCode.sendKeys(data.getZipCode());

            Select select = new Select(dropdown_State());
            select.selectByVisibleText(data.getState());

            describe = txtbx_DescribeYourself();
            describe.clear();
            describe.sendKeys(data.getDescribe());
        }
        catch (Exception e)
        {
            AutomationLog.error("could not populate overview details in Overview tab form");
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
           AutomationLog.error("could not save overview details in Overview tab form");
           throw (e);
        }
        return tab;
    }

    public String getTextBoxName() throws Exception
    {
        String nameTextBox = "";
        try
        {
            nameTextBox = (txtbx_Name().getAttribute("value")).trim();
        }
        catch (Exception e)
        {
            AutomationLog.error("Name not found in Text Box");
        }
        return nameTextBox;
    }

    public String getTextBoxEmail() throws Exception
    {
        String emailTextBox = "";
        try
        {
            emailTextBox = (txtbx_Email().getAttribute("value"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Name not found in Text Box");
        }
        return emailTextBox;
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
           element = driver.findElement(By.className("nameformError")).findElement(By.className("formErrorContent"));
       }
       catch(Exception e)
       {
           AutomationLog.error("Could not find Error message When Name field is empty");
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
             element = driver.findElement(By.className("workformError")).findElement(By.className("formErrorContent"));
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
            element = driver.findElement(By.className("mobileformError")).findElement(By.className("formErrorContent"));
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
            element = driver.findElement(By.className("address1formError")).findElement(By.className("formErrorContent"));
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
            element = driver.findElement(By.className("address2formError")).findElement(By.className("formErrorContent"));
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
            element = driver.findElement(By.className("cityformError")).findElement(By.className("formErrorContent"));
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
            element = driver.findElement(By.className("stateformError")).findElement(By.className("formErrorContent"));
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
            element = driver.findElement(By.className("zipformError")).findElement(By.className("formErrorContent"));
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
            element = driver.findElement(By.id("charLimit"));
        }
        catch(Exception e)
        {
        throw(e);
        }
    return element;
    }

    public WebElement msg_SuccessAfterSave() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("profileSubmitMsg"));
        }
        catch (Exception e)
        {
            AutomationLog.error("could not find success message");
            throw(e);
        }
        return element;
    }

    public String getTheCountOfDescYourself() throws Exception
    {
        String countOfChar = "";
        try
        {
            countOfChar = "("+txtbx_countCharInDecribeYourself().getText()+" characters remaining)";
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