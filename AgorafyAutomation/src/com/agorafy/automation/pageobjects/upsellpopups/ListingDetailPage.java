package com.agorafy.automation.pageobjects.upsellpopups;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;
import com.agorafy.automation.pageobjects.CompanyProfilePage;
import com.agorafy.automation.pageobjects.Page;
import com.agorafy.automation.pageobjects.SendEmailPopUp;
import com.agorafy.automation.pageobjects.UpdateListingPopUp;

public class ListingDetailPage extends LoginPopUp
{

    WebElement element = null;
    List <WebElement> elements = null;
    String CurrentUrl = null;

    public ListingDetailPage(WebDriver driver) 
    {
        super(driver);
    }

    public static ListingDetailPage listingDetailPage()
    {
        return PageFactory.initElements(driver, ListingDetailPage.class);
    }

    public WebElement page_TitleSection() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("page-title-section"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Page title Section");
            throw(e);
        }
        return element;
    }

    public WebElement link_SubscribeToListing() throws Exception
    {
        try
        {
            WebElement parent = driver.findElement(By.id("subscriptionSectionLink"));
            element = parent.findElement(By.linkText("Subscribe to listing"));
            AutomationLog.info("Subscribe to listing link found on Listing Detail Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Subscribe to listing link not found on Listing Detail Page");
            throw(e);
        }
        return element;
    }

    public Page clickOnSubscribeToListingLink(boolean loginStatus) throws Exception
    {
        Page page = null;
        link_SubscribeToListing().click();
        try
        {
            if(loginStatus)
            {
                page = new ListingDetailPage(driver);
            }
            else
            {
                WaitFor.ElementToBeDisplayed(driver, getLoginPopUpLocator());
                page = new LoginPopUp(driver);
            }
            AutomationLog.info("Successfully clicked on  SubscribeToListingLink on Listing Detail Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on SubscribeToListingLink on Listing Detail Page");
            throw(e);
         }
         return page;
    }

    public WebElement link_UnsubscribeListing() throws Exception
    {
        try
        {
            WebElement parent = driver.findElement(By.id("subscriptionSectionLink"));
            element = parent.findElement(By.linkText("Unsubscribe listing"));
            AutomationLog.info("UnSubscribe listing link found on Listing Detail Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("UnSubscribe listing link not found on Listing Detail Page");
            throw(e);
        }
        return element;
    }

    public void clickOnUnsubscribeListingLink() throws Exception
    {
        try
        {
            link_UnsubscribeListing().click();
            AutomationLog.info("Successfully clicked on Unsubscribe listing link on Listing Detail Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Unsubscribe listing link on Listing Detail Page");
            throw(e);
        }
    }

    public WebElement brokerInformationSection() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("brokerInfo"));
            AutomationLog.info("Broker contact section found on the page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Broker contact section Not found");
        }
        return element;
    }

    public List<WebElement> brokerContacts() throws Exception
    {
        List<WebElement> brokers = new ArrayList<WebElement>();
        try
        {
            WebElement parent = brokerInformationSection().findElement(By.tagName("ul"));
            brokers = parent.findElements(By.tagName("li"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find BrokersContacts");
            throw(e);
        }
        return brokers;
    }

    public WebElement link_brokerProfileName(int index) throws Exception 
    {
        try
        {
            WebElement parent = brokerContacts().get(index).findElement(By.className("contact-details")).findElement(By.tagName("h6"));
            element = parent.findElement(By.tagName("a"));
            AutomationLog.info("Broker Profile name link found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find broker Profile Name link");
            throw(e);
        }
        return element;
    }

    public WebElement link_companyProfileName(int index) throws Exception 
    {
        try
        {
            WebElement parent = brokerContacts().get(index).findElement(By.className("contact-details")).findElement(By.tagName("span"));
            element = parent.findElement(By.tagName("a"));
            AutomationLog.info("Company Profile name link found");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find Company Profile Name link");
            throw(e);
        }
        return element;
    }
 
    public String getFirstBrokerProfileName() throws Exception
    {
        return link_brokerProfileName(0).getText();
    }

    public ProfessionalProfilePage clickOnFirstBrokerProfileNameLink() throws Exception
    {
        ProfessionalProfilePage profilepage = null;
        try
        {
            link_brokerProfileName(0).click();
            profilepage = new ProfessionalProfilePage(driver);
            AutomationLog.info("Successfully clicked on first Broker Profile Name link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on first Broker Profile Name link");
            throw(e);
        }
        return profilepage;
    }

    public CompanyProfilePage clickOnFirstCompanyProfileNameLink() throws Exception
    {
        CompanyProfilePage companyprofile = null;
        try
        {
            link_companyProfileName(0).click();
            companyprofile = new CompanyProfilePage(driver);
            AutomationLog.info("Successfully clicked on first Company profile name link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on first Company Profile Name link");
            throw(e);
        }
        return companyprofile;
    }

    public String getFirstCompanyProfileName() throws Exception
    {
        return link_companyProfileName(0).getText();
    }

    public List<WebElement> link_sendEmailContactSection() throws Exception
    {
        List<WebElement> elements = null;
        try
        {
            elements = brokerInformationSection().findElements(By.linkText("Send email"));
            
        }
        catch (Exception e)
        {
            System.out.println("No cntacts were found for the listing");
        }
        return elements;
    }

    public Page clickSendEmailLink(boolean status) throws Exception
    {
        Page page = null;
        try
        {
            link_sendEmailContactSection().get(0).click();
            if(status)
            {
                page = new SendEmailPopUp(driver);
            }
            else
            {
                WaitFor.ElementToBeDisplayed(driver, getLoginPopUpLocator());
                page = new LoginPopUp(driver);
            }
            AutomationLog.info("Send Email link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not click Send email link");
        }
        return page;
    }

    public WebElement link_UpdateListing() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("listingUpdateLink"));
            AutomationLog.info("Listing update link is visible");
        }
        catch (Exception e)
        {
            AutomationLog.error("Listing update link not found, login not successful");
        }
        return element;
    }

    public WebElement link_addToReport() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("addToReport"));
            AutomationLog.info("Add to report link is present on details page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Add to report link is not present on Details page");
        }
        return element;
    }

    public WebElement link_removeFromReport() throws Exception
    {
        try
        {
            element = driver.findElement(By.id("removeFromReport"));
            AutomationLog.info("Remove From Report link is present on details page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Remove From Report link is not present on Details page");
        }
        return element;
    }

    public void clickOnRemoveFromReportLink() throws Exception
    {
        try
        {
            link_removeFromReport().click();
            AutomationLog.info("Successfully clicked on Remove From Report Link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on Remove From Report Link");
            throw(e);
        }
    }

    public Page clickOnAddToReportLink(boolean isLoggedIn) throws Exception
    {
        Page page = null;

        try
        {
            link_addToReport().click();
            if(isLoggedIn)
            {
                page = new ListingDetailPage(driver);
                AutomationLog.info("Add to Report link clicked");
            }
            else
            {
                WaitFor.ElementToBeDisplayed(driver, getLoginPopUpLocator());
                page = new LoginPopUp(driver);
                AutomationLog.info("Add to Report link clicked");
            }
        }
        catch(Exception e)
        {
            AutomationLog.error("Unable to click Add to Report");
        }
        return page;
    }

    public UpdateListingPopUp clickUpdateListingLink() throws Exception
    {
        UpdateListingPopUp updatelisting = null;
        try
        {
            link_UpdateListing().click();
            updatelisting = new UpdateListingPopUp(driver);
            AutomationLog.info("Successfully clicked on update listing link");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not click on update listing link");
            throw(e);
        }
        return updatelisting;
    }

    public WebElement title_ListingTypeSearched() throws Exception
    {
        try
        {
            element = page_TitleSection().findElement(By.className("hidden-xs")).findElement(By.tagName("h2"));
            AutomationLog.info("Title of ListingType searched found");
        }
        catch (Exception e)
        {
            AutomationLog.info("Could not find Title of Listing Type Searched");
            throw(e);
        }
        return element;
    }

    public String getTitleOfListingTypeSearched() throws Exception
    {
        return title_ListingTypeSearched().getText();
    }

    public boolean isUpdateListingLinkPresent() throws Exception
    {
        if(link_UpdateListing().isDisplayed()==true)
            return true;
        else
            return false;
    }

    public WebElement listingDetailsPageContainer() throws Exception
    {
        try
        {
            element = driver.findElement(By.className("listing-details-page"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Container for listing details page not found");
        }
        return element;
    }

    public WebElement link_PropertyDetails() throws Exception
    {
        try
        {
            element = listingDetailsPageContainer().findElement(By.linkText("Property Details"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Property Details link is NOT found in the title section");
        }
        return element;
    }

    public PropertyDetailPage clickPropertyDetailLink() throws Exception
    {
        PropertyDetailPage propertyDetail= null;
        try
        {
            link_PropertyDetails().click();
            propertyDetail = new PropertyDetailPage();
        }
        catch (Exception e)
        {
            AutomationLog.error("Unable to locate or click Property Details link");
        }
        return propertyDetail;
    }

    public WebElement element_listingTitle() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[2]/div[1]/div[2]/h2"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Title element of the listing is NOT found");
        }
        return element;
    }

    public String txt_listingTitle() throws Exception
    {
        String listingTitle = null; 
        try
        {
            listingTitle = element_listingTitle().getText();
        }
        catch(Exception e)
        {
            AutomationLog.error("Title element of the listing is NOT found");
            throw (e);
        }
        return listingTitle;
    }

    public List<WebElement> list_Showings() throws Exception
    {
        List<WebElement> list = new ArrayList<WebElement>();
        try
        {
            element = driver.findElement(By.id("showing")).findElement(By.className("ul-reset"));
            list = element.findElements(By.tagName("li"));
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not find list of showings");
            throw(e);
        }
        return list;
    }

    public WebElement getFirstShowingFromShowingsList() throws Exception
    {
        try
        {
            element = list_Showings().get(0);
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not get first showing from showings list");
            throw(e);
        }
        return element;
    }
}
