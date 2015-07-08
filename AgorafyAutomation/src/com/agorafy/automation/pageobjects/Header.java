package com.agorafy.automation.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.reports.Reports;
import com.agorafy.automation.pageobjects.submitlisting.SubmitListingLocationFormPage;
import com.agorafy.automation.pageobjects.subnavigationmenu.MySubscriptions;
import com.agorafy.automation.pageobjects.upsellpopups.LoginPopUp;

public class Header extends Page
{
    private WebElement element = null;

    public Header(WebDriver driver)
    {
        super(driver);
        }

    public WebElement link_Login() throws Exception
    {
        try 
        {
            element = driver.findElement(By.linkText("Log In"));
            AutomationLog.info("Login link found in the Header");
        }
        catch (Exception e)
        {
            AutomationLog.error("Login link was not found in the Header");
            throw(e);
        }

        return element;
    }

    public WebElement link_SignUp() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Sign Up"));
            AutomationLog.info("SignUp link found in the Header");
        }
        catch (Exception e)
        {
            AutomationLog.error("Sign up link was not found in the Header");
            throw(e);
        }

        return element;
    }

    public SignUp clickOnSignUpUpLink() throws Exception
    {
        SignUp signup = null;
        try
        {
            link_SignUp().click();
            signup = new SignUp(driver);
            AutomationLog.info("Successfully clicked on signup Link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on signUp Link");
            throw(e);
        }
        return signup;
    }

    public WebElement link_SubmitListing() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Submit Listing"));
            AutomationLog.info("Submit listing link found in the Header");
        }
        catch (Exception e)
        {
            AutomationLog.error("Submit listing link was not found in the Header");
            throw(e);
        }
        return element;
    }

    public Page clickSubmitListing(Boolean loginStatus) throws Exception
    {
        Page page= null;
        link_SubmitListing().click();

        if(loginStatus)
        {
            page = new SubmitListingLocationFormPage(driver);
            return page;
        }
        else
        {
            page = new LoginPopUp(driver);
            return page;
        }
    }

    //Links below are seen when user is logged in

    public By getProfileNameLocator() 
    {
        return  (By.className("profile-name"));
    }

    public WebElement link_SwitchToAdmin() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Switch to Admin"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Switch To Admin link not found when Profile name is clicked");
            throw(e);
        }
        return element;
    }

    public Admin clickSwitchToAdminLinkBelowProfilePic() throws Exception
    {
        Admin admin;
        try
        {
            link_SwitchToAdmin().click();
            admin = new Admin(driver);
            AutomationLog.info("Successfully clicked on Switch To Admin link under profile pic");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not clicked on Switch To Admin link under profile pic");
            throw(e);
        }
        return admin;
    }

    public WebElement link_Logout() throws Exception
    {
        try
        {
            element = driver.findElement(By.linkText("Logout"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Logout link Not found in the Header");
            throw(e);
        }
        return element;
    }

    public Homepage clickLogoutLinkBelowProfilePic() throws Exception
    {
        Homepage homepage;
        try
        {
            link_Logout().click();
            homepage = new Homepage();
            AutomationLog.info("Successfully clicked on Logout link under profile pic");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not clicked on Logout link under profile pic");
            throw(e);
        }
        return homepage;
    }

    public String greeting() throws Exception
    {
        String greeting="";
        try
        {
            greeting = driver.findElement(getProfileNameLocator()).getText();
            AutomationLog.info("Greeting found after successful Login");
        }
        catch(Exception e)
        {
            AutomationLog.error("Not able to find Greeting after successful Login");
            throw(e);
        }
        return greeting;
    }

    public WebElement form_AdvancedSearch() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("advancedSearchForm"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Advance Search form");
            throw(e);
        }
        return element;
    }

    public WebElement icon_AdvanceSearchDropDown() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("advancedSearch"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find AdvanceSearch Dropdown icon ");
            throw(e);
        }
        return element;
    }

    public void clickOnAdvanceSearchDropDownIcon() throws Exception
    {
        try
        {
            icon_AdvanceSearchDropDown().click();
            AutomationLog.info("Successfully clicked on AdvanceSearch DropDown icon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on AdvanceSearch DropDown icon");
        }
        
    }

    public WebElement txtbx_BedsInAdvanceSearchForm() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("bedsInput"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Textbox for beds in advance search form    ");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_BathInAdvanceSearchForm() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("bathsInput"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Textbox for beds in advance search form    ");
            throw(e);
        }
        return element;
    }

    public WebElement btn_SearchOnAdvanceSearchForm() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("searchFormAdvancedButton"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find search button on advance search form");
            throw(e);
        }
        return element;
    }

    public void clickOnSearchButtonOnAdvanceSearchform() throws Exception
    {

        try
        {
            btn_SearchOnAdvanceSearchForm().click();
            AutomationLog.info("Successfully clicked on Search button on Advanced search form");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not click on Search button on Advanced search form");
            throw(e);
        }
    }

    public WebElement txtbx_Size_AdvanceSearchForm() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("sizeInput"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Size text box in Advance Search form");
            throw(e);
        }
        return element;
    }

    public void enterSizeInAdvanceSearchSizeTextBox(String size) throws Exception
    {
        txtbx_Size_AdvanceSearchForm().clear();
        txtbx_Size_AdvanceSearchForm().sendKeys(size);
    }

    public WebElement txtbx_Price_AdvanceSearchForm() throws Exception
    {
        try
        {
            element = driver.findElement(By.name("price"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Price text box in Advance Search form");
            throw(e);
        }
        return element;
    }

    public void enterPriceInAdvanceSearchPriceTextBox(String price) throws Exception
    {
        txtbx_Price_AdvanceSearchForm().clear();
        txtbx_Price_AdvanceSearchForm().sendKeys(price);
    }

    public WebElement reportCount() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("reportCount"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found report count in prfile name dropdown");
            throw(e);
        }
        return element;
    }

    public WebElement link_Reports() throws Exception
    {
       try
       {
           element = driver.findElement(By.id("viewReport"));
       }
       catch(Exception e)
       {
           AutomationLog.error("Could not found Reports link in Profile DropDown");
           throw(e);
       }
       return element;
    }

    public Reports clickOnReportsLink() throws Exception
    {
        Reports reports = null;
        try
        {
            link_Reports().click();
            reports = new Reports(driver);
            AutomationLog.info("Successfully clicked on Reports link in Profile Dropdown");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Reports link in Profile Dropdown");
            throw(e);
        }
        return reports;
    }

    public WebElement link_profileNameDropdown() throws Exception
    {
        try
        {
            element = driver.findElement(getProfileNameLocator());
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Profile name dropdown");
            throw(e);
        }
        return element;
    }

    public Homepage logout() throws Exception
    {
    	Homepage homepage = null;
        try
        {
            header().link_profileNameDropdown().click();
            header().link_Logout().click();
            WaitFor.waitForPageToLoad(driver);
            homepage = new Homepage();
            AutomationLog.info("Logged out of Agorafy");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to Logout from Agorafy");
            throw(e);
        }
        return homepage;
    }

    public WebElement closeLoginPopUp() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//a[@role='button']"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Login Pop Up close button is not found");
            throw(e);
        }
        return element;
    }

    public void clickOnCloseLoginPopUp() throws Exception
    {
        try
        {
            closeLoginPopUp().click();
            AutomationLog.info("Successfully click on Login pop-up close icon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to click on Login pop-up close icon");
            throw(e);
        }
    }

    public WebElement btn_searchForm() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("searchFormButton"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Search from button is not found on header");
            throw(e);
        }
        return element;
    }

    public void clickOnSearchFormButton() throws Exception
    {
        try
        {
            btn_searchForm().click();
            AutomationLog.info("Successfully click on Search Form button");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to click on Search Form button");
            throw(e);
        }
    }

    public WebElement msg_ZebraTooltip() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("Zebra_Tooltip_Message"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Tool Tip Message is not found on Header after clicking on empty search button");
            throw(e);
        }
        return element;
    }

    public WebElement txtbx_SearchInput() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("searchInput"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Search Input textbox is not found");
            throw(e);
        }
        return element;
    }

    public void enterSearchTextInSearchInputTextBox(String data) throws Exception
    {
        try
        {
            txtbx_SearchInput().sendKeys(data);
            AutomationLog.info("Successfully enter data in SearchInput Textbox");
        }
        catch(Exception e)
        {
            AutomationLog.error("Failed to enter data in SearchInput Textbox");
            throw(e);
        }
    }

    public By getAutoCompleteMenuDropboxLoactor() throws Exception
    {
        return By.className("ui-autocomplete");
    }

    public WebElement searchBox_AutoCompleteMenu() throws Exception
    {
        try
        {
            element = driver.findElement(getAutoCompleteMenuDropboxLoactor());
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Autocomplete Menu dropbox");
            throw(e);
        }
        return element;
    }

    public void clickOnProfileNameDropdownArrow() throws Exception
    {
        try
        {
            link_profileNameDropdown().click();
            AutomationLog.info("Successfully clicked on Profile name dropdown Arrow");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not found Profile name dropdown Arrow");
            throw(e);
        }
    }

    public WebElement link_Subscriptions() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("subscriptions_dropBox"));
        }
        catch (Exception e)
        {
            AutomationLog.error("Subscriptions link below profile pic not found");
            throw(e);
        }
        return element;
    }

    public MySubscriptions clickSubscriptionsLinkBelowProfilePic() throws Exception
    {
        MySubscriptions mySubscriptions;
        try
        {
            link_Subscriptions().click();
            mySubscriptions = new MySubscriptions(driver);
            AutomationLog.info("Successfully clicked on Subscriptions link under profile pic");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not clicked on Subscriptions link under profile pic");
            throw(e);
        }
        return mySubscriptions;
    }

    public HeaderLoginForm openHeaderLoginForm() throws Exception
    {
        HeaderLoginForm headerloginform = null;
        try
        {
            link_Login().click();
            headerloginform = new HeaderLoginForm(driver);
            AutomationLog.info("Successfully clicked on Login link in the Header");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Login link");
            throw(e);
        }
        return headerloginform;
    }

    public WebElement dropdown_SelectBoroughIcon() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='boroughSelect']/div/span"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Select Borough Icon ");
        }
        return element;
    }

    public void clickOnSelectBoroughIcon() throws Exception
    {
        try
        {
            dropdown_SelectBoroughIcon().click();
            AutomationLog.info("Successfully clicked on Select Borough Icon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Select Borough Icon");
        }
    }

    public WebElement dropdown_SelectListingCategoryIcon() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='listingCategorySelect']/div/span"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Select Borough Icon ");
        }
        return element;
    }

    public void clickOnSelectListingCategoryIcon() throws Exception
    {
        try
        {
            dropdown_SelectListingCategoryIcon().click();
            AutomationLog.info("Successfully clicked on Select Listing CategoryIcon");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Select Listing Category Icon");
        }
    }


    public void selectListingCategory(String selectcategory) throws Exception
    {
        try
        {
            WebElement select = driver.findElement(By.id("listingCategorySelect"));
            List<WebElement> listingcategories = select.findElements(By.className("dd-option-text"));
            for(WebElement listingcategory:listingcategories)
            {
                if((listingcategory.getText()).equalsIgnoreCase(selectcategory))
                {
                    listingcategory.click();
                    break;
                }
            }
            AutomationLog.info("Successfully selected listing category");
        }
        catch(Exception e)
        {
            AutomationLog.error("could not select listing category");
            throw(e);
        }
    }

    public void selectBorough(String selectborough) throws Exception
    {
        try
        {
            WebElement select = driver.findElement(By.id("boroughSelect"));
            List<WebElement> boroughs = select.findElements(By.className("dd-option-text"));
            for(WebElement borough:boroughs)
            {
                if((borough.getText()).equalsIgnoreCase(selectborough))
                {
                    borough.click();
                    break;
                }
            }
            AutomationLog.info("Successfully selected borough");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not select borough");
            throw(e);
        }
    }

    public WebElement dropdrow_OfferingType() throws Exception
    {
        try
        {
             element = driver.findElement(By.id("offeringType"));
             AutomationLog.info("Successfully found offering type dropdown");
        }
        catch(Exception e)
        {
             AutomationLog.error("Could not find offering type dropdown");
             throw(e);
        }
        return element;
    }

    public WebElement dropdown_PropertyType() throws Exception
    {
        try
        {
             element = driver.findElement(By.id("propertyType"));
             AutomationLog.info("Successfully found Property type dropdown");
        }
        catch(Exception e)
        {
             AutomationLog.error("Could not find Property type dropdown");
             throw(e);
        }
        return element;
    }

    public void clickOnPropertyTypeDropdown() throws Exception
    {
        try
        {
            dropdown_PropertyType().click();
            AutomationLog.info("Successfully clicked on Property type dropdown");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Property type dropdown");
        }
    }

    public void clickOnOfferingTypeDropdown() throws Exception
    {
        try
        {
            dropdrow_OfferingType().click();
            AutomationLog.info("Successfully clicked on Offering type dropdown");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Offering type dropdown");
        }
    }

    public void selectListingType(String listingtype) throws Exception
    {
        Select type = new Select(dropdrow_OfferingType());
        type.selectByVisibleText(listingtype);
        AutomationLog.info("Listing type Selected successfully");
    }

    public void selectPropertyType(String propertytype) throws Exception
    {
        Select type = new Select(dropdown_PropertyType());
        WaitFor.sleepFor(1000);
        type.selectByValue(propertytype.toLowerCase());
        AutomationLog.info("Property type Selected successfully");
    }

    public String getSelectedPropertyType() throws Exception
    {
        String selectedproperty = null;
        try
        {
            element = new Select(dropdown_PropertyType()).getFirstSelectedOption();
            AutomationLog.info("Selected Property Type found");
            selectedproperty = element.getText();
        }
        catch(Exception e)
        {
           AutomationLog.error("Could not find Selected Property type");
           throw(e);
        }
        return selectedproperty;
    }

    public List<String> getListingTypesList() throws Exception
    {
        List<String> offeringlist = new ArrayList<String>();
        Select type = new Select(dropdrow_OfferingType());
        List<WebElement> offeringTypes = type.getOptions();
        for(WebElement offerType : offeringTypes)
        {
            offeringlist.add(offerType.getText());
        }
        return offeringlist;
    }

    public List<String> getPropertyTypeList() throws Exception
    {
        int positionToBeDiscarded = 0;
        List<String> propertylist = new ArrayList<String>();
        Select type = new Select(dropdown_PropertyType());
        List<WebElement> propertyTypes = type.getOptions();
        for(WebElement property : propertyTypes)
        {
            if(property.getAttribute("style").equalsIgnoreCase("display: block;"))
           {
                if(positionToBeDiscarded!=0 )
                {
                   propertylist.add(property.getText());
                }
           }
            positionToBeDiscarded++;
        }
        return propertylist;
    }

}
