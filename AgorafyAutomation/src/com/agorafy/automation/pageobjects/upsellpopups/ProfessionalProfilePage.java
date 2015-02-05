package com.agorafy.automation.pageobjects.upsellpopups;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.agorafy.automation.automationframework.AutomationLog;
import com.agorafy.automation.pageobjects.Page;

public class ProfessionalProfilePage extends Page
{
        WebElement element = null;

        public ProfessionalProfilePage(WebDriver driver) 
        {
            super(driver);
        }
        
        public static ProfessionalProfilePage professionalProfilePage()
        {
            return PageFactory.initElements(driver, ProfessionalProfilePage.class);
        }

        public WebElement btnSendEmailInProfessionalProfilePage() throws Exception
        {
            try
            {
                element = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/a"));
                AutomationLog.info("Send Email button found on Professional Profile Page");
            }
            catch(Exception e)
            {
                AutomationLog.error("Send Email button not found on Professional Profile Page");
                throw(e);
            }
             return element;
        }

        public void clickSendEmailbtnInProfessionalProfilePage() throws Exception
        {
            try
            {
                btnSendEmailInProfessionalProfilePage().click();
                AutomationLog.info("Click action performed on Send Email button on Professional Profile Page");
            }
            catch(Exception e)
            {
                AutomationLog.error("Click action not performed on Send Email button on Professional Profile Page");
                throw(e);
             }
        }

        public WebElement userNameInPopupAfterclickSendEmailbtnInProfessionalProfilePage() throws Exception
        {
            try
            {
                element = driver.findElement(By.xpath("//*[@id='upsellPopup']/form/div[1]/input"));
                AutomationLog.info("Found Username Field on Login popup after click of send email on Prfessional Profile Page");
            }
            catch(Exception e)
            {
                AutomationLog.error("Dind't Found Username Field on Login popup after click of send email on Prfessional Profile Page");
                throw(e);
             }
             return element;
        }

        public WebElement passwordInPopupAfterclickSendEmailbtnInProfessionalProfilePage() throws Exception
        {
            try
            {
                element = driver.findElement(By.xpath("//*[@id='upsellPopup']/form/div[2]/input"));
                AutomationLog.info("Found password Field on Login popup after click of send email on Prfessional Profile Page");
            }
            catch(Exception e)
            {
                AutomationLog.error("Dind't Found password Field on Login popup after click of send email on Prfessional Profile Page");
                throw(e);
             }
             return element;
        }

        public WebElement btnLoginToMyAccountInPopup() throws Exception
        {
            try
            {
                element = driver.findElement(By.xpath("//*[@id='upsellPopup']/form/div[3]/input"));
                AutomationLog.info("LoginToMyAccount button found on Login popup in Professional Profile Page");
            }
            catch(Exception e)
            {
                AutomationLog.error("LoginToMyAccount button did not found on Login popup in Professional Profile Page");
                throw(e);
             }
             return element;
        }

        public ProfessionalProfilePage populateLoginPopUpDataForProfessionalPage(String Email, String Password ) throws Exception
        {
        	ProfessionalProfilePage professionalProfilePage = new ProfessionalProfilePage(driver);
            try
            {
                Page.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                userNameInPopupAfterclickSendEmailbtnInProfessionalProfilePage().clear();
                userNameInPopupAfterclickSendEmailbtnInProfessionalProfilePage().sendKeys(Email);
                passwordInPopupAfterclickSendEmailbtnInProfessionalProfilePage().clear();
                passwordInPopupAfterclickSendEmailbtnInProfessionalProfilePage().sendKeys(Password);
                btnLoginToMyAccountInPopup().click();
                AutomationLog.info("Successfully populated data in login pop up of Professional Page");
            }
            catch(Exception e)
            {
                AutomationLog.error("Could not populate data into login pop up of Professional Page");
                throw(e);
            }
            return professionalProfilePage;
        }
}
