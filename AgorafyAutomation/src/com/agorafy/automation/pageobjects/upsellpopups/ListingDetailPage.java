package com.agorafy.automation.pageobjects.upsellpopups;

//import java.awt.List;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.automationframework.WaitFor;

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
    public WebElement SubscribeToListingLinkInListingDetailPage() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='subscriptionSectionLink']/div/a"));
            AutomationLog.info("Subscribe to listing link found on Listing Detail Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Subscribe to listing link not found on Listing Detail Page");
            throw(e);
        }
         return element;
    }

    public WebElement SubscribeToListingLinkInLoggedInMode() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath(".//*[@id='subscriptionSectionLink']/div[2]/a"));
            AutomationLog.info("Subscribe to listing link in Logged in mode, found on Listing Detail Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Subscribe to listing link in Logged in mode, not found on Listing Detail Page");
            throw(e);
        }
         return element;
    }

    public void clickSubscribeToListingLinkInLoggedInMode()  
    {
        try 
        {
            SubscribeToListingLinkInLoggedInMode().click();
            AutomationLog.info("Subscribe to listing link in logged in mode, on listing details page is clicked sucessfully");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Failed to click, Subscribe to listing link in logged in mode, on listing details page");
        }
    }

    public LoginPopUp clickSubscribeToListingLinkInListingDetailPage(boolean loginStatus) throws Exception
    {
        LoginPopUp subscribeToListingPopUp= null;
        try
        {
            if(loginStatus)
            {
                SubscribeToListingLinkInLoggedInMode().click();
            }
            else
            {
                SubscribeToListingLinkInListingDetailPage().click();
                WaitFor.ElementToBeDisplayed(driver, getLoginPopUpLocator());
                subscribeToListingPopUp = new LoginPopUp(driver);
            }
            AutomationLog.info("Click action performed on SubscribeToListingLink on Listing Detail Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("Click action not performed on SubscribeToListingLink on Listing Detail Page");
            throw(e);
         }
         return subscribeToListingPopUp;
    }

    public WebElement UnSubscribeToListingLinkInListingDetailPage() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//*[@id='subscriptionSectionLink']/div[1]/a"));
            AutomationLog.info("UnSubscribe to listing link found on Listing Detail Page");
        }
        catch(Exception e)
        {
            AutomationLog.error("UnSubscribe to listing link not found on Listing Detail Page");
            throw(e);
        }
         return element;
    }

    public void clickUnsubscribeListingLink()  
    {
        try 
        {
            UnSubscribeToListingLinkInListingDetailPage().click();
            AutomationLog.info("Unsubscribe listing link in listing details page is sucessfully clicked");
        } 
        catch (Exception e) 
        {
            AutomationLog.error("Failed to click, Unsubscribe listing link in listing details page");
        }
    }

    public String getUnSubscribeToListingLinkTextInListingDetailPage() throws Exception
    {
        String unSubscribeToListing="";
        try
        {
            unSubscribeToListing = driver.findElement(By.xpath("//*[@id='subscriptionSectionLink']/div[1]/a")).getText();
            AutomationLog.info("UnSubscribeToListingLink Text found after click on SubscribeToListingLink on ListingPage");
        }
        catch(Exception e)
        {
            AutomationLog.error("UnSubscribeToListingLink Text Not found after click on SubscribeToListingLink on ListingPage");
            throw(e);
         }
         return unSubscribeToListing;
    }
    public WebElement userNameInPopupSubscribeToListingLinkInListingDetailPage() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//*[@id='upsellPopup']/form/div[1]/input"));
            AutomationLog.info("Found Username Field on Login popup after click on SubscribeToListingLinkInListingDetailPage");
        }
        catch(Exception e)
        {
            AutomationLog.error("Dind't Found Username Field on Login popup after click on SubscribeToListingLinkInListingDetailPage");
            throw(e);
         }
         return element;
    }

    public WebElement passwordInPopupSubscribeToListingLinkInListingDetailPage() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//*[@id='upsellPopup']/form/div[2]/input"));
            AutomationLog.info("Found Password Field on Login popup after click on SubscribeToListingLinkInListingDetailPage");
        }
        catch(Exception e)
        {
            AutomationLog.error("Dind't Found Username Field on Login popup after click on SubscribeToListingLinkInListingDetailPage");
            throw(e);
         }
         return element;
    }

    public WebElement btnLoginToMyAccountInPopupInSubscribeToListing() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("//*[@id='upsellPopup']/form/div[3]/input"));
            AutomationLog.info("LoginToMyAccount button found on Login popup in SubscribeToListingLinkInListingDetailPage");
        }
        catch(Exception e)
        {
            AutomationLog.error("LoginToMyAccount button did not found on Login popup in SubscribeToListingLinkInListingDetailPage");
            throw(e);
         }
         return element;
    }

    /*public ListingDetailPage populateLoginPopUpDataForListingDetailPage(String Email, String Password ) throws Exception
    {
    	ListingDetailPage listingDetailPage = new ListingDetailPage(driver);
        try
        {
            Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            userNameInPopupSubscribeToListingLinkInListingDetailPage().clear();
            userNameInPopupSubscribeToListingLinkInListingDetailPage().sendKeys(Email);
            passwordInPopupSubscribeToListingLinkInListingDetailPage().clear();
            passwordInPopupSubscribeToListingLinkInListingDetailPage().sendKeys(Password);
            btnLoginToMyAccountInPopupInSubscribeToListing().click();
            AutomationLog.info("Successfully populated data in login pop up of SubscribeToListingLinkInListingDetailPage");
        }
        catch(Exception e)
        {
            AutomationLog.error("Could not populate data into login pop up of SubscribeToListingLinkInListingDetailPage");
            throw(e);
        }
        return listingDetailPage;
    }*/

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

    public LoginPopUp clickSendEmailLink() throws Exception
    {
        LoginPopUp loginpopup = null;
        try
        {
            link_sendEmailContactSection().get(0).click();
            WaitFor.ElementToBeDisplayed(driver, getLoginPopUpLocator());
            loginpopup = new LoginPopUp(driver);
            AutomationLog.info("Send Email link is clicked");
        }
        catch (Exception e)
        {
            AutomationLog.error("Could not click Send email link");
        }
        return loginpopup;
    }

    public WebElement link_UpdateListing() throws Exception
    {
        try 
        {
            element = driver.findElement(By.id("listingUpdateLink"));
            //AutomationLog.info("Listing update link is visible");
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

    public LoginPopUp clickLinkAddToReport() throws Exception
    {
        LoginPopUp loginPopUp = null;
        try
        {
            link_addToReport().click();
            WaitFor.ElementToBeDisplayed(driver, getLoginPopUpLocator());
            loginPopUp = new LoginPopUp(driver);
            AutomationLog.info("Add to Report link clicked");
        }
        catch(Exception e)
        {
            AutomationLog.error("Unable to click Add to Report");
        }
        return loginPopUp;
    }

    public WebElement title_ListingTypeSearched() throws Exception
    {
        try
        {
            element = driver.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div[1]/div[3]/h2"));
        }
        catch (Exception e)
        {
            AutomationLog.info("Could not found Title of Listing Type Searched");
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

    public void logout() throws Exception
    {
        header().link_ProfileNameOnDashboardAfterLogin().click();
        header().link_Logout().click();
        WaitFor.waitForPageToLoad(driver);
    }
}
