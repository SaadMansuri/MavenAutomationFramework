package com.agorafy.automation.pageobjects.upsellpopups;

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

        public WebElement txt_ProfileName() throws Exception 
        {
            try
            {
                element = driver.findElement(By.className("profile-content")).findElement(By.tagName("h2"));
                AutomationLog.info("Profile name found");
            }
            catch(Exception e)
            {
                AutomationLog.error("Could not find profile name ");
                throw(e);
            }
            return element;
        }

        public WebElement btn_SendEmail() throws Exception
        {
            try
            {
                element = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[2]/div/div/div/a"));
                //element = driver.findElement(By.className("upsell btn"));
                AutomationLog.info("Send Email button found on Professional Profile Page");
            }
            catch(Exception e)
            {
                AutomationLog.error("Send Email button not found on Professional Profile Page");
                throw(e);
            }
             return element;
        }

        public LoginPopUp clickSendEmailbtnOnProfessionalProfile() throws Exception
        {
            LoginPopUp loginpopup = null;
            try
            {
                btn_SendEmail().click();
                loginpopup = new LoginPopUp(driver);
                AutomationLog.info("Click action performed on Send Email button on Professional Profile Page");
            }
            catch(Exception e)
            {
                AutomationLog.error("Click action not performed on Send Email button on Professional Profile Page");
                throw(e);
             }
            return loginpopup;
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
}
