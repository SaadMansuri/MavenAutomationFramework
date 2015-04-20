package com.agorafy.automation.pageobjects.contentpages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;





import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class AboutUs extends Page
{
    private WebElement element = null;
    public AboutUs(WebDriver driver)
    {
        super(driver);
    }

    public String getApplicationUrl()
    {
        return applicationUrl();
    }

    public WebElement pageHeadingElement() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]/div[1]/h2"));
            AutomationLog.info("About Us Page Heading found on page");
        }
        catch(Exception e)
        {
            AutomationLog.error("About Us Page Heading Not found");
            throw(e);
        }
        return element;
    }
    public WebElement HeaderCategorySearchBar() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//*[@id='listingCategorySelect']"));
            AutomationLog.info("Header Category SearchBar is Found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Header Category SearchBar not Found");
            throw(e);
        }
        return element;
    }
    public String clickHeaderCategorySearchBar() throws Exception
    {
        String dropDown="";
    	try
        {
            HeaderCategorySearchBar().click();
            AutomationLog.info("After click ,Opened drop down for CategorySearchBar");
        }
        catch (Exception e)
        {
            AutomationLog.error("After click ,Drop down didn't open for CategorySearchBar");
            throw(e);
        }
         return dropDown;
    }
    public  String HeaderCategorySearchBar_DropDownCommercialOption() throws Exception
    {
        String dropDownCommercialOption="";
        try
        {
        	dropDownCommercialOption = driver.findElement(By.xpath("//*[@id='listingCategorySelect']/ul/li[1]/a/label")).getText();
            AutomationLog.info("In Header Category SearchBar, Commercial Category is Found");
        }
        catch(Exception e)
        {
            AutomationLog.error("In Header Category SearchBar, Commercial Category not Found");
            throw(e);
        }
        return dropDownCommercialOption;
    }
    public  String HeaderCategorySearchBar__DropDownResidentialOption() throws Exception
    {
        String dropDownResidentialOption="";
        try
        {
        	dropDownResidentialOption = driver.findElement(By.xpath("//*[@id='listingCategorySelect']/ul/li[2]/a/label")).getText();
            AutomationLog.info("In Header Category SearchBar, Residential Category is Found");
        }
        catch(Exception e)
        {
            AutomationLog.error("In Header Category SearchBar, Residential Category not Found");
            throw(e);
        }
        return dropDownResidentialOption;
    }
    public WebElement SearchTextAreaInAboutUsHeader() throws Exception
    {
        try
        {
             element = driver.findElement(By.cssSelector("#searchInput"));
             AutomationLog.info("Search Text box found on the AboutUs Header");
        }
             catch (Exception e)
        {
             AutomationLog.error("Search Text box was Not found on the ABoutUs Header");
             throw(e);
        }
             return element;
    }
    public WebElement sendSearchTextInAboutUsHeader() throws Exception
    {
        try
        {
        	SearchTextAreaInAboutUsHeader().sendKeys("paris");
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	AutomationLog.info("Search Keywords has been sent to Search Text box in the AboutUs Header");
        }
        catch (Exception e)
        {
            AutomationLog.error("Search Keywords has not sent to Search Text box in the AboutUs Header ");
        }
        return element;
    }
    public String getTextSearchBoxInput() throws Exception
    {
        String SearchTextBox = "";
        try
        {
        	SearchTextBox = sendSearchTextInAboutUsHeader().getAttribute("value");
        }
        catch (Exception e)
        {
            AutomationLog.error("Entered text not found in Text Box");
        }
        return SearchTextBox;
    }
    public WebElement HeaderSearchTextBar_FindText() throws Exception
    {
        try
        {
        	element = driver.findElement(By.xpath("//*[@id='searchFormContainer']/div[3]/ul/li[1]"));
            AutomationLog.info("In Header DropDown Text SearchBar, Unique Text 'Find Listing' is Found");
        }
        catch(Exception e)
        {
            AutomationLog.error("In Header DropDown Text SearchBar, Unique Text 'Find Listing' not Found");
            throw(e);
        }
        return element;
    }
    public String getDropDownSearchBoxText() throws Exception
    {
        String dropDownSearchTextBox = "";
        try
        {
            dropDownSearchTextBox = HeaderSearchTextBar_FindText().getText();
        }
        catch (Exception e)
        {
            AutomationLog.error("Unable To get DropDown text 'Find Listing' text in Search Text Box");
        }
        return dropDownSearchTextBox;
    }
    public WebElement HeaderBoroughSearchBarInAboutUsPage() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//*[@id='boroughSelect']"));
            AutomationLog.info("Header Category boroughSelect bar is Found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Header Category boroughSelect bar not Found");
            throw(e);
        }
        return element;
    }
    public String clickHeaderBoroughSearchBarInAboutUsPage() throws Exception
    {
        String BoroughDropDown="";
    	try
        {
            HeaderBoroughSearchBarInAboutUsPage().click();
            AutomationLog.info("After click ,Opened drop down for BoroughSearchBar");
        }
        catch (Exception e)
        {
            AutomationLog.error("After click ,Drop down didn't open for BoroughSearchBar");
            throw(e);
        }
         return BoroughDropDown;
    }
    public  String HeaderBoroughSearchBarInAboutUsPage_DropDownManhattanOption() throws Exception
    {
        String dropDownManhattanOption="";
        try
        {
        	dropDownManhattanOption = driver.findElement(By.xpath("//*[@id='boroughSelect']/ul/li[1]/a/label")).getText();
            AutomationLog.info("In Header Borough SearchBar, Manhattan Borough is Found in Drop Down");
        }
        catch(Exception e)
        {
            AutomationLog.error("In Header Borough SearchBar, Manhattan Borough is not Found in Drop Down");
            throw(e);
        }
        return dropDownManhattanOption;
    }
    public  String HeaderBoroughSearchBarInAboutUsPage_DropDownBronxOption() throws Exception
    {
        String dropDownBronxOption="";
        try
        {
        	dropDownBronxOption = driver.findElement(By.xpath("//*[@id='boroughSelect']/ul/li[2]/a/label")).getText();
            AutomationLog.info("In Header Borough SearchBar, Bronx Borough is Found in Drop Down");
        }
        catch(Exception e)
        {
            AutomationLog.error("In Header Borough SearchBar, Bronx Borough is not Found in Drop Down");
            throw(e);
        }
        return dropDownBronxOption;
    }
    public  String HeaderBoroughSearchBarInAboutUsPage_DropDownBrooklynOption() throws Exception
    {
        String dropDownBrooklynOption="";
        try
        {
        	dropDownBrooklynOption = driver.findElement(By.xpath("//*[@id='boroughSelect']/ul/li[3]/a/label")).getText();
            AutomationLog.info("In Header Borough SearchBar, Brooklyn Borough is Found in Drop Down");
        }
        catch(Exception e)
        {
            AutomationLog.error("In Header Borough SearchBar, Brooklyn Borough is not Found in Drop Down");
            throw(e);
        }
        return dropDownBrooklynOption;
    }
    public  String HeaderBoroughSearchBarInAboutUsPage_DropDownQueensOption() throws Exception
    {
        String dropDownQueensOption="";
        try
        {
        	dropDownQueensOption = driver.findElement(By.xpath("//*[@id='boroughSelect']/ul/li[4]/a/label")).getText();
            AutomationLog.info("In Header Borough SearchBar, Queens Borough is Found in Drop Down");
        }
        catch(Exception e)
        {
            AutomationLog.error("In Header Borough SearchBar, Queens Borough is not Found in Drop Down");
            throw(e);
        }
        return dropDownQueensOption;
    }
    public  String HeaderBoroughSearchBarInAboutUsPage_DropDownStatenIslandOption() throws Exception
    {
        String dropDownStatenIslandOption="";
        try
        {
        	dropDownStatenIslandOption = driver.findElement(By.xpath("//*[@id='boroughSelect']/ul/li[2]/a/label")).getText();
            AutomationLog.info("In Header Borough SearchBar, StatenIsland is Found in Drop Down");
        }
        catch(Exception e)
        {
            AutomationLog.error("In Header Borough SearchBar, StatenIsland Borough is not Found in Drop Down");
            throw(e);
        }
        return dropDownStatenIslandOption;
    }
    @Override
    public String pageHeading() throws Exception
    {
        return pageHeadingElement().getText();
    }
}
