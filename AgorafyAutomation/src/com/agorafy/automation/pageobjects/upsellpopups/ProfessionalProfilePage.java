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

        public WebElement ProfileContent() throws Exception
        {
            try
            {
                element = driver.findElement(By.className("profile-content"));
            }
            catch(Exception e)
            {
                AutomationLog.error("Could not find profile contents");
                throw(e);
            }
            return element;
        }

        public WebElement txt_ProfileName() throws Exception 
        {
            try
            {
                element = ProfileContent().findElement(By.tagName("h2"));
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
                element = ProfileContent().findElement(By.className("actions")).findElement(By.tagName("a"));
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

        public String getApplicationUrl() throws Exception 
        {
            return applicationUrl();
        }
}
